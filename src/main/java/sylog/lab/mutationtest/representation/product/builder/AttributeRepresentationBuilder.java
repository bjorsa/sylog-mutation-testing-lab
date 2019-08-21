package sylog.lab.mutationtest.representation.product.builder;

import sylog.lab.mutationtest.domain.shopping.product.Attribute;
import sylog.lab.mutationtest.representation.product.AttributeRepresentation;

import java.util.Set;
import java.util.stream.Collectors;

public final class AttributeRepresentationBuilder {

    private AttributeRepresentationBuilder() {
        // prevent instantiation and sub classing
    }

    public static AttributeRepresentation fromAttribute(Attribute attribute) {
        return new AttributeRepresentation(attribute.getName().getName(), attribute.getValue().getValue());
    }

    public static Set<AttributeRepresentation> fromAttributes(Set<Attribute> attributes) {
        return attributes.stream().map(AttributeRepresentationBuilder::fromAttribute).collect(Collectors.toSet());
    }
}
