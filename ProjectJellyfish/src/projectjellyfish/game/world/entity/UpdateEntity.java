/*
 * No license is included with the package at this time.
 * Copyright 2018, Finck (github.com/cfinck27) and Gryphon (github.com/GriffFr)
 */

package projectjellyfish.game.world.entity;


import projectjellyfish.game.world.IUpdateable;

public abstract class UpdateEntity extends Entity implements IUpdateable
{

    public UpdateEntity()
    {
    }
    
    @Override
    public abstract void update(double timestep);
    
}
