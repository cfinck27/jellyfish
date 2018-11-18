/*
 * No license is included with the package at this time.
 * Copyright 2018, Finck (github.com/cfinck27) and Gryphon (github.com/GriffFr)
 */

package projectjellyfish.window.input;


import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import projectjellyfish.game.Game;

public class KeyStateManager
{
    
    protected KeyState[] states;
    protected Queue<KeyEvent> evtQueue = new ConcurrentLinkedQueue<>();
    
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
    
    private void press(KeyEnum key)
    {
        KeyState state = getKeyState(key);
        if (!state.isPressed() && !state.isHeld())
        {
            state.press();
        }
    }
    
    private void release(KeyEnum key)
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
    
    public void pollKeyEvents()
    {
        KeyEvent evt;
        while ((evt = evtQueue.poll()) != null)
        {
            if (evt.getNewState().getState() == KeyState.KEYSTATE_PRESSED)
            {
                this.press(evt.getNewState().getKey());
            }
            else if (evt.getNewState().getState() == KeyState.KEYSTATE_RELEASED)
            {
                this.release(evt.getNewState().getKey());
            }
        }
    }
    
    public void fireKeyEvent(KeyEvent evt)
    {
        evtQueue.offer(evt);
    }
    
}