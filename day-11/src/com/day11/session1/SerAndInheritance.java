package com.day11.session1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class P {
	int i = 20;

	public P() {
		System.out.println("ctr of P is called");
	}
}

class Q extends P implements Serializable {
	int j = 40;

	public Q() {
		System.out.println("ctr of Q is called");
	}

}

public class SerAndInheritance {

	public static void main(String[] args) {
		// ser

		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(new File("foo.txt")));
			Q q = new Q();
			q.i = 99;
			oos.writeObject(q);
			System.out.println("object q is serilized in the file...");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("-------------------------------");
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					new File("foo.txt")));

			Q q = (Q) ois.readObject();
			System.out.println(q.i);
			System.out.println(q.j);
			System.out.println("object q is serilized in the file...");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
