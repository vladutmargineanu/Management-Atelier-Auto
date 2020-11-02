package Angajati;
import Masini.Masina;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Scanner;


public class Angajat {
    private int angajatId;
    private String nume;
    private String prenume;
    private String dataNasterii;
    private String dataAngajarii;
    private final double coeficientSalariat;

    // waiting queue for each employee
    public ArrayList<Masina> waitingQueue = new ArrayList<>();
    // currently cars that are repaired
    public ArrayList<Masina> inProgress = new ArrayList<>();

    public Angajat(int angajatId, String nume, String prenume,
                   String dataNasterii, String dataAngajarii,
                   double coeficientSalariat) {
        this.angajatId          = angajatId;
        this.nume               = nume;
        this.prenume            = prenume;
        this.dataNasterii       = dataNasterii;
        this.dataAngajarii      = dataAngajarii;
        this.coeficientSalariat = coeficientSalariat;
    }

    public int getAngajatId() {
        return angajatId;
    }

    public void setAngajatId(int angajatId) {
        this.angajatId = angajatId;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(String dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public String getDataAngajarii() {
        return dataAngajarii;
    }

    public void setDataAngajarii(String dataAngajarii) {
        this.dataAngajarii = dataAngajarii;
    }

    public double getCoeficientSalariat() {
        return coeficientSalariat;
    }
}
