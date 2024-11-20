package pojo;

public class Branch {

	private int branchId;
	private String branchName;
	private int branchCode;
	private String city;
	private int managerId;
	private long createdTime;
	private long modifiedTime;
	private int modifiedBy;

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
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
