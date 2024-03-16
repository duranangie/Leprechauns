package com.leprechauns.main.Service;

import com.leprechauns.main.Entity.Order;
import com.leprechauns.main.Entity.Product;
import com.leprechauns.main.Entity.DTO.OfficeDTO;
import com.leprechauns.main.Entity.DTO.OrderDetailsDTO;
import com.leprechauns.main.Entity.oderdetails.OrderDetails;
import com.leprechauns.main.Repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderDetailsService {

    @Autowired
    public OrderDetailsRepository orderDetailRepository;
    

    public List<OrderDetailsDTO> getAllOrderDetails() {
        return orderDetailRepository.findAll().stream()
                .map(OrderDetails::toDTO)
                .toList();
    }

    // private OrderDetailsDTO convertToObject(Object[] objects, Map<String, Integer> propertyIndices) {
    //     if (objects == null || objects.length < propertyIndices.size()) {
    //         throw new IllegalArgumentException("The array of objects is null or doesn't have enough elements");
    //     }
    //     OrderDetailsDTO dto = new OrderDetailsDTO();
    //     propertyIndices.forEach((propertyName, index) -> {
    //         switch (propertyName) {
    //             case "order":
    //                 dto.setOrder((Order) objects[index]);
    //                 break;
    //             case "product":
    //                 dto.setProduct((Product) objects[index]);
    //                 break;
    //             case "amount":
    //                 dto.setAmount((Integer) objects[index]);
    //                 break;
    //             case "unitPrice":
    //                 dto.setUnitPrice((double) objects[index]);
    //                 break;
    //             case "numberLine":
    //                 dto.setNumberLine((Integer) objects[index]);
    //                 break;
    //             }
    //         }
    //     );
    //     return dto;
    // }

    // public List<OrderDetailsDTO> getOrderDetailDTOListFromObjectArray(List<Object[]> objectList, Map<String, Integer> propertyIndices) {
    //     return objectList.stream()
    //             .map(objects -> convertToObject(objects, propertyIndices))
    //             .collect(Collectors.toList());
    // }

    // public List<OrderDetailsDTO> findNumberProduct(){
    //     List<Object[]> objectList = orderDetailRepository.findNumberProduct();
    //     Map<String, Integer> propertyIndices = Map.of("order", 0, "number_different_products", 1);
    //     return getOrderDetailDTOListFromObjectArray(objectList, propertyIndices);
    // }
}