import java.util.ArrayList;
import java.util.List;

public class Stylist {
  private String mName;
  private static List<Stylist> instances = new ArrayList<Stylist>();
  private int mId;

  public Stylist(String name) {
    mName = name;
    instances.add(this);
    mId = instances.size();
  }

  public String getName(){
    return mName;
  }

  public static List<Stylist> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

public int getId() {
  return mId;
}

}
