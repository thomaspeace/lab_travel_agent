import java.time.LocalDate;
import java.util.ArrayList;


public abstract class Activity implements Bookable {

    private LocalDate date;
    private int capacity;
    private int price;
    private ArrayList<Customer> players;

    public Activity(int year, int month, int day, int capacity, int price){
        this.date = LocalDate.of(year, month, day);
        this.capacity = capacity;
        this.price = price;
        this.players = new ArrayList<>();
    }

    public LocalDate getDate(){
        return this.date;
    }

    public void setDate(int day, int month, int year){
        this.date = LocalDate.of(day,month,year);
    }

    public void setPrice(int newPrice){
        this.price = newPrice;
    }

    public int getPrice(){
        return this.price;
    }

    public void setCapacity(int newCapacity){
        this.capacity = newCapacity;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public int getPlayers(){
        return this.players.size();
    }

    public boolean hasCapacity(){
        return this.getPlayers() < this.getCapacity();
    }

    public void book(Customer customer){
        if (this.hasCapacity() && customer.canAfford(this.price)) {
            this.players.add(customer);
            customer.pay(this.getPrice());
        }
    }

    public void cancel(Customer customer){
        this.players.remove(customer);
//        using pay method with a negative number to refund
        customer.pay(-this.price);
    }



}
