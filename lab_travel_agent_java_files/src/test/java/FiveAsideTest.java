import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FiveAsideTest {

    Customer customer;
    FiveAside fiveAside;

    @BeforeEach
    public void setUp(){
        customer = new Customer("Robbie", 500);
        fiveAside = new FiveAside(2023, 12, 25, 10, 50);
    }

    @Test
    public void canGetDate(){
        assertThat(fiveAside.getDate()).isEqualTo("2023-12-25");
    }

    @Test
    public void canSetDate(){
        fiveAside.setDate(1900,01,05);
        assertThat(fiveAside.getDate()).isEqualTo("1900-01-05");
    }

    @Test
    public void canSetPrice(){
        fiveAside.setPrice(75);
        assertThat(fiveAside.getPrice()).isEqualTo(75);
    }

    @Test
    public void canGetPrice(){
        assertThat(fiveAside.getPrice()).isEqualTo(50);
    }

    @Test
    public void canSetCapacity(){
        fiveAside.setCapacity(12);
        assertThat(fiveAside.getCapacity()).isEqualTo(12);
    }

    @Test
    public void canGetCapacity(){
        assertThat(fiveAside.getCapacity()).isEqualTo(10);
    }

    @Test
    public void canBook__has_capacity_enough_money(){
        fiveAside.book(customer);
        assertThat(fiveAside.getPlayers()).isEqualTo(1);
        assertThat(customer.getWallet()).isEqualTo(450);
    }

    @Test
    public void canBook__has_capacity_not_enough_money(){
        customer.setWallet(0);
        fiveAside.book(customer);
        assertThat(fiveAside.getPlayers()).isEqualTo(0);
        assertThat(customer.getWallet()).isEqualTo(0);
    }

    @Test
    public void canBook__no_capacity_enough_money(){
        fiveAside.setCapacity(0);
        fiveAside.book(customer);
        assertThat(fiveAside.getPlayers()).isEqualTo(0);
        assertThat(customer.getWallet()).isEqualTo(500);
    }

    @Test
    public void canCancel() {
        fiveAside.book(customer);
        assertThat(fiveAside.getPlayers()).isEqualTo(1);
        assertThat(customer.getWallet()).isEqualTo(450);
        fiveAside.cancel(customer);
        assertThat(fiveAside.getPlayers()).isEqualTo(0);
        assertThat(customer.getWallet()).isEqualTo(500);
    }

    @Test
    public void canHasCapacity__true(){
        assertThat(fiveAside.hasCapacity()).isEqualTo(true);
    }

    @Test
    public void canHasCapacity__false(){
        fiveAside.setCapacity(1);
        fiveAside.book(customer);
        assertThat(fiveAside.hasCapacity()).isEqualTo(false);
    }



}
