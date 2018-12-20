package pl.sstenzel.ug.javaee.florists.service;
import pl.sstenzel.ug.javaee.florists.domain.Newsletter;
import java.util.*;
public class NewsletterService {
    List<String> czestotliwosci = new ArrayList();
    List<String> tematyka = new ArrayList();
    private Map<Long, Newsletter> newslettery = new HashMap();
    private long availableId;
    public NewsletterService() {
        czestotliwosci.add("Codziennie");
        czestotliwosci.add("Tygodniowo");
        czestotliwosci.add("Miesiecznie");
        tematyka.add("Kwiaciarnia");
        tematyka.add("Leśnictwo");
        tematyka.add("Ogrodnictwo");
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
    public Collection<Newsletter> getAll() {
        return newslettery.values();
    }
    public Newsletter get (long id){
        return this.newslettery.get(id);
    }
    public long add (Newsletter n) {
        if(newslettery.containsKey(n.getId())){
            newslettery.replace(n.getId(), n);
            return n.getId();
        }
        Long newId = (long) (newslettery.size() + 1);
        n.setId(newId);
        this.newslettery.put(newId, n);
        return newId;
    }
    public void delete (String idS){
        long id = Long.parseLong(idS);
        if(this.newslettery.containsKey(id)) {
            this.newslettery.remove(id);
        }
    }
    //    public void delete (long id){
//        if(this.newslettery.containsKey(id)) {
//            this.newslettery.remove(id);
//        }
//    }
    public long getAvailableId() {
        return availableId++;
    }
}