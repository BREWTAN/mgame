package onight.zjfae.mfront.cache;

import java.util.HashMap;

import onight.zjfae.ordbgens.app.entity.APPDictionary;

/**
 * 字典表
 * 
 * @author brew
 *
 */
public class KDictionary {

	public static HashMap<String, HashMap<String, APPDictionary>> dictsByKeyNO = new HashMap<>();
	public static HashMap<String, HashMap<String, APPDictionary>> caseIgnoreDictsByKeyNO = new HashMap<>();
	
}
