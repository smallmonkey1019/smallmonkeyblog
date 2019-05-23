package com.asiainfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;

public class Vector {

	public static void main(String[] args) {
		/*java.util.Vector<Object> vector = new java.util.Vector<Object>();
		vector.add();
		ArrayList<Object> arrayList = new ArrayList<Object>();
		arrayList.add(e)*/
		Hashtable<String, Object> hashtable =  new Hashtable<>();	
		HashMap<String, Object> hashMap = new HashMap<>();
		hashtable.put("", "");
//		hashMap.put(key, value);
//		hashtable.get(key)
		Collections.synchronizedMap(hashMap);
		
	}
}
