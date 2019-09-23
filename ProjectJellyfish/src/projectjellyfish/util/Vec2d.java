/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.util;


public class Vec2d extends Vec2<Double>
{

    public Vec2d()
    {
	super(0.0, 0.0);
    }
    
    public Vec2d(Double x, Double y)
    {
	super(x, y);
    }
    
    public Vec2d(final Vec2d v)
    {
	super(v);
    }

    @Override
    public Vec2d add(final Vec2<Double> n)
    {
	this.x += n.x;
	this.y += n.y;
	
	return this;
    }

    @Override
    public Vec2d subtract(final Vec2<Double> n)
    {
	this.x -= n.x;
	this.y -= n.y;
	
	return this;
    }

    @Override
    public Vec2d multiply(final Vec2<Double> n)
    {
	this.x *= n.x;
	this.y *= n.y;
	
	return this;
    }

    @Override
    public Vec2d divide(final Vec2<Double> n)
    {
	this.x /= n.x;
	this.y /= n.y;
	
	return this;
    }

    @Override
    public Vec2d negate()
    {
	this.x *= -1;
	this.y *= -1;
	
	return this;
    }
    
    public static Vec2d add(Vec2d a, Vec2d b)
    {
	return new Vec2d(a).add(b);
    }
    
    public static Vec2d subtract(Vec2d a, Vec2d b)
    {
	return new Vec2d(a).subtract(b);
    }
    
    public static Vec2d multiply(Vec2d a, Vec2d b)
    {
	return new Vec2d(a).multiply(b);
    }
    
    public static Vec2d divide(Vec2d a, Vec2d b)
    {
	return new Vec2d(a).divide(b);
    }
}
