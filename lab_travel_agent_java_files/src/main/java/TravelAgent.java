public class TravelAgent {

    public void makeBooking(Bookable bookable, Customer customer){
        bookable.book(customer);
    }

    public void cancelBooking(Bookable bookable, Customer customer){
        bookable.cancel(customer);
    }

}
