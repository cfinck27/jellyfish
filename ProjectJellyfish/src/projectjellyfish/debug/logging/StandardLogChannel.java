/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.debug.logging;

import java.util.ArrayList;

public class StandardLogChannel implements LogChannel
{
	
	protected int severity = 5;
	
	protected ArrayList<LogChannelOutput> outputs;
	protected ArrayList<LogChannelFilter> filters;
	
	public StandardLogChannel()
	{
		outputs = new ArrayList<>();
		filters = new ArrayList<>();
	}
	
	@Override
	public void log(String message)
	{
		for (LogChannelOutput o : outputs)
		{
			o.write(new LogMessage(message, severity));
		}
	}

	@Override
	public void log(String message, Object source)
	{
		for (LogChannelOutput o : outputs)
		{
			o.write(new LogMessage(message, severity, source));
		}
	}

	@Override
	public void addOutput(LogChannelOutput output)
	{
		outputs.add(output);
	}

	@Override
	public boolean removeOutput(LogChannelOutput output)
	{
		return outputs.remove(output);
	}

	@Override
	public LogChannelOutput[] getOutputs()
	{
		return outputs.toArray(new LogChannelOutput[0]);
	}

	@Override
	public void addFilter(LogChannelFilter filter)
	{
		filters.add(filter);
	}

	@Override
	public boolean removeFilter(LogChannelFilter filter)
	{
		return filters.remove(filter);
	}

	@Override
	public LogChannelFilter[] getFilters()
	{
		return filters.toArray(new LogChannelFilter[0]);
	}

	@Override
	public void setSeverityLevel(int severity)
	{
		this.severity = severity;
	}

	@Override
	public int getSeverityLevel()
	{
		return this.severity;
	}

}