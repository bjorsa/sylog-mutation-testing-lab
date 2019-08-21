package sylog.lab.mutationtest.service.util;

import org.junit.Test;
import sylog.lab.mutationtest.domain.Entity;
import sylog.lab.mutationtest.domain.Identifier;
import sylog.lab.mutationtest.domain.shopping.product.Product;
import sylog.lab.mutationtest.repository.Products;
import sylog.lab.mutationtest.representation.product.ProductRepresentation;
import sylog.lab.mutationtest.service.ProductService;
import sylog.lab.mutationtest.repository.ProductRepository;
import sylog.lab.mutationtest.representation.EntityRepresentation;
import sylog.lab.mutationtest.representation.product.AttributeRepresentation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ProductServiceTest {

    @Test
    public void shouldListAllTheProductsWhenCalledWithoutArguments() {
        List<ProductRepresentation> products = new ProductService().listProducts(null, null, null, null);
        List<TestEntity> result = products.stream().map(EntityRepresentation::getId).map(TestEntity::new).collect(Collectors.toList());
        List<TestEntity> expected = ProductRepository.products().stream().map(Product::getIdentifier).map(TestEntity::new).collect(Collectors.toList());
        assertThat(result).containsExactlyInAnyOrder(expected.toArray(new TestEntity[]{}));
    }

    @Test
    public void shouldListOnlyTheProductsWithTheSpecifiedAttribute() {
        List<ProductRepresentation> products = new ProductService().listProducts(new AttributeRepresentation("color", "Black"), null, null, null);
        List<TestEntity> result = products.stream().map(EntityRepresentation::getId).map(TestEntity::new).collect(Collectors.toList());
        List<TestEntity> expected = Stream.of(Products.T_SHIRT, Products.ROLLERBLADES).map(Product::getIdentifier).map(TestEntity::new).collect(Collectors.toList());
        assertThat(result).containsExactlyInAnyOrder(expected.toArray(new TestEntity[]{}));
    }

    @Test
    public void shouldOrderProductsAccordingToTheSpecifiedAttribute() {
        List<ProductRepresentation> products = new ProductService().listProducts(new AttributeRepresentation("size", "S"), "color", null, null);
        List<TestEntity> result = products.stream().map(EntityRepresentation::getId).map(TestEntity::new).collect(Collectors.toList());
        List<TestEntity> expected = Stream.of(Products.T_SHIRT, Products.LEATHER_PANTS).map(Product::getIdentifier).map(TestEntity::new).collect(Collectors.toList());
        assertThat(result).containsExactly(expected.toArray(new TestEntity[]{}));
    }

    private static class TestEntity extends Entity {

        protected TestEntity(Identifier identifier) {
            super(identifier);
        }
    }
}
