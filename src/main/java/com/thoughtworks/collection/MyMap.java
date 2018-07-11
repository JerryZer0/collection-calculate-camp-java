package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
//        throw new NotImplementedException();
        return array.stream().map(n->n*3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
//        throw new NotImplementedException();
        return array.stream().map(n->letterList.get(n-1)).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
//        throw new NotImplementedException();
        return array.stream().map(n->{
            StringBuffer sb = new StringBuffer();
            while (n>0){
                sb.append(letterList.get((n-1)%26));
                n=(n-1)/26;
            }
            return sb.reverse().toString();
        }).collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        throw new NotImplementedException();
    }

    public List<Integer> sortFromSmall() {
        throw new NotImplementedException();
    }
}
