package org.dwcj.javaland.components.pages.dashboard.widgets.inbox;

import org.dwcj.controls.AbstractControl;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AbstractPanel;
import org.dwcj.controls.panels.Div;
import org.dwcj.controls.panels.events.DivClickEvent;

public class Inbox extends AbstractControl {
  private AbstractPanel panel;

  @Override
  protected void create(AbstractPanel panel) {
    super.create(panel);
    this.panel = panel;

    Div card = new Div();
    card.addClassName("card card--inbox");

    Label header = new Label();
    header.addClassName("card__header");
    header.setText("Inbox");

    Div messagesWrapper = new Div();
    messagesWrapper.addClassName("card__messagesWrapper");

    panel.add(card);

    String[] names = {
        "Nina Martí",
        "Dragan  Somma",
        "Gwyn Lundgren",
        "Luisa  Mäkelä",
        "Miguel  Pinto",
        "Paschalis Babineaux"
    };

    String[] messages = {
        "I've sent you the files for the...",
        "This UI looks awesome! Can you...",
        "Can you share the PSD file for...",
        "Can we schedule a call this...",
        "One of the simplest ways to...",
        "Hey! I attached some new..."
    };

    for (int i = 0; i < 6; i++) {
      Div message = new Div();
      message.addClassName("card__message");
      message.setUserData("title", names[i]);
      message.setUserData("message", messages[i]);
      message.onClick(this::handleMessageClick);

      Label avatar = new Label();
      avatar.addClassName("card__messageAvatar");
      int rnd = (int) (Math.random() * 100);
      avatar.setText("<html><img alt='" + names[i] + "'' src='https://ui-avatars.com/api/?i=" + rnd
          + "&&background=random&&name=" + names[i]
          + "' /></html>");
      message.add(avatar);

      Div wrapper = new Div();
      wrapper.addClassName("card__messageWrapper");

      Label name = new Label();
      name.addClassName("card__messageName");
      name.setText(i > 2 ? names[i] : "<html><b>" + names[i] + " (2)</b></html>");
      wrapper.add(name);

      Label content = new Label();
      content.addClassName("card__messageContent");
      content.setText(messages[i]);
      wrapper.add(content);

      message.add(wrapper);
      messagesWrapper.add(message);
    }

    card.add(header, messagesWrapper);
  }

  private void handleMessageClick(DivClickEvent event) {
    Div message = event.getControl();
    String title = (String) message.getUserData("title");
    String messageText = (String) message.getUserData("message");

    Reply replay = new Reply(title, messageText);
    panel.add(replay);
    replay.show();

  }
}
