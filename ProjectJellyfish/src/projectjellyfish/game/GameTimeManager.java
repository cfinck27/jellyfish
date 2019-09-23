/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
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
    protected int pTotalTicks = 0;
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
        pTotalTicks = totalTicks;
        totalTicks = (int) (totalTime / timestep);
    }
    
    public void newFrame()
    {
        stopFrame();
        startFrame();
    }
    
    public void setTimestep(double timestep)
    {
        this.timestep = timestep;
    }
    
    public double getTimestep()
    {
        return timestep;
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
    
    public int getElapsedTicks()
    {
        return (totalTicks - pTotalTicks);
    }
    
    public boolean isNewTick()
    {
        return (totalTicks > pTotalTicks);
    }
    
}
