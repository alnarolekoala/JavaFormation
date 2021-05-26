package org.afpa.model;

public class entcom {
    private int numcom;
    private String obscom;
    private String datcom;
    private int numfou;

    public entcom() {}

    public entcom(int numcom, String obscom, String datcom, int numfou) {
        this.numcom = numcom;
        this.obscom = obscom;
        this.datcom = datcom;
        this.numfou = numfou;
    }

    public int getNumcom() {
        return numcom;
    }

    public void setNumcom(int numcom) {
        this.numcom = numcom;
    }

    public String getObscom() {
        return obscom;
    }

    public void setObscom(String obscom) {
        this.obscom = obscom;
    }

    public String getDatcom() {
        return datcom;
    }

    public void setDatcom(String datcom) {
        this.datcom = datcom;
    }

    public int getNumfou() {
        return numfou;
    }

    public void setNumfou(int numfou) {
        this.numfou = numfou;
    }
}
