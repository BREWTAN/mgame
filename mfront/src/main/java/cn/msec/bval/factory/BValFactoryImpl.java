package cn.msec.bval.factory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;

import cn.msec.bval.exception.ErrorMessage;
import cn.msec.bval.exception.ITRD_Message;
import cn.msec.bval.exception.ITradeMsgException;
import cn.msec.bval.validator.IVal;
import cn.msec.bval.validator.MapKV;
import cn.msec.bval.validator.MapKV.MapKVA;

@Slf4j
public class BValFactoryImpl {
	@AllArgsConstructor
	class BeanVal {
		Method method;
		ITRD_Message errorMsg;
		IVal val;
	}

	List<BeanVal> tradeValidators = new ArrayList<BeanVal>();

	@SuppressWarnings("rawtypes")
	public IVal genValidator(Annotation anno) {
		Method clazzmethod;
		try {
			clazzmethod = anno.getClass().getDeclaredMethod("valClass");
			if (clazzmethod != null) {
				Class valClazz = (Class) clazzmethod.invoke(anno);
				return (IVal) valClazz.newInstance();
			}
		} catch (Exception e) {
		}
		return null;
	}

	@AllArgsConstructor
	class BeanPropSetter {
		Method method;
		MapKV propertySetter;
	}

	public ITRD_Message validate(Object bean) {
		if (bean == null)
			throw new ITradeMsgException(ITRD_Message.ITM_ERR_BODY_ERROR);
		String v = null;
		for (BeanVal bv : tradeValidators) {
			try {
				// log.debug("checking:"+bv.val+",method="+bv.method);
				v = (String) bv.method.invoke(bean);
				if (!bv.val.isValid(v))
					throw new ITradeMsgException(bv.errorMsg);
			} catch (Exception e) {
				log.error("validate error:" + bv.errorMsg + "@" + bv.method + ",v=" + v, e);
				throw new ITradeMsgException(bv.errorMsg);
				// return bv.errorMsg;
			}
		}
		return ITRD_Message.ITM_OK;
	}

	List<BeanPropSetter> bvSetter = new ArrayList<BeanPropSetter>();

	public void setProps(Map<String, String> map, Object bean) {
		String v = null;
		for (BeanPropSetter bv : bvSetter) {
			try {
				v = bv.propertySetter.getProp(map);
				bv.method.invoke(bean, v);
			} catch (Exception e) {
				log.warn("属性设置失败", e);
				// return bv.errorMsg;
			}
		}
	}

	public class FieldSets {
		Field field;
		ErrorMessage anno;
		Method getMethod;
		Method setMethod;

		public FieldSets(Field field, ErrorMessage anno, Method getMethod, Method setMethod) {
			super();
			this.field = field;
			this.anno = anno;
			this.getMethod = getMethod;
			this.setMethod = setMethod;
		}
	};

	void fetchFieldsReclusive(Class clazz) {
		for (Field field : clazz.getDeclaredFields()) {
			ErrorMessage erranno = field.getAnnotation(ErrorMessage.class);
			ITRD_Message tradeMsg = ITRD_Message.ITM_ERR_0299_MSG_UNKNOW;
			if (erranno != null) {
				tradeMsg = erranno.value();
			}
			MapKVA mapkv = field.getAnnotation(MapKVA.class);
			Method setMethod = null;

			try {
				setMethod = clazz.getDeclaredMethod("set" + StringUtils.capitalize(field.getName()), field.getType());
			} catch (Exception e1) {
			}

			if (mapkv != null && setMethod != null) {
				MapKV propertySetter = new MapKV();
				propertySetter.init(mapkv);
				bvSetter.add(new BeanPropSetter(setMethod, propertySetter));
			}
			boolean override = true;
			Method getMethod = null;

			try {
				getMethod = clazz.getDeclaredMethod("get" + StringUtils.capitalize(field.getName()));
			} catch (Exception e) {
				// e.printStackTrace();
				try {
					getMethod = clazz.getDeclaredMethod("is" + StringUtils.capitalize(field.getName()));
				} catch (Exception e1) {
					// e.printStackTrace();
					log.debug("绑定消息处理协议时失败:" + field.getName() + "@" + clazz.getName(), e);
					continue;
				}
			}

			for (BeanVal val : tradeValidators) {
				if (val.method.getName().equals(getMethod.getName())) {
					override = false;
					break;
				}
			}
			if (override&&getMethod!=null) {
				for (Annotation anno : field.getAnnotations()) {
					if (erranno == anno)
						continue;
					try {
						IVal validator = genValidator(anno);
						if (validator != null) {
							validator.init(anno);
							tradeValidators.add(new BeanVal(getMethod, tradeMsg, validator));
						}

					} catch (Exception e) {
						// e.printStackTrace();
						log.debug("绑定消息处理协议时失败:" + field.getName() + "@" + clazz.getName(), e);
					}
				}
			}
		}
		if (!clazz.getSuperclass().equals(Object.class)) {
			fetchFieldsReclusive(clazz.getSuperclass());
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void registryBean(Class clazz, boolean overrided) {
		if (tradeValidators == null || overrided) {
			tradeValidators = new ArrayList<BValFactoryImpl.BeanVal>();
		}
		fetchFieldsReclusive(clazz);
		log.debug("::bval:@" + ",size=" + tradeValidators.size() + "[" + tradeValidators + "]");
	}

	public static void main(String[] args) {
		// new BValFactoryImpl().searchBean(ITRD_100ReqBean.class);
	}
}
