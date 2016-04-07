package glazer.deadlock;

import java.util.concurrent.locks.ReentrantLock;

public class Fork extends ReentrantLock{
	private int number;

	public Fork(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Fork [number=" + number + "]";
	}
}
