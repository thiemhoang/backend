package com.example.demo.util;

import java.util.Date;

import org.junit.Test;

import com.example.demo.util.DateUtils;

import org.junit.Assert;

public class DateUtilTest {

	@Test
	public void testParseDate() {
		Date date = DateUtils.parseDate("2017-10-22T12:30:32Z");
		Assert.assertNotNull(date);
	}
}
