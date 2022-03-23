package com.clyao.basis;

import com.clyao.basis.test.Color;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KingBasisServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test1(){
        System.out.println(Color.BLUE);
    }

}
