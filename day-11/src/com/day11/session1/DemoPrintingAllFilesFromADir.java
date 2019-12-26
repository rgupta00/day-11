package com.day11.session1;
import java.io.*;

public class DemoPrintingAllFilesFromADir {
	
	public static void main(String[] args) {
		File dir=new File("/home/raj/Downloads");
		if(dir.isDirectory()){
			File fileNames[]=dir.listFiles(new FileFilter() {
				
				@Override
				public boolean accept(File file) {
					return file.isDirectory();
				}
			});
			for(File fileName: fileNames){
				System.out.println(fileName);
			}
		}
	}

}
