/*
 * No license is included with the package at this time.
 * Copyright 2018, Finck (github.com/cfinck27) and Gryphon (github.com/GriffFr)
 */

package projectjellyfish.util;


public abstract class Vec2<T extends Number>
{
    public T x;
    public T y;
    
    public Vec2(T x, T y)
    {
	this.x = x;
	this.y = y;
    }
    
    public <V extends Vec2<T>> Vec2(final V v)
    {
	this.x = v.x;
	this.y = v.y;
    }
    
    public abstract Vec2<T> negate();
    
    public abstract Vec2<T> add(final Vec2<T> n);
    public abstract Vec2<T> subtract(final Vec2<T> n);
    public abstract Vec2<T> multiply(final Vec2<T> n);
    public abstract Vec2<T> divide(final Vec2<T> n);
    
    @Override
    public String toString()
    {
	return "(" + x + ", " + y + ")";
    }
    
    public static <U extends Number> Vec2<U> negate(final Vec2<U> a, final Vec2<U> b)
    {
	throw new UnsupportedOperationException("Vec2 child does not support.");
    }
    
    public static <U extends Number> Vec2<U> add(final Vec2<U> a, final Vec2<U> b)
    {
	throw new UnsupportedOperationException("Vec2 child does not support.");
    }
    
    public static <U extends Number> Vec2<U> subtract(final Vec2<U> a, final Vec2<U> b)
    {
	throw new UnsupportedOperationException("Vec2 child does not support.");
    }
    
    public static <U extends Number> Vec2<U> multiply(final Vec2<U> a, final Vec2<U> b)
    {
	throw new UnsupportedOperationException("Vec2 child does not support.");
    }
    
    public static <U extends Number> Vec2<U> divide(final Vec2<U> a, final Vec2<U> b)
    {
	throw new UnsupportedOperationException("Vec2 child does not support.");
    }
}
