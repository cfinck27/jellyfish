/*
 * No license is included with the package at this time.
 * Copyright 2018, Finck (github.com/cfinck27) and Gryphon (github.com/GriffFr)
 */

package projectjellyfish.game.messaging;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
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
        
        msgQueue = new PriorityQueue<>();
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
    
    public void pollMessages()
    {
        Message next;
        while ((next = msgQueue.poll()) != null)
        {
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
        }
    }
    
    @Override
    public void run()
    {
        while (true)
        {
            pollCommands();
        }
    }
    
}