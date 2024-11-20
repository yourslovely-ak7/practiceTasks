package crud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import pojo.Transaction;
import query.Condition;
import query.Order;

public class TransactionOperation 
{
	private static final Set<Long> generatedNumbers = new HashSet<>();
    private static final Random random = new Random();
    private static Operations newOpt= new Operations();
    private static AccountOperation accOpt= new AccountOperation();
    private Map<Transaction,List<String>> objects;
    private Map<String,Condition> condition;
	
	public void newTransaction(long accountNo, long accountTxnWith, long amount, boolean externalBank)
	{
		if(externalBank==false)
		{
			if(accOpt.checkAccountStatus(accountTxnWith))
			{
				long txnRefNo= generateUniqueRandom12DigitNumber();
				long txnDateTime= getCurrentTimeMillis();
				
				if(accOpt.debitAmount(accountNo,amount,txnDateTime))
				{
					Transaction newTransaction= new Transaction();
					newTransaction.setTxnRefNo(txnRefNo);
					newTransaction.setAccountNo(accountNo);
					newTransaction.setCustId(accOpt.getCustId(accountNo));
					newTransaction.setAccountTxnWith(accountTxnWith);
					newTransaction.setTxnDateTime(txnDateTime);
					newTransaction.setAmount(amount);
					newTransaction.setTxnMode("DEBIT");

					newOpt.createMethod(newTransaction);

					if(accOpt.creditAmount(accountTxnWith,amount,txnDateTime))
					{
						newTransaction= new Transaction();
						newTransaction.setTxnRefNo(txnRefNo);
						newTransaction.setAccountNo(accountTxnWith);
						newTransaction.setCustId(accOpt.getCustId(accountTxnWith));
						newTransaction.setAccountTxnWith(accountNo);
						newTransaction.setTxnDateTime(txnDateTime);
						newTransaction.setAmount(amount);
						newTransaction.setTxnMode("CREDIT");
						
						newOpt.createMethod(newTransaction);
					}
				}
				
			}
			
		}
		
	}
	
	public void showTransactions(long accountNo, int limit)
	{
		Transaction transaction= new Transaction();
		List<String> requiredFields= new ArrayList<>();
		
		requiredFields.add("txnRefNo");
		requiredFields.add("accountNo");
		requiredFields.add("accountTxnWith");
		requiredFields.add("txnDateTime");
		requiredFields.add("amount");
		requiredFields.add("txnMode");
		
		objects= new HashMap<>();
		objects.put(transaction, requiredFields);
		
		condition= new HashMap<>();
		Condition newCondition= new Condition();
		newCondition.setTableName("Transaction");
		newCondition.setFieldName("accountNo");
		newCondition.setOperator(" = ");
		newCondition.setValue(accountNo);
		
		condition.put("", newCondition);
		
		Order order= new Order();
		if(limit>150)
		{
			limit= 150;
		}
		
		List<String> orderBy= new ArrayList<String>();
		orderBy.add("txnDateTime");
		
		order.setTableObject(transaction);
		order.setOrderBy(orderBy);
		order.setDesc(true);
		order.setLimit(limit);
		
		newOpt.selectMethod(objects, condition, order);
	}
	
	private static long generateUniqueRandom12DigitNumber() {
        long randomNumber;
        do {
            randomNumber = 100_000_000_000L + (long) (random.nextDouble() * 900_000_000_000L);
        } 
        while (!generatedNumbers.add(randomNumber)); 
        
        return randomNumber;
    }

    private static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
}
