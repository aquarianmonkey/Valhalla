package com.berns.collections;

import java.util.Scanner;

class LinkedList
{
	Node head;
	Node tail;
	private int size;

	/*
	 * Adds Node to end of list with given `num` as data Make sure it correctly
	 * sets the head (and tail) when adding the first item to the list
	 */
	public void add(int num)
	{
		// your code here
		if (head == null && tail == null)
		{
			head = new Node(num);
			tail = head;
		} else
		{
			tail.next = new Node(num);
			tail = tail.next;
		}
		++size;
	}

	public int size()
	{
		return size;
	}

	private Node getNode(int index)
	{
		if (head == null && tail == null)
		{
			return null;
		}
		int counter = 0;
		Node output = head;
		while (counter < index && output != null)
		{
			output = output.next;
			counter++;
		}
		return output;
	}

	public void add(int index, int num)
	{
		// if 0
		if (index == 0)
		{
			Node temp = head;
			head = new Node(num, temp);
		} 
		/*else if (index == (size - 1))
		{
			this.add(num);
		}*/ 
		else if (index > 0)
		{
			Node prev = this.getNode(index - 1);
			Node next = prev.next;
			prev.next = new Node(num, next);
		}
		++size;
	}

	public int remove(int index)
	{
		if (size == 0 || index > (size - 1) || index < 0)
			throw new IllegalArgumentException();
		int num = -1;
		if (index == 0)
		{
			num = head.data;
			head = head.next;
		} else if (index == (size - 1))
		{
			num = tail.data;
			tail = this.getNode(index - 1);
			tail.next = null;
		} else if (index > 0)
		{
			Node prev = this.getNode(index - 1);
			num = prev.next.data;
			// Node current = prev.next;
			// prev.next = current.next;
			prev.next = prev.next.next;
		}
		--size;
		return num;
	}

	/*
	 * Returns value of node at given index
	 */
	public int get(int index)
	{
		if (head == null && tail == null)
		{
			return -1;
		}
		int counter = 0;
		Node output = head;
		while (counter < index)
		{
			output = output.next;
			counter++;
		}
		return output.data;
	}

	public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for(int i=0; i<n; i++){
            int a = in.nextInt();
            int b= in.nextInt();
            if(a == -6){
                System.out.println(list.get(b)); 
            }
            else if(a == -9){
                list.add(b);
            }
            else if(a == -1){
            	
            	System.out.println(list.remove(b));
            	
            }
            else{
            	list.add(a, b);
            }
        }
        
        in.close();
    }


}

class Node
{
	int data;
	Node next;

	public Node(int d)
	{
		data = d;
	}

	public Node(int d, Node n)
	{
		data = d;
		next = n;
	}
}