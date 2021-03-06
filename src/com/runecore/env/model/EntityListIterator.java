package com.runecore.env.model;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * EntityListIterator.java
 * @author Harry Andreas<harry@runecore.org>
 * Feb 11, 2013
 */
public class EntityListIterator<E extends Entity> implements Iterator<E> {

	/**
	 * The entities.
	 */
	private final Entity[] entities;
	/**
	 * The entity list.
	 */
	private final EntityList<E> entityList;
	/**
	 * The previous index.
	 */
	private int lastIndex = -1;
	/**
	 * The current index.
	 */
	private int cursor = 0;
	/**
	 * The size of the list.
	 */
	private final int size;

	/**
	 * Creates an entity list iterator.
	 * 
	 * @param entityList
	 *            The entity list.
	 */
	public EntityListIterator(EntityList<E> entityList) {
		this.entityList = entityList;
		entities = entityList.toArray(new Entity[0]);
		size = entities.length;
	}

	@Override
	public boolean hasNext() {
		return cursor < size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		lastIndex = cursor++;
		return (E) entities[lastIndex];
	}

	@Override
	public void remove() {
		if (lastIndex == -1) {
			throw new IllegalStateException();
		}
		entityList.remove(entities[lastIndex]);
	}
}
