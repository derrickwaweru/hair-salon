import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {

  @Test
  public void stylist_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("Home");
    assertEquals(true, testStylist instanceof Stylist);
  }

@Test
public void getName_stylistInstantiatesWithName_Home() {
  Stylist testStylist = new Stylist("Home");
  assertEquals("Home", testStylist.getName());
}

@Test
public void all_returnsAllInstancesOfStylist_true() {
  Stylist firstStylist = new Stylist("Work");
  Stylist secondStylist = new Stylist("work");
  assertEquals(true, Stylist.all().contains(firstStylist));
  assertEquals(true, Stylist.all().contains(secondStylist));
}

@Test
public void clear_emptiesAllStylistsFromList_0() {
  Stylist testStylist = new Stylist("Home");
  Stylist.clear();
  assertEquals(Stylist.all().size(), 0);
}

@Test
public void getId_stylistsInstantiateWithAnId_1() {
  Stylist.clear();
  Stylist testStylist = new Stylist("Home");
  assertEquals(1, testStylist.getId());
}

@Test
public void getClients_initiallyReturnsEmptyList_ArrayList() {
  Stylist.clear();
  Stylist testStylist = new Stylist("Home");
  assertEquals(0, testStylist.getClients().size());
}

@Test
public void addClient_addsClientToList_true() {
  Stylist testStylist = new Stylist("Home");
  Client testClient = new Client("Aqua mist");
  testStylist.addClient(testClient);
  assertTrue(testStylist.getClients().contains(testClient));
}

@Test
 public void find_returnsStylistWithSameId_secondStylist() {
   Stylist.clear();
   Stylist firstStylist = new Stylist("Home");
   Stylist secondStylist = new Stylist("Work");
   assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
 }

}
