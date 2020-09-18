package com.m.thread_1A2B3C;

public class Class01 {
	// 1A-2B-3C-4D
	static Thread t12 = null, t22 = null;

	private static Object obj = new Object();

	public static void main(String[] args) {
		final Object o1 = new Object();

		Thread t1 = null, t2 = null;

		char[] c1 = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		int[] c2 = new int[26];
		for (int i = 0; i < 26; i++) {
			c2[i] = i + 1;
		}

		t1 = new Thread(() -> {
			synchronized (obj) {
				for (int i = 0; i < c1.length; i++) {
					System.out.print(c1[i]);
					try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					try {
						obj.notify();
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					obj.notify();
				}
			}
		}, "t1");

		t2 = new Thread(() -> {
			synchronized (obj) {
				for (int i = 0; i < c2.length; i++) {
					if (i == c2.length - 1) {
						System.out.print(c2[i]);
					} else {
						System.out.print(c2[i] + "-");
					}
					try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					try {
						obj.notify();
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					obj.notify();
				}
			}
		}, "t2");

		if (c1.length == c2.length) {
			t1.start();
			t2.start();
		} else {
			System.out.println("c1.length 不等于 c2.length");
		}
	}
}
