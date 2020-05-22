package fr.uvsq.pglp_5_2;

import java.util.ArrayList;
import java.io.*;

public class DaoPersonnel implements Dao<Personnel> {
	
	
	
	public void serialize(final Personnel p,final String file){
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
	
	public Personnel deserialize(final String file)
	{
		Personnel p = null;
		ObjectInputStream in = null;
		try {
			final FileInputStream fichier = new FileInputStream(file);
			in = new ObjectInputStream(fichier);
			p = (Personnel) in.readObject();
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
	
	
	private ArrayList<Personnel> list;
	
	public DaoPersonnel()
	{
		list = new ArrayList<Personnel>();
	}
	
	public void add(final Personnel p)
	{
		File f = new File("Personnel");
		String[] liste = f.list();
		
		for(int i = 0;i<liste.length;i++)
			if(p.getId() == Integer.parseInt(liste[i]))
				return;
		
		this.serialize(p, "Personnel\\"+p.getId());
	}
	
	public Personnel get(int id)
	{	
		File f = new File("Personnel");
		String[] liste = f.list();
		for(int i = 0; i<liste.length;i++)
			if(Integer.parseInt(liste[i]) == id)
				return this.deserialize("Personnel\\"+liste[i]);
		return null;
	}
	
	public Personnel update(Personnel p)
	{
		Personnel pTransi = this.get(p.getId());
		if(pTransi != null)
		{
			this.remove(p);
			this.add(pTransi);
			return pTransi;
		}
		return null;
	}
	
	public void remove(Personnel p)
	{
		if(this.get(p.getId()) != null)
		{
			File f = new File("Personnel\\" + p.getId());
			f.delete();
		}
	}
	
}
