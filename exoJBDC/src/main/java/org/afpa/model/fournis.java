package org.afpa.model;

public class fournis {
    private int numfou;
    private String nomfou;
    private String ruefou;
    private String posfou;
    private String vilfou;
    private String confou;

    public fournis(){}

    public fournis(int numfou){
        this.numfou = numfou;
    }

    public fournis(String nomfou, String ruefou, String posfou, String vilfou, String confou){

        this.nomfou = nomfou;
        this.ruefou = ruefou;
        this.posfou = posfou;
        this.vilfou = vilfou;
        this.confou = confou;
    }
    public fournis(int numfou, String nomfou, String ruefou, String posfou, String vilfou, String confou){
        this.numfou = numfou;
        this.nomfou = nomfou;
        this.ruefou = ruefou;
        this.posfou = posfou;
        this.vilfou = vilfou;
        this.confou = confou;
    }
    public int getNumfou() {
        return numfou;
    }

    public void setNumfou(int numfou) {
        this.numfou = numfou;
    }

    public String getNomfou() {
        return nomfou;
    }

    public void setNomfou(String nomfou) {
        this.nomfou = nomfou;
    }

    public String getRuefou() {
        return ruefou;
    }

    public void setRuefou(String ruefou) {
        this.ruefou = ruefou;
    }

    public String getPosfou() {
        return posfou;
    }

    public void setPosfou(String posfou) {
        this.posfou = posfou;
    }

    public String getVilfou() {
        return vilfou;
    }

    public void setVilfou(String vilfou) {
        this.vilfou = vilfou;
    }

    public String getConfou() {
        return confou;
    }

    public void setConfou(String confou) {
        this.confou = confou;
    }

}
