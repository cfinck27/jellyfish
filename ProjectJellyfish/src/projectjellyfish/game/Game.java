/*
 * No license is included with the package at this time.
 * Copyright 2018, Finck (github.com/cfinck27) and Gryphon (github.com/GriffFr)
 */

package projectjellyfish.game;


import projectjellyfish.debug.JLog;
import projectjellyfish.game.messaging.Console;
import projectjellyfish.game.messaging.MessageCallback;
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
    
    protected JLog log;
    protected Console console;
    protected Thread conThread;
    protected Window window;
    
    protected World world;
    protected GameTimeManager ticks;
    
    protected boolean isExiting = false;
    
    private double x = 0.0;
    
    
    private Game()
    {
    }
    
    private void setup()
    {   
        log = new JLog(System.out);
        log.setOutputFile("gamelog" + System.currentTimeMillis() + ".log");
        
        console = new Console(System.in, System.out);
        conThread = new Thread(console);
        conThread.start();
        
	window = new Window_Swing("Project Jellyfish", 500, 500);
        
        world = new World();
        ticks = new GameTimeManager();
        ticks.setTimestep(1.0 / 60.0);
        
        console.addCommand("exit", new MessageCallback(this, "exit"));
    }
    
    private void shutdown()
    {
        window.close();
        try
        {
            conThread.join(1000);
        }
        catch (InterruptedException ex)
        {
            log.println("GAME: Thread interrupted while shutting down.");
        }
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
        
        log.println("This is a test...");
        log.println("Yet another test...");
        
        System.out.println("Timestep: " + ticks.getTimestep());
        
        ticks.startFrame();
        
        while (!instance.isExiting())
	{
            console.pollMessages();
            window.pollEvents();
            
            for (int i = 0; i < ticks.getElapsedTicks(); i++)
            {
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
        
        shutdown();
    }
    
    public JLog getLog()
    {
        return log;
    }
    
    public Console getConsole()
    {
        return console;
    }
    
    public boolean isExiting()
    {
        return isExiting;
    }
    
    public void exit()
    {
        isExiting = true;
    }
    
}
