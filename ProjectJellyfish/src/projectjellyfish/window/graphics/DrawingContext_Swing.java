/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.window.graphics;


import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.geom.AffineTransform;
import java.util.EmptyStackException;
import java.util.Stack;
import projectjellyfish.util.Vec2d;
import projectjellyfish.window.Sprite;
import projectjellyfish.window.Window_Swing;

public class DrawingContext_Swing extends DrawingContext
{
    protected Canvas canvas;
    protected Graphics2D graphics;
    protected final AffineTransform defaultTransform;
    protected final Stack<AffineTransform> matrix = new Stack<>();
    
    protected int lastFps = 0;
    protected int fps = 0;
    protected long fpsTimer;
    

    public DrawingContext_Swing(Canvas canvas)
    {
	this.canvas = canvas;
        
	graphics = (Graphics2D)canvas.getBufferStrategy().getDrawGraphics();
	defaultTransform = graphics.getTransform();
	fpsTimer = System.currentTimeMillis();
    }
    
    @Override
    public void clear()
    {
	Window_Swing.doInSwing(() ->
	{
	    graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
	});
    }
    
    @Override
    public void drawRect(double x, double y, double w, double h)
    {
	Window_Swing.doInSwing(() ->
	{
	    graphics.drawRect((int)x, (int)y, (int)w, (int)h);
	});
    }

    @Override
    public void drawRect(Vec2d pos, Vec2d dim)
    {
	Window_Swing.doInSwing(() ->
	{
	    graphics.drawRect(pos.x.intValue(), pos.y.intValue(), dim.x.intValue(), dim.y.intValue());
	});
    }

    @Override
    public void fillRect(double x, double y, double w, double h)
    {
	Window_Swing.doInSwing(() ->
	{
	    graphics.fillRect((int)x, (int)y, (int)w, (int)h);
	});
    }

    @Override
    public void fillRect(Vec2d pos, Vec2d dim)
    {
	Window_Swing.doInSwing(() ->
	{
	    graphics.fillRect(pos.x.intValue(), pos.y.intValue(), dim.x.intValue(), dim.y.intValue());
	});
    }

    @Override
    public void setColor(Color c)
    {
	Window_Swing.doInSwing(() ->
	{
            // FIXME
	    //graphics.setPaint(new java.awt.Color(c.r, c.g, c.b, c.a));
	});
    }

    @Override
    public Color getColor()
    {
	java.awt.Color c = (java.awt.Color)graphics.getPaint();
	return new Color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
    }
    
    @Override
    public void present()
    {
	if (System.currentTimeMillis() - fpsTimer > 1000)
	{
	    fpsTimer = System.currentTimeMillis();
	    lastFps = fps;
	    fps = 0;
	}
	else
	{
	    ++fps;
	}
	
	Window_Swing.doInSwing(() ->
	{
	    graphics.setTransform(defaultTransform);
	    graphics.setPaint(java.awt.Color.RED);
	    graphics.setStroke(new BasicStroke(3));
	    graphics.drawRect(0, 0, canvas.getWidth() - 1, canvas.getHeight() - 1);
	    
	    graphics.setPaint(java.awt.Color.BLACK);
	    graphics.drawString("" + lastFps, 25.0f, 25.0f);

	    
	    canvas.getBufferStrategy().show();
	    graphics = (Graphics2D)canvas.getBufferStrategy().getDrawGraphics();
	});
    }
    
    @Override
    public void rotate(double theta)
    {
	Window_Swing.doInSwing(() ->
	{
	    graphics.rotate(theta);
	});
    }
    
    @Override
    public void rotate(double theta, double x, double y)
    {
	Window_Swing.doInSwing(() ->
	{
	    graphics.rotate(theta, x, y);
	});
    }
    
    @Override
    public void scale(double x, double y)
    {
	Window_Swing.doInSwing(() ->
	{
	    graphics.scale(x, y);
	});
    }
    
    @Override
    public void translate(double x, double y)
    {
	Window_Swing.doInSwing(() ->
	{
	    graphics.translate(x, y);
	});
    }
    
    @Override
    public void pushMatrix()
    {
	matrix.push((AffineTransform)graphics.getTransform().clone());
    }
    
    @Override
    public void popMatrix()
    {
	Window_Swing.doInSwing(() ->
	{
	    try
	    {
		graphics.setTransform(matrix.pop());
	    }
	    catch (EmptyStackException ex)
	    {
		graphics.setTransform(defaultTransform);
		System.err.println("DrawingContext_Swing: Attempted to pop matrix beyond stack size!");
	    }
	});
    }
    
    @Override
    public void drawSprite(Sprite img, double x, double y)
    {
        Window_Swing.doInSwing(() ->
        {
            graphics.drawImage(img.getBufferedImage(), null, (int)x, (int)y);
        });
    }
}
