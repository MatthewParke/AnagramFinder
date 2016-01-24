package anagrams;

public class LinkedList {

	//Linked List Properties
	private int length;
	private LLNode first, last;

	public LinkedList(LLNode node){
		this.first = node;
		this.last = node;
		length = 1;
	}

	//Accessors
	public LLNode getFirst(){
		return first;
	}
	public LLNode getLast(){
		return last;
	}
	public int getLength(){
		return length;
	}

	//Adds to front of list
	public void addToList(LLNode newNode){
		newNode.setNext(first);
		newNode.setPrevious(null);
		first.setPrevious(newNode);
		first = newNode;
		length++;
	}
	//moves node to front of list
	public void moveToFront(LLNode node){
		if(node.getPrevious() == null && node.getNext() == null){
			//only node in list
		}
		else if(node.getPrevious() == null){
			//in front of list
		}
		else if(node.getNext() == null){
			//tail of list
			node.getPrevious().setNext(null);
			first.setPrevious(node);
			node.setNext(first);
			node.setPrevious(null);
			first = node;
		}
		else{//somewhere in the middle
			node.getPrevious().setNext(node.getNext());
			node.getNext().setPrevious(node.getPrevious());
			first.setPrevious(node);
			node.setNext(first);
			node.setPrevious(null);
			first = node;
		}
	}

}