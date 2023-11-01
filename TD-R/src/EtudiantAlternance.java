public class EtudiantAlternance extends Etudiant{
private int salaire;

public EtudiantAlternance(int salaire){this.salaire=salaire;}


public int getSalaire(){return salaire;}
public void setSalaire(int salaire){this.salaire=salaire;}


    void ajouterUneAbsence(){
    setSalaire(getSalaire()+50000);
}

    @Override
    public String toString() {
        return "Salaire: " + salaire;
    }
}
