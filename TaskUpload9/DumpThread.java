package com.example.task9;

public class DumpThread extends Thread
{
	ExtendedThread extendedThread[];
	Thread runnableThread[];
	
	public DumpThread()
	{
		
	}
	
	public DumpThread(ExtendedThread extendedThread[], Thread runnableThread[])
	{
		this.extendedThread= extendedThread;
		this.runnableThread= runnableThread;
	}
	
	public void run()
	{
		try
		{
		for(int i=0;i<10;i++)
		{
			System.out.printf("\nThread Dump : "+(i+1)+"\n\n");
			for(ExtendedThread iter: extendedThread)
			{
				System.out.println("Extended Thread Name : "+iter.getName()+" ; Thread State : "+iter.getState());
			}
			
			for(Thread iter: runnableThread)
			{
				System.out.println("Runnable Thread Name : "+iter.getName()+" ; Thread State : "+iter.getState());
			}
			
			Thread.sleep(45000);
		}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
