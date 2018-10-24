/*
 * No license is included with the package at this time.
 * Copyright 2018, Finck (github.com/cfinck27) and Gryphon (github.com/GriffFr)
 */

package projectjellyfish.game;


import java.util.logging.Level;
import java.util.logging.Logger;
import projectjellyfish.game.world.World;
import projectjellyfish.window.Window;
import projectjellyfish.window.Window_Swing;
import projectjellyfish.window.graphics.Color;
import projectjellyfish.window.graphics.DrawingContext;

public class Game implements Runnable
{
    
    // Singleton game instance
    private static Game instance = null;
    public static Game getInstance()
    {
        if (instance == null)
        {
            instance = new Game();
        }
        
        return instance;
    }
    
    protected World world;
    protected Window window;
    protected GameTimeManager ticks;
    
    private double x = 0.0;
    
    
    private Game()
    {
        
    }
    
    private void setup()
    {
        world = new World();
	window = new Window_Swing("Project Jellyfish", 500, 500);
        ticks = new GameTimeManager();
        ticks.setTimestep(1.0 / 60.0);
    }
    
    private void update()
    {
        x += ticks.getTimestep() * 100;
    }
    
    private void draw()
    {
        DrawingContext g = window.getGraphics();

        g.clear();

        g.rotate(Math.PI * x / 128.0, x + 100.0, 200.0);

        g.setColor(new Color(255, 255, 255));
        g.fillRect(x, 100.0, 200.0, 200.0);
        g.setColor(new Color(0, 0, 0));
        g.drawRect(x, 100.0, 200.0, 200.0);

        g.present();
    }
    
    @Override
    public void run()
    {
        setup();
        
        window.show();
        
        System.out.println("Timestep: " + ticks.getTimestep());
        long start = System.currentTimeMillis();
        
        ticks.startFrame();
        
        while (true)
	{
            for (int i = 0; i < ticks.getElapsedTicks(); i++)
            {
                //System.out.println(ticks.getTotalTicks() + " : " + ((System.currentTimeMillis() - start) / 1000.0));
                update();
                draw();
            }
            
            try
            {
                // we do this because otherwise we will go too fast
                // and improperly capture elapsed cycles
                //
                // can probably remove once we start polling for events
                Thread.sleep(1);
            }
            catch (InterruptedException e)
            {
            }
            
            ticks.newFrame();
	}
    }
    
}
