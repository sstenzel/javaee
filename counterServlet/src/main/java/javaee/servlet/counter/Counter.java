package javaee.servlet.counter;

public class Counter {
private int counter = 0;
public void increment() {
    this.counter++;
}
public int getValue(){
    return this.counter;
}


}


// synchronized - tylko jeden watek