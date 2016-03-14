package com.oostdam.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Thijs on 3/12/2016.
 */
public class TreeSorterTest {

    @Test
    public void testSort() throws Exception {

        List<Integer> data = new ArrayList<>();
        data.add(3);
        data.add(2);
        data.add(5);
        data.add(1);
        data.add(7);

        TreeSorter<Integer> treeSorter = new TreeSorter<>();

        treeSorter.sort(data, (left, right)-> left.compareTo(right));

        Assert.assertTrue(data.get(0) == 1);
        Assert.assertTrue(data.get(1) == 2);
        Assert.assertTrue(data.get(2) == 3);
        Assert.assertTrue(data.get(3) == 5);
        Assert.assertTrue(data.get(4) == 7);
    }
}