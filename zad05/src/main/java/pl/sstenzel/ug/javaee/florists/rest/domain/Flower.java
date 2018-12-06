package pl.sstenzel.ug.javaee.florists.rest.domain;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Flower {
    private long id;
    private String name;
    private Date pickDate;
    private Boolean dogToxic;
    private double price;
    private long amount;

    public Flower() {
    }

    public Flower(String name, Date pickDate, Boolean dogToxic, double price, long amount) {
        super();
        this.name = name;
        this.pickDate = pickDate;
        this.dogToxic = dogToxic;
        this.price = price;
        this.amount = amount;
    }
    public Flower(long id, String name, Date pickDate, Boolean dogToxic, double price, long amount) {
        this(name, pickDate, dogToxic, price, amount);
        this.id = id;
    }

    public Flower(String name, String pickDate, String dogToxic, String price, String amount) {
        this.name = name;
        this.setPickDate(pickDate);
        this.dogToxic = Boolean.parseBoolean(dogToxic);
        this.price = Integer.parseInt(price);
        this.amount = Integer.parseInt(amount);
    }

    public Flower(String id, String name, String pickDate, String dogToxic, String price, String amount) {
        this(name, pickDate, dogToxic, price, amount);
        this.setId(Long.parseLong(id));
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
//    public Date getPickDate() {
//        return pickDate;
//    }

    public void setPickDate(Date pickDate) {
        this.pickDate = pickDate;
    }

    public void setPickDate(String pickDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.pickDate = new Date(format.format(pickDate));
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date getPickDate() {
        return pickDate;
    }

    public Boolean getDogToxic() {
        return dogToxic;
    }
    public void setDogToxic(Boolean dogToxic) {
        this.dogToxic = dogToxic;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public long getAmount() { return amount; }
    public void setAmount(long amount) { this.amount = amount; }

    public boolean isOneMoreItem (long inBasket) {
        if(getAmount() > inBasket){
            return true;
        }
        return false;
    }
    public void substractAmount(long amount) {
        this.amount -= amount;
    }

    @Override
    public String toString() {
        return "Flower name: '" + name + '\'' +
                ", \tpick up date: " + new SimpleDateFormat("dd/MM/yy").format(pickDate.getTime()) +
                ", \ttoxic for dogs: " + dogToxic +
                ", \tprice: " + price +
                ", \tamount: " + amount ;
    }


}