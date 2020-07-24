package com.company;

import static com.company.ArrayTools.bubbleSort;
import static com.company.ArrayTools.halfSearch;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [] arr = {101,12,7,89,21,90,82,11,2,3};
       //selectSort(arr);
        bubbleSort(arr);
        System.out.println(halfSearch(arr,91));
        ArrayTools.printArray(arr);
    }
}
