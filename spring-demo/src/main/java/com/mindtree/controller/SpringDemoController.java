package com.mindtree.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.service.impl.SpringDemoServiceImpl;

@RestController
@RequestMapping(path = "/test")
public class SpringDemoController {
	
	@Autowired
	SpringDemoServiceImpl   springDemoServiceImpl;

	@RequestMapping(value = "/fileWrite", method = RequestMethod.GET) 
	public String fileWrite(@RequestParam("message") String message) throws Exception {
         String msg =null;
		try { 
			if(message.length() > 0){
				springDemoServiceImpl.writeFileProcess(message); 
				msg= "file write operation is done";
			}
			else{
				msg="The entered statement is blank";
			}
		return msg;

		} catch (IOException e) {

			return e.getMessage();

		}

	}

	@RequestMapping(value = "/fileRead", method = RequestMethod.GET) 
	public String fileRead() throws FileNotFoundException { 

		return "file content is displayed:->" + springDemoServiceImpl.readFileProcess();

	}

}
