
// Función para abrir modal de nueva obra
function nuevaObra() {
  const modal = document.getElementById('modalNuevaObra');
  if (modal) {
    modal.style.display = 'flex';
    document.body.style.overflow = 'hidden';
    document.getElementById('nombreObra')?.focus();
  }
}

// Función para cambiar página
function irAPagina(pagina) {
  document.querySelectorAll('.page-btn').forEach(btn => {
    btn.classList.remove('active');
  });
  event.target.classList.add('active');
  console.log(`Ir a página ${pagina}`);
}

// Función para cambiar página (prev/next)
function cambiarPagina(direccion) {
  const activeBtn = document.querySelector('.page-btn.active');
  const currentPage = activeBtn ? parseInt(activeBtn.textContent) : 1;
  
  if (direccion === 'prev' && currentPage > 1) {
    irAPagina(currentPage - 1);
  } else if (direccion === 'next' && currentPage < 5) {
    irAPagina(currentPage + 1);
  }
}
function cambiarTitulo(titulo, breadcrumbItem) {
  const pageTitle = document.getElementById('page-title');
  const breadcrumb = document.getElementById('breadcrumb-nav');
  
  if (pageTitle) pageTitle.textContent = titulo;
  
  if (breadcrumb) {
    breadcrumb.innerHTML = `
      <li class="breadcrumb-item"><a href="#" onclick="volverInicio()">Home</a></li>
      <li class="breadcrumb-item"><a href="#" onclick="volverInicio()">Configuración</a></li>
      <li class="breadcrumb-item active" aria-current="page">${breadcrumbItem}</li>
    `;
  }
}

function volverInicio() {
  document.querySelectorAll('.gestion-section').forEach(section => {
    section.style.display = 'none';
  });
  document.querySelectorAll('.config-section').forEach(section => {
    section.style.display = 'block';
  });
  cambiarTitulo('Configuración', 'Configuración');
}

// MAIN CODE
document.addEventListener('DOMContentLoaded', function() {
  console.log('DOM cargado - Iniciando configuración...');

  // 1. CONFIGURACIÓN DE TARJETAS
  const tarjetas = document.querySelectorAll('.config-card');
  console.log(`Tarjetas encontradas: ${tarjetas.length}`);

  tarjetas.forEach(tarjeta => {
    tarjeta.addEventListener('click', function() {
      const sectionId = this.getAttribute('data-config');
      console.log(`Clic en tarjeta: ${sectionId}`);

      // Ocultar todas las secciones
      document.querySelectorAll('.gestion-section, .config-section').forEach(section => {
        section.style.display = 'none';
      });

      // Mostrar sección objetivo
      const targetId = `seccion-${sectionId}`;
      const targetSection = document.getElementById(targetId);
      
      if (targetSection) {
        console.log(`Mostrando sección: ${targetId}`);
        targetSection.style.display = 'block';
        
        // Actualizar título y breadcrumb
        const nombreSeccion = sectionId.charAt(0).toUpperCase() + sectionId.slice(1);
        cambiarTitulo(`Gestión de ${nombreSeccion}`, `Gestión de ${nombreSeccion}`);
        
        // Scroll suave
        targetSection.scrollIntoView({ behavior: 'smooth' });
      } else {
        console.error(`Sección no encontrada: ${targetId}`);
      }
    });
  });

  // 2. MANEJO DE MODALES (versión optimizada)
  const configModales = {
    obra: {
      id: 'modalNuevaObra',
      btnApertura: '.btn-nueva-obra',
      formId: 'formNuevaObra',
      campoFoco: '#nombreObra'
    },
    actividad: {
      id: 'modalNuevaActividad',
      btnApertura: '.btn-nueva-actividad',
      formId: 'formNuevaActividad',
      campoFoco: '#nombreActividad'
    },
    personal: {
      id: 'modalNuevoPersonal',
      btnApertura: '.btn-nuevo-personal',
      formId: 'formNuevoPersonal',
      campoFoco: '#nombrePersonal'
    }
  };

  Object.values(configModales).forEach(modalConfig => {
    const modal = document.getElementById(modalConfig.id);
    if (!modal) {
      console.error(`Modal no encontrado: ${modalConfig.id}`);
      return;
    }

    // Evento apertura
    document.querySelectorAll(modalConfig.btnApertura).forEach(boton => {
      boton.addEventListener('click', (e) => {
        e.preventDefault();
        modal.style.display = 'flex';
        document.body.style.overflow = 'hidden';
        const campo = document.querySelector(modalConfig.campoFoco);
        if (campo) campo.focus();
      });
    });

    // Evento cierre
    modal.querySelectorAll('[data-dismiss="modal"], .btn-secondary').forEach(boton => {
      boton.addEventListener('click', () => {
        modal.style.display = 'none';
        document.body.style.overflow = 'auto';
      });
    });

    // Clic fuera del modal
    modal.addEventListener('click', (e) => {
      if (e.target === modal) {
        modal.style.display = 'none';
        document.body.style.overflow = 'auto';
      }
    });

    // Submit formulario
    const form = document.getElementById(modalConfig.formId);
    if (form) {
      form.addEventListener('submit', (e) => {
        e.preventDefault();
        // Aquí tu lógica para guardar
        modal.style.display = 'none';
        document.body.style.overflow = 'auto';
      });
    }
  });

  // Cerrar modales con ESC
  document.addEventListener('keydown', (e) => {
    if (e.key === 'Escape') {
      document.querySelectorAll('.modal-commons-backdrop').forEach(modal => {
        if (modal.style.display === 'flex') {
          modal.style.display = 'none';
          document.body.style.overflow = 'auto';
        }
      });
    }
  });

  console.log('Configuración completada correctamente');
});

// Otras funciones que necesites conservar
function cambiarTituloInicio() {
  cambiarTitulo('Configuración', 'Configuración');
}

// Manejo de botones Volver
document.querySelectorAll('.btn-volver, .btn-volverActividad, .btn-volverPersonal').forEach(btn => {
  btn.addEventListener('click', function(e) {
    e.preventDefault();
    volverInicio();
  });
});


 // Manejo de botones de Acceso Rápido
  document.querySelectorAll('.quick-access-btn').forEach(btn => {
    btn.addEventListener('click', function(e) {
      e.preventDefault();
      const modalId = this.getAttribute('data-modal-target');
      if (modalId) {
        const modal = document.getElementById(modalId);
        if (modal) {
          modal.style.display = 'flex';
          document.body.style.overflow = 'hidden';
          const input = modal.querySelector('input');
          if (input) input.focus();
        }
      }
    });
  });
