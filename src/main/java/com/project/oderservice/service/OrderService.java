package com.project.oderservice.service;

import com.project.oderservice.domain.CreateOrder;
import com.project.oderservice.domain.Order;
import com.project.oderservice.domain.StoreProduct;
import com.project.oderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final StoreService storeService;

    public OrderService(OrderRepository orderRepository,
                        StoreService storeService) {
        this.orderRepository = orderRepository;
        this.storeService = storeService;
    }

    public void newOrder(CreateOrder createOrder) {
        List<StoreProduct> storeProducts = new ArrayList<>();

        // 재고 조회해서 구매하는 갯수와 비교
        for (Map.Entry<Integer, Integer> entry : createOrder.getQuantityByProduct().entrySet()) {
            Integer productId = entry.getKey();
            Integer buyQuantity = entry.getValue();

            StoreProduct storeProduct = storeService.getStoreProduct(
                    createOrder.getStoreId(),
                    productId);

            // 비교
            int stockQuantity = storeProduct.getStockQuantity();

            if (buyQuantity > stockQuantity) {
                throw new RuntimeException("재고가 없습니다.");
            }
            // 재고 마이너스 메서드 호출
            storeProduct.adjustStockQuantity(buyQuantity);
            storeProducts.add(storeProduct);

        }
        Order entity = Order.newOrder(createOrder);
        orderRepository.save(entity);

        // 저장
        storeService.saveAll(storeProducts);
    }
}
