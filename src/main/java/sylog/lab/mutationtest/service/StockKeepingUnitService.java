package sylog.lab.mutationtest.service;

import org.springframework.stereotype.Service;
import sylog.lab.mutationtest.domain.Identifier;
import sylog.lab.mutationtest.repository.StockKeepingUnitRepository;
import sylog.lab.mutationtest.representation.product.StockKeepingUnitRepresentation;
import sylog.lab.mutationtest.representation.product.builder.StockKeepingUnitRepresentationBuilder;

import java.util.List;
import java.util.UUID;

@Service
public class StockKeepingUnitService {

    public StockKeepingUnitRepresentation findSKU(UUID SKUUUID) {
        return StockKeepingUnitRepresentationBuilder.fromSKU(StockKeepingUnitRepository.find(new Identifier(SKUUUID)));
    }

    public List<StockKeepingUnitRepresentation> findSKUByProduct(UUID productUUID) {
        return StockKeepingUnitRepresentationBuilder.fromSKUs(StockKeepingUnitRepository.findByProduct(new Identifier(productUUID)));
    }
}
