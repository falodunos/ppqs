package com.bais.ppqs.model.enums.telco.state;

import com.bais.ppqs.model.enums.telco.TState;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class StateConverter implements AttributeConverter<TState, String> {
    @Override
    public String convertToDatabaseColumn(TState status) {
        if (status == null) {
            return null;
        }
        return status.getCode();
    }

    @Override
    public TState convertToEntityAttribute(final String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(TState.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}