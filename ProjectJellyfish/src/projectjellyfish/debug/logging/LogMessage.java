/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.debug.logging;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogMessage
{
	protected Object source;
    protected String message;
    protected int severity;
    protected boolean forced;
	
	protected Date timestamp;
	protected static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	
	public LogMessage(String message, int severity, Object source, boolean forced)
	{
		this.message = message;
		this.severity = severity;
		this.source = source;
		this.forced = forced;
		
		this.timestamp = new Date();
	}
	
	public LogMessage(String message, int severity)
	{
		this(message, severity, null, false);
	}
	
	public LogMessage(String message, int severity, Object source)
	{
		this(message, severity, source, false);
	}
	
	public LogMessage(String message, int severity, boolean forced)
	{
		this(message, severity, null, forced);
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}
	public String getMessage()
	{
		return this.message;
	}
	
	public void setSeverity(int severity)
	{
		this.severity = severity;
	}
	public int getSeverity()
	{
		return this.severity;
	}
	
	public void setForced(boolean forced)
	{
		this.forced = forced;
	}
	public boolean shouldForce()
	{
		return this.forced;
	}
	
	public void setSource(Object source)
	{
		this.source = source;
	}
	public Object getSource()
	{
		return this.source;
	}
	
	public void setTimestamp(Date timestamp)
	{
		this.timestamp = timestamp;
	}
	public Date getTimestamp()
	{
		return this.timestamp;
	}
	
	@Override
	public String toString()
	{
		return "[" + sdf.format(timestamp) + "] " + this.message;
	}
	
}
