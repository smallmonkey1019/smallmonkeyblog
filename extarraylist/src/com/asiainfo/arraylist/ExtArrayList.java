/**     
 * @�ļ�����: ExtArrayList.java  
 * @��·��: com.asiainfo.arraylist  
 * @����: TODO  
 * @���ߣ����� 
 * @ʱ�䣺2019��1��7�� ����9:13:50  
 * @�汾��V1.0     
 */  
package com.asiainfo.arraylist;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author cuipeng
 * @email cuipeng3@asiainfo.com
 * @date 2019��1��7�� ����9:13:50
 * @version 1.0
 * @param <E>
 * @description 
 */
public class ExtArrayList<E> implements ExtList<E>{
	
	//1������һ������
	private Object[] elementData;
	
	private int size;
	//�����ʼ����������
	private static final int DEFAULT_CAPACITY = 10;
	
	//2.�������캯��
	public ExtArrayList(int initialCapacity) {
		
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("�����ʼ�����ȹ�С"+
                    initialCapacity);
		}
		this.elementData = new Object[initialCapacity];
	}
	
	public ExtArrayList() {
		this.elementData = new Object[DEFAULT_CAPACITY];
	}
	
	//3.Add����
	/**
	 * ���Ԫ��
	 * @author cuipeng
	 * @email cuipeng3@asiainfo.com
	 * @date 2019��1��7�� ����9:30:04
	 * @version 1.0
	 * @description 
	 * @param object
	 */
	public void add(E e) {
		ensureExplicitCapacity(size + 1);
		elementData[size++] = e;
		
	}
	
	/**
	 * ���Ԫ��
	 * @author cuipeng
	 * @email cuipeng3@asiainfo.com
	 * @date 2019��1��7�� ����9:30:04
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
	 * ɾ��Ԫ��
	 * @author cuipeng
	 * @email cuipeng3@asiainfo.com
	 * @date 2019��1��7�� ����9:53:09
	 * @version 1.0
	 * @description 
	 */
	private Object remove(int index) {
		// TODO Auto-generated method stub
		rangeCheck(index);
		Object object = get(index);
		//ɾ��ԭ�����
		//����ɾ��Ԫ�غ���ĳ���
		int numMoved = elementData.length - index - 1;
		if (numMoved > 0)
	            System.arraycopy(elementData, index+1, elementData, index,
	                             numMoved);
		return this.elementData[--size] = null;
		
	}
	
	/**
	 * ɾ��Ԫ�أ�ɾ��Ԫ����ͬԪ��ɾ����һ��
	 * @author cuipeng
	 * @email cuipeng3@asiainfo.com
	 * @date 2019��1��7�� ����10:10:12
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
	 * ��ȡԪ��
	 * @author cuipeng
	 * @email cuipeng3@asiainfo.com
	 * @date 2019��1��7�� ����9:28:37
	 * @version 1.0
	 * @description 
	 */
	public Object get(int index) {
		// TODO Auto-generated method stub
		rangeCheck(index);
		if (size == 0) {
			throw new NullPointerException("��ָ���쳣�ˣ�");
		}
		return this.elementData[index];
	}
	
	/**
	 * ����Խ��
	 * @author cuipeng
	 * @email cuipeng3@asiainfo.com
	 * @date 2019��1��7�� ����9:30:22
	 * @version 1.0
	 * @description 
	 */
	private void rangeCheck(int index) {
		// TODO Auto-generated method stub
		if (index - size >= 0) {
			throw new IndexOutOfBoundsException("����Խ����");
		}
	}
	
	/**
	 * ��������
	 * @author cuipeng
	 * @email cuipeng3@asiainfo.com
	 * @date 2019��1��7�� ����9:43:33
	 * @version 1.0
	 * @description 
	 */
	private void ensureExplicitCapacity(int minCapacity) {
		// TODO Auto-generated method stub
		if (size == elementData.length) {
			//���� 2*size
			int oldCapacity = elementData.length;
		    int newCapacity = oldCapacity + (oldCapacity >> 1);
		    //����ʼ����Ϊ1 ʱ�����ݵ�2
		    if (newCapacity - minCapacity < 0)
	            newCapacity = minCapacity;
		    
			this.elementData = Arrays.copyOf(this.elementData, newCapacity);
			
		} 
	}
	
	/**
	 * ���س���
	 * @author cuipeng
	 * @email cuipeng3@asiainfo.com
	 * @date 2019��1��7�� ����9:51:21
	 * @version 1.0
	 * @description 
	 * @return
	 */
	public int size() {
        return size;
    }

}
