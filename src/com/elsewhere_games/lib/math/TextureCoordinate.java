package com.elsewhere_games.lib.math;

public class TextureCoordinate {

	/*
	 * Constructors
	 */
	
	/**
	 * <p>Class constructor. Allows the <code>s</code> and <code>t</code>
	 * coordinates of this texture coordinate to be specified.</p>
	 * 
	 * @param s The s coordinate of this texture.
	 * @param t The t coordinate of this texture.
	 */
	public TextureCoordinate(final int s, final int t) {
		this.s = s;
		this.t = t;
	}
	
	/*
	 * Accessors and Modifiers
	 */
	
	private int s;
	
	/**
	 * <p>Gets the <code>s</code> coordinate of this texture.</p>
	 * 
	 * @return The <code>s</code> coordinate of this texture.
	 */
	public final int getS() {
		return this.s;
	}
	
	private int t;
	
	/**
	 * <p>Gets the <code>t</code> coordinate of this texture.</p>
	 * 
	 * @return The <code>t</code> coordinate of this texture.
	 */
	public final int getT() {
		return this.t;
	}
	
}
