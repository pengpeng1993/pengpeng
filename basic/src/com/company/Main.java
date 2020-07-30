package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [] arr = {101,12,7,89,21,90,82,11,2,3};
       //selectSort(arr);
        ArrayTools.bubbleSort(arr);
        System.out.println(ArrayTools.halfSearch(arr,91));
        ArrayTools.printArray(arr);
        Object obj = new Object();
    }
}
