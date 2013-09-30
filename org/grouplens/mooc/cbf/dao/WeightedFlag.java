package org.grouplens.mooc.cbf.dao;

import org.grouplens.lenskit.core.Parameter;

import javax.inject.Qualifier;
import java.lang.annotation.*;

/**
 * Parameter annotation for user profile elaboration method selection.
 * @author Gael Abadin
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Qualifier
@Parameter(Weighted.class)
public @interface WeightedFlag {
}
