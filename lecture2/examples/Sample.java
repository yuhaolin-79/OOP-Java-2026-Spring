package examples;

import java.util.*;
import java.io.*;

// Sample的父类是Object
public class Sample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("input.txt"));
		String line = null;
		
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			System.out.println(line);			
		}
		
		/*
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		// Step 3. 通过对象引用调用类提供的方法
		String line = br.readLine();
		// 未初始化的对象为null
		while(line != null) {
			System.out.println(line);
			line = br.readLine();
		}
		
		br.close();
		*/
		
		/*
		// Step 2. 创建对象
		FileReader fr = new FileReader("input.txt");
		// Step 3. 通过对象引用调用类提供的方法
		int v = fr.read();
		
		while(v != -1) {
			System.out.print((char)v);
			v = fr.read();
		}
		System.out.println();
		
		fr.close();
		*/
		
		
		/*
		// Step 2. 创建对象，对于集合类(Collections)需要限定元素类型(模板)
		// v: Object Reference对象引用
		Vector<String> v = new Vector<String>();
		
		// Step 3. 通过对象引用调用类提供的方法
		v.add("One");
		v.add("Two");
		
		System.out.println(v);
		
		// Garbage Collection 垃圾自动回收 JVM虚机
	
	    */
	}

}

