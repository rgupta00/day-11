package com.day11.session1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DemoStream {

	public static void main(String[] args) {
		//Writing the data
		try (DataOutputStream dos =
				new DataOutputStream(new FileOutputStream(
				"no.txt"))) {
			for(int i=0;i< 10; i++){
				dos.writeInt(i);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//reading the data
		try (DataInputStream dis =
				new DataInputStream(new FileInputStream(
				"no.txt"))) {
			for(int i=0;i< 10; i++){
				System.out.println(dis.readInt());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}











