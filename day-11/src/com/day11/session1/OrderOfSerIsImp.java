package com.day11.session1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Ser in case of inheritance
 */
class A {
	int i=20;
	public A(){}
	public A(int i){
		System.out.println("ctr of A is called..public A(int i).");
	}
}

class B extends A implements Serializable{
	 int j=40;
	public B(){
		super(55);
		System.out.println("ctr of B is called...");
	}
}


class Rat implements Serializable{
	int i=10;
	int j=20;
}

class Cat implements Serializable{
	Rat rat=new Rat();
}
class Dog implements Serializable{
	Cat cat=new Cat();
}

public class OrderOfSerIsImp {
	
	public static void main(String[] args) {
		
		/*
		 * ser in case of inheritance
		 */
	
		try {
			ObjectOutputStream oos=new ObjectOutputStream
					(new FileOutputStream("exp.txt"));
			B b=new B();
			b.i=88;
			oos.writeObject(b);
			System.out.println("object B is added..");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("-------------------------");
		try {
			ObjectInputStream oos=new ObjectInputStream
					(new FileInputStream("exp.txt"));
			
			B b=(B) oos.readObject();
			System.out.println(b.i);
			System.out.println(b.j);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		/*
		 * Serilization and object graph!
		 * When we store an object all related object graph is also
		 * saved.
		 */
		
		try {
			ObjectOutputStream oos=new ObjectOutputStream
					(new FileOutputStream("exp.txt"));
			oos.writeObject(new Dog());
			System.out.println("dog are added..");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			ObjectInputStream oos=new ObjectInputStream
					(new FileInputStream("exp.txt"));
			
			Dog dog=(Dog) oos.readObject();

			System.out.println("dog are obtained..");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		/*
		 * You need to maintain same order of retrival of
		 *  serilized object
		 * how u stored them otherwise will get CCEx
		 */
		//Ser
		/*try {
			ObjectOutputStream oos=new ObjectOutputStream
					(new FileOutputStream("exp.txt"));
			oos.writeObject(new Rat());
			oos.writeObject(new Cat());
			oos.writeObject(new Dog());
			System.out.println("rat cat dog are added..");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			ObjectInputStream oos=new ObjectInputStream
					(new FileInputStream("exp.txt"));
			Rat rat=(Rat) oos.readObject();
			Cat cat=(Cat) oos.readObject();
			Dog dog=(Dog) oos.readObject();
			

			System.out.println("rat cat dog are obtained..");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		*/
	}

}









