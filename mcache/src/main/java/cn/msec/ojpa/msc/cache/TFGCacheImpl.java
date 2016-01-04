package cn.msec.ojpa.msc.cache;

import lombok.extern.slf4j.Slf4j;
import onight.tfw.ojpa.api.DomainDaoSupport;
import onight.tfw.ojpa.api.OJpaDAO;
import onight.tfw.ojpa.api.ServiceSpec;
import onight.tfw.ojpa.api.StoreServiceProvider;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Invalidate;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.annotations.Requires;
import org.apache.felix.ipojo.annotations.Validate;
import org.osgi.framework.BundleContext;

@Component(immediate = true)
@Instantiate(name = "tfgcache")
@Provides(specifications = StoreServiceProvider.class, strategy = "SINGLETON")
@Slf4j
public class TFGCacheImpl extends StoreServiceProvider {

	@Override
	public String getProviderid() {
		return ServiceSpec.CACHE_STORE.getTarget();
	}

	BundleContext bundleContext;

	@Requires
	CacheLoader cacheLoader;

	public TFGCacheImpl(BundleContext bundleContext) {
		super();
		log.debug("create:TFGCacheImpl:");
		this.bundleContext = bundleContext;
	}

	@Validate
	public void startup() {
		log.info("启动中...@" + bundleContext);
		log.info("cache:" + cacheLoader);
		log.info("启动完成...");
	}

	@Invalidate
	public void shutdown() {
		log.info("退出中...");
		log.info("退出完成...");
	}

	@Override
	public DomainDaoSupport getDaoByBeanName(OJpaDAO dao) {
		return new CacheDao(cacheLoader);
	}

}
