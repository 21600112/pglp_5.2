package fr.uvsq.pglp_5_2;

import java.util.ArrayList;
import java.time.LocalDate;

public class Personnel implements PersonnelInterface{
	
	private final int id;
	private final String nom;
	private final String prenom;
	private final String fonction;
	private final java.time.LocalDate dateNaissance;
	private ArrayList<String> numeroTelephone;
	
	public static class Builder {
		
		private final int id;
		private final String nom;
		private final String prenom;
		private final String fonction;
		private final java.time.LocalDate dateNaissance;
		private final ArrayList<String> numeroTelephone;
		
		Builder(final int id,final String nom,final String prenom,final String fonction,final LocalDate dateNaissance,final ArrayList<String> numeroTelephone)
		{
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
			this.dateNaissance = dateNaissance;
			this.fonction = fonction;
			this.numeroTelephone = numeroTelephone;
			
		}
		
		public void print(){
			System.out.print("nom : "+nom+" prenm : "+prenom+" fonction : "+fonction+" date de naissance : "+dateNaissance+
					" numero de tel : ");
		}
		
		public Personnel build()
		{
			return new Personnel(this);
		}
	}
	
	public Personnel(Builder b) {
		this.id = b.id;
		this.nom = b.nom;
		this.prenom = b.prenom;
		this.fonction = b.fonction;
		this.dateNaissance = b.dateNaissance;
		this.numeroTelephone = b.numeroTelephone;
	}
	
	public void print(){
		System.out.print("nom : "+nom+" prenm : "+prenom+" fonction : "+fonction+" date de naissance : "+dateNaissance+
				" numero de tel : ");
	}
	
	public int getId()
	{
		return id;
	}
	
}

