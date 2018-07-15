package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
//        throw new NotImplementedException();
        List<Integer> list = IntStream.range(0,number-1).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return list.stream().filter(n->n%2==list.get(1)%2).collect(Collectors.toList());
    }
}
