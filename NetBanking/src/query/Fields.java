package query;

import java.util.List;

public class Fields 
{
	private String tableName;
	private List<String> fieldNames;
	private List<Object> values;
	
	public List<Object> getValues() {
		return values;
	}
	public void setValues(List<Object> values) {
		this.values = values;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public List<String> getFieldNames() {
		return fieldNames;
	}
	public void setFieldNames(List<String> fieldNames) {
		this.fieldNames = fieldNames;
	}
}
