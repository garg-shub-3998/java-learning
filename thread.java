
class hi extends Thread{                                           // using thread class
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("Hi");
			try{Thread.sleep(1000);}catch(Exception e) {}
		}
	}
}
class hello implements Runnable{                                  // using runnable interface
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("Hello");
			try{Thread.sleep(1000);}catch(Exception e) {}
		}
	}
}
public class thread {

	public static void main(String[] args) throws Exception {
		hi obj1 = new hi();
		hello obj2 = new hello();
		
		obj1.start();
		try{Thread.sleep(500);}catch(Exception e) {}
		Thread t2 = new Thread(obj2);
		t2.start();                           
		try{Thread.sleep(300);}catch(Exception e) {}
		 
		Thread t3 = new Thread(() ->                                     // using lambda expression
		{
			for(int i = 0; i < 3; i++) {
				System.out.println("lambda thread");
				try{Thread.sleep(2000);}catch(Exception e) {}
			}
		});
		t3.start();
		
		obj1.join();                                                  // join method waits for these threads to join main again before printing bye 
		t2.join();
		t3.join();
		System.out.println(t2.isAlive());                             // isAlive is used to check weather thread is alive or not   
		System.out.println("Bye");
	}

}
