package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
//        throw new NotImplementedException();
        List<Integer> list = new ArrayList<>();
        for(Integer[] tempList:array){
            for (Integer integer:tempList){
                list.add(integer);
            }
        }
        return list;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        throw new NotImplementedException();
    }
}
