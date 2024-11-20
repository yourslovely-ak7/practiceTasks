package pojo;

public class User {

	private int userId;
	private String userName;
	private String name;
	private String userType;
	private String mobileNo;
	private String emailId;
	private String accountPass;
	private long dob;
	private long createdTime;
	private long modifiedTime;
	private int modifiedBy;
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserType() {
		return userType;
	}
	
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getAccountPass() {
		return accountPass;
	}
	
	public void setAccountPass(String accountPass) {
		this.accountPass = accountPass;
	}
	
	public long getDob() {
		return dob;
	}
	
	public void setDob(long dob) {
		this.dob = dob;
	}
	
	public long getCreatedTime() {
		return createdTime;
	}
	
	public void setCreatedTime(long createdTime) {
		this.createdTime = createdTime;
	}
	
	public long getModifiedTime() {
		return modifiedTime;
	}
	
	public void setModifiedTime(long modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	
	public int getModifiedBy() {
		return modifiedBy;
	}
	
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
}
