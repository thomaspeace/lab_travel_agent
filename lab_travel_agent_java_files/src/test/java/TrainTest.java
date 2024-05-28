import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TrainTest {

    Train train;
    Customer customer;

    @BeforeEach
    public void setUp(){
        train = new Train(1000, 100);
        customer = new Customer("Tom", 10000);
    }

    @Test
    public void canBook__true(){
        train.book(customer);
        assertThat(customer.getWallet()).isEqualTo(9000);
        assertThat(train.getCustomers()).isEqualTo(1);
    }

    @Test
    public void canBook__no_money(){
        customer.setWallet(0);
        train.book(customer);
        assertThat(customer.getWallet()).isEqualTo(0);
        assertThat(train.getCustomers()).isEqualTo(0);
    }

    @Test
    public void canBook__no_capacity(){
        train.book(customer);
        train.setCapacity(1);
        Customer customer2 = new Customer("Robbie", 20000);
        train.book(customer2);
        assertThat(train.getCustomers()).isEqualTo(1);
    }
}
