/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.debug.logging;

import java.util.HashMap;
import java.util.Map;

public class StandardLogger implements Logger
{

	protected Map<String, LogChannel> channels;
	
	public StandardLogger()
	{
		channels = new HashMap<>();
	}
	
	@Override
	public LogChannel getChannel(String id)
	{
		return channels.get(id);
	}

	@Override
	public boolean addChannel(String id, LogChannel channel)
	{
		return (channels.put(id, channel) != null);
	}

	@Override
	public boolean removeChannel(String id)
	{
		return (channels.remove(id) != null);
	}

	@Override
	public LogChannel[] getChannels()
	{
		return channels.values().toArray(new LogChannel[0]);
	}

}