package sylog.lab.mutationtest.representation.product.builder;

import sylog.lab.mutationtest.domain.shopping.price.Price;
import sylog.lab.mutationtest.representation.product.PriceRepresentation;

public final class PriceRepresentationBuilder {

    private PriceRepresentationBuilder() {
        // prevent instantiation and sub classing
    }

    public static PriceRepresentation fromPrice(Price price) {
        return new PriceRepresentation(price.getAmount());
    }
}
