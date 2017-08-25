import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("stylists", request.session().attribute("stylists"));
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      post("/stylists", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();

    ArrayList<Stylist> stylists = request.session().attribute("stylists");
    if (stylists == null) {
      stylists = new ArrayList<Stylist>();
      request.session().attribute("stylists", stylists);
    }

    String name = request.queryParams("name");
    Stylist newStylist = new Stylist(name);
    stylists.add(newStylist);

    model.put("template", "templates/success.vtl");
    return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());




  }
}
