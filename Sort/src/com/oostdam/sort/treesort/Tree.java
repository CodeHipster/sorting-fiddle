package com.oostdam.sort.treesort;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Thijs on 3/14/2016.
 */
public class Tree<T> {
    private class Node<T> {
        Node(T value) {
            this.value = value;
        }

        Node left;
        Node right;
        T value;
    }

    public Tree(List<T> data, Comparator<T> comparator)
    {
        root = null;
        this.data = data;
        this.comparator = comparator;

        buildTree(data);
    }

    private Node root;
    private List<T> data;
    private Comparator<T> comparator;

    //Put the tree into original data in sorted order.
    public void sortData() {
        data.clear(); //set size to 0, but keep capacity.
        traverseTreeInOrder(this.root);
    }

    private void buildTree(List<T> data){
        Iterator<T> iter = data.iterator();

        //Create the tree;
        T value = iter.next();
        root = new Node(value);
        while (iter.hasNext()) {
            value = iter.next();
            addRecursive(this.root, value);
        }
    }

    //Recursively add values to the tree.
    private void addRecursive(Node<T> node, T value) {
        //compare == 1 if arg1 is greater then arg2
        if (comparator.compare(node.value, value) == 1) {
            if (node.left != null) {
                addRecursive(node.left, value);
            } else {
                node.left = new Node<>(value);
            }
        } else {
            if (node.right != null) {
                addRecursive(node.right, value);
            } else {
                node.right = new Node<>(value);
            }
        }
    }

    //Insert node value into data if it has no children.
    //Data has to be cleared before calling this method.
    private void traverseTreeInOrder(Node<T> node) {
        if (node.left != null) {
            traverseTreeInOrder(node.left);
        }

        this.data.add(node.value);

        if (node.right != null) {
            traverseTreeInOrder(node.right);
        }
    }
}
