/**     
 * @�ļ�����: Test001.java  
 * @��·��: com.asiainfo  
 * @����: TODO  
 * @���ߣ����� 
 * @ʱ�䣺2018��10��12�� ����3:28:59  
 * @�汾��V1.0     
 */  
package com.asiainfo;

/**
 * @author cuipeng
 * @email cuipeng3@asiainfo.com
 * @date 2018��10��12�� ����3:28:59
 * @version 1.0
 * @description 
 */
public class Test001 {
	
	public static void main(String[] args) {
		//��ʼ�����ڴ�����С��
		Test001 test001 = new Test001();
		test001 = null;
		System.gc();//�ֶ�ִ������
		
	}
	
	/* 
	* <p>����: finalize</p>
	* <p>����: </p>
	* @throws Throwable
	* @see java.lang.Object#finalize()
	*/
	
	@Override
	protected void finalize() throws Throwable {
		//gc��������֮ǰ����
		System.out.println("gc��������....");
	}
	
	

}
