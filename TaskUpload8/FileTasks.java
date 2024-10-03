package com.example.task8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import com.example.exception.Helper;
import com.example.exception.InvalidException;

public class FileTasks {
	
	public BufferedWriter createBW(String fileName) throws InvalidException, IOException
	{
		Helper.validateInput(fileName);
		
		BufferedWriter newBW= new BufferedWriter(new FileWriter(fileName));
		
		return newBW;
	}
	
	public BufferedWriter createBW(File newFile) throws InvalidException, IOException
	{
		BufferedWriter newBW= new BufferedWriter(new FileWriter(newFile));
		
		return newBW;
	}
	public void writeInFile(BufferedWriter writer, String line) throws IOException, InvalidException
	{
		Helper.validateInput(writer);
		Helper.validateInput(line);
		
		writer.write(line);
	}
	
	public void writeNewLine(BufferedWriter writer) throws IOException, InvalidException
	{
		Helper.validateInput(writer);
		
		writer.newLine();
	}
	
	public void closeWriter(BufferedWriter writer) throws IOException, InvalidException
	{
		Helper.validateInput(writer);
		
		writer.close();
	}
	
	public Properties createProps()
	{
		Properties newProp=new Properties();
		
		return newProp;
	}
	
	public void setProps(Properties newProp, String key, String value) throws InvalidException
	{
		Helper.validateInput(newProp);
		Helper.validateInput(key);
		Helper.validateInput(value);
		
		newProp.setProperty(key, value);
	}
	
	public FileOutputStream createFileOut(String fileName) throws IOException, InvalidException
	{
		Helper.validateInput(fileName);
		
		FileOutputStream fileOut=new FileOutputStream(fileName);
		return fileOut;
	}
	
	public FileOutputStream createFileOut(File newFile) throws IOException, InvalidException
	{
		Helper.validateInput(newFile);
		
		FileOutputStream fileOut=new FileOutputStream(newFile);
		return fileOut;
	}
	
	public void storeProps(Properties newProp, FileOutputStream fileOut, String comment) throws IOException, InvalidException
	{
		Helper.validateInput(newProp);
		Helper.validateInput(fileOut);
		Helper.validateInput(comment);
		
		newProp.store(fileOut, comment);
	}
	
	public FileInputStream createFileIn(String fileName) throws IOException, InvalidException
	{
		Helper.validateInput(fileName);
		
		FileInputStream fileIn=new FileInputStream(fileName);
		return fileIn;
	}
	
	public FileInputStream createFileIn(File newFile) throws IOException, InvalidException
	{
		Helper.validateInput(newFile);
		
		FileInputStream fileIn=new FileInputStream(newFile);
		return fileIn;
	}
	
	public void loadProps(Properties newProp, FileInputStream fileIn) throws IOException, InvalidException
	{
		Helper.validateInput(newProp);
		Helper.validateInput(fileIn);
		
		newProp.load(fileIn);
	}
	
	public void createDir(String path) throws InvalidException
	{
		Helper.validateInput(path);
		
		File file= new File(path);
		
		if(! file.exists())
		{
			file.mkdirs();
		}
	}
	
	public File createFileInDir(String path, String fileName) throws IOException, InvalidException
	{
		Helper.validateInput(path);
		Helper.validateInput(fileName);
		
		File file= new File(path, fileName);
		
		file.createNewFile();
		return file;
	}
	
	
}
