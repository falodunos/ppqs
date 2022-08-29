package com.bais.ppqs.model.enums.telco.runtimenv;

import com.bais.ppqs.model.enums.constraints.TelcoRuntimeEnvSubset;
import com.bais.ppqs.model.enums.telco.RuntimeEnv;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class TelcoRuntimeEnvSubsetValidator implements ConstraintValidator<TelcoRuntimeEnvSubset, RuntimeEnv> {
    private RuntimeEnv[] subset;

    @Override
    public void initialize(TelcoRuntimeEnvSubset constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(RuntimeEnv value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset)
                .contains(value);
    }
}
