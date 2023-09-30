package com.CRM.VTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class consist of generic method to fetch the data from property file
 * @author Debasish
 *
 */

public class Fileutility {
	/**
	 * This method help us to fetch the data from property file
	 * @Debasish
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	
	public String getdataFromPropertyFile(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(Ipathconstant.propertyfilepath);
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}

}
