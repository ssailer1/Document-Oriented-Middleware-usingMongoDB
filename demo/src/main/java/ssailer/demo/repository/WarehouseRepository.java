package ssailer.demo.repository;

import ssailer.demo.model.ProductData;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface WarehouseRepository extends MongoRepository<ProductData, String> {

    public ProductData findByProductID(String productID);
    public List<ProductData> findByWarehouseID(String warehouseID);

}