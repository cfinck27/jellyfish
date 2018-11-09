/*
 * No license is included with the package at this time.
 * Copyright 2018, Finck (github.com/cfinck27) and Gryphon (github.com/GriffFr)
 */

package projectjellyfish.window.input;

public class KeyState
{
    
    protected final KeyEnum key;
    
    public static final byte KEYSTATE_INACTIVE = 0;
    public static final byte KEYSTATE_PRESSED = 1;
    public static final byte KEYSTATE_HELD = 2;
    public static final byte KEYSTATE_RELEASED = 3;
    
    protected byte state;
    
    public KeyState(KeyEnum key)
    {
        this.key = key;
        state = KEYSTATE_INACTIVE;
    }
    
    public KeyEnum getKey()
    {
        return key;
    }
    
    public boolean isPressed()
    {
        return (state == KEYSTATE_PRESSED);
    }
    
    public boolean isHeld()
    {
        return (state == KEYSTATE_HELD);
    }
    
    public boolean isReleased()
    {
        return (state == KEYSTATE_RELEASED);
    }
    
    public void press()
    {
        state = KEYSTATE_PRESSED;
    }
    
    public void release()
    {
        state = KEYSTATE_RELEASED;
    }
    
    public void update()
    {
        if (state == KEYSTATE_PRESSED)
        {
            state = KEYSTATE_HELD;
        }
        else if (state == KEYSTATE_RELEASED)
        {
            state = KEYSTATE_INACTIVE;
        }
    }
    
}