package com.clyao.basis.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class TestList {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("java");
        list.add("king");
        System.out.println(list);

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }

}
