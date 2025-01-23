package com.folkatechtest.folkatechtest.helpers;

import com.folkatechtest.folkatechtest.models.Product;
import com.folkatechtest.folkatechtest.models.dtos.ProductDto;

public class ProductMapper {
    public static ProductDto toProductDto(Product product) {
        var productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setSupplierName(product.getSupplierName());
        productDto.setStock(product.getStock());
        productDto.setPrice(product.getPrice());
        productDto.setOrigin(product.getOrigin());
        productDto.setSpecies(product.getSpecies());
        productDto.setRoastLevel(product.getRoastLevel());
        productDto.setTasted(product.getTasted());
        productDto.setProcessing(product.getProcessing());
        productDto.setRating(product.getOrders().stream().mapToDouble(e -> e.getRating()).average().orElse(5));
        return productDto;
    }
}
