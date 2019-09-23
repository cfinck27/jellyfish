/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.debug.logging;

public interface Logger
{
    
    public LogChannel getChannel(String id);
    
    public boolean addChannel(String id, LogChannel channel);
    public boolean removeChannel(String id);
	
	public LogChannel[] getChannels();
    
}