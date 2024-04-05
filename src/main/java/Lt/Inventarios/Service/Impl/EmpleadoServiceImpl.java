package Lt.Inventarios.Service.Impl;

import Lt.Inventarios.Entity.Dto.EmpleadoDTO;
import Lt.Inventarios.Entity.Empleado;
import Lt.Inventarios.Repository.EmpleadoRepository;
import Lt.Inventarios.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public Empleado guardarEmpleado(EmpleadoDTO empleadoDTO){
        Empleado empleado = new Empleado();
        empleado.setUsername(empleadoDTO.getUsername());
        empleado.setPassword(empleadoDTO.getPassword());
        empleado.setFirstname(empleadoDTO.getFirstname());
        empleado.setLastname((empleadoDTO.getLastname()));
        empleado.setCountry((empleadoDTO.getCountry()));
        empleado.setSector((empleadoDTO.getSector()));
        empleado.setDocumento((empleadoDTO.getDocumento()));
        empleado.setRole(empleadoDTO.getRole());
        return empleadoRepository.save(empleado);
    }

}
