package com.poc.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;

public abstract class GenericConverter<S, D> implements Converter<S, D> {

    @Override
    public D convert(MappingContext<S, D> context) {
        return new ModelMapper().map(context.getSource(), context.getDestinationType());
    }
}
