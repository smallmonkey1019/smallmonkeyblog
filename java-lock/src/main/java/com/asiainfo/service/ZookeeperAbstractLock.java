/**     
 * @文件名称: ZookeeperAbstractLock.java  
 * @类路径: com.asiainfo.service  
 * @描述: TODO  
 * @作者：崔鹏 
 * @时间：2018年11月16日 上午9:11:47  
 * @版本：V1.0     
 */  
package com.asiainfo.service;

import org.I0Itec.zkclient.ZkClient;

/**
 * 重构重复代码
 * @author cuipeng
 * @email cuipeng3@asiainfo.com
 * @date 2018年11月16日 上午9:11:47
 * @version 1.0
 * @description 
 */
public abstract class ZookeeperAbstractLock implements Lock {

	// zk连接地址
	private static final String CONNECTSTRING = "127.0.0.1:2181";
	// 创建zk连接
	protected ZkClient zkClient = new ZkClient(CONNECTSTRING);
	protected static final String PATH = "/lock";

	/* 
	* <p>标题: getLock</p>
	* <p>描述: </p>
	* @see com.asiainfo.service.Lock#getLock()
	*/
	
	@Override
	public void getLock() {
		// TODO Auto-generated method stub
		if (tryLock()) {
			System.out.println("获取锁成功.....");
		} else {
			//等待
			waitLock();
			//重新获取锁
			getLock();
		}
	}
	
	//是否获取锁成功  成功返回true
	abstract Boolean tryLock();
	
	abstract void waitLock();

	/* 
	* <p>标题: unLock</p>
	* <p>描述: </p>
	* @see com.asiainfo.service.Lock#unLock()
	*/
	
	@Override
	public void unLock() {
		// TODO Auto-generated method stub
		if (zkClient != null) {
			zkClient.close();
		}
	}

}
