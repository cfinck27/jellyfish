/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.game.world;

import projectjellyfish.debug.logging.LogChannel;
import projectjellyfish.game.Game;
import projectjellyfish.game.world.entity.Entity;
import projectjellyfish.window.input.InputEvent;
import projectjellyfish.window.input.KeyEvent;
import projectjellyfish.window.input.KeyListener;

public class Player implements KeyListener
{
    
    protected static LogChannel log;
    
    protected Entity playerEntity;
    
    public Player()
    {
        log = Game.getInstance().getLogger().getChannel(Game.LOG_GENERAL);
        Game.getInstance().getWindow().addKeyListener(this);
    }
    
    public Entity getPlayerEntity()
    {
        return playerEntity;
    }

    @Override
    public void onInput(KeyEvent e)
    {
        //Game.getInstance().getLog().println(e);
        log.log(e.toString());
    }

    @Override
    public void onInput(InputEvent e)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
