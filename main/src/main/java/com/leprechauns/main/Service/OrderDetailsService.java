package com.leprechauns.main.Service;

import com.leprechauns.main.Entity.DTO.OrderDetailsDTO;
import com.leprechauns.main.Entity.oderdetails.OrderDetails;
import com.leprechauns.main.Repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderDetailsService {

    @Autowired
    public OrderDetailsRepository orderDetailRepository;

    // Queries

    public List<OrderDetailsDTO> getAllOrderDetails() {
        return orderDetailRepository.findAll().stream()
                .map(OrderDetails::toDTO)
                .toList();
    }

    public List<Map<String, Object>> findNumberProduct() {
        return orderDetailRepository.findNumberProduct();
    }

    public List<Map<String, Object>> findTotalProductEachProduct() {
        return orderDetailRepository.findTotalProductEachProduct();
    }

    public List<Map<String, Object>> find20ProductTotalUnits() {
        List<Map<String, Object>> productList = orderDetailRepository.find20ProductTotalUnits();

        productList = productList.stream()
                .sorted(Comparator.comparing(product -> (String) product.get("productId")))
                .collect(Collectors.toList());
        return productList;
    }

    public List<Map<String, Object>> findVATAndInvoice() {
        return orderDetailRepository.findVATAndInvoice();
    }

    public List<Map<String, Object>> findVATAndInvoiceGroupByProductCode() {
        return orderDetailRepository.findVATAndInvoiceGroupByProductCode();
    }

    public List<Map<String, Object>> findVATAndInvoiceGroupByProductCodeAndOr() {
        return orderDetailRepository.findVATAndInvoiceGroupByProductCodeAndOr();
    }

    public List<Map<String, Object>> findInvoiceMore3000() {
        return orderDetailRepository.findInvoiceMore3000();
    }
}