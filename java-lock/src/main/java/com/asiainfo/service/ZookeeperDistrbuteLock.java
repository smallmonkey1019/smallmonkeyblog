/**     
 * @�ļ�����: ZookeeperDistrbuteLock.java  
 * @��·��: com.asiainfo.service  
 * @����: TODO  
 * @���ߣ����� 
 * @ʱ�䣺2018��11��16�� ����9:20:40  
 * @�汾��V1.0     
 */  
package com.asiainfo.service;

import java.util.concurrent.CountDownLatch;

import org.I0Itec.zkclient.IZkDataListener;

/**
 * @author cuipeng
 * @email cuipeng3@asiainfo.com
 * @date 2018��11��16�� ����9:20:40
 * @version 1.0
 * @description 
 */
public class ZookeeperDistrbuteLock extends ZookeeperAbstractLock{

	
	private CountDownLatch countDownLatch = null;
	/* 
	* <p>����: tryLock</p>
	* <p>����: </p>
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
	* <p>����: waitLock</p>
	* <p>����: </p>
	* @return
	* @see com.asiainfo.service.ZookeeperAbstractLock#waitLock()
	*/
	
	@Override
	void waitLock() {
		
		if (zkClient.exists(PATH)) {
			//�����ź���
			countDownLatch = new CountDownLatch(1);
			try {
				countDownLatch.await();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
		//ʹ���¼�����
		IZkDataListener iZkDataListener = new IZkDataListener() {
			
			@Override
			public void handleDataDeleted(String arg0) throws Exception {
				// TODO Auto-generated method stub
				//����wait
				if (countDownLatch != null) {
					countDownLatch.countDown();
				}	

			}
			
			@Override
			public void handleDataChange(String arg0, Object arg1) throws Exception {
				// TODO Auto-generated method stub
				
			}
		};
		
		// ע���¼�
		zkClient.subscribeDataChanges(PATH, iZkDataListener);
		if (zkClient.exists(PATH)) {
			countDownLatch = new CountDownLatch(1);
			try {
				countDownLatch.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ɾ������
		zkClient.unsubscribeDataChanges(PATH, iZkDataListener);

	}

}
