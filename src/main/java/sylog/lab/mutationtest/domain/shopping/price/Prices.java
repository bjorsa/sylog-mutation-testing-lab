package sylog.lab.mutationtest.domain.shopping.price;

import sylog.lab.mutationtest.domain.ValueObject;
import sylog.lab.mutationtest.domain.util.Validate;

import java.util.Collections;
import java.util.Currency;
import java.util.Map;
import java.util.Set;

public final class Prices extends ValueObject {
    private final Map<Currency, Price> prices;

    public Prices(Map<Currency, Price> prices) {
        Validate.notNull(prices);
        Validate.notEmpty(prices);

        this.prices = Collections.unmodifiableMap(prices);
    }

    public Set<Currency> getCurrencies() {
        return Collections.unmodifiableSet(prices.keySet());
    }

    public Price getPriceByCurrency(Currency currency) {
        return prices.get(currency);
    }
}
