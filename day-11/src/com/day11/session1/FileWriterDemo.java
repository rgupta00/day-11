package com.day11.session1;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
	public static void main(String[] args) {
		
		try (FileWriter fw=new FileWriter("demo3.txt")){
			fw.write("i love java and teaching and traveling\n");
			fw.write("you need to love the god not to fear from him\n");
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
