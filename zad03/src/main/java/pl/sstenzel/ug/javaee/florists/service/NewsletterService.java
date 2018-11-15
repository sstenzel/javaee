package pl.sstenzel.ug.javaee.florists.service;


import pl.sstenzel.ug.javaee.florists.domain.Newsletter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class NewsletterService {
    List<String> czestotliwosci = new ArrayList<String>();
    List<String> tematyka = new ArrayList<String>();
    private Map<Long, Newsletter> newslettery;
    private long availableId;

    public NewsletterService(List<String> czestotliwosci, List<String> tematyka) {
        this.czestotliwosci = czestotliwosci;
        this.tematyka = tematyka;
        czestotliwosci.add("Codziennie");
        czestotliwosci.add("Tygodniowo");
        czestotliwosci.add("Miesiecznie");
        tematyka.add("Kwiaciarnia");
        tematyka.add("Leśnictwo");
        tematyka.add("Ogrodnictwo");
        this.newslettery = new HashMap<>();
        this.availableId = 1;

    }

    public List<String> getCzestotliwosci() {
        return czestotliwosci;
    }

    public void setCzestotliwosci(List<String> czestotliwosci) {
        this.czestotliwosci = czestotliwosci;
    }

    public List<String> getTematyka() {
        return tematyka;
    }

    public void setTematyka(List<String> tematyka) {
        this.tematyka = tematyka;
    }

    public Map<Long, Newsletter> getNewslettery() {
        return newslettery;
    }

    public void setNewslettery(Map<Long, Newsletter> newslettery) {
        this.newslettery = newslettery;
    }

    public void add (String imie, String dataS, String czestotliwosc, String tematyka) {
        Date data = new Date();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try{
            data = format.parse(dataS);
        } catch (ParseException e) {}

        add(new Newsletter(getAvailableId(), imie, data, czestotliwosc, tematyka);
    }

    public Collection<Newsletter> getAll() {
        return newslettery.values();
    }
    public Newsletter get (long id){
        return this.newslettery.get(id);
    }

    public void add (Newsletter n){
        this.newslettery.put(n.getId(), n);
    }

    public void delete (long id){
        if(this.newslettery.containsKey(id)) {
            this.newslettery.remove(id);
        }
    }
    public long getAvailableId() {
        return availableId++;
    }
}
