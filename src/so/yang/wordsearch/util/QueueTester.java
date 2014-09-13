package so.yang.wordsearch.util;

public class QueueTester {

	public static void main(String[] args)
	{
		MyQueue queue = new MyQueue(3);
		
		int randomInt = (int) (Math.random() * 10);
		queue.enqueue(randomInt+"");
		randomInt = (int) (Math.random() * 10);
		queue.enqueue(randomInt+"");


		System.out.println(queue.toString());

	}
}
