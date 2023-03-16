package org.dwcj.javaland.components.pages.dashboard.widgets.todo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.dwcj.controls.AbstractControl;
import org.dwcj.controls.button.Button;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AbstractPanel;
import org.dwcj.controls.panels.Div;
import org.dwcj.javaland.components.pages.dashboard.widgets.todo.model.TodoRepository;

public class TodoToolbar extends AbstractControl {
  private final TodoRepository repository;
  private Div todoToolbar;
  private Label remainingItems;

  /**
   * Creates a new instance of {@link TodoToolbar}.
   *
   * @param repository the repository to use
   */
  public TodoToolbar(TodoRepository repository) {
    this.repository = repository;
    this.repository.addChangeListener(new RepositoryChangeListener());
  }

  @Override
  protected void create(AbstractPanel panel) {
    super.create(panel);

    todoToolbar = new Div();
    todoToolbar.addClassName("todo__toolbar");

    remainingItems = new Label("");
    remainingItems.addClassName("todo__remainingItems");

    Button clearCompleted = new Button("Archive");
    clearCompleted.setTheme(Button.Theme.OUTLINED_PRIMARY);
    clearCompleted.onClick(e -> {
      repository.removeCompletedItems();
    });

    update();
    todoToolbar.add(remainingItems, clearCompleted);
    panel.add(todoToolbar);
  }

  private void update() {
    int total = repository.getItems().size();
    int remaining = total - repository.getCompletedItems().size();

    remainingItems.setText(remaining + " of " + total + " remaining");
  }

  private class RepositoryChangeListener implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
      String[] properties = {"added", "removed", "updated"};
      if(java.util.Arrays.asList(properties).contains(evt.getPropertyName())) {
        update();
      }
    }
  }
}
