package com.elsewhere_games.lib.math.boundingvolume;

import com.elsewhere_games.lib.math.Vertex2d;

public class Circle implements BoundingVolume {

	/*
	 * Components
	 */
	
	private Vertex2d center;
	private float radius;
	
	/*
	 * Constructors
	 */
	
	/**
	 * <p>Class constructor. Creates a bounding circle with it's center set to
	 * (0, 0) and a radius of 1.<p>
	 */
	public Circle() {
		this(new Vertex2d(), 1.0f);
	}
	
	/**
	 * <p>Class constructor. Allows the <code>center</code> and <code>radius</code>
	 * to be specified.</p>
	 * 
	 * @param center Where the center of this bounding circle is located.
	 * @param radius The radius of this circle.
	 */
	public Circle(final Vertex2d center, final float radius) {
		this.center = center;
		this.radius = radius;
	}
	
	/*
	 * Accessors and Modifiers
	 */
	
	/**
	 * <p>Gets the radius of this bounding circle.</p>
	 * 
	 * @return The radius of this bounding circle.
	 */
	public final float getRadius() {
		return this.radius;
	}
	
	/*
	 * Bounding Volume Interface
	 */
	
	@Override
	public Vertex2d getCenter() {
		return center;
	}

	@Override
	public boolean contains(Vertex2d point) {
		
		/*
		 * The algorithm uses the Pythagorean theorem in calculating the
		 * square of the distance from the center of this circle to the specified
		 * point. If the square of the distance is larger than the square of the
		 * radius of this circle, the point lies outside of the circle.
		 * 
		 * We could take the root of these values to follow the complete algorithm,
		 * but that would be extra and unnecessary work.
		 */
		
		float deltaX = point.getX() - this.center.getX();
		float deltaY = point.getY() - this.center.getY();
		float deltaSquaredSum = ((deltaX * deltaX) + (deltaY * deltaY));
		float squaredRadius = (this.radius * this.radius);
				
		return (deltaSquaredSum <= squaredRadius);
	}

	
	
}
