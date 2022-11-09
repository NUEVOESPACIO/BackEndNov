
package com.sistema.examenes.repositorios;

import com.sistema.examenes.entidades.Educacion;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducacionRepository extends JpaRepository<Educacion, Long>{
    
}
