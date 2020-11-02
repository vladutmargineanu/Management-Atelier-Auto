package Atelier;

import Angajati.Angajat;
import Angajati.AngajatiFunctionalitati;
import Masini.Autobuz;
import Masini.Camion;
import Masini.Masina;
import Masini.Standard;

import java.util.HashMap;
import java.util.Map;


public class Atelier {
    public AngajatiFunctionalitati angajatiFunct;

    HashMap<Angajat, Boolean> availability = new HashMap<Angajat, Boolean>();

    public Atelier(AngajatiFunctionalitati functionalitatiAngajati) {
        angajatiFunct = functionalitatiAngajati;
    }

    public void showWaitingQueue() {
        for (Map.Entry employees : angajatiFunct.angajati.entrySet()) {
            Angajat employee = (Angajat)employees.getValue();
            System.out.println("Angajatul: " + employee.getAngajatId());

            System.out.println("Lista de masini la care se lucreaza: ");
            for (int i = 0; i < employee.inProgress.size();i++)
            {
                System.out.println(employee.inProgress.get(i));
            }

            System.out.println("Lista de masini din coada de asteptare: ");
            for (int i = 0; i <  employee.waitingQueue.size();i++)
            {
                System.out.println( employee.waitingQueue.get(i));
            }
        }
    }

    public void updateAvalability() {
        for (Map.Entry employees : angajatiFunct.angajati.entrySet()) {
            Angajat employee = (Angajat)employees.getValue();
            Boolean b = aglomerareAngajat(employee.getAngajatId());

            if (b) {
                System.out.println("Nu mai sunt locuri libere pentru angjatul cu id-ul " + employee.getAngajatId());
            }
            else {
                System.out.println("Mai sunt locuri libere pentru angjatul cu id-ul " + employee.getAngajatId());
            }
            availability.put(employee, b);
        }
    }


    // Verificam daca exista angajati in atelier
    public void esteDeschis() {
        if(angajatiFunct.existaAngajat()) {
            System.out.println("Atelierul NU este deschis! ");
        }
        else {
            System.out.println("Atelierul este deschis! ");
        }
    }

    public void eliminaMasinaReparata(int id, Masina masina) {
        Angajat angajat = angajatiFunct.angajati.get(id);

        if (angajat != null) {
            angajat.inProgress.remove(masina);
        }
    }

    public void eliminaMasinaCoada(int id, Masina masina) {
        Angajat angajat = angajatiFunct.angajati.get(id);

        if (angajat != null) {
            angajat.waitingQueue.remove(masina);
        }
    }

    public void asigneazaMasina(int id, Masina masina) {
        Angajat angajat = angajatiFunct.angajati.get(id);

        if (angajat != null) {
            if (angajat.inProgress.size() != 0 && angajat.inProgress.size() < 4) {
                if (masina instanceof Autobuz) {
                    for (Masina it : angajat.inProgress) {
                        if (it instanceof Autobuz) {
                            return;
                        }
                    }
                    angajat.inProgress.add(masina);
                    return;
                }

                if (masina instanceof Camion) {
                    for (Masina it : angajat.inProgress) {
                        if (it instanceof Camion) {
                            return;
                        }
                    }
                    angajat.inProgress.add(masina);
                    return;
                }

                int counter = 0;
                for (Masina it : angajat.inProgress) {
                    if (it instanceof Standard) {
                        counter++;
                    }
                }
                if (counter < 3) {
                    angajat.inProgress.add(masina);
                }
                angajat.inProgress.add(masina);
            }

            if (angajat.inProgress.size() == 0) {
                angajat.inProgress.add(masina);
            }
            // if employee is busy, add car in the waiting queue
            if (angajat.inProgress.size() > 4) {
                angajat.waitingQueue.add(masina);
            }
        }
    }

    public boolean aglomerareAngajat(int id) {
        Angajat angajat = angajatiFunct.angajati.get(id);

        return angajat.inProgress.size() > 4;
    }

    // add car to waiting queue to a specific employee(if the employee is busy)
    public void addInWaitingQueue(int id, Masina masina) {
        Angajat angajat = angajatiFunct.angajati.get(id);

        angajat.waitingQueue.add(masina);
    }
}
