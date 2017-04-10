package org.ralphmorales.fx.fxHarvester.repositories;

import org.ralphmorales.fx.fxHarvester.entities.FileLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileLogRepository extends CrudRepository<FileLog, String>{

}
