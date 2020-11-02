package Masini;

import java.util.Calendar;

public class Camion extends Masina {

    private double tonaj;

    public Camion(String masinaID, long numarKm,
                  int anFabricatie, boolean diesel, double tonaj) {
        super(masinaID, numarKm, anFabricatie, diesel);
        this.tonaj = tonaj;
    }

    public double getTonaj() {
        return tonaj;
    }

    public void setTonaj(double tonaj) {
        this.tonaj = tonaj;
    }

    @Override
    public double calcularePolita(boolean discount) {
        double polita = 0;
        int actualYear = Calendar.getInstance().get(Calendar.YEAR);
        polita = (actualYear - this.getAnFabricatie()) * 300;
        if(this.getNumarKm() > 800000) {
            polita += 700;
        }
        if (discount) {
            polita = polita - (15 / 100 * polita);
        }
        return polita;
    }
}
