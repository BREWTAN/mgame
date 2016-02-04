package cn.msec.ojpa.msc.cass;

import java.net.URL;
import java.util.Enumeration;

import lombok.extern.slf4j.Slf4j;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Invalidate;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.annotations.Validate;
import org.osgi.framework.BundleContext;

import cn.msec.bao.outils.conf.PropHelper;
import cn.msec.ojpa.api.DomainDaoSupport;
import cn.msec.ojpa.api.OJpaDAO;
import cn.msec.ojpa.api.ServiceSpec;
import cn.msec.ojpa.api.StoreServiceProvider;
import cn.msec.ojpa.cass.core.CassandraClusterFactory;
import cn.msec.ojpa.cass.core.KeyspaceManager;

import com.datastax.driver.core.ConsistencyLevel;

@Component(immediate = true)
@Instantiate(name = "cassandara")
@Provides(specifications = StoreServiceProvider.class)
@Slf4j
public class JPACassImpl extends StoreServiceProvider {

	@Override
	public String getProviderid() {
		return ServiceSpec.CASS_STORE.getTarget();
	}

	BundleContext bundleContext;

	public JPACassImpl(BundleContext bundleContext) {
		super();
		log.debug("create:JPCassImpl:");
		this.bundleContext = bundleContext;
	}

	KeyspaceManager km;
	CassandraClusterFactory cassfactory;

	@Validate
	public void startup() {
		log.info("启动中...@" + bundleContext);
		Enumeration<URL> entries = bundleContext.getBundle().findEntries("/cn/msec/ojpa/msb/cass/entity", "*", true);

		 System.out.println("entry::"+entries);
		 while(entries!=null&&entries.hasMoreElements()){
		 URL url=entries.nextElement();
		  System.out.println("url::"+url);
		 }

		PropHelper props = new PropHelper(bundleContext);
		cassfactory = new CassandraClusterFactory();

		cassfactory.setContactPoints(props.get("ofw.cass.contactpoint", "172.30.12.44"));
		cassfactory.setPort(props.get("ofw.cass.port", 9042));
		cassfactory.initCluster(props);

		km = new KeyspaceManager(cassfactory,//
				props.get("ofw.cass.keyspace", "msbao"),//
				props.get("ofw.cass.strategy", "SimpleStrategy"),//
				props.get("ofw.cass.replica", "1"),//
				ConsistencyLevel.QUORUM);
		
		km.setBasePackage("cn.msec.ojpa.msc.cass.entity");
		km.initTables();
		
		log.info("启动完成...");
	}

	@Invalidate
	public void shutdown() {

		log.info("退出中...");
		log.info("退出完成...");
	}

	@Override
	public DomainDaoSupport getDaoByBeanName(OJpaDAO dao) {
		 return km.getDaoByTableName(dao.getDomainName());
//		return null;
	}

}
