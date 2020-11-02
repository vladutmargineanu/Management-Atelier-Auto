package Angajati;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.time.*;

public class AngajatiFunctionalitati {

    public int IDCounter = 1;

    public HashMap<Integer, Angajat> angajati = new HashMap<Integer, Angajat>();

    public void afisareAngajati() {
        System.out.println("Afisare angajati:");
        for (Map.Entry angajatPair : angajati.entrySet()) {
            Angajat angajat = (Angajat)angajatPair.getValue();
            System.out.println("ID angajat: " + angajat.getAngajatId() +
                    "\nNume: " + angajat.getNume() +
                    "\nPrenume: " + angajat.getPrenume() +
                    "\nData Nasterii: " + angajat.getDataNasterii() +
                    "\nData Angajarii: " + angajat.getDataAngajarii() +
                    "\nCoeficient salariat: " + angajat.getCoeficientSalariat());
        }
    }

    public void adaugareAngajat() throws ParseException {
        Scanner t = new Scanner(System.in);
        System.out.println("Introducere date nou angajat: ");

        System.out.println("Nume: ");
        String nume = t.nextLine();
        if (nume == null || nume.length() > 30) {
            System.out.println("Nume invalid. Depaseste 30 de caractere sau este null");
            return;
        }

        System.out.println("Prenume: ");
        String prenume = t.nextLine();
        if (prenume == null || prenume.length() > 30) {
            System.out.println("Prenume invalid. Depaseste 30 de caractere sau este null");
            return;
        }

        System.out.println("Data Nasterii: MM/dd/yyyy");
        String dataNasterii = t.nextLine();

        System.out.println("Data Angajarii: MM/dd/yyyy");
        String dataAngajarii = t.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date firstDate = sdf.parse(dataNasterii);
        Date secondDate = sdf.parse(dataAngajarii);

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());

        long diferenta = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        if (Math.floor(Math.abs(diferenta / 365)) < 18) {
            System.out.println("Angajatul nu are peste 18 ani!");
            return;
        }

        System.out.println("Functia ocupata (e.g. Director/Mecanic/Asistent: ");
        String functie = t.nextLine();


        if (functie.equals("Director")) {
            Director angajat = new Director(IDCounter, nume, prenume, dataNasterii, dataAngajarii);
            angajati.put(IDCounter, angajat);
        }
        else if (functie.equals("Mecanic")) {
            Mecanic angajat = new Mecanic(IDCounter, nume, prenume, dataNasterii, dataAngajarii);
            angajati.put(IDCounter, angajat);
        }
        else if (functie.equals("Asistent")) {
            Asistent angajat = new Asistent(IDCounter, nume, prenume, dataNasterii, dataAngajarii);
            angajati.put(IDCounter, angajat);
        }

        IDCounter++;
    }

    public void stergereAngajat(int angajatId) {
        if (!angajati.containsKey(angajatId)) {
            System.out.println("Angajatul nu exista!");

            System.out.println("Reintroduceti ID: ");
            Scanner t = new Scanner(System.in);
            int noulID = t.nextInt();

            if (!angajati.containsKey(noulID)) {
                System.out.println("Angajatul nu exista!");
            }
            angajati.remove(noulID);

        }
         angajati.remove(angajatId);
    }

    public void editareAngajat(int angajatId) throws ParseException {
        if (!angajati.containsKey(angajatId)) {
            System.out.println("Angajatul nu exista!");
        }
        Angajat angajat = angajati.get(angajatId);

        System.out.println("Introduceti noile campuri:");
        Scanner t = new Scanner(System.in);

        System.out.println("Nume: ");
        String nume = t.nextLine();
        if (nume == null || nume.length() > 30) {
            System.out.println("Nume invalid. Depaseste 30 de caractere sau este null");
            return;
        }
        angajat.setNume(nume);

        System.out.println("Prenume: ");
        String prenume = t.nextLine();
        if (prenume == null || prenume.length() > 30) {
            System.out.println("Prenume invalid. Depaseste 30 de caractere sau este null");
            return;
        }
        angajat.setPrenume(prenume);

        System.out.println("Data Nasterii: MM/dd/yyyy");
        String dataNasterii = t.nextLine();

        System.out.println("Data Angajarii: MM/dd/yyyy");
        String dataAngajarii = t.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date firstDate = sdf.parse(dataNasterii);
        Date secondDate = sdf.parse(dataAngajarii);

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());

        long diferenta = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        if (Math.abs(diferenta / 365) < 18) {
            System.out.println("Angajatul nu are peste 18 ani!");
            return;
        }
        angajat.setDataNasterii(dataNasterii);
        angajat.setDataAngajarii(dataAngajarii);
    }

    public double calculSalariu(int angajatId) throws ParseException {
        if (!angajati.containsKey(angajatId)) {
            System.out.println("Angajatul nu exista!");
        }
        Angajat angajat = angajati.get(angajatId);

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);

        Date secondDate = sdf.parse(DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(LocalDate.now()));
        Date firstDate = sdf.parse(angajat.getDataAngajarii());

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());

        long vechimeZile = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        double vechimeAni = Math.floor(Math.abs(vechimeZile / 365));

        return vechimeAni * angajat.getCoeficientSalariat() * 1000;
    }

    public boolean existaAngajat() {
       if (angajati.isEmpty()) {
           return false;
       }
       return true;
    }
}
