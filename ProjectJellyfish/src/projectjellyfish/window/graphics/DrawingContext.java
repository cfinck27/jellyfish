/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.window.graphics;


import projectjellyfish.util.Vec2d;
import projectjellyfish.window.Sprite;

public abstract class DrawingContext
{
    public DrawingContext()
    {
	
    }
    
    public abstract void clear();
    public abstract void present();
    
    public abstract void rotate(double theta);
    public abstract void rotate(double theta, double x, double y);
    
    public abstract void scale(double x, double y);
    
    public abstract void translate(double x, double y);
    
    public abstract void pushMatrix();
    public abstract void popMatrix();
    
    public abstract void setColor(Color c);
    public abstract Color getColor();
    
    public abstract void drawRect(double x, double y, double w, double h);
    public abstract void drawRect(Vec2d pos, Vec2d dim);
    
    public abstract void fillRect(double x, double y, double w, double h);
    public abstract void fillRect(Vec2d pos, Vec2d dim);
    
    public abstract void drawSprite(Sprite img, double x, double y);
}
