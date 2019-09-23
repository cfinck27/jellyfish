/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.game.messaging;

public class Message
{
    
    protected Object source;
    protected String msgText;
    
    public Message(Object source, String msgText)
    {
        this.source = source;
        this.msgText = msgText;
    }
    
    public Object getSource()
    {
        return source;
    }
    
    public String getMessageText()
    {
        return msgText;
    }
    
    public boolean equals(Message other)
    {
        return msgText.equals(other.getMessageText());
    }
    
}