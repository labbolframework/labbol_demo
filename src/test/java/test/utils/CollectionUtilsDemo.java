package test.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

public class CollectionUtilsDemo {

	@Test
	public void isEmpty() {
		System.out.println(CollectionUtils.isEmpty(null));
		System.out.println(CollectionUtils.isEmpty(new ArrayList<>()));
		System.out.println(CollectionUtils.isEmpty(Collections.emptyList()));
	}

	@Test
	public List<?> emptyList(){
		return Collections.emptyList();
	}
	
}
