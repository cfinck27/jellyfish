/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.util;


public class PreciseTimer implements Timer
{
    
    protected long startTime;
    protected long stopTime;
    
    public PreciseTimer()
    {
        startTime = System.nanoTime();
        stopTime = 0;
    }
    
    @Override
    public void start()
    {
        startTime = System.nanoTime();
    }
    
    @Override
    public double stop()
    {
        stopTime = System.nanoTime();
        return (stopTime - startTime) / 1000.0 / 1000000.0;
    }
    
    @Override
    public double getTime()
    {
        if (startTime > stopTime)
        {
            return (System.nanoTime() - startTime) / 1000.0 / 1000000.0;
        }
        else
        {
            return (stopTime - startTime) / 1000.0 / 1000000.0;
        }
    }
    
    @Override
    public boolean isRunning()
    {
        return (startTime > stopTime);
    }
    
}
