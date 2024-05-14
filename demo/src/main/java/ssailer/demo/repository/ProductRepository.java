package ssailer.demo.repository;

import ssailer.demo.model.ProductData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductData, String> {
    Iterable<ProductData> findByWarehouseID(String warehouseID);
    Iterable<ProductData> findByWarehouseIDAndProductName(String warehouseID, String productName);
    Iterable<ProductData> findByProductQuantityLessThan(double quantity);
    Iterable<ProductData> findByWarehouseIDAndProductQuantityLessThan(String warehouseID, double quantity);
    Iterable<ProductData> findByProductCategoryIn(String... categories);
}
