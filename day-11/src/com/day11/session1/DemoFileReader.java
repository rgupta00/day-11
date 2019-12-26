package com.day11.session1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DemoFileReader {

	public static void main(String[] args) {
		// fileReader read a char at a time : bad performance
		int val = 0;

		try (FileReader fr = new FileReader("data.txt")) {
			while ((val = fr.read()) != -1) {
				System.out.println((char)val);
			}
		} catch (IOException e) {
			System.out.println("file is not found");
		}

	}

}











