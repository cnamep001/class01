package com.m.reflect01;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Class01 {
	public static void main(String[] args) {
		
		try {
			
			
			
			
			
			
			Class clazz = Class.forName("com.m.reflect01.Student");
			Object obj = clazz.getConstructor().newInstance();
			Field field = clazz.getDeclaredField("id");
			Method method = clazz.getMethod("setId", field.getType());
			method.invoke(obj, 1);
			
			Method method2 = clazz.getMethod("getId");
			Integer id = (Integer)method2.invoke(obj);
			System.out.println(id);
			
			
			
			
			
			
			
			
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}
}
