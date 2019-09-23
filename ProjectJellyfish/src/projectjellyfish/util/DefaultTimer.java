/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.util;


public class DefaultTimer implements Timer
{
    
    protected long startTime;
    protected long stopTime;
    
    public DefaultTimer()
    {
        startTime = System.currentTimeMillis();
        stopTime = 0;
    }
    
    @Override
    public void start()
    {
        startTime = System.currentTimeMillis();
    }
    
    @Override
    public double stop()
    {
        stopTime = System.currentTimeMillis();
        return (stopTime - startTime) / 1000.0;
    }
    
    @Override
    public double getTime()
    {
        if (startTime > stopTime)
        {
            return (System.currentTimeMillis() - startTime) / 1000.0;
        }
        else
        {
            return (stopTime - startTime) / 1000.0;
        }
    }
    
    @Override
    public boolean isRunning()
    {
        return (startTime > stopTime);
    }
}
