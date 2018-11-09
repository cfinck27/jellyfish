/*
 * No license is included with the package at this time.
 * Copyright 2018, Finck (github.com/cfinck27) and Gryphon (github.com/GriffFr)
 */

package projectjellyfish.window.input;

public class KeyStateManager
{
    
    protected KeyState[] states;
    
    public KeyStateManager()
    {
        states = new KeyState[KeyEnum.values().length];
        for (int i = 0; i < states.length; i++)
        {
            states[i] = new KeyState(KeyEnum.values()[i]);
        }
    }
    
    public KeyState getKeyState(KeyEnum key)
    {
        for (KeyState s : states)
        {
            if (s.getKey() == key)
            {
                return s;
            }
        }
        return null;
    }
    
    public void press(KeyEnum key)
    {
        KeyState state = getKeyState(key);
        if (!state.isPressed() && !state.isHeld())
        {
            state.press();
        }
    }
    
    public void release(KeyEnum key)
    {
        KeyState state = getKeyState(key);
        if (state.isPressed() || state.isHeld())
        {
            state.release();
        }
    }
    
    public void updateStates()
    {
        for (KeyState s : states)
        {
            s.update();
        }
    }
    
}