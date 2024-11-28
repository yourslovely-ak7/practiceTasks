package demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import crud.AccountOperation;
import crud.BranchOperation;
import crud.CustomerOperation;
import crud.EmployeeOperation;
import crud.TransactionOperation;
import crud.UserOperation;

public class RUnner {

	public static <E> void main(String [] args)
	{
		BranchOperation bncOpt= new BranchOperation();
		EmployeeOperation empOpt= new EmployeeOperation();
		CustomerOperation custOpt= new CustomerOperation();
		AccountOperation accOpt= new AccountOperation();
		TransactionOperation txnOpt= new TransactionOperation();
		UserOperation usrOpt= new UserOperation();
		
		String dobString = "2003-04-23"; 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
        try
		{
        	List<Object> obj= custOpt.getCustomerDetails(7);
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}
}