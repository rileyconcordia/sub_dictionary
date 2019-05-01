//------------------------------------------------------------------------
//Written by: Kwok Ho, Chan 40091211 | Lang Zhu 27890575
//COMP249
//Assignment 4
//Question 1
//Due Date: April 8, 2019
//------------------------------------------------------------------------
package Part1;
import java.util.ArrayList;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author riley
 *
 */
public class SubDictionary {

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		//read file
		Scanner kb = new Scanner(System.in); //user input
		Scanner sc = null; //to read text file
		File file = null;
		PrintWriter pw = null;
		
		
		
		ArrayList<String>articles = new ArrayList<>();
		ArrayList<String>dictionary = new ArrayList<>();
		//Creation of ArrayList A-Z
		ArrayList<String> Dictionary_A = new ArrayList<>();
		Dictionary_A.add(0, "A");
		Dictionary_A.add(1, "==");
		ArrayList<String> Dictionary_B = new ArrayList<>();
		Dictionary_B.add(0, "B");
		Dictionary_B.add(1, "==");
		ArrayList<String> Dictionary_C = new ArrayList<>();
		Dictionary_C.add(0, "C");
		Dictionary_C.add(1, "==");
		ArrayList<String> Dictionary_D = new ArrayList<>();
		Dictionary_D.add(0, "D");
		Dictionary_D.add(1, "==");
		ArrayList<String> Dictionary_E = new ArrayList<>();
		Dictionary_E.add(0, "E");
		Dictionary_E.add(1, "==");
		ArrayList<String> Dictionary_F = new ArrayList<>();
		Dictionary_F.add(0, "F");
		Dictionary_F.add(1, "==");
		ArrayList<String> Dictionary_G = new ArrayList<>();
		Dictionary_G.add(0, "G");
		Dictionary_G.add(1, "==");
		ArrayList<String> Dictionary_H = new ArrayList<>();
		Dictionary_H.add(0, "H");
		Dictionary_H.add(1, "==");
		ArrayList<String> Dictionary_I = new ArrayList<>();
		Dictionary_I.add(0, "I");
		Dictionary_I.add(1, "==");
		ArrayList<String> Dictionary_J = new ArrayList<>();
		Dictionary_J.add(0, "J");
		Dictionary_J.add(1, "==");
		ArrayList<String> Dictionary_K = new ArrayList<>();
		Dictionary_K.add(0, "K");
		Dictionary_K.add(1, "==");
		ArrayList<String> Dictionary_L = new ArrayList<>();
		Dictionary_L.add(0, "L");
		Dictionary_L.add(1, "==");
		ArrayList<String> Dictionary_M = new ArrayList<>();
		Dictionary_M.add(0, "M");
		Dictionary_M.add(1, "==");
		ArrayList<String> Dictionary_N = new ArrayList<>();
		Dictionary_N.add(0, "N");
		Dictionary_N.add(1, "==");
		ArrayList<String> Dictionary_O = new ArrayList<>();
		Dictionary_O.add(0, "O");
		Dictionary_O.add(1, "==");
		ArrayList<String> Dictionary_P = new ArrayList<>();
		Dictionary_P.add(0, "P");
		Dictionary_P.add(1, "==");
		ArrayList<String> Dictionary_Q = new ArrayList<>();
		Dictionary_Q.add(0, "Q");
		Dictionary_Q.add(1, "==");
		ArrayList<String> Dictionary_R = new ArrayList<>();
		Dictionary_R.add(0, "R");
		Dictionary_R.add(1, "==");
		ArrayList<String> Dictionary_S = new ArrayList<>();
		Dictionary_S.add(0, "S");
		Dictionary_S.add(1, "==");
		ArrayList<String> Dictionary_T = new ArrayList<>();
		Dictionary_T.add(0, "T");
		Dictionary_T.add(1, "==");
		ArrayList<String> Dictionary_U = new ArrayList<>();
		Dictionary_U.add(0, "U");
		Dictionary_U.add(1, "==");
		ArrayList<String> Dictionary_V = new ArrayList<>();
		Dictionary_V.add(0, "V");
		Dictionary_V.add(1, "==");
		ArrayList<String> Dictionary_W = new ArrayList<>();
		Dictionary_W.add(0, "W");
		Dictionary_W.add(1, "==");
		ArrayList<String> Dictionary_X = new ArrayList<>();
		Dictionary_X.add(0, "X");
		Dictionary_X.add(1, "==");
		ArrayList<String> Dictionary_Y = new ArrayList<>();
		Dictionary_Y.add(0, "Y");
		Dictionary_Y.add(1, "==");
		ArrayList<String> Dictionary_Z = new ArrayList<>();
		Dictionary_Z.add(0, "Z");
		Dictionary_Z.add(1, "==");
		//End of creation of A-Z arrayList
		
		String line = ""; //for processing input files
		String userinput;
		//regex for digits
		Pattern digits = Pattern.compile("\\d");
		Pattern word = Pattern.compile("[A-Z]");
		
		//Ask for user-input for file name
		System.out.println("Please enter a file name");
		userinput = kb.nextLine();
		
		//processing the input files
		try
		{
			file = new File(userinput);
			sc = new Scanner(new FileInputStream(file));
			
			while(sc.hasNextLine()) {
				line = sc.nextLine();		
				
				String[]arrOfStr = line.split(" ");
				
				for(int i=0; i<arrOfStr.length;i++) {
					
					articles.add(arrOfStr[i]);	
				}
			}
		}
		catch(IOException e)
		{
			System.out.println("IOException is caught");
		}
		
		//remove symbol
		for(int i=0; i<articles.size(); i++) {	
			//? : , ; ! .
			if ( articles.get(i).contains("?") || articles.get(i).contains(":") || articles.get(i).contains(",") || articles.get(i).contains(";") || articles.get(i).contains("!") || articles.get(i).contains(".")) {
				articles.set(i, articles.get(i).substring(0, articles.get(i).length()-1));				
			}
			
			//' =
			if ( articles.get(i).contains("'") || articles.get(i).contains("=")) {
				articles.remove(i);
			}
		}
		
		//UPPERCASE
		for(int i=0; i<articles.size(); i++) {
			articles.set(i, articles.get(i).toUpperCase());
		}
		
		//remove elements which is not combined with only characters
		for (int i=0; i<articles.size(); i++) {
			Matcher matcher_word = word.matcher(articles.get(i));
			if (!matcher_word.find()){
				articles.remove(i);
			}
		}
		
		//remove duplicated elements
		for(int i=0; i<articles.size(); i++) {
			for (int j=i+1; j<articles.size(); j++) {
				if(articles.get(i).equals(articles.get(j))) {
					articles.remove(j);
				}
			}
		}
		
		//remove elements contains only numbers
		for(int i=0; i<articles.size(); i++) {
			Matcher matcher_digits = digits.matcher(articles.get(i));
			if (matcher_digits.find()) {
				articles.remove(i);
			}
		}
				
		//remove elements contains only one character
		for(int i=0; i<articles.size(); i++) {
			if ( !(articles.get(i).equals("A")) && !(articles.get(i).equals("I")) && articles.get(i).length() == 1) {
				articles.remove(i);
			}	
		}
		
		//to sort
		for(int i=0; i<articles.size(); i++) {
			for (int j=i+1; j<articles.size(); j++) {
				if(articles.get(i).compareTo(articles.get(j)) >0 ){
					String temp = articles.get(i);					
					articles.set(i, articles.get(j));
					articles.set(j, temp);			
				}
			}
		}
		
		//remove null
		for (int i=0; i<articles.size(); i++) {
			if(articles.get(i) == null || articles.get(i) == "" || articles.get(i) == "\n") {
				articles.remove(i);
			}
		}
		//finish processing the input files
		
		//adding the input according to alphabetical order
		for (int i=0; i<articles.size();i++) {
			if (articles.get(i).charAt(0) == 'A') {
				Dictionary_A.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'B') {
				Dictionary_B.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'C') {
				Dictionary_C.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'D') {
				Dictionary_D.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'E') {
				Dictionary_E.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'F') {
				Dictionary_F.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'G') {
				Dictionary_G.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'H') {
				Dictionary_H.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'I') {
				Dictionary_I.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'J') {
				Dictionary_J.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'K') {
				Dictionary_K.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'L') {
				Dictionary_L.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'M') {
				Dictionary_M.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'N') {
				Dictionary_N.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'O') {
				Dictionary_O.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'P') {
				Dictionary_P.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'Q') {
				Dictionary_Q.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'R') {
				Dictionary_R.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'S') {
				Dictionary_S.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'T') {
				Dictionary_T.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'U') {
				Dictionary_U.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'V') {
				Dictionary_V.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'W') {
				Dictionary_W.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'X') {
				Dictionary_X.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'Y') {
				Dictionary_Y.add(articles.get(i));
			}
			
			else if (articles.get(i).charAt(0) == 'Z') {
				Dictionary_Z.add(articles.get(i));
			}
		}
		//finish adding the input according to alphabetical order
		
		//adding them back to the final dictionary
		dictionary.add("The document produced this sub-dictionary, which includes " + articles.size() + " entries.");
		dictionary.add("");
		dictionary.addAll(Dictionary_A);
		dictionary.add("");
		dictionary.addAll(Dictionary_B);
		dictionary.add("");
		dictionary.addAll(Dictionary_C);
		dictionary.add("");
		dictionary.addAll(Dictionary_D);
		dictionary.add("");
		dictionary.addAll(Dictionary_E);
		dictionary.add("");
		dictionary.addAll(Dictionary_F);
		dictionary.add("");
		dictionary.addAll(Dictionary_G);
		dictionary.add("");
		dictionary.addAll(Dictionary_H);
		dictionary.add("");
		dictionary.addAll(Dictionary_I);
		dictionary.add("");
		dictionary.addAll(Dictionary_J);
		dictionary.add("");
		dictionary.addAll(Dictionary_K);
		dictionary.add("");
		dictionary.addAll(Dictionary_L);
		dictionary.add("");
		dictionary.addAll(Dictionary_M);
		dictionary.add("");
		dictionary.addAll(Dictionary_N);
		dictionary.add("");
		dictionary.addAll(Dictionary_O);
		dictionary.add("");
		dictionary.addAll(Dictionary_P);
		dictionary.add("");
		dictionary.addAll(Dictionary_Q);
		dictionary.add("");
		dictionary.addAll(Dictionary_R);
		dictionary.add("");
		dictionary.addAll(Dictionary_S);
		dictionary.add("");
		dictionary.addAll(Dictionary_T);
		dictionary.add("");
		dictionary.addAll(Dictionary_U);
		dictionary.add("");
		dictionary.addAll(Dictionary_V);
		dictionary.add("");
		dictionary.addAll(Dictionary_W);
		dictionary.add("");
		dictionary.addAll(Dictionary_X);
		dictionary.add("");
		dictionary.addAll(Dictionary_Y);
		dictionary.add("");
		dictionary.addAll(Dictionary_Z);
		dictionary.add("");
		//finishing adding them back to the final dictionary
		
		for (int i=0; i<dictionary.size(); i++) {
			System.out.println(dictionary.get(i));
		}
		
		try {
			pw = new PrintWriter(new FileOutputStream("Sub_Dictionary_created.txt"));
			
			for (int i=0; i < dictionary.size();i++) {
				pw.println(dictionary.get(i));
			}
			
		}
		catch(Exception e) {
			System.out.println("Exception is caught!");
		}
		
		pw.close();
		
		
		
	}
	
	
}


