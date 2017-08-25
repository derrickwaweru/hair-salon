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

post("/stylists",(request,response) -> {
  Map<String, Object> model= new HashMap<String, Object>();

  String name= request.queryParams("name");
  Stylist newStylist = new Stylist(name);
  request.session().attribute("stylist, newStylist");

  model.put("template","templates/success.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

}
