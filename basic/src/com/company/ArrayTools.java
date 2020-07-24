package com.company;

public class ArrayTools {

    /**
     * 选择排序,从前到后,每次确定一个元素的位置
     */
    public static void selectSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 打印数组
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    /**
     *  冒泡排序
     * */
    public static void bubbleSort(int arr[]) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static int halfSearch(int [] arr, int key) {
        int min = 0;
        int max = arr.length -1;
        int mid = (min+max) / 2;
        while(arr[mid] != key) {
            if(arr[mid] > key) {
               max = mid - 1;
            } else if(arr[mid] < key) {
                min = mid + 1;
            }
            mid = (max + min) / 2;
            if(max < min) {
                return - 1;
            }
        }
        return mid;
    }
}
