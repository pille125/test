package org.dieschnittstelle.jee.esa.basics.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This Annotation is used for class attributes at runtime.
 * If an attribute is annoted with this, you have to set the value attribute.
 * Can be used to get ta pretty name of the class field instead of the attribute name
 *
 * Created by Robin on 31.10.2016.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DisplayAs {
    String getValue();
}
