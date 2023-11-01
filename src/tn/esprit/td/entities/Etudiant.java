package tn.esprit.td.entities;

public abstract class Etudiant {
    public int identifiant;
    public String nom,prenom ;
    public float moyenne;

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public float getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }

    public Etudiant(int identifiant, String nom, String prenom, float moyenne) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.moyenne = moyenne;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj){
            return true;
        }
        if (this==null){
            return false;
        }
        if(obj instanceof Etudiant){
            Etudiant etudiant = (Etudiant) obj;
            return this.getIdentifiant()==etudiant.getIdentifiant() && this.getNom()==etudiant.getNom();
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "identifiant=" + identifiant +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", moyenne=" + moyenne +
                '}';
    }

    public abstract void  ajouterUneAbsence();
}
