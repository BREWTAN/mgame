package onight.zjfae.mfront.preproc;

import lombok.AllArgsConstructor;
import lombok.Data;
import onight.zjfae.ordbgens.app.entity.APPIfacePreproc;

@AllArgsConstructor
@Data
public class PreProcResult {

	
	boolean drop = false;

	APPIfacePreproc preproc;
	
}
