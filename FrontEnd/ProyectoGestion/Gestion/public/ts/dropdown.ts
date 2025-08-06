export function setupDropdowns(): void {
  // Definición mejorada de tipos
  interface HTMLElementWithArrow extends HTMLElement {
    querySelector(selectors: '.arrow'): HTMLElement | null;
  }

  interface HTMLElementWithDropdown extends HTMLElement {
    querySelector(selectors: '.dropdown-content'): HTMLElement | null;
    previousElementSibling: HTMLElementWithArrow | null;
  }

  // Función para cerrar otros dropdowns
  const closeOtherDropdowns = (currentContent: HTMLElement | null): void => {
    const allVisibleDropdowns = document.querySelectorAll<HTMLElement>('.dropdown-content.visible');
    
    allVisibleDropdowns.forEach((dropdown) => {
      if (dropdown !== currentContent && dropdown.previousElementSibling) {
        dropdown.classList.remove('visible');
        const sibling = dropdown.previousElementSibling as HTMLElementWithArrow;
        const arrow = sibling.querySelector('.arrow');
        arrow?.classList.remove('rotated');
      }
    });
  };

  // Configuración de botones toggle
  const setupToggleButtons = (): void => {
    const toggleButtons = document.querySelectorAll<HTMLElementWithArrow>('.toggle-button');
    
    toggleButtons.forEach((button) => {
      button.addEventListener('click', (e) => {
        e.stopPropagation();
        const container = button.closest<HTMLElementWithDropdown>('.dropdown-container');
        
        if (!container) return;

        const arrow = button.querySelector('.arrow');
        const content = container.querySelector('.dropdown-content');

        if (!arrow || !content) return;

        closeOtherDropdowns(content);
        
        arrow.classList.toggle('rotated');
        content.classList.toggle('visible');
      });
    });
  };

  // Manejo de clics fuera del dropdown
  const setupDocumentClickHandler = (): void => {
    document.addEventListener('click', (e) => {
      const target = e.target as HTMLElement;
      
      if (!target.closest('.dropdown-container')) {
        const allVisibleContents = document.querySelectorAll<HTMLElement>('.dropdown-content.visible');
        
        allVisibleContents.forEach((content) => {
          content.classList.remove('visible');
          if (content.previousElementSibling) {
            const sibling = content.previousElementSibling as HTMLElementWithArrow;
            const arrow = sibling.querySelector('.arrow');
            arrow?.classList.remove('rotated');
          }
        });
      }
    });
  };

  // Inicialización
  setupToggleButtons();
  setupDocumentClickHandler();
}