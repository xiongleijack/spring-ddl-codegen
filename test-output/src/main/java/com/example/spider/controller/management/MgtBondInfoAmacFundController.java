package com.example.spider.controller.management;

import com.github.wz2cool.dynamic.SortDirection;
import com.github.wz2cool.dynamic.model.NormPagingResult;
import com.example.spider.model.dto.BondInfoAmacFundDetailDTO;
import com.example.spider.model.dto.request.BondInfoAmacFundQueryDTO;
import com.example.spider.model.dto.response.BondInfoAmacFundPageDTO;
import com.example.spider.service.BondInfoAmacFundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * management 中国证券投资基金业协会基金后台管理
 *
 * @author xionglei
 */
@Api(tags = "(后台管理)中国证券投资基金业协会基金")
@RestController
@RequestMapping("/management/bondInfoAmacFund")
public class MgtBondInfoAmacFundController {

    @Resource
    private BondInfoAmacFundService bondInfoAmacFundService;

    @ApiOperation("新增")
    @PostMapping
    public void insertBondInfoAmacFund(
            @ApiParam(value = "用户id") @CookieValue(value = "m_user_id", defaultValue = "1") Long userId,
            @RequestBody BondInfoAmacFundDetailDTO bondInfoAmacFundDetailDTO) {
        bondInfoAmacFundService.insertBondInfoAmacFund(userId, bondInfoAmacFundDetailDTO);
    }

    @PutMapping("/deleted")
    public void updateDeletedByIds(
            @ApiParam(value = "用户id") @CookieValue(value = "m_user_id", defaultValue = "1") Long userId,
            @RequestBody Collection<Long> ids,
            @RequestParam @ApiParam(value = "是否有效: 0:有效 1:无效") Integer deleted) {
        bondInfoAmacFundService.updateDeletedByIds(userId, ids, deleted);
    }

    @PutMapping
    public void updateBondInfoAmacFund(
            @ApiParam(value = "用户id") @CookieValue(value = "m_user_id", defaultValue = "1") Long userId,
            @RequestBody BondInfoAmacFundDetailDTO bondInfoAmacFundDetailDTO) {
        bondInfoAmacFundService.updateBondInfoAmacFund(userId, bondInfoAmacFundDetailDTO);
    }

    @GetMapping
    public BondInfoAmacFundDetailDTO getBondInfoAmacFundById(@RequestParam Long id) {
        return bondInfoAmacFundService.getBondInfoAmacFundById(id);
    }

    @PostMapping("/page")
    public NormPagingResult<BondInfoAmacFundPageDTO> pageQuery(
            @RequestBody BondInfoAmacFundQueryDTO bondInfoAmacFundQueryDTO,
            @ApiParam(value = "页码") @RequestParam(defaultValue = "1") Integer pageNum,
            @ApiParam(value = "每页条数") @RequestParam(defaultValue = "50") Integer pageSize,
            @ApiParam(value = "排序字段") @RequestParam(defaultValue = "updateTime") String sortProperty,
            @ApiParam(value = "分页方向") @RequestParam(defaultValue = "DESC") SortDirection sortDirection) {
        return bondInfoAmacFundService.pageQuery(
                bondInfoAmacFundQueryDTO, pageSize, pageNum, sortProperty, sortDirection);
    }
}
