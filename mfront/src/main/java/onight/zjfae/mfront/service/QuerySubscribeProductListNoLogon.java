package onight.zjfae.mfront.service;

import com.google.protobuf.Message;

import onight.zjfae.afront.gens.PBIFEPrdsubscribequeryQuerySubscribeProductListNoLogon.PBIFE_prdsubscribequery_querySubscribeProductListNoLogon;
import onight.zjfae.afront.gens.PBIFEPrdsubscribequeryQuerySubscribeProductListNoLogon.PBIFE_prdsubscribequery_querySubscribeProductListNoLogon.Builder;
import onight.zjfae.afront.gens.PBIFEPrdsubscribequeryQuerySubscribeProductListNoLogon.PBIFE_prdsubscribequery_querySubscribeProductListNoLogon.ProductFinanceDetailList;
import onight.zjfae.mfront.service.IFEBeanMapping.PostProc;

public class QuerySubscribeProductListNoLogon implements PostProc {

	@Override
	public void postDO(Message message, String pbname) {
		
		Builder product =PBIFE_prdsubscribequery_querySubscribeProductListNoLogon.newBuilder();

		ProductFinanceDetailList productFinanceDetailList =product.getProductFinanceDetailList(0);
		product=(Builder) message.toBuilder();
	
		

	}

}
