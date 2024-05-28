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
    public void canPay__enough_money(){
        customer.pay(1000);
        assertThat(customer.getWallet()).isEqualTo(9000);
    }

    @Test
    public void canPay__not_enough_money(){
        customer.pay(100000);
        assertThat(customer.getWallet()).isEqualTo(10000);
    }

    @Test
    public void canAfford__true(){
        assertThat(customer.canAfford(1000)).isEqualTo(true);
    }

    @Test
    public void canAfford__false(){
        assertThat(customer.canAfford(100000)).isEqualTo(false);
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
