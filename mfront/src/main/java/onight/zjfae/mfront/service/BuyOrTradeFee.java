package onight.zjfae.mfront.service;

import java.util.regex.Pattern;

import com.google.protobuf.Message;

import cn.msec.bval.validator.RegexFM;
import onight.zjfae.afront.gens.PBIFETradeQueryTransferSellProfits.REQ_PBIFE_trade_queryTransferSellProfits.Builder;
import onight.zjfae.afront.gens.PBIFETradeQueryTransferSellProfits.Ret_PBIFE_trade_queryTransferSellProfits;
import onight.zjfae.mfront.service.IFEBeanMapping.PreProc;

public class BuyOrTradeFee implements PreProc {

	@Override
	public void prepDO(Message message, String pbname) {
		
		Builder buyOrTrade=(Builder)message.toBuilder();
		String actualRate=buyOrTrade.getActualRate();
		Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");   
		if(actualRate==null || !pattern.matcher(actualRate.toString().trim()).matches()){
				
				String returnInfo="您的转让利率["+actualRate.toString()+"]不合规,请您重新输入!";
			
		}
		try{
			double f = Double.parseDouble(actualRate.toString().trim());
		}catch(Exception e){
			
		}
		
		
	}

}
