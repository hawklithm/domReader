package org.hawklithm.domReader.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.hawklithm.domReader.classloader.MyClassLoader;

public class JavaReader {
	private MyClassLoader loader = new MyClassLoader();

	public List<File> getAllSubFile(File rootFile) {
		List<File> files = new ArrayList<File>();
		String[] filenames = rootFile.list();
		for (String index : filenames) {
			File f = new File(rootFile.getPath() + File.separatorChar + index);
			if (f.isDirectory()) {
				files.addAll(getAllSubFile(f));
			} else if (f.isFile() && index.endsWith(".class")) {
				files.add(f);
			}
		}
		return files;
	}

	public void readFolder(String folderName) {
		File file = new File(folderName);
		System.out.println(file.getPath());
		List<File> files = getAllSubFile(file);
		FileInputStream in = null;
		byte[] bs;
		int length;
		for (File index : files) {
			try {
				System.out.println(index.getName()+":");
				in = new FileInputStream(index);
				bs = new byte[in.available()];
				length = in.read(bs);
				Class<?> clazz=loader.loadClass(null,bs,length);
				Field[] fields=clazz.getDeclaredFields();
				for (Field field:fields){
					System.out.print(field.getName()+",");
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
