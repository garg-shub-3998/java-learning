class counter {
		public int i;
		counter(){
			i = 0;
		}
		
		public synchronized void increment() {
			i++; 
		}
	}


public class ThreadSynchro {

	public static void main(String[] args) throws Exception {
		counter c = new counter();
		
		Thread t1 = new Thread( () -> 
		{
			for(int i = 0; i < 1000; i++) {
				c.increment();
			}
		} );
		
		Thread t2 = new Thread( () -> 
		{
			for(int i = 0; i < 1000; i++) {
				c.increment();
			}
		} );
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println(c.i);

	}

}
