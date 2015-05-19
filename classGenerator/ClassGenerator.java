/*
Thinking in Java page:364
类生成器
*/

import java.io.*;
import java.util.*;


interface Generator<T> { T next(); }

public class ClassGenerator<T> implements Generator<T> {

	private Class<T> classType;

	public ClassGenerator( Class<T> type) {
		this.classType = type;
	}

	public T next() {
		try{
			return classType.newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public static <T> Generator<T> register(Class<T> classType ) {
		return new ClassGenerator<T>(classType);
	}
}
