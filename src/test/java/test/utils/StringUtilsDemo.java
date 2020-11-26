package test.utils;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.yelong.commons.lang.Strings;

public class StringUtilsDemo {

	@Test
	public void isBlank() {
		System.out.println(StringUtils.isBlank("  "));
	}

	@Test
	public void isEmpty() {
		System.out.println(StringUtils.isEmpty(""));
	}

	@Test
	public void isNullOrBlank() {
		Object str = (String) null;
		System.out.println(Strings.isNullOrBlank(str));
	}

}
