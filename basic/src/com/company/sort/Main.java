package com.company.sort;

public class Main {

	public static void main(final String[] args) {
		// write your code here
		final int[] arr = {101, 12, 7, 89, 21, 90, 82, 11, 2, 3};
		//ArrayTools.bubbleSort(arr);
		ArrayTools.selectSort2(arr);
		//System.out.println(ArrayTools.halfSearch(arr, 91));
		ArrayTools.printArray(arr);
		final Object obj = new Object();
	}
}
