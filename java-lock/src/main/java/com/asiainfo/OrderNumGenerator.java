/**     
 * @�ļ�����: OrderNumGenerator.java  
 * @��·��: com.asiainfo  
 * @����: TODO  
 * @���ߣ����� 
 * @ʱ�䣺2018��11��14�� ����4:14:48  
 * @�汾��V1.0     
 */
package com.asiainfo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cuipeng
 * @email cuipeng3@asiainfo.com
 * @date 2018��11��14�� ����4:14:48
 * @version 1.0
 * @description
 */
public class OrderNumGenerator {
	// ȫ�ֶ���id
	public static int count = 0;

	public String getNumber() {
		try {
			Thread.sleep(200);
		} catch (Exception e) {
		}
		SimpleDateFormat simpt = new SimpleDateFormat("yyyyMMddHHmmss");
		return simpt.format(new Date()) + "-" + ++count;
	}

}
