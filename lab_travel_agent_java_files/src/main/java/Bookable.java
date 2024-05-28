public interface Bookable {

    void book(Customer customer);
    void cancel(Customer customer);
    int getPrice();
    boolean hasCapacity();
}
