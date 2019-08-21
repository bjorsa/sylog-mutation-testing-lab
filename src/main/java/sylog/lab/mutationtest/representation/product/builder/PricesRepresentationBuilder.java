package sylog.lab.mutationtest.representation.product.builder;

import sylog.lab.mutationtest.domain.shopping.price.Prices;
import sylog.lab.mutationtest.representation.product.PriceRepresentation;
import sylog.lab.mutationtest.representation.product.PricesRepresentation;

import java.util.Currency;
import java.util.Map;
import java.util.stream.Collectors;

public final class PricesRepresentationBuilder {

    private PricesRepresentationBuilder() {
        // prevent instantiation and sub classing
    }

    public static PricesRepresentation fromPrices(Prices prices) {
        return new PricesRepresentation(buildCurrencyPriceRepresentationMap(prices));
    }

    private static Map<Currency, PriceRepresentation> buildCurrencyPriceRepresentationMap(Prices prices) {
        return prices.getCurrencies().stream().collect(
                Collectors.toMap(c -> c, c -> PriceRepresentationBuilder.fromPrice(prices.getPriceByCurrency(c)))
        );
    }
}
