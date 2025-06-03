import { setupDropdowns } from './dropdown';
import { setupSortable } from './sortable';

export function initializeScripts(): void {
  consol
  document.addEventListener('DOMContentLoaded', () => {
    setupDropdowns();
    setupSortable();
  });
}