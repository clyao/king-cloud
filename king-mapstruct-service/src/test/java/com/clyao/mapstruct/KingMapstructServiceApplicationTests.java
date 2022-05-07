package com.clyao.mapstruct;

import com.clyao.mapstruct.convert.UserConvert;
import com.clyao.mapstruct.model.dto.UserDTO;
import com.clyao.mapstruct.model.po.UserPO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class KingMapstructServiceApplicationTests {

    @Test
    public void test1(){
        UserPO userPO = new UserPO();
        userPO.setAge(20);
        userPO.setName("king");
        userPO.setId(1l);
        System.out.println(userPO.toString());
        UserDTO userDTO = UserConvert.INSTANCE.userPO2UserDTO(userPO);
        System.out.println(userDTO.toString());
    }

}
