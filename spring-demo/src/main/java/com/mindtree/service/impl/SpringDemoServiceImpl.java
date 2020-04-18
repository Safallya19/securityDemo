package com.mindtree.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.mindtree.service.SpringDemoService;

@Service
public class SpringDemoServiceImpl implements SpringDemoService{

	@Override
	public void writeFileProcess(String message) throws FileNotFoundException { 
		
		FileOutputStream file = new FileOutputStream("demoAb.txt"); 
		PrintWriter pw = new PrintWriter(file); 
		pw.println(message); 
		pw.close();
		
	}

	@Override
	public String readFileProcess() throws FileNotFoundException {  
		 
		FileInputStream fileInputStream = new FileInputStream("demoAb.txt"); 
		Scanner sc = new Scanner(fileInputStream); 
		String str = null; 
		while (sc.hasNext()) { 
			str = sc.nextLine(); 
		}
	 
		return str;
	}

}
