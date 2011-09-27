package com.elsewhere_games.lib.math.shape;

import com.elsewhere_games.lib.math.Vertex2d;

public class Rectangle {

	/*
	 * Constructors
	 */
	
	/**
	 * <p>Class constructor. Allows the <code>center</code>, <code>width</code>,
	 * and <code>height</code> of this rectangle to be specified.</p>
	 * 
	 * @param center The center location of this rectangle.
	 * @param width The horizontal span of this rectangle.
	 * @param height The vertical span of this rectangle.
	 */
	public Rectangle(final Vertex2d center, final float width, final float height) {
		this.center = center;
		this.width = width;
		this.height = height;
	}
	
	/*
	 * Accessors and Modifiers 
	 */
	
	private Vertex2d center;
	
	public final Vertex2d getCenter() {
		return this.center;
	}
	
	public void setCenter(final Vertex2d center) {
		this.center = center;
	}
	
	private float width;
	
	public final float getWidth() {
		return this.width;
	}
	
	public void setWidth(final float width) {
		this.width = width;
	}
	
	private float height;
	
	public final float getHeight() {
		return this.height;
	}
	
	public void setHeight(final float height) {
		this.height = height;
	}
	
	public float getLeft() {
		return this.center.getX() - (this.width * 0.5f);
	}
	
	public float getRight() {
		return this.center.getX() + (this.width * 0.5f);
	}
	
	public float getBottom() {
		return this.center.getY() - (this.height * 0.5f);
	}
	
	public float getTop() {
		return this.center.getY() + (this.height * 0.5f);
	}
}
