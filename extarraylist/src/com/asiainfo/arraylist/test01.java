/**     
 * @文件名称: test01.java  
 * @类路径: com.asiainfo.arraylist  
 * @描述: TODO  
 * @作者：崔鹏 
 * @时间：2019年1月10日 下午2:51:22  
 * @版本：V1.0     
 */  
package com.asiainfo.arraylist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cuipeng
 * @email cuipeng3@asiainfo.com
 * @date 2019年1月10日 下午2:51:22
 * @version 1.0
 * @description 
 */
public class test01 {
	public static void main(String[] args) {
		
		Map IdleData = new HashMap();
		IdleData.put("RES_STATE", "1");
		if(!"1".equals(IdleData.get("RES_STATE"))&&!"6".equals(IdleData.get("RES_STATE"))){
				System.out.println("進入方法");
		} else {
			System.out.println("測試");
		}
		
	}
}
