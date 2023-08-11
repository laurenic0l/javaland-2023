import { LitElement, html, css } from 'https://unpkg.com/lit-element/lit-element.js?module';

/**
 * A simple animated counter card component.
 *
 * @element animated-counter
 * @slot icon - The icon slot.
 *
 * @prop {String} lang - The language code for the number format.
 * @prop {String} format-options - The options for the number format.
 * @prop {String} label - The label of the card.
 * @prop {Number} start - The start value of the counter.
 * @prop {Number} speed - The speed of the animation.
 * @prop {String} theme - The theme of the card. Supported values are: `primary`, `danger`, `success`, `info`, `warning`.
 * @prop {Number} value - The value of the counter.
 * @prop {String} valuePrefix - The prefix of the counter.
 * @prop {String} valueSuffix - The suffix of the counter.
 */
class AnimatedCounter extends LitElement {
  static get properties() {
    return {
      formatOptions: { type: Object },
      lang: { type: String },
      label: { type: String },
      start: { type: Number },
      speed: { type: Number },
      theme: { type: String, reflect: true },
      value: { type: Number },
      valuePrefix: { type: String },
      valueSuffix: { type: String },
    };
  }

  static get styles() {
    return css`
    :host {
      display: block;
    }

    [part='card'] {
      display: flex;
      align-items: center;
      padding: 1.5rem;
      border-radius: var(--bbj-border-radius);
      background-color: var(--bbj-surface-3);
      border: 1px solid var(--bbj-color-default);
      gap: 1.5rem;
    }

    [part='content'] {
      flex: 1;
      display: flex;
      flex-direction: column;
    }

    [part='value'] {
      font-size: 2.1rem;
      font-weight: var(--bbj-font-weight-bolder);
    }

    [part='label'] {
      font-size: 1.1rem;
      color: var(--bbj-color-gray-text-light);
    }

    :host ::slotted([slot='icon']) {
      display: flex;
      font-size: 2.1rem;
      color: var(--bbj-color-gray-text-light);
      border-radius: var(--bbj-border-radius-round);
      border: thin solid black;
      padding: 1rem;
    }

    :host([theme='primary']) ::slotted([slot='icon']) {
      color: var(--bbj-color-primary);
      border-color: var(--bbj-color-primary);
      background-color: var(--bbj-color-primary-alt);
    }

    :host([theme='danger']) ::slotted([slot='icon']) {
      color: var(--bbj-color-danger);
      border-color: var(--bbj-color-danger);
      background-color: var(--bbj-color-danger-alt);
    }

    :host([theme='success']) ::slotted([slot='icon']) {
      color: var(--bbj-color-success);
      border-color: var(--bbj-color-success);
      background-color: var(--bbj-color-success-alt);
    }

    :host([theme='info']) ::slotted([slot='icon']) {
      color: var(--bbj-color-info);
      border-color: var(--bbj-color-info);
      background-color: var(--bbj-color-info-alt);
    }

    :host([theme='warning']) ::slotted([slot='icon']) {
      color: var(--bbj-color-warning);
      border-color: var(--bbj-color-warning);
      background-color: var(--bbj-color-warning-alt);
    }`;
  }

  constructor() {
    super();
    this.formatOptions = {
      currency: 'EUR',
      minimumFractionDigits: 2,
      maximumFractionDigits: 2,
    };
    this.lang = 'de-DE';
    this.label = '';
    this.start = 0;
    this.speed = 1000;
    this.theme = '';
    this.value = 0;
    this.valuePrefix = this.valuePrefix || '';
    this.valueSuffix = this.valueSuffix || '';
  }

  updated(changedProperties) {
    if (changedProperties.has('value')) {
      this.animate(this.value);
    }
  }

  format(value) {
    const formatted = new Intl.NumberFormat(this.lang, this.formatOptions).format(value);
    return `${this.valuePrefix || ''}${formatted}${this.valueSuffix || ''}`
  }

  animate(value) {
    const start = this.start;
    const duration = this.speed;

    if (duration === 0) {
      this.renderRoot.querySelector('[part="value"]').innerHTML = this.format(value);
      return;
    }

    const inc = (timestamp) => {
      const progress = timestamp - start;
      const progressPercentage = Math.min(progress / duration, 1);
      const currentValue = start + progressPercentage * (value - start);
      this.renderRoot.querySelector('[part="value"]').innerHTML = this.format(currentValue);
      if (progress < duration) {
        window.requestAnimationFrame(inc);
      }
    };

    window.requestAnimationFrame(inc);
  }

  render() {
    return html`
    <Panel part="card">
      <slot name="icon"></slot>
      <Panel part="content">
        <Panel part="value">${this.format(this.value)}</Panel>
        <Panel part="label">${this.label}</Panel>
      </Panel>
    </Panel>`;
  }
}

customElements.define('animated-counter', AnimatedCounter);
