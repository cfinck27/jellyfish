/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
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
