/**     
 * @�ļ�����: test01.java  
 * @��·��: com.asiainfo.arraylist  
 * @����: TODO  
 * @���ߣ����� 
 * @ʱ�䣺2019��1��10�� ����2:51:22  
 * @�汾��V1.0     
 */  
package com.asiainfo.arraylist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cuipeng
 * @email cuipeng3@asiainfo.com
 * @date 2019��1��10�� ����2:51:22
 * @version 1.0
 * @description 
 */
public class test01 {
	public static void main(String[] args) {
		
		Map IdleData = new HashMap();
		IdleData.put("RES_STATE", "1");
		if(!"1".equals(IdleData.get("RES_STATE"))&&!"6".equals(IdleData.get("RES_STATE"))){
				System.out.println("�M�뷽��");
		} else {
			System.out.println("�yԇ");
		}
		
	}
}
