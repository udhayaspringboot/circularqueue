package com.queue.circularqueue;

import java.util.Scanner;

public class CircularQueueImpl {
	
	int SIZE = 5; 
	  int front=-1, rear=-1;
	  int items[] = new int[SIZE];


	 
	  boolean isFull() {
	    if (front == 0 && rear == SIZE - 1) {
	      return true;
	    }
	    if (front == rear + 1) {
	      return true;
	    }
	    return false;
	  }

	  
	  boolean isEmpty() {
	    if (front == -1)
	      return true;
	    else
	      return false;
	  }

	 
	  void enQueue(int element) {
	    if (isFull()) {
	      System.out.println("Queue is full");
	    } else {
	      if (front == -1)
	        front = 0;
	      rear = (rear + 1) % SIZE;
	      items[rear] = element;
	      System.out.println("Inserted " + element);
	    }
	  }

	  
	  int deQueue() {
	    int element;
	    if (isEmpty()) {
	      System.out.println("Queue is empty");
	      return (-1);
	    } else {
	      element = items[front];
	      if (front == rear) {
	        front = -1;
	        rear = -1;
	      } /* Q has only one element, so we reset the queue after deleting it. */
	      else {
	        front = (front + 1) % SIZE;
	      }
	      return (element);
	    }
	  }
	  private void queueFront() {
			
		  if(isEmpty())
		  {
			  System.out.println("Queue is empty");
		  }
		  else
		  {
			  System.out.println("first element is "+items[front]);
		  }
		}

	  void display() {
	    
	    int i;
	    if (isEmpty()) {
	      System.out.println("Empty Queue");
	    } else {
	      System.out.println("Front -> " + front);
	      System.out.println("Items -> ");
	      for (i = front; i != rear; i = (i + 1) % SIZE)
	        System.out.print(items[i] + " ");
	      System.out.println(items[i]);
	      System.out.println("Rear -> " + rear);
	    }
	  }
	  public static void main(String[] args)
	  {
		  CircularQueueImpl cirQ = new CircularQueueImpl();
		  
		  int choice=0;  
			 char ch = ' ';
			    Scanner sc = new Scanner(System.in);  
			    
			    System.out.println("*********Queue operations using Circular Linked List*********\n");  
			    System.out.println("\n------------------------------------------------\n");  
			    do
			    {  
			        System.out.println("\nChose one from the below options...\n");  
			        System.out.println("\n1.EnQueue\n2.DeQueue\n3.Show\n4.QueueFront");  
			        System.out.println("\n Enter your choice \n");        
			        choice = sc.nextInt();  
			        switch(choice)  
			        {  
			            case 1:  
			            {   System.out.println("Enter the element to Enqueue");
			                 
			            
			            cirQ.enQueue(sc.nextInt()); 
			                break;  
			            }  
			            case 2:  
			            {  
			            	cirQ.deQueue();  
			                break;  
			            }  
			            case 3:  
			            {  
			            	cirQ.display();
			                break;  
			            }  
			            case 4:  
			            {  
			            	cirQ.queueFront();
			                break;  
			            }  
			            default:  
			            {  
			                System.out.println("Please Enter valid choice ");  
			            }  
			        }
			            System.out.println("\nDo you want to continue ? (Y/N)");
						Scanner acb = new Scanner(System.in);
						ch = acb.next().charAt(0);
					
			    }while (ch == 'y' || ch == 'Y');
			        

	  }


	
}
