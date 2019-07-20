package main;
import java.util.*;

public class CipherMain {
	public static Scanner scanner = new Scanner(System.in); //get user input
	public static String mess = new String(); //user message
	//List that contains for each position a letter of the user message.
	public static List<Character> arr = new ArrayList<Character>(); 
	//List that contains for each position a letter of the Alphabet.
	public static List<Character> abc = new ArrayList<Character>(); 

	public static void main(String[] args) {		
		System.out.println("Welcome to the Caesar Cipher.\nInsert a message:");
		mess = scanner.nextLine(); //taking the user message.
		
		int cipherShift = 0;
		System.out.println("Insert a number (Integer) of cipher that you want to shift:");
		cipherShift = scanner.nextInt(); //taking the preferred shifting value for the Caesar Cipher.
		
		convertToList();
		createABC();
		cryptoLetter(cipherShift);
		checkResult();
	}
	
	public static void checkResult() {
		for (int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
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
	//In our case this given value it's the cipherShift variable that user inserted previously.
	//If the function will find that we're in the last indexes of the Alphabet List, it will go back to the start.
	//For instance, if the user choose 3 as cipherShift, 'X' will be 'A', 'Y' will be 'B' and 'Z' will be 'C'. 
	public static void cryptoLetter(int cipherShift) {
		for (int i=0; i<arr.size(); i++) {
			for (int j=0; j<abc.size(); j++) {
				if (arr.get(i) == abc.get(j)) {

					if (abc.indexOf(abc.get(j)) > 22) {
						switch(abc.indexOf(abc.get(j))) {
						case 23:
							arr.set(i, abc.get(0 + (cipherShift - 3)));
							break;
						case 24:
							arr.set(i, abc.get(0 + (cipherShift - 2)));
							break;
						case 25:
							arr.set(i, abc.get(0 + (cipherShift - 1)));
							break;
						default:
							System.out.println("Exception");
							break;
						}
					} else {
						arr.set(i, abc.get(j + cipherShift));
						break;
					}
				}
			}
		}
	}
}
