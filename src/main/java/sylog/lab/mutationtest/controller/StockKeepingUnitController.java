package sylog.lab.mutationtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sylog.lab.mutationtest.representation.product.StockKeepingUnitRepresentation;
import sylog.lab.mutationtest.service.StockKeepingUnitService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sku")
public class StockKeepingUnitController {

    @Autowired
    private StockKeepingUnitService service;

    @RequestMapping(path = "/{SKUUUID}")
    public StockKeepingUnitRepresentation findSKU(@PathVariable(name="SKUUUID") UUID SKUUUID) {
        return service.findSKU(SKUUUID);
    }

    @RequestMapping(path = "/product/{productUUID}")
    public List<StockKeepingUnitRepresentation> findSKUByProduct(@PathVariable(name = "productUUID") UUID productUUID) {
        return service.findSKUByProduct(productUUID);
    }
}