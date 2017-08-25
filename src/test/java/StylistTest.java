import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {
  @Test
  public void Stylist_instantiatesCorrectly_true(){
    Stylist myStylist = new Stylist("Aqua mist");
    assertEquals(true, myStylist instanceof Stylist);
  }

@Test
public void Stylist_instantiatesWithName_String(){
  Stylist myStylist = new Stylist("Aqua mist");
  assertEquals("Aqua mist",myStylist.getName());
}

@Test
public void all_returnsAllInstancesOfStylist_true() {
  Stylist firstStylist = new Stylist("Aqua mist");
  Stylist secondStylist = new Stylist("Movit mambo");
  assertEquals(true, Stylist.all().contains(firstStylist));
  assertEquals(true, Stylist.all().contains(secondStylist));
}

@Test
public void clear_emptiesAllStylistsFromArrayList_0() {
  Stylist myStylist = new Stylist("Aqua mist");
  Stylist.clear();
  assertEquals(Stylist.all().size(), 0);
}

@Test
public void getId_stylistsInstantiateWithAnID_1() {
  Stylist.clear();
  Stylist myStylist = new Stylist("Aqua mist");
  assertEquals(1, myStylist.getId());
}

}
