public class Ecole {
    String nom;

    private Etudiant[] etudiants,alternants;
    //private Etudiant[] alternants;
    private int nombreEtudiants;

    public Ecole(String nom) {
        this.nom = nom;
        this.etudiants = new Etudiant[500];
        this.alternants = new Etudiant[500];
    }
/*
    public void ajouterEtudiant(Etudiant etudiant) {
        if (nombreEtudiants < etudiants.length) {
            etudiants[nombreEtudiants] = etudiant;
            nombreEtudiants++;
        } else {
            System.out.println("L'école est pleine, impossible d'ajouter plus d'étudiants.");
        }
    }
*/
    // Méthode pour ajouter un étudiant à l'école
    public void ajouterEtudiant(Etudiant etudiant) {
        // Vérifier si l'étudiant n'est pas déjà inscrit à l'école
        if (rechercherEtudiant(etudiant) != -1) {
            System.out.println("L'étudiant est déjà inscrit à l'école.");
        } else {
            if (nombreEtudiants < etudiants.length) {
                etudiants[nombreEtudiants] = etudiant;
                nombreEtudiants++;
            } else {
                System.out.println("L'école est pleine, impossible d'ajouter plus d'étudiants.");
            }
        }
    }


    public int rechercherEtudiant(Etudiant etudiant) {
        for (int i = 0; i < nombreEtudiants; i++) {
            if (etudiants[i].equals(etudiant)) {
                return i; // Étudiant trouvé, retourne l'indice
            }
        }
        return -1; // Étudiant non trouvé
    }


    public float getMoyenneDes3A() {
        float sommeMoyennes = 0;
        int nombreEtudiants3A = 0;

        for (int i = 0; i < nombreEtudiants; i++) {
            if (etudiants[i] instanceof Etudiant3eme) {
                // Vérifie si l'étudiant est une instance de Etudiant3eme (3A)
                Etudiant3eme etudiant3A = (Etudiant3eme) etudiants[i]; // Cast vers Etudiant3eme
                sommeMoyennes += etudiant3A.getMoyenne(); // Obtient la moyenne de l'étudiant de 3A
                nombreEtudiants3A++;
            }
        }

        if (nombreEtudiants3A > 0) {
            return sommeMoyennes / nombreEtudiants3A;
        } else {
            return 0; // Aucun étudiant de 3A trouvé
        }
    }


    public float moyenneSalaireAlternants() {
        float sommeSalaires = 0;
        int nombreAlternants = 0;

        for (Etudiant etudiant : etudiants) {
            if (etudiant instanceof EtudiantAlternance) {
                EtudiantAlternance alternant = (EtudiantAlternance) etudiant; // Cast vers EtudiantAlternance
                sommeSalaires += alternant.getSalaire();
                nombreAlternants++;
            }
        }

        if (nombreAlternants > 0) {
            return sommeSalaires / nombreAlternants;
        } else {
            return 0; // Aucun étudiant alternant trouvé
        }
    }




    public void changerEcole(Etudiant etudiant, Ecole nouvelleEcole) {
        int indexAChanger = -1;

        // Rechercher l'étudiant à changer d'école dans le tableau
        for (int i = 0; i < etudiants.length; i++) {
            if (etudiants[i] != null && etudiants[i].equals(etudiant)) {
                indexAChanger = i;
                break;
            }
        }

        if (indexAChanger != -1) {
            // Retirer l'étudiant de l'école actuelle
            etudiants[indexAChanger] = null;

            // Ajouter l'étudiant à la nouvelle école
            nouvelleEcole.ajouterEtudiant(etudiant);

            System.out.println(etudiant.getNom() + " a changé d'école.");
        } else {
            System.out.println(etudiant.getNom() + " n'est pas inscrit dans cette école.");
        }
    }



}
