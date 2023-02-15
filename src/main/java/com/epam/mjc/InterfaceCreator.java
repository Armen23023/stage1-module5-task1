package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return  x -> {
            Iterator<String> iterator = x.iterator();
            if (iterator.hasNext()){
                if (iterator.next().substring(0, 1).matches("[A-Z]")){
                    return true;
                }
            }
            return false;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            Iterator<Integer> iterator = x.iterator();
            List<Integer> list = new ArrayList<>();
            while (iterator.hasNext()){
                Integer next = iterator.next();
                if (next % 2 == 0){
                    list.add(next);
                }
            }
            x.addAll(list);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return ()->{
            List<String> list = new ArrayList<>();
            Iterator<String> iterator = values.iterator();
            while (iterator.hasNext()){
                String next = iterator.next();
                String[] s = next.split(" ");
                if (next.substring(0,1).matches("[A-Z]+") && next.substring(next.length()-1).matches("\\.")
                && s.length>3){
                    list.add(next);
                }
            }
            return list;
        };



    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x-> {
          Map<String,Integer>  map = new HashMap<>();
            Iterator<String> iterator = x.iterator();
            while (iterator.hasNext()){
                String next = iterator.next();
                map.put(next,next.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1,list2)->{
            List<Integer> list = new ArrayList<>();
            list.addAll(list1);
            list.addAll(list2);
            return list;
        };
    }
}
