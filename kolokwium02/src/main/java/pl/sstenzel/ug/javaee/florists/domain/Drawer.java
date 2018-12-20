package pl.sstenzel.ug.javaee.florists.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Drawer {

    private long id;
    private String brand;
    private double price;
    private Date productionDate;
    private boolean extraGlass;

    public Drawer(){
        this.id = 0;
        this.price = 0.0;
    }

    public Drawer(String brand, double price, Date productionDate, boolean eg){
        this.brand = brand;
        this.price = price;
        this.productionDate = productionDate;
        this.extraGlass = eg;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public boolean isExtraGlass() {
        return extraGlass;
    }

    public void setExtraGlass(boolean extraGlass) {
        this.extraGlass = extraGlass;
    }

    public static String dateToString(Date date){
        if(date == null)
            return "";
        return new SimpleDateFormat("dd.MM.yyyy").format(date);
    }
    public static Date stringToDate(String date) throws ParseException {
        if(date == "")
            return null;
        return new SimpleDateFormat("dd.MM.yyyy").parse(date);
    }

    @Override
    public String toString() {
        return "\nDrawer brand: " + getBrand() +
                "\nPrice: " + getPrice() +
                "\nProduction date: " + new SimpleDateFormat("dd.MM.yyyy").format(getProductionDate()) +
                 "\nExtra glass: " + isExtraGlass();
    }

    public String printHTML() {
        return "<p><ul>"+
                "<li>\nId: " + getId() +"</li>"+
                "<li>\nDrawer brand: " + getBrand() +"</li>"+
                "<li>\nPrice: " + getPrice() +"</li>"+
                "<li>\nProduction date: " + new SimpleDateFormat("dd.MM.yyyy").format(getProductionDate()) +"</li>"+
                "<li>\nExtra glass: " + isExtraGlass() +"</li>"+
                "</ul></p>";
    }

    public void clear(){
        id = 0;
        price = 0.0;
        productionDate = null;
        extraGlass = false;
        brand = null;
    }
}
