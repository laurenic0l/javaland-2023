import { LitElement, html, css } from 'https://unpkg.com/lit-element/lit-element.js?module';

/**
 * A simple table component
 *
 * @element lite-table
 *
 * @prop {Array} data - The data to display in the table
 * @prop {Array} columns - The columns to display in the table
 */
class LiteTable extends LitElement {
  static get properties() {
    return {
      data: { type: Array },
      columns: { type: Array },
    };
  }

  static get styles() {
    return css`
      :host {
        display: block;
      }

      .table-wrapper {
        overflow-x: auto;
      }

      table {
        border-collapse: collapse;
        width: 100%;
      }

      th,
      td {
        border-bottom: 1px solid var(--bbj-color-default);
        padding: var(--bbj-space-m);
      }

      th {
        text-align: left;
        font-weight: 500;
      }

      td {
        color: var(--bbj-color-gray-text);
      }

      tr:last-child td {
        border-bottom: none;
      }

      tbody tr:hover {
        background-color: var(--bbj-color-primary-alt);
        color: var(--bbj-color-on-primary-text-alt);
      }
    `;
  }

  constructor() {
    super();
    this.data = [];
    this.columns = [];
  }

  render() {
    return html`
      <Panel class="table-wrapper">
        <table>
          <thead>
            <tr>
              ${this.columns.map(column => html` <th>${column}</th> `)}
            </tr>
          </thead>
          <tbody>
            ${this.data.map(
            row => html`
            <tr>
              ${row.map(cell => html` <td>${cell}</td> `)}
            </tr>
            `,
          )}
          </tbody>
        </table>
      </Panel>
    `;
  }
}

customElements.define('lite-table', LiteTable);
