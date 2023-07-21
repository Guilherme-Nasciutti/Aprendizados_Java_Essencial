package generics_set_map.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1,3,4,5);
        List<Double> doubleList = Arrays.asList(3.5 , 4.16, 6.87);
        List<Object> objList  = new ArrayList<Object>();

        copy(intList, objList);
        printList(objList);
        copy (doubleList, objList);
        printList(objList);
    }

    public static void copy(List<? extends Number> source, List<? super Number> destiny){
        for (Number number : source){
            destiny.add(number);
        }
    }

    public static void printList(List<?> list){
        for (Object obj : list){
            System.out.print(obj + " ");
        }
        System.out.println();
    }
}
