package com.oostdam.sort.treesort;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Thijs on 3/12/2016.
 * Sort using a binary tree.
 */
public class TreeSorter {

    public static <T> void sort(List<T> data, Comparator<T> comparator) {
        //List of 1 is sorted.
        if (data.size() < 2) {
            return;
        }

        Tree<T> tree = new Tree<>(data,comparator);

        tree.sortData();

        return;
    }
}
