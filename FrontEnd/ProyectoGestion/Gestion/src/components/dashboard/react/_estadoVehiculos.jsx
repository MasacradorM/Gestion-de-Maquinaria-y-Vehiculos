import React, { useState } from "react";
import '@/styles/main.scss';  

export default function EstadoVehiculosReact({ vehiculos }) {
  const [estadoActual, setEstadoActual] = useState("disponible");
  const filtrados = vehiculos.filter((v) => v.estado === estadoActual);

  return (
    <div className="estado-vehiculos-container">
      <div className="filtros-botones mb-3">
        {["disponible", "mantenimiento", "transito"].map((estado) => (
          <button
            key={estado}
            className={`estado-btn ${estadoActual === estado ? "active" : ""}`}
            onClick={() => setEstadoActual(estado)}
          >
            <span className="btn-text">{estado}</span>
            <span className="badge">
              {vehiculos.filter((v) => v.estado === estado).length}
            </span>
          </button>
        ))}
      </div>

      <div className="lista-container">
        {filtrados.length > 0 ? (
          <ul className="lista-vehiculos">
            {filtrados.map((v, i) => (
              <li className="vehiculo-item" key={i}>
                <div className="vehiculo-info">
                  <strong>{v.nombre}</strong>
                  <span>{v.base}</span>
                </div>
                <div className={`vehiculo-status ${v.estado}`}></div>
              </li>
            ))}
          </ul>
        ) : (
          <div className="no-vehiculos">
            No hay vehículos en este estado
          </div>
        )}
      </div>
    </div>
  );
}