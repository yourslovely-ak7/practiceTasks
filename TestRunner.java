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
	}
}
