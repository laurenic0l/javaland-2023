package org.dwcj.javaland.components.pages.dashboard.widgets.todo;

import org.dwcj.controls.AbstractControl;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AbstractPanel;
import org.dwcj.controls.panels.Div;
import org.dwcj.javaland.components.pages.dashboard.widgets.todo.model.TodoRepository;

public class Todo extends AbstractControl {

  @Override
  protected void create(AbstractPanel panel) {
    super.create(panel);

    Div card = new Div();
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
