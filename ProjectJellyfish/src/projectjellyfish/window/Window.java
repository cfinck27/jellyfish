/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.window;


import java.util.ArrayList;
import projectjellyfish.util.Vec2i;
import projectjellyfish.window.graphics.DrawingContext;
import projectjellyfish.window.input.KeyEvent;
import projectjellyfish.window.input.KeyListener;
import projectjellyfish.window.input.KeyStateManager;

public abstract class Window
{
    protected DrawingContext graphics;
    
    protected KeyStateManager keyStates;
    protected ArrayList<KeyListener> keyListeners;
    
    public Window()
    {
        keyStates = new KeyStateManager();
        keyListeners = new ArrayList<>();
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
    
    public abstract void pollEvents();
    
    public void addKeyListener(KeyListener l)
    {
        keyListeners.add(l);
    }
    
    public void removeKeyListener(KeyListener l)
    {
        keyListeners.remove(l);
    }
    
    protected void fireKeyEvent(KeyEvent e)
    {
        keyStates.fireKeyEvent(e);
        for (KeyListener l : keyListeners)
        {
            l.onInput(e);
        }
    }
    
    public abstract boolean isKeyDown(int kc);
}
