package com.leprechauns.main.Controller;

import java.util.List;
import java.util.Map;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leprechauns.main.Entity.DTO.OrderDetailsDTO;
import com.leprechauns.main.Service.OrderDetailsService;

@RestController
@RequestMapping("/orderdetails")
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
public class OrderDetailsController {

    public final OrderDetailsService orderDetailsService;

    @Autowired
    public OrderDetailsController(OrderDetailsService orderDetailService) {
        this.orderDetailsService = orderDetailService;
    }
    
    @GetMapping
    public List<OrderDetailsDTO> getAllOrderDetails(){
        return orderDetailsService.getAllOrderDetails();
    }
    
    @GetMapping("/different-products")
    public List<Map<String, Object>> getNumberProduct() {
        return orderDetailsService.findNumberProduct();
    }

    @GetMapping("/total-products-each-order")
    public List<Map<String, Object>> getTotalProductEachProduct() {
        return orderDetailsService.findTotalProductEachProduct();
    }

    @GetMapping("/20-products-total-unit/{limit}")
    public List<Map<String, Object>> get20ProductTotalUnits(@PathVariable int limit) {
        return orderDetailsService.find20ProductTotalUnits(limit);
    }

    @GetMapping("/tax-vat-total-charged")
    public List<Map<String, Object>> getVATAndInvoice() {
        return orderDetailsService.findVATAndInvoice();
    }

    @GetMapping("/tax-vat-total-charged-productcode")
    public List<Map<String, Object>> getVATAndInvoiceGroupByProductCode() {
        return orderDetailsService.findVATAndInvoiceGroupByProductCode();
    }

    @GetMapping("/tax-vat-total-charged-productcode-or")
    public List<Map<String, Object>> getVATAndInvoiceGroupByProductCodeAndOr() {
        return orderDetailsService.findVATAndInvoiceGroupByProductCodeAndOr();
    }

    @GetMapping("/product-more-3000/{max}")
    public List<Map<String, Object>> getInvoiceMore3000(@PathVariable int max) {
        return orderDetailsService.findInvoiceMore3000(max);
    }
}
