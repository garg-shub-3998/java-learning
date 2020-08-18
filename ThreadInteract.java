class Q{
		int num;
		boolean flag = false;
		public synchronized void put() {
			while(flag) {
				try {wait();}catch(Exception e) {}
			}
			num++;
			System.out.println("Put : " + num);
			flag = true;
			notify();
		}
		public synchronized void get() {
			while(!flag) {
				try {wait();}catch(Exception e) {}
			}
			System.out.println("Get : " + num);
			flag = false;
			notify();
		}
	}
	
	class producer implements Runnable{
		Q q;
		producer(Q q){
			this.q = q;
			Thread t = new Thread(this,"Producer");
			t.start();
		}
		public void run() {
			while(true) {
				q.put();
				try { Thread.sleep(500); }catch(Exception e) {}
			}
		}
	}
	
	class consumer implements Runnable{
		Q q;
		consumer(Q q){
			this.q = q;
			Thread t = new Thread(this,"consumer");
			t.start();
		}
		public void run() {
			while(true) {
				q.get();
				try { Thread.sleep(5000); }catch(Exception e) {}
			}
		}
	}

public class ThreadInteract {
	
	public static void main(String[] args) {
	   Q q = new Q();
	   producer p = new producer(q);
	   consumer c = new consumer(q);
	   System.gc();
	}

}
