package sylog.lab.mutationtest.service.util;

import sylog.lab.mutationtest.domain.Identifier;
import sylog.lab.mutationtest.domain.shopping.product.StockKeepingUnit;

import java.util.Collections;
import java.util.List;

public class ProductWithSKUs {

    private final Identifier product;
    private final List<StockKeepingUnit> SKUs;

    public ProductWithSKUs(Identifier product, List<StockKeepingUnit> SKUs) {
        this.product = product;
        this.SKUs = Collections.unmodifiableList(SKUs);
    }

    public Identifier getProduct() {
        return product;
    }

    public List<StockKeepingUnit> getSKUs() {
        return SKUs;
    }
}
