package com.example.spider.controller.management;

import com.github.wz2cool.dynamic.SortDirection;
import com.github.wz2cool.dynamic.model.NormPagingResult;
import com.innodealing.commons.http.RestResponse;
import com.example.spider.model.dto.OnshoreBondFilterV5DetailDTO;
import com.example.spider.model.dto.request.OnshoreBondFilterV5QueryDTO;
import com.example.spider.model.dto.response.OnshoreBondFilterV5PageDTO;
import com.example.spider.service.OnshoreBondFilterV5Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * management 境内债券筛选V3宽表（旧onshore_bond_filter超集+F9/DeepInfo/list复刻字段），每个bondUniCode一行，软删，update_time为增量游标后台管理
 *
 * @author xionglei
 */
@Api(tags = "(后台管理)境内债券筛选V3宽表（旧onshore_bond_filter超集+F9/DeepInfo/list复刻字段），每个bondUniCode一行，软删，update_time为增量游标")
@RestController
@RequestMapping("/management/onshoreBondFilterV5")
public class MgtOnshoreBondFilterV5Controller {

    @Resource
    private OnshoreBondFilterV5Service onshoreBondFilterV5Service;

    @ApiOperation("新增")
    @PostMapping
    public RestResponse<Void> insertOnshoreBondFilterV5(
            @ApiParam(value = "用户id") @CookieValue(value = "m_user_id", defaultValue = "1") Long userId,
            @RequestBody OnshoreBondFilterV5DetailDTO onshoreBondFilterV5DetailDTO) {
        onshoreBondFilterV5Service.insertOnshoreBondFilterV5(userId, onshoreBondFilterV5DetailDTO);
        return RestResponse.Success(null);
    }

    @ApiOperation("更新删除状态")
    @PutMapping("/deleted")
    public RestResponse<Void> updateDeletedByIds(
            @ApiParam(value = "用户id") @CookieValue(value = "m_user_id", defaultValue = "1") Long userId,
            @RequestBody Collection<Long> ids,
            @RequestParam @ApiParam(value = "是否有效: 0:有效 1:无效") Integer deleted) {
        onshoreBondFilterV5Service.updateDeletedByIds(userId, ids, deleted);
        return RestResponse.Success(null);
    }

    @ApiOperation("更新")
    @PutMapping
    public RestResponse<Void> updateOnshoreBondFilterV5(
            @ApiParam(value = "用户id") @CookieValue(value = "m_user_id", defaultValue = "1") Long userId,
            @RequestBody OnshoreBondFilterV5DetailDTO onshoreBondFilterV5DetailDTO) {
        onshoreBondFilterV5Service.updateOnshoreBondFilterV5(userId, onshoreBondFilterV5DetailDTO);
        return RestResponse.Success(null);
    }

    @ApiOperation("根据ID查询")
    @GetMapping
    public RestResponse<OnshoreBondFilterV5DetailDTO> getOnshoreBondFilterV5ById(@RequestParam Long id) {
        return RestResponse.Success(onshoreBondFilterV5Service.getOnshoreBondFilterV5ById(id));
    }

    @ApiOperation("分页查询")
    @PostMapping("/page")
    public RestResponse<NormPagingResult<OnshoreBondFilterV5PageDTO>> pageQuery(
            @RequestBody OnshoreBondFilterV5QueryDTO onshoreBondFilterV5QueryDTO,
            @ApiParam(value = "页码") @RequestParam(defaultValue = "1") Integer pageNum,
            @ApiParam(value = "每页条数") @RequestParam(defaultValue = "50") Integer pageSize,
            @ApiParam(value = "排序字段") @RequestParam(defaultValue = "updateTime") String sortProperty,
            @ApiParam(value = "分页方向") @RequestParam(defaultValue = "DESC") SortDirection sortDirection) {
        return RestResponse.Success(onshoreBondFilterV5Service.pageQuery(
                onshoreBondFilterV5QueryDTO, pageSize, pageNum, sortProperty, sortDirection));
    }
}
