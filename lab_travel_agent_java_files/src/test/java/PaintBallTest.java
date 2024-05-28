import org.assertj.core.internal.bytebuddy.build.ToStringPlugin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PaintBallTest {

    Customer customer;
    PaintBall paintball;

    @BeforeEach
    public void setUp(){
        customer = new Customer("Robbie", 500);
        paintball = new PaintBall(2023, 12, 25, 8, 50);
    }

    @Test
    public void canGetDate(){
        assertThat(paintball.getDate()).isEqualTo("2023-12-25");
    }

    @Test
    public void canSetDate(){
        paintball.setDate(1900,01,05);
        assertThat(paintball.getDate()).isEqualTo("1900-01-05");
    }

    @Test
    public void canSetPrice(){
        paintball.setPrice(75);
        assertThat(paintball.getPrice()).isEqualTo(75);
    }

    @Test
    public void canGetPrice(){
        assertThat(paintball.getPrice()).isEqualTo(50);
    }

    @Test
    public void canSetCapacity(){
        paintball.setCapacity(12);
        assertThat(paintball.getCapacity()).isEqualTo(12);
    }

    @Test
    public void canGetCapacity(){
        assertThat(paintball.getCapacity()).isEqualTo(8);
    }

    @Test
    public void canBook__has_capacity_enough_money(){
        paintball.book(customer);
        assertThat(paintball.getPlayers()).isEqualTo(1);
        assertThat(customer.getWallet()).isEqualTo(450);
    }

    @Test
    public void canBook__has_capacity_not_enough_money(){
        customer.setWallet(0);
        paintball.book(customer);
        assertThat(paintball.getPlayers()).isEqualTo(0);
        assertThat(customer.getWallet()).isEqualTo(0);
    }

    @Test
    public void canBook__no_capacity_enough_money(){
        paintball.setCapacity(0);
        paintball.book(customer);
        assertThat(paintball.getPlayers()).isEqualTo(0);
        assertThat(customer.getWallet()).isEqualTo(500);
    }

    @Test
    public void canCancel(){
        paintball.book(customer);
        assertThat(paintball.getPlayers()).isEqualTo(1);
        assertThat(customer.getWallet()).isEqualTo(450);
        paintball.cancel(customer);
        assertThat(paintball.getPlayers()).isEqualTo(0);
        assertThat(customer.getWallet()).isEqualTo(500);
    }

    @Test
    public void canHasCapacity__true(){
        assertThat(paintball.hasCapacity()).isEqualTo(true);
    }

    @Test
    public void canHasCapacity__false(){
        paintball.setCapacity(1);
        paintball.book(customer);
        assertThat(paintball.hasCapacity()).isEqualTo(false);
    }



}
