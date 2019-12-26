package com.day11.session1;

import java.io.File;
import java.io.IOException;

public class DemoFile2 {
	
	public static void main(String[] args) throws IOException {
		File file=new File("demo4");
		System.out.println(file.mkdir());
		System.out.println(file.mkdir());
		
	}

}
