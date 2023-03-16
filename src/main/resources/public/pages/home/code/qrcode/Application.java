public class QrCodeApplication extends App {

  @Override
  public void run() throws DwcException {
    String text = "https://dwcj.org/";

    QRCode qr = new QRCode();
    qr.setValue(text);

    TextBox input = new TextBox(text);
    input.onEditModify((e) -> {
      qr.setValue(input.getText());
    });
  }
}
