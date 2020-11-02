package Masini;

public abstract class Masina {
    private String masinaID;
    private double numarKm;
    private int anFabricatie;
    private boolean diesel;

    public Masina (String masinaID, long numarKm,
                   int anFabricatie, boolean diesel) {
        this.masinaID = masinaID;
        this.numarKm = numarKm;
        this.anFabricatie = anFabricatie;
        this.diesel = diesel;
    }

    public abstract double calcularePolita(boolean discount);


    public String getMasinaID() {
        return masinaID;
    }

    public void setMasinaID(String masinaID) {
        this.masinaID = masinaID;
    }

    public double getNumarKm() {
        return numarKm;
    }

    public void setNumarKm(long numarKm) {
        this.numarKm = numarKm;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public boolean isDiesel() {
        return diesel;
    }

    public void setDiesel(boolean diesel) {
        this.diesel = diesel;
    }
}
