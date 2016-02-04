package onight.mgame.chats.cass;

import java.net.URL;
import java.util.Enumeration;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Invalidate;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.annotations.Validate;
import org.osgi.framework.BundleContext;

import com.datastax.driver.core.ConsistencyLevel;

import lombok.extern.slf4j.Slf4j;
import onight.tfw.cass.core.CassandraClusterFactory;
import onight.tfw.cass.core.KeyspaceManager;
import onight.tfw.ojpa.api.DomainDaoSupport;
import onight.tfw.ojpa.api.OJpaDAO;
import onight.tfw.ojpa.api.ServiceSpec;
import onight.tfw.ojpa.api.StoreServiceProvider;
import onight.tfw.outils.conf.PropHelper;

@Component(immediate = true)
@Instantiate(name = "cass")
@Provides(specifications = StoreServiceProvider.class)
@Slf4j
public class JPACassImpl implements StoreServiceProvider  {

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
				props.get("ofw.cass.keyspace", "mgame"),//
				props.get("ofw.cass.strategy", "SimpleStrategy"),//
				props.get("ofw.cass.replica", "1"),//
				ConsistencyLevel.QUORUM);
		
		km.setBasePackage("onight.mgame.chats.cass.entity");
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

	@Override
	public String[] getContextConfigs() {
		return null;
	}

}
