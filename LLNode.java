package anagrams;

//Linked List Node Class
public class LLNode{
	private AnagramClass anagramClass;
	private String word;
	private LLNode next, prev;

	//pass null for ac if using for string, pass null for wd if using for anagram class
	public LLNode(AnagramClass ac, String wd){
		anagramClass = ac;
		word = wd;
		next = null;
		prev = null;
	}
	public AnagramClass getAnagram(){
		return this.anagramClass;
	}
	public String getWord(){
		return this.word;
	}
	public LLNode getPrevious(){
		return this.prev;
	}
	public LLNode getNext(){
		return this.next;
	}
	public void setPrevious(LLNode prev){
		this.prev = prev;
	}
	public void setNext(LLNode next){
		this.next = next;
	}
}