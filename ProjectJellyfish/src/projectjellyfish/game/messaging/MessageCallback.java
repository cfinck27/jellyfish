/*
 * No license is included with the package at this time.
 * Copyright 2018, Finck (github.com/cfinck27) and Gryphon (github.com/GriffFr)
 */

package projectjellyfish.game.messaging;

import java.lang.reflect.Method;
import projectjellyfish.game.Game;

public class MessageCallback
{
    
    protected Object target;
    protected Method method;
    
    public MessageCallback(Object target, String methodName)
    {
        this.target = target;
        try
        {
            method = target.getClass().getMethod(methodName);
        }
        catch (NoSuchMethodException e)
        {
            method = null;
            Game.getInstance().getLog().println("MESSAGE_CALLBACK: Tried to get method that did not exist.");
        }
    }
    
    public void trigger()
    {
        Game.getInstance().getLog().println("MESSAGE_CALLBACK: Tried to call method that didn't exist.");
    }
    
    public boolean isValidCallback()
    {
        return (method != null);
    }
    
}