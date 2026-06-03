package com.example.order.controller.management;

import com.github.wz2cool.dynamic.SortDirection;
import com.github.wz2cool.dynamic.model.NormPagingResult;
import com.example.order.model.dto.OrderDetailDTO;
import com.example.order.model.dto.request.OrderQueryDTO;
import com.example.order.model.dto.response.OrderPageDTO;
import com.example.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * management 订单表后台管理
 *
 * @author codegen
 */
@Api(tags = "(后台管理)订单表")
@RestController
@RequestMapping("/management/order")
public class MgtOrderController {

    @Resource
    private OrderService orderService;

    @ApiOperation("新增")
    @PostMapping
    public void insertOrder(
            @ApiParam(value = "用户id") @CookieValue(value = "m_user_id", defaultValue = "1") Long userId,
            @RequestBody OrderDetailDTO orderDetailDTO) {
        orderService.insertOrder(userId, orderDetailDTO);
    }

    @PutMapping("/deleted")
    public void updateDeletedByIds(
            @ApiParam(value = "用户id") @CookieValue(value = "m_user_id", defaultValue = "1") Long userId,
            @RequestBody Collection<Long> ids,
            @RequestParam @ApiParam(value = "是否有效: 0:有效 1:无效") Integer deleted) {
        orderService.updateDeletedByIds(userId, ids, deleted);
    }

    @PutMapping
    public void updateOrder(
            @ApiParam(value = "用户id") @CookieValue(value = "m_user_id", defaultValue = "1") Long userId,
            @RequestBody OrderDetailDTO orderDetailDTO) {
        orderService.updateOrder(userId, orderDetailDTO);
    }

    @GetMapping
    public OrderDetailDTO getOrderById(@RequestParam Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/page")
    public NormPagingResult<OrderPageDTO> pageQuery(
            @RequestBody OrderQueryDTO orderQueryDTO,
            @ApiParam(value = "页码") @RequestParam(defaultValue = "1") Integer pageNum,
            @ApiParam(value = "每页条数") @RequestParam(defaultValue = "50") Integer pageSize,
            @ApiParam(value = "排序字段") @RequestParam(defaultValue = "updateTime") String sortProperty,
            @ApiParam(value = "分页方向") @RequestParam(defaultValue = "DESC") SortDirection sortDirection) {
        return orderService.pageQuery(
                orderQueryDTO, pageSize, pageNum, sortProperty, sortDirection);
    }
}
