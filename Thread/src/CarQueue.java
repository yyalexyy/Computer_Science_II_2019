
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
/**
 * This class adds and removes an element each time from the queue.
 * @author Alex Juan
 *
 */
public class CarQueue {
	Queue<Integer> myQueue = new ArrayDeque<>();
	Random rand = new Random();

	public CarQueue() {
		for(int i = 0; i < 5; i++) {
			myQueue.add(rand.nextInt(3+1));		//Generate between 0 to 3
		}
	}
	
	
	public void addToQueue() {
		
		class MyRunnable implements Runnable{
			
			@Override
			public void run() {
				try {
					for(int i = 0; i < 10; i++)
						myQueue.add(rand.nextInt(3+1));		//Generate between 0 to 3
					
					Thread.sleep(100);
				}
				catch(InterruptedException e) {
					
				}
				finally {
					
				}
			}
			
		}
		
		Runnable r = new MyRunnable();
		Thread t = new Thread(r);
		t.start();
		
	}
	
	public Integer deleteQueue() {
		if(myQueue.size() == 0)
			return -1;
		
		return myQueue.remove();
	}

}
