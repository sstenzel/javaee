package pl.sstenzel.ug.javaee.rodo.domain;

public class Consent {
    private boolean rodo;
    private boolean newsletter;

    public Consent() {
        this.rodo = false;
        this.newsletter = false;
    }

    public Consent(boolean rodo, boolean newsletter) {
        this.rodo = rodo;
        this.newsletter = newsletter;
    }

    public boolean getRodo() {
        return rodo;
    }

    public void setRodo(boolean rodo) {
        this.rodo = rodo;
    }

    public boolean getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
    }
}
