package com.floristeria_sql.nivel_floristeria.repositori;

import com.floristeria_sql.nivel_floristeria.domain.Decoracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecoracionRepositori extends JpaRepository<Decoracion,Long> {
}
