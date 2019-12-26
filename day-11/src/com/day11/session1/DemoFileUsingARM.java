package com.day11.session1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DemoFileUsingARM {
	// char stream vs byte stream
	public static void main(String[] args) {

		TreeSet<String> set = new TreeSet<String>();

		//Automatic resource mgt 1.7
		//purpose : to reduce the code, java dev dont need to 
		//care about closing the resouce, it is autmatically closed 
		//this gurantee is given by JVM
		
		try (BufferedReader br = 
				new BufferedReader(new FileReader("data.txt"))) {

			String line = null;
			while ((line = br.readLine()) != null) {
				String tokens[] = line.split(" ");
				for (String token : tokens) {
					set.add(token);
				}
			}
		} catch (FileNotFoundException ex) {
			System.out.println("file is not found");
		} catch (IOException e) {
			System.out.println("some io ex");
		}

		// we need to print that set
		for (String val : set) {
			System.out.println(val);
		}
	}
}
