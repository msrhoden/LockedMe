package com.example.LockedMe;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class FileOperations {
	
	private static ArrayList<String> information = new ArrayList<String>();
	private static final String folderPath = "LockedMe_Users\\";

	public static void createFile() throws IOException { 
		
		ArrayList<String> information = new ArrayList<String>();
		Scanner s = new Scanner(System.in);		
			
		System.out.println("\n________________________________________________________");
		System.out.println("Provide information for the file:");
		System.out.println("________________________________________________________\n");
		
		System.out.println("Enter your full name:");
		information.add(s.nextLine());			
	
		String fileName = information.get(0)+".txt";		
		File file = new File(folderPath+fileName);
		
		if(file.createNewFile()) {
			FileWriter writer = new FileWriter(folderPath+fileName);			
			
			System.out.println("\n________________________________________________________");
			System.out.println("File successfully Created! File Name: " + fileName);
			System.out.println("________________________________________________________");
			
		} else {
			System.out.println("\n________________________________________________________");
			System.out.println("File Already Exists ");
			System.out.println("________________________________________________________");
						
		}

		MainApp.fileOperationMenu();		
		s.close();
	}
	
		
	public static void searchFile() throws IOException {		
		
		Scanner s = new Scanner(System.in);
		File file;
		
		System.out.println("\n________________________________________________________");
		System.out.println("Search file");
		System.out.println("________________________________________________________\n");
		
		System.out.println("Enter the File Name");
		String fileName = s.nextLine();
		String ext = ".txt";
		
		if(!fileName.toLowerCase().contains(ext.toLowerCase())) {
			fileName = fileName+ext;
		}
		
		fileName = folderPath+fileName; 
		file = new File(fileName);
		
				
		if(file.exists()) {
			System.out.println("\n________________________________________________________");
			System.out.println("File Found");
			System.out.println("________________________________________________________\n");
			
		}
		else {
			System.out.println("\n________________________________________________________");
			System.out.println("Error: File not Found!!");
			System.out.println("________________________________________________________\n");
		}
		
		MainApp.fileOperationMenu();
		s.close();		
	}
	
	public static void delete() throws IOException {
		Scanner s = new Scanner(System.in);				
		System.out.println("\n________________________________________________________");
		System.out.println("Enter the file name to be deleted:");
		System.out.println("________________________________________________________\n");	
		
		String file = s.nextLine();
		String ext = ".txt";
		
		if(!file.toLowerCase().contains(ext.toLowerCase())) {
			file = file+ext;
		}
		file = folderPath+file;   
		
		System.out.println("Are you sure you want to delete the file (1)To confirm or (2)To Cancel");
		int test = s.nextInt();
		if (test==1) {
			try {
				Files.delete(Paths.get(file));
				System.out.println("\n________________________________________________________");
				System.out.println("file successfully deleted");
				System.out.println("________________________________________________________\n");
			} catch (NoSuchFileException e) {
				System.out.println("\n________________________________________________________");
				System.out.println("Error: No such file exists");
				System.out.println("________________________________________________________\n");
			} 
			
		}else {
			System.out.println("Operation Canceled");
		}	
		
		MainApp.fileOperationMenu();	
		s.close();
	}
	
	
	public void fileList() { 
		
        File folder = new File("LockedMe_Users");
        
        if(folder.isDirectory())
        {
            File[] fileList = folder.listFiles();

            System.out.println("\n____________________________________________________________");           
            System.out.println("Please find below all File Names in Alphabetic order");
            System.out.println("Total number of Client Files: " + fileList.length);
            System.out.println("____________________________________________________________\n");
                    
            Arrays.sort(fileList);
            
            for(File file:fileList)
            {
                System.out.println(file.getName());
            }
        }
    }
}