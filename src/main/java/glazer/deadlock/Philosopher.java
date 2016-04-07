package glazer.deadlock;

import java.util.concurrent.TimeUnit;

public class Philosopher extends Thread {

	private Fork f1;
	private Fork f2;
	private String name;

	public Philosopher(String name, Fork f1, Fork f2) {
		this.name = name;
		this.f1 = f1;
		this.f2 = f2;

	}

	public void run() {
		while (true) {
			think();
			eat();
		}
	}

	public void eat() {
		// System.out.println(this + " trying to pick up " + f1);

		// f1.tryLock();
		// synchronize(f1);
		// System.out.println(this + " picked up " + f1);
		// System.out.println(this + " trying to pick up " + f2);
		// f2.tryLock();
		// System.out.println(this + " eating...");
		// if (f1.isLocked()) {
		// f1.unlock();
		// System.out.println(this + " put down " + f1);
		// }
		// if (f2.isLocked()) {
		// f2.unlock();
		// System.out.println(this + " put down " + f2);
		// }

		// synchronized (f1) {
		// System.out.println(this + " picked up " + f1);
		// waitForAFewSeconds(10);
		try {
			f1.tryLock(10, TimeUnit.SECONDS);
			System.out.println(this + " picked up " + f1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// try {
		// wait();
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		System.out.println(this + " trying to pick up " + f2);
		try {
			f2.tryLock(10, TimeUnit.SECONDS);
			System.out.println(this + " picked up " + f2);
			System.out.println(this + " eating...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (f1.isLocked()) {
			f1.unlock();
			System.out.println(this + " put down " + f1);
		}
		if (f2.isLocked()) {
			f2.unlock();
			System.out.println(this + " put down " + f2);
		}
		// synchronized (f2) {
		// System.out.println(this + " eating...");
		// waitForAFewSeconds(10);
		// }
		// System.out.println(this + " put down " + f1);
		// }
		//
		// System.out.println(this + " put down " + f2);
		//
	}

	public void think() {
		waitForAFewSeconds(5);
	}

	private void waitForAFewSeconds(int seconds) {
		try {
			Thread.sleep((long) (seconds * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Philosopher [name=" + name + "]";
	}

	// if not last fork, grab it
	// if person requesting has another fork, grab it, else wait
}
