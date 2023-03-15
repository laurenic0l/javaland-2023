public class QrCodeApplication extends App {

  @Override
  public void run() throws DwcException {

    QRCode qr = new QRCode();
    qr.setValue("https://dwcj.org/");

    TextBox input = new TextBox();
    input.onEditModify((e) -> {
      qr.setValue(input.getText());
    });
  }
}
