package org.dwcj.javaland.components.pages.dashboard.widgets.inbox;

import java.util.function.Consumer;

import org.dwcj.controls.AbstractControl;
import org.dwcj.controls.button.Button;
import org.dwcj.controls.button.events.ButtonClickEvent;
import org.dwcj.controls.dialog.Dialog;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AbstractPanel;
import org.dwcj.controls.textarea.TextArea;
import org.dwcj.controls.textbox.TextBox;

public class Reply extends AbstractControl {

  private final String title;
  private final String message;
  private Dialog dialog;
  private Consumer<ButtonClickEvent> handleClick;

  /**
   * Create a new instance of {@link Reply}.
   *
   * @param title   The title of the message.
   * @param message The message.
   */
  public Reply(String title, String message) {
    this.title = title;
    this.message = message;
    this.handleClick = this::handleButtonClick;
  }

  /**
   * Show the dialog.
   */
  public void show() {
    dialog.show();
  }

  @Override
  protected void create(AbstractPanel panel) {
    super.create(panel);

    dialog = new Dialog();
    dialog.setAlignment(Dialog.Alignment.TOP);
    dialog.setMaxWidth("450px");

    dialog.addClassName("dialog--reply");

    dialog.getHeader().add(new Label("<html><bbj-icon name='send'></bbj-icon> Reply To Message</html>"));

    TextBox to = new TextBox(title);
    to.setAttribute("readonly", "true");
    to.setAttribute("label", "To:");

    TextBox subject = new TextBox();
    subject.addClassName("dialog__title");
    subject.setAttribute("label", "Subject:");
    subject.setAttribute("placeholder", "The subject of the message");

    TextArea text = new TextArea();
    text.addClassName("dialog__message");
    text.setText("> " + message + "\n");
    text.setAttribute("label", "Message:");

    dialog.getContent()
        .addClassName("dialog__content")
        .add(to, subject, text);

    Button send = new Button("Send");
    send.setTheme(Button.Theme.PRIMARY);
    send.onClick(this.handleClick);

    Button cancel = new Button("Cancel");
    cancel.onClick(this.handleClick);

    dialog.getFooter().add(send, cancel);

    panel.add(dialog);
  }

  private void handleButtonClick(ButtonClickEvent event) {
    dialog.hide();
    dialog.destroy();
  }
}
