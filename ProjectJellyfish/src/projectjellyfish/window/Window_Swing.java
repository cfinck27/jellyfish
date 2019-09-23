/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.window;


import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import projectjellyfish.game.Game;
import projectjellyfish.util.Vec2i;
import projectjellyfish.window.graphics.DrawingContext_Swing;
import projectjellyfish.window.input.KeyEnum;
import projectjellyfish.window.input.KeyEvent;
import projectjellyfish.window.input.KeyState;

public class Window_Swing extends Window implements ComponentListener, java.awt.event.KeyListener
{

    protected class Window_JFrame extends JFrame
    {
	public Window_JFrame(String title)
	{
	    super(title);
	}
    }
    
    
    protected Window_JFrame frame;
    protected JPanel mainPane;
    protected JPanel secondaryPane;
    protected Canvas canvas;
    
    public Window_Swing(String title, int w, int h)
    {
	doInSwing(() ->
	{
	    frame = new Window_JFrame(title);
	    mainPane = new JPanel(new BorderLayout());
	    secondaryPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
	    canvas = new Canvas();

	    secondaryPane.setBackground(Color.GRAY);
	    canvas.setBackground(new Color(230, 230, 230));
	    
	    canvas.setPreferredSize(new Dimension(w, h));

	    secondaryPane.add(canvas); 
	    mainPane.add(secondaryPane, BorderLayout.CENTER);
	    frame.setContentPane(mainPane);
	    frame.pack();

	    frame.addComponentListener(this);
            frame.addKeyListener(this);
            
            frame.setFocusable(true);
            mainPane.setFocusable(false);
            secondaryPane.setFocusable(false);
            canvas.setFocusable(false);
            
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    canvas.createBufferStrategy(2);
            
	    graphics = new DrawingContext_Swing(canvas);
	});
    }
    
    public static void doInSwing(Runnable runMe)
    {
	try
	{
	    SwingUtilities.invokeAndWait(runMe);
	}
	catch (InterruptedException | InvocationTargetException ex)
	{
	    System.err.println("Window_Swing: Error while invoking runnable in swing thread");
	}
    }
    
    @Override
    public void componentResized(ComponentEvent e)
    {
	if (e.getComponent() == frame)
	{
	    canvas.setLocation(0, 0);
	    canvas.setSize(secondaryPane.getSize());
	}
    }

    @Override
    public void componentMoved(ComponentEvent e)
    {
    }

    @Override
    public void componentShown(ComponentEvent e)
    {
        Game.getInstance().getLog().println("Component Shown!");
    }

    @Override
    public void componentHidden(ComponentEvent e)
    {
	Game.getInstance().getLog().println("Component Hidden!");
    }
    
    @Override
    public void close()
    {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
    
    @Override
    public void show()
    {
	frame.setVisible(true);
    }
    
    @Override
    public void hide()
    {
	frame.setVisible(false);
    }
    
    @Override
    public boolean isVisible()
    {
	return frame.isVisible();
    }
    
    @Override
    public void setSize(int w, int h)
    {
	frame.setPreferredSize(new Dimension(w, h));
    }
    
    @Override
    public Vec2i getSize()
    {
	return new Vec2i(frame.getSize().width, frame.getSize().height);
    }
    
    @Override
    public void present()
    {
	graphics.present();
    }
    
    @Override
    public void pollEvents()
    {
        keyStates.pollKeyEvents();
        
        // update key states after polling events
        keyStates.updateStates();
    }
    
    @Override
    public boolean isKeyDown(int kc)
    {
        return keyStates.getKeyState(KeyEnum.getKeyByCode(kc)).isPressed() ||
               keyStates.getKeyState(KeyEnum.getKeyByCode(kc)).isHeld();
    }

    @Override
    public void keyTyped(java.awt.event.KeyEvent e)
    {
        // nothing
    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent e)
    {
        KeyState pre = keyStates.getKeyState(KeyEnum.getKeyByCode(e.getKeyCode()));
        KeyState post = new KeyState(pre);
        post.press();
        KeyEvent out = new KeyEvent(this, pre, post);
        this.fireKeyEvent(out);
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e)
    {
        KeyState pre = keyStates.getKeyState(KeyEnum.getKeyByCode(e.getKeyCode()));
        KeyState post = new KeyState(pre);
        post.release();
        KeyEvent out = new KeyEvent(this, pre, post);
        this.fireKeyEvent(out);
    }
    
}
