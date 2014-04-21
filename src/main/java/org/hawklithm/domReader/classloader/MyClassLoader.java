package org.hawklithm.domReader.classloader;

public class MyClassLoader extends ClassLoader {
	@SuppressWarnings("unchecked")
	public Class loadClass(String name,byte[] bs,int length){
		return super.defineClass(name,bs, 0, length);
	}
}

