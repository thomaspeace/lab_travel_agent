import java.lang.reflect.Array;
import java.util.ArrayList;

public class Train implements Bookable{

//    properties
    private int price;
    private int capacity;
    private ArrayList<Customer> customers;

    public Train(int price, int capacity){
        this.price = price;
        this.capacity = capacity;
        this.customers = new ArrayList<>();
    }

//    getters and setters

    public void setPrice(int newPrice){
        this.price = newPrice;
    }

    public void setCapacity(int newCapacity){
        this.capacity = newCapacity;
    }

    public int getPrice(){
        return this.price;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public ArrayList<Customer> getCustomers(){
        return this.customers;
    }



}
