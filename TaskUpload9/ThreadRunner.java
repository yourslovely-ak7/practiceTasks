package com.example.task9;

import java.util.Scanner;

public class ThreadRunner 
{
	public static void main(String [] args)
	{
		Scanner scanner=new Scanner(System.in);
		ThreadRunner runner=new ThreadRunner();
		
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
						runner.exercise1(scanner);
						break;
					case 2:
						runner.exercise2(scanner);
						break;
					case 3:
						runner.exercise3(scanner);
						break;
					case 4:
						runner.exercise4(scanner);
						break;
					case 5:
						runner.exercise5(scanner);
						break;
					case 6:
						runner.exercise6(scanner);
						break;
					case 7:
						runner.exercise7(scanner);
						break;
					case 0:
						flag++;
						System.out.println("Thank You! See you again...");
						break;
					default:
						System.out.println("Enter a valid Input!");
					}
				}
				catch(Exception error)
				{
					System.out.println("Error : "+ error);
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
	
	private void exercise1(Scanner scanner) throws Exception
	{
		ExtendedThread thread=new ExtendedThread();
		
		System.out.println("Thread Name : "+thread.getName()+"; Thread Priority : "+thread.getPriority()
		+"; Thread State : "+thread.getState());
		
		thread.start();
		
		System.out.println("Thread Name : "+thread.getName()+"; Thread Priority : "+thread.getPriority()
		+"; Thread State : "+thread.getState());
		
		thread.join();
	}
	
	private void exercise2(Scanner scanner) throws Exception
	{
		RunnableThread obj=new RunnableThread();
		Thread thread= new Thread(obj);
		
		System.out.println("Thread Name : "+thread.getName()+"; Thread Priority : "+thread.getPriority()
		+"; Thread State : "+thread.getState());
		
		thread.start();
		
		System.out.println("Thread Name : "+thread.getName()+"; Thread Priority : "+thread.getPriority()
		+"; Thread State : "+thread.getState());
		
		thread.join();
	}
	
	private void exercise3(Scanner scanner) throws Exception
	{
		ExtendedThread extThread=new ExtendedThread();
		extThread.setName("Extended Thread");
		
		System.out.println("Thread Name : "+extThread.getName()+"; Thread Priority : "+extThread.getPriority()
		+"; Thread State : "+extThread.getState());
		
		extThread.start();
		
		System.out.println("Thread Name : "+extThread.getName()+"; Thread Priority : "+extThread.getPriority()
		+"; Thread State : "+extThread.getState());
		extThread.join();
		System.out.println();
		
		RunnableThread obj=new RunnableThread();
		Thread runThread= new Thread(obj,"RunnableThread");
		
		System.out.println("Thread Name : "+runThread.getName()+"; Thread Priority : "+runThread.getPriority()
		+"; Thread State : "+runThread.getState());
		
		runThread.start();
		
		System.out.println("Thread Name : "+runThread.getName()+"; Thread Priority : "+runThread.getPriority()
		+"; Thread State : "+runThread.getState());
		
		runThread.join();
	}
	
	private void exercise4(Scanner scanner)
	{
		for(int i=0;i<5;i++)
		{
			ExtendedThread obj=new ExtendedThread(60000);
			obj.setName("ExtendedThread["+(i+1)+"]");
			
			obj.start();
		}
		
		for(int i=0;i<5;i++)
		{
			RunnableThread obj=new RunnableThread(45000);
			String name="RunnableThread["+(i+1)+"]";
			Thread thread=new Thread(obj,name);
						
			thread.start();
		}
	}
	
	private void exercise5(Scanner scanner)
	{
		for(int i=0;i<5;i++)
		{
			System.out.println("Enter the sleep time for the thread in seconds : ");
			int sec= scanner.nextInt();
			long sleepTime= sec*1000;
			ExtendedThread obj=new ExtendedThread(sleepTime);
			obj.setName("ExtendedThread["+(i+1)+"]");
			
			obj.start();
		}
		
		for(int i=0;i<5;i++)
		{
			System.out.println("Enter the sleep time for the thread in seconds : ");
			int sec= scanner.nextInt();
			long sleepTime= sec*1000;
			RunnableThread obj=new RunnableThread(sleepTime);
			String name="RunnableThread["+(i+1)+"]";
			Thread thread=new Thread(obj,name);
						
			thread.start();
		}
	}
	
	private void exercise6(Scanner scanner) throws InterruptedException
	{
		ExtendedThread[] extendedThread=new ExtendedThread[5];
		RunnableThread[] runnable=new RunnableThread[5];
		Thread[] runnableThread= new Thread[5];
		
		for(int i=0;i<5;i++)
		{
			System.out.println("Enter the sleep time for the thread in seconds : ");
			int sec= scanner.nextInt();
			long sleepTime= sec*1000;
			
			extendedThread[i] =new ExtendedThread(sleepTime);
			extendedThread[i].setName("ExtendedThread["+(i+1)+"]");
			extendedThread[i].toggle();
			extendedThread[i].start();
		}
		
		for(int i=0;i<5;i++)
		{
			System.out.println("Enter the sleep time for the thread in seconds : ");
			int sec= scanner.nextInt();
			long sleepTime= sec*1000;
			
			runnable[i] =new RunnableThread(sleepTime);
			
			String name="RunnableThread["+(i+1)+"]";
			runnableThread[i]=new Thread(runnable[i],name);
			runnable[i].toggle();
			runnableThread[i].start();
		}
		
		Thread.sleep(120000);
		
		for(int i=0;i<3;i++)
		{
			for(ExtendedThread iter: extendedThread)
			{
				System.out.println("Extended Thread Name : "+iter.getName()+" ; Thread State : "+iter.getState());
			}
			
			for(Thread iter: runnableThread)
			{
				System.out.println("Runnable Thread Name : "+iter.getName()+" ; Thread State : "+iter.getState());
			}
			
			Thread.sleep(30000);
		}
		
		for(ExtendedThread iter: extendedThread)
		{
			iter.toggle();
		}
		
		for(RunnableThread iter: runnable)
		{
			iter.toggle();
		}
	}
	
	private void exercise7(Scanner scanner) throws InterruptedException
	{
		ExtendedThread[] extendedThread=new ExtendedThread[5];
		RunnableThread[] runnable=new RunnableThread[5];
		Thread[] runnableThread= new Thread[5];
		
		for(int i=0;i<5;i++)
		{
			System.out.println("Enter the sleep time for the thread in seconds : ");
			int sec= scanner.nextInt();
			long sleepTime= sec*1000;
			
			extendedThread[i] =new ExtendedThread(sleepTime);
			extendedThread[i].setName("ExtendedThread["+(i+1)+"]");
			extendedThread[i].toggle();
			extendedThread[i].start();
		}
		
		for(int i=0;i<5;i++)
		{
			System.out.println("Enter the sleep time for the thread in seconds : ");
			int sec= scanner.nextInt();
			long sleepTime= sec*1000;
			
			runnable[i] =new RunnableThread(sleepTime);
			
			String name="RunnableThread["+(i+1)+"]";
			runnableThread[i]=new Thread(runnable[i],name);
			runnable[i].toggle();
			runnableThread[i].start();
		}
		
		Thread.sleep(120000);
		
		DumpThread dump=new DumpThread(extendedThread,runnableThread);
		StopThread stop=new StopThread(extendedThread, runnable);
		
		dump.start();
		stop.start();
		
		dump.join();
		stop.join();
		
		boolean isAlive=false;
		
		for(ExtendedThread iter: extendedThread)
		{
			if(iter.isAlive())
			{
				isAlive=true;
				break;
			}
		}
		
		for(Thread iter: runnableThread)
		{
			if(iter.isAlive())
			{
				isAlive=true;
				break;
			}
		}
		
		if(!isAlive)
		{
			System.out.println("All tasks Completed!");
		}
		
		System.out.printf("\nThread Dump after the tasks Completed...\n\n");
		
		for(ExtendedThread iter: extendedThread)
		{
			System.out.println("Extended Thread Name : "+iter.getName()+" ; Thread State : "+iter.getState());
		}
		
		for(Thread iter: runnableThread)
		{
			System.out.println("Runnable Thread Name : "+iter.getName()+" ; Thread State : "+iter.getState());
		}
	}
}
