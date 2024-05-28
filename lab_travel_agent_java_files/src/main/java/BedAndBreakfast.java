import java.util.ArrayList;

public class BedAndBreakfast implements Bookable{

    private int price;
    private ArrayList<Customer> customer;

    public BedAndBreakfast(int price){
        this.price = price;
        this.customer = new ArrayList<>();
    }

    public int getPrice(){
        return this.price;
    }

    public int getCustomerCount(){
        return this.customer.size();
    }

    public void setPrice(int newPrice){
        this.price = newPrice;
    }

    public boolean hasCapacity(){
        if (this.getCustomerCount() < 1) {
            return true;
        }
        return false;
    }

    public void book(Customer customer){
        if (this.hasCapacity() && customer.canAfford(this.price)){
            customer.pay(this.getPrice());
            this.customer.add(customer);
        }
    }

    public void cancel(Customer customer){
        this.customer.remove(customer);
//        refunding the customer using a negative number in the pay method
        customer.pay(-this.getPrice());
    }
}





