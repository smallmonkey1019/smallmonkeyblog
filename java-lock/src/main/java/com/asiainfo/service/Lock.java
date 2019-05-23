/**     
 * @文件名称: Lock.java  
 * @类路径: com.asiainfo.service  
 * @描述: TODO  
 * @作者：崔鹏 
 * @时间：2018年11月16日 上午9:09:50  
 * @版本：V1.0     
 */  
package com.asiainfo.service;

/**
 * 定义的分布式锁
 * @author cuipeng
 * @email cuipeng3@asiainfo.com
 * @date 2018年11月16日 上午9:09:50
 * @version 1.0
 * @description 
 */
public interface Lock {

	/**
	 * 获取锁
	 * @author cuipeng
	 * @email cuipeng3@asiainfo.com
	 * @date 2018年11月16日 上午9:10:57
	 * @version 1.0
	 * @description
	 */
	public void getLock();
	/**
	 * 释放锁
	 * @author cuipeng
	 * @email cuipeng3@asiainfo.com
	 * @date 2018年11月16日 上午9:10:49
	 * @version 1.0
	 * @description
	 */
	public void unLock();
	
}
