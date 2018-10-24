/*
 * No license is included with the package at this time.
 * Copyright 2018, Finck (github.com/cfinck27) and Gryphon (github.com/GriffFr)
 */

package projectjellyfish.window.input;


public class KeyEvent implements InputEvent
{

    protected Object source;
    
    public KeyEvent(Object source)
    {
        this.source = source;
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
}
