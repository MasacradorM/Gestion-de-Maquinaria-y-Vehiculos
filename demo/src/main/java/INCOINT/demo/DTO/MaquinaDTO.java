package INCOINT.demo.DTO;

import java.time.LocalDateTime;

import INCOINT.demo.model.TipoMaquinaria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaquinaDTO {

    private TipoMaquinaria tipoMaquinariaId;
    private String maquina;
    private LocalDateTime fechaRegistro;
    private boolean estatus;

}
