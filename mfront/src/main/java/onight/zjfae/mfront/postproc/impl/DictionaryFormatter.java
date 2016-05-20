package onight.zjfae.mfront.postproc.impl;

import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;
import onight.zjfae.mfront.cache.KDictionary;
import onight.zjfae.mfront.postproc.AbstractPostFieldTracker;
import onight.zjfae.mfront.postproc.annotation.Formatter;
import onight.zjfae.mfront.utils.PBMessageFlatten.ModifyValue;
import onight.zjfae.ordbgens.app.entity.APPDictionary;
import onight.zjfae.ordbgens.app.entity.APPIfacePostproc;

import org.apache.commons.lang3.StringUtils;

@Slf4j
@Formatter("dict")
public class DictionaryFormatter extends AbstractPostFieldTracker {

	public DictionaryFormatter(APPIfacePostproc procs) {
		super(procs);
	}

	@Override
	public ModifyValue modTraceValue(Object v) {
		String patterns[] = StringUtils.stripAll(procs.getProcParams().trim().split(","));
		
//		HashMap<String, HashMap<String, APPDictionary>> dictmap;
		HashMap<String, APPDictionary> map;
		if (StringUtils.equalsIgnoreCase("caseignore", patterns[0].trim())) {
			map = KDictionary.caseIgnoreDictsByKeyNO.get(procs.getKeyNo().toLowerCase());
		} else {
			map = KDictionary.dictsByKeyNO.get(procs.getKeyNo());
		}
//		HashMap<String, APPDictionary> map = dictmap.get(procs.getKeyNo());
		if (map != null) {
			APPDictionary dict = map.get((String) v);
			if (dict != null) {
				return new ModifyValue(dict.getDataValue());
			}else
			if(patterns.length>=2&&StringUtils.isNoneBlank(patterns[1]))
			{//走默认值
				if("{}".equals(patterns[1])){
					return null;
				}
				return new ModifyValue(patterns[1]);
			}
		}
		return null;
//		
//		return new ModifyValue("");
	}
}
