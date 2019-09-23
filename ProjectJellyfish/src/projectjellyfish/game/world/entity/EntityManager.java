/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.game.world.entity;


import java.util.ArrayList;
import java.util.Iterator;

public class EntityManager<T extends Entity> implements Iterable<T>
{
    protected ArrayList<T> entities = new ArrayList<>();
    
    @Override
    public Iterator<T> iterator()
    {
	return entities.iterator();
    }
    
    public void add(T e)
    {
	entities.add(e);
    }
    
    public void remove(T e)
    {
	entities.remove(e);
    }
    
    public T get(int index)
    {
	return entities.get(index);
    }
    
    public T[] getArray(T[] t)
    {
        return entities.toArray(t);
    }
}
