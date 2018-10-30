/*
 * No license is included with the package at this time.
 * Copyright 2018, Finck (github.com/cfinck27) and Gryphon (github.com/GriffFr)
 */

package projectjellyfish.game.messaging;

public class Message
{
    
    protected Object source;
    protected String msgText;
    
    public Message(Object source, String msgText)
    {
        this.source = source;
    }
    
    public Object getSource()
    {
        return source;
    }
    
    public String getMessageText()
    {
        return msgText;
    }
    
    public boolean isEqual(Message other)
    {
        return msgText.equals(other.getMessageText());
    }
    
}