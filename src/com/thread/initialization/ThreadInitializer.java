package com.thread.initialization;

public class ThreadInitializer {

	public static void main(String[] args) {
		System.out.println("this is the Thread Initialization class. We will initialize threads with different methods");
		
		Thread t = new ThreadByExtendigThreadClass();
		t.start();
		
		t = new Thread(new ThreadByRunnableInterface());
		t.start();

		ThreadByAnonymousClass threadByAnonymousClass = new ThreadByAnonymousClass();
	}

}
