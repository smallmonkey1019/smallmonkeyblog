/**     
 * @文件名称: OrderNumGenerator.java  
 * @类路径: com.asiainfo  
 * @描述: TODO  
 * @作者：崔鹏 
 * @时间：2018年11月14日 下午4:14:48  
 * @版本：V1.0     
 */
package com.asiainfo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cuipeng
 * @email cuipeng3@asiainfo.com
 * @date 2018年11月14日 下午4:14:48
 * @version 1.0
 * @description
 */
public class OrderNumGenerator {
	// 全局订单id
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
