/**     
 * @文件名称: User.java  
 * @类路径: com.asiainfo.entity  
 * @描述: TODO  
 * @作者：崔鹏 
 * @时间：2018年10月28日 上午9:03:27  
 * @版本：V1.0     
 */  
package com.asiainfo.entity;

/**
 * @author cuipeng
 * @email cuipeng3@asiainfo.com
 * @date 2018年10月28日 上午9:03:27
 * @version 1.0
 * @description 
 */
public class User {
	private int id;
	private String name;
	private int age;
    //get,set方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	
}
