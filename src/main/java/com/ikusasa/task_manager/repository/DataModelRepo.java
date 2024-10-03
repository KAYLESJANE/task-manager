package com.ikusasa.task_manager.repository;

import com.ikusasa.task_manager.model.DataModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DataModelRepo is a Spring Data JPA repository interface for managing
 * DataModel entities in the database.
 */

public interface DataModelRepo extends JpaRepository <DataModel, String >{

}
