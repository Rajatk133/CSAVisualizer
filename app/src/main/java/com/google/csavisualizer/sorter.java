package com.google.csavisualizer;

import java.util.Comparator;

public class sorter implements Comparator<helper> {
    @Override
    public int compare(helper t2, helper t1) {
       return t2.getVal()-t1.getVal();
    }
}
