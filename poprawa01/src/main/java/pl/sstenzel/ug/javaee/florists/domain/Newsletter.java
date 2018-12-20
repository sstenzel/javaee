package pl.sstenzel.ug.javaee.florists.domain;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Newsletter {
    private long id;
    private String imie;
    private Date dataOd;
    private Date dataDo;
    private String czestotliwosc;
    private String tematyka;
    public Newsletter() {
    }
    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return "ID: " + id + "<br>" +
                "Imię: " + imie + "<br>" +
                "Od: " + format.format(dataOd) + "<br>" +
                "Do: " + format.format(dataDo) + "<br>" +
                "Częstowliwość: " + czestotliwosc + "<br>" +
                "Tematyka: " + tematyka + "<br>";
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }
    public Date getDataOd() {
        return dataOd;
    }
    public void setDataOd(Date dataOd) {
        this.dataOd = dataOd;
    }
    public Date getDataDo() {
        return dataDo;
    }
    public void setDataDo(Date dataDo) {
        this.dataDo = dataDo;
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