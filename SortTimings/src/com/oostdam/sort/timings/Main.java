package com.oostdam.sort.timings;

import com.oostdam.sort.MergeSort;
import com.oostdam.sort.treesort.TreeSorter;

import java.util.*;

/**
 * Created by Thijs on 3/12/2016.
 */
public class Main {
    public static void main(String[] args){

        Integer nrOfItems = 100000;

        List<Integer> dataMergeSort = new ArrayList<>();
        Random random = new Random();
        for(int i = 0 ; i < nrOfItems; i++){
            dataMergeSort.add(random.nextInt(nrOfItems));
        }

        List<Integer> dataTreeSort = new ArrayList<>(dataMergeSort);

        List<Integer> dataCollectionsSort = new ArrayList<>(dataMergeSort);

        int[] dataNativeUtilArraySort = new int[nrOfItems];
        for(int i = 0; i < dataNativeUtilArraySort.length; i++){
            dataNativeUtilArraySort[i] = random.nextInt(nrOfItems);
        }

        //No lambda available in java 7 :(
        //sorter.sort((left, right) -> (left > right)?true :false);
        Comparator<Integer> comparator = (left, right) -> (left > right)?1:-1;

        Long start = System.nanoTime();
        MergeSort.sort(dataMergeSort,comparator);
        Long end = System.nanoTime();

        System.out.println("Time to sort in ms using merge sort: " + (end-start)/1000000);

        start = System.nanoTime();
        TreeSorter.sort(dataTreeSort, comparator);
        end = System.nanoTime();

        System.out.println("Time to sort in ms using tree sort: " + (end-start)/1000000);

        start = System.nanoTime();
        Collections.sort(dataCollectionsSort,comparator);
        end = System.nanoTime();

        System.out.println("Time to sort in ms using colletions.sort: " + (end-start)/1000000);

        start = System.nanoTime();
        java.util.Arrays.sort(dataNativeUtilArraySort);
        end = System.nanoTime();

        System.out.println("Time to sort in ms using java.util.arrays.sort with native int: " + (end-start)/1000000);

    }
}
