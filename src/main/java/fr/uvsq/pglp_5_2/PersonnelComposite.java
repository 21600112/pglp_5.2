package fr.uvsq.pglp_5_2;

import java.util.ArrayList;
import java.util.Iterator;

public class PersonnelComposite implements PersonnelInterface{
	
	public ArrayList<PersonnelInterface> p;
	private final int id;
	private static int cpt = 0;
		
	public PersonnelComposite() {
		id = cpt++;
		p = new ArrayList<PersonnelInterface>();
	}
	
	public PersonnelComposite add(final PersonnelInterface i) {
		if(!p.contains(i))
			p.add(i);
		
		return this;
	}
	
	public PersonnelComposite remove(final PersonnelInterface i)
	{
		if(p.contains(i))
			p.remove(i);
		
		return this;
			
	}
	
	public Iterator<PersonnelInterface> getIterator()
	{
		return p.iterator();
	}
	
	public void print()
	{
		for(PersonnelInterface i : p)
			i.print();
	}
	
	public int getId()
	{
		return id;
	}
}

