/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.window;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import projectjellyfish.util.Vec2i;

public class Sprite
{
    
    protected File src;
    protected final BufferedImage img;
    
    public Sprite(String imgPath) throws IOException
    {   
        src = new File(imgPath);
        img = ImageIO.read(src);
    }
    
    public Vec2i getSize()
    {
        return new Vec2i(img.getWidth(), img.getHeight());
    }
    
    public BufferedImage getBufferedImage()
    {
        return img;
    }
    
    public String getPath()
    {
        return src.getPath();
    }
}
