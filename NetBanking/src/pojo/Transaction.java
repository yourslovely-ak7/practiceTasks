package pojo;

public class Transaction {

	private int txnId;
	private long txnRefNo;
	private long accountNo;
	private long custId;
	private long accountTxnWith;
	private long txnDateTime;
	private long amount;
	private String txnMode;
	
	public int getTxnId() {
		return txnId;
	}
	public void setTxnId(int txnId) {
		this.txnId = txnId;
	}
	public long getTxnRefNo() {
		return txnRefNo;
	}
	public void setTxnRefNo(long txnRefNo) {
		this.txnRefNo = txnRefNo;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public long getAccountTxnWith() {
		return accountTxnWith;
	}
	public void setAccountTxnWith(long accountTxnWith) {
		this.accountTxnWith = accountTxnWith;
	}
	public long getTxnDateTime() {
		return txnDateTime;
	}
	public void setTxnDateTime(long txnDateTime) {
		this.txnDateTime = txnDateTime;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getTxnMode() {
		return txnMode;
	}
	public void setTxnMode(String txnMode) {
		this.txnMode = txnMode;
	}
	
}
