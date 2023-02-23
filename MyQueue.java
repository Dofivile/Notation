import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T>{
	
	private T[] queue;
	private int front;
	private int back;
	private int size;
	
	
	private static final int DEFUALT_CAPACITY=10;	
	
	public MyQueue(int initial_capacity) {
		T[] temp_queue= (T[])new Object[initial_capacity];
		queue=temp_queue;
		front=-1;
		back=-1;
		int size=0;

		
	}
	
	public MyQueue() {
		this(DEFUALT_CAPACITY);
	}
	@Override
	public boolean isEmpty() {
		if(front==-1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean isFull() {
		if(front==0 && back==queue.length-1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T temp;
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}else {
			temp= queue[front];
			if(front>=back) {
				front=-1;
				back=-1;

			}else {
				front++;

			}
			size--;
		}

		return temp;



	}

	@Override
	public int size() {
		
		return this.size;
	}

	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		
		if(isFull()) {
			throw new QueueOverflowException();
		}else {
			
			if(front==-1) {
				front=0;
			}
			back++;
			queue[back]= e;
			size++;
			
		}
		return true;
	}
	@Override
	public String toString() {
		String result="";
		
		for(int i=0; i< queue.length;++i) {
			
			if(queue[i]!=null) {
				result+=queue[i];
			}
			
		}
		return result;
	}

	@Override
	public String toString(String delimiter) {
		 String result="";
	       
	       
	       for( int i=0; i< queue.length;++i) {
	    	   
	    	   if(queue[i]!=null) {
	    		   result+=queue[i];
	    		   
	    		   if(i!=back) {
	        		   result+= delimiter;
	        	   }
	    	   }
	    	  
	       }
	       
	       
	       
	       
	       return result;
		
	}

	@Override
	public void fill(ArrayList<T> list) {
		
		ArrayList<T> copyList= new ArrayList<>(list);
		for(int i =0; i<list.size();++i) {
			
			if(isFull()) {
				throw new QueueOverflowException();
			}
			if(front==-1) {
				front++;
			}

			queue[i]=copyList.get(i);
			back++;
			size++;
		}
	}

}
