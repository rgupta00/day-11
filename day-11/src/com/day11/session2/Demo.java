package com.day11.session2;
class A{
	A(int i){
		System.out.println("hi");
	}
	A(){}
}
class B extends A{
	B(){
		System.out.println("by");
	}
}
public class Demo {
	
	public static void main(String[] args) {
		A a=new B();
	}

}
