package com.ozduman.analyses.tests;

import com.ozduman.analyses.OneTimePadding;
import com.ozduman.analyses.tests.interfaces.CipherTest;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * Tests for One Time Padding.
 * 
 * @author haluk
 *
 */
public class OneTimePaddingTest implements CipherTest {

	OneTimePadding oneTimePadding = new OneTimePadding();
	@Test
	public void testGetEncryptedText() {
		Assert.assertEquals("aednk", oneTimePadding.getEncryptedText("haluk", "test"));
		Assert.assertEquals("haluk", oneTimePadding.getEncryptedText("haluk", ""));
		Assert.assertEquals("", oneTimePadding.getEncryptedText("", "haluk"));
		Assert.assertEquals("mlalbwshnetimepadding", oneTimePadding.getEncryptedText("thisisaonetimepadding", "testtest"));
		Assert.assertEquals("mlalbwshgilbmepadding", oneTimePadding.getEncryptedText("thisisaonetimepadding", "testtesttest"));
		Assert.assertEquals("mlalbwshgilbfihtdding", oneTimePadding.getEncryptedText("thisisaonetimepadding", "testtesttesttest"));
		Assert.assertEquals("mlalbwshgilbfihtwhagg", oneTimePadding.getEncryptedText("thisisaonetimepadding", "testtesttesttesttest"));
		Assert.assertEquals("mlalbwshgilbfihtwhagz", oneTimePadding.getEncryptedText("thisisaonetimepadding", "testtesttesttesttesttest"));
	}
	
	@Test
	public void testGetDecryptedText() {
		Assert.assertEquals("haluk", oneTimePadding.getDecryptedText("aednk", "test"));
		Assert.assertEquals("haluk", oneTimePadding.getDecryptedText("haluk", ""));
		Assert.assertEquals("", oneTimePadding.getDecryptedText("", "haluk"));
		Assert.assertEquals("thisisaonetimepadding", oneTimePadding.getDecryptedText("mlalbwshnetimepadding", "testtest"));
		Assert.assertEquals("thisisaonetimepadding", oneTimePadding.getDecryptedText("mlalbwshgilbmepadding", "testtesttest"));
		Assert.assertEquals("thisisaonetimepadding", oneTimePadding.getDecryptedText("mlalbwshgilbfihtdding", "testtesttesttest"));
		Assert.assertEquals("thisisaonetimepadding", oneTimePadding.getDecryptedText("mlalbwshgilbfihtwhagg", "testtesttesttesttest"));
		Assert.assertEquals("thisisaonetimepadding", oneTimePadding.getDecryptedText("mlalbwshgilbfihtwhagz", "testtesttesttesttesttest"));
	}
}
