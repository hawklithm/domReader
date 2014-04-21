package org.hawklithm.domReader.dataobject;

import java.util.HashMap;
import java.util.Map;

public class JavaFileInfo {
	private Map<String,String> info=new HashMap<String,String>();
	public String getProperty(String propertyName) throws Exception{
		if (info.containsKey(propertyName)){
			return info.get(propertyName);
		}
		throw new Exception("have no such property["+propertyName+"]");
	}
	public void setProperty(String propertyName,String value){
		info.put(propertyName, value);
	}
}
