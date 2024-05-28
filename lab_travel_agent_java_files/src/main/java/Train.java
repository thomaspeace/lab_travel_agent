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

    public void book(Customer customer){
        if (this.hasCapacity() && customer.canAfford(this.price)) {
            this.customers.add(customer);
            customer.pay(this.getPrice());
        }
    }

    public void cancel(Customer customer){
        this.customers.remove(customer);
//        using pay method with a negative number to refund
        customer.pay(-this.price);
    }

    public boolean hasCapacity(){
        if (this.getCustomers() < this.getCapacity()){
            return true;
        }
        return false;
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

    public int getCustomers(){
        return this.customers.size();
    }



}
