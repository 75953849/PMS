package com.tyut.test;


public class PTest {
	public static void main(String[] args) {
		/* Properties prop = new Properties();     
	        try{
	            //读取属性文件a.properties
	      
	        	///PMS0.1/config/ptext.properties
	            InputStream in = new BufferedInputStream (new FileInputStream("./config/ptext.properties"));
	            prop.load(in);     ///加载属性列表
	            Iterator<String> it=prop.stringPropertyNames().iterator();
	            while(it.hasNext()){
	                String key=it.next();
	                System.out.println(key+":"+prop.getProperty(key));
	            }
	            in.close();
	            
	            ///保存属性到b.properties文件
	            FileOutputStream oFile = new FileOutputStream("./config/ptext.properties", false);//true表示追加打开
	            prop.setProperty("am_work_hour", "3");
	            prop.store(oFile, "");
	            oFile.close();
	        }
	        catch(Exception e){
	            System.out.println(e);
	        }*/
		
		
		
		System.out.println(PropertiesTest.getValue("am_work_hour"));
		PropertiesTest.setValue("am_work_hour", "8");
	    } 
}
