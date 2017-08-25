import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {
  @Test
  public void Client_instantiatesCorrectly_true(){
    Client myClient = new Client("Aqua mist");
    assertEquals(true, myClient instanceof Client);
  }

@Test
public void Client_instantiatesWithName_String(){
  Client myClient = new Client("Aqua mist");
  assertEquals("Aqua mist",myClient.getName());
}

@Test
public void all_returnsAllInstancesOfClient_true() {
  Client firstClient = new Client("Aqua mist");
  Client secondClient = new Client("Movit mambo");
  assertEquals(true, Client.all().contains(firstClient));
  assertEquals(true, Client.all().contains(secondClient));
}

@Test
public void clear_emptiesAllClientsFromArrayList_0() {
  Client myclient = new Client("Aqua mist");
  Client.clear();
  assertEquals(Client.all().size(), 0);
}

@Test
public void getId_clientsInstantiateWithAnId_1() {
  Client.clear();
  Client myClient = new Client("Aqua mist");
  assertEquals(1, myClient.getId());
}

@Test
public void find_returnsClientWithSameId_secondClient() {
  Client firstClient = new Client("Mow the lawn");
  Client secondClient = new Client("Buy groceries");
  assertEquals(Client.find(firstClient.getId()), firstClient);
  assertEquals(Client.find(secondClient.getId()), secondClient);
}

}
