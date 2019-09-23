/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.game.world;


import projectjellyfish.game.world.entity.Entity;
import projectjellyfish.game.world.entity.EntityManager;
import projectjellyfish.game.world.entity.UpdateEntity;

public class World
{
    
    protected Player player;
    protected EntityManager<UpdateEntity> ent_update = new EntityManager<>();
    
    public World()
    {
        player = new Player();
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
