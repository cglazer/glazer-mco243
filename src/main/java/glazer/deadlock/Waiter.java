package glazer.deadlock;
/**
 * Philosopher must ask a waiter before picking up a fork
 * @author Chaya Glazer
 *
 */
public class Waiter {
	public Waiter() {

	}

	public synchronized boolean tryToEat(Fork f1, Fork f2) {
		if (!f1.isInUse() || !f2.isInUse()) {
			f1.setInUse(true);
			f2.setInUse(true);
			return true;
		}
		return false;
	}
}
