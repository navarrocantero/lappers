package com.lappers.model.circuit;

/**
 * Created by Laptop on 16/05/2017.
 */
public enum Circuit_Enum {
    MONTEBLANCO("Monteblanco",3926,"Spain"),
    NORDSCHLEIFE("Nordschleife",20832,"Germany"),
    GRAND_TOUR("Grand Tour",2000,"Great Britain"),
    TOP_GEAR("Top Gear",2820,"Great Britain");


    // DEPRECATED CIRCUITS FOR 2.0 VERSION
//    BARCELONA_GP("Barcelona gp",4655,"Spain"),
//    BARCELONA_MOTO("BARCELONA MOTO",4727,"Spain"),
//    IMOLA("Imola",4909,"Italy"),
//    MONZA("Monza",5793,"Italy"),
//    MUGELLO("Mugello",5245,"Italy"),
//    SILVERSTONE_INTERNATIONAL("Silverstone International",3619,"Great Britain"),
//    SILVERSTONE_NATIONAL("Silverstone National",2638,"Great Britain"),
//    SPA("SPA",7004,"Belgium"),



    private final String CIRCUIT_NAME;
    private final double CIRCUIT_LENGTH;
    private final String CIRCUIT_COUNTRY;


    public String getCIRCUIT_NAME() {
        return CIRCUIT_NAME;
    }

    public double getCIRCUIT_LENGTH() {
        return CIRCUIT_LENGTH;
    }

    public String getCIRCUIT_COUNTRY() {
        return CIRCUIT_COUNTRY;
    }

    Circuit_Enum(String CIRCUIT_NAME, double CIRCUIT_LENGTH, String CIRCUIT_COUNTRY) {
        this.CIRCUIT_NAME = CIRCUIT_NAME;
        this.CIRCUIT_LENGTH = CIRCUIT_LENGTH;
        this.CIRCUIT_COUNTRY = CIRCUIT_COUNTRY;
    }

    @Override
    public String toString() {
        return
                "Circuit Name    = " + this.getCIRCUIT_NAME() + "\n" +
                        "Circuit Country = " + this.getCIRCUIT_COUNTRY() + "\n" +
                        "Circuit Length  = " + this.getCIRCUIT_LENGTH() + " m" + "\n";
    }



}
