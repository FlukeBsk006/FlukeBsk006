package com.example.firstspring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class FirstspringApplication {
	public static void main(String[] args) {
		SpringApplication.run(FirstspringApplication.class, args);

//		Abtract_test ab_test[] = new Abtract_test[2];
//
//		for(int i=0;i<2;i++){
//			ab_test[i] = new Human("cccc", "dhd");
//			System.out.println("ab rows : " + ab_test[i]);
//			Human h = new Human(null, null);
//			h.ShowAll();
//		}
//
//		Human h1 = new Human();
//		List<String> hh = h1.lists();
//		System.out.println(hh);
	}
}
interface interface_test{
	void ShowAll();
	String test();
}

abstract class Abtract_test {
	public String name;

	public Abtract_test (String text1, String text2){
		name = text1 + " " + text2;
	}
	public String noImplement(){
		return "dfdfdf";
	}
	public String toString(){
		return ("name : " + name);
	}
}

class Human extends Abtract_test implements interface_test {

	public Human(){
		super(null, null);
	}

	public Human(String text1, String text2) {
		super(text1, text2);
	}
	@Override
	public void ShowAll() {
		System.out.println("interfact success");
	}

	@Override
	public String test() {
		return null;
	}

	public List<String > lists(){
		List list = new ArrayList();
		list.add("fefef");
		list.add("dddd");
		list.add("dddd");
		return list;
	}

	@Override
	public String toString() {
		return "Human{" +
				"name='" + name + '\'' +
				'}';
	}
}