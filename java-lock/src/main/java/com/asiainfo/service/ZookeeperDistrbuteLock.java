/**     
 * @文件名称: ZookeeperDistrbuteLock.java  
 * @类路径: com.asiainfo.service  
 * @描述: TODO  
 * @作者：崔鹏 
 * @时间：2018年11月16日 上午9:20:40  
 * @版本：V1.0     
 */  
package com.asiainfo.service;

import java.util.concurrent.CountDownLatch;

import org.I0Itec.zkclient.IZkDataListener;

/**
 * @author cuipeng
 * @email cuipeng3@asiainfo.com
 * @date 2018年11月16日 上午9:20:40
 * @version 1.0
 * @description 
 */
public class ZookeeperDistrbuteLock extends ZookeeperAbstractLock{

	
	private CountDownLatch countDownLatch = null;
	/* 
	* <p>标题: tryLock</p>
	* <p>描述: </p>
	* @return
	* @see com.asiainfo.service.ZookeeperAbstractLock#tryLock()
	*/
	
	@Override
	Boolean tryLock() {
		try {
			zkClient.createEphemeral(PATH);
			return true;
		} catch (Exception e) {
//			e.printStackTrace();
			return false;
		}

	}

	/* 
	* <p>标题: waitLock</p>
	* <p>描述: </p>
	* @return
	* @see com.asiainfo.service.ZookeeperAbstractLock#waitLock()
	*/
	
	@Override
	void waitLock() {
		
		if (zkClient.exists(PATH)) {
			//创建信号量
			countDownLatch = new CountDownLatch(1);
			try {
				countDownLatch.await();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
		//使用事件监听
		IZkDataListener iZkDataListener = new IZkDataListener() {
			
			@Override
			public void handleDataDeleted(String arg0) throws Exception {
				// TODO Auto-generated method stub
				//唤醒wait
				if (countDownLatch != null) {
					countDownLatch.countDown();
				}	

			}
			
			@Override
			public void handleDataChange(String arg0, Object arg1) throws Exception {
				// TODO Auto-generated method stub
				
			}
		};
		
		// 注册事件
		zkClient.subscribeDataChanges(PATH, iZkDataListener);
		if (zkClient.exists(PATH)) {
			countDownLatch = new CountDownLatch(1);
			try {
				countDownLatch.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 删除监听
		zkClient.unsubscribeDataChanges(PATH, iZkDataListener);

	}

}
