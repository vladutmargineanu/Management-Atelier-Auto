package Angajati;

public class Director extends Angajat {

    public static double COEFICIENT = 2.0;

    public Director(int angajatId, String nume, String prenume,
                    String dataNasterii, String dataAngajarii) {
        super(angajatId, nume, prenume, dataNasterii,
                dataAngajarii, COEFICIENT);
    }
}
