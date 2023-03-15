public class AppTemplateDemo extends App {
  @Override
  public void run() throws DwcException {
    AppPanel window = new AppPanel();

    AppTemplateMobile layout = new AppTemplateMobile();

    layout.addPage("Dashboard", "dashboard", new Div())
        .addPage("Orders", "shopping-cart", new Div())
        .addPage("Customers", "users", new Div())
        .addPage("Products", "box", new Div())
        .addPage("Documents", "files", new Div())
        .addPage("Tasks", "checklist", new Div())
        .addPage("Analytics", "chart-dots-2", new Div());

    window.add(layout);
  }
}
