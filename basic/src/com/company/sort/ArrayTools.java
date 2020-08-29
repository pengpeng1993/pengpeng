package com.company.sort;

public class ArrayTools {

	/**
	 * @description:选择排序从前到后每次确定一个元素的位置
	 * @author pengpeng
	 * @date 2020/8/29
	 * @param arr
	 * @return void
	*/
	public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					final int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	/**
	 * @description:选择排序从前到后每次确定一个元素的位置,每循环一次才进行交换
	 * @author pengpeng
	 * @date 2020/8/29
	 * @param arr
	 * @return void
	*/
	public static void selectSort2(int[] arr) {
		for(int i = 0; i <arr.length - 1; i++) {
			int index = i;
			int temp = arr[i];
			for(int j = i + 1; j < arr.length ; j++) {
				if(temp > arr[j]) {
					temp = arr[j];
					index = j;
				}
			}
			if(index != i) {
				int tempValue = arr[i];
				arr[i] = temp;
				arr[index] = tempValue;
			}
		}
	}

	/**
	 * @description:打印数组
	 * @author pengpeng
	 * @date 2020/8/29
	 * @param arr
	 * @return void
	*/
	public static void printArray(final int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	/**
	 * @description:冒泡排序
	 * @author pengpeng
	 * @date 2020/8/29
	 * @param arr
	 * @return void
	*/
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					final int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
	/**
	 * @description: 二分查找
	 * @author pengpeng
	 * @date 2020/8/29
	 * @param arr
	 * @param key
	 * @return int
	*/
	public static int halfSearch(int[] arr, final int key) {
		int min = 0;
		int max = arr.length - 1;
		int mid = (min + max) / 2;
		while (arr[mid] != key) {
			if (arr[mid] > key) {
				max = mid - 1;
			} else if (arr[mid] < key) {
				min = mid + 1;
			}
			mid = (max + min) / 2;
			if (max < min) {
				return -1;
			}
		}
		return mid;
	}
}
