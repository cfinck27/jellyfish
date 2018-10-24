/*
 * No license is included with the package at this time.
 * Copyright 2018, Finck (github.com/cfinck27) and Gryphon (github.com/GriffFr)
 */

package projectjellyfish.game.world;


import projectjellyfish.game.world.entity.Entity;
import projectjellyfish.game.world.entity.EntityManager;
import projectjellyfish.game.world.entity.UpdateEntity;

public class World
{
    
    protected EntityManager<UpdateEntity> ent_update = new EntityManager<>();
    
    public World()
    {
    }
    
    public void register(Entity e)
    {
        if (e instanceof UpdateEntity)
        {
            ent_update.add((UpdateEntity)e);
        }
    }
    
    public UpdateEntity[] getEnts()
    {
        return ent_update.getArray(new UpdateEntity[0]);
    }
    
}