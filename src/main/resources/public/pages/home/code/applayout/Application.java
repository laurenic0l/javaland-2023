public class AppTemplateDemo extends App {
  @Override
  public void run() throws DwcException {
    AppPanel window = new AppPanel();

    AppTemplateMobile layout = new AppTemplateMobile();

    // .....

    layout.addPage("Dashboard", "dashboard", new Panel())
        .addPage("Orders", "shopping-cart", new Panel())
        .addPage("Customers", "users", new Panel())
        .addPage("Products", "box", new Panel())
        .addPage("Documents", "files", new Panel())
        .addPage("Tasks", "checklist", new Panel())
        .addPage("Analytics", "chart-dots-2", new Panel());

    // .....

    window.add(layout);
  }
}
