package com.example.order.api.controller;

import com.example.order.application.service.OrderService;
import com.example.order.domain.entity.Order;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 订单表 Import Controller
 *
 * @author codegen
 */
@Tag(name = "Order Import")
@RestController
@RequestMapping("/api/orders/import")
public class OrderImportController {

    private final OrderService orderService;

    public OrderImportController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Operation(summary = "导入订单表")
    @PostMapping
    public boolean importData(@RequestParam("file") MultipartFile file) {
        // TODO: parse file and convert to entities
        List<Order> records = List.of();
        return orderService.saveBatch(records);
    }
}
