package edu.uprm.cse.ds.array;

public class Example2 {

	public static void main(String[] args) {
		char charArray[] = {'C', 'a', 'l', 'l', 'e'};
		Character charArray2[] = {new Character('C'), 
				new Character('a'), new Character('l'), 
				new Character('l'), new Character('e')};
		
		for (int i=0; i < charArray.length; ++i) {
			System.out.println(charArray[i]);
		}
		System.out.println("\n");
		for (int i=0; i < charArray2.length; ++i) {
			System.out.println(charArray2[i]);
		}

	}

}
