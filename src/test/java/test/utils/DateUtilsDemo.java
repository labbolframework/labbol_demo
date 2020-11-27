package test.utils;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;
import org.yelong.commons.util.Dates;

public class DateUtilsDemo {

	@Test
	public void parseDate() throws ParseException {
		Date date = DateUtils.parseDate("2020-01-01", Dates.YYYY_MM_DD_HH_MM_SS, Dates.YYYY_MM_DD_BAR);
		System.out.println(DateFormatUtils.format(date, Dates.YYYY_MM_DD_HH_MM_SS));
	}

}
