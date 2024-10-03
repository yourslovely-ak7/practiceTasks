package com.example.task8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;

import com.example.exception.InvalidException;

public class FileRunner {
	
	public static Logger logger= Logger.getLogger(FileRunner.class.getName());
	
	public static void main(String [] args)
	{
		Scanner scanner=new Scanner(System.in);
		FileTasks fileObj=new FileTasks();
		FileRunner runner=new FileRunner();
		
		int flag=0;
		int option;
		
		try {
			
			while(flag==0)
			{
				runner.defaultPrint();
				option= scanner.nextInt();
				
				try
				{
					switch(option)
					{
					case 1:
						runner.exercise1(scanner,fileObj);
						break;
					case 2:
						runner.exercise2(scanner,fileObj);
						break;
					case 3:
						runner.exercise3(scanner,fileObj);
						break;
					case 4:
						runner.exercise4(scanner,fileObj);
						break;
					case 0:
						flag++;
						logger.info("Thank You! See you again...");
						break;
					default:
						logger.info("Enter a valid Input!");
					}
				}
				catch(IOException error)
				{
					logger.info("Error : "+ error);
				}
				catch(InvalidException error)
				{
					logger.severe("Error : "+ error);
				}
			}	
		}
		finally {
			scanner.close();
		}
	}
	

	private void defaultPrint()
	{
		System.out.printf("\nSelect an option : \n");
	}

	private void exercise1(Scanner scanner, FileTasks fileObj) throws IOException, InvalidException
	{
		logger.info("Enter the name for the text file : ");
		String fileName= scanner.next();
		fileName+= ".txt";
		BufferedWriter writer= fileObj.createBW(fileName);
		
		logger.info("Enter the number of lines : ");
		int num= scanner.nextInt();
		scanner.nextLine();
		
		logger.info("Enter the lines to be written : ");
		String line;
		for(int i=0;i<num;i++)
		{
			line= scanner.nextLine();
			fileObj.writeInFile(writer, line);
			fileObj.writeNewLine(writer);
		}
		
		fileObj.closeWriter(writer);
	}
	
	private void exercise2(Scanner scanner, FileTasks fileObj) throws IOException, InvalidException
	{
		Properties newProp= fileObj.createProps();
		
		logger.info("Enter the number of pairs : ");
		int num= scanner.nextInt();
		scanner.nextLine();

		logger.info("Enter the Key and Value separated by space : ");
		String key,value,comment;
		for(int i=0;i<num;i++)
		{
			key= scanner.next();
			value= scanner.next();
			
			fileObj.setProps(newProp, key, value);
		}
		
		logger.info("Enter the name for the text file : ");
		String fileName= scanner.next();
		fileName+= ".txt";
		logger.info("Enter a comment to store : ");
		scanner.nextLine();
		comment= scanner.nextLine();
		
		FileOutputStream fileOut= fileObj.createFileOut(fileName);
		fileObj.storeProps(newProp, fileOut, comment);
	}
	
	private void exercise3(Scanner scanner, FileTasks fileObj) throws IOException, InvalidException
	{
		Properties newProp= fileObj.createProps();
		
		logger.info("Enter the name for the text file : ");
		String fileName= scanner.next();
		fileName+= ".txt";
		
		FileInputStream fileIn= fileObj.createFileIn(fileName);
		fileObj.loadProps(newProp,fileIn);
		
		newProp.forEach((key,value)->{
			logger.info(key+" = "+value);
			}
		);
	}
	
	private void exercise4(Scanner scanner, FileTasks fileObj) throws IOException, InvalidException
	{
		logger.info("Enter the file path : ");
		String path= scanner.next();

		fileObj.createDir(path);
		
		logger.info("Exercise - 1 : Write lines in a file.");
		logger.info("Enter the file name : ");
		String fileName= scanner.next();
		fileName+= ".txt";
		File newFile= fileObj.createFileInDir(path, fileName);
		
		BufferedWriter writer = fileObj.createBW(newFile);
		logger.info("Enter the number of lines : ");
		int num= scanner.nextInt();
		scanner.nextLine();
		
		logger.info("Enter the lines to be written : ");
		String line;
		for(int i=0;i<num;i++)
		{
			line= scanner.nextLine();
			fileObj.writeInFile(writer, line);
			fileObj.writeNewLine(writer);
		}
		
		fileObj.closeWriter(writer);
		
		logger.info("Exercise - 2 : Store Props in a file.");
		Properties newProp= fileObj.createProps();
		
		logger.info("Enter the number of pairs : ");
		num= scanner.nextInt();
		scanner.nextLine();

		logger.info("Enter the Key and Value separated by space : ");
		String key,value,comment;
		
		for(int i=0;i<num;i++)
		{
			key= scanner.next();
			value= scanner.next();
			
			fileObj.setProps(newProp, key, value);
		}
		
		logger.info("Enter the name for the text file : ");
		fileName= scanner.next();
		fileName+= ".txt";
		
		logger.info("Enter a comment to store : ");
		scanner.nextLine();
		comment= scanner.nextLine();
		
		newFile= fileObj.createFileInDir(path, fileName);
		FileOutputStream fileOut= fileObj.createFileOut(newFile);
		fileObj.storeProps(newProp, fileOut, comment);
		
		logger.info("Exercise - 3 : Print the Props from the file.");
		newProp= fileObj.createProps();
		
		logger.info("Enter the name for the text file : ");
		fileName= scanner.next();
		fileName+= ".txt";
		newFile= fileObj.createFileInDir(path, fileName);
		
		FileInputStream fileIn= fileObj.createFileIn(newFile);
		fileObj.loadProps(newProp,fileIn);
		
		newProp.forEach((keyPart,valuePart)->{
			logger.info(keyPart+" = "+valuePart);
			}
		);
	}
	
	
}
