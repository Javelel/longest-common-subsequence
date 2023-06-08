package pl.edu.pw.ee;

import org.junit.Assert;

import org.junit.Test;

public class LongestCommonSubsequenceTest {

	@Test
	public void testShouldReturnLCSOfTwoStrings() {
		// given
		String s1 = "kanapki";
		String s2 = "napisy";
		LongestCommonSubsequence instance = new LongestCommonSubsequence(s1, s2);

		// when
		String result = instance.findLCS();
		String expected = "napi";

		// then
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testShouldWorkWithWhiteSpaces() {
		// given
		String s1 = "\t\n\r\f\b\n\n\b";
		String s2 = "\t\n\r\f\b\t";
		LongestCommonSubsequence instance = new LongestCommonSubsequence(s1, s2);

		// when
		String result = instance.findLCS();
		String expected = "\t\n\r\f\b";

		// then
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testShouldWorkWhenOneOfGivenStringsIsEmpty() {
		// given
		String s1 = "";
		String s2 = "trollface";
		LongestCommonSubsequence instance = new LongestCommonSubsequence(s1, s2);

		// when
		String result = instance.findLCS();
		String expected = "";

		// then
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testShouldWorkWhenBothGivenStringsAreEmpty() {
		// given
		String s1 = "";
		String s2 = "";
		LongestCommonSubsequence instance = new LongestCommonSubsequence(s1, s2);

		// when
		String result = instance.findLCS();
		String expected = "";

		// then
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testShouldWorkWhenGivenStringsDontHaveLCS() {
		// given
		String s1 = "troll";
		String s2 = "face";
		LongestCommonSubsequence instance = new LongestCommonSubsequence(s1, s2);

		// when
		String result = instance.findLCS();
		String expected = "";

		// then
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testShouldWorkWhenGivenStringsAreTheSame() {
		// given
		String s1 = "code";
		LongestCommonSubsequence instance = new LongestCommonSubsequence(s1, s1);

		// when
		String result = instance.findLCS();
		String expected = s1;

		// then
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testShouldWorkWhenOneStringContainsTheOther() {
		// given
		String s1 = "impedancja";
		String s2 = "edanc";
		LongestCommonSubsequence instance = new LongestCommonSubsequence(s1, s2);

		// when
		String result = instance.findLCS();
		String expected = s2;

		// then
		Assert.assertEquals(expected, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testShouldThrowExceptionWhenOneOfTheArgumentsIsNull() {
		// given
		String s1 = null;
		String s2 = "Trollface";

		// when
		LongestCommonSubsequence instance = new LongestCommonSubsequence(s1, s2);
	}

	@Test(expected = IllegalStateException.class)
	public void testDisplayWithoutFindLCSMethod() {
		// given
		String s1 = "kanapki";
		String s2 = "napisy";
		LongestCommonSubsequence instance = new LongestCommonSubsequence(s1, s2);

		// when
		instance.display();

		// then
		assert true;
	}

	@Test
	public void testDisplay() {
		// given
		String s1 = "kanapki";
		String s2 = "napisy";
		LongestCommonSubsequence instance = new LongestCommonSubsequence(s1, s2);

		// when
		instance.findLCS();
		instance.display();

		// then
		assert true;
	}

}
