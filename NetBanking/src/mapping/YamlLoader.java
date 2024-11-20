package mapping;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

@SuppressWarnings("unchecked")
public class YamlLoader {

    private Map<String, Map<String, Object>> mappings;
    private String yamlFilePath="mapping/mapping.yaml";
    
    public YamlLoader() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(yamlFilePath)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("YAML file not found: " + yamlFilePath);
            }
            Yaml yaml = new Yaml();
            // Load the YAML file into a Map<String, Map<String, Object>>.
            mappings = (Map<String, Map<String, Object>>) yaml.load(inputStream);
        } catch (Exception e) {
            System.err.println("Error loading YAML file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Get the table name for a given class
    public String getTableName(String className) {
        if (mappings != null && mappings.containsKey(className)) {
            Map<String, Object> classData = mappings.get(className);
            if (classData.containsKey("table")) {
                return (String) classData.get("table");
            }
        }
        return null;
    }

    // Get the column name for a specific field in a given class
    public String getColumnName(String className, String fieldName) {
        if (mappings != null && mappings.containsKey(className)) {
            Map<String, Object> classData = mappings.get(className);
            if (classData.containsKey("fields")) {
                Map<String, String> fields = (Map<String, String>) classData.get("fields");
                return fields.get(fieldName);  // Return the column name for the field
            }
        }
        return null;
    }
    
    public Map<String, String> getAllColumnNames(String className) {
        if (mappings != null && mappings.containsKey(className)) {
            Map<String, Object> classData = mappings.get(className);
            if (classData.containsKey("fields")) {
                // Cast the "fields" to a Map<String, String> and return it
                Map<String, String> fields = (Map<String, String>) classData.get("fields");
                return fields;
            }
        }
        return null; // Return null if no data is found
    }
    
    public String getPrimaryKey(String className) {
        if (mappings != null && mappings.containsKey(className)) {
            Map<String, Object> classData = mappings.get(className);
            if (classData.containsKey("pk")) {
                return (String) classData.get("pk");
            }
        }
        return null; // Return null if no primary key is found
    }
    
    public String getautoIncrementField(String className) {
        if (mappings != null && mappings.containsKey(className)) {
            Map<String, Object> classData = mappings.get(className);
            if (classData.containsKey("autoInc")) {
                return (String) classData.get("autoInc");
            }
        }
        return null; // Return null if no primary key is found
    }
    
    public String getPrimaryKeyFieldName(String className,String primaryKey) {
        if (mappings != null && mappings.containsKey(className)) 
        {
            Map<String, Object> classData = mappings.get(className);
            
            // Retrieve the fields map and look for the field name corresponding to the primary key
            Map<String, String> fields = (Map<String, String>) classData.get("fields");
            for (Map.Entry<String, String> entry : fields.entrySet()) 
            {
                if (entry.getValue().equals(primaryKey)) 
                {
                    return entry.getKey();  // This returns the left-hand side field name
                }
            }
        }
        return null;  // Return null if no matching field name is found
    }

    public Map<String, Map<String, String>> getAllForeignKeyReferences(String className)
    {
    	if (mappings != null && mappings.containsKey(className)) 
    	{
    		Map<String, Object> classData = mappings.get(className);
    		if (classData.containsKey("fk")) 
    		{
    			return (Map<String, Map<String, String>>) classData.get("fk");
    		}
    	}
    	return null;
    }

//     Method to fetch foreign key references for a given class name
//    public Map<String, String> getForeignKeyReferences(String className) {
//        if (mappings != null && mappings.containsKey(className)) 
//        {
//            Map<String, Object> classData = mappings.get(className);
//            if (classData.containsKey("fk")) 
//            {
//                // Cast the "fk" section to a Map<String, Map<String, String>> and return the reference parts
//                Map<String, Map<String, String>> foreignKeys = (Map<String, Map<String, String>>) classData.get("fk");
//                // Extract only the reference parts from the foreign key data
//                Map<String, String> references = new java.util.HashMap<>();
//                for (String fkName : foreignKeys.keySet()) 
//                {
//                    Map<String, String> fkData = foreignKeys.get(fkName);
//                    if (fkData.containsKey("reference")) 
//                    {
//                        references.put(fkName, fkData.get("reference"));
//                    }
//                }
//                return references;
//            }
//        }
//        return null; // Return null if no foreign keys are found
//    }
    

}
