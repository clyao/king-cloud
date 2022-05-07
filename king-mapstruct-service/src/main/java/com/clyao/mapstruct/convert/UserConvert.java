package com.clyao.mapstruct.convert;

import com.clyao.mapstruct.model.dto.UserDTO;
import com.clyao.mapstruct.model.po.UserPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    /*@Mappings({
            @Mapping(target = "userName", source = "name")
    })*/
    UserDTO userPO2UserDTO(UserPO userPO);

}
