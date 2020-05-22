package fr.uvsq.pglp_5_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DaoPersonnelComposite implements Dao<PersonnelComposite> {
	
	
	public void serialize(PersonnelComposite p, String file)
	{
		ObjectOutputStream out = null;
		try {
			final FileOutputStream fichier = new FileOutputStream(file);
			out = new ObjectOutputStream(fichier);
			out.writeObject(p);
			out.flush();
		}
		catch(java.io.IOException e){
			e.printStackTrace();
		}
		try {
			out.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public PersonnelComposite deserialize(String file)
	{
		PersonnelComposite p = null;
		ObjectInputStream in = null;
		try {
			final FileInputStream fichier = new FileInputStream(file);
			in = new ObjectInputStream(fichier);
			p = (PersonnelComposite) in.readObject();
			fichier.close();
		}
		catch(java.io.IOException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try {
			in.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return p;
	
	}
	
	public void add(PersonnelComposite p)
	{
		File f = new File("PersonnelComposite");
		String[] liste = f.list();
		
		for(int i = 0;i<liste.length;i++)
			if(p.getId() == Integer.parseInt(liste[i]))
				return;
		
		this.serialize(p, "PersonnelComposite\\"+p.getId());
	}
	
	public PersonnelComposite get(int id)
	{
		File f = new File("PersonnelComposite");
		String[] liste = f.list();
		for(int i = 0; i<liste.length;i++)
			if(Integer.parseInt(liste[i]) == id)
				return this.deserialize("PersonnelComposite\\"+liste[i]);
		return null;
	}
	
	public PersonnelComposite update(PersonnelComposite p)
	{
		PersonnelComposite pTransi = this.get(p.getId());
		if(pTransi != null)
		{
			this.remove(p);
			this.add(pTransi);
			return pTransi;
		}
		return null;
	}
	
	public void remove(PersonnelComposite p)
	{
		if(this.get(p.getId()) != null)
		{
			File f = new File("PersonnelComposite\\" + p.getId());
			f.delete();
		}
	}
	
}
