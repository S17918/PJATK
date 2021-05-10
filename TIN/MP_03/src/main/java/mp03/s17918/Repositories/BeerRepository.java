package mp03.s17918.Repositories;

import mp03.s17918.models.Beer;
import org.springframework.data.repository.CrudRepository;

public interface BeerRepository extends CrudRepository<Beer, Long> {
}
