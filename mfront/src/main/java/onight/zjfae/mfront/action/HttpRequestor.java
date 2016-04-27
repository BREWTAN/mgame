package onight.zjfae.mfront.action;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;

import lombok.extern.slf4j.Slf4j;
import onight.tfw.otransio.api.beans.FramePacket;

@Slf4j
public class HttpRequestor {

	@SuppressWarnings("deprecation")
	public void reload() {
		lock.writeLock().lock();
		try {

			RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.<ConnectionSocketFactory> create();
			ConnectionSocketFactory plainSF = new PlainConnectionSocketFactory();
			registryBuilder.register("http", plainSF);
			// 指定信任密钥存储对象和连接套接字工厂
			try {
				KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
				// 信任任何链接
				TrustStrategy anyTrustStrategy = new TrustStrategy() {
					@Override
					public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
						return true;
					}
				};
				SSLContext sslContext = SSLContexts.custom().useTLS().loadTrustMaterial(trustStore, anyTrustStrategy).build();
				LayeredConnectionSocketFactory sslSF = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
				registryBuilder.register("https", sslSF);
			} catch (KeyStoreException e) {
				throw new RuntimeException(e);
			} catch (KeyManagementException e) {
				throw new RuntimeException(e);
			} catch (NoSuchAlgorithmException e) {
				throw new RuntimeException(e);
			}
			Registry<ConnectionSocketFactory> registry = registryBuilder.build();

			cm = new PoolingHttpClientConnectionManager(registry);
			httpclient = HttpClientBuilder.create().setConnectionManager(cm).build();
		} finally {
			lock.writeLock().unlock();
		}
	}

	public void changeMaxTotal(int size) {
		lock.writeLock().lock();
		try {
			cm.setMaxTotal(size);
		} finally {
			lock.writeLock().unlock();
		}
	}

	public void changeMaxPerRoute(int size) {
		lock.writeLock().lock();
		try {
			cm.setDefaultMaxPerRoute(size);
		} finally {
			lock.writeLock().unlock();
		}
	}

	public String post(String xml, String address, int timeoutMillis) throws ClientProtocolException, IOException {
		lock.readLock().lock();
		try {
			HttpHost host = new HttpHost(address);
			StringEntity entity = new StringEntity(xml, "UTF-8");
			HttpPost httppost = new HttpPost(address);
			httppost.setEntity(entity);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			return httpclient.execute(httppost, responseHandler);
		} finally {
			lock.readLock().unlock();
		}
	}

	public String post(String xml, String address) throws ClientProtocolException, IOException {
		lock.readLock().lock();
		try {
			log.debug("httppost:" + address + ",data=" + xml);
			
			StringEntity entity = new StringEntity(xml, "UTF-8");
			HttpPost httppost = new HttpPost(address);
			httppost.setEntity(entity);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			String result = httpclient.execute(httppost, responseHandler);

			log.debug("httpresult:" + address + ",result=" + result);
			return result;
		} finally {
			lock.readLock().unlock();
		}
	}
	
	public String post(final FramePacket pack, String xml, String address) throws ClientProtocolException, IOException {
		lock.readLock().lock();
		try {
			log.debug("httppost:" + address + ",data=" + xml);
			StringEntity entity = new StringEntity(xml, "UTF-8");
			HttpPost httppost = new HttpPost(address);
			
			StringBuffer stringBuffer = new StringBuffer();
			if (pack.getExtProp(SSO_SMID) != null) {//get client smid 
				stringBuffer.append(SSO_SMID).append("=").append(pack.getExtProp(SSO_SMID)).append(";");
			}
			if (pack.getExtProp(ZJS_ID) != null) {//get client zjsid
				stringBuffer.append(ZJS_ID).append("=").append(pack.getExtProp(ZJS_ID)).append(";");
			}
			if(StringUtils.isNotBlank(stringBuffer)){// if exists , post it as Cookie to erie
				httppost.setHeader(new BasicHeader("Cookie",stringBuffer.toString()));
			}
			httppost.setEntity(entity);
			
			ResponseHandler<String> responseHandler = new BasicResponseHandler(){
				@Override
				public String handleResponse(HttpResponse response) throws HttpResponseException, IOException {
					if(response.getHeaders("Set-Cookie").length > 0){
						log.debug(response.getHeaders("Set-Cookie")[0].getValue());
					}
					pack.getExtHead().buildFor((HttpServletResponse)response);
					return super.handleResponse(response);
				}
			};
			String result = httpclient.execute(httppost, responseHandler);
			log.debug("httpresult:" + address + ",result=" + result);
			return result;
		} finally {
			lock.readLock().unlock();
		}
	}

	public void destroy() {
		lock.writeLock().lock();
		try {
			cm.shutdown();
		} finally {
			lock.writeLock().unlock();
		}
	}

	public int defaultHttpTimeoutMillis = 10000;// http超时时间
	private int httpKeepAlivesSecs = 60;
	private String SSO_SMID="SMID";
	private String ZJS_ID="ZJSID";	
	private PoolingHttpClientConnectionManager cm;
	private CloseableHttpClient httpclient;
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
}
