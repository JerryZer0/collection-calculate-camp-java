package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
//        throw new NotImplementedException();
        int small = left<right?left:right;
        int big = small==left?right:left;
        List<Integer> list = IntStream.range(small,big+1).boxed().collect(Collectors.toList());
        return small==left?list:list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
//        throw new NotImplementedException();
        int small = left<right?left:right;
        int big = small==left?right:left;
        List<Integer> list = IntStream.range(small,big+1).boxed().filter(n->n%2==0).collect(Collectors.toList());
        return small==left?list:list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
//        throw new NotImplementedException();
        return Arrays.stream(array).boxed().filter(n->n%2==0).collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
//        throw new NotImplementedException();
        return array[array.length-1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
//        throw new NotImplementedException();
        List<Integer> first = Arrays.stream(firstArray).boxed().collect(Collectors.toList());
        List<Integer> second = Arrays.stream(secondArray).boxed().collect(Collectors.toList());
        return first.stream().filter(n->second.contains(n)).collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
//        throw new NotImplementedException();
        List<Integer> first = Arrays.stream(firstArray).collect(Collectors.toList());
        List<Integer> second = Arrays.stream(secondArray).collect(Collectors.toList());
        first.addAll(second.stream().filter(n->!first.contains(n)).collect(Collectors.toList()));
        return first;
    }
}
