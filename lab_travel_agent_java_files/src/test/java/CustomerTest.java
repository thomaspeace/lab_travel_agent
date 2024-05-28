import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomerTest {

    Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer("Tom", 10000);
    }

    @Test
    public void canPay(){
        customer.pay(1000);
        assertThat(customer.getWallet()).isEqualTo(9000);
    }

    @Test
    public void canGetName(){
        assertThat(customer.getName()).isEqualTo("Tom");
    }

    @Test
    public void canGetWallet(){
        assertThat(customer.getWallet()).isEqualTo(10000);
    }

    @Test
    public void canSetName(){
        customer.setName("Robbie");
        assertThat(customer.getName()).isEqualTo("Robbie");
    }

    @Test
    public void canSetWallet(){
        customer.setWallet(15000);
        assertThat(customer.getWallet()).isEqualTo(15000);
    }



}
