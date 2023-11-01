public class Etudiant {
    private int identifiant;
    private String nom;
    private String prenom;
    private float moyenne;

    void ajouterUneAbsence(){};
    //void abstract ajouterUneAbsence2(){};
    public Etudiant(){}
    public Etudiant( int identifiant, String nom, String prenom, float moyenne){
    this.identifiant=identifiant;
    this.nom=nom;
    this.prenom=prenom;
    this.moyenne=moyenne;
    }

    public int getIdentifiant(){return identifiant; }
    public void setIdentifiant(int identifiant){this.identifiant=identifiant;}

    public String getNom(){return nom; }
    public void setNom(String nom){this.nom=nom;}

    public String getPrenom(){return prenom;}
    public void setPrenom(String prenom){this.prenom=prenom;}

    public float getMoyenne(){return moyenne;}
    public void setMoyenne(float moyenne){this.moyenne=moyenne;}

/*
        @Override
        public boolean equals(Object obj) {
            if (null == obj) return false;
            if (obj instanceof Etudiant etudiant){
                //return identifiant == autreEtudiant.identifiant && nom.equals(autreEtudiant.nom);            }

            return false;
        }
*/

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj instanceof Etudiant etudiant) {
            return identifiant==etudiant.getIdentifiant() && nom.equals(etudiant.getNom());
}
        return false;
    }

    @Override
    public String toString() {
        return "Identifiant: " + identifiant + ", Nom: " + nom + ", Prénom: " + prenom + ", Moyenne: " + moyenne;
    }

}
