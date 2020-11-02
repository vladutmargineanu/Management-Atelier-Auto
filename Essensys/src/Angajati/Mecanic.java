package Angajati;

class Mecanic extends Angajat {

    public static double COEFICIENT = 1.5;

    public Mecanic(int angajatId, String nume, String prenume,
                   String dataNasterii, String dataAngajarii) {
        super(angajatId, nume, prenume, dataNasterii,
                dataAngajarii, COEFICIENT);
    }
}
