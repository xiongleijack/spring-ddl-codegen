package com.example.spider.controller.management;

import com.github.wz2cool.dynamic.SortDirection;
import com.github.wz2cool.dynamic.model.NormPagingResult;
import com.example.spider.model.dto.BondInfoCsrcFndAnnDetailDTO;
import com.example.spider.model.dto.request.BondInfoCsrcFndAnnQueryDTO;
import com.example.spider.model.dto.response.BondInfoCsrcFndAnnPageDTO;
import com.example.spider.service.BondInfoCsrcFndAnnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * management 中国证券监督管理委员会基金公告-补充后台管理
 *
 * @author xionglei
 */
@Api(tags = "(后台管理)中国证券监督管理委员会基金公告-补充")
@RestController
@RequestMapping("/management/bondInfoCsrcFndAnn")
public class MgtBondInfoCsrcFndAnnController {

    @Resource
    private BondInfoCsrcFndAnnService bondInfoCsrcFndAnnService;

    @ApiOperation("新增")
    @PostMapping
    public void insertBondInfoCsrcFndAnn(
            @ApiParam(value = "用户id") @CookieValue(value = "m_user_id", defaultValue = "1") Long userId,
            @RequestBody BondInfoCsrcFndAnnDetailDTO bondInfoCsrcFndAnnDetailDTO) {
        bondInfoCsrcFndAnnService.insertBondInfoCsrcFndAnn(userId, bondInfoCsrcFndAnnDetailDTO);
    }

    @PutMapping("/deleted")
    public void updateDeletedByIds(
            @ApiParam(value = "用户id") @CookieValue(value = "m_user_id", defaultValue = "1") Long userId,
            @RequestBody Collection<Long> ids,
            @RequestParam @ApiParam(value = "是否有效: 0:有效 1:无效") Integer deleted) {
        bondInfoCsrcFndAnnService.updateDeletedByIds(userId, ids, deleted);
    }

    @PutMapping
    public void updateBondInfoCsrcFndAnn(
            @ApiParam(value = "用户id") @CookieValue(value = "m_user_id", defaultValue = "1") Long userId,
            @RequestBody BondInfoCsrcFndAnnDetailDTO bondInfoCsrcFndAnnDetailDTO) {
        bondInfoCsrcFndAnnService.updateBondInfoCsrcFndAnn(userId, bondInfoCsrcFndAnnDetailDTO);
    }

    @GetMapping
    public BondInfoCsrcFndAnnDetailDTO getBondInfoCsrcFndAnnById(@RequestParam Long id) {
        return bondInfoCsrcFndAnnService.getBondInfoCsrcFndAnnById(id);
    }

    @PostMapping("/page")
    public NormPagingResult<BondInfoCsrcFndAnnPageDTO> pageQuery(
            @RequestBody BondInfoCsrcFndAnnQueryDTO bondInfoCsrcFndAnnQueryDTO,
            @ApiParam(value = "页码") @RequestParam(defaultValue = "1") Integer pageNum,
            @ApiParam(value = "每页条数") @RequestParam(defaultValue = "50") Integer pageSize,
            @ApiParam(value = "排序字段") @RequestParam(defaultValue = "updateTime") String sortProperty,
            @ApiParam(value = "分页方向") @RequestParam(defaultValue = "DESC") SortDirection sortDirection) {
        return bondInfoCsrcFndAnnService.pageQuery(
                bondInfoCsrcFndAnnQueryDTO, pageSize, pageNum, sortProperty, sortDirection);
    }
}
