package com.m.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Class02 {

	private Integer num = 0;

	private Integer maxSize = 10;

	private Lock lock = new ReentrantLock();

	private Condition condition = lock.newCondition();

	public Class02() {

	}

	public Class02(Integer maxSize) {

		this.maxSize = maxSize;
	}

	// 消费
	public void test01() {
		try {
			this.lock.lock();
			while (num == 0) {
				this.condition.await();
				this.num--;
				this.condition.signalAll();
			}
		} catch (Exception e) {

		} finally {
			// 释放锁
			this.lock.unlock();
		}
	}

	// 生产
	public void test02() {
		try {
			this.lock.lock();
			while (num == this.maxSize) {
				this.condition.await();
				this.num++;
				this.condition.signalAll();
			}
		} catch (Exception e) {

		} finally {
			// 释放锁
			this.lock.unlock();
		}
	}

}
