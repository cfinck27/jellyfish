/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.window.input;


public class KeyEvent implements InputEvent
{
    
    public static final byte KEY_DOWN = 1;
    public static final byte KEY_UP = 2;
    
    
    protected Object source;
    protected byte keyAction;
    protected int keyCode;
    
    public KeyEvent(Object source, byte keyAction, int keyCode)
    {
        this.source = source;
        this.keyAction = keyAction;
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
    
    public byte getKeyAction()
    {
        return keyAction;
    }
    
    public int getKeyCode()
    {
        return keyCode;
    }
}
