package pl.sstenzel.ug.javaee.florists.service;

import pl.sstenzel.ug.javaee.florists.domain.Consent;

public class ConsentService {

    private Consent consent = new Consent();

    public void add(Consent consent){
        this.consent = consent;
    }

}
