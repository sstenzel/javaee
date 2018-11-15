package pl.sstenzel.ug.javaee.rodo.service;

import pl.sstenzel.ug.javaee.rodo.domain.Consent;

public class ConsentService {

    private Consent consent = new Consent();

    public void add(Consent consent){
        this.consent = consent;
    }

}
