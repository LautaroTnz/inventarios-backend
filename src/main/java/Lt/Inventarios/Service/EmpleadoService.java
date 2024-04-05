package Lt.Inventarios.Service;

import Lt.Inventarios.Entity.Dto.EmpleadoDTO;
import Lt.Inventarios.Entity.Empleado;

public interface EmpleadoService {

    Empleado guardarEmpleado(EmpleadoDTO empleadoDTO);

}
