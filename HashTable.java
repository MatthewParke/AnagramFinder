package anagrams;

public class HashTable {
	
	//first 26 prime numbers -- used in hash function
	private int[] PRIMES = {2, 3, 5, 7 , 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
	private static LinkedList[] hashTable;
	private int anagramCount =0;

	public HashTable(){
		hashTable = new LinkedList[10000];
	}
	public LinkedList[] getHashTable(){
		return hashTable;
	}
	//hash function
	//uniqueID represents a anagram class
	//hashIndex represent a location to hash the class to
	//uniqueID and hashIndex are calculated differently
	//mods are by 10000 because that is the size of the hash table
	public AnagramClass hashFunction(String word){
		char[] letterArray = word.toCharArray();
		int uniqueID=0;
		int hashIndex=1;
		for(int i=0; i<letterArray.length; i++){
			hashIndex *= PRIMES[(letterArray[i] - 97)];
			if(hashIndex > 10000){
				hashIndex %= 10000;
			}
			uniqueID += (letterArray[i] + PRIMES[(letterArray[i] - 97)]);
		}
		hashIndex %= 10000;
		AnagramClass newClass = new AnagramClass(hashIndex, uniqueID, word);
		newClass.addAnagram(word);
		return newClass;
	}

	//insert into hash table using anagram class
	public void addToTable(AnagramClass anagram){
		//get list at hash index
		LinkedList classList = hashTable[anagram.getHashIndex()];
		LLNode curr = null;
		//empty hash index -- create new list and node to put there
		if(classList == null){
			LLNode newAnagramNode = new LLNode(anagram, null);
			LinkedList newAnagramList = new LinkedList(newAnagramNode);
			hashTable[anagram.getHashIndex()] = newAnagramList;
			
		}
		else{//hash index has linkedList
			//search for correct class in linkedlist, may not exist
			curr = classList.getFirst();
			while(curr != null){
				if(anagram.getUniqueID() == curr.getAnagram().getUniqueID()){
					//found correct class -- curr = class we want to add to
					break;
				}
				//at last index and its not the class we want -- create new class for list
				else if(curr.getNext() == null){
					anagramCount++;
					LLNode newAnagramNode = new LLNode(anagram, null);
					classList.addToList(newAnagramNode);
					return;
				}
				//not found and not at end of list-- goto next class
				curr = curr.getNext();
			}
			//curr is equal to the anagram passed to the method -- take word from parameter anagram
			//and add it to the anagram class already in hashtable
			curr.getAnagram().addAnagram(anagram.getWord());

			//bring most recently accessed class to the front. This makes for the 
			//largest/most accessed classes to be at the front.
			classList.moveToFront(curr);
		}
	}
	public int getCount(){
		return anagramCount;
	}
}