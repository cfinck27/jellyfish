/*
 * No license is included with the package at this time.
 * Copyright 2018, Finck (github.com/cfinck27) and Gryphon (github.com/GriffFr)
 */

package projectjellyfish.window.graphics;


public class Color
{
    public double r, g, b, a;
    
    public Color()
    {
	this(0, 0, 0, 255);
    }
    
    public Color(int r, int g, int b)
    {
	this(r, g, b, 255);
    }
    
    public Color(int r, int g, int b, int a)
    {
	this.r = r / 255.0;
	this.g = g / 255.0;
	this.b = b / 255.0;
	this.a = a / 255.0;
    }
    
    public Color(double r, double g, double b)
    {
	this(r, g, b, 255.0);
    }
    
    public Color(double r, double g, double b, double a)
    {
	this.r = r / 255.0;
	this.g = g / 255.0;
	this.b = b / 255.0;
	this.a = a / 255.0;
    }
    
    @Override
    public String toString()
    {
	return "(" + r + ", " + g + ", " + b + ", " + a + ")";
    }
}
