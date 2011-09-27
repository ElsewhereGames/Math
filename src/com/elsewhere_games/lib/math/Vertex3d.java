package com.elsewhere_games.lib.math;

import java.io.Serializable;
import java.nio.FloatBuffer;

public class Vertex3d implements Cloneable, Serializable {
	
	/*
	 * Version
	 */
	
	public static final long serialVersionUID = 1l;
	
	/*
	 * Constants
	 */
	
	public static final int COMPONENT_COUNT = 3;
	
	/*
	 * Constructors
	 */
	
	/**
	 * <p>Class constructor. Allows the <code>x</code>, <code>y</code>,
	 * and <code>z</code> components of this vertex to be specified.</p>
	 * 
	 * @param x The x component of this vertex.
	 * @param y The y component of this vertex.
	 * @param z The z component of this vertex.
	 */
	public Vertex3d(final float x, final float y, final float z) {
		this.x = x;
		this.y = y;
		this.z = z;
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
	 * <p>Gets the z component of this vector.</p>
	 * 
	 * @return The z component of this vector.
	 */
	public final float getZComponent() {
		return this.z;
	}
	
	/**
	 * <p>Sets the z component of this vector.</p>
	 * 
	 * @param z The new z component of this vector.
	 */
	public final void setZComponent(final float z) {
		this.z = z;
	}
	
	/**
	 * <p>Puts the components of this vertex into the <code>destination</code>
	 * buffer in x, y, z order.</p>
	 * 
	 * @param destination The buffer into which the components of this vertex
	 * will be put.
	 * 
	 * @throws IllegalArgumentException If the buffer does not contain enough
	 * room for the elements.
	 */
	public void getComponents(FloatBuffer destination) {
		// Make sure there is enough room:
		if (destination.remaining() < Vertex3d.COMPONENT_COUNT) {
			throw new IllegalArgumentException("The destination buffer is too small to contain all components of the vertex.");
		}
		
		destination.put(this.x);
		destination.put(this.y);
		destination.put(this.z);
	}
	
	/*
	 * Java Object Overrides
	 */
	
	/**
	 * <p>Returns a deep copy of this vertex.</p>
	 * 
	 * @return A deep copy of this vertex.
	 */
	
	@Override
	public Object clone() {
		Vertex3d clonedVertex = new Vertex3d(this.x, this.y, this.z);
		
		return clonedVertex;
	}
	
	/*
	 * Local Fields
	 */
	
	private float x;
	private float y;
	private float z;
}

