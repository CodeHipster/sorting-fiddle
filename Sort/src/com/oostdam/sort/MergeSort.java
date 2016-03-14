package com.oostdam.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Thijs on 3/11/2016.
 */
public class MergeSort {
    //Sort the array. Array is passed as reference.
    public static <T> List<T> sort(List<T> data, Comparator<T> comparator){
        List<T> backBuffer = new ArrayList<>(data);
        return sort(data,backBuffer, comparator, 0);
    }

    //
    private static <T> List<T> sort(List<T> original, List<T>buffer, Comparator<T> comparator, Integer depth){
        int size = original.size();

        //Empty list or list containing 1 element is considered sorted.
        if(size == 1){
            if(depth % 2 == 0){
                return original;
            }else{
                buffer.set(0,original.get(0));
                return buffer;
            }
        }

        //Split and sort the list.
        List<T> leftBuffer = buffer.subList(0,size/2);
        List<T> leftSorted = sort(original.subList(0,size/2),leftBuffer, comparator, ++depth);
        List<T> rightBuffer = buffer.subList(size/2, size);
        List<T> rightSorted = sort(original.subList(size/2, size),rightBuffer, comparator, ++depth);

        //Merge lists
        //Use depth to determine where to merge into.
        //This will make sure sorted sublists are merged into the list where they are not part of.
        if(depth % 2 == 0){
            return mergeInto(leftSorted, rightSorted, original, comparator);
        }else{
            return mergeInto(leftSorted, rightSorted, buffer, comparator);
        }
    }

    //destination.size() = left.size() + right.size()
    //Returns reference to destination.
    private static <T> List<T> mergeInto(List<T> left, List<T> right, List<T> destination, Comparator<T> comparator){
        Integer leftSize = left.size();
        Integer rightSize = right.size();
        Integer leftIndex = 0;
        Integer rightIndex = 0;
        Integer destIndex = 0;

        boolean leftHasItems = true;
        boolean rightHasItems = true;
        while(leftHasItems || rightHasItems){
            //If left and right lists have items, compare and add to destination
            if(leftHasItems && rightHasItems){
                T rightItem = right.get(rightIndex);
                T leftItem = left.get(leftIndex);
                if(comparator.compare(leftItem, rightItem) == 1){
                    destination.set(destIndex, rightItem);
                    rightIndex++;
                }else{
                    destination.set(destIndex, leftItem);
                    leftIndex++;
                }
            }else if(leftHasItems){
                destination.set(destIndex, left.get(leftIndex));
                leftIndex++;
            }else{
                destination.set(destIndex, right.get(rightIndex));
                rightIndex++;
            }

            destIndex++;

            leftHasItems = (leftIndex < leftSize);
            rightHasItems = (rightIndex < rightSize);
        }

        return destination;
    }
}
