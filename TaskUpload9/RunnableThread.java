package com.example.task9;

public class RunnableThread implements Runnable
{
	private long sleepTime;
	
	public RunnableThread()
	{
		
	}
	
	public RunnableThread(long sleepTime)
	{
		this.sleepTime=sleepTime;
	}
	
//	public void run()
//	{
//		Thread thread= Thread.currentThread();
//		System.out.println("Override run method() from RunnableThread class: ");
//		
//		System.out.println("Thread Name : "+thread.getName()+"; Thread Priority : "+thread.getPriority()
//		+"; Thread State : "+thread.getState());
//	}
	
	public void run()
	{
		try 
		{
			Thread thread= Thread.currentThread();
			
			System.out.println("Going to sleep : "+thread.getName());
			
			Thread.sleep(sleepTime);
			
			System.out.println("After sleeping : "+thread.getName());
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
