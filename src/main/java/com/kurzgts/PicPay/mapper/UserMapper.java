package com.kurzgts.PicPay.mapper;

import com.kurzgts.PicPay.dto.CreateUserDTO;
import com.kurzgts.PicPay.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "balance", constant = "0.0")
    User toEntity(CreateUserDTO dto);
}
