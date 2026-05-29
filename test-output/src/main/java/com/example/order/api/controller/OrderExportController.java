package com.example.order.api.controller;

import com.example.order.application.service.OrderService;
import com.example.order.domain.entity.Order;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 订单表 Export Controller
 *
 * @author codegen
 */
@Tag(name = "Order Export")
@RestController
@RequestMapping("/api/orders/export")
public class OrderExportController {

    private final OrderService orderService;

    public OrderExportController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Operation(summary = "导出订单表")
    @GetMapping
    public void export(HttpServletResponse response) throws IOException {
        List<Order> records = orderService.list();
        response.setContentType("text/csv;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=t_order.csv");
        StringBuilder builder = new StringBuilder();
        builder.append("主键ID,");
        builder.append("订单号,");
        builder.append("用户ID,");
        builder.append("订单金额,");
        builder.append("订单状态,");
        builder.append("创建时间,");
        builder.append("更新时间");
        builder.append("\n");
        for (Order item : records) {
            builder.append(item.getId()).append(",");
            builder.append(item.getOrderno()).append(",");
            builder.append(item.getUserid()).append(",");
            builder.append(item.getAmount()).append(",");
            builder.append(item.getStatus()).append(",");
            builder.append(item.getCreatedat()).append(",");
            builder.append(item.getUpdatedat()).append("");
            builder.append("\n");
        }
        response.getOutputStream().write(builder.toString().getBytes(StandardCharsets.UTF_8));
    }
}
