// This class implements the Queue
public class Queue<V> {

    
    public Object[] queue;
    public int capacity, currentSize=0, front=0, rear=0;
	
    public Queue(int capacity) {    
       this.capacity=capacity;
       queue=new Object[capacity];
    }

    public int size() {
       return currentSize;
    }

    public boolean isEmpty() {
      return size()==0;
    }
	
    public boolean isFull() {
      return size()==capacity;
    }

    public void enqueue(Object node) {
    	if(isFull()) {
    		//System.out.println("Queue is full");
    	}
    	else {
    	queue[rear] = node;
    	rear=(rear+1)%capacity;
    	currentSize=currentSize + 1;}
    }

    public V dequeue() {
        if(isEmpty()) {
        	
        	return null;
        }
        else {
        Object noderemoved=queue[front];
        front=(front+1)%capacity;
        currentSize=currentSize - 1;
        return (V) noderemoved;}
    }

}



