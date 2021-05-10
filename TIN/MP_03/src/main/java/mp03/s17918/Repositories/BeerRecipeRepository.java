package mp03.s17918.Repositories;

import mp03.s17918.models.Beer_Recipe;
import org.springframework.data.repository.CrudRepository;

public interface BeerRecipeRepository extends CrudRepository<Beer_Recipe, Long> {
}
