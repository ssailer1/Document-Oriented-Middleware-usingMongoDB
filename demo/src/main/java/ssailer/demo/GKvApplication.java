package ssailer.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import ssailer.demo.model.*;
import ssailer.demo.repository.*;

import java.util.Arrays;

@SpringBootApplication
@RestController
@RequestMapping("/warehouse")
public class GKvApplication implements CommandLineRunner {

    @Autowired
    private WarehouseRepository warehouseDataRepository;

    public static void main(String[] args) {
        SpringApplication.run(GKvApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initializeDatabase();
    }

    private void initializeDatabase() {
        WarehouseData warehouse1 = new WarehouseData();
        warehouse1.setWarehouseName("Warehouse A");
        warehouse1.setWarehouseID("1");

        WarehouseData warehouse2 = new WarehouseData();
        warehouse2.setWarehouseName("Warehouse B");
        warehouse2.setWarehouseID("2");

        for (int i = 0; i < 2; i++) {
            warehouse1.addProduct(new ProductData("1","00-443175","Bio Orangensaft Sonne","Getraenk", 2500));
            warehouse2.addProduct(new ProductData("2","00-443176","Bio Orangensaft Sonne","Getraenk", 2500));
        }
        warehouse1.addProduct(new ProductData("1","00-443176","Bio Orangensaft Sonne2","Getraenk", 2500));

        warehouseDataRepository.saveAll(Arrays.asList(warehouse1, warehouse2));
    }

    @GetMapping("/all")
    public Iterable<WarehouseData> getAllWarehouses() {
        return warehouseDataRepository.findAll();
    }

    @GetMapping("/{id}")
    public WarehouseData getWarehouseById(@PathVariable String id) {
        return warehouseDataRepository.findById(id).orElse(null);
    }

    @GetMapping("/{id}/products")
    public Iterable<ProductData> getProductsByWarehouseId(@PathVariable String id) {
        WarehouseData warehouse = warehouseDataRepository.findById(id).orElse(null);
        if (warehouse != null) {
            return warehouse.getProducts();
        }
        return null;
    }
}