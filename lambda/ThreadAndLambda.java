package lambda;

public class ThreadAndLambda {

	public static void main(String[] args) {
		Thread t1 = new Thread( new Runnable()
				{
					@Override
					public void run() {
						System.out.println("Thread Started by annonymous class");
					}
				} );
		Thread t2 = new Thread( () -> 
		{
			System.out.println("Thread Started by lambda epression");
		});
		t1.start();
		t2.start();
		
	}

}
