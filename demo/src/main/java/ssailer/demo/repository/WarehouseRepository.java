package ssailer.demo.repository;

import ssailer.demo.model.ProductData;
import org.springframework.data.mongodb.repository.MongoRepository;
import ssailer.demo.model.WarehouseData;

import java.util.List;

public interface WarehouseRepository extends MongoRepository<WarehouseData, String> {}