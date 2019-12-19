package interceptors;

import java.util.HashMap;
import javax.enterprise.inject.Produces;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Biagio
 */
public class HashMapProduces {
    @Produces
    HashMap<String, Integer> counters;
}
