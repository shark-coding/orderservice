package com.project.oderservice.service;

import com.project.oderservice.domain.StoreProduct;
import com.project.oderservice.repository.StoreProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    private StoreProductRepository storeProductRepository;

    public StoreService(StoreProductRepository storeProductRepository) {
        this.storeProductRepository = storeProductRepository;
    }

    public StoreProduct getStoreProduct(int storeId, int productId) {
        Optional<StoreProduct> storeProductOptional = storeProductRepository.findByStoreIdAndProductId(storeId, productId);
        if (storeProductOptional.isEmpty()) {
            throw new RuntimeException("존재하지 않습니다.");
        }

        return storeProductOptional.get();
    }

    // List 형태의 storeProduct를 저장하는 메서드
    public void saveAll(List<StoreProduct> storeProductList) {
        storeProductRepository.saveAll(storeProductList);;
    }
}
