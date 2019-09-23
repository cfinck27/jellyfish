/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
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
