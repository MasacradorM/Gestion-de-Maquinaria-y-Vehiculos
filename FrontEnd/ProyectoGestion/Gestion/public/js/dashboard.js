const tarjetas = {
  rendimiento: document.getElementById('card-rendimiento'),
  estado: document.getElementById('card-estado'),
  resumen: document.getElementById('card-resumen'),
  alertas: document.getElementById('card-alertas'),
};

const tarjetaNombres = {
  rendimiento: 'Comparación de Rendimiento',
  estado: 'Estado de Vehículos',
  resumen: 'Resumen del Registro',
  alertas: 'Alertas Pendientes'
};

const mensajeTarjetas = document.getElementById('mensaje-tarjetas');
const listaAgregar = document.getElementById('lista-agregar');

function verificarTarjetasMostradas() {
  const todasVisibles = Object.values(tarjetas).every(t => !t.classList.contains('d-none'));
  mensajeTarjetas && (mensajeTarjetas.style.display = todasVisibles ? 'block' : 'none');
}

function actualizarListaAgregar() {
  listaAgregar.innerHTML = '';

  Object.entries(tarjetas).forEach(([key, tarjeta]) => {
    if (tarjeta.classList.contains('d-none')) {
      const li = document.createElement('li');
      li.className = 'list-group-item agregar-item';
      li.dataset.card = key;
      li.textContent = tarjetaNombres[key];
      listaAgregar.appendChild(li);

      li.addEventListener('click', () => {
        tarjeta.classList.remove('d-none');
        actualizarListaAgregar();
        verificarTarjetasMostradas();
      });
    }
  });

  const dropdown = document.querySelector('.dropdown-content');
  if (dropdown) {
    dropdown.style.display = listaAgregar.children.length > 0 ? 'block' : 'none';
  }
}

document.addEventListener('click', function (event) {
  if (event.target.classList.contains('btn-close')) {
    const card = event.target.closest('.card');
    if (card) {
      card.classList.add('d-none');
      actualizarListaAgregar();
      verificarTarjetasMostradas();
    }
  }
});

document.addEventListener('DOMContentLoaded', () => {
  actualizarListaAgregar();
});
