import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class BedAndBreakfastTest {

    BedAndBreakfast bedAndBreakfast;
    Customer customer;

    @BeforeEach
    public void setUp(){
        bedAndBreakfast = new BedAndBreakfast(80);
        customer = new Customer("Robbie", 100);
    }

    @Test
    public void canGetPrice(){
        assertThat(bedAndBreakfast.getPrice()).isEqualTo(80);
    }

    @Test
    public void canGetCustomerCount__zero(){
        assertThat(bedAndBreakfast.getCustomerCount()).isEqualTo(0);
    }

    @Test
    public void canGetCustomerCount__one(){
        bedAndBreakfast.book(customer);
        assertThat(bedAndBreakfast.getCustomerCount()).isEqualTo(1);
    }

    @Test
    public void canSetPrice(){
        bedAndBreakfast.setPrice(120);
        assertThat(bedAndBreakfast.getPrice()).isEqualTo(120);
    }

    @Test
    public void hasCapacity__true(){
        assertThat(bedAndBreakfast.hasCapacity()).isEqualTo(true);
    }

    @Test
    public void hasCapacity__false(){
        bedAndBreakfast.book(customer);
        assertThat(bedAndBreakfast.hasCapacity()).isEqualTo(false);
    }

    @Test
    public void canBook__enough_money_and_capacity(){
        bedAndBreakfast.book(customer);
        assertThat(bedAndBreakfast.getCustomerCount()).isEqualTo(1);
        assertThat(customer.getWallet()).isEqualTo(20);
    }

    @Test
    public void canBook__not_enough_money(){
        customer.setWallet(50);
        bedAndBreakfast.book(customer);
        assertThat(bedAndBreakfast.getCustomerCount()).isEqualTo(0);
        assertThat(customer.getWallet()).isEqualTo(50);
    }

    @Test
    public void canBook__not_enough_capacity(){
        bedAndBreakfast.book(customer);
        Customer customer2 = new Customer("Tom", 120);
        assertThat(bedAndBreakfast.getCustomerCount()).isEqualTo(1);
        assertThat(customer2.getWallet()).isEqualTo(120);
    }

    @Test
    public void canCancel(){
        bedAndBreakfast.book(customer);
        assertThat(bedAndBreakfast.getCustomerCount()).isEqualTo(1);
        assertThat(customer.getWallet()).isEqualTo(20);
        bedAndBreakfast.cancel(customer);
        assertThat(bedAndBreakfast.getCustomerCount()).isEqualTo(0);
        assertThat(customer.getWallet()).isEqualTo(100);
    }



}
