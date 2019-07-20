package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CipherMain {
	public static Scanner scanner = new Scanner(System.in);
	public static String mess = new String();
	public static List<Character> arr = new ArrayList<Character>();
	public static List<Character> abc = new ArrayList<Character>();

	public static void main(String[] args) {		
		System.out.println("Welcome to the Caesar Cipher.\nInsert a message:");
		mess = scanner.nextLine();
		
		int cipherShift = 0;
		System.out.println("Insert a number (Integer) of cipher that you want to shift:");
		cipherShift = scanner.nextInt();
		
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
	
	public static void convertToList() {
		mess = mess.toUpperCase();
		for (int i=0; i<mess.length(); i++) {
			arr.add(mess.charAt(i));
		}
	}
	
	public static void createABC() {
		String abcString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i=0; i<abcString.length(); i++) {
			abc.add(abcString.charAt(i));
		}	
	}
	
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
