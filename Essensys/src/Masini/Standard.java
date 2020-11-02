package Masini;

import java.util.Calendar;

public class Standard extends Masina {

    private String modTransmisie;    // Manual/Automat

    public Standard(String masinaID, long numarKm, int anFabricatie,
                    boolean diesel, String modTransmisie) {
        super(masinaID, numarKm, anFabricatie, diesel);
        this.modTransmisie = modTransmisie;
    }

    public String getModTransmisie() {
        return modTransmisie;
    }

    public void setModTransmisie(String modTransmisie) {
        this.modTransmisie = modTransmisie;
    }

    @Override
    public double calcularePolita(boolean discount) {
        double polita = 0;
        int actualYear = Calendar.getInstance().get(Calendar.YEAR);
        polita = (actualYear - this.getAnFabricatie()) * 100;
        if (this.isDiesel()) {
            polita += 500;
        }
        if(this.getNumarKm() > 200000) {
            polita += 500;
        }
        if (discount) {
            polita = polita - (5 / 100 * polita);
        }
        return polita;
    }
}
