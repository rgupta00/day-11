package com.day11.session2;
import java.util.*;
class Val{
	private int i;
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public Val(int i) {
		this.i = i;
	}
}
public class DemoSet {
	
	public static void main(String[] args) {
		Set<Val> set=new HashSet<Val>();
		set.add(new Val(33));
		System.out.println(set.contains(new Val(33)));
	}

}






