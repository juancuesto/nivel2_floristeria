package com.floristeria_sql.nivel_floristeria.repositori;

import com.floristeria_sql.nivel_floristeria.domain.Flor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlorRepositori extends JpaRepository<Flor,Long> {
}
