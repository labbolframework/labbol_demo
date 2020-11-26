package test.utils;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.yelong.commons.io.FileUtilsE;

public class FileUtilsEDemo {

	@Test
	public void createNewFileOverride() throws IOException {
		FileUtilsE.createNewFileOverride("M:", "temp", "demo.txt");
	}

	@Test
	public void delete() {
		FileUtilsE.deleteQuietly(FileUtilsE.getFile("M:", "temp", "demo.txt"));
	}

}
