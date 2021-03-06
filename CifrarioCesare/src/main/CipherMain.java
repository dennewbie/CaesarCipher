package main;
import java.util.*;
//Caesar Cipher by @dennewbie

public class CipherMain {
	public static Scanner scanner = new Scanner(System.in); //get user input
	public static String mess = new String(); //user message
	//List that contains for each position a letter of the user message.
	public static List<Character> arr = new ArrayList<Character>(); 
	//List that contains for each position a letter of the Alphabet.
	public static List<Character> abc = new ArrayList<Character>(); 

	public static void main(String[] args) {	
		int cipherShift = 0;
		System.out.println("\t\t***Welcome to the Caesar Cipher***");
		
		System.out.println("\nInsert a message that you want to enrypt/decrypt:");
		mess = scanner.nextLine(); //taking the user message.
		
		System.out.println("\nInsert a number (Integer) that represent the number of letter\nthat you want to shift forward/back (shift back with negative number):");
		cipherShift = scanner.nextInt(); //taking the preferred shifting value for the Caesar Cipher.
				
		convertToList();
		createABC();
		cryptoLetter(cipherShift);
		checkResult();
	}
	
	public static void checkResult() {
		System.out.println();
		for (int i=0; i<arr.size(); i++) {
				System.out.print(arr.get(i));
		}
	}
	
	//Fill the arr List with the word's letters (one for each position inside the List.
	public static void convertToList() {
		mess = mess.toUpperCase();
		for (int i=0; i<mess.length(); i++) {
			arr.add(mess.charAt(i));
		}
	}
	
	//Function that fills the Alphabet List.
	public static void createABC() {
		String abcString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i=0; i<abcString.length(); i++) {
			abc.add(abcString.charAt(i));
		}	
	}
	
	//Function that encrypts the user message by replacing the given index value with another given value.
	//In our case this given value it's the cipherShiftUser variable that user inserted previously.
	//If the function will find that we're in the last indexes of the Alphabet List, it will go back to the start.
	//For instance, if the user choose 3 as cipherShift, 'X' will be 'A', 'Y' will be 'B' and 'Z' will be 'C'. 

	
	public static void cryptoLetter(int cipherShiftUser) {
		for (int i=0; i<arr.size(); i++) {
			if ((abc.indexOf(arr.get(i)) + cipherShiftUser) < 0) {
					int newCipher = abc.indexOf(arr.get(i)) + cipherShiftUser;
					while (newCipher < 0) {
						if ((newCipher + 26) > 0) {
							if (!Character.isLetter(arr.get(i))) {
								break;
							} else {
								arr.set(i, abc.get(newCipher + 26));
							}
							break;
						} 
						newCipher += 26;
					}
			} else if (abc.indexOf(arr.get(i)) + cipherShiftUser > 25) {
				int newCipher = cipherShiftUser + abc.indexOf(arr.get(i));
				while (newCipher > 25) {
					if ((newCipher - 26) < 25) {
						arr.set(i, abc.get(newCipher - 26));
						break;
					}
					newCipher -= 26;
				}
			} else {
				for (int j=0; j<abc.size(); j++) {
					if ((abc.get(j)) == arr.get(i)) {
						arr.set(i, (abc.get(j + cipherShiftUser)));
						break;
					}
				}
				
			}
		}
	}
}