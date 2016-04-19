package cn.msec.bval.validator;

import java.lang.annotation.Annotation;

public interface IVal {

	public abstract boolean init(Annotation a);

	public abstract boolean isValid(String v);

}