import java.util.*;
import java.util.stream.Collectors;

public class Annuaire {

    private Map<String, String> annuaire;

    public Annuaire() {
        this.annuaire = new HashMap<>();
    }

    public void enregistrerArrivee(String personnel, String bureau) throws NullPointerException, DejaPresentException {
        if (personnel == null || bureau == null) {
            throw new NullPointerException();
        }
        if (this.annuaire.containsKey(personnel)) {
            throw new DejaPresentException();
        }
        this.annuaire.put(personnel, bureau);
    }

    public void modifierBureau(String personnel, String bureau) throws NullPointerException, PersonnelInconnuException {
        if (personnel == null || bureau == null) {
            throw new NullPointerException();
        }
        if (!this.annuaire.containsKey(personnel)) {
            throw new PersonnelInconnuException();
        }
        this.annuaire.replace(personnel, bureau);
    }

    public String bureau(String personnel) throws NullPointerException, PersonnelInconnuException {
        if (personnel == null) {
            throw new NullPointerException();
        }
        if (!this.annuaire.containsKey(personnel)) {
            throw new PersonnelInconnuException();
        }
        return this.annuaire.get(personnel);
    }

    public void enregistrerDepart(String personnel) throws NullPointerException, PersonnelInconnuException {
        if (personnel == null) {
            throw new NullPointerException();
        }
        if (!this.annuaire.containsKey(personnel)) {
            throw new PersonnelInconnuException();
        }
        this.annuaire.remove(personnel);
    }

    public Collection<String> personnels() {
        return this.annuaire.keySet();
    }

    public Collection<String> bureaux() {
        return this.annuaire.values().stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public Collection<String> personnels(String bureau) throws NullPointerException {
        if (bureau == null) {
            throw new NullPointerException();
        }
        return this.annuaire.keySet().stream()
                .filter(personnel -> this.annuaire.get(personnel).equals(bureau))
                .collect(Collectors.toList());
    }

    public void afficher() {
        for (Map.Entry entry : this.annuaire.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public Map<String, List<String>> occupationBureaux() {
        return this.annuaire.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
    }

    public void afficherParBureau() {
        for (Map.Entry entry : this.occupationBureaux().entrySet()) {
            System.out.println(entry.getKey() + " :");
            for (String personnel : (List<String>) entry.getValue()) {
                System.out.println("  " + personnel);
            }
        }
    }
}
