/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.debug.logging;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class LogChannelFileOutput implements LogChannelOutput
{
	
	protected File file;
	protected PrintWriter writer;
	
	public LogChannelFileOutput(File file) throws FileNotFoundException
	{
		this.file = file;
		writer = new PrintWriter(file);
	}

	@Override
	public void write(LogMessage message)
	{
		writer.println(message);
		writer.flush();
	}
	
}