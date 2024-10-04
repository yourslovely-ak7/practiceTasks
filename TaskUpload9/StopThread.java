package com.example.task9;

public class StopThread extends Thread
{
	ExtendedThread extendedThread[];
	RunnableThread runnable[];
	
	public StopThread()
	{
		
	}
	
	public StopThread(ExtendedThread extendedThread[], RunnableThread runnable[])
	{
		this.extendedThread= extendedThread;
		this.runnable= runnable;
	}
	
	public void run()
	{
		try
		{
			for(int i=0;i<5;i++)
			{
				extendedThread[i].toggle();
				runnable[i].toggle();
				
				Thread.sleep(60000);
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
