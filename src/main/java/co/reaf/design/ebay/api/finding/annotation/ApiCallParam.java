package co.reaf.design.ebay.api.finding.annotation;

import co.reaf.design.ebay.api.finding.enums.FindingApiParam;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by iabramov on 17/09/2015.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ApiCallParam {
    FindingApiParam value();
}
