package sylog.lab.mutationtest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sylog.lab.mutationtest.service.ProductService;
import sylog.lab.mutationtest.representation.product.AttributeRepresentation;
import sylog.lab.mutationtest.representation.product.ProductRepresentation;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping(path="/{productUUID}")
    public ProductRepresentation findProduct(@PathVariable(name="productUUID") UUID productUUID) {
        return service.findProduct(productUUID);
    }

    @RequestMapping(path="/category/{categoryUUID}")
    public List<ProductRepresentation> findProductsByCategory(@PathVariable(name = "categoryUUID") UUID categoryUUID) {
        return service.findProductsByCategory(categoryUUID);
    }

    @RequestMapping
    public List<ProductRepresentation> listProducts(
            @RequestParam(name = "attribute", required = false) String attributeData,
            @RequestParam(name = "orderByAttribute", required = false) String orderByAttribute,
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "pageSize", required = false) Integer pageSize) throws IOException {

        AttributeRepresentation attribute = null;
        if (attributeData != null) {
            attribute = new ObjectMapper().readValue(attributeData, AttributeRepresentation.class);
        }
        return service.listProducts(attribute, orderByAttribute, page, pageSize);
    }
}
