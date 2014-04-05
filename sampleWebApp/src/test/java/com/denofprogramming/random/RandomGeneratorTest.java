package com.denofprogramming.random;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class RandomGeneratorTest
{

    private RandomGenerator randomGenerator;

    @Before
    public void setUp()
    {
	randomGenerator = new DefaultRandomGenerator();
    }

    @After
    public void after()
    {
	randomGenerator = null;
    }

    @Test
    public void testName()
    {
	Assert.assertSame("Name is not the same as expected: ", "Default Randon Number Generator", randomGenerator.name());
    }

    @Test
    public void testRandomGenerator()
    {
	int generatedInt = randomGenerator.generate();
	assertTrue("Generated int was not between 5 and 10: ", generatedInt >= 5 && generatedInt <= 10);
    }

}
