/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.debug.logging;

public interface LogChannelFilter
{
    
    public boolean shouldFilter(LogMessage message);
    public LogMessage filterText(LogMessage message);
	
    public void setBypassFilter(boolean doBypass);
	public boolean doBypassFilter();
	
	public void setBypassFilterText(boolean doBypassText);
	public boolean doBypassFilterText();
    
	public void setEnabled(boolean enabled);
	public boolean isEnabled();
	
}