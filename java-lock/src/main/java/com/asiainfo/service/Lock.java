/**     
 * @�ļ�����: Lock.java  
 * @��·��: com.asiainfo.service  
 * @����: TODO  
 * @���ߣ����� 
 * @ʱ�䣺2018��11��16�� ����9:09:50  
 * @�汾��V1.0     
 */  
package com.asiainfo.service;

/**
 * ����ķֲ�ʽ��
 * @author cuipeng
 * @email cuipeng3@asiainfo.com
 * @date 2018��11��16�� ����9:09:50
 * @version 1.0
 * @description 
 */
public interface Lock {

	/**
	 * ��ȡ��
	 * @author cuipeng
	 * @email cuipeng3@asiainfo.com
	 * @date 2018��11��16�� ����9:10:57
	 * @version 1.0
	 * @description
	 */
	public void getLock();
	/**
	 * �ͷ���
	 * @author cuipeng
	 * @email cuipeng3@asiainfo.com
	 * @date 2018��11��16�� ����9:10:49
	 * @version 1.0
	 * @description
	 */
	public void unLock();
	
}
