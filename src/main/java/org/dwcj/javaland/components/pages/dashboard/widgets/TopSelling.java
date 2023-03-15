package org.dwcj.javaland.components.pages.dashboard.widgets;

import org.dwcj.controls.AbstractControl;
import org.dwcj.controls.label.Label;
import org.dwcj.controls.panels.AbstractPanel;
import org.dwcj.controls.panels.Div;
import org.dwcj.javaland.components.litetable.LiteTable;

import com.google.gson.JsonArray;

public final class TopSelling extends AbstractControl {

  @Override
  protected void create(AbstractPanel panel) {
    super.create(panel);

    Div card = new Div();
    card.addClassName("card card--topSelling");

    Label header = new Label();
    header.addClassName("card__header");
    header.setText("Top Selling Products");
    card.add(header);

    LiteTable table = new LiteTable();

    // columns
    String[] colNames = new String[] { "Product", "Price", "Quantity", "Amount" };
    for (String colName : colNames) {
      table.getColumns().add(colName);
    }

    // rows
    JsonArray rows = table.getRows();
    String[] products = new String[] { "ASOS Ridley High Waist", "Marco Lightweight Shirt", "Half Sleeve Shirt",
        "Lightweight Jacket", "Marco Shoes", "ASOS Ridley High Waist", "Half Sleeve Shirt", "Lightweight Jacket" };
    String[] prices = new String[] { "$79.49", "$128.50", "$39.99", "$20.00", "$28.49", "$79.49", "$39.99", "$20.00" };
    String[] quantities = new String[] { "82", "37", "64", "184", "69", "82", "64", "184" };
    String[] amounts = new String[] { "$6,518.18", "$4,754.50", "$2,559.36", "$3,680.00", "$1,965.81", "$6,518.18",
        "$2,559.36", "$3,680.00" };
    for (int i = 0; i < products.length; i++) {
      JsonArray row = new JsonArray();
      row.add(products[i]);
      row.add(prices[i]);
      row.add(quantities[i]);
      row.add(amounts[i]);
      rows.add(row);
    }

    table.requestUpdate();
    card.add(table);

    panel.add(card);
  }
}
