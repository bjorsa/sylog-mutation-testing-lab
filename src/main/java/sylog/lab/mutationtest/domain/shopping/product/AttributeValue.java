package sylog.lab.mutationtest.domain.shopping.product;

import sylog.lab.mutationtest.domain.ValueObject;
import sylog.lab.mutationtest.domain.util.Validate;

public final class AttributeValue extends ValueObject {
    public static final int MAX_VALUE_LENGTH = 200;

    private final String value;

    public AttributeValue(String value) {
        Validate.notNull(value);
        Validate.notEmpty(value);
        Validate.lessThanOrEqual(value.length(), MAX_VALUE_LENGTH, () -> new IllegalArgumentException("value can be no longer than " + MAX_VALUE_LENGTH + " characters"));

        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
