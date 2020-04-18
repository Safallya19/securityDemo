package com.mindtree.service;

import java.io.FileNotFoundException;

public interface SpringDemoService {
       void writeFileProcess(String message)throws FileNotFoundException;
       String readFileProcess() throws FileNotFoundException;
}
