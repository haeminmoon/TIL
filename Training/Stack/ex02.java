package prac;

import java.util.Arrays;

class ArrayStack {
   
   private int top;
   private int maxSize;
   private int[] stackArray;
   
   public ArrayStack(int maxSize){
       this.maxSize = maxSize;
       this.stackArray = new int[maxSize];
       this.top = -1;
   }
   
   public boolean empty(){
       return (top == -1);
   }
   
   public boolean full(){
       return (top == maxSize-1);
   }
   
   public void push(int item){
       
       stackArray[++top] = item;
   }
   
   public int peek(){
       
       return stackArray[top];
   }
   
   public int pop(){
   	int item = peek();
       top--;
       return item;
   }
}

public class ex02 {
	public static void main(String[] args) {
		ArrayStack arrStack = new ArrayStack(10);
		
		arrStack.push(1);
		arrStack.push(2);
		System.out.println(arrStack.pop());
		arrStack.push(3);
		System.out.println(arrStack.pop());
		System.out.println(arrStack.pop());
		//System.out.println(arrStack);
	}
}
