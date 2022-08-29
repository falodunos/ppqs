package com.bais.ppqs.model.enums.telco.runtimenv;

import com.bais.ppqs.model.enums.telco.RuntimeEnv;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class TelcoRuntimeEnvConverter implements AttributeConverter<RuntimeEnv, String> {
    @Override
    public String convertToDatabaseColumn(RuntimeEnv status) {
        if (status == null) {
            return null;
        }
        return status.getCode();
    }

    @Override
    public RuntimeEnv convertToEntityAttribute(final String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(RuntimeEnv.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
