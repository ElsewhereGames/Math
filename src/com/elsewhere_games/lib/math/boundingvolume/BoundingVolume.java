package com.elsewhere_games.lib.math.boundingvolume;

import com.elsewhere_games.lib.math.Vertex2d;

public interface BoundingVolume {
	
	/*
	 * Bounds Operations
	 */
	
	/**
	 * <p>Gets the center of this bounding volume.</p>
	 * 
	 * @return The center of this bounding volume.
	 */
	public Vertex2d getCenter();
	
	/**
	 * <p>Check to see if the specified <code>point</code> lies inside of this
	 * bounding volume.</p>
	 * 
	 * @param point The point to check for containment in these bounds.
	 * @return <code>true</code> if the specified point lies inside of this
	 * bounding volume, <code>false</code> otherwise.
	 */
	public boolean contains(Vertex2d point);
	
}
