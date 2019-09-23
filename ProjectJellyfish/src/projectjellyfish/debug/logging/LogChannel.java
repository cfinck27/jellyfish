/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.debug.logging;

public interface LogChannel
{
    
    public void log(String message);
	public void log(String message, Object source);
	
	public void addOutput(LogChannelOutput output);
	public boolean removeOutput(LogChannelOutput output);
	public LogChannelOutput[] getOutputs();
    
    public void addFilter(LogChannelFilter filter);
    public boolean removeFilter(LogChannelFilter filter);
    public LogChannelFilter[] getFilters();
    
	public void setSeverityLevel(int severity);
	public int getSeverityLevel();
	
}