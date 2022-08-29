package com.bais.ppqs.model.enums.constraints;

import com.bais.ppqs.model.enums.telco.TState;
import com.bais.ppqs.model.enums.telco.state.TelcoStateSubsetValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = TelcoStateSubsetValidator.class)
public @interface TelcoStateSubset {
    /**
     * @return subset of NState enum
     */
    TState[] anyOf();

    /**
     * @return the error message template
     */
    String message() default "must be any of {anyOf}";

    /**
     * @return the groups the constraint belongs to
     */
    Class<?>[] groups() default {};

    /**
     * @return the payload associated to the constraint
     */
    Class<? extends Payload>[] payload() default {};
}