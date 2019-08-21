package sylog.lab.mutationtest.domain.shopping;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import sylog.lab.mutationtest.domain.Identifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ShoppingCartLineItemTest {

    @Test
    public void shouldRetainSuppliedValues() {
        Identifier skuIdentifier = new Identifier();
        int quantity = 13;
        ShoppingCartLineItem lineItem = new ShoppingCartLineItem(skuIdentifier, quantity);

        assertThat(lineItem.getQuantity()).isEqualTo(quantity);
        Assertions.assertThat(lineItem.getSKU()).isEqualTo(skuIdentifier);
    }

    @Test
    public void shouldThrowWhenCreatedWithANullSKUIdentifier() {
        assertThatThrownBy(() -> new ShoppingCartLineItem(null, 13)).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void shouldThrowWhenCreatedWithANonPositiveQuantity() {
        assertThatThrownBy(() -> new ShoppingCartLineItem(new Identifier(), 0)).isInstanceOf(IllegalArgumentException.class);
    }
}
