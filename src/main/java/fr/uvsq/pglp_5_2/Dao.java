package fr.uvsq.pglp_5_2;

import java.util.ArrayList;

public interface Dao<T> {
	
	public void serialize(T object, String file);
	
	public T deserialize(String file);
	
	public void add(T object);
	
	public T get(int id);
	
	public T update(T object);
	
	public void remove(T object);
	
}
