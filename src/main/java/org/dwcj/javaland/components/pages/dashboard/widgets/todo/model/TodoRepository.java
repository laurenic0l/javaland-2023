package org.dwcj.javaland.components.pages.dashboard.widgets.todo.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public final class TodoRepository {
  private final List<TodoItem> todoItems = new ArrayList<>();
  private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  private final PropertyChangeListener todoItemChangeListener = new TodoItemChangeListener();

  public List<TodoItem> getTodoItems() {
    return todoItems;
  }

  /**
   * Adds a new TodoItem to the repository.
   *
   * @param todoItem the TodoItem to add
   */
  public void addItem(TodoItem todoItem) {
    todoItems.add(todoItem);
    propertyChangeSupport.firePropertyChange("added", null, todoItem);
    todoItem.addChangeListener(todoItemChangeListener);
  }

  /**
   * Adds a new TodoItem to the repository.
   *
   * @param text      the text to set
   * @param completed the completed state to set
   * @return the added TodoItem
   */
  public TodoItem addItem(String text, boolean completed) {
    TodoItem todoItem = new TodoItem(text, completed);
    addItem(todoItem);
    return todoItem;
  }

  /**
   * Adds a new TodoItem to the repository.
   *
   * @param text the text to set
   * @return the added TodoItem
   */
  public TodoItem addItem(String text) {
    return addItem(text, false);
  }

  /**
   * Removes a TodoItem from the repository.
   *
   * @param todoItem the TodoItem to remove
   */
  public void removeItem(TodoItem todoItem) {
    todoItems.remove(todoItem);
    todoItem.removeChangeListener(todoItemChangeListener);
    propertyChangeSupport.firePropertyChange("removed", null, todoItem);
  }

  /**
   * Removes all completed TodoItems from the repository.
   */
  public void removeCompletedItems() {
    List<TodoItem> completedItems = getCompletedItems();
    for (TodoItem todoItem : completedItems) {
      removeItem(todoItem);
    }
  }

  /**
   * Gets all TodoItems from the repository.
   *
   * @return the TodoItems
   */
  public List<TodoItem> getItems() {
    return todoItems;
  }

  /**
   * Gets all completed TodoItems from the repository.
   *
   * @return the completed TodoItems
   */
  public List<TodoItem> getCompletedItems() {
    List<TodoItem> completedItems = new ArrayList<>();

    for (TodoItem todoItem : todoItems) {
      if (todoItem.isCompleted()) {
        completedItems.add(todoItem);
      }
    }

    return completedItems;
  }

  /**
   * Finds a TodoItem by its id.
   *
   * @param id the id to search for
   * @return the TodoItem or null if not found
   */
  public TodoItem findById(String id) {
    for (TodoItem todoItem : todoItems) {
      if (todoItem.getId().equals(id)) {
        return todoItem;
      }
    }

    return null;
  }

  /**
   * Adds a listener to the repository.
   *
   * @param listener the listener to add
   * @return this
   */
  public TodoRepository addChangeListener(PropertyChangeListener listener) {
    propertyChangeSupport.addPropertyChangeListener(listener);
    return this;
  }

  private class TodoItemChangeListener implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
      propertyChangeSupport.firePropertyChange("updated", null, evt.getSource());
    }
  }
}
