/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.debug.logging;

public class LogChannelStandardOutput implements LogChannelOutput
{

	@Override
	public void write(LogMessage message)
	{
		System.out.println(message);
	}

}