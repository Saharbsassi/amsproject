package com.sip.ams.entities;

public class Etudiant {
		private String nom; 
		private int age;
		private String email;
		private String adresse;
		private int tel;
		public Etudiant(String nom,int age, String email,String adresse,int tel) {
			this.nom = nom;
			this.age = age;
			this.email = email;
			this.adresse = adresse;
			this.tel = tel;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAdresse() {
			return adresse;
		}
		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}
		@Override
		public String toString() {
			return "Etudiant [nom=" + nom + ", age=" + age + ", email=" + email + ", adresse=" + adresse + ", tel="
					+ tel + "]";
		}
		public int getTel() {
			return tel;
		}
		public void setTel(int tel) {
			this.tel = tel;
		}	
	
}
