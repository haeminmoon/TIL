package prac;

class Node{
    int data;
    Node nextNode;

    Node(int data){
        this.data = data;
        this.nextNode = null;
    }
}

class LinkedQueue {
    Node front;
    Node rear;
    
    public LinkedQueue(){
        this.front = null;
        this.rear = null;
    }
    
    public boolean empty(){
        return (front==null);
    }
    
    public void enQueue(int item){
        Node node = new Node(item);
        node.nextNode = null;
        
        if(empty()){
            rear = node;
            front = node;
        }else{
            rear.nextNode = node;
            rear = node;
        }
    }
    
    public int deQueue(){
        int item = peek();
        front = front.nextNode;
        
        if(front == null){
            rear = null;
        }
        
        return item;
    }
    
    public int peek(){
        return front.data;
    }
}
public class ex03 {

	public static void main(String[] args) {
		LinkedQueue linkedQueue = new LinkedQueue();
		
		linkedQueue.enQueue(1);
		System.out.println(linkedQueue.deQueue());
		linkedQueue.enQueue(2);
		linkedQueue.enQueue(3);
		System.out.println(linkedQueue.deQueue());
		System.out.println(linkedQueue.deQueue());
	}
}
