package com.thread.basicSynchronizationForCounter;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadForSynchronization extends Thread{
	static int counter=0;
	static int counterWithSnchronizationMethod=0;
	static AtomicInteger atomicCounter = new AtomicInteger(0);
	int nonStaticCounter=0;
	
	@Override
	public void run() {
		for(int i=0;i<10000;i++) {
			incrementTheValues();
		}
	}
	
	public synchronized void incrementTheCounter() {
		counterWithSnchronizationMethod++;
	}
	
	private void incrementTheValues() {
		counter ++;
		atomicCounter.incrementAndGet();
		incrementTheCounter();	
	}
	
	private void incrementingNonStaticVariable() {
		for(int i =0;i<1000;i++) {
			nonStaticCounter++;
		}
	}
	
	public void incrementTheNonStaticCounter() {
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				incrementingNonStaticVariable();
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				try {					
					thread1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				incrementingNonStaticVariable();
			}
		});
		
		Thread thread3 = new Thread(new Runnable() {
			public void run() {
				try {
					thread2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				incrementingNonStaticVariable();
			}
		});
		
		Thread thread4 = new Thread(new Runnable() {
			public void run() {
				try {
					thread3.join();
				} catch(InterruptedException e) {
					
				}
				incrementingNonStaticVariable();
			}
		});
		
		thread1.start(); thread2.start(); thread3.start(); thread4.start();
	}
	
	public int getNonStaticCounter() {
		return nonStaticCounter;
	}
}
