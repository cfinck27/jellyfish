/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.game.world;

import projectjellyfish.game.Game;
import projectjellyfish.game.world.entity.Entity;
import projectjellyfish.window.input.InputEvent;
import projectjellyfish.window.input.KeyEvent;
import projectjellyfish.window.input.KeyListener;

public class Player implements KeyListener
{
    
    protected Entity playerEntity;
    
    public Player()
    {
        Game.getInstance().getWindow().addKeyListener(this);
    }
    
    public Entity getPlayerEntity()
    {
        return playerEntity;
    }

    @Override
    public void onInput(KeyEvent e)
    {
        Game.getInstance().getLog().println(e);
    }

    @Override
    public void onInput(InputEvent e)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
