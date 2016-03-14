package com.oostdam.sort;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Thijs on 3/11/2016.
 */
public class MergeSortTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testTest1() throws Exception {

        List<Integer> data = new ArrayList<>();
        data.add(3);
        data.add(2);
        data.add(5);
        data.add(1);
        data.add(7);

        MergeSort.sort(data, (left, right)-> left.compareTo(right));

        Assert.assertTrue(data.get(0) == 1);
        Assert.assertTrue(data.get(1) == 2);
        Assert.assertTrue(data.get(2) == 3);
        Assert.assertTrue(data.get(3) == 5);
        Assert.assertTrue(data.get(4) == 7);
    }
}