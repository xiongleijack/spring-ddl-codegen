package com.example.order.api.controller;

import com.example.order.api.dto.OrderDetailDTO;
import com.example.order.api.dto.OrderPageDTO;
import com.example.order.api.dto.OrderQueryDTO;
import com.example.order.application.service.OrderService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 订单表表控制器
 *
 * @author codegen
 */
@Tag(name = "订单表")
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @Operation(summary = "分页查询")
    @PostMapping("/page")
    public Page<OrderPageDTO> pageQuery(
            @RequestBody OrderQueryDTO queryDTO,
            @Parameter(description = "页码") @RequestParam(defaultValue = "1") Integer pageNum,
            @Parameter(description = "每页条数") @RequestParam(defaultValue = "10") Integer pageSize) {
        return orderService.pageQuery(queryDTO, pageNum, pageSize);
    }

    @Operation(summary = "根据主键查询详情")
    @GetMapping("/{id}")
    public OrderDetailDTO getDetail(@PathVariable Long id) {
        return orderService.getDetail(id);
    }

    @Operation(summary = "新增")
    @PostMapping
    public void create(@RequestBody OrderDetailDTO detailDTO) {
        orderService.create(detailDTO);
    }

    @Operation(summary = "更新")
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody OrderDetailDTO detailDTO) {
        orderService.update(id, detailDTO);
    }

    @Operation(summary = "删除")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderService.delete(id);
    }
}
