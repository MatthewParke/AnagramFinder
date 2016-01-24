package anagrams;

public class AnagramClass {
	private int hashIndex;
	private int uniqueID;
	private String word;
	private LinkedList anagrams;

	public AnagramClass(int index, int id, String word){
		this.hashIndex = index;
		this.uniqueID = id;
		this.word = word;
		LLNode newNode = new LLNode(null, word);
		this.anagrams = new LinkedList(newNode);
	}
	//Accessors
	public int getHashIndex(){
		return hashIndex;
	}
	public int getUniqueID(){
		return uniqueID;
	}
	public LinkedList getAnagrams(){
		return anagrams;
	}
	public String getWord(){
		return word;
	}
	public void addAnagram(String word){
		LLNode newNode = new LLNode(null,word);
		this.anagrams.addToList(newNode);
	}
	public String ClassToString(){
		String returnString ="";
		LLNode curr = new LLNode(null,null);
		//if(anagrams.getLength() > 5){			//if you want classes with 5 or more members
			curr = anagrams.getFirst();
			while(curr.getNext() != null){
				returnString += (curr.getWord() + " ");
				curr = curr.getNext();
			}
		//}
		return returnString;
	}
}