package tn.esprit.td.entities;

public class EtudiantAlternance extends Etudiant{
    private int salaire;

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public EtudiantAlternance(int identifiant, String nom, String prenom, float moyenne,int salaire) {
        super(identifiant, nom, prenom, moyenne);
        this.salaire=salaire;
    }

    @Override
    public void ajouterUneAbsence(){
    this.salaire-=50;
        if(this.salaire<0){
            this.salaire=0;
        }
    }

    @Override
    public String toString() {
        return "EtudiantAlternance{" +
                "salaire=" + salaire +
                "} " + super.toString();
    }
}
