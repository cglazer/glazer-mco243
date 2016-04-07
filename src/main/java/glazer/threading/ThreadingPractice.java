package glazer.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadingPractice {
	private int total;

	public ThreadingPractice() throws InterruptedException {
		total = 0;
		ExecutorService service = Executors.newFixedThreadPool(6);

		for (int i = 0; i < 10000; i++) {
			Runnable runnable = new Runnable() {
				public void run() {
					total++;
				}
			};
			service.execute(runnable);
		}

		service.shutdown();
		service.awaitTermination(10, TimeUnit.SECONDS);
		System.out.println(total);
	}

	public void add() {
		//instead of downloading file
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//using synchronize like this only pauses the threads to make sure all totals happen
		synchronized(this){
			total++;
		}
		total++;
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ThreadingPractice threading = new ThreadingPractice();

	}
}
