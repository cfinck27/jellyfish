/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.util;


public interface Timer
{
    
    public void start();
    public double stop();
    
    public double getTime();
    public boolean isRunning();
    
}
