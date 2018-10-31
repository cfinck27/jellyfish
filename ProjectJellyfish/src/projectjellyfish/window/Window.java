/*
 * No license is included with the package at this time.
 * Copyright 2018, Finck (github.com/cfinck27) and Gryphon (github.com/GriffFr)
 */

package projectjellyfish.window;


import projectjellyfish.util.Vec2i;
import projectjellyfish.window.graphics.DrawingContext;
import projectjellyfish.window.input.InputListener;

public abstract class Window
{
    protected DrawingContext graphics;
    
    public Window()
    {
    }
    
    public DrawingContext getGraphics()
    {
	return graphics;
    }
    
    public abstract void close();
    public abstract void show();
    public abstract void hide();
    public abstract boolean isVisible();
    
    public abstract void setSize(int w, int h);
    public abstract Vec2i getSize();
    
    public abstract void present();
    
    public abstract void addInputListener(InputListener l);
    
    public abstract boolean isKeyDown(int kc);
}
