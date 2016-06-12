package onight.zjfae.mfront.preproc;

import lombok.AllArgsConstructor;
import lombok.Data;
import onight.zjfae.ordbgens.app.entity.APPIfacePreproc;

@AllArgsConstructor
@Data
/**
 * @author tfw
 * @date  2016年6月12日
 * @desc  前置预处理处理结果
 */
public class PreProcResult {

	
	boolean drop = false;

	APPIfacePreproc preproc;
	
}
