package com.elsewhere_games.lib.math;

import java.io.Serializable;
import java.nio.FloatBuffer;

public class Vector2d implements Cloneable, Serializable {

	/*
	 * Version
	 */
	
	public static final long serialVersionUID = 1l;
	
	/*
	 * Constructors
	 */
	
	/**
	 * <p>Class constructor. Allows the <code>x</code> and <code>y</code>
	 * components of this vector to be specified.</p>
	 * 
	 * @param x The x component of this vector.
	 * @param y The y component of this vector.
	 */
	public Vector2d(final float x, final float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * <p>Class constructor. Sets the x and y components of this vector to 
	 * <code>0.0f</code>.</p>
	 */
	public Vector2d() {
		this(0.0f, 0.0f);
	}
	
	/*
	 * Mathematical Operations
	 */
	
	/**
	 * <p>Adds the <code>otherVector</code> to this vector.</p>
	 * 
	 * @param otherVector The vector to add to this vector.
	 */
	public final void add(final Vector2d otherVector) {
		this.x = this.x + otherVector.x;
		this.y = this.y + otherVector.y;
	}
	
	/**
	 * <p>Adds the specified components to this vector.</p>
	 * 
	 * @param x The x component to add to this vector.
	 * @param y The y component to add to this vector.
	 */
	public final void add(final float x, final float y) {
		this.x = this.x + x;
		this.y = this.y + y;
	}
	
	/**
	 * <p>Multiplies the components of this vector by the supplied 
	 * <code>scalar</code>.</p>
	 * 
	 * @param scalar The value by which this vector is scaled.
	 */
	public final void multiply(final float scalar) {
		this.x = this.x * scalar;
		this.y = this.y * scalar;
	}
	
	/**
	 * <p>Divides the components of this vector by the supplied
	 * <code>scalar</code>.</p>
	 * 
	 * @param scalar The value by which this vector is scaled.
	 */
	public final void divide(final float scalar) {
		this.x = this.x / scalar;
		this.y = this.y / scalar;
	}
	
	/**
	 * <p>Gets the length of this vector.</p>
	 * 
	 * @return The length of this vector.
	 */
	public final float calculateLength() {
		// Length is calculated using the Pythagorean theorem:
		float lengthSquared = this.calculateLengthSquared();
		return (float)Math.sqrt(lengthSquared);
	}
	
	/**
	 * <p>Gets the length of this vector squared. Often vector math
	 * can be simplified by using the squared length of a vector, and
	 * since getting the actual length involves calculating a square
	 * root, this method can provide performance benefits.</p>
	 * 
	 * @return The squared length of this vector.
	 */
	public final float calculateLengthSquared() {
		// Length is calculated using the Pythagorean theorem:
		float lengthSquared = (this.x * this.x) +
							  (this.y * this.y);
		
		return lengthSquared;
	}
	
	public final float calculateDotProduct(Vector2d otherVector) {
		Vector2d thisVector = this;
		
		float dotProduct = (thisVector.x * otherVector.x) +
						   (thisVector.y * otherVector.y);
		
		return dotProduct;
	}
	
	public final void normalize() {
		float length = this.calculateLength();
		// Avoid dividing by zero:
		if (length != 0.0f) {
			this.divide(length);
		}
	}
	
	/*
	 * Accessors and Modifiers
	 */

	/**
	 * <p>Gets the x component of this vector.</p>
	 * 
	 * @return The x component of this vector.
	 */
	public final float getXComponent() {
		return this.x;
	}
	
	/**
	 * <p>Sets the x component of this vector.</p>
	 * 
	 * @param x The new x component of this vector.
	 */
	public final void setXComponent(final float x) {
		this.x = x;
	}
	
	/**
	 * <p>Gets the y component of this vector.</p>
	 * 
	 * @return The y component of this vector.
	 */
	public final float getYComponent() {
		return this.y;
	}
	
	/**
	 * <p>Sets the y component of this vector.</p>
	 * 
	 * @param y The new y component of this vector.
	 */
	public final void setYComponent(final float y) {
		this.y = y;
	}
	
	/**
	 * <p>Stores the x and y components of this vector (in that order) in 
	 * the specified <code>destination</code> buffer.</p>
	 * 
	 * @param destination The buffer in which the components are stored. The 
	 * position of the buffer after this operation lies after the last 
	 * component added.
	 * 
	 * @throws IllegalArgumentException If the <code>destination</code> buffer
	 * contains less than three elements.
	 */
	public final void getComponents(FloatBuffer destination) throws IllegalArgumentException {
		// Make sure there is enough room for the components:
		if (destination.remaining() < Vector2d.COMPONENT_COUNT) {
			throw new IllegalArgumentException("The specified destination buffer is not large enough.");
		}
		
		// The components are stored in XYZ order.
		destination.put(this.x);
		destination.put(this.y);
	}
	
	/**
	 * <p>Sets the x and y components of this vector to the specified values.</p>
	 * 
	 * @param x The new x component of this vector.
	 * @param y The new y component of this vector.
	 */
	public final void setComponents(final float x, final float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * <p>Sets the x and components of this vector to the values supplied by the
	 * <code>source</code> buffer.</p>
	 * 
	 * @param source The buffer which supplies the values of this vector. The 
	 * values are expected to be stored in XY order.
	 * 
	 * @throws IllegalArgumentException If the <code>source</code> buffer does
	 * not have enough elements remaining for all components of this vector.
	 */
	public final void setComponents(final FloatBuffer source) {
		// Make sure the source contains enough components:
		if (source.remaining() < Vector2d.COMPONENT_COUNT) {
			throw new IllegalArgumentException("The specified source buffer does not contain enough components.");
		}
		
		// The components are stored in XYZ order.
		this.x = source.get();
		this.y = source.get();
	}
	
	/*
	 * Java Object Overrides
	 */
	
	/**
	 * <p>Creates a deep copy of this color.</p>
	 * 
	 * @return A deep copy of this color.
	 */
	
	@Override
	public Object clone() {
		Vector2d clonedVector = new Vector2d(this.x, this.y);
		
		return clonedVector;
	}
	
	/**
	 * <p>Verifies that the components of the specified <code>otherColor</code>
	 * match those of this color.</p>
	 * 
	 * @return <code>true</code> if all components of the two colors match,
	 * <code>false</code> otherwise.
	 * 
	 * @throws IllegalArgumentException If the <code>otherColor</code> is not
	 * an object of the same type as this color.
	 */
	
	@Override
	public boolean equals(Object otherVector) throws IllegalArgumentException {
		// Make sure the other color is actually a color:
		if (!(otherVector instanceof Vector3d)) {
			throw new IllegalArgumentException("The specified object is not of type " + this.getClass().getCanonicalName());
		}
		
		Vector2d vectorA = this;
		Vector2d vectorB = (Vector2d)otherVector;
		boolean isEqual = true;
		
		// Comparison is faster if we see if they are not equal.
		if(
				(!MathUtilities.isEqual(vectorA.x, vectorB.x)) 		||
				(!MathUtilities.isEqual(vectorA.y, vectorB.y))
		) {
			isEqual = false;
		}
		
		return isEqual;
	}
	
	/*
	 * Local Fields
	 */
	
	private float x;			// The x component of this vector.
	private float y;			// The y component of this vector.
	
	/*
	 * Constants
	 */
	
	public static final int COMPONENT_COUNT = 2;
	
}

