import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {
  @Test
  public void Stylist_instantiatesCorrectly_true(){
    Stylist myStylist = new Stylist("Aqua mist");
    assertEquals(true, myStylist instanceof Stylist);
  }
}
