/*
 * No license is included with the package at this time.
 * Copyright 2018, Finck (github.com/cfinck27) and Gryphon (github.com/GriffFr)
 */

package projectjellyfish.util;


public interface Timer
{
    
    public void start();
    public double stop();
    
    public double getTime();
    public boolean isRunning();
    
}
