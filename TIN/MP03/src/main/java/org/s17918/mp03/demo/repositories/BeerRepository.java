package org.s17918.mp03.demo.repositories;

import org.s17918.mp03.demo.models.Beer;
import org.springframework.data.repository.CrudRepository;

public interface BeerRepository extends CrudRepository<Beer, Long> {
}
