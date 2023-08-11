package org.dwcj.javaland.components.pages.dashboard.widgets.inbox;


import org.dwcj.component.AbstractComponent;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.event.ButtonClickEvent;
import org.dwcj.component.dialog.Dialog;
import org.dwcj.component.event.EventListener;
import org.dwcj.component.field.TextField;
import org.dwcj.component.textarea.TextArea;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.AbstractWindow;

import static org.dwcj.component.button.ButtonTheme.PRIMARY;

public class Reply extends AbstractComponent {

  private final String title;
  private final String message;
  private Dialog dialog;
  private EventListener<ButtonClickEvent> handleClick;

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
  protected void create(AbstractWindow panel) {

    dialog = new Dialog();
    dialog.setAlignment(Dialog.Alignment.TOP);
    dialog.setMaxWidth("450px");

    dialog.addClassName("dialog--reply");

    dialog.getHeader().add(new Label("<html><bbj-icon name='send'></bbj-icon> Reply To Message</html>"));

    TextField to = new TextField(title);
    to.setAttribute("readonly", "true");
    to.setAttribute("label", "To:");

    TextField subject = new TextField();
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
    send.setTheme(PRIMARY);
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
