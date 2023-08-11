package org.dwcj.javaland.components.pages.dashboard.widgets.inbox;


import org.dwcj.component.AbstractComponent;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.AbstractWindow;
import org.dwcj.component.window.Panel;
import org.dwcj.component.window.event.WindowClickEvent;

public class Inbox extends AbstractComponent {
  private AbstractWindow panel;

  @Override
  protected void create(AbstractWindow panel) {
    this.panel = panel;

    Panel card = new Panel();
    card.addClassName("card card--inbox");

    Label header = new Label();
    header.addClassName("card__header");
    header.setText("Inbox");

    Panel messagesWrapper = new Panel();
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
      Panel message = new Panel();
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

      Panel wrapper = new Panel();
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

  private void handleMessageClick(WindowClickEvent event) {
    Panel message = event.getControl();
    String title = (String) message.getUserData("title");
    String messageText = (String) message.getUserData("message");

    Reply replay = new Reply(title, messageText);
    panel.add(replay);
    replay.show();

  }
}
