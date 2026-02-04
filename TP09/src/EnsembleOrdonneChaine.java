public class EnsembleOrdonneChaine extends EnsembleChaine implements EnsembleOrdonne {

    @Override
    public int minimum() {
        if (estVide()) {
            return -1;
        } else {
            Cellule currentCel = tete;
            while(currentCel.suivant != null) {
                currentCel = currentCel.suivant;
            }
        }
        return -1;
    }

}
