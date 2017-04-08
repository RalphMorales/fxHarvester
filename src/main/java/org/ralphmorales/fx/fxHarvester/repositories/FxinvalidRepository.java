package org.ralphmorales.fx.fxHarvester.repositories;

import org.ralphmorales.fx.fxHarvester.entities.Fxinvalid;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FxinvalidRepository extends CrudRepository<Fxinvalid, Long>{

}
