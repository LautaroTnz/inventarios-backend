package Lt.Inventarios.Rest;

import Lt.Inventarios.Entity.Dto.EmpleadoDTO;
import Lt.Inventarios.Entity.Empleado;
import Lt.Inventarios.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleados")
public class EmpleadoRest {

    private EmpleadoService empleadoService;

    @Autowired
    public EmpleadoRest(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearEmpleado(@RequestBody EmpleadoDTO empleadoDTO){
        Empleado empleado = empleadoService.guardarEmpleado(empleadoDTO);
        return new ResponseEntity<>("Empleado creado con exito: " + empleado.getId(), HttpStatus.CREATED);
    }

}
