



document.addEventListener("DOMContentLoaded", () => {
  
  // Inicializar la aplicación
  const app = new EquipmentFormApp();
  app.initialize();
});

// Clase principal que orquesta la aplicación
class EquipmentFormApp {
  constructor() {
    // Inicializar las diferentes partes de la aplicación
    this.formManager = new FormManager();
    this.stateManager = new StateManager(this.formManager);
    this.activityManager = new ActivityManager();
    this.calculationManager = new CalculationManager();
    this.modalManager = new ModalManager(this.stateManager);
  }

  initialize() {
    this.stateManager.initialize();
    this.activityManager.initialize();
    this.calculationManager.initialize();
    this.modalManager.initialize();
  }
}

// Gestor de formularios (SRP: responsable de obtener referencias a elementos DOM)
class FormManager {
  constructor() {
    // Estado y formulario principal
    this.estadoRadios = document.querySelectorAll('input[name="estado"]');
    this.actividadCell = document.getElementById("actividad-cell");
    
    // Secciones del formulario
    this.sections = {
      fechaContainer: document.getElementById("fecha-container"), 
      obraContainer: document.getElementById("obra-container"),
      gpsContainer:document.getElementById("gps-container"),
      costosSection: document.getElementById("costos-section"),
      actividadSection: document.getElementById("actividad-cell"),
      combustibleSection: document.getElementById("combustible-section"),
      gpsSection: document.getElementById("gps-section"),
      observacionesSection: document.getElementById("observaciones-section"),
      conductorContainer: document.getElementById("conductor-container"),
      reporteContainer: document.getElementById("reporte-container")
    };
    
    // Campos de entrada
    this.inputs = {
      valorHr: document.getElementById("modal-valor-hr"),
      total: document.getElementById("modal-total"),
      galones: document.getElementById("combustible-galones"),
      hrCombustible: document.getElementById("combustible-kilometro"),
      rendimiento: document.getElementById("combustible-rendimiento"),
      actividadSelect: document.getElementById("actividad-select"),
      actividadInput: document.getElementById("nueva-actividad-input"),
      mantenimientoForm: document.getElementById("mantenimiento-form"),
      tipoInput: document.getElementById("modal-tipo"),
      placaInput: document.getElementById("modal-placa"),
      fechaInput: document.getElementById("modal-fecha"),
      obraInput: document.getElementById("modal-obra"),
      conductorInput: document.getElementById("modal-conductor"),
      gpsInput: document.getElementById("modal-gps")  
    };
    
    // Actividades
    this.activityElements = {
      btnAgregarActividad: document.getElementById("btn-agregar-actividad"),
      btnGuardarActividad: document.getElementById("btn-guardar-actividad"),
      nuevaActividadContainer: document.getElementById("nueva-actividad-container"),
      nuevaActividadInput: document.getElementById("nueva-actividad-input"),
      actividadesAgregadas: document.getElementById("actividades-agregadas"),
      mensajeActividadesVacio: document.getElementById("mensaje-actividades-vacio")
    };

    // Modal
    this.equipoModal = document.getElementById("equipoModal");
  }

  // Método para mostrar/ocultar una sección
  toggleSection(sectionId, display) {
    if (this.sections[sectionId]) {
      this.sections[sectionId].style.display = display ? "block" : "none";
    }
  }

  // Método para obtener un elemento de entrada
  getInput(inputId) {
    return this.inputs[inputId];
  }

  // Método para obtener un elemento de actividades
  getActivityElement(elementId) {
    return this.activityElements[elementId];
  }
}

// Gestor de estados (SRP: responsable de gestionar estados del formulario)
class StateManager {
  constructor(formManager) {
    this.formManager = formManager;
    this.requiredFields = {
      standby: ["modal-fecha", "modal-obra", "modal-conductor"],
      mantenimiento: ["modal-fecha", "modal-obra", "actividad-select", "modal-reporte"],
      disponible: ["modal-fecha", "modal-obra"],
      operacion: ["modal-fecha", "modal-obra", 
                  "modal-valor-hr", "actividad-select", "modal-conductor", "modal-reporte"]
    };
  }
  
  initialize() {
    // Registrar eventos para cambio de estado
    this.formManager.estadoRadios.forEach((radio) => {
      radio.addEventListener("change", () => {
        if (radio.checked) {
          this.updateSectionsVisibility(radio.id);
        }
      });
    });
  }

  // Actualizar visibilidad de secciones según estado
  updateSectionsVisibility(stateId) {
    // Reset all required fields
    this.resetRequiredFields();
    
    // Ocultar todas las secciones primero
    Object.keys(this.formManager.sections).forEach(sectionId => {
      this.formManager.toggleSection(sectionId, false);
    });
    
    // Mostrar secciones según el estado seleccionado
    switch(stateId) {
      case "standby":
        this.formManager.toggleSection("observacionesSection", true);
        this.formManager.toggleSection("conductorContainer", true);
        this.formManager.toggleSection("horasSection", true);
        this.formManager.toggleSection("reporteContainer", true);
        this.formManager.toggleSection("operacionDetails", true);
        this.setRequiredFields("standby");
        break;
        
      case "mantenimiento":
        this.formManager.toggleSection("fechaContainer", true);
        this.formManager.toggleSection("obraContainer", true);  
        this.formManager.toggleSection("horasSection", true);
        this.formManager.toggleSection("actividadSection", true);
        this.formManager.toggleSection("observacionesSection", true);
        this.formManager.toggleSection("reporteContainer", true);
        this.setRequiredFields("mantenimiento");
        break;
        
      case "disponible":
        this.formManager.toggleSection("fechaContainer", true);
        this.formManager.toggleSection("horasSection", true);
        this.formManager.toggleSection("costosSection", true);
        this.formManager.toggleSection("observacionesSection", true);
        this.formManager.toggleSection("reporteContainer", true);

        this.setRequiredFields("disponible");
        break;
        
      case "operacion":
        this.formManager.toggleSection("fechaContainer", true);
        this.formManager.toggleSection("obraContainer", true);
        this.formManager.toggleSection("horasSection", true);
        this.formManager.toggleSection("costosSection", true);
        this.formManager.toggleSection("actividadSection", true);
        this.formManager.toggleSection("combustibleSection", true);
        this.formManager.toggleSection("gpsSection", true);
        this.formManager.toggleSection("observacionesSection", true);
        this.formManager.toggleSection("conductorContainer", true);
        this.formManager.toggleSection("reporteContainer", true);
        this.formManager.toggleSection("gpsContainer", true);
        this.setRequiredFields("operacion");
        break;
    }
  }
  
  // Resetear los campos requeridos
  resetRequiredFields() {
    // Combinar todos los posibles campos requeridos
    const allPossibleRequired = [...new Set([
      ...this.requiredFields.standby,
      ...this.requiredFields.mantenimiento,
      ...this.requiredFields.disponible,
      ...this.requiredFields.operacion
    ])];
    
    allPossibleRequired.forEach(fieldId => {
      const field = document.getElementById(fieldId);
      if (field) {
        field.removeAttribute("required");
      }
    });
  }
  
  // Establecer campos requeridos según el estado
  setRequiredFields(state) {
    if (this.requiredFields[state]) {
      this.requiredFields[state].forEach(fieldId => {
        const field = document.getElementById(fieldId);
        if (field) {
          field.setAttribute("required", "required");
        }
      });
    }
  }
}

// Gestor de actividades (SRP: responsable de gestionar las actividades)
class ActivityManager {
  constructor() {
    // Referencias a elementos DOM relacionados con actividades
    this.btnAgregarActividad = document.getElementById("btn-agregar-actividad");
    this.btnGuardarActividad = document.getElementById("btn-guardar-actividad");
    this.nuevaActividadContainer = document.getElementById("nueva-actividad-container");
    this.nuevaActividadInput = document.getElementById("nueva-actividad-input");
    this.actividadesAgregadas = document.getElementById("actividades-agregadas");
    this.mensajeActividadesVacio = document.getElementById("mensaje-actividades-vacio");
    this.actividadSelect = document.getElementById("actividad-select");
    this.cantidadActividad = document.getElementById("cantidad-actividad");
    
    // Lista de actividades
    this.actividades = [];
  }
  
  initialize() {
    this.setupEventListeners();
  }
  
  setupEventListeners() {
    // Mostrar/ocultar entrada de nueva actividad
    if (this.actividadSelect) {
      this.actividadSelect.addEventListener("change", () => {
        if (this.nuevaActividadContainer) {
          this.nuevaActividadContainer.style.display = 
            this.actividadSelect.value === "Otra actividad..." ? "block" : "none";
        }
      });
    }
    
    // Agregar actividad desde select
    if (this.btnAgregarActividad) {
      this.btnAgregarActividad.addEventListener("click", () => {
        if (!this.actividadSelect || !this.actividadesAgregadas || !this.mensajeActividadesVacio) return;
        
        const selectedValue = this.actividadSelect.value;
        const cantidadIngresada = parseInt(this.cantidadActividad.value,10);
      
      
        if (selectedValue && selectedValue !== "Seleccionar actividad" && selectedValue !== "Otra actividad..." &&       !isNaN(cantidadIngresada) && cantidadIngresada > 0
) {
          this.addActivity(selectedValue,cantidadIngresada);
        }
      });
    }
    
    // Guardar nueva actividad personalizada
    if (this.btnGuardarActividad && this.nuevaActividadInput) {
      this.btnGuardarActividad.addEventListener("click", () => {
        const nuevaActividad = this.nuevaActividadInput.value.trim();
        if (nuevaActividad) {
          this.addActivity(nuevaActividad);
          // Resetear la entrada y ocultar el contenedor
          this.nuevaActividadInput.value = "";
          if (this.nuevaActividadContainer) {
            this.nuevaActividadContainer.style.display = "none";
          }
          // Resetear el select
          if (this.actividadSelect) {
            this.actividadSelect.value = "Seleccionar actividad";
          }
        }
      });
    }
  }
  
  // Agregar actividad a la lista
  addActivity(nombreActividad,cantidad) {
    if (!this.actividadesAgregadas || !this.mensajeActividadesVacio) return;
    
    this.actividades.push({ actividad: nombreActividad, cantidad });

    // Ocultar mensaje de vacío
    this.mensajeActividadesVacio.style.display = "none";
    
    // Crear elemento de actividad
    const actividadItem = document.createElement("div");
    actividadItem.className = "d-flex justify-content-between align-items-center mb-2";
    
    const actividadText = document.createElement("span");
    actividadText.textContent = `${nombreActividad} (x${cantidad})`;   // ⬅️ mostramos cantidad

    const deleteBtn = document.createElement("button");
    deleteBtn.className = "btn btn-sm btn-danger";
    deleteBtn.innerHTML = '<i class="bi bi-trash"></i>';
    deleteBtn.addEventListener("click", () => {
      this.removeActivity(nombreActividad, actividadItem);
    });
    
    actividadItem.appendChild(actividadText);
    actividadItem.appendChild(deleteBtn);
    this.actividadesAgregadas.appendChild(actividadItem);
  }
  
  // Eliminar actividad de la lista
 removeActivity(nombreActividad, actividadItem) {
  this.actividades = this.actividades.filter(a => a.actividad !== nombreActividad);
  actividadItem.remove();
  if (this.actividades.length === 0) {
    this.mensajeActividadesVacio.style.display = "block";
  }
}

}


class CalculationManager {
  constructor() {
    this.total = document.getElementById("modal-total");
    this.galones = document.getElementById("combustible-galones");
    this.hrCombustible = document.getElementById("combustible-kilometro");
    this.rendimiento = document.getElementById("combustible-rendimiento");
  }
  
  initialize() {
    this.setupEventListeners();
  }
  
  setupEventListeners() {
    // Eventos para cálculo de rendimiento
    if (this.galones && this.hrCombustible) {
      this.galones.addEventListener("input", () => this.calculateEfficiency());
      this.hrCombustible.addEventListener("input", () => this.calculateEfficiency());
    }
  }
  
  // Cálculo de horómetro y total
  calculateHorometerAndTotal() {
    if (!this.hrInicial || !this.hrFinal || !this.hrTotal || !this.valorHr || !this.total) return;
    
    const inicial = parseFloat(this.hrInicial.value);
    const final = parseFloat(this.hrFinal.value);
    const valor = parseFloat(this.valorHr.value);

    if (!isNaN(inicial) && !isNaN(final) && final >= inicial) {
      const totalHoras = final - inicial;
      this.hrTotal.value = totalHoras.toFixed(2);

      if (!isNaN(valor)) {
        this.total.value = (totalHoras * valor).toFixed(2);
      }
    } else {
      this.hrTotal.value = "";
      this.total.value = "";
    }
  }

  // Cálculo de rendimiento de combustible
  calculateEfficiency() {
    if (!this.galones || !this.hrCombustible || !this.rendimiento) return;
    
    const gal = parseFloat(this.galones.value);
    const horas = parseFloat(this.hrCombustible.value);

    if (!isNaN(gal) && !isNaN(horas) && horas > 0) {
      this.rendimiento.value = (gal / horas).toFixed(2);
    } else {
      this.rendimiento.value = "";
    }
  }
}

// Gestor del modal (SRP: responsable de inicializar y gestionar el modal)
class ModalManager {
  constructor(stateManager) {
    this.stateManager = stateManager;
    this.equipoModal = document.getElementById("equipoModal");
    this.tipoInput = document.getElementById("modal-tipo");
    this.placaInput = document.getElementById("modal-placa");
    this.fechaInput = document.getElementById("modal-fecha");
    this.obraInput = document.getElementById("modal-obra");
    this.conductorInput = document.getElementById("modal-conductor");
  }
  
  initialize() {
    if (this.equipoModal) {
      this.equipoModal.addEventListener("show.bs.modal", (event) => {
        const button = event.relatedTarget;
        if (!button) return;

        // Obtener atributos del botón
        const tipo = button.getAttribute("data-tipo") || "";
        const placa = button.getAttribute("data-placa") || "";
        const estado = button.getAttribute("data-estado") || "";
        const fecha = button.getAttribute("data-fecha") || "";
        const obra = button.getAttribute("data-obra") || "";
        const conductor = button.getAttribute("data-conductor") || "";

        // Establecer valores en el formulario
        this.setFormValues(tipo, placa, fecha, obra, conductor);
        
        // Establecer estado
        this.setFormState(estado);
      });
    }
  }
  
  // Establecer valores en el formulario
  setFormValues(tipo, placa, fecha, obra, conductor) {
    if (this.tipoInput) this.tipoInput.value = tipo;
    if (this.placaInput) this.placaInput.value = placa;
    if (this.fechaInput) this.fechaInput.value = fecha || new Date().toISOString().split('T')[0]; // Fecha actual si no hay
    if (this.obraInput) this.obraInput.value = obra;
    if (this.conductorInput) this.conductorInput.value = conductor;
  }
  
  // Establecer estado del formulario
  setFormState(estado) {
    const radio = document.getElementById(estado.toLowerCase()) || 
                  document.querySelector(`input[name="estado"][id="${estado.toLowerCase()}"]`);
    
    if (radio) {
      radio.checked = true;
      // Disparar el evento change para actualizar la visibilidad
      radio.dispatchEvent(new Event("change"));
    } else {
      // Por defecto, seleccionar DISPONIBLE
      const defaultRadio = document.getElementById("disponible");
      if (defaultRadio) {
        defaultRadio.checked = true;
        defaultRadio.dispatchEvent(new Event("change"));
      }
    }
  }
}




