package thread.initialization;

public class ThreadByAnonymousClass {
	
	public ThreadByAnonymousClass() {
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
					System.out.println("this is the test");
			}
		});

		t.start();
	}
}
