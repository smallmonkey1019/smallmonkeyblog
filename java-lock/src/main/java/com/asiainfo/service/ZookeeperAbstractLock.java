/**     
 * @�ļ�����: ZookeeperAbstractLock.java  
 * @��·��: com.asiainfo.service  
 * @����: TODO  
 * @���ߣ����� 
 * @ʱ�䣺2018��11��16�� ����9:11:47  
 * @�汾��V1.0     
 */  
package com.asiainfo.service;

import org.I0Itec.zkclient.ZkClient;

/**
 * �ع��ظ�����
 * @author cuipeng
 * @email cuipeng3@asiainfo.com
 * @date 2018��11��16�� ����9:11:47
 * @version 1.0
 * @description 
 */
public abstract class ZookeeperAbstractLock implements Lock {

	// zk���ӵ�ַ
	private static final String CONNECTSTRING = "127.0.0.1:2181";
	// ����zk����
	protected ZkClient zkClient = new ZkClient(CONNECTSTRING);
	protected static final String PATH = "/lock";

	/* 
	* <p>����: getLock</p>
	* <p>����: </p>
	* @see com.asiainfo.service.Lock#getLock()
	*/
	
	@Override
	public void getLock() {
		// TODO Auto-generated method stub
		if (tryLock()) {
			System.out.println("��ȡ���ɹ�.....");
		} else {
			//�ȴ�
			waitLock();
			//���»�ȡ��
			getLock();
		}
	}
	
	//�Ƿ��ȡ���ɹ�  �ɹ�����true
	abstract Boolean tryLock();
	
	abstract void waitLock();

	/* 
	* <p>����: unLock</p>
	* <p>����: </p>
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
