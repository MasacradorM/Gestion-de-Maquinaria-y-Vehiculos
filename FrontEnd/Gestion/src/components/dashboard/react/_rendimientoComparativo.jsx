// RendimientoComparativoChart.jsx
import React from 'react';
import '@/styles/main.scss';  // Ya incluye todos los estilos de configuración

export default function RendimientoComparativo({
  datosAyer = {
    kmRecorridos: 0,
    rendimientoKmGal: 5,
    galonesUsados: 9876,
    velocidadMax: 998
  },
  datosAnteayer = {
    kmRecorridos: 2345,
    rendimientoKmGal: 0,
    galonesUsados: 0,
    velocidadMax: 0
  },
  fechaAyer = "08/04/2025",
  fechaAnteayer = "09/04/2025"
}) {
  return (
    <div className="col-lg-7 rendimiento-chart-container">
      <div className="card-header" />
      <div className="card-body">
        <div className="chart-container">
          {/* Eje Y */}
          <div className="chart-grid">
            <div className="y-axis">
              <span>200</span>
              <span>150</span>
              <span>100</span>
              <span>50</span>
              <span>0</span>
            </div>

            {/* Columnas */}
            <div className="chart-columns">
              {[
                ['kmRecorridos', 'Km Recorridos'],
                ['rendimientoKmGal', 'Rendimiento (km/gal)'],
                ['galonesUsados', 'Galones usados'],
                ['velocidadMax', 'Velocidad Máx']
              ].map(([key], index) => (
                <div className="chart-column" key={index}>
                  <div className="bars-container">
                    <div className="bar ayer" style={{ height: `${datosAyer[key] / 10}%` }}></div>
                    <div className="bar anteayer" style={{ height: `${datosAnteayer[key] /20}%` }}></div>
                  </div>
                </div>
              ))}
            </div>
          </div>

          {/* Eje X */}
          <div className="x-axis-labels">
            <div className="axis-label">Km Recorridos</div>
            <div className="axis-label">Rendimiento (km/gal)</div>
            <div className="axis-label">Galones usados</div>
            <div className="axis-label">Velocidad Máx</div>
          </div>

          {/* Leyenda */}
          <div className="chart-legend">
            <div className="legend-item">
              <div className="legend-color ayer"></div>
              <span>Ayer ({fechaAyer})</span>
            </div>
            <div className="legend-item">
              <div className="legend-color anteayer"></div>
              <span>Anteayer ({fechaAnteayer})</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
