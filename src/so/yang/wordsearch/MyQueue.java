package so.yang.wordsearch;

import java.util.Arrays;

/**
 * Using array to simulate a queue
 * Original found in book "Data Structures & Algorithms in JAVA" 5th 
 * @author yang
 * 
 */
public class MyQueue {
	
	private String[] queueArray;
	private int queueLength;
	private int f, r;
	private int n;
	

	public MyQueue(int length){
		f = 0;
		r = 0;
		this.queueLength = length;
		this.n = queueLength + 1;
		queueArray = new String[n];		
	}
	
	/**
	 * Return number of string in the queue
	 * @return Number of string in the queue
	 */
	public int size()
	{
		return (n - f + r) % n;
	}
	
	/**
	 * Check is there any string in the queue
	 * @return true if the queue is empty
	 */
	public boolean isEmpty()
	{
		return f==r;
	}
	
	/**
	 * return the string at the front of the queue
	 * @return the string at the front of the queue
	 * @throws EmptyQueueException if the queue is empty
	 */
	public String front() throws EmptyQueueException
	{
		if(isEmpty())
		{
			throw new EmptyQueueException("The queue is empty");
		}
		return queueArray[f];
	}
	
	/**
	 * Insert a new string at the rear of the queue
	 * @param str new string to be inserted
	 * @throws EmptyQueueException if the queue is empty
	 */
	public void enqueue(String str)
	{
		if(size()== n -1)
		{
			try {
				this.dequeue();
			} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.queueArray[r] = str;
		r = (r+1) % n;
		
	}
	
	/**
	 * Remove the string in the front of the queue
	 * @return the string in the front of the queue
	 * @throws EmptyQueueException if the queue is empty
	 */
	public String dequeue() throws EmptyQueueException
	{
		if(this.isEmpty())
		{
			throw new EmptyQueueException("The queue is empty");
		}
		String temp = this.queueArray[f];
		this.queueArray[f] = null;
		f = (f + 1) % n;
		return temp;
	}
	
	@Override
	public String toString() {
		String str ="";
		String temp = "";
		for(int i = 0; i<3; i++)
		{
			try {
				temp = this.dequeue();
			} catch (EmptyQueueException e1) {
				temp = "null";
			}
			str+=temp;
			if(i!=2)
			{
				str+=" \n";
			}
		}
		return str;
		
	}
	
}
