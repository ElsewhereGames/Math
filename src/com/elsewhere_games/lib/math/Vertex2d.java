package com.elsewhere_games.lib.math;

// Java IO
import java.io.Serializable;
import java.nio.FloatBuffer;

public class Vertex2d implements Cloneable, Serializable {
	
	/*
	 * Version
	 */
	
	public static final long serialVersionUID = 1l;
	
	/*
	 * Constants
	 */
	
	public static final int COMPONENT_COUNT = 2;
	
	/*
	 * Constructors
	 */
	
	/**
	 * <p>Class constructor. All components of this vertex are initialized to
	 * <code>0.0f</code>.</p>
	 */
	public Vertex2d() {
		this.x = 0.0f;
		this.y = 0.0f;
	}
	
	/**
	 * <p>Class constructor. Allows the <code>x</code> and <code>y</code>
	 * components of this vertex to be specified.</p>
	 * 
	 * @param x The x component of this vertex.
	 * @param y The y component of this vertex.
	 * @param z The z component of this vertex.
	 */
	public Vertex2d(final float x, final float y) {
		this.x = x;
		this.y = y;
	}
	
	/*
	 * Mathematical Operations
	 */
	
	/**
	 * <p>Adds the <code>otherVertex</code> to this vertex, meaning that the x
	 * and y components of the specified vertex are added to their correlating
	 * components of this vertex.</p>
	 * 
	 * @param otherVertex The vertex to add to this vertex.
	 */
	public void add(Vertex2d otherVertex) {
		this.x += otherVertex.x;
		this.y += otherVertex.y;
	}
	
	/**
	 * <p>Calculates the angle between the <code>otherVertex</code> and this
	 * vertex, expressed in radians.</p>
	 * 
	 * @param otherVertex The vertex between which to calculate the angle.
	 * @return The angle between this vertex and the other vertex in radians.
	 */
	public float angleBetween(Vertex2d otherVertex) {
		float xDifference = otherVertex.x - this.x;
		float yDifference = otherVertex.y - this.y;
		
		return (float)Math.atan2(xDifference, yDifference);
	}
	
	/*
	 * Accessors and Modifiers
	 */

	/**
	 * <p>Gets the x component of this vector.</p>
	 * 
	 * @return The x component of this vector.
	 */
	public final float getX() {
		return this.x;
	}
	
	/**
	 * <p>Sets the x component of this vector.</p>
	 * 
	 * @param x The new x component of this vector.
	 */
	public final void setX(final float x) {
		this.x = x;
	}
	
	/**
	 * <p>Gets the y component of this vector.</p>
	 * 
	 * @return The y component of this vector.
	 */
	public final float getY() {
		return this.y;
	}
	
	/**
	 * <p>Sets the y component of this vector.</p>
	 * 
	 * @param y The new y component of this vector.
	 */
	public final void setY(final float y) {
		this.y = y;
	}
	
	/**
	 * <p>Puts the components of this vertex into the <code>destination</code>
	 * buffer in x, y order.</p>
	 * 
	 * @param destination The buffer into which the components of this vertex
	 * will be put.
	 * 
	 * @throws IllegalArgumentException If the buffer does not contain enough
	 * room for the elements.
	 */
	public void getComponents(FloatBuffer destination) {
		// Make sure there is enough room:
		if (destination.remaining() < Vertex2d.COMPONENT_COUNT) {
			throw new IllegalArgumentException("The destination buffer is too small to contain all components of the vertex.");
		}
		
		destination.put(this.x);
		destination.put(this.y);
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
		Vertex2d clonedVertex = new Vertex2d(this.x, this.y);
		
		return clonedVertex;
	}
	
	/*
	 * Local Fields
	 */
	
	private float x;
	private float y;
	
}
