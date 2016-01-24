package anagrams;
import java.io.*;
public class Anagrams{
	public static void main(String []args){
		//pull file from args
		File dict = null;
		if(args.length > 0){
			dict = new File(args[0]);
		}
		//set up hash table
		HashTable hashTable = new HashTable();

		//start reading file
		try(BufferedReader br = new BufferedReader(new FileReader(dict))){
			String textLine = br.readLine();
			while(textLine != null){
				//hash words as they are read
				hashTable.addToTable(hashTable.hashFunction(textLine));
				textLine = br.readLine();
			}
			br.close();
			//done reading

			//start writing
			//cycle through all lists in hash table
			//at each list, cycle through all classes
			//toString all classes in list
			PrintWriter pw = new PrintWriter(new FileWriter("anagram.txt"));
			int a=0;
			LinkedList[] ht = hashTable.getHashTable();
			for(int i=0; i<10000;i++){
				if(ht[i] != null){
					LinkedList LList = ht[i];
					LLNode curr = LList.getFirst();
					while(curr.getNext() != null){
						String s = curr.getAnagram().ClassToString();
						a++;
						if(s != ""){
							pw.println(s);
						}
						curr = curr.getNext();
					}
				}
			}
			pw.close();
			System.out.println(a);
		}
		catch(Exception e){
			e.printStackTrace();
		}//hash words as they are read
		
	}
}
//CommandLine commands for running dict1 and dict2:
//java -cp . anagrams.Anagrams dict1
//java -Xmx1024m -cp . anagrams.Anagrams dict2
