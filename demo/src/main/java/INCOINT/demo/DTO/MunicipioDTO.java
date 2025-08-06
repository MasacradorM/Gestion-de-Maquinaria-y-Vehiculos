package INCOINT.demo.DTO;

import INCOINT.demo.model.Departamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MunicipioDTO {

    private Departamento departamentoId;
    private String municipioNombre;
    private int codigoDane;
    
}
