package com.m.thread_1A2B3C;

import java.util.concurrent.locks.LockSupport;

public class Class02 {
	// 1A-2B-3C-4D
	static Thread t12 = null, t22 = null;

	public static void main(String[] args) {

		char[] c1 = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		int[] c2 = new int[26];
		for (int i = 0; i < 26; i++) {
			c2[i] = i + 1;
		}

		t12 = new Thread(() -> {

			for (char i : c1) {
				System.out.print(i);
				LockSupport.unpark(t22);
				LockSupport.park();
			}

		}, "t1");

		t22 = new Thread(() -> {

			for (int i : c2) {
				LockSupport.park();
				if (i == c2[c2.length - 1]) {
					System.out.print(i);
				} else {
					System.out.print(i + "-");
				}
				LockSupport.unpark(t12);
			}

		}, "t2");

		if (c1.length == c2.length) {
			t12.start();
			t22.start();
		} else {
			System.out.println("c1.length 不等于 c2.length");
		}
	}
}
