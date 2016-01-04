package cn.msec.ojpa.msc.cache;

import onight.tfg.ordbgens.sys.entity.TSysParam;
import onight.tfg.ordbgens.tfc.entity.TFCChannelProduct;
import onight.tfg.ordbgens.tfc.entity.TFCCoinType;
import onight.tfg.ordbgens.tfc.entity.TFCGameSupportCoin;


public class PreLoadClass {
	public static Class[]  getPreLoad(){
		return new Class[]{
				TSysParam.class,
				TFCChannelProduct.class,
				TFCCoinType.class,
				TFCGameSupportCoin.class
		};
	}
}
