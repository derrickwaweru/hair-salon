import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Stylist {
  private String name;
  private int id;
  private int stylistId;
  //private List<Client> mClients;

 //logic for initial instantiation
  public Stylist(String name, int stylistId) {
    this.name = name;
    this.stylistId = stylistId;
    //instances.add(this);
    //mId = instances.size();
    //mClients = new ArrayList<Client>();
  }

 //give a stylist a name
  public String getName() {
    return name;
  }

 //
  //returns all instances of a stylist
  //public static List<Stylist> all() {
    //return instances;
  //}

 //clear all instances of a stylist
  //public static void clear() {
    //instances.clear();
  //}

 //getting id for a stylist
  public int getId() {
    return id;
  }

 //locating a stylist using id
  public static Stylist find(int id) {
      try(Connection con = DB.sql2o.open()) {
        String sql = "SELECT * FROM stylists where id=:id";
        Stylist stylist = con.createQuery(sql)
          .addParameter("id", id)
          .executeAndFetchFirst(Stylist.class);
        return stylist;
      }
    }

 //listing clients under stylists
  //public List<Client> getClients() {
    //return mClients;
  //}

 //adding a client to a stylists
  //public void addClient(Client client) {
    //mClients.add(client);
  //}

 //method to return all stylists
  public static List<Stylist> all() {
    String sql = "SELECT id, name FROM stylists";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Stylist.class);
    }
  }

 //method to overide stylists objects
  @Override
  public boolean equals(Object otherStylist) {
    if (!(otherStylist instanceof Stylist)) {
      return false;
    } else {
      Stylist newStylist = (Stylist) otherStylist;
      return this.getName().equals(newStylist.getName()) &&
            this.getId() == newStylist.getId();
    }
  }

 //method to save new stylist and assign same DB id
  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists(name) VALUES (:name)";
      this.id = (int) con.createQuery(sql, true)
          .addParameter("name", this.name)
          .executeUpdate()
          .getKey();
      }
    }

 //method to retrieve all clients in a specific stylistId
  public List<Client> getClients() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients where stylistId=:id";
      return con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetch(Client.class);
    }
  }
  //
  // @Override
  //   public boolean equals(Object otherStylist) {
  //     if (!(otherStylist instanceof Stylist)) {
  //       return false;
  //     } else {
  //       Stylist newStylist = (Stylist) otherStylist;
  //       return this.getName().equals(newStylist.getName());
  //     }
  //   }

    // public static Stylist find(int id) {
    //     try(Connection con = DB.sql2o.open()) {
    //       String sql = "SELECT * FROM stylists where id=:id";
    //       Stylist stylist = con.createQuery(sql)
    //         .addParameter("id", id)
    //         .executeAndFetchFirst(Stylist.class);
    //       return stylist;
    //     }
    //   }

      public int getStylistId() {
        return stylistId;
      }

}
