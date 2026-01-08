public class EnsembleChaine implements Ensemble {

    private Cellule tete;

    public EnsembleChaine() {
        this.tete = null;
    }

    @Override
    public int cardinal() {
        int count = 0;
        Cellule currentCel = tete;
        while(currentCel != null) {
            count++;
            currentCel = currentCel.suivant;
        }
        return count;
    }

    @Override
    public boolean estVide() {
        return this.tete == null;
    }

    @Override
    public boolean contient(int x) {
        Cellule currentCel = tete;
        while(currentCel != null) {
            if(currentCel.valeur == x) {
                return true;
            }
            currentCel = currentCel.suivant;
        }
        return false;
    }

    @Override
    public void ajouter(int x) {
        Cellule currentCel = tete;
        if(estVide()) {
            tete = new Cellule(x, null);
        } else {
            if(!contient(x)) {
                while(currentCel.suivant != null) {
                    currentCel = currentCel.suivant;
                }
                currentCel.suivant = new Cellule(x, null);
            }
        }
    }

    @Override
    public void supprimer(int x) {
        Cellule currentCel = tete;
        if(contient(x)) {
            if(tete.valeur == x) {
                tete = tete.suivant;
            } else {
                while(currentCel.suivant.valeur != x) {
                    currentCel = currentCel.suivant;
                }
                currentCel.suivant = currentCel.suivant.suivant;
            }
        }
    }
}
