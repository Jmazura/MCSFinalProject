
package mcsfinalproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class ToolClass {
    public JSONParser parser = new JSONParser();
    public ToolClass()
    {
        
    }
    
    public String getJSONFromFile(String filename)
    {
        String jsonText = "";
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                jsonText += line + "\n";
            }
            bufferedReader.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return jsonText;
    }
    
    public String getStringFromObject(JSONObject objectname, String key)
    {
        return (String) objectname.get(key);
    }
    
    public int getIntFromObject(JSONObject objectname, String key)
    {
        System.out.println(objectname.get(key));
        return Integer.parseInt((String) objectname.get(key));
    }
    
    public JSONObject getObjecFrom(String filename, String key)
    {
        String jsonText = this.getJSONFromFile(filename);
        try
        {
            Object object = parser.parse(jsonText);
            JSONObject mainJsonObject = (JSONObject) object;
            return (JSONObject) mainJsonObject.get(key);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
        
    }
    public String getStringFrom(String filename, String key)
    {
        String jsonText = this.getJSONFromFile(filename);
        try
        {
            Object object = parser.parse(jsonText);
            JSONObject mainJsonObject = (JSONObject) object;
            return (String) mainJsonObject.get(key);
        }
        catch(Exception ex)
        {
            return ex.getMessage();
        }   
    }
    
    public int getIntFrom(String filename, String key)
    {
        String jsonText = this.getJSONFromFile(filename);
        try
        {
            Object object = parser.parse(jsonText);
            JSONObject mainJsonObject = (JSONObject) object;
            return (int) mainJsonObject.get(key);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return 0;
        }   
    }
    
    public String get(String filename)
    {
        return this.getJSONFromFile(filename);
    }
    
    public void addData(JSONObject object, String key, String data)
    {
        

    }
    
    public JSONObject getObject(String filename)
    {
        String jsonText = this.getJSONFromFile(filename);
        try{
        Object object = parser.parse(jsonText);
        JSONObject mainJsonObject = (JSONObject) object;
        return mainJsonObject;
        }catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    
    public void writeJSON() throws IOException
    {
        FileWriter file = new FileWriter("src/mcsfinalproject/DATABASE.json", false);
        file.write(this.getObject("src/mcsfinalproject/DATABASE.json").toJSONString());
        file.close();
    }
}   
