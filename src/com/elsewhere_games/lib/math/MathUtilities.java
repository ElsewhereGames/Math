package com.elsewhere_games.lib.math;


/**
 * <p>Various math utility methods and constants are provided which will 
 * enhance the features already found in {@link java.lang.Math}.</p>
 * 
 * @author Hans Pragt
 *
 */

public class MathUtilities {

	/**
	 * <p>Clamps the <code>value</code> between the specified <code>minimum</code>
	 * and <code>maximum</code>.</p>
	 * 
	 * @param value The value to clamp between the <code>minimum</code> and 
	 * <code>maximum</code>.
	 * @param minimum The minimum value returned.
	 * @param maximum The maximum value returned.
	 * @return The specified <code>minimum</code> if the <code>value</code> is less
	 * than this value, the specified <code>maximum</code> if the <code>value</code>
	 * is greater than this value, <code>value</code> otherwise.
	 */
	public static float clamp(float value, float minimum, float maximum) {
		float result = value;
		
		result = Math.max(minimum, result);
		result = Math.min(maximum, result);
		
		return result;
	}
	
	/**
	 * <p>Checks the first floating point value against the second. If the absolute
	 * difference of the two is less than epsilon (as defined in MathUtilities), the
	 * two values are considered to be equal.</p>
	 *  
	 * @param value1 The first value to compare.
	 * @param value2 The second value to compare.
	 * 
	 * @return <code>true</code> if the values are relatively equal, <code>false</code>
	 * otherwise.
	 */
	public static boolean isEqual(final float value1, final float value2) {
		return (Math.abs(value1 - value2) < MathUtilities.EPSILON);
	}
	
	/*
	 * Mathematical Constants
	 */
	
	/**
	 * <p>When comparing two floating point values, epsilon is used a margin of
	 * error. In other words, <code>1 + EPSILON == 1</code>.</p>
	 */
	public static final float EPSILON = 0.0000001f;
	
	/*
	 * Multiples of Pi
	 */
	
	/**
	 * <p>Half the value of the mathematical constant pi.</p>
	 */
	public static final float HALF_PI = 0.5f * MathUtilities.PI;
	
	/**
	 * <p>The mathematical constant pi.</p>
	 */
	public static final float PI = (float)Math.PI;
	
	/**
	 * <p>One and half times the mathematical constant pi.</p>
	 */
	public static final float THREE_HALVES_PI = 1.5f * MathUtilities.PI;
	
	/**
	 * <p>Twice the value of the mathematical constant pi.</p>
	 */
	public static final float TWO_PI = 2.0f * MathUtilities.PI;
	
	/**
	 * <p>1 divided by the mathematical constant pi.</p>
	 */
	public static final float INVERSE_PI = 1.0f / MathUtilities.PI;
	
	/*
	 * Degree and Radian Conversion
	 */
	
	/**
	 * <p>Multiply a value expressed in degrees by this number to get that value
	 * expressed in radians.</p> 
	 */
	public static final float DEGREES_TO_RADIANS_MULTIPLIER = MathUtilities.PI / 180.0f;
	
	/**
	 * <p>Multiply a value expressed in radians by this number to get that value
	 * expressed in degrees.</p>
	 */
	public static final float RADIANS_TO_DEGREES_MULTIPLIER = 180.0f / MathUtilities.PI;
	
}
