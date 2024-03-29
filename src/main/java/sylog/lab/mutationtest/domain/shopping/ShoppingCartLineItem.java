package sylog.lab.mutationtest.domain.shopping;

import sylog.lab.mutationtest.domain.Identifier;
import sylog.lab.mutationtest.domain.ValueObject;
import sylog.lab.mutationtest.domain.util.Validate;

public final class ShoppingCartLineItem extends ValueObject {

    private final Identifier sku;
    private final int quantity;

    public ShoppingCartLineItem(Identifier sku, int quantity) {
        Validate.notNull(sku);
        Validate.positive(quantity, () -> new IllegalArgumentException("quantity must be a positive integer."));

        this.sku = sku;
        this.quantity = quantity;
    }

    public Identifier getSKU() {
        return sku;
    }

    public int getQuantity() {
        return quantity;
    }
}
