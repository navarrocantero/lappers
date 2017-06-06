
//package com.lappers.model.circuit;
//
//
//import com.lappers.Util;
//
//public class Circuit {
//
//
//    private String circuitName;
//    private String circuitCountry;
//    private Double circuitLength;
//
//
//    // Constructors
//
//    public Circuit(Circuit circuit) {
//        this(circuit.getCircuitName(), circuit.getCircuitCountry(), circuit.getCircuitLength());
//    }
//
//    public Circuit() {
//
//        this("", "", 1);
//    }
//
//    public Circuit(String circuitName) {
//
//        this(circuitName, "", 1);
//    }
//
//    public Circuit(String circuitName, Double circuitLength) {
//
//        this(circuitName, "", circuitLength);
//    }
//
//    public Circuit(String circuitName, int circuitLength) {
//
//        this(circuitName, "", circuitLength);
//    }
//
//    public Circuit(String circuitName, String circuitCountry, int circuitLength) {
//
//
//        this(circuitName, circuitCountry, ((double) circuitLength));
//
//    }
//
//    public Circuit(String circuitName, String circuitCountry, Double circuitLength) {
//
//        this.setCircuitName(circuitName);
//        this.setCircuitCountry(circuitCountry);
//        this.setCircuitLength(circuitLength);
//
//    }
//
//    public Circuit(Circuit_Enum circuit_enum) {
//        this.setCircuitName(circuit_enum.getCIRCUIT_NAME());
//        this.setCircuitLength(circuit_enum.getCIRCUIT_LENGTH());
//        this.setCircuitCountry(circuit_enum.getCIRCUIT_COUNTRY());
//    }
//
//
//    // Accesors
//
//    public String getCircuitName() {
//
//        return circuitName;
//    }
//
//    protected void setCircuitName(String circuitName) {
//
//
//        this.circuitName = Util.checkEmptyString(circuitName);
//    }
//
//    public String getCircuitCountry() {
//
//        return circuitCountry;
//    }
//
//    protected void setCircuitCountry(String circuitCountry) {
//
//
//        this.circuitCountry = Util.checkEmptyString(circuitCountry);
//    }
//
//    public Double getCircuitLength() {
//
//        return circuitLength;
//    }
//
//    protected void setCircuitLength(Double circuitLength) {
//
//        this.circuitLength = Util.checkPositiveDouble(circuitLength);
//    }
//
//
//    // Helpers
//
//    @Override
//    public String toString() {
//        return
//                "Circuit Name    = " + this.getCircuitName() + "\n" +
//                        "Circuit Country = " + this.getCircuitCountry() + "\n" +
//                        "Circuit Length  = " + this.getCircuitLength() + " m" + "\n";
//    }
//
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {   // Are the same memory ID ?
//            return true;
//        }
//        if (obj == null) {  // It is the object null ?
//            return false;
//        }
//        if (obj.getClass() != this.getClass()) { // Are the same class ?
//            return false;
//        }
//
//        Circuit circuit = (Circuit) obj;  // Instance of new car object
//
//        return this.getCircuitName().equalsIgnoreCase(circuit.getCircuitName());     // It is the same circuit name ?
//
//
//    }
//
//
//}
//
