/*
 * No license is included with the package at this time.
 * Copyright 2018, Finck (github.com/cfinck27) and Gryphon (github.com/GriffFr)
 */

package projectjellyfish.game;


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
    
    @Override
    public void run()
    {
        setup();
        
        window.show();
        double x = 0.0;
        
        while (true)
	{
            ticks.startFrame();
            if (ticks.isNewTick())
            {
                DrawingContext g = window.getGraphics();

                g.clear();

                g.rotate(Math.PI * x / 128.0, x + 100.0, 200.0);

                g.setColor(new Color(255, 255, 255));
                g.fillRect(x, 100.0, 200.0, 200.0);
                g.setColor(new Color(0, 0, 0));
                g.drawRect(x, 100.0, 200.0, 200.0);

                g.present();
                
                System.out.printf("%.8f\n", ticks.getDelta());
            }
            
	    x += ticks.getDelta() * 100;
            
            ticks.stopFrame();
	}
    }
    
}