package org.dwcj.javaland.components.pages.dashboard.widgets.todo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;


import org.dwcj.component.AbstractComponent;
import org.dwcj.component.optioninput.CheckBox;
import org.dwcj.component.window.AbstractWindow;
import org.dwcj.component.window.Panel;
import org.dwcj.javaland.components.pages.dashboard.widgets.todo.model.TodoItem;
import org.dwcj.javaland.components.pages.dashboard.widgets.todo.model.TodoRepository;

public class TodoList extends AbstractComponent {
  private final TodoRepository repository;
  private List<CheckBox> checkBoxes = new ArrayList<>();
  private Panel list;

  /**
   * Creates a new instance of {@link TodoList}.
   *
   * @param repository the repository to use
   */
  public TodoList(TodoRepository repository) {
    this.repository = repository;
    this.repository.addChangeListener(new RepositoryChangeListener());
  }

  @Override
  protected void create(AbstractWindow panel) {

    list = new Panel();
    list.addClassName("todo__list");
    repository.getItems().forEach(item -> {
      addCheckbox(item);
    });

    panel.add(list);
  }

  private void addCheckbox(TodoItem item) {
    CheckBox checkBox = new CheckBox();
    checkBox.setUserData("id", item.getId());
    checkBox.setText(item.getText());
    checkBox.setChecked(item.isCompleted());
    checkBox.addClassName("todo__item");
    checkBox.onToggle(e -> {
      item.setCompleted(checkBox.isChecked());
    });

    checkBoxes.add(checkBox);
    list.add(checkBox);
  }

  private class RepositoryChangeListener implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
      if (evt.getPropertyName().equals("added")) {
        addCheckbox((TodoItem) evt.getNewValue());
      }

      if (evt.getPropertyName().equals("removed")) {
        TodoItem item = (TodoItem) evt.getNewValue();
        checkBoxes.stream()
            .filter(checkBox -> checkBox.getUserData("id").equals(item.getId()))
            .findFirst()
            .ifPresent(checkBox -> {
              checkBox.destroy();
            });
      }
    }
  }
}
