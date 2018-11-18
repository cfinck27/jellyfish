/*
 * No license is included with the package at this time.
 * Copyright 2018, Finck (github.com/cfinck27) and Gryphon (github.com/GriffFr)
 */

package projectjellyfish.window.input;


public class KeyEvent implements InputEvent
{
    protected Object source;
    protected KeyState oldState;
    protected KeyState newState;
    
    public KeyEvent(Object source, KeyState oldState, KeyState newState)
    {
        this.source = source;
        this.oldState = oldState;
        this.newState = newState;
    }
    
    @Override
    public Object getSource()
    {
        return source;
    }

    @Override
    public String getType()
    {
        return "KEY_EVENT";
    }
    
    public KeyState getOldState()
    {
        return oldState;
    }
    
    public KeyState getNewState()
    {
        return newState;
    }
    
    @Override
    public String toString()
    {
        return "" + oldState + " -> " + newState;
    }
}
