package demo;

import java.io.IOException;

import org.yelong.commons.io.FileUtilsE;

public class Main {

	public void test() {
		
		
		try {
			FileUtilsE.createDirectoryOverride("M:", "demo.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
