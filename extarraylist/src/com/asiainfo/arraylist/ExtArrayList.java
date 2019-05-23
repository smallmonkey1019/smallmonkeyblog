/**     
 * @文件名称: ExtArrayList.java  
 * @类路径: com.asiainfo.arraylist  
 * @描述: TODO  
 * @作者：崔鹏 
 * @时间：2019年1月7日 下午9:13:50  
 * @版本：V1.0     
 */  
package com.asiainfo.arraylist;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author cuipeng
 * @email cuipeng3@asiainfo.com
 * @date 2019年1月7日 下午9:13:50
 * @version 1.0
 * @param <E>
 * @description 
 */
public class ExtArrayList<E> implements ExtList<E>{
	
	//1、定义一个数组
	private Object[] elementData;
	
	private int size;
	//定义初始化数组容量
	private static final int DEFAULT_CAPACITY = 10;
	
	//2.创建构造函数
	public ExtArrayList(int initialCapacity) {
		
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("数组初始化长度过小"+
                    initialCapacity);
		}
		this.elementData = new Object[initialCapacity];
	}
	
	public ExtArrayList() {
		this.elementData = new Object[DEFAULT_CAPACITY];
	}
	
	//3.Add方法
	/**
	 * 添加元素
	 * @author cuipeng
	 * @email cuipeng3@asiainfo.com
	 * @date 2019年1月7日 下午9:30:04
	 * @version 1.0
	 * @description 
	 * @param object
	 */
	public void add(E e) {
		ensureExplicitCapacity(size + 1);
		elementData[size++] = e;
		
	}
	
	/**
	 * 添加元素
	 * @author cuipeng
	 * @email cuipeng3@asiainfo.com
	 * @date 2019年1月7日 下午9:30:04
	 * @version 1.0
	 * @description 
	 * @param object
	 */
	public void add(int index,Object object) {
		rangeCheck(index);
		ensureExplicitCapacity(size + 1);
		System.arraycopy(elementData, index, elementData, index + 1,
                  size - index);
		elementData[index] = object;
		size++;
	}
	
	/**
	 * 删除元素
	 * @author cuipeng
	 * @email cuipeng3@asiainfo.com
	 * @date 2019年1月7日 下午9:53:09
	 * @version 1.0
	 * @description 
	 */
	private Object remove(int index) {
		// TODO Auto-generated method stub
		rangeCheck(index);
		Object object = get(index);
		//删除原理分析
		//计算删除元素后面的长度
		int numMoved = elementData.length - index - 1;
		if (numMoved > 0)
	            System.arraycopy(elementData, index+1, elementData, index,
	                             numMoved);
		return this.elementData[--size] = null;
		
	}
	
	/**
	 * 删除元素，删除元素相同元素删除第一个
	 * @author cuipeng
	 * @email cuipeng3@asiainfo.com
	 * @date 2019年1月7日 下午10:10:12
	 * @version 1.0
	 * @description 
	 */
	private boolean remove(Object object) {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.elementData.length; i++) {
			Object value = elementData[i];
			if (value.equals(object)) {
				remove(i);
				return true;
			}
		}
		return false;
	}
	/**
	 * 获取元素
	 * @author cuipeng
	 * @email cuipeng3@asiainfo.com
	 * @date 2019年1月7日 下午9:28:37
	 * @version 1.0
	 * @description 
	 */
	public Object get(int index) {
		// TODO Auto-generated method stub
		rangeCheck(index);
		if (size == 0) {
			throw new NullPointerException("空指针异常了！");
		}
		return this.elementData[index];
	}
	
	/**
	 * 数组越界
	 * @author cuipeng
	 * @email cuipeng3@asiainfo.com
	 * @date 2019年1月7日 下午9:30:22
	 * @version 1.0
	 * @description 
	 */
	private void rangeCheck(int index) {
		// TODO Auto-generated method stub
		if (index - size >= 0) {
			throw new IndexOutOfBoundsException("数组越界啦");
		}
	}
	
	/**
	 * 数组扩容
	 * @author cuipeng
	 * @email cuipeng3@asiainfo.com
	 * @date 2019年1月7日 下午9:43:33
	 * @version 1.0
	 * @description 
	 */
	private void ensureExplicitCapacity(int minCapacity) {
		// TODO Auto-generated method stub
		if (size == elementData.length) {
			//扩容 2*size
			int oldCapacity = elementData.length;
		    int newCapacity = oldCapacity + (oldCapacity >> 1);
		    //若初始容量为1 时，扩容到2
		    if (newCapacity - minCapacity < 0)
	            newCapacity = minCapacity;
		    
			this.elementData = Arrays.copyOf(this.elementData, newCapacity);
			
		} 
	}
	
	/**
	 * 返回长度
	 * @author cuipeng
	 * @email cuipeng3@asiainfo.com
	 * @date 2019年1月7日 下午9:51:21
	 * @version 1.0
	 * @description 
	 * @return
	 */
	public int size() {
        return size;
    }

}
