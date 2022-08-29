package com.bais.ppqs.model.enums.telco.state;

import com.bais.ppqs.model.enums.constraints.TelcoStateSubset;
import com.bais.ppqs.model.enums.telco.TState;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class TelcoStateSubsetValidator implements ConstraintValidator<TelcoStateSubset, TState> {
    private TState[] subset;

    @Override
    public void initialize(TelcoStateSubset constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(TState value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset)
                .contains(value);
    }
}