package com.example.task9;

public class ExtendedThread extends Thread
{
	private long sleepTime;
	private boolean isRunning;
	
	public ExtendedThread()
	{
		
	}
	
	public ExtendedThread(long sleepTime)
	{
		this.sleepTime=sleepTime;
	}
	
	public void toggle()
	{
		this.isRunning= !(isRunning);
	}
	
//	public void run()
//	{
//		System.out.println("Override run method() from ExtendedThread class: ");
//		
//		System.out.println("Thread Name : "+getName()+"; Thread Priority : "+getPriority()+"; Thread State : "+getState());
//	}
	
//	public void run()
//	{
//		try 
//		{
//			System.out.println("Going to sleep : "+getName());
//			
//			Thread.sleep(sleepTime);
//			
//			System.out.println("After sleeping : "+getName());
//		} 
//		catch (InterruptedException e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public void run()
	{
		try 
		{
			while(isRunning)
			{
				System.out.println("Going to sleep : "+getName());
			
				Thread.sleep(sleepTime);
			
				System.out.println("After sleeping : "+getName());
			}
			
			System.out.println("Thread - "+this.getName()+" exited the loop!");
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
