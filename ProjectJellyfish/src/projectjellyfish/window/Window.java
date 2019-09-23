/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
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
