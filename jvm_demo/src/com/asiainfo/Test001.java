/**     
 * @文件名称: Test001.java  
 * @类路径: com.asiainfo  
 * @描述: TODO  
 * @作者：崔鹏 
 * @时间：2018年10月12日 下午3:28:59  
 * @版本：V1.0     
 */  
package com.asiainfo;

/**
 * @author cuipeng
 * @email cuipeng3@asiainfo.com
 * @date 2018年10月12日 下午3:28:59
 * @version 1.0
 * @description 
 */
public class Test001 {
	
	public static void main(String[] args) {
		//初始化堆内存设置小点
		Test001 test001 = new Test001();
		test001 = null;
		System.gc();//手动执行垃圾
		
	}
	
	/* 
	* <p>标题: finalize</p>
	* <p>描述: </p>
	* @throws Throwable
	* @see java.lang.Object#finalize()
	*/
	
	@Override
	protected void finalize() throws Throwable {
		//gc回收垃圾之前调用
		System.out.println("gc回收垃圾....");
	}
	
	

}
