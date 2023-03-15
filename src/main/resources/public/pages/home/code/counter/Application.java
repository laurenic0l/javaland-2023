@AppTitle("Simple Counter")
public final class Application extends App {
  private int count = 0;

  @Override
  public void run() throws DwcException {

    AppPanel window = new AppPanel();

    Label text = new Label("Count: 0");
    result.add(text);

    Button button = new Button("Counter");
    button.onClick(e -> {
      count++;
      text.setText("Count: " + count);
    });

    window.add(text, button);
  }
}
