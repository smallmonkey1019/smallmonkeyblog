package com.asiainfo;

class ResNumber{
	
	public Integer count = 0;
	
	public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
	
	
	public String getNumber() {
		count = threadLocal.get()+1;
		threadLocal.set(count);
		return count+"";
	}
}

class ThreadLocaDemo extends Thread {
	
	public ResNumber res;
	public ThreadLocaDemo(ResNumber res){
		this.res = res;
	}
	@Override
	public void run() {
		
		for (int i = 0; i < 30; i++) {
			System.out.println(getName()+","+res.getNumber());
		}
	}
}

public class ThreadLocaDemo01 {
	public static void main(String[] args) {
		ResNumber res = new ResNumber();
		ThreadLocaDemo t1 = new ThreadLocaDemo(res);
		ThreadLocaDemo t2 = new ThreadLocaDemo(res);
		ThreadLocaDemo t3 = new ThreadLocaDemo(res);
		t1.start();
		t2.start();
		t3.start();
	}
}
