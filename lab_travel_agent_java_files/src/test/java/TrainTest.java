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
    public void canBook__enough_money_and_capacity(){
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

    @Test
    public void canCancel(){
        train.book(customer);
        assertThat(customer.getWallet()).isEqualTo(9000);
        assertThat(train.getCustomers()).isEqualTo(1);
        train.cancel(customer);
        assertThat(customer.getWallet()).isEqualTo(10000);
        assertThat(train.getCustomers()).isEqualTo(0);
    }

    @Test
    public void hasCapacity__true(){
        assertThat(train.hasCapacity()).isEqualTo(true);
    }

    @Test
    public void hasCapacity__false(){
        train.setCapacity(1);
        train.book(customer);
        assertThat(train.hasCapacity()).isEqualTo(false);
    }

    @Test
    public void canSetPrice(){
        train.setPrice(50);
        assertThat(train.getPrice()).isEqualTo(50);
    }

    @Test
    public void canSetCapacity(){
        train.setCapacity(60);
        assertThat(train.getCapacity()).isEqualTo(60);
    }

    @Test
    public void canGetPrice(){
        assertThat(train.getPrice()).isEqualTo(1000);
    }

    @Test
    public void canGetCapacity(){
        assertThat(train.getCapacity()).isEqualTo(100);
    }

    @Test
    public void getCustomers__empty(){
        assertThat(train.getCustomers()).isEqualTo(0);
    }

    @Test
    public void getCustomers__not_empty(){
        train.book(customer);
        assertThat(train.getCustomers()).isEqualTo(1);
    }




}
