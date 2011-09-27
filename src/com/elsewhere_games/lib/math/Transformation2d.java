package com.elsewhere_games.lib.math;

public class Transformation2d {

	/*
	 * Constructors
	 */
	
	/**
	 * <p>Class constructor.<p>
	 */
	public Transformation2d() {
		this.translation = new Vertex2d();
		this.scale = 1.0f;
	}
	
	/*
	 * Mathematical Operations
	 */
	
	public void multiply(Transformation2d otherTransformation) {
		this.translation.add(otherTransformation.translation);
	}
	
	/*
	 * Accessors and Modifiers
	 */
	
	private Vertex2d translation;
	
	/**
	 * <p>Gets the translation of this transformation.</p>
	 * 
	 * @return The translation of this transformation.
	 */
	public Vertex2d getTranslation() {
		return this.translation;
	}
	
	private float scale;
	
	/**
	 * <p>Gets the uniform scale factor of this transformation.</p>
	 * 
	 * @return The uniform scale factor of this transformation.
	 */
	public float getScale() {
		return this.scale;
	}
	
}
