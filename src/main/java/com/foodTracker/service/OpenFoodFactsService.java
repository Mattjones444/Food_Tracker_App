package com.foodTracker.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenFoodFactsService {
    public Map<String, Object> getProductInfo(String barcode) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://world.openfoodfacts.org/api/v0/product/" + barcode + ".json";
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        
        

        Map<String, Object> productData = new HashMap<>();
        if (response != null && response.containsKey("product")) {
            Map<String, Object> product = (Map<String, Object>) response.get("product");
            productData.put("product_name", (String) product.getOrDefault("product_name", "Unknown"));
            productData.put("quantity", (String) product.getOrDefault("quantity", "N/A"));
        }
        //System.out.println("OpenFoodFacts raw response: " + response);
        return productData;
    }

    
}