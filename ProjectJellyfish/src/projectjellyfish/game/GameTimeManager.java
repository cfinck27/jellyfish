/*
 * No license is included with the package at this time.
 * Copyright 2018, Finck (github.com/cfinck27) and Gryphon (github.com/GriffFr)
 */

package projectjellyfish.game;


/*
 *  FIXME: THIS CLASS SUCKS RIGHT NOW.. DOESNT WORK RIGHT
 */

import projectjellyfish.util.PreciseTimer;

public class GameTimeManager
{
    
    protected PreciseTimer gameTimer = new PreciseTimer();
    protected double delta = 0.0;
    protected double timestep = 1.0 / 60.0;
    protected double totalTime = 0.0;
    protected int totalTicks = 0;
    
    
    public GameTimeManager()
    {
    }
    
    
    public void startFrame()
    {
        gameTimer.start();
    }
    
    public void stopFrame()
    {
        delta = gameTimer.stop();
        totalTime += delta;
        totalTicks = (int) (totalTime / timestep);
    }
    
    public double getDelta()
    {
        return delta;
    }
    
    public void setTimestep(double timestep)
    {
        this.timestep = timestep;
    }
    
    public double getTimestep()
    {
        return timestep;
    }
    
    public int getTickDelta()
    {
        return (int) (delta / timestep);
    }
    
    public double getInterpDelta()
    {
        return (delta % timestep);
    }
    
    public double getTotalTime()
    {
        return totalTime;
    }
    
    public int getTotalTicks()
    {
        return totalTicks;
    }
    
    public boolean isNewTick()
    {
        return (int) ((totalTime - delta) / timestep) != (int) (totalTime / timestep);
    }
    
}
