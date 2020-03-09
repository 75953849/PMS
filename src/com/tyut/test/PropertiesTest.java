package com.tyut.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	 public static Properties getProperties(){
		 	Properties properties = new Properties();
	        try {
	        	
				BufferedInputStream in = new BufferedInputStream(new FileInputStream("./config/ptext.properties"));
				properties.load(in);
				in.close();
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
	        return properties;
	 }

	    /**
	     * 根据key查询value值
	     * @param key key
	     * @return
	     */
	    public static String getValue(String key){
	        Properties properties = getProperties();
	        String value = properties.getProperty(key);
	        return value;
	    }

	    /**
	     * 新增/修改数据
	     * @param key 
	     * @param value
	     */
	    public static void setValue(String key, String value){
	        Properties properties = getProperties();
	        properties.setProperty(key, value);
	 
	        String path = "./config/ptext.properties";
	        try {
	        	FileOutputStream fileOutputStream = new FileOutputStream(path);
	            properties.store(fileOutputStream, "");
	            fileOutputStream.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } 
	        
	    }

	    /**
	     * 删除和修改只有语句不同
	     * properties.remove(key);
	     */
	}

