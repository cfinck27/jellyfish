/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.game.messaging;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;
import projectjellyfish.game.Game;

public class Console extends Thread
{
    
    protected InputStream inStream;
    protected OutputStream outStream;
    
    protected Scanner in;
    protected PrintWriter out;
    
    protected Queue<Message> msgQueue;
    protected HashMap<String, MessageCallback> messageTable;
    
    public Console(InputStream inStream, OutputStream outStream)
    {
        this.inStream = inStream;
        this.outStream = outStream;
        
        in = new Scanner(inStream);
        out = new PrintWriter(outStream);
        
        msgQueue = new ConcurrentLinkedQueue<>();
        messageTable = new HashMap<>();
    }
    
    public boolean addCommand(String name, MessageCallback callback)
    {
        if (callback.isValidCallback() && !messageTable.containsKey(name))
        {
            messageTable.put(name, callback);
            return true;
        }
        
        Game.getInstance().getLog().println("CONSOLE: Failed to add command '" + name + "'.");
        return false;
    }
    
    public boolean removeCommand(String name)
    {
        if (messageTable.containsKey(name))
        {
            messageTable.remove(name);
            return true;
        }
        return false;
    }
    
    public boolean commandExists(String name)
    {
        return messageTable.containsKey(name);
    }
    
    public void postMessage(Message msg)
    {
        msgQueue.offer(msg);
    }
    
    protected void pollCommands()
    {
        Scanner scnr = new Scanner(inStream);
        String cmd = scnr.next();
        postMessage(new Message(this, cmd));
    }
    
    protected boolean pollSingleMessage()
    {
        Message next = msgQueue.poll();
        if (next == null)
        {
            return false;
        }
        
        MessageCallback callback = messageTable.get(next.getMessageText());
        if (callback != null)
        {
            callback.trigger();
        }
        else
        {
            out.println("Command not found.");
            out.flush();
        }
        
        return true;
    }
    
    public void pollMessages(int max)
    {
        int i;
        for (i = 0; (max < 0) || (i < max); i++)
        {
            if (!pollSingleMessage())
            {
                break;
            }
        }
        /*
        if (i > 0)
        {
            Game.getInstance().getLog().println(i + " messages polled.");
        }
        */
    }
    
    
    public void pollMessages()
    {
        pollMessages(-1);
    }
    
    @Override
    public void run()
    {
        while (!Game.getInstance().isExiting())
        {
            pollCommands();
        }
    }
    
}