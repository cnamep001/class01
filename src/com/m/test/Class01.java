package com.m.test;

import java.util.Arrays;

/**
 * 设计模式 算法
 * 
 * @author GUSHI
 *
 */
public class Class01 {
	public static void main(String[] args) {
		test8();
	}
	
	public static void test8() {
		int[] arr = { 5, 93, 8, 92, 7, 91, 6, 90, 1 };
		// 跨度k=2,i=k

		int k = 2;
		for (int i = k; i < arr.length; i++) {
			int temp = arr[i];
			int j = i - k;

			for (; j >= 0 && arr[j] > temp; j -= k) {
				arr[j + k] = arr[j];
			}

			arr[j + k] = temp;
		}

		k = 1;
		for (int i = k; i < arr.length; i++) {
			int temp = arr[i];
			int j = i - k;

			for (; j >= 0 && arr[j] > temp; j -= k) {
				arr[j + k] = arr[j];
			}

			arr[j + k] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}
	
    public static void test2() {
//      int[] arr = new int[]{1, 3, 5, 7, -1};
      int[] arr = {13, 11, 15, -11, 99, -10, 0, 22};

      for (int i = 0; i < arr.length - 1; i++) {
          for (int end = i + 1; (end - 1) >= 0 && arr[end - 1] > arr[end]; end--) {
              int temp = arr[end - 1];
              arr[end - 1] = arr[end];
              arr[end] = temp;
          }
      }

      System.out.println(Arrays.toString(arr));
  }
}