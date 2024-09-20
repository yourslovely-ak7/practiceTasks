package test;
import birds.Bird;
import child.Parrot;

class TestRunner
{
	public static void main(String [] args)
	{
		Bird obj=new Bird();
		Parrot obj1=new Parrot();
		
		obj.fly();
		obj1.speak();
		
		ClassLoader classLoader = TestRunner.class.getClassLoader();
		
		if(classLoader!=null)
		{
			System.out.println("This class is loaded by : "+classLoader);
		}
		
		System.out.println("This class will be in Ext dir...");
	}
}
