package com.oostdam.sort;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Thijs on 3/12/2016.
 * Sort using a binary tree.
 * Crashes with stack overflow exception on large sets of data.
 */
public class TreeSorter<T> {

    public TreeSorter() {
        root = null;
    }

    private class Node<T> {
        Node(T value) {
            this.value = value;
        }

        void addRecursive(Node<T> node, T value, Comparator comparator) {
            //compare == 1 if arg1 is greater then arg2
            if (comparator.compare(this.value, value) == 1) {
                if (node.left != null) {
                    addRecursive(node.left, value, comparator);
                } else {
                    node.left = new Node<>(value);
                }
            } else {
                if (node.right != null) {
                    addRecursive(node.right, value, comparator);
                } else {
                    node.right = new Node<>(value);
                }
            }
        }

        Node left;
        Node right;
        T value;
    }

    private Node root;

    //data is the original list to be sorted.
    private void toListSorted(List<T> data) {
        data.clear();
        traverseLeftToRight(root, data);
    }

    //Insert node value into data if it has no children.
    private void traverseLeftToRight(Node<T> node, List<T> data) {
        if (node.left != null) {
            traverseLeftToRight(node.left, data);
        }

        data.add(node.value);

        if (node.right != null) {
            traverseLeftToRight(node.right, data);
        }
    }

    public void sort(List<T> data, Comparator<T> comparator) {
        //List of 1 is sorted.
        if (data.size() < 2) {
            return;
        }

        Iterator<T> iter = data.iterator();

        //Create the tree;
        T value = iter.next();
        root = new Node(value);
        while (iter.hasNext()) {
            value = iter.next();
            root.addRecursive(root, value, comparator);
        }

        //Map the tree to the list in order.
        toListSorted(data);

        return;
    }
}
