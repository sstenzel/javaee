package pl.sstenzel.ug.javaee.florists.domain;

import java.util.Date;

public class Newsletter {
    private long id;
    private String imie;
    private Date kiedy;
    private String czestotliwosc;
    private String tematyka;

    public Newsletter(long id, String imie, Date kiedy, String czestotliwosc, String tematyka) {
        this.id = id;
        this.imie = imie;
        this.kiedy = kiedy;
        this.czestotliwosc = czestotliwosc;
        this.tematyka = tematyka;
    }
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public Date getKiedy() {
        return kiedy;
    }

    public void setKiedy(Date kiedy) {
        this.kiedy = kiedy;
    }

    public String getCzestotliwosc() {
        return czestotliwosc;
    }

    public void setCzestotliwosc(String czestotliwosc) {
        this.czestotliwosc = czestotliwosc;
    }

    public String getTematyka() {
        return tematyka;
    }

    public void setTematyka(String tematyka) {
        this.tematyka = tematyka;
    }


}
