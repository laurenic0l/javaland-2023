package org.dwcj.javaland.components.pages.dashboard.widgets.todo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.dwcj.component.button.Button;
import org.dwcj.component.html.elements.Div;
import org.dwcj.component.html.elements.Paragraph;
import org.dwcj.javaland.components.pages.dashboard.widgets.todo.model.TodoRepository;

import static org.dwcj.component.button.ButtonTheme.OUTLINED_PRIMARY;

public class TodoToolbar extends Div {
  private final TodoRepository repository;
  private Div todoToolbar;
  private Paragraph remainingItems;

  /**
   * Creates a new instance of {@link TodoToolbar}.
   *
   * @param repository the repository to use
   */
  public TodoToolbar(TodoRepository repository) {
    this.repository = repository;
    this.repository.addChangeListener(new RepositoryChangeListener());
    
    todoToolbar = new Div();
    todoToolbar.addClassName("todo__toolbar");

    remainingItems = new Paragraph("");
    remainingItems.addClassName("todo__remainingItems");

    Button clearCompleted = new Button("Archive");
    clearCompleted.setTheme(OUTLINED_PRIMARY);
    clearCompleted.onClick(e -> {
      repository.removeCompletedItems();
    });

    update();
    todoToolbar.add(remainingItems, clearCompleted);
    add(todoToolbar);
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
