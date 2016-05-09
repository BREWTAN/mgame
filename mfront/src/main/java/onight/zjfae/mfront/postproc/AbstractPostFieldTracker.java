package onight.zjfae.mfront.postproc;

import lombok.AllArgsConstructor;
import onight.zjfae.mfront.utils.PBMessageFlatten.FieldTracker;
import onight.zjfae.ordbgens.app.entity.APPIfacePostproc;

@AllArgsConstructor
public abstract class AbstractPostFieldTracker extends FieldTracker {
	protected APPIfacePostproc procs;

}
