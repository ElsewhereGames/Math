package com.elsewhere_games.lib.math.boundingvolume;

import com.elsewhere_games.lib.math.Vertex2d;

public class AxisAlignedBoundingBox implements BoundingVolume {

	/*
	 * Constructors
	 */
	
	/**
	 * <p>Class constructor which assumes the center of this bounding volume
	 * is at the center of the object it is associated with. This constructor
	 * does allow a <code>width</code> and <code>height</code> to be
	 * specified.</p>
	 * 
	 * @param width The width of this bounding box.
	 * @param height The height of this bounding box.
	 */
	public AxisAlignedBoundingBox(float width, float height) {
		this(new Vertex2d(0.0f, 0.0f), width, height);
	}
	
	/**
	 * <p>Class constructor. Allows the <code>width</code> and <code>height</code>
	 * of this axis aligned bounding box to be specified.</p>
	 * 
	 * @param center The center of this bounding box.
	 * @param width The width of this bounding box.
	 * @param height The height of this bounding box.
	 */
	public AxisAlignedBoundingBox(Vertex2d center, float width, float height) {
		this.center = center;
		this.width = width;
		this.height = height;
	}
	
	/*
	 * Bounding Volume Operations
	 */
	
	@Override
	public boolean contains(Vertex2d point) {
		boolean contains = true;
		
		float halfWidth = this.width / 2;
		float halfHeight = this.height / 2;
		
		// Check all extents for containment:		
		if (
				(point.getX() < this.center.getX() - halfWidth) 	||
				(point.getX() > this.center.getX() + halfWidth) 	||
				(point.getY() < this.center.getY() - halfHeight)	||
				(point.getY() > this.center.getY() + halfHeight)
			) 
		{
			contains = false;
		}
		
		return contains;
	}
	
	/*
	 * Accessors and Modifiers
	 */
	
	private Vertex2d center;
	
	/**
	 * <p>Gets the center of this axis aligned bounding box.</p>
	 */
	
	@Override
	public Vertex2d getCenter() {
		return center;
	}
	
	private float width;
	
	/**
	 * <p>Gets the width of this axis aligned bounding box.</p>
	 * 
	 * @return The width of this axis aligned bounding box.
	 */
	public float getWidth() {
		return this.width;
	}
	
	private float height;
	
	/**
	 * <p>Gets the height of this axis aligned bounding box.</p>
	 * 
	 * @return The height of this axis aligned bounding box.
	 */
	public float getHeight() {
		return this.height;
	}
}
