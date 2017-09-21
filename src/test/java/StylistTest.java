import org.junit.*;
import org.sql2o.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class StylistTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();



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
  assertEquals(true, Stylist.all().get(0).equals(firstStylist));
  assertEquals(true, Stylist.all().get(1).equals(secondStylist));
}

// @Test
// public void clear_emptiesAllStylistsFromList_0() {
//   Stylist testStylist = new Stylist("Home");
//   Stylist.clear();
//   assertEquals(Stylist.all().size(), 0);
// }

@Test
public void getId_stylistsInstantiateWithAnId_1() {
  // Stylist.clear();
  Stylist testStylist = new Stylist("Home");
  testStylist.save();
  assertTrue(testStylist.getId() > 0);
}

@Test
public void getClients_initiallyReturnsEmptyList_ArrayList() {
  // Stylist.clear();
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
  //  Stylist.clear();
   Stylist firstStylist = new Stylist("Home");
   firstStylist.save();
   Stylist secondStylist = new Stylist("Work");
   secondStylist.save();
   assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
 }

 @Test
       public void getClients_retrievesAllClientsFromDatabase_clientsList() {
         Stylist myStylist = new Stylist("Household chores");
         myStylist.save();
         Client firstClient = new Client("Aqua mist", myStylist.getId());
         firstClient.save();
         Client secondClient = new Client("Aqua mist", myStylist.getId());
         secondClient.save();
         Client[] clients = new Client[] { firstClient, secondClient };
         assertTrue(myStylist.getClients().containsAll(Arrays.asList(clients)));
       }

       @Test
      public void equals_returnsTrueIfNamesAretheSame() {
        Stylist firstStylist = new Stylist("Household chores");
        Stylist secondStylist = new Stylist("Household chores");
        assertTrue(firstStylist.equals(secondStylist));
      }

      @Test
      public void save_savesIntoDatabase_true() {
        Stylist myStylist = new Stylist("Household chores");
        myStylist.save();
        assertTrue(Stylist.all().get(0).equals(myStylist));
      }

      @Test
      public void save_assignsIdToObject() {
        Stylist myStylist = new Stylist("Household chores");
        myStylist.save();
        Stylist savedStylist = Stylist.all().get(0);
        assertEquals(myStylist.getId(), savedStylist.getId());
      }

}
