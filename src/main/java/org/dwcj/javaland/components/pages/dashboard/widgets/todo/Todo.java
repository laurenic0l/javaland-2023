package org.dwcj.javaland.components.pages.dashboard.widgets.todo;

import org.dwcj.component.AbstractComponent;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.AbstractWindow;
import org.dwcj.component.window.Panel;
import org.dwcj.javaland.components.pages.dashboard.widgets.todo.model.TodoRepository;

public class Todo extends AbstractComponent {

  @Override
  protected void create(AbstractWindow panel) {


    Panel card = new Panel();
    card.addClassName("card card--todo");

    Label header = new Label();
    header.addClassName("card__header");
    header.setText("Todo");
    card.add(header);

    TodoRepository repository = new TodoRepository();
    repository.addItem("Contact the organizers");
    repository.addItem("Register for the event", true);
    repository.addItem("Book a hotel room");
    repository.addItem("Book a flight");
    repository.addItem("Start testing your application", true);
    repository.addItem("Start preparing your presentation", true);
    repository.addItem("Build your demo application", true);

    card.add(
        new TodoToolbar(repository),
        new TodoList(repository),
        new TodoInput(repository));
    panel.add(card);
  }
}
