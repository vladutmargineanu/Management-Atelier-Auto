package Masini;

import java.util.Calendar;

public class Autobuz extends Masina {

    private int numarLocuri;

    public Autobuz(String masinaID, long numarKm,
                   int anFabricatie, boolean diesel, int numarLocuri) {
        super(masinaID, numarKm, anFabricatie, diesel);
        this.numarLocuri = numarLocuri;
    }

    public int getNumarLocuri() {
        return numarLocuri;
    }

    public void setNumarLocuri(int numarLocuri) {
        this.numarLocuri = numarLocuri;
    }

    @Override
    public double calcularePolita(boolean discount) {
        double polita = 0;
        int actualYear = Calendar.getInstance().get(Calendar.YEAR);
        polita = (actualYear - this.getAnFabricatie()) * 200;
        if (this.isDiesel()) {
            polita += 1000;
        }
        if(this.getNumarKm() > 200000) {
            polita += 1000;
        } else if(this.getNumarKm() > 100000) {
            polita += 500;
        }
        if (discount) {
            polita = polita - (10 / 100 * polita);
        }
        return polita;
    }
}
