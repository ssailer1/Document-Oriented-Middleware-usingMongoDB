package ssailer.demo.model;

import ssailer.demo.repository.ProductRepository;
import ssailer.demo.repository.WarehouseRepository;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;

@Service
public class WarehouseDataService {
    private final RestTemplate restTemplate;
    private final WarehouseRepository warehouseRepository;
    private final ProductRepository productRepository;

    public WarehouseDataService(RestTemplate restTemplate, WarehouseRepository warehouseRepository, ProductRepository productRepository) {
        this.restTemplate = restTemplate;
        this.warehouseRepository = warehouseRepository;
        this.productRepository = productRepository;
    }

    public void fetchDataAndStoreInMongoDB() {
        // Daten von der REST-Schnittstelle abrufen
        // Annahme: Die REST-Schnittstelle gibt WarehouseData-Objekte zurück
        ResponseEntity<WarehouseData[]> response = restTemplate.exchange(
                "http://localhost:8080/warehouse/all",
                HttpMethod.GET,
                null,
                WarehouseData[].class
        );

        // Daten in MongoDB speichern
        Arrays.asList(response.getBody()).forEach(warehouseData -> {
            this.warehouseRepository.save(warehouseData);
            warehouseData.getProducts().forEach(product -> productRepository.save(product));
        });
    }
}

