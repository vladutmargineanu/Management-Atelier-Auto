package Angajati;

class Asistent extends Angajat{

    public static Double COEFICIENT = 1.0;

    public Asistent(int angajatId, String nume, String prenume,
                    String dataNasterii, String dataAngajarii) {
        super(angajatId, nume, prenume, dataNasterii,
                dataAngajarii, COEFICIENT);
    }
}
