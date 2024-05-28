import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TravelAgentTest {

    TravelAgent travelAgent;
    Train train;
    BedAndBreakfast bedAndBreakfast;
    Customer customer;

    @BeforeEach
    public void setUp(){
        travelAgent = new TravelAgent();
        train = new Train(1000, 100);
        bedAndBreakfast = new BedAndBreakfast(1000);
        customer = new Customer("Tom", 10000);
    }

    @Test
    public void canBook__train_enough_money_and_capacity(){
        travelAgent.makeBooking(train, customer);
        assertThat(customer.getWallet()).isEqualTo(9000);
        assertThat(train.getCustomers()).isEqualTo(1);
    }

    @Test
    public void canBook__train_no_money(){
        customer.setWallet(0);
        train.book(customer);
        assertThat(customer.getWallet()).isEqualTo(0);
        assertThat(train.getCustomers()).isEqualTo(0);
    }

    @Test
    public void canBook__train_no_capacity(){
        train.book(customer);
        train.setCapacity(1);
        Customer customer2 = new Customer("Robbie", 20000);
        train.book(customer2);
        assertThat(train.getCustomers()).isEqualTo(1);
    }

    @Test
    public void canBook__bnb_enough_money_and_capacity(){
        travelAgent.makeBooking(bedAndBreakfast, customer);
        assertThat(customer.getWallet()).isEqualTo(9000);
        assertThat(bedAndBreakfast.getCustomerCount()).isEqualTo(1);
    }

    @Test
    public void canBook__bnb_no_money(){
        customer.setWallet(0);
        bedAndBreakfast.book(customer);
        assertThat(customer.getWallet()).isEqualTo(0);
        assertThat(bedAndBreakfast.getCustomerCount()).isEqualTo(0);
    }

    @Test
    public void canBook__bnb_no_capacity(){
        bedAndBreakfast.book(customer);
        Customer customer2 = new Customer("Robbie", 20000);
        bedAndBreakfast.book(customer2);
        assertThat(bedAndBreakfast.getCustomerCount()).isEqualTo(1);
    }

    @Test
    public void canCancel_train(){
        travelAgent.makeBooking(train, customer);
        assertThat(train.getCustomers()).isEqualTo(1);
        assertThat(customer.getWallet()).isEqualTo(9000);
        travelAgent.cancelBooking(train, customer);
        assertThat(train.getCustomers()).isEqualTo(0);
        assertThat(customer.getWallet()).isEqualTo(10000);
    }

    @Test
    public void canCancel_bnb(){
        travelAgent.makeBooking(bedAndBreakfast, customer);
        assertThat(bedAndBreakfast.getCustomerCount()).isEqualTo(1);
        assertThat(customer.getWallet()).isEqualTo(9000);
        travelAgent.cancelBooking(bedAndBreakfast, customer);
        assertThat(bedAndBreakfast.getCustomerCount()).isEqualTo(0);
        assertThat(customer.getWallet()).isEqualTo(10000);
    }
}
