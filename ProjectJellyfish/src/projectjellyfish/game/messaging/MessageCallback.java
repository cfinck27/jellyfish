/*
 * No license is included with the package at this time.
 * Copyright 2018, Finck (github.com/cfinck27) and Gryphon (github.com/GriffFr)
 */

package projectjellyfish.game.messaging;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import projectjellyfish.game.Game;

public class MessageCallback
{
    
    protected Object target;
    protected Method method;
    
    public MessageCallback(Object target, String methodName)
    {
        this.target = target;
        method = null;
        
	Class c = target.getClass();
	do
	{
	    try
	    {
		method = c.getDeclaredMethod(methodName);
		System.out.println("Found method -> " + methodName + "!");
		break;
	    }
	    catch (NoSuchMethodException ex)
	    {
		Game.getInstance().getLog().println("Method missing from class " + c);
	    }
	}
	while ((c = c.getSuperclass()) != null);
	
	if (method == null)
	{
            Game.getInstance().getLog().println("MessageCallback: No such method exists -> " + methodName);
        }
    }
    
    public void trigger()
    {
        if (isValidCallback())
        {
            try
            {
                method.invoke(target, null);
            }
            catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex)
            {
                Game.getInstance().getLog().println("MESSAGE_CALLBACK: Error invoking callback.");
            }
        }
        else
        {
            Game.getInstance().getLog().println("MESSAGE_CALLBACK: Tried to call method that didn't exist.");
        }
    }
    
    public boolean isValidCallback()
    {
        return (method != null);
    }
    
}