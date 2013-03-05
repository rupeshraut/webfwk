package com.dev.zkshowcase.testcase;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.Assert.*;

/**
 * The Class Test.
 */
public class TestCase {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(TestCase.class);

	/**
	 * Test log4j2.
	 */
	@org.junit.Test
	public void testLog4j2() {
		LOGGER.info("Today is {}", new Date());
		fail("invalid testcase");
	}
}
