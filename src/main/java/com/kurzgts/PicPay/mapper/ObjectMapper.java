package com.kurzgts.PicPay.mapper;

import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return modelMapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
        return origin.stream()
                .map(element -> modelMapper.map(element, destination))
                .collect(Collectors.toList());
    }
}