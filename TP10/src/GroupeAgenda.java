public class GroupeAgenda extends AgendaAbstrait {

    public GroupeAgenda(String nom) {
        super(nom);
    }

    public void ajouter(Agenda agenda) {
    }

    @Override
    public String getNom() {
        return "";
    }

    @Override
    public void enregistrer(int creneau, String rdv) throws OccupeException {

    }

    @Override
    public boolean annuler(int creneau) {
        return false;
    }

    @Override
    public String getRendezVous(int creneau) throws LibreException {
        return "";
    }

    public void proposer(int i, String ok) {
    }
}
