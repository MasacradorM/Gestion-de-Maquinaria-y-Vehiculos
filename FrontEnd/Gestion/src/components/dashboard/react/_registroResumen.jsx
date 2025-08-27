
import React from 'react';
import '@/styles/main.scss';  


export default function RegistroResumen({
  horaInicio = "7:05 AM",
  totalVehiculos = 26,
  vehiculosPendientes = [
    { codigo: "DA3450", nombre: "CAMIÓN DA3450" },
    { codigo: "SVF404", nombre: "VOLQUETA SVF404" },
    { codigo: "DA3445", nombre: "CAMIÓN DA3445" },
    { codigo: "DA3445", nombre: "CAMIÓN DA3445" },
  ],
  porcentajeCompletado = 85
}) {
  return (
    <div className="registro-resumen-container h-100">
      <div className="card-header">
        <h3 className="card-title">Resumen del Registro</h3>
      </div>
      <div className="card-body">
        <div className="registro-summary">
          <div className="summary-header">
            <span className="total-vehicles">22 de {totalVehiculos} vehículos registrados</span>
            <span className="start-time">Hora inicio: {horaInicio}</span>
          </div>

          <div className="progress-container">
            <div
              className="progress-bar"
              style={{ width: `${porcentajeCompletado}%` }}
            >
              {porcentajeCompletado}%
            </div>
          </div>

          <div className="pending-vehicles">
            <h4>Vehículos Pendientes:</h4>
            <ul>
              {vehiculosPendientes.map((vehiculo, index) => (
                <li key={index}>
                  <span className="vehicle-type">{vehiculo.nombre}</span>
                  <span className="vehicle-code">{vehiculo.codigo}</span>
                </li>
              ))}
            </ul>
          </div>
        </div>
      </div>
    </div>
  );
}



