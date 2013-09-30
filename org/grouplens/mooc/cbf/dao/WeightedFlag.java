package org.grouplens.mooc.cbf.dao;

import org.grouplens.lenskit.core.Parameter;

import javax.inject.Qualifier;
import java.lang.annotation.*;

/**
 * Parameter annotation for the move tag file.
 * @author <a href="http://www.grouplens.org">GroupLens Research</a>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Qualifier
@Parameter(Weighted.class)
public @interface WeightedFlag {
}