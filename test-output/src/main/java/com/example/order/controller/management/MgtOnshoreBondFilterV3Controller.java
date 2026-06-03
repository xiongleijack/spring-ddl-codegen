package com.example.order.controller.management;

import com.github.wz2cool.dynamic.SortDirection;
import com.github.wz2cool.dynamic.model.NormPagingResult;
import com.example.order.model.dto.OnshoreBondFilterV3DetailDTO;
import com.example.order.model.dto.request.OnshoreBondFilterV3QueryDTO;
import com.example.order.model.dto.response.OnshoreBondFilterV3PageDTO;
import com.example.order.service.OnshoreBondFilterV3Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * management 后台管理
 *
 * @author xionglei
 */
@Api(tags = "(后台管理)")
@RestController
@RequestMapping("/management/onshoreBondFilterV3")
public class MgtOnshoreBondFilterV3Controller {

    @Resource
    private OnshoreBondFilterV3Service onshoreBondFilterV3Service;

    @ApiOperation("新增")
    @PostMapping
    public void insertOnshoreBondFilterV3(
            @ApiParam(value = "用户id") @CookieValue(value = "m_user_id", defaultValue = "1") Long userId,
            @RequestBody OnshoreBondFilterV3DetailDTO onshoreBondFilterV3DetailDTO) {
        onshoreBondFilterV3Service.insertOnshoreBondFilterV3(userId, onshoreBondFilterV3DetailDTO);
    }

    @PutMapping("/deleted")
    public void updateDeletedByIds(
            @ApiParam(value = "用户id") @CookieValue(value = "m_user_id", defaultValue = "1") Long userId,
            @RequestBody Collection<Long> ids,
            @RequestParam @ApiParam(value = "是否有效: 0:有效 1:无效") Integer deleted) {
        onshoreBondFilterV3Service.updateDeletedByIds(userId, ids, deleted);
    }

    @PutMapping
    public void updateOnshoreBondFilterV3(
            @ApiParam(value = "用户id") @CookieValue(value = "m_user_id", defaultValue = "1") Long userId,
            @RequestBody OnshoreBondFilterV3DetailDTO onshoreBondFilterV3DetailDTO) {
        onshoreBondFilterV3Service.updateOnshoreBondFilterV3(userId, onshoreBondFilterV3DetailDTO);
    }

    @GetMapping
    public OnshoreBondFilterV3DetailDTO getOnshoreBondFilterV3ById(@RequestParam Long id) {
        return onshoreBondFilterV3Service.getOnshoreBondFilterV3ById(id);
    }

    @PostMapping("/page")
    public NormPagingResult<OnshoreBondFilterV3PageDTO> pageQuery(
            @RequestBody OnshoreBondFilterV3QueryDTO onshoreBondFilterV3QueryDTO,
            @ApiParam(value = "页码") @RequestParam(defaultValue = "1") Integer pageNum,
            @ApiParam(value = "每页条数") @RequestParam(defaultValue = "50") Integer pageSize,
            @ApiParam(value = "排序字段") @RequestParam(defaultValue = "updateTime") String sortProperty,
            @ApiParam(value = "分页方向") @RequestParam(defaultValue = "DESC") SortDirection sortDirection) {
        return onshoreBondFilterV3Service.pageQuery(
                onshoreBondFilterV3QueryDTO, pageSize, pageNum, sortProperty, sortDirection);
    }
}
