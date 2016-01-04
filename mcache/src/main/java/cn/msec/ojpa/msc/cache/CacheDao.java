package cn.msec.ojpa.msc.cache;

import java.util.List;

import lombok.val;
import lombok.extern.slf4j.Slf4j;
import onight.tfw.ojpa.api.CacheKey;
import onight.tfw.ojpa.api.NoneDomainDao;
import onight.tfw.outils.serialize.SerializerUtil;

@Slf4j
public class CacheDao extends NoneDomainDao {

	CacheLoader cache;

	public CacheDao(CacheLoader cache) {
		super();
		this.cache = cache;
	}

	@Override
	public Object selectByPrimaryKey(Object key) {
		if (key == null)
			return null;
		val tkey = SerializerUtil.deserialize(key, CacheKey.class);
		if (tkey.getCol() != null) {
			return cache.getV(tkey.getTable(), tkey.getKey(), tkey.getCol(), tkey.getDefautlV());
		} else {
			return cache.getO(tkey.getTable(), tkey.getKey(), tkey.getDefautlV());
		}
	}

	@Override
	public List<Object> selectByExample(Object key) {
		if (key == null)
			return null;
		val tkey = SerializerUtil.deserialize(key, CacheKey.class);
		return cache.searchByCol(tkey.getTable(), tkey.getKey().split(","), tkey.getCol().split(","));
	}

}
