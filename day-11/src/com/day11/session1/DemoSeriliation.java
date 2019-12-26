package com.day11.session1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//what is serilization: storing the state of java object
// along with metadata so that it can transmit over the network
//it is heavly used in RMI ( rmi is used in EJB a old but powerful tech)

//marker interface: empty interface

class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
    private String password;
    
    private void writeObject(ObjectOutputStream oos) 
    		throws IOException{
    	oos.defaultWriteObject();
    	String passwordString= "54545SX"+password;
    	oos.writeObject(passwordString);
    }
    
    private void readObject(ObjectInputStream ois) 
    		throws IOException, ClassNotFoundException{
    	ois.defaultReadObject();
    	String passwordTemp=(String) ois.readObject();
    	password=passwordTemp.substring(7);
    	
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employee(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public Employee() {}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", password="
				+ password + "]";
	}
}
public class DemoSeriliation {
	public static void main(String[] args) {
		Employee employee=new Employee(121, "raja", 
				"appleIsGoodForHealth");
		
		//ser: writing process
			try {
				ObjectOutputStream oos=
						new ObjectOutputStream
						(new FileOutputStream("demoser.txt"));
				oos.writeObject(employee);
				System.out.println("object is written on the file");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		//reading process:de-ser
			try {
				ObjectInputStream ois=
						new ObjectInputStream
						(new FileInputStream("demoser.txt"));
				
				Employee employee2=(Employee) ois.readObject();
				
				System.out.println(employee2);
				System.out.println("object is written on the file");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
	}
}
 













