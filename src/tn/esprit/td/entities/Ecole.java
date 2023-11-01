package tn.esprit.td.entities;

import java.util.Arrays;

public class Ecole {
    private String nom;
    private Etudiant [] etudiants;
    private int nbrEtudiants;
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Ecole(String nom) {
        this.etudiants=new Etudiant[500];
        this.nom = nom;
    }

    public int rechercherEtudiant(Etudiant e){
        for(int i=0;i<etudiants.length;i++){
            if (etudiants[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public void ajouterEtudiant(Etudiant e){
        if(rechercherEtudiant(e)==-1){
            if (nbrEtudiants<etudiants.length){
                etudiants[nbrEtudiants]=e;
                nbrEtudiants++;
                System.out.println("Etudiant bien ajouté");
            }else {
                System.out.println("l'ecole est plein");
            }
        }else{
            System.out.println("Ce étudiant est déja inscri");
        }
    }
    public float getMoyenneDes3a(){
        float moyenne3A=0;
        int nbrEtu3A=0;

        for (Etudiant etudiant : etudiants) {
            if (etudiant instanceof Etudiant3eme) {
                moyenne3A += etudiant.getMoyenne();
                nbrEtu3A++;
            }
        }
        return moyenne3A/nbrEtu3A;

    }

    public float moyenneSalaireAlternants(){
        float salaireMoy=0;
        int nbrEtuAlternant=0;

        for (Etudiant etudiant : etudiants) {
            if (etudiant instanceof EtudiantAlternance) {
                salaireMoy += ((EtudiantAlternance) etudiant).getSalaire();
                nbrEtuAlternant++;
            }
        }
        return salaireMoy/nbrEtuAlternant;

    }

    public void changerEcole(Etudiant etd,Ecole e){
        int etudiantInd = rechercherEtudiant(etd);

        if (etudiantInd != -1) {
            for (int i = etudiantInd; i < nbrEtudiants - 1; i++) {
                etudiants[i] = etudiants[i + 1];

            }
            nbrEtudiants--;

                e.ajouterEtudiant(etd);
                e.etudiants[nbrEtudiants] = etd;
                e.nbrEtudiants++;
                System.out.println("etudiant a bien changé d'école.");

        } else {
            System.out.println("Cet étudiant n'est pas inscrit .");

        }
    }


    @Override
    public String toString() {
        return "Ecole{" +
                "nom='" + nom + '\'' +
                ", etudiants=" + Arrays.toString(etudiants) +
                ", nbrEtudiants=" + nbrEtudiants +
                '}';
    }
}
