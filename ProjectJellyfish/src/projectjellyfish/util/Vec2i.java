/*
 * No license is included with the package at this time.
 * Copyright 2018, Finck (github.com/cfinck27) and Gryphon (github.com/GriffFr)
 */

package projectjellyfish.util;


public class Vec2i extends Vec2<Integer>
{
    public Vec2i(Integer x, Integer y)
    {
	super(x, y);
    }
    
    public Vec2i(final Vec2i v)
    {
	super(v);
    }

    @Override
    public Vec2i add(final Vec2<Integer> n)
    {
	this.x += n.x;
	this.y += n.y;
	
	return this;
    }

    @Override
    public Vec2i subtract(final Vec2<Integer> n)
    {
	this.x -= n.x;
	this.y -= n.y;
	
	return this;
    }

    @Override
    public Vec2i multiply(final Vec2<Integer> n)
    {
	this.x *= n.x;
	this.y *= n.y;
	
	return this;
    }

    @Override
    public Vec2i divide(final Vec2<Integer> n)
    {
	this.x /= n.x;
	this.y /= n.y;
	
	return this;
    }

    @Override
    public Vec2i negate()
    {
	this.x *= -1;
	this.y *= -1;
	
	return this;
    }
    
    public static Vec2i negate(final Vec2i a)
    {
	return new Vec2i(a).negate();
    }
    
    public static Vec2i add(final Vec2i a, final Vec2i b)
    {
	return new Vec2i(a).add(b);
    }
    
    public static Vec2i subtract(final Vec2i a, final Vec2i b)
    {
	return new Vec2i(a).subtract(b);
    }
    
    public static Vec2i multiply(final Vec2i a, final Vec2i b)
    {
	return new Vec2i(a).multiply(b);
    }
    
    public static Vec2i divide(final Vec2i a, final Vec2i b)
    {
	return new Vec2i(a).divide(b);
    }
}
