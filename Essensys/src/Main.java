import Angajati.Angajat;
import Angajati.AngajatiFunctionalitati;
import Angajati.Director;
import Atelier.Atelier;
import Masini.Camion;
import Masini.Masina;
import Masini.Standard;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {

        AngajatiFunctionalitati functionalitatiAngajati = new AngajatiFunctionalitati();

        // Add employees
        functionalitatiAngajati.adaugareAngajat();
        //functionalitatiAngajati.adaugareAngajat();
        //functionalitatiAngajati.adaugareAngajat();

        functionalitatiAngajati.afisareAngajati();

        Atelier atelier = new Atelier(functionalitatiAngajati);

        atelier.esteDeschis();

        Masina masina1 = new Standard("1", 100, 2020, true, "Automat");
        Masina masina2 = new Standard("2", 10000, 2020, true, "Automat");
        Masina masina3 = new Standard("3", 500, 2020, true, "Automat");
        Masina masina4 = new Standard("4", 800, 2020, true, "Manual");

        Masina masina5 = new Camion("5", 0, 2019, false, 10);
        Masina masina6 = new Camion("6", 90000, 2009, false, 15);


        atelier.asigneazaMasina(1, masina1);
        atelier.asigneazaMasina(1, masina2);
        atelier.asigneazaMasina(1, masina3);
        atelier.asigneazaMasina(1, masina4);
        atelier.asigneazaMasina(1, masina5);
        atelier.asigneazaMasina(1, masina6);
        atelier.showWaitingQueue();
        atelier.eliminaMasinaReparata(1, masina1);
        atelier.showWaitingQueue();
        atelier.asigneazaMasina(1, masina4);
        atelier.showWaitingQueue();


    }
}
