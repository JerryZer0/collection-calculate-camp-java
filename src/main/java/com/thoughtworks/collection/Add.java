package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {

    //add
    private List<Integer> getEventList(List<Integer> arrayList){
        return arrayList.stream().filter(n->n%2==0).collect(Collectors.toList());
    }

    public int getSumOfEvens(int leftBorder, int rightBorder) {
//        throw new NotImplementedException();
        int left = leftBorder<rightBorder?leftBorder:rightBorder;
        int right = left==leftBorder?rightBorder:leftBorder;
        List<Integer> list = IntStream.range(left,right+1).boxed().collect(Collectors.toList());
        return list.stream().filter(n-> n%2 == 0).reduce(0,Integer::sum );
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
//        throw new NotImplementedException();
        int left = leftBorder<rightBorder?leftBorder:rightBorder;
        int right = left==leftBorder?rightBorder:leftBorder;
        List<Integer> list = IntStream.range(left,right+1).boxed().collect(Collectors.toList());
        return list.stream().filter(n->n%2==1).reduce(0,Integer::sum);
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
//        throw new NotImplementedException();
        return arrayList.stream().map(n->n*3+2).reduce(0,Integer::sum);

    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
//        throw new NotImplementedException();
        return arrayList.stream().map(n->n%2==0?n:(n*3+2)).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
//        throw new NotImplementedException();
        return arrayList.stream().map(n->n%2==1?(n*3+5):0).reduce(0,Integer::sum);
    }

    public double getMedianOfEven(List<Integer> arrayList) {
//        throw new NotImplementedException();
        List<Integer> list = arrayList.stream().filter(n->n%2==0).collect(Collectors.toList());
        return  (list.get((list.size()-1)/2)+list.get(list.size()/2))/2;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
//        throw new NotImplementedException();
        return arrayList.stream().filter(n->n%2==0).collect(Collectors.averagingInt(n->n));
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
//        throw new NotImplementedException();
        return arrayList.stream().filter(n->n%2==0).anyMatch(n->n==specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
//        throw new NotImplementedException();
        return arrayList.stream().filter(n->n%2==0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
//        throw new NotImplementedException();
        List<Integer> event = arrayList.stream().filter(n->n%2==0).sorted().collect(Collectors.toList());
        List<Integer> odd = arrayList.stream().filter(n->n%2!=0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        odd.forEach(n->event.add(n));
        return event;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        //throw new NotImplementedException();
//        List<Integer> list = arrayList.stream().skip(1).collect(Collectors.toList());
//        for(int i = 0; i < list.size();i++ )
//            list.set(i,3*(list.get(i)+arrayList.get(i)));
//        return list;
        List<Integer> list = new ArrayList<>();
        arrayList.stream().reduce((num1,num2)->{
            list.add((num1+num2)*3);
            return num2;
        });
        return list;
    }
}
