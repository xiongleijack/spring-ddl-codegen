package com.example.order.model.entity.bondbasic;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 表实体对象
 *
 * @author xionglei
 */
@Table(name="onshore_bond_filter_v3")
public class OnshoreBondFilterV3DO {

    /**
     * 债券统一编码
     */
    @Column
    private Long bondUniCode;

    /**
     * 债券ID。来源 http://172.16.100.55:3000/search?query=setBondId%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Long bondId;

    /**
     * 债券代码。来源 http://172.16.100.55:3000/search?query=setBondCode%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private String bondCode;

    /**
     * 债券简称。来源 http://172.16.100.55:3000/search?query=setBondShortName%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private String bondShortName;

    /**
     * YY主体评级V2（字符串，映射值见 com_yy_rating_v2_mapping）。来源 http://172.16.100.55:3000/search?query=setComYyRatingV2%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private String comYyRatingV2;

    /**
     * 债券隐含评级 取值：AAA+;AAA;AAA-;AA+;AA;AA(2);AA-（数值映射见 bond_implied_rating_mapping）。来源 http://172.16.100.55:3000/search?query=setBondImpliedRating%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private String bondImpliedRating;

    /**
     * 债券外部评级筛选 取值：AAA;AA+;AA;AA-;A+;--（数值映射见 bond_ext_rating_filter_mapping）。来源 http://172.16.100.55:3000/search?query=setBondExtRating%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private String bondExtRating;

    /**
     * 主体外部评级筛选 取值：AAA;AA+;AA;AA-;A+;--（数值映射见 com_ext_rating_filter_mapping）。来源 http://172.16.100.55:3000/search?query=setComExtRating%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private String comExtRating;

    /**
     * 主体简称（发行人简称）。来源 http://172.16.100.55:3000/search?query=setComShortName%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private String comShortName;

    /**
     * 主体全称（发行人全称）。来源 http://172.16.100.55:3000/search?query=setComFullName%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private String comFullName;

    /**
     * 剩余期限（字符串，天数见 remaining_tenor_day）。来源 http://172.16.100.55:3000/search?query=setRemainingTenor%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private String remainingTenor;

    /**
     * 城投二级行业名称。来源 http://172.16.100.55:3000/search?query=setUdicInduLevel2Name%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private String udicInduLevel2Name;

    /**
     * 债券期限（字符串，天数见 bond_tenor_day）。来源 http://172.16.100.55:3000/search?query=setBondTenor%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private String bondTenor;

    @Column
    private String chinaBondCreditRating;

    @Column
    private String chinaComCreditRating;

    /**
     * 债券承销商（发行机构）主体全称。来源 http://172.16.100.55:3000/search?query=setIssueAgencyComFullName%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private String issueAgencyComFullName;

    /**
     * 流动性大档评分描述（字符串，数值见 large_gear_score）。来源 http://172.16.100.55:3000/search?query=setLargeGearScoreDesc%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private String largeGearScoreDesc;

    /**
     * 流动性小档评分描述（字符串，数值见 small_gear_score）。来源 http://172.16.100.55:3000/search?query=setSmallGearScoreDesc%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private String smallGearScoreDesc;

    /**
     * 浮息基准（浮动利率基准）。来源 http://172.16.100.55:3000/search?query=setBaseRatePar%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private String baseRatePar;

    /**
     * 债券信用级别（取自 rating 服务）。来源 http://172.16.100.55:3000/search?query=setBondCredLevel%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private String bondCredLevel;

    /**
     * 发行人（主体）信用级别（取自 rating 服务）。来源 http://172.16.100.55:3000/search?query=setComCredLevel%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private String comCredLevel;

    /**
     * 最新行权日（字符串）。解析逻辑详见 http://172.16.100.55:3000/search?query=getExerciseDateByCalculateDate&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private String latestExerciseDate;

    /**
     * 上市日。来源 http://172.16.100.55:3000/search?query=setListDate&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private LocalDate listDate;

    /**
     * 到期日（日历）：优先取 latest_exercise_date，无行权日时取 maturity_date。来源 http://172.16.100.55:3000/search?query=setMaturityDateCalendar%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private LocalDate maturityDateCalendar;

    /**
     * 发行起始日。来源 http://172.16.100.55:3000/search?query=setIssueStartDate%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private LocalDate issueStartDate;

    /**
     * 发行结束日。来源 http://172.16.100.55:3000/search?query=setIssueEndDate%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private LocalDate issueEndDate;

    /**
     * 到期日（源:t_bond_basic_info#actu_end_date）。来源 http://172.16.100.55:3000/search?query=setMaturityDate%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private LocalDate maturityDate;

    /**
     * 计算用最新行权日。解析逻辑详见 http://172.16.100.55:3000/search?query=parseCalcLatestExerciseDate&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private LocalDate calcLatestExerciseDate;

    /**
     * 换手率。来源 http://172.16.100.55:3000/search?query=setTurnoverRate%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private BigDecimal turnoverRate;

    /**
     * CFETS(银行间)成交量(亿)。来源 http://172.16.100.55:3000/search?query=setInterbankTradeAmount%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private BigDecimal interbankTradeAmount;

    /**
     * 交易所成交量(万)。来源 http://172.16.100.55:3000/search?query=setExchangeTradeAmount%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private BigDecimal exchangeTradeAmount;

    /**
     * 成交偏离中值(BP)：成交收益率减中债中位数。来源 http://172.16.100.55:3000/search?query=setTradeYieldSubCbMedian%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private BigDecimal tradeYieldSubCbMedian;

    /**
     * 双边利差中值(BP)：bid收益率减ofr。来源 http://172.16.100.55:3000/search?query=setBidYieldSubOfrMedian%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private BigDecimal bidYieldSubOfrMedian;

    /**
     * bid中债偏离中值(BP)：bid收益率减中债。来源 http://172.16.100.55:3000/search?query=setBidYieldSubCbMedian%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private BigDecimal bidYieldSubCbMedian;

    /**
     * ofr偏离中值(BP)：中债收益率减ofr。来源 http://172.16.100.55:3000/search?query=setCbYieldSubOfrMedian%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private BigDecimal cbYieldSubOfrMedian;

    /**
     * 债券余额(单位:亿)。来源 http://172.16.100.55:3000/search?query=setBondBalance&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private BigDecimal bondBalance;

    /**
     * 实际发行金额(默认:亿)。来源 http://172.16.100.55:3000/search?query=setActualIssueAmount&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private BigDecimal actualIssueAmount;

    /**
     * 发行价格(单位:元)。来源 http://172.16.100.55:3000/search?query=setIssuePrice%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private BigDecimal issuePrice;

    /**
     * 招标区间下限(源:t_bond_primary_info#did_interval_low)。来源 http://172.16.100.55:3000/search?query=setDidIntervalLow%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private BigDecimal didIntervalLow;

    /**
     * 招标区间上限(源:t_bond_primary_info#did_interval_sup)。来源 http://172.16.100.55:3000/search?query=setDidIntervalSup%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private BigDecimal didIntervalSup;

    /**
     * 最新票面利率。来源 http://172.16.100.55:3000/search?query=setLatestCouponRate%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private BigDecimal latestCouponRate;

    /**
     * 最新票面值。来源 http://172.16.100.55:3000/search?query=setLatestParValue%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private BigDecimal latestParValue;

    /**
     * 流动性评分值 S+:100 S:95 S-:90 A+:85 A:80 A-:70 B+:60 B:55 B-:50 C+:35 C:30 C-:25 D+:10 D:5 D-:3 E:0（是否展示见 ls_score_show_status）。来源 http://172.16.100.55:3000/search?query=setLsScore%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private BigDecimal lsScore;

    /**
     * 质押率(转股比例)。来源 http://172.16.100.55:3000/search?query=setConvRatio&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private BigDecimal convRatio;

    /**
     * 一级行业编码。来源 http://172.16.100.55:3000/search?query=setInduLevel1Code&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Long induLevel1Code;

    /**
     * 二级行业编码。来源 http://172.16.100.55:3000/search?query=setInduLevel2Code&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Long induLevel2Code;

    /**
     * 省份编码。来源 http://172.16.100.55:3000/search?query=setProvinceUniCode&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Long provinceUniCode;

    /**
     * 地级市编码。来源 http://172.16.100.55:3000/search?query=setCityUniCode&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Long cityUniCode;

    /**
     * 城投(实际控制人)区域编码。来源 http://172.16.100.55:3000/search?query=setUdicAreaUniCode%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Long udicAreaUniCode;

    /**
     * 区域编码：udicAreaUniCode!=0取之；为0但cityUniCode!=0取cityUniCode；均为0取provinceUniCode。逻辑详见 http://172.16.100.55:3000/search?query=getAreaUniCode%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Long areaUniCode;

    /**
     * 由 area_uni_code 反查关联的省编码。来源 http://172.16.100.55:3000/search?query=setAreaProvinceUniCode%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Long areaProvinceUniCode;

    /**
     * 由 area_uni_code 反查关联的市编码。来源 http://172.16.100.55:3000/search?query=setAreaCityUniCode%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Long areaCityUniCode;

    /**
     * 由 area_uni_code 反查关联的区县编码。来源 http://172.16.100.55:3000/search?query=setAreaDistrictUniCode%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Long areaDistrictUniCode;

    /**
     * 主体唯一编码。来源 http://172.16.100.55:3000/search?query=setComUniCode&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Long comUniCode;

    /**
     * 城投(实际控制人)区县编码。来源 http://172.16.100.55:3000/search?query=setUdicDistrictUniCode%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Long udicDistrictUniCode;

    /**
     * 城投(实际控制人)城市编码。来源 http://172.16.100.55:3000/search?query=setUdicCityUniCode%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Long udicCityUniCode;

    /**
     * 城投(实际控制人)省份编码。来源 http://172.16.100.55:3000/search?query=setUdicProvinceUniCode%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Long udicProvinceUniCode;

    /**
     * 债券承销商（发行机构）唯一编码。来源 http://172.16.100.55:3000/search?query=setIssueAgencyComUniCode%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Long issueAgencyComUniCode;

    @Column
    private Integer bondFilterType;

    /**
     * 债券筛选类型 同 bond_basic.onshore_bond_filter.bond_filter_type。来源 http://172.16.100.55:3000/search?query=setBasicBondFilterType%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer basicBondFilterType;

    /**
     * 地方债类型 1:一般地方债 2:地方专项债。来源 http://172.16.100.55:3000/search?query=setLocalBondType%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer localBondType;

    /**
     * 是否商金债 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setCorporateFinanceStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer corporateFinanceStatus;

    /**
     * 是否银行永续债 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setTier1Status%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer tier1Status;

    /**
     * 是否二级资本债 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setTier2Status%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer tier2Status;

    /**
     * 是否电力 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setElectricityStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer electricityStatus;

    /**
     * 是否钢铁 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setSteelStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer steelStatus;

    /**
     * 是否煤炭 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setCoalStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer coalStatus;

    /**
     * 是否水泥 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setCementStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer cementStatus;

    /**
     * 是否房地产 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setRealEstateStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer realEstateStatus;

    /**
     * 是否交运 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setTransportStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer transportStatus;

    /**
     * 是否城投主体 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setUdicStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer udicStatus;

    /**
     * 是否铁道 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setRailwayStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer railwayStatus;

    /**
     * 是否上市 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setListedStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer listedStatus;

    /**
     * 是否绿色债券 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setGreenBondStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer greenBondStatus;

    /**
     * 是否可质押 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setPledgeStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer pledgeStatus;

    /**
     * 是否跨市场 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setCrossMarketStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer crossMarketStatus;

    /**
     * 银行类型 1:政策性银行 2:国有商业银行 3:股份制商业银行 4:城市商业银行 5:农村商业银行 6:农村信用合作社 7:村镇银行。来源 http://172.16.100.55:3000/search?query=setBankType&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer bankType;

    /**
     * 同业存单(NCD)类型 2:国有商业银行 3:股份制商业银行 4:城市商业银行 5:农村商业银行 999:其他(1,6,7也归属到其他)。来源 http://172.16.100.55:3000/search?query=setNcdType%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer ncdType;

    /**
     * 票面利率筛选类型 1:固息 2:浮息 999:其他。来源 http://172.16.100.55:3000/search?query=setCouponRateFilterType&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer couponRateFilterType;

    /**
     * 票面利率V3筛选类型 1:固息 2:DEPO 3:LPR 4:SHIBOR 999:其他。来源 http://172.16.100.55:3000/search?query=setCouponRateV3FilterType&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer couponRateV3FilterType;

    /**
     * 债券隐含评级映射 10:AAA+ 20:AAA 30:AAA- 40:AA+ 50:AA 55:AA(2) 60:AA-。来源 http://172.16.100.55:3000/search?query=setBondImpliedRatingMapping&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer bondImpliedRatingMapping;

    /**
     * 债券外部评级筛选映射 1:AAA 2:AA+ 3:AA 4:AA- 5:A+ 999:其他。来源 http://172.16.100.55:3000/search?query=setBondExtRatingFilterMapping&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer bondExtRatingFilterMapping;

    /**
     * 主体外部评级筛选映射 1:AAA 2:AA+ 3:AA 4:AA- 5:A+ 999:其他。来源 http://172.16.100.55:3000/search?query=setComExtRatingFilterMapping&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer comExtRatingFilterMapping;

    @Column
    private Integer comYyRatingMapping;

    /**
     * YY主体评级V2映射 枚举详见 http://172.16.100.55:3000/search?query=YyRatingEnum&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer comYyRatingV2Mapping;

    /**
     * YY主体评级V2映射排序字段。来源 http://172.16.100.55:3000/search?query=setComYyRatingV2MappingSort%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer comYyRatingV2MappingSort;

    /**
     * 企业性质(经营类型过滤用) 1:央企 2:国企 3:民企 999:其他。来源 http://172.16.100.55:3000/search?query=setBusinessFilterNature&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer businessFilterNature;

    /**
     * 是否含权 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setEmbeddedOptionStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer embeddedOptionStatus;

    /**
     * 是否永续 0:非永续 1:永续。来源 http://172.16.100.55:3000/search?query=setPerpetualStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer perpetualStatus;

    /**
     * 担保状态 0:无 1:有。来源 http://172.16.100.55:3000/search?query=setGuaranteedStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer guaranteedStatus;

    /**
     * 担保细分 0:无担保 1:担保公司担保 2:其他担保。来源 http://172.16.100.55:3000/search?query=setGuaranteedStatusV2%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer guaranteedStatusV2;

    @Column
    private Integer udicAdministrativeRegion;

    /**
     * 债券募集类型 1:公募 2:私募 3:小公募。来源 http://172.16.100.55:3000/search?query=setBondOfferingType%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer bondOfferingType;

    /**
     * 债券市场(二级) 1:深圳证券交易所 2:上海证券交易所 3:银行间市场 4:柜台交易市场 999:其他。来源 http://172.16.100.55:3000/search?query=setSecondMarket&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer secondMarket;

    /**
     * 二级筛选市场 1:交易所 2:银行间 999:其他。来源 http://172.16.100.55:3000/search?query=setSecondFilterMarket&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer secondFilterMarket;

    /**
     * 是否流通中 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setCirculationStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer circulationStatus;

    /**
     * 发行状态 0:发行中 1:已上市 2:延迟发行 3:取消发行。来源 http://172.16.100.55:3000/search?query=setIssueStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer issueStatus;

    /**
     * 是否到期 0:未到期 1:已到期。来源 http://172.16.100.55:3000/search?query=setExpired&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer expired;

    /**
     * 币种 1:CNY 2:HKD 3:USD。来源 http://172.16.100.55:3000/search?query=setCurrency&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer currency;

    /**
     * 业务性质 详见参数字典 http://git.innodealing.cn/global/document/wikis （常用字段规范）。来源 http://172.16.100.55:3000/search?query=setBusinessNature&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer businessNature;

    /**
     * 募集方式 0:私募 1:公募。来源 http://172.16.100.55:3000/search?query=setPublicOffering&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer publicOffering;

    /**
     * 票面利率类型 0:其他 1:固定利率 2:浮动利率 3:累进利率 4:贴现 5:无序利率 999:其他。来源 http://172.16.100.55:3000/search?query=setCouponRateType%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer couponRateType;

    /**
     * 含权类型 0:含权 1:不含权 2:永续。来源 http://172.16.100.55:3000/search?query=setEmbeddedOption&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer embeddedOption;

    /**
     * 债券类型 详见参数字典 bond_type http://git.innodealing.cn/global/document/wikis （常用字段规范）。来源 http://172.16.100.55:3000/search?query=setBondType&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer bondType;

    /**
     * 主体外部评级映射 0:-- 20:AAA 40:AA+ 50:AA 60:AA- 70:A+ 80:A 90:A- 100:BBB+ 110:BBB 120:BBB- 130:BB+ 140:BB 150:BB- 160:B+ 170:B 180:B- 200:CCC 220:CC 230:C。来源 http://172.16.100.55:3000/search?query=setComExtRatingMapping&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer comExtRatingMapping;

    /**
     * 海外主体外部评级映射 0:-- 20:AAA 22:Aaa 42:Aa1 50:AA 60:AA- 70:A+ 72:A1 80:A 82:A2 90:A- 92:A3 100:BBB+ 102:Baa1 110:BBB 112:Baa2 120:BBB- 122:Baa3 130:BB+ 132:Ba1 140:BB 142:Ba2 150:BB- 152:Ba3 160:B+ 162:B1 172:B2 180:B- 182:B3 190:CCC+ 192:Caa1 202:Caa2 210:CCC- 212:Caa3 222:Ca 239:SD 240:D 999:-- 1002:WD。来源 http://172.16.100.55:3000/search?query=setIntlExtRatingMapping&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer intlExtRatingMapping;

    /**
     * 债券外部评级映射 0:-- 20:AAA 21:A-1+ 22:Aaa 30:AAA- 40:AA+ 50:AA 60:AA- 70:A+ 71:A-1 80:A 90:A- 91:A-2 100:BBB+ 110:BBB 120:BBB- 121:A-3 130:BB+ 140:BB 160:B+ 170:B 180:B- 200:CCC 220:CC 230:C 240:D 999:--。来源 http://172.16.100.55:3000/search?query=setBondExtRatingMapping&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer bondExtRatingMapping;

    /**
     * 是否回售 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setPutOptionStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer putOptionStatus;

    /**
     * 是否赎回 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setRedeemStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer redeemStatus;

    /**
     * 主体是否违约 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setDefaultComStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer defaultComStatus;

    /**
     * 付息频率 12:按月 4:按季 2:半年 1:按年 999:其他。来源 http://172.16.100.55:3000/search?query=setInterestPaymentFrequency%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer interestPaymentFrequency;

    /**
     * 是否非银金融债 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setNonBankFinanceStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer nonBankFinanceStatus;

    /**
     * 剩余期限天数。来源 http://172.16.100.55:3000/search?query=setRemainingTenorDay&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer remainingTenorDay;

    @Column
    private Integer areaLevel;

    /**
     * 平台重要性(平台等级) 1:核心平台 2:重要平台 3:次要平台。来源 http://172.16.100.55:3000/search?query=setPlatformLevel%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer platformLevel;

    /**
     * DM城投状态 0:非城投 1:城投。来源 http://172.16.100.55:3000/search?query=setDmUdicStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer dmUdicStatus;

    @Column
    private Integer crossMarketDedupStatus;

    /**
     * 提前还本状态 0:不提前还本 1:提前还本。来源 http://172.16.100.55:3000/search?query=setPrepaymentStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer prepaymentStatus;

    /**
     * 券商普通债状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setSecurityGeneralStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer securityGeneralStatus;

    /**
     * 券商次级债状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setSecuritySubStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer securitySubStatus;

    /**
     * 保险永续债状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setInsurancePerpetualStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer insurancePerpetualStatus;

    /**
     * 保险次级债状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setInsuranceSubStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer insuranceSubStatus;

    /**
     * 不含假期状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setWithoutHolidayStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer withoutHolidayStatus;

    /**
     * 外资银行状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setForeignBankStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer foreignBankStatus;

    /**
     * 次级债状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setSubordinatedStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer subordinatedStatus;

    /**
     * 债券期限天数。来源 http://172.16.100.55:3000/search?query=setBondTenorDay%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer bondTenorDay;

    /**
     * 中债债券类型 1:国债/地方政府债/政策性银行债/企业债/商业银行债/银行间ABS估值 2:中票/短融(超短融)及标准化票据估值 3:PPN及其他债务融资工具估值 4:同业存单估值 5:公司债估值 6:ABS和ABN估值 7:违约估值。来源 http://172.16.100.55:3000/search?query=setCbResourceType&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer cbResourceType;

    /**
     * 科创票据状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setScienceTechNoteStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer scienceTechNoteStatus;

    /**
     * 科技创新公司债状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setStiStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer stiStatus;

    /**
     * 碳中和债状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setCarbonNeutralityStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer carbonNeutralityStatus;

    /**
     * 乡村振兴债状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setRuralRevivalStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer ruralRevivalStatus;

    /**
     * 地方债类型 1:一般债 2:专项债 99:其他。来源 http://172.16.100.55:3000/search?query=setLgBondType&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer lgBondType;

    /**
     * 熊猫债状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setPandaStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer pandaStatus;

    /**
     * 熊猫债状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setPandaBondStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer pandaBondStatus;

    /**
     * 经纪商成交(笔)。来源 http://172.16.100.55:3000/search?query=setTradingNum%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer tradingNum;

    /**
     * 成交天数。来源 http://172.16.100.55:3000/search?query=setTradingDays%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer tradingDays;

    /**
     * Bid笔数。来源 http://172.16.100.55:3000/search?query=setBidNum%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer bidNum;

    /**
     * Bid天数。来源 http://172.16.100.55:3000/search?query=setBidQuoteDays%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer bidQuoteDays;

    /**
     * Ofr笔数。来源 http://172.16.100.55:3000/search?query=setOfrNum%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer ofrNum;

    /**
     * Ofr天数。来源 http://172.16.100.55:3000/search?query=setOfrQuoteDays%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer ofrQuoteDays;

    /**
     * 双边报价天数。来源 http://172.16.100.55:3000/search?query=setTwoSideQuoteDays%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer twoSideQuoteDays;

    /**
     * 流动性评分统计周期 1:3天 10:14天。来源 http://172.16.100.55:3000/search?query=setLiquidityScoreStatPeriod%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer liquidityScoreStatPeriod;

    /**
     * 流动性评分。来源 http://172.16.100.55:3000/search?query=setLiquidityScoreLevel&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer liquidityScoreLevel;

    /**
     * 是否TLAC债 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setTlacBondStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer tlacBondStatus;

    /**
     * 利率类型 2:浮动利率。来源 http://172.16.100.55:3000/search?query=setRateType%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer rateType;

    /**
     * 是否柜台债 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setCounterBondStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer counterBondStatus;

    /**
     * 是否证券公司短融债 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setSecurityInstCpBondStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer securityInstCpBondStatus;

    /**
     * 是否政策性银行次级债 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setPolicyBankSubBondStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer policyBankSubBondStatus;

    /**
     * 是否贴现国债 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setDiscountTreasuryBondStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer discountTreasuryBondStatus;

    /**
     * 托管场所 1:中债登 2:中证登 3:上清所 99:其他。来源 http://172.16.100.55:3000/search?query=setCustodyVenue%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer custodyVenue;

    /**
     * 中债资信债券评级映射 1:AAA+ 2:AAA 3:AAA- 4:AA+ 5:AA 99:其他 999:无评级。来源 http://172.16.100.55:3000/search?query=setChinaBondCreditRatingMapping%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer chinaBondCreditRatingMapping;

    /**
     * 中债资信主体评级映射 1:AAA+ 2:AAA 3:AAA- 4:AA+ 5:AA 99:其他 999:无评级。来源 http://172.16.100.55:3000/search?query=setChinaComCreditRatingMapping%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer chinaComCreditRatingMapping;

    /**
     * 交易所做市 1:上证利率 2:上证信用 3:深证利率 4:深证信用。来源 http://172.16.100.55:3000/search?query=setMarketMaker%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer marketMaker;

    /**
     * 债券承销商中介类型代码。来源 http://172.16.100.55:3000/search?query=setIssueAgencyTypeCode%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer issueAgencyTypeCode;

    /**
     * 是否信用债ETF 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setCreditBondEtfStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer creditBondEtfStatus;

    /**
     * 是否利率债ETF 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setRateBondEtfStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer rateBondEtfStatus;

    /**
     * 是否科创债ETF 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setSciTechInnoBondEtfStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer sciTechInnoBondEtfStatus;

    /**
     * 是否可转债ETF 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setConvertibleBondEtfStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer convertibleBondEtfStatus;

    /**
     * 到期日距下个工作日相差天数（到期日即工作日则为0）。来源 http://172.16.100.55:3000/search?query=setMaturityHoildayDay%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer maturityHoildayDay;

    /**
     * 到期日距下个工作日相差天数（不含周末口径）。来源 http://172.16.100.55:3000/search?query=setMaturityHolidayDayNotWeekend%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer maturityHolidayDayNotWeekend;

    /**
     * 科创债-科创债ETF成分券状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setStiEtfStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer stiEtfStatus;

    /**
     * 科创债-非科创债ETF成分券状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setStiNotEtfStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer stiNotEtfStatus;

    /**
     * 是否免税 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setTaxFreeStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer taxFreeStatus;

    /**
     * 清偿顺序 1:普通债权 2:次级债权 3:二级资本工具 4:混合资本工具 5:其他一级资本工具 99:其他。来源 http://172.16.100.55:3000/search?query=setPaymentOrder&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer paymentOrder;

    /**
     * 是否可赎回 0:不可赎回 1:可赎。来源 http://172.16.100.55:3000/search?query=setCallableStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer callableStatus;

    /**
     * 风险类型 0:违约 1:展期。来源 http://172.16.100.55:3000/search?query=setRiskType%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer riskType;

    /**
     * 税率矩阵类型 1:国债 2:地方债 3:政金债 4:央票 5:金融债 6:同业存单 7:铁道债 99:信用债。来源 http://172.16.100.55:3000/search?query=setTaxRateMatrixType%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer taxRateMatrixType;

    /**
     * 流动性大档评分 1:S 2:A 3:B 4:C 5:D 6:E（参见 LiquidityLargeGearScoreEnum）。来源 http://172.16.100.55:3000/search?query=setLargeGearScore%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer largeGearScore;

    /**
     * 流动性小档评分 1:S+ 2:S 3:S- 4:A+ 5:A 6:A- 7:B+ 8:B 9:B- 10:C+ 11:C 12:C- 13:D+ 14:D 15:D- 16:E（参见 LiquiditySmallGearScoreEnum）。来源 http://172.16.100.55:3000/search?query=setSmallGearScore%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer smallGearScore;

    /**
     * 流动性评分值是否展示 0:不展示 1:展示。来源 http://172.16.100.55:3000/search?query=setLsScoreShowStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer lsScoreShowStatus;

    /**
     * 票面利率F9筛选类型 1:固息 2:浮息 999:其他（累进利率类型映射为其他）。来源 http://172.16.100.55:3000/search?query=setCouponRateF9FilterType%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer couponRateF9FilterType;

    /**
     * 是否信用债 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setCreditBondStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer creditBondStatus;

    /**
     * 是否利率债 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setRateBondStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer rateBondStatus;

    /**
     * 是否科创债 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setSciTechInnoBondStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer sciTechInnoBondStatus;

    /**
     * 存续状态 0:非存续 1:存续 99:其他。来源 http://172.16.100.55:3000/search?query=setOutstandingStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer outstandingStatus;

    /**
     * 债券发行年份。来源 http://172.16.100.55:3000/search?query=setBondIssYear%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer bondIssYear;

    /**
     * 地方债资金用途性质 1:新增 2:再融资 3:置换 4:特殊再融资 99:其他。来源 http://172.16.100.55:3000/search?query=setFundUseType&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer fundUseType;

    /**
     * 高成长产业债状态 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setHighGrowthSectorBondStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer highGrowthSectorBondStatus;

    /**
     * 利息计算方式 1:按频率比例 2:ACT/365 3:ACT/360 4:ACT/ACT 5:THIRTY_360 6:DIVIDE 999:其他。来源 http://172.16.100.55:3000/search?query=setInterestCalculateMethod%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private Integer interestCalculateMethod;

    /**
     * 债券担保人全称列表 Set<String>。来源 http://172.16.100.55:3000/search?query=setGuarantorFullNames%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private String guarantorFullNames;

    /**
     * 基金精简信息 List<DwsFundShortInfoDTO>。来源 http://172.16.100.55:3000/search?query=setFundShortInfos%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private String fundShortInfos;

    /**
     * 跨市场债券集合 List<BondCodeNameV3DTO>（跨市场债拼接，见 cross_market_dedup_status）。来源 http://172.16.100.55:3000/search?query=setCrossBondCodeNameV3DTOs%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private String crossBondCodeNameV3;

    /**
     * 行权日期集合 List<String>。解析逻辑详见 http://172.16.100.55:3000/search?query=getExerciseDateList%20BondBasicInfoDAO&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private String exerciseDateList;

    /**
     * 计算用未来行权日集合(>=计算日) List<java.sql.Date>(epoch-millis)。逻辑详见 http://172.16.100.55:3000/search?query=filterCalcFutureExerciseDates&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private String calcFutureExerciseDate;

    /**
     * 计算用历史行权日集合 List<java.sql.Date>(epoch-millis)。解析逻辑详见 http://172.16.100.55:3000/search?query=parseAllExerciseDates&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic
     */
    @Column
    private String calcHistoryExerciseDate;

    /**
     * 创建时间
     */
    @Column
    private LocalDateTime createTime;

    /**
     * 更新时间（仅当 content_hash 变化时才 bump，作为 OSS 增量游标）
     */
    @Column
    private LocalDateTime updateTime;

    /**
     * 软删标记 0:未删 1:已删
     */
    @Column
    private Integer deleted;

    /**
     * 全字段内容哈希 MD5（内容门控：哈希不变则不写、update_time 不动）
     */
    @Column
    private String contentHash;

    @Column
    private String constraint;

    public Long getBondunicode() {
        return bondUniCode;
    }

    public void setBondunicode(Long bondUniCode) {
        this.bondUniCode = bondUniCode;
    }

    public Long getBondid() {
        return bondId;
    }

    public void setBondid(Long bondId) {
        this.bondId = bondId;
    }

    public String getBondcode() {
        return bondCode;
    }

    public void setBondcode(String bondCode) {
        this.bondCode = bondCode;
    }

    public String getBondshortname() {
        return bondShortName;
    }

    public void setBondshortname(String bondShortName) {
        this.bondShortName = bondShortName;
    }

    public String getComyyratingv2() {
        return comYyRatingV2;
    }

    public void setComyyratingv2(String comYyRatingV2) {
        this.comYyRatingV2 = comYyRatingV2;
    }

    public String getBondimpliedrating() {
        return bondImpliedRating;
    }

    public void setBondimpliedrating(String bondImpliedRating) {
        this.bondImpliedRating = bondImpliedRating;
    }

    public String getBondextrating() {
        return bondExtRating;
    }

    public void setBondextrating(String bondExtRating) {
        this.bondExtRating = bondExtRating;
    }

    public String getComextrating() {
        return comExtRating;
    }

    public void setComextrating(String comExtRating) {
        this.comExtRating = comExtRating;
    }

    public String getComshortname() {
        return comShortName;
    }

    public void setComshortname(String comShortName) {
        this.comShortName = comShortName;
    }

    public String getComfullname() {
        return comFullName;
    }

    public void setComfullname(String comFullName) {
        this.comFullName = comFullName;
    }

    public String getRemainingtenor() {
        return remainingTenor;
    }

    public void setRemainingtenor(String remainingTenor) {
        this.remainingTenor = remainingTenor;
    }

    public String getUdicindulevel2name() {
        return udicInduLevel2Name;
    }

    public void setUdicindulevel2name(String udicInduLevel2Name) {
        this.udicInduLevel2Name = udicInduLevel2Name;
    }

    public String getBondtenor() {
        return bondTenor;
    }

    public void setBondtenor(String bondTenor) {
        this.bondTenor = bondTenor;
    }

    public String getChinabondcreditrating() {
        return chinaBondCreditRating;
    }

    public void setChinabondcreditrating(String chinaBondCreditRating) {
        this.chinaBondCreditRating = chinaBondCreditRating;
    }

    public String getChinacomcreditrating() {
        return chinaComCreditRating;
    }

    public void setChinacomcreditrating(String chinaComCreditRating) {
        this.chinaComCreditRating = chinaComCreditRating;
    }

    public String getIssueagencycomfullname() {
        return issueAgencyComFullName;
    }

    public void setIssueagencycomfullname(String issueAgencyComFullName) {
        this.issueAgencyComFullName = issueAgencyComFullName;
    }

    public String getLargegearscoredesc() {
        return largeGearScoreDesc;
    }

    public void setLargegearscoredesc(String largeGearScoreDesc) {
        this.largeGearScoreDesc = largeGearScoreDesc;
    }

    public String getSmallgearscoredesc() {
        return smallGearScoreDesc;
    }

    public void setSmallgearscoredesc(String smallGearScoreDesc) {
        this.smallGearScoreDesc = smallGearScoreDesc;
    }

    public String getBaseratepar() {
        return baseRatePar;
    }

    public void setBaseratepar(String baseRatePar) {
        this.baseRatePar = baseRatePar;
    }

    public String getBondcredlevel() {
        return bondCredLevel;
    }

    public void setBondcredlevel(String bondCredLevel) {
        this.bondCredLevel = bondCredLevel;
    }

    public String getComcredlevel() {
        return comCredLevel;
    }

    public void setComcredlevel(String comCredLevel) {
        this.comCredLevel = comCredLevel;
    }

    public String getLatestexercisedate() {
        return latestExerciseDate;
    }

    public void setLatestexercisedate(String latestExerciseDate) {
        this.latestExerciseDate = latestExerciseDate;
    }

    public LocalDate getListdate() {
        return listDate;
    }

    public void setListdate(LocalDate listDate) {
        this.listDate = listDate;
    }

    public LocalDate getMaturitydatecalendar() {
        return maturityDateCalendar;
    }

    public void setMaturitydatecalendar(LocalDate maturityDateCalendar) {
        this.maturityDateCalendar = maturityDateCalendar;
    }

    public LocalDate getIssuestartdate() {
        return issueStartDate;
    }

    public void setIssuestartdate(LocalDate issueStartDate) {
        this.issueStartDate = issueStartDate;
    }

    public LocalDate getIssueenddate() {
        return issueEndDate;
    }

    public void setIssueenddate(LocalDate issueEndDate) {
        this.issueEndDate = issueEndDate;
    }

    public LocalDate getMaturitydate() {
        return maturityDate;
    }

    public void setMaturitydate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

    public LocalDate getCalclatestexercisedate() {
        return calcLatestExerciseDate;
    }

    public void setCalclatestexercisedate(LocalDate calcLatestExerciseDate) {
        this.calcLatestExerciseDate = calcLatestExerciseDate;
    }

    public BigDecimal getTurnoverrate() {
        return turnoverRate;
    }

    public void setTurnoverrate(BigDecimal turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    public BigDecimal getInterbanktradeamount() {
        return interbankTradeAmount;
    }

    public void setInterbanktradeamount(BigDecimal interbankTradeAmount) {
        this.interbankTradeAmount = interbankTradeAmount;
    }

    public BigDecimal getExchangetradeamount() {
        return exchangeTradeAmount;
    }

    public void setExchangetradeamount(BigDecimal exchangeTradeAmount) {
        this.exchangeTradeAmount = exchangeTradeAmount;
    }

    public BigDecimal getTradeyieldsubcbmedian() {
        return tradeYieldSubCbMedian;
    }

    public void setTradeyieldsubcbmedian(BigDecimal tradeYieldSubCbMedian) {
        this.tradeYieldSubCbMedian = tradeYieldSubCbMedian;
    }

    public BigDecimal getBidyieldsubofrmedian() {
        return bidYieldSubOfrMedian;
    }

    public void setBidyieldsubofrmedian(BigDecimal bidYieldSubOfrMedian) {
        this.bidYieldSubOfrMedian = bidYieldSubOfrMedian;
    }

    public BigDecimal getBidyieldsubcbmedian() {
        return bidYieldSubCbMedian;
    }

    public void setBidyieldsubcbmedian(BigDecimal bidYieldSubCbMedian) {
        this.bidYieldSubCbMedian = bidYieldSubCbMedian;
    }

    public BigDecimal getCbyieldsubofrmedian() {
        return cbYieldSubOfrMedian;
    }

    public void setCbyieldsubofrmedian(BigDecimal cbYieldSubOfrMedian) {
        this.cbYieldSubOfrMedian = cbYieldSubOfrMedian;
    }

    public BigDecimal getBondbalance() {
        return bondBalance;
    }

    public void setBondbalance(BigDecimal bondBalance) {
        this.bondBalance = bondBalance;
    }

    public BigDecimal getActualissueamount() {
        return actualIssueAmount;
    }

    public void setActualissueamount(BigDecimal actualIssueAmount) {
        this.actualIssueAmount = actualIssueAmount;
    }

    public BigDecimal getIssueprice() {
        return issuePrice;
    }

    public void setIssueprice(BigDecimal issuePrice) {
        this.issuePrice = issuePrice;
    }

    public BigDecimal getDidintervallow() {
        return didIntervalLow;
    }

    public void setDidintervallow(BigDecimal didIntervalLow) {
        this.didIntervalLow = didIntervalLow;
    }

    public BigDecimal getDidintervalsup() {
        return didIntervalSup;
    }

    public void setDidintervalsup(BigDecimal didIntervalSup) {
        this.didIntervalSup = didIntervalSup;
    }

    public BigDecimal getLatestcouponrate() {
        return latestCouponRate;
    }

    public void setLatestcouponrate(BigDecimal latestCouponRate) {
        this.latestCouponRate = latestCouponRate;
    }

    public BigDecimal getLatestparvalue() {
        return latestParValue;
    }

    public void setLatestparvalue(BigDecimal latestParValue) {
        this.latestParValue = latestParValue;
    }

    public BigDecimal getLsscore() {
        return lsScore;
    }

    public void setLsscore(BigDecimal lsScore) {
        this.lsScore = lsScore;
    }

    public BigDecimal getConvratio() {
        return convRatio;
    }

    public void setConvratio(BigDecimal convRatio) {
        this.convRatio = convRatio;
    }

    public Long getIndulevel1code() {
        return induLevel1Code;
    }

    public void setIndulevel1code(Long induLevel1Code) {
        this.induLevel1Code = induLevel1Code;
    }

    public Long getIndulevel2code() {
        return induLevel2Code;
    }

    public void setIndulevel2code(Long induLevel2Code) {
        this.induLevel2Code = induLevel2Code;
    }

    public Long getProvinceunicode() {
        return provinceUniCode;
    }

    public void setProvinceunicode(Long provinceUniCode) {
        this.provinceUniCode = provinceUniCode;
    }

    public Long getCityunicode() {
        return cityUniCode;
    }

    public void setCityunicode(Long cityUniCode) {
        this.cityUniCode = cityUniCode;
    }

    public Long getUdicareaunicode() {
        return udicAreaUniCode;
    }

    public void setUdicareaunicode(Long udicAreaUniCode) {
        this.udicAreaUniCode = udicAreaUniCode;
    }

    public Long getAreaunicode() {
        return areaUniCode;
    }

    public void setAreaunicode(Long areaUniCode) {
        this.areaUniCode = areaUniCode;
    }

    public Long getAreaprovinceunicode() {
        return areaProvinceUniCode;
    }

    public void setAreaprovinceunicode(Long areaProvinceUniCode) {
        this.areaProvinceUniCode = areaProvinceUniCode;
    }

    public Long getAreacityunicode() {
        return areaCityUniCode;
    }

    public void setAreacityunicode(Long areaCityUniCode) {
        this.areaCityUniCode = areaCityUniCode;
    }

    public Long getAreadistrictunicode() {
        return areaDistrictUniCode;
    }

    public void setAreadistrictunicode(Long areaDistrictUniCode) {
        this.areaDistrictUniCode = areaDistrictUniCode;
    }

    public Long getComunicode() {
        return comUniCode;
    }

    public void setComunicode(Long comUniCode) {
        this.comUniCode = comUniCode;
    }

    public Long getUdicdistrictunicode() {
        return udicDistrictUniCode;
    }

    public void setUdicdistrictunicode(Long udicDistrictUniCode) {
        this.udicDistrictUniCode = udicDistrictUniCode;
    }

    public Long getUdiccityunicode() {
        return udicCityUniCode;
    }

    public void setUdiccityunicode(Long udicCityUniCode) {
        this.udicCityUniCode = udicCityUniCode;
    }

    public Long getUdicprovinceunicode() {
        return udicProvinceUniCode;
    }

    public void setUdicprovinceunicode(Long udicProvinceUniCode) {
        this.udicProvinceUniCode = udicProvinceUniCode;
    }

    public Long getIssueagencycomunicode() {
        return issueAgencyComUniCode;
    }

    public void setIssueagencycomunicode(Long issueAgencyComUniCode) {
        this.issueAgencyComUniCode = issueAgencyComUniCode;
    }

    public Integer getBondfiltertype() {
        return bondFilterType;
    }

    public void setBondfiltertype(Integer bondFilterType) {
        this.bondFilterType = bondFilterType;
    }

    public Integer getBasicbondfiltertype() {
        return basicBondFilterType;
    }

    public void setBasicbondfiltertype(Integer basicBondFilterType) {
        this.basicBondFilterType = basicBondFilterType;
    }

    public Integer getLocalbondtype() {
        return localBondType;
    }

    public void setLocalbondtype(Integer localBondType) {
        this.localBondType = localBondType;
    }

    public Integer getCorporatefinancestatus() {
        return corporateFinanceStatus;
    }

    public void setCorporatefinancestatus(Integer corporateFinanceStatus) {
        this.corporateFinanceStatus = corporateFinanceStatus;
    }

    public Integer getTier1status() {
        return tier1Status;
    }

    public void setTier1status(Integer tier1Status) {
        this.tier1Status = tier1Status;
    }

    public Integer getTier2status() {
        return tier2Status;
    }

    public void setTier2status(Integer tier2Status) {
        this.tier2Status = tier2Status;
    }

    public Integer getElectricitystatus() {
        return electricityStatus;
    }

    public void setElectricitystatus(Integer electricityStatus) {
        this.electricityStatus = electricityStatus;
    }

    public Integer getSteelstatus() {
        return steelStatus;
    }

    public void setSteelstatus(Integer steelStatus) {
        this.steelStatus = steelStatus;
    }

    public Integer getCoalstatus() {
        return coalStatus;
    }

    public void setCoalstatus(Integer coalStatus) {
        this.coalStatus = coalStatus;
    }

    public Integer getCementstatus() {
        return cementStatus;
    }

    public void setCementstatus(Integer cementStatus) {
        this.cementStatus = cementStatus;
    }

    public Integer getRealestatestatus() {
        return realEstateStatus;
    }

    public void setRealestatestatus(Integer realEstateStatus) {
        this.realEstateStatus = realEstateStatus;
    }

    public Integer getTransportstatus() {
        return transportStatus;
    }

    public void setTransportstatus(Integer transportStatus) {
        this.transportStatus = transportStatus;
    }

    public Integer getUdicstatus() {
        return udicStatus;
    }

    public void setUdicstatus(Integer udicStatus) {
        this.udicStatus = udicStatus;
    }

    public Integer getRailwaystatus() {
        return railwayStatus;
    }

    public void setRailwaystatus(Integer railwayStatus) {
        this.railwayStatus = railwayStatus;
    }

    public Integer getListedstatus() {
        return listedStatus;
    }

    public void setListedstatus(Integer listedStatus) {
        this.listedStatus = listedStatus;
    }

    public Integer getGreenbondstatus() {
        return greenBondStatus;
    }

    public void setGreenbondstatus(Integer greenBondStatus) {
        this.greenBondStatus = greenBondStatus;
    }

    public Integer getPledgestatus() {
        return pledgeStatus;
    }

    public void setPledgestatus(Integer pledgeStatus) {
        this.pledgeStatus = pledgeStatus;
    }

    public Integer getCrossmarketstatus() {
        return crossMarketStatus;
    }

    public void setCrossmarketstatus(Integer crossMarketStatus) {
        this.crossMarketStatus = crossMarketStatus;
    }

    public Integer getBanktype() {
        return bankType;
    }

    public void setBanktype(Integer bankType) {
        this.bankType = bankType;
    }

    public Integer getNcdtype() {
        return ncdType;
    }

    public void setNcdtype(Integer ncdType) {
        this.ncdType = ncdType;
    }

    public Integer getCouponratefiltertype() {
        return couponRateFilterType;
    }

    public void setCouponratefiltertype(Integer couponRateFilterType) {
        this.couponRateFilterType = couponRateFilterType;
    }

    public Integer getCouponratev3filtertype() {
        return couponRateV3FilterType;
    }

    public void setCouponratev3filtertype(Integer couponRateV3FilterType) {
        this.couponRateV3FilterType = couponRateV3FilterType;
    }

    public Integer getBondimpliedratingmapping() {
        return bondImpliedRatingMapping;
    }

    public void setBondimpliedratingmapping(Integer bondImpliedRatingMapping) {
        this.bondImpliedRatingMapping = bondImpliedRatingMapping;
    }

    public Integer getBondextratingfiltermapping() {
        return bondExtRatingFilterMapping;
    }

    public void setBondextratingfiltermapping(Integer bondExtRatingFilterMapping) {
        this.bondExtRatingFilterMapping = bondExtRatingFilterMapping;
    }

    public Integer getComextratingfiltermapping() {
        return comExtRatingFilterMapping;
    }

    public void setComextratingfiltermapping(Integer comExtRatingFilterMapping) {
        this.comExtRatingFilterMapping = comExtRatingFilterMapping;
    }

    public Integer getComyyratingmapping() {
        return comYyRatingMapping;
    }

    public void setComyyratingmapping(Integer comYyRatingMapping) {
        this.comYyRatingMapping = comYyRatingMapping;
    }

    public Integer getComyyratingv2mapping() {
        return comYyRatingV2Mapping;
    }

    public void setComyyratingv2mapping(Integer comYyRatingV2Mapping) {
        this.comYyRatingV2Mapping = comYyRatingV2Mapping;
    }

    public Integer getComyyratingv2mappingsort() {
        return comYyRatingV2MappingSort;
    }

    public void setComyyratingv2mappingsort(Integer comYyRatingV2MappingSort) {
        this.comYyRatingV2MappingSort = comYyRatingV2MappingSort;
    }

    public Integer getBusinessfilternature() {
        return businessFilterNature;
    }

    public void setBusinessfilternature(Integer businessFilterNature) {
        this.businessFilterNature = businessFilterNature;
    }

    public Integer getEmbeddedoptionstatus() {
        return embeddedOptionStatus;
    }

    public void setEmbeddedoptionstatus(Integer embeddedOptionStatus) {
        this.embeddedOptionStatus = embeddedOptionStatus;
    }

    public Integer getPerpetualstatus() {
        return perpetualStatus;
    }

    public void setPerpetualstatus(Integer perpetualStatus) {
        this.perpetualStatus = perpetualStatus;
    }

    public Integer getGuaranteedstatus() {
        return guaranteedStatus;
    }

    public void setGuaranteedstatus(Integer guaranteedStatus) {
        this.guaranteedStatus = guaranteedStatus;
    }

    public Integer getGuaranteedstatusv2() {
        return guaranteedStatusV2;
    }

    public void setGuaranteedstatusv2(Integer guaranteedStatusV2) {
        this.guaranteedStatusV2 = guaranteedStatusV2;
    }

    public Integer getUdicadministrativeregion() {
        return udicAdministrativeRegion;
    }

    public void setUdicadministrativeregion(Integer udicAdministrativeRegion) {
        this.udicAdministrativeRegion = udicAdministrativeRegion;
    }

    public Integer getBondofferingtype() {
        return bondOfferingType;
    }

    public void setBondofferingtype(Integer bondOfferingType) {
        this.bondOfferingType = bondOfferingType;
    }

    public Integer getSecondmarket() {
        return secondMarket;
    }

    public void setSecondmarket(Integer secondMarket) {
        this.secondMarket = secondMarket;
    }

    public Integer getSecondfiltermarket() {
        return secondFilterMarket;
    }

    public void setSecondfiltermarket(Integer secondFilterMarket) {
        this.secondFilterMarket = secondFilterMarket;
    }

    public Integer getCirculationstatus() {
        return circulationStatus;
    }

    public void setCirculationstatus(Integer circulationStatus) {
        this.circulationStatus = circulationStatus;
    }

    public Integer getIssuestatus() {
        return issueStatus;
    }

    public void setIssuestatus(Integer issueStatus) {
        this.issueStatus = issueStatus;
    }

    public Integer getExpired() {
        return expired;
    }

    public void setExpired(Integer expired) {
        this.expired = expired;
    }

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public Integer getBusinessnature() {
        return businessNature;
    }

    public void setBusinessnature(Integer businessNature) {
        this.businessNature = businessNature;
    }

    public Integer getPublicoffering() {
        return publicOffering;
    }

    public void setPublicoffering(Integer publicOffering) {
        this.publicOffering = publicOffering;
    }

    public Integer getCouponratetype() {
        return couponRateType;
    }

    public void setCouponratetype(Integer couponRateType) {
        this.couponRateType = couponRateType;
    }

    public Integer getEmbeddedoption() {
        return embeddedOption;
    }

    public void setEmbeddedoption(Integer embeddedOption) {
        this.embeddedOption = embeddedOption;
    }

    public Integer getBondtype() {
        return bondType;
    }

    public void setBondtype(Integer bondType) {
        this.bondType = bondType;
    }

    public Integer getComextratingmapping() {
        return comExtRatingMapping;
    }

    public void setComextratingmapping(Integer comExtRatingMapping) {
        this.comExtRatingMapping = comExtRatingMapping;
    }

    public Integer getIntlextratingmapping() {
        return intlExtRatingMapping;
    }

    public void setIntlextratingmapping(Integer intlExtRatingMapping) {
        this.intlExtRatingMapping = intlExtRatingMapping;
    }

    public Integer getBondextratingmapping() {
        return bondExtRatingMapping;
    }

    public void setBondextratingmapping(Integer bondExtRatingMapping) {
        this.bondExtRatingMapping = bondExtRatingMapping;
    }

    public Integer getPutoptionstatus() {
        return putOptionStatus;
    }

    public void setPutoptionstatus(Integer putOptionStatus) {
        this.putOptionStatus = putOptionStatus;
    }

    public Integer getRedeemstatus() {
        return redeemStatus;
    }

    public void setRedeemstatus(Integer redeemStatus) {
        this.redeemStatus = redeemStatus;
    }

    public Integer getDefaultcomstatus() {
        return defaultComStatus;
    }

    public void setDefaultcomstatus(Integer defaultComStatus) {
        this.defaultComStatus = defaultComStatus;
    }

    public Integer getInterestpaymentfrequency() {
        return interestPaymentFrequency;
    }

    public void setInterestpaymentfrequency(Integer interestPaymentFrequency) {
        this.interestPaymentFrequency = interestPaymentFrequency;
    }

    public Integer getNonbankfinancestatus() {
        return nonBankFinanceStatus;
    }

    public void setNonbankfinancestatus(Integer nonBankFinanceStatus) {
        this.nonBankFinanceStatus = nonBankFinanceStatus;
    }

    public Integer getRemainingtenorday() {
        return remainingTenorDay;
    }

    public void setRemainingtenorday(Integer remainingTenorDay) {
        this.remainingTenorDay = remainingTenorDay;
    }

    public Integer getArealevel() {
        return areaLevel;
    }

    public void setArealevel(Integer areaLevel) {
        this.areaLevel = areaLevel;
    }

    public Integer getPlatformlevel() {
        return platformLevel;
    }

    public void setPlatformlevel(Integer platformLevel) {
        this.platformLevel = platformLevel;
    }

    public Integer getDmudicstatus() {
        return dmUdicStatus;
    }

    public void setDmudicstatus(Integer dmUdicStatus) {
        this.dmUdicStatus = dmUdicStatus;
    }

    public Integer getCrossmarketdedupstatus() {
        return crossMarketDedupStatus;
    }

    public void setCrossmarketdedupstatus(Integer crossMarketDedupStatus) {
        this.crossMarketDedupStatus = crossMarketDedupStatus;
    }

    public Integer getPrepaymentstatus() {
        return prepaymentStatus;
    }

    public void setPrepaymentstatus(Integer prepaymentStatus) {
        this.prepaymentStatus = prepaymentStatus;
    }

    public Integer getSecuritygeneralstatus() {
        return securityGeneralStatus;
    }

    public void setSecuritygeneralstatus(Integer securityGeneralStatus) {
        this.securityGeneralStatus = securityGeneralStatus;
    }

    public Integer getSecuritysubstatus() {
        return securitySubStatus;
    }

    public void setSecuritysubstatus(Integer securitySubStatus) {
        this.securitySubStatus = securitySubStatus;
    }

    public Integer getInsuranceperpetualstatus() {
        return insurancePerpetualStatus;
    }

    public void setInsuranceperpetualstatus(Integer insurancePerpetualStatus) {
        this.insurancePerpetualStatus = insurancePerpetualStatus;
    }

    public Integer getInsurancesubstatus() {
        return insuranceSubStatus;
    }

    public void setInsurancesubstatus(Integer insuranceSubStatus) {
        this.insuranceSubStatus = insuranceSubStatus;
    }

    public Integer getWithoutholidaystatus() {
        return withoutHolidayStatus;
    }

    public void setWithoutholidaystatus(Integer withoutHolidayStatus) {
        this.withoutHolidayStatus = withoutHolidayStatus;
    }

    public Integer getForeignbankstatus() {
        return foreignBankStatus;
    }

    public void setForeignbankstatus(Integer foreignBankStatus) {
        this.foreignBankStatus = foreignBankStatus;
    }

    public Integer getSubordinatedstatus() {
        return subordinatedStatus;
    }

    public void setSubordinatedstatus(Integer subordinatedStatus) {
        this.subordinatedStatus = subordinatedStatus;
    }

    public Integer getBondtenorday() {
        return bondTenorDay;
    }

    public void setBondtenorday(Integer bondTenorDay) {
        this.bondTenorDay = bondTenorDay;
    }

    public Integer getCbresourcetype() {
        return cbResourceType;
    }

    public void setCbresourcetype(Integer cbResourceType) {
        this.cbResourceType = cbResourceType;
    }

    public Integer getSciencetechnotestatus() {
        return scienceTechNoteStatus;
    }

    public void setSciencetechnotestatus(Integer scienceTechNoteStatus) {
        this.scienceTechNoteStatus = scienceTechNoteStatus;
    }

    public Integer getStistatus() {
        return stiStatus;
    }

    public void setStistatus(Integer stiStatus) {
        this.stiStatus = stiStatus;
    }

    public Integer getCarbonneutralitystatus() {
        return carbonNeutralityStatus;
    }

    public void setCarbonneutralitystatus(Integer carbonNeutralityStatus) {
        this.carbonNeutralityStatus = carbonNeutralityStatus;
    }

    public Integer getRuralrevivalstatus() {
        return ruralRevivalStatus;
    }

    public void setRuralrevivalstatus(Integer ruralRevivalStatus) {
        this.ruralRevivalStatus = ruralRevivalStatus;
    }

    public Integer getLgbondtype() {
        return lgBondType;
    }

    public void setLgbondtype(Integer lgBondType) {
        this.lgBondType = lgBondType;
    }

    public Integer getPandastatus() {
        return pandaStatus;
    }

    public void setPandastatus(Integer pandaStatus) {
        this.pandaStatus = pandaStatus;
    }

    public Integer getPandabondstatus() {
        return pandaBondStatus;
    }

    public void setPandabondstatus(Integer pandaBondStatus) {
        this.pandaBondStatus = pandaBondStatus;
    }

    public Integer getTradingnum() {
        return tradingNum;
    }

    public void setTradingnum(Integer tradingNum) {
        this.tradingNum = tradingNum;
    }

    public Integer getTradingdays() {
        return tradingDays;
    }

    public void setTradingdays(Integer tradingDays) {
        this.tradingDays = tradingDays;
    }

    public Integer getBidnum() {
        return bidNum;
    }

    public void setBidnum(Integer bidNum) {
        this.bidNum = bidNum;
    }

    public Integer getBidquotedays() {
        return bidQuoteDays;
    }

    public void setBidquotedays(Integer bidQuoteDays) {
        this.bidQuoteDays = bidQuoteDays;
    }

    public Integer getOfrnum() {
        return ofrNum;
    }

    public void setOfrnum(Integer ofrNum) {
        this.ofrNum = ofrNum;
    }

    public Integer getOfrquotedays() {
        return ofrQuoteDays;
    }

    public void setOfrquotedays(Integer ofrQuoteDays) {
        this.ofrQuoteDays = ofrQuoteDays;
    }

    public Integer getTwosidequotedays() {
        return twoSideQuoteDays;
    }

    public void setTwosidequotedays(Integer twoSideQuoteDays) {
        this.twoSideQuoteDays = twoSideQuoteDays;
    }

    public Integer getLiquidityscorestatperiod() {
        return liquidityScoreStatPeriod;
    }

    public void setLiquidityscorestatperiod(Integer liquidityScoreStatPeriod) {
        this.liquidityScoreStatPeriod = liquidityScoreStatPeriod;
    }

    public Integer getLiquidityscorelevel() {
        return liquidityScoreLevel;
    }

    public void setLiquidityscorelevel(Integer liquidityScoreLevel) {
        this.liquidityScoreLevel = liquidityScoreLevel;
    }

    public Integer getTlacbondstatus() {
        return tlacBondStatus;
    }

    public void setTlacbondstatus(Integer tlacBondStatus) {
        this.tlacBondStatus = tlacBondStatus;
    }

    public Integer getRatetype() {
        return rateType;
    }

    public void setRatetype(Integer rateType) {
        this.rateType = rateType;
    }

    public Integer getCounterbondstatus() {
        return counterBondStatus;
    }

    public void setCounterbondstatus(Integer counterBondStatus) {
        this.counterBondStatus = counterBondStatus;
    }

    public Integer getSecurityinstcpbondstatus() {
        return securityInstCpBondStatus;
    }

    public void setSecurityinstcpbondstatus(Integer securityInstCpBondStatus) {
        this.securityInstCpBondStatus = securityInstCpBondStatus;
    }

    public Integer getPolicybanksubbondstatus() {
        return policyBankSubBondStatus;
    }

    public void setPolicybanksubbondstatus(Integer policyBankSubBondStatus) {
        this.policyBankSubBondStatus = policyBankSubBondStatus;
    }

    public Integer getDiscounttreasurybondstatus() {
        return discountTreasuryBondStatus;
    }

    public void setDiscounttreasurybondstatus(Integer discountTreasuryBondStatus) {
        this.discountTreasuryBondStatus = discountTreasuryBondStatus;
    }

    public Integer getCustodyvenue() {
        return custodyVenue;
    }

    public void setCustodyvenue(Integer custodyVenue) {
        this.custodyVenue = custodyVenue;
    }

    public Integer getChinabondcreditratingmapping() {
        return chinaBondCreditRatingMapping;
    }

    public void setChinabondcreditratingmapping(Integer chinaBondCreditRatingMapping) {
        this.chinaBondCreditRatingMapping = chinaBondCreditRatingMapping;
    }

    public Integer getChinacomcreditratingmapping() {
        return chinaComCreditRatingMapping;
    }

    public void setChinacomcreditratingmapping(Integer chinaComCreditRatingMapping) {
        this.chinaComCreditRatingMapping = chinaComCreditRatingMapping;
    }

    public Integer getMarketmaker() {
        return marketMaker;
    }

    public void setMarketmaker(Integer marketMaker) {
        this.marketMaker = marketMaker;
    }

    public Integer getIssueagencytypecode() {
        return issueAgencyTypeCode;
    }

    public void setIssueagencytypecode(Integer issueAgencyTypeCode) {
        this.issueAgencyTypeCode = issueAgencyTypeCode;
    }

    public Integer getCreditbondetfstatus() {
        return creditBondEtfStatus;
    }

    public void setCreditbondetfstatus(Integer creditBondEtfStatus) {
        this.creditBondEtfStatus = creditBondEtfStatus;
    }

    public Integer getRatebondetfstatus() {
        return rateBondEtfStatus;
    }

    public void setRatebondetfstatus(Integer rateBondEtfStatus) {
        this.rateBondEtfStatus = rateBondEtfStatus;
    }

    public Integer getScitechinnobondetfstatus() {
        return sciTechInnoBondEtfStatus;
    }

    public void setScitechinnobondetfstatus(Integer sciTechInnoBondEtfStatus) {
        this.sciTechInnoBondEtfStatus = sciTechInnoBondEtfStatus;
    }

    public Integer getConvertiblebondetfstatus() {
        return convertibleBondEtfStatus;
    }

    public void setConvertiblebondetfstatus(Integer convertibleBondEtfStatus) {
        this.convertibleBondEtfStatus = convertibleBondEtfStatus;
    }

    public Integer getMaturityhoildayday() {
        return maturityHoildayDay;
    }

    public void setMaturityhoildayday(Integer maturityHoildayDay) {
        this.maturityHoildayDay = maturityHoildayDay;
    }

    public Integer getMaturityholidaydaynotweekend() {
        return maturityHolidayDayNotWeekend;
    }

    public void setMaturityholidaydaynotweekend(Integer maturityHolidayDayNotWeekend) {
        this.maturityHolidayDayNotWeekend = maturityHolidayDayNotWeekend;
    }

    public Integer getStietfstatus() {
        return stiEtfStatus;
    }

    public void setStietfstatus(Integer stiEtfStatus) {
        this.stiEtfStatus = stiEtfStatus;
    }

    public Integer getStinotetfstatus() {
        return stiNotEtfStatus;
    }

    public void setStinotetfstatus(Integer stiNotEtfStatus) {
        this.stiNotEtfStatus = stiNotEtfStatus;
    }

    public Integer getTaxfreestatus() {
        return taxFreeStatus;
    }

    public void setTaxfreestatus(Integer taxFreeStatus) {
        this.taxFreeStatus = taxFreeStatus;
    }

    public Integer getPaymentorder() {
        return paymentOrder;
    }

    public void setPaymentorder(Integer paymentOrder) {
        this.paymentOrder = paymentOrder;
    }

    public Integer getCallablestatus() {
        return callableStatus;
    }

    public void setCallablestatus(Integer callableStatus) {
        this.callableStatus = callableStatus;
    }

    public Integer getRisktype() {
        return riskType;
    }

    public void setRisktype(Integer riskType) {
        this.riskType = riskType;
    }

    public Integer getTaxratematrixtype() {
        return taxRateMatrixType;
    }

    public void setTaxratematrixtype(Integer taxRateMatrixType) {
        this.taxRateMatrixType = taxRateMatrixType;
    }

    public Integer getLargegearscore() {
        return largeGearScore;
    }

    public void setLargegearscore(Integer largeGearScore) {
        this.largeGearScore = largeGearScore;
    }

    public Integer getSmallgearscore() {
        return smallGearScore;
    }

    public void setSmallgearscore(Integer smallGearScore) {
        this.smallGearScore = smallGearScore;
    }

    public Integer getLsscoreshowstatus() {
        return lsScoreShowStatus;
    }

    public void setLsscoreshowstatus(Integer lsScoreShowStatus) {
        this.lsScoreShowStatus = lsScoreShowStatus;
    }

    public Integer getCouponratef9filtertype() {
        return couponRateF9FilterType;
    }

    public void setCouponratef9filtertype(Integer couponRateF9FilterType) {
        this.couponRateF9FilterType = couponRateF9FilterType;
    }

    public Integer getCreditbondstatus() {
        return creditBondStatus;
    }

    public void setCreditbondstatus(Integer creditBondStatus) {
        this.creditBondStatus = creditBondStatus;
    }

    public Integer getRatebondstatus() {
        return rateBondStatus;
    }

    public void setRatebondstatus(Integer rateBondStatus) {
        this.rateBondStatus = rateBondStatus;
    }

    public Integer getScitechinnobondstatus() {
        return sciTechInnoBondStatus;
    }

    public void setScitechinnobondstatus(Integer sciTechInnoBondStatus) {
        this.sciTechInnoBondStatus = sciTechInnoBondStatus;
    }

    public Integer getOutstandingstatus() {
        return outstandingStatus;
    }

    public void setOutstandingstatus(Integer outstandingStatus) {
        this.outstandingStatus = outstandingStatus;
    }

    public Integer getBondissyear() {
        return bondIssYear;
    }

    public void setBondissyear(Integer bondIssYear) {
        this.bondIssYear = bondIssYear;
    }

    public Integer getFundusetype() {
        return fundUseType;
    }

    public void setFundusetype(Integer fundUseType) {
        this.fundUseType = fundUseType;
    }

    public Integer getHighgrowthsectorbondstatus() {
        return highGrowthSectorBondStatus;
    }

    public void setHighgrowthsectorbondstatus(Integer highGrowthSectorBondStatus) {
        this.highGrowthSectorBondStatus = highGrowthSectorBondStatus;
    }

    public Integer getInterestcalculatemethod() {
        return interestCalculateMethod;
    }

    public void setInterestcalculatemethod(Integer interestCalculateMethod) {
        this.interestCalculateMethod = interestCalculateMethod;
    }

    public String getGuarantorfullnames() {
        return guarantorFullNames;
    }

    public void setGuarantorfullnames(String guarantorFullNames) {
        this.guarantorFullNames = guarantorFullNames;
    }

    public String getFundshortinfos() {
        return fundShortInfos;
    }

    public void setFundshortinfos(String fundShortInfos) {
        this.fundShortInfos = fundShortInfos;
    }

    public String getCrossbondcodenamev3() {
        return crossBondCodeNameV3;
    }

    public void setCrossbondcodenamev3(String crossBondCodeNameV3) {
        this.crossBondCodeNameV3 = crossBondCodeNameV3;
    }

    public String getExercisedatelist() {
        return exerciseDateList;
    }

    public void setExercisedatelist(String exerciseDateList) {
        this.exerciseDateList = exerciseDateList;
    }

    public String getCalcfutureexercisedate() {
        return calcFutureExerciseDate;
    }

    public void setCalcfutureexercisedate(String calcFutureExerciseDate) {
        this.calcFutureExerciseDate = calcFutureExerciseDate;
    }

    public String getCalchistoryexercisedate() {
        return calcHistoryExerciseDate;
    }

    public void setCalchistoryexercisedate(String calcHistoryExerciseDate) {
        this.calcHistoryExerciseDate = calcHistoryExerciseDate;
    }

    public LocalDateTime getCreatetime() {
        return createTime;
    }

    public void setCreatetime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdatetime() {
        return updateTime;
    }

    public void setUpdatetime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getContenthash() {
        return contentHash;
    }

    public void setContenthash(String contentHash) {
        this.contentHash = contentHash;
    }

    public String getConstraint() {
        return constraint;
    }

    public void setConstraint(String constraint) {
        this.constraint = constraint;
    }

}
