/**
 * 
 */
package com.denofprogramming.random;

import org.apache.commons.math3.random.RandomDataGenerator;

/**
 *
 *
 */
public class DefaultRandomGenerator implements RandomGenerator
{

    public String name()
    {
	return "Default Randon Number Generator";
    }

    public int generate()
    {
	final RandomDataGenerator aRandomDataGenerator = new RandomDataGenerator();
	return aRandomDataGenerator.nextInt(5, 10);
    }

}
