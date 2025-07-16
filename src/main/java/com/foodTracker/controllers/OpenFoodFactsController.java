package com.foodTracker.controllers;

import com.foodTracker.service.OpenFoodFactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class OpenFoodFactsController {

    @Autowired
    private OpenFoodFactsService productService;

    @GetMapping("/{barcode}")
    public Map<String, String> getProductByBarcode(@PathVariable String barcode) {
        Map<String, Object> productInfo = productService.getProductInfo(barcode);

        String productName = productInfo.getOrDefault("product_name", "Unknown").toString();
        String quantity = productInfo.getOrDefault("quantity", "N/A").toString();

        return Map.of(
            "name", productName,
            "quantity", quantity
        );
    }
}

