package com.thread.basicSynchronizationForCounter;

/*
 * This class demonstrate the usages for atomic and synchronization in threads
 */

public class ClassToCheckSynch {

	public static void main(String [] args) {
		Thread thread1 = new ThreadForSynchronization();
		Thread thread2 = new ThreadForSynchronization();
		Thread thread3 = new ThreadForSynchronization();
		Thread thread4 = new ThreadForSynchronization();
		
		thread1.start(); thread2.start(); thread3.start(); thread4.start();
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("the counter after execution of threads without synchronization is "+ThreadForSynchronization.counter);
		System.out.println("other counter after execution of threads with synchronization is "+ThreadForSynchronization.counterWithSnchronizationMethod);
		System.out.println("counter after execution of threads with atomic counter is "+ThreadForSynchronization.atomicCounter.get());
		
		ThreadForSynchronization threadForSynchronization = new ThreadForSynchronization();
		threadForSynchronization.incrementTheNonStaticCounter();
		
		System.out.println("counter after execution of threads with non static counter is "+threadForSynchronization.getNonStaticCounter());
	}
}
