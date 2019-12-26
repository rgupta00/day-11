package com.day11.session1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DemoFile {
	// char stream vs byte stream
	public static void main(String[] args) {
		// print the content of the file
		// print unique words form the file

		// get a hashset and put the token into set, and then it
		// will not allow duplicate and afterward print that

		TreeSet<String> set = new TreeSet<String>();
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(
					"data.txt"));
			String line=null;
			while((line=br.readLine())!=null){
				String tokens[]=line.split(" ");
				for(String token: tokens){
					set.add(token);
				}
			}
		} catch (FileNotFoundException ex) {
			System.out.println("file is not found");
		} catch (IOException e) {
			System.out.println("some io ex");
		} 
		finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		//we need to print that set
		for(String val: set){
			System.out.println(val);
		}
	}
}











