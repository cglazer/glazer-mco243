package glazer.deadlock;

import java.util.concurrent.locks.ReentrantLock;

public class Fork extends ReentrantLock{
	private int number;
	private boolean inUse;

	public boolean isInUse() {
		return inUse;
	}

	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}

	public Fork(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Fork [number=" + number + "]";
	}
}
