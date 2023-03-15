package org.dwcj.javaland.components.pages.dashboard.widgets.todo;

import org.dwcj.controls.AbstractControl;
import org.dwcj.controls.button.Button;
import org.dwcj.controls.panels.AbstractPanel;
import org.dwcj.controls.panels.Div;
import org.dwcj.controls.textbox.TextBox;
import org.dwcj.javaland.components.pages.dashboard.widgets.todo.model.TodoRepository;

public final class TodoInput extends AbstractControl {
  private final TodoRepository repository;

  /**
   * Creates a new instance of {@link TodoInput}.
   *
   * @param repository the repository to use
   */
  public TodoInput(TodoRepository repository) {
    this.repository = repository;
  }

  /**
   * Creates a new instance of {@link TodoInput}.
   */
  @Override
  protected void create(AbstractPanel panel) {
    super.create(panel);

    Div wrapper = new Div();
    wrapper.addClassName("todo__inputWrapper");

    TextBox input = new TextBox();
    input.addClassName("todo__input");
    input.setAttribute("placeholder", "What needs to be done?");

    Button button = new Button("Add");
    button.setTheme(Button.Theme.PRIMARY);
    button.addClassName("todo__button");
    button.onClick(e -> {
      repository.addItem(input.getText());
      input.setText("");
    });

    wrapper.add(input, button);
    panel.add(wrapper);
  }
}
