package com.example.onshore.model.dto.response;

import java.sql.Date;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import io.swagger.annotations.ApiModelProperty;

/**
 * 表Page对象 {@link OnshoreBondFilterV3DO}
 *
 * @author xionglei
 */
public class OnshoreBondFilterV3PageDTO {

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("债券统一编码")
    private Long bondUniCode;

    @ApiModelProperty("债券ID。来源 http://172.16.100.55:3000/search?query=setBondId%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Long bondId;

    @ApiModelProperty("债券代码。来源 http://172.16.100.55:3000/search?query=setBondCode%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private String bondCode;

    @ApiModelProperty("债券简称。来源 http://172.16.100.55:3000/search?query=setBondShortName%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private String bondShortName;

    @ApiModelProperty("YY主体评级V2（字符串，映射值见 com_yy_rating_v2_mapping）。来源 http://172.16.100.55:3000/search?query=setComYyRatingV2%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private String comYyRatingV2;

    @ApiModelProperty("债券隐含评级 取值：AAA+;AAA;AAA-;AA+;AA;AA(2);AA-（数值映射见 bond_implied_rating_mapping）。来源 http://172.16.100.55:3000/search?query=setBondImpliedRating%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private String bondImpliedRating;

    @ApiModelProperty("债券外部评级筛选 取值：AAA;AA+;AA;AA-;A+;--（数值映射见 bond_ext_rating_filter_mapping）。来源 http://172.16.100.55:3000/search?query=setBondExtRating%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private String bondExtRating;

    @ApiModelProperty("主体外部评级筛选 取值：AAA;AA+;AA;AA-;A+;--（数值映射见 com_ext_rating_filter_mapping）。来源 http://172.16.100.55:3000/search?query=setComExtRating%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private String comExtRating;

    @ApiModelProperty("主体简称（发行人简称）。来源 http://172.16.100.55:3000/search?query=setComShortName%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private String comShortName;

    @ApiModelProperty("主体全称（发行人全称）。来源 http://172.16.100.55:3000/search?query=setComFullName%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private String comFullName;

    @ApiModelProperty("剩余期限（字符串，天数见 remaining_tenor_day）。来源 http://172.16.100.55:3000/search?query=setRemainingTenor%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private String remainingTenor;

    @ApiModelProperty("城投二级行业名称。来源 http://172.16.100.55:3000/search?query=setUdicInduLevel2Name%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private String udicInduLevel2Name;

    @ApiModelProperty("债券期限（字符串，天数见 bond_tenor_day）。来源 http://172.16.100.55:3000/search?query=setBondTenor%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private String bondTenor;

    @ApiModelProperty("china_bond_credit_rating")
    private String chinaBondCreditRating;

    @ApiModelProperty("china_com_credit_rating")
    private String chinaComCreditRating;

    @ApiModelProperty("债券承销商（发行机构）主体全称。来源 http://172.16.100.55:3000/search?query=setIssueAgencyComFullName%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private String issueAgencyComFullName;

    @ApiModelProperty("流动性大档评分描述（字符串，数值见 large_gear_score）。来源 http://172.16.100.55:3000/search?query=setLargeGearScoreDesc%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private String largeGearScoreDesc;

    @ApiModelProperty("流动性小档评分描述（字符串，数值见 small_gear_score）。来源 http://172.16.100.55:3000/search?query=setSmallGearScoreDesc%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private String smallGearScoreDesc;

    @ApiModelProperty("浮息基准（浮动利率基准）。来源 http://172.16.100.55:3000/search?query=setBaseRatePar%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private String baseRatePar;

    @ApiModelProperty("债券信用级别（取自 rating 服务）。来源 http://172.16.100.55:3000/search?query=setBondCredLevel%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private String bondCredLevel;

    @ApiModelProperty("发行人（主体）信用级别（取自 rating 服务）。来源 http://172.16.100.55:3000/search?query=setComCredLevel%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private String comCredLevel;

    @ApiModelProperty("最新行权日（字符串）。解析逻辑详见 http://172.16.100.55:3000/search?query=getExerciseDateByCalculateDate&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private String latestExerciseDate;

    @ApiModelProperty("上市日。来源 http://172.16.100.55:3000/search?query=setListDate&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Date listDate;

    @ApiModelProperty("到期日（日历）：优先取 latest_exercise_date，无行权日时取 maturity_date。来源 http://172.16.100.55:3000/search?query=setMaturityDateCalendar%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Date maturityDateCalendar;

    @ApiModelProperty("发行起始日。来源 http://172.16.100.55:3000/search?query=setIssueStartDate%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Date issueStartDate;

    @ApiModelProperty("发行结束日。来源 http://172.16.100.55:3000/search?query=setIssueEndDate%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Date issueEndDate;

    @ApiModelProperty("到期日（源:t_bond_basic_info#actu_end_date）。来源 http://172.16.100.55:3000/search?query=setMaturityDate%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Date maturityDate;

    @ApiModelProperty("计算用最新行权日。解析逻辑详见 http://172.16.100.55:3000/search?query=parseCalcLatestExerciseDate&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Date calcLatestExerciseDate;

    @ApiModelProperty("换手率。来源 http://172.16.100.55:3000/search?query=setTurnoverRate%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private BigDecimal turnoverRate;

    @ApiModelProperty("CFETS(银行间)成交量(亿)。来源 http://172.16.100.55:3000/search?query=setInterbankTradeAmount%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private BigDecimal interbankTradeAmount;

    @ApiModelProperty("交易所成交量(万)。来源 http://172.16.100.55:3000/search?query=setExchangeTradeAmount%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private BigDecimal exchangeTradeAmount;

    @ApiModelProperty("成交偏离中值(BP)：成交收益率减中债中位数。来源 http://172.16.100.55:3000/search?query=setTradeYieldSubCbMedian%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private BigDecimal tradeYieldSubCbMedian;

    @ApiModelProperty("双边利差中值(BP)：bid收益率减ofr。来源 http://172.16.100.55:3000/search?query=setBidYieldSubOfrMedian%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private BigDecimal bidYieldSubOfrMedian;

    @ApiModelProperty("bid中债偏离中值(BP)：bid收益率减中债。来源 http://172.16.100.55:3000/search?query=setBidYieldSubCbMedian%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private BigDecimal bidYieldSubCbMedian;

    @ApiModelProperty("ofr偏离中值(BP)：中债收益率减ofr。来源 http://172.16.100.55:3000/search?query=setCbYieldSubOfrMedian%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private BigDecimal cbYieldSubOfrMedian;

    @ApiModelProperty("债券余额(单位:亿)。来源 http://172.16.100.55:3000/search?query=setBondBalance&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private BigDecimal bondBalance;

    @ApiModelProperty("实际发行金额(默认:亿)。来源 http://172.16.100.55:3000/search?query=setActualIssueAmount&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private BigDecimal actualIssueAmount;

    @ApiModelProperty("发行价格(单位:元)。来源 http://172.16.100.55:3000/search?query=setIssuePrice%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private BigDecimal issuePrice;

    @ApiModelProperty("招标区间下限(源:t_bond_primary_info#did_interval_low)。来源 http://172.16.100.55:3000/search?query=setDidIntervalLow%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private BigDecimal didIntervalLow;

    @ApiModelProperty("招标区间上限(源:t_bond_primary_info#did_interval_sup)。来源 http://172.16.100.55:3000/search?query=setDidIntervalSup%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private BigDecimal didIntervalSup;

    @ApiModelProperty("最新票面利率。来源 http://172.16.100.55:3000/search?query=setLatestCouponRate%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private BigDecimal latestCouponRate;

    @ApiModelProperty("最新票面值。来源 http://172.16.100.55:3000/search?query=setLatestParValue%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private BigDecimal latestParValue;

    @ApiModelProperty("流动性评分值 S+:100 S:95 S-:90 A+:85 A:80 A-:70 B+:60 B:55 B-:50 C+:35 C:30 C-:25 D+:10 D:5 D-:3 E:0（是否展示见 ls_score_show_status）。来源 http://172.16.100.55:3000/search?query=setLsScore%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private BigDecimal lsScore;

    @ApiModelProperty("质押率(转股比例)。来源 http://172.16.100.55:3000/search?query=setConvRatio&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private BigDecimal convRatio;

    @ApiModelProperty("一级行业编码。来源 http://172.16.100.55:3000/search?query=setInduLevel1Code&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Long induLevel1Code;

    @ApiModelProperty("二级行业编码。来源 http://172.16.100.55:3000/search?query=setInduLevel2Code&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Long induLevel2Code;

    @ApiModelProperty("省份编码。来源 http://172.16.100.55:3000/search?query=setProvinceUniCode&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Long provinceUniCode;

    @ApiModelProperty("地级市编码。来源 http://172.16.100.55:3000/search?query=setCityUniCode&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Long cityUniCode;

    @ApiModelProperty("城投(实际控制人)区域编码。来源 http://172.16.100.55:3000/search?query=setUdicAreaUniCode%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Long udicAreaUniCode;

    @ApiModelProperty("区域编码：udicAreaUniCode!=0取之；为0但cityUniCode!=0取cityUniCode；均为0取provinceUniCode。逻辑详见 http://172.16.100.55:3000/search?query=getAreaUniCode%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Long areaUniCode;

    @ApiModelProperty("由 area_uni_code 反查关联的省编码。来源 http://172.16.100.55:3000/search?query=setAreaProvinceUniCode%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Long areaProvinceUniCode;

    @ApiModelProperty("由 area_uni_code 反查关联的市编码。来源 http://172.16.100.55:3000/search?query=setAreaCityUniCode%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Long areaCityUniCode;

    @ApiModelProperty("由 area_uni_code 反查关联的区县编码。来源 http://172.16.100.55:3000/search?query=setAreaDistrictUniCode%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Long areaDistrictUniCode;

    @ApiModelProperty("主体唯一编码。来源 http://172.16.100.55:3000/search?query=setComUniCode&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Long comUniCode;

    @ApiModelProperty("城投(实际控制人)区县编码。来源 http://172.16.100.55:3000/search?query=setUdicDistrictUniCode%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Long udicDistrictUniCode;

    @ApiModelProperty("城投(实际控制人)城市编码。来源 http://172.16.100.55:3000/search?query=setUdicCityUniCode%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Long udicCityUniCode;

    @ApiModelProperty("城投(实际控制人)省份编码。来源 http://172.16.100.55:3000/search?query=setUdicProvinceUniCode%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Long udicProvinceUniCode;

    @ApiModelProperty("债券承销商（发行机构）唯一编码。来源 http://172.16.100.55:3000/search?query=setIssueAgencyComUniCode%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Long issueAgencyComUniCode;

    @ApiModelProperty("bond_filter_type")
    private Integer bondFilterType;

    @ApiModelProperty("债券筛选类型 同 bond_basic.onshore_bond_filter.bond_filter_type。来源 http://172.16.100.55:3000/search?query=setBasicBondFilterType%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer basicBondFilterType;

    @ApiModelProperty("地方债类型 1:一般地方债 2:地方专项债。来源 http://172.16.100.55:3000/search?query=setLocalBondType%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer localBondType;

    @ApiModelProperty("是否商金债 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setCorporateFinanceStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer corporateFinanceStatus;

    @ApiModelProperty("是否银行永续债 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setTier1Status%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer tier1Status;

    @ApiModelProperty("是否二级资本债 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setTier2Status%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer tier2Status;

    @ApiModelProperty("是否电力 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setElectricityStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer electricityStatus;

    @ApiModelProperty("是否钢铁 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setSteelStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer steelStatus;

    @ApiModelProperty("是否煤炭 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setCoalStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer coalStatus;

    @ApiModelProperty("是否水泥 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setCementStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer cementStatus;

    @ApiModelProperty("是否房地产 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setRealEstateStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer realEstateStatus;

    @ApiModelProperty("是否交运 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setTransportStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer transportStatus;

    @ApiModelProperty("是否城投主体 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setUdicStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer udicStatus;

    @ApiModelProperty("是否铁道 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setRailwayStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer railwayStatus;

    @ApiModelProperty("是否上市 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setListedStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer listedStatus;

    @ApiModelProperty("是否绿色债券 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setGreenBondStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer greenBondStatus;

    @ApiModelProperty("是否可质押 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setPledgeStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer pledgeStatus;

    @ApiModelProperty("是否跨市场 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setCrossMarketStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer crossMarketStatus;

    @ApiModelProperty("银行类型 1:政策性银行 2:国有商业银行 3:股份制商业银行 4:城市商业银行 5:农村商业银行 6:农村信用合作社 7:村镇银行。来源 http://172.16.100.55:3000/search?query=setBankType&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer bankType;

    @ApiModelProperty("同业存单(NCD)类型 2:国有商业银行 3:股份制商业银行 4:城市商业银行 5:农村商业银行 999:其他(1,6,7也归属到其他)。来源 http://172.16.100.55:3000/search?query=setNcdType%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer ncdType;

    @ApiModelProperty("票面利率筛选类型 1:固息 2:浮息 999:其他。来源 http://172.16.100.55:3000/search?query=setCouponRateFilterType&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer couponRateFilterType;

    @ApiModelProperty("票面利率V3筛选类型 1:固息 2:DEPO 3:LPR 4:SHIBOR 999:其他。来源 http://172.16.100.55:3000/search?query=setCouponRateV3FilterType&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer couponRateV3FilterType;

    @ApiModelProperty("债券隐含评级映射 10:AAA+ 20:AAA 30:AAA- 40:AA+ 50:AA 55:AA(2) 60:AA-。来源 http://172.16.100.55:3000/search?query=setBondImpliedRatingMapping&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer bondImpliedRatingMapping;

    @ApiModelProperty("债券外部评级筛选映射 1:AAA 2:AA+ 3:AA 4:AA- 5:A+ 999:其他。来源 http://172.16.100.55:3000/search?query=setBondExtRatingFilterMapping&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer bondExtRatingFilterMapping;

    @ApiModelProperty("主体外部评级筛选映射 1:AAA 2:AA+ 3:AA 4:AA- 5:A+ 999:其他。来源 http://172.16.100.55:3000/search?query=setComExtRatingFilterMapping&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer comExtRatingFilterMapping;

    @ApiModelProperty("com_yy_rating_mapping")
    private Integer comYyRatingMapping;

    @ApiModelProperty("YY主体评级V2映射 枚举详见 http://172.16.100.55:3000/search?query=YyRatingEnum&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer comYyRatingV2Mapping;

    @ApiModelProperty("YY主体评级V2映射排序字段。来源 http://172.16.100.55:3000/search?query=setComYyRatingV2MappingSort%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer comYyRatingV2MappingSort;

    @ApiModelProperty("企业性质(经营类型过滤用) 1:央企 2:国企 3:民企 999:其他。来源 http://172.16.100.55:3000/search?query=setBusinessFilterNature&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer businessFilterNature;

    @ApiModelProperty("是否含权 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setEmbeddedOptionStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer embeddedOptionStatus;

    @ApiModelProperty("是否永续 0:非永续 1:永续。来源 http://172.16.100.55:3000/search?query=setPerpetualStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer perpetualStatus;

    @ApiModelProperty("担保状态 0:无 1:有。来源 http://172.16.100.55:3000/search?query=setGuaranteedStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer guaranteedStatus;

    @ApiModelProperty("担保细分 0:无担保 1:担保公司担保 2:其他担保。来源 http://172.16.100.55:3000/search?query=setGuaranteedStatusV2%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer guaranteedStatusV2;

    @ApiModelProperty("udic_administrative_region")
    private Integer udicAdministrativeRegion;

    @ApiModelProperty("债券募集类型 1:公募 2:私募 3:小公募。来源 http://172.16.100.55:3000/search?query=setBondOfferingType%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer bondOfferingType;

    @ApiModelProperty("债券市场(二级) 1:深圳证券交易所 2:上海证券交易所 3:银行间市场 4:柜台交易市场 999:其他。来源 http://172.16.100.55:3000/search?query=setSecondMarket&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer secondMarket;

    @ApiModelProperty("二级筛选市场 1:交易所 2:银行间 999:其他。来源 http://172.16.100.55:3000/search?query=setSecondFilterMarket&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer secondFilterMarket;

    @ApiModelProperty("是否流通中 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setCirculationStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer circulationStatus;

    @ApiModelProperty("发行状态 0:发行中 1:已上市 2:延迟发行 3:取消发行。来源 http://172.16.100.55:3000/search?query=setIssueStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer issueStatus;

    @ApiModelProperty("是否到期 0:未到期 1:已到期。来源 http://172.16.100.55:3000/search?query=setExpired&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer expired;

    @ApiModelProperty("币种 1:CNY 2:HKD 3:USD。来源 http://172.16.100.55:3000/search?query=setCurrency&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer currency;

    @ApiModelProperty("业务性质 详见参数字典 http://git.innodealing.cn/global/document/wikis （常用字段规范）。来源 http://172.16.100.55:3000/search?query=setBusinessNature&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer businessNature;

    @ApiModelProperty("募集方式 0:私募 1:公募。来源 http://172.16.100.55:3000/search?query=setPublicOffering&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer publicOffering;

    @ApiModelProperty("票面利率类型 0:其他 1:固定利率 2:浮动利率 3:累进利率 4:贴现 5:无序利率 999:其他。来源 http://172.16.100.55:3000/search?query=setCouponRateType%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer couponRateType;

    @ApiModelProperty("含权类型 0:含权 1:不含权 2:永续。来源 http://172.16.100.55:3000/search?query=setEmbeddedOption&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer embeddedOption;

    @ApiModelProperty("债券类型 详见参数字典 bond_type http://git.innodealing.cn/global/document/wikis （常用字段规范）。来源 http://172.16.100.55:3000/search?query=setBondType&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer bondType;

    @ApiModelProperty("主体外部评级映射 0:-- 20:AAA 40:AA+ 50:AA 60:AA- 70:A+ 80:A 90:A- 100:BBB+ 110:BBB 120:BBB- 130:BB+ 140:BB 150:BB- 160:B+ 170:B 180:B- 200:CCC 220:CC 230:C。来源 http://172.16.100.55:3000/search?query=setComExtRatingMapping&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer comExtRatingMapping;

    @ApiModelProperty("海外主体外部评级映射 0:-- 20:AAA 22:Aaa 42:Aa1 50:AA 60:AA- 70:A+ 72:A1 80:A 82:A2 90:A- 92:A3 100:BBB+ 102:Baa1 110:BBB 112:Baa2 120:BBB- 122:Baa3 130:BB+ 132:Ba1 140:BB 142:Ba2 150:BB- 152:Ba3 160:B+ 162:B1 172:B2 180:B- 182:B3 190:CCC+ 192:Caa1 202:Caa2 210:CCC- 212:Caa3 222:Ca 239:SD 240:D 999:-- 1002:WD。来源 http://172.16.100.55:3000/search?query=setIntlExtRatingMapping&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer intlExtRatingMapping;

    @ApiModelProperty("债券外部评级映射 0:-- 20:AAA 21:A-1+ 22:Aaa 30:AAA- 40:AA+ 50:AA 60:AA- 70:A+ 71:A-1 80:A 90:A- 91:A-2 100:BBB+ 110:BBB 120:BBB- 121:A-3 130:BB+ 140:BB 160:B+ 170:B 180:B- 200:CCC 220:CC 230:C 240:D 999:--。来源 http://172.16.100.55:3000/search?query=setBondExtRatingMapping&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer bondExtRatingMapping;

    @ApiModelProperty("是否回售 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setPutOptionStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer putOptionStatus;

    @ApiModelProperty("是否赎回 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setRedeemStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer redeemStatus;

    @ApiModelProperty("主体是否违约 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setDefaultComStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer defaultComStatus;

    @ApiModelProperty("付息频率 12:按月 4:按季 2:半年 1:按年 999:其他。来源 http://172.16.100.55:3000/search?query=setInterestPaymentFrequency%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer interestPaymentFrequency;

    @ApiModelProperty("是否非银金融债 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setNonBankFinanceStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer nonBankFinanceStatus;

    @ApiModelProperty("剩余期限天数。来源 http://172.16.100.55:3000/search?query=setRemainingTenorDay&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer remainingTenorDay;

    @ApiModelProperty("area_level")
    private Integer areaLevel;

    @ApiModelProperty("平台重要性(平台等级) 1:核心平台 2:重要平台 3:次要平台。来源 http://172.16.100.55:3000/search?query=setPlatformLevel%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer platformLevel;

    @ApiModelProperty("DM城投状态 0:非城投 1:城投。来源 http://172.16.100.55:3000/search?query=setDmUdicStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer dmUdicStatus;

    @ApiModelProperty("cross_market_dedup_status")
    private Integer crossMarketDedupStatus;

    @ApiModelProperty("提前还本状态 0:不提前还本 1:提前还本。来源 http://172.16.100.55:3000/search?query=setPrepaymentStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer prepaymentStatus;

    @ApiModelProperty("券商普通债状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setSecurityGeneralStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer securityGeneralStatus;

    @ApiModelProperty("券商次级债状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setSecuritySubStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer securitySubStatus;

    @ApiModelProperty("保险永续债状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setInsurancePerpetualStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer insurancePerpetualStatus;

    @ApiModelProperty("保险次级债状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setInsuranceSubStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer insuranceSubStatus;

    @ApiModelProperty("不含假期状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setWithoutHolidayStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer withoutHolidayStatus;

    @ApiModelProperty("外资银行状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setForeignBankStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer foreignBankStatus;

    @ApiModelProperty("次级债状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setSubordinatedStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer subordinatedStatus;

    @ApiModelProperty("债券期限天数。来源 http://172.16.100.55:3000/search?query=setBondTenorDay%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer bondTenorDay;

    @ApiModelProperty("中债债券类型 1:国债/地方政府债/政策性银行债/企业债/商业银行债/银行间ABS估值 2:中票/短融(超短融)及标准化票据估值 3:PPN及其他债务融资工具估值 4:同业存单估值 5:公司债估值 6:ABS和ABN估值 7:违约估值。来源 http://172.16.100.55:3000/search?query=setCbResourceType&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer cbResourceType;

    @ApiModelProperty("科创票据状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setScienceTechNoteStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer scienceTechNoteStatus;

    @ApiModelProperty("科技创新公司债状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setStiStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer stiStatus;

    @ApiModelProperty("碳中和债状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setCarbonNeutralityStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer carbonNeutralityStatus;

    @ApiModelProperty("乡村振兴债状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setRuralRevivalStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer ruralRevivalStatus;

    @ApiModelProperty("地方债类型 1:一般债 2:专项债 99:其他。来源 http://172.16.100.55:3000/search?query=setLgBondType&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer lgBondType;

    @ApiModelProperty("熊猫债状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setPandaStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer pandaStatus;

    @ApiModelProperty("熊猫债状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setPandaBondStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer pandaBondStatus;

    @ApiModelProperty("经纪商成交(笔)。来源 http://172.16.100.55:3000/search?query=setTradingNum%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer tradingNum;

    @ApiModelProperty("成交天数。来源 http://172.16.100.55:3000/search?query=setTradingDays%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer tradingDays;

    @ApiModelProperty("Bid笔数。来源 http://172.16.100.55:3000/search?query=setBidNum%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer bidNum;

    @ApiModelProperty("Bid天数。来源 http://172.16.100.55:3000/search?query=setBidQuoteDays%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer bidQuoteDays;

    @ApiModelProperty("Ofr笔数。来源 http://172.16.100.55:3000/search?query=setOfrNum%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer ofrNum;

    @ApiModelProperty("Ofr天数。来源 http://172.16.100.55:3000/search?query=setOfrQuoteDays%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer ofrQuoteDays;

    @ApiModelProperty("双边报价天数。来源 http://172.16.100.55:3000/search?query=setTwoSideQuoteDays%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer twoSideQuoteDays;

    @ApiModelProperty("流动性评分统计周期 1:3天 10:14天。来源 http://172.16.100.55:3000/search?query=setLiquidityScoreStatPeriod%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer liquidityScoreStatPeriod;

    @ApiModelProperty("流动性评分。来源 http://172.16.100.55:3000/search?query=setLiquidityScoreLevel&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer liquidityScoreLevel;

    @ApiModelProperty("是否TLAC债 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setTlacBondStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer tlacBondStatus;

    @ApiModelProperty("利率类型 2:浮动利率。来源 http://172.16.100.55:3000/search?query=setRateType%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer rateType;

    @ApiModelProperty("是否柜台债 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setCounterBondStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer counterBondStatus;

    @ApiModelProperty("是否证券公司短融债 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setSecurityInstCpBondStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer securityInstCpBondStatus;

    @ApiModelProperty("是否政策性银行次级债 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setPolicyBankSubBondStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer policyBankSubBondStatus;

    @ApiModelProperty("是否贴现国债 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setDiscountTreasuryBondStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer discountTreasuryBondStatus;

    @ApiModelProperty("托管场所 1:中债登 2:中证登 3:上清所 99:其他。来源 http://172.16.100.55:3000/search?query=setCustodyVenue%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer custodyVenue;

    @ApiModelProperty("中债资信债券评级映射 1:AAA+ 2:AAA 3:AAA- 4:AA+ 5:AA 99:其他 999:无评级。来源 http://172.16.100.55:3000/search?query=setChinaBondCreditRatingMapping%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer chinaBondCreditRatingMapping;

    @ApiModelProperty("中债资信主体评级映射 1:AAA+ 2:AAA 3:AAA- 4:AA+ 5:AA 99:其他 999:无评级。来源 http://172.16.100.55:3000/search?query=setChinaComCreditRatingMapping%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer chinaComCreditRatingMapping;

    @ApiModelProperty("交易所做市 1:上证利率 2:上证信用 3:深证利率 4:深证信用。来源 http://172.16.100.55:3000/search?query=setMarketMaker%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer marketMaker;

    @ApiModelProperty("债券承销商中介类型代码。来源 http://172.16.100.55:3000/search?query=setIssueAgencyTypeCode%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer issueAgencyTypeCode;

    @ApiModelProperty("是否信用债ETF 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setCreditBondEtfStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer creditBondEtfStatus;

    @ApiModelProperty("是否利率债ETF 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setRateBondEtfStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer rateBondEtfStatus;

    @ApiModelProperty("是否科创债ETF 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setSciTechInnoBondEtfStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer sciTechInnoBondEtfStatus;

    @ApiModelProperty("是否可转债ETF 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setConvertibleBondEtfStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer convertibleBondEtfStatus;

    @ApiModelProperty("到期日距下个工作日相差天数（到期日即工作日则为0）。来源 http://172.16.100.55:3000/search?query=setMaturityHoildayDay%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer maturityHoildayDay;

    @ApiModelProperty("到期日距下个工作日相差天数（不含周末口径）。来源 http://172.16.100.55:3000/search?query=setMaturityHolidayDayNotWeekend%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer maturityHolidayDayNotWeekend;

    @ApiModelProperty("科创债-科创债ETF成分券状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setStiEtfStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer stiEtfStatus;

    @ApiModelProperty("科创债-非科创债ETF成分券状态 0:不是 1:是。来源 http://172.16.100.55:3000/search?query=setStiNotEtfStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer stiNotEtfStatus;

    @ApiModelProperty("是否免税 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setTaxFreeStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer taxFreeStatus;

    @ApiModelProperty("清偿顺序 1:普通债权 2:次级债权 3:二级资本工具 4:混合资本工具 5:其他一级资本工具 99:其他。来源 http://172.16.100.55:3000/search?query=setPaymentOrder&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer paymentOrder;

    @ApiModelProperty("是否可赎回 0:不可赎回 1:可赎。来源 http://172.16.100.55:3000/search?query=setCallableStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer callableStatus;

    @ApiModelProperty("风险类型 0:违约 1:展期。来源 http://172.16.100.55:3000/search?query=setRiskType%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer riskType;

    @ApiModelProperty("税率矩阵类型 1:国债 2:地方债 3:政金债 4:央票 5:金融债 6:同业存单 7:铁道债 99:信用债。来源 http://172.16.100.55:3000/search?query=setTaxRateMatrixType%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer taxRateMatrixType;

    @ApiModelProperty("流动性大档评分 1:S 2:A 3:B 4:C 5:D 6:E（参见 LiquidityLargeGearScoreEnum）。来源 http://172.16.100.55:3000/search?query=setLargeGearScore%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer largeGearScore;

    @ApiModelProperty("流动性小档评分 1:S+ 2:S 3:S- 4:A+ 5:A 6:A- 7:B+ 8:B 9:B- 10:C+ 11:C 12:C- 13:D+ 14:D 15:D- 16:E（参见 LiquiditySmallGearScoreEnum）。来源 http://172.16.100.55:3000/search?query=setSmallGearScore%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer smallGearScore;

    @ApiModelProperty("流动性评分值是否展示 0:不展示 1:展示。来源 http://172.16.100.55:3000/search?query=setLsScoreShowStatus%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer lsScoreShowStatus;

    @ApiModelProperty("票面利率F9筛选类型 1:固息 2:浮息 999:其他（累进利率类型映射为其他）。来源 http://172.16.100.55:3000/search?query=setCouponRateF9FilterType%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer couponRateF9FilterType;

    @ApiModelProperty("是否信用债 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setCreditBondStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer creditBondStatus;

    @ApiModelProperty("是否利率债 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setRateBondStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer rateBondStatus;

    @ApiModelProperty("是否科创债 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setSciTechInnoBondStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer sciTechInnoBondStatus;

    @ApiModelProperty("存续状态 0:非存续 1:存续 99:其他。来源 http://172.16.100.55:3000/search?query=setOutstandingStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer outstandingStatus;

    @ApiModelProperty("债券发行年份。来源 http://172.16.100.55:3000/search?query=setBondIssYear%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer bondIssYear;

    @ApiModelProperty("地方债资金用途性质 1:新增 2:再融资 3:置换 4:特殊再融资 99:其他。来源 http://172.16.100.55:3000/search?query=setFundUseType&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer fundUseType;

    @ApiModelProperty("高成长产业债状态 0:否 1:是。来源 http://172.16.100.55:3000/search?query=setHighGrowthSectorBondStatus&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer highGrowthSectorBondStatus;

    @ApiModelProperty("利息计算方式 1:按频率比例 2:ACT/365 3:ACT/360 4:ACT/ACT 5:THIRTY_360 6:DIVIDE 999:其他。来源 http://172.16.100.55:3000/search?query=setInterestCalculateMethod%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private Integer interestCalculateMethod;

    @ApiModelProperty("债券担保人全称列表 Set<String>。来源 http://172.16.100.55:3000/search?query=setGuarantorFullNames%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private String guarantorFullNames;

    @ApiModelProperty("基金精简信息 List<DwsFundShortInfoDTO>。来源 http://172.16.100.55:3000/search?query=setFundShortInfos%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private String fundShortInfos;

    @ApiModelProperty("跨市场债券集合 List<BondCodeNameV3DTO>（跨市场债拼接，见 cross_market_dedup_status）。来源 http://172.16.100.55:3000/search?query=setCrossBondCodeNameV3DTOs%20OnshoreBondFilterV3ServiceImpl&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private String crossBondCodeNameV3;

    @ApiModelProperty("行权日期集合 List<String>。解析逻辑详见 http://172.16.100.55:3000/search?query=getExerciseDateList%20BondBasicInfoDAO&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private String exerciseDateList;

    @ApiModelProperty("计算用未来行权日集合(>=计算日) List<java.sql.Date>(epoch-millis)。逻辑详见 http://172.16.100.55:3000/search?query=filterCalcFutureExerciseDates&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private String calcFutureExerciseDate;

    @ApiModelProperty("计算用历史行权日集合 List<java.sql.Date>(epoch-millis)。解析逻辑详见 http://172.16.100.55:3000/search?query=parseAllExerciseDates&langs=Java&repos=git.innodealing.cn%2Fbackend%2Fonshore-bond-basic")
    private String calcHistoryExerciseDate;

    @ApiModelProperty("全字段内容哈希 MD5（内容门控：哈希不变则不写、update_time 不动）")
    private String contentHash;

    @ApiModelProperty("更新人")
    private String updateByDis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBondUniCode() {
        return bondUniCode;
    }

    public void setBondUniCode(Long bondUniCode) {
        this.bondUniCode = bondUniCode;
    }

    public Long getBondId() {
        return bondId;
    }

    public void setBondId(Long bondId) {
        this.bondId = bondId;
    }

    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public String getBondShortName() {
        return bondShortName;
    }

    public void setBondShortName(String bondShortName) {
        this.bondShortName = bondShortName;
    }

    public String getComYyRatingV2() {
        return comYyRatingV2;
    }

    public void setComYyRatingV2(String comYyRatingV2) {
        this.comYyRatingV2 = comYyRatingV2;
    }

    public String getBondImpliedRating() {
        return bondImpliedRating;
    }

    public void setBondImpliedRating(String bondImpliedRating) {
        this.bondImpliedRating = bondImpliedRating;
    }

    public String getBondExtRating() {
        return bondExtRating;
    }

    public void setBondExtRating(String bondExtRating) {
        this.bondExtRating = bondExtRating;
    }

    public String getComExtRating() {
        return comExtRating;
    }

    public void setComExtRating(String comExtRating) {
        this.comExtRating = comExtRating;
    }

    public String getComShortName() {
        return comShortName;
    }

    public void setComShortName(String comShortName) {
        this.comShortName = comShortName;
    }

    public String getComFullName() {
        return comFullName;
    }

    public void setComFullName(String comFullName) {
        this.comFullName = comFullName;
    }

    public String getRemainingTenor() {
        return remainingTenor;
    }

    public void setRemainingTenor(String remainingTenor) {
        this.remainingTenor = remainingTenor;
    }

    public String getUdicInduLevel2Name() {
        return udicInduLevel2Name;
    }

    public void setUdicInduLevel2Name(String udicInduLevel2Name) {
        this.udicInduLevel2Name = udicInduLevel2Name;
    }

    public String getBondTenor() {
        return bondTenor;
    }

    public void setBondTenor(String bondTenor) {
        this.bondTenor = bondTenor;
    }

    public String getChinaBondCreditRating() {
        return chinaBondCreditRating;
    }

    public void setChinaBondCreditRating(String chinaBondCreditRating) {
        this.chinaBondCreditRating = chinaBondCreditRating;
    }

    public String getChinaComCreditRating() {
        return chinaComCreditRating;
    }

    public void setChinaComCreditRating(String chinaComCreditRating) {
        this.chinaComCreditRating = chinaComCreditRating;
    }

    public String getIssueAgencyComFullName() {
        return issueAgencyComFullName;
    }

    public void setIssueAgencyComFullName(String issueAgencyComFullName) {
        this.issueAgencyComFullName = issueAgencyComFullName;
    }

    public String getLargeGearScoreDesc() {
        return largeGearScoreDesc;
    }

    public void setLargeGearScoreDesc(String largeGearScoreDesc) {
        this.largeGearScoreDesc = largeGearScoreDesc;
    }

    public String getSmallGearScoreDesc() {
        return smallGearScoreDesc;
    }

    public void setSmallGearScoreDesc(String smallGearScoreDesc) {
        this.smallGearScoreDesc = smallGearScoreDesc;
    }

    public String getBaseRatePar() {
        return baseRatePar;
    }

    public void setBaseRatePar(String baseRatePar) {
        this.baseRatePar = baseRatePar;
    }

    public String getBondCredLevel() {
        return bondCredLevel;
    }

    public void setBondCredLevel(String bondCredLevel) {
        this.bondCredLevel = bondCredLevel;
    }

    public String getComCredLevel() {
        return comCredLevel;
    }

    public void setComCredLevel(String comCredLevel) {
        this.comCredLevel = comCredLevel;
    }

    public String getLatestExerciseDate() {
        return latestExerciseDate;
    }

    public void setLatestExerciseDate(String latestExerciseDate) {
        this.latestExerciseDate = latestExerciseDate;
    }

    public Date getListDate() {
        return listDate;
    }

    public void setListDate(Date listDate) {
        this.listDate = listDate;
    }

    public Date getMaturityDateCalendar() {
        return maturityDateCalendar;
    }

    public void setMaturityDateCalendar(Date maturityDateCalendar) {
        this.maturityDateCalendar = maturityDateCalendar;
    }

    public Date getIssueStartDate() {
        return issueStartDate;
    }

    public void setIssueStartDate(Date issueStartDate) {
        this.issueStartDate = issueStartDate;
    }

    public Date getIssueEndDate() {
        return issueEndDate;
    }

    public void setIssueEndDate(Date issueEndDate) {
        this.issueEndDate = issueEndDate;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Date getCalcLatestExerciseDate() {
        return calcLatestExerciseDate;
    }

    public void setCalcLatestExerciseDate(Date calcLatestExerciseDate) {
        this.calcLatestExerciseDate = calcLatestExerciseDate;
    }

    public BigDecimal getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(BigDecimal turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    public BigDecimal getInterbankTradeAmount() {
        return interbankTradeAmount;
    }

    public void setInterbankTradeAmount(BigDecimal interbankTradeAmount) {
        this.interbankTradeAmount = interbankTradeAmount;
    }

    public BigDecimal getExchangeTradeAmount() {
        return exchangeTradeAmount;
    }

    public void setExchangeTradeAmount(BigDecimal exchangeTradeAmount) {
        this.exchangeTradeAmount = exchangeTradeAmount;
    }

    public BigDecimal getTradeYieldSubCbMedian() {
        return tradeYieldSubCbMedian;
    }

    public void setTradeYieldSubCbMedian(BigDecimal tradeYieldSubCbMedian) {
        this.tradeYieldSubCbMedian = tradeYieldSubCbMedian;
    }

    public BigDecimal getBidYieldSubOfrMedian() {
        return bidYieldSubOfrMedian;
    }

    public void setBidYieldSubOfrMedian(BigDecimal bidYieldSubOfrMedian) {
        this.bidYieldSubOfrMedian = bidYieldSubOfrMedian;
    }

    public BigDecimal getBidYieldSubCbMedian() {
        return bidYieldSubCbMedian;
    }

    public void setBidYieldSubCbMedian(BigDecimal bidYieldSubCbMedian) {
        this.bidYieldSubCbMedian = bidYieldSubCbMedian;
    }

    public BigDecimal getCbYieldSubOfrMedian() {
        return cbYieldSubOfrMedian;
    }

    public void setCbYieldSubOfrMedian(BigDecimal cbYieldSubOfrMedian) {
        this.cbYieldSubOfrMedian = cbYieldSubOfrMedian;
    }

    public BigDecimal getBondBalance() {
        return bondBalance;
    }

    public void setBondBalance(BigDecimal bondBalance) {
        this.bondBalance = bondBalance;
    }

    public BigDecimal getActualIssueAmount() {
        return actualIssueAmount;
    }

    public void setActualIssueAmount(BigDecimal actualIssueAmount) {
        this.actualIssueAmount = actualIssueAmount;
    }

    public BigDecimal getIssuePrice() {
        return issuePrice;
    }

    public void setIssuePrice(BigDecimal issuePrice) {
        this.issuePrice = issuePrice;
    }

    public BigDecimal getDidIntervalLow() {
        return didIntervalLow;
    }

    public void setDidIntervalLow(BigDecimal didIntervalLow) {
        this.didIntervalLow = didIntervalLow;
    }

    public BigDecimal getDidIntervalSup() {
        return didIntervalSup;
    }

    public void setDidIntervalSup(BigDecimal didIntervalSup) {
        this.didIntervalSup = didIntervalSup;
    }

    public BigDecimal getLatestCouponRate() {
        return latestCouponRate;
    }

    public void setLatestCouponRate(BigDecimal latestCouponRate) {
        this.latestCouponRate = latestCouponRate;
    }

    public BigDecimal getLatestParValue() {
        return latestParValue;
    }

    public void setLatestParValue(BigDecimal latestParValue) {
        this.latestParValue = latestParValue;
    }

    public BigDecimal getLsScore() {
        return lsScore;
    }

    public void setLsScore(BigDecimal lsScore) {
        this.lsScore = lsScore;
    }

    public BigDecimal getConvRatio() {
        return convRatio;
    }

    public void setConvRatio(BigDecimal convRatio) {
        this.convRatio = convRatio;
    }

    public Long getInduLevel1Code() {
        return induLevel1Code;
    }

    public void setInduLevel1Code(Long induLevel1Code) {
        this.induLevel1Code = induLevel1Code;
    }

    public Long getInduLevel2Code() {
        return induLevel2Code;
    }

    public void setInduLevel2Code(Long induLevel2Code) {
        this.induLevel2Code = induLevel2Code;
    }

    public Long getProvinceUniCode() {
        return provinceUniCode;
    }

    public void setProvinceUniCode(Long provinceUniCode) {
        this.provinceUniCode = provinceUniCode;
    }

    public Long getCityUniCode() {
        return cityUniCode;
    }

    public void setCityUniCode(Long cityUniCode) {
        this.cityUniCode = cityUniCode;
    }

    public Long getUdicAreaUniCode() {
        return udicAreaUniCode;
    }

    public void setUdicAreaUniCode(Long udicAreaUniCode) {
        this.udicAreaUniCode = udicAreaUniCode;
    }

    public Long getAreaUniCode() {
        return areaUniCode;
    }

    public void setAreaUniCode(Long areaUniCode) {
        this.areaUniCode = areaUniCode;
    }

    public Long getAreaProvinceUniCode() {
        return areaProvinceUniCode;
    }

    public void setAreaProvinceUniCode(Long areaProvinceUniCode) {
        this.areaProvinceUniCode = areaProvinceUniCode;
    }

    public Long getAreaCityUniCode() {
        return areaCityUniCode;
    }

    public void setAreaCityUniCode(Long areaCityUniCode) {
        this.areaCityUniCode = areaCityUniCode;
    }

    public Long getAreaDistrictUniCode() {
        return areaDistrictUniCode;
    }

    public void setAreaDistrictUniCode(Long areaDistrictUniCode) {
        this.areaDistrictUniCode = areaDistrictUniCode;
    }

    public Long getComUniCode() {
        return comUniCode;
    }

    public void setComUniCode(Long comUniCode) {
        this.comUniCode = comUniCode;
    }

    public Long getUdicDistrictUniCode() {
        return udicDistrictUniCode;
    }

    public void setUdicDistrictUniCode(Long udicDistrictUniCode) {
        this.udicDistrictUniCode = udicDistrictUniCode;
    }

    public Long getUdicCityUniCode() {
        return udicCityUniCode;
    }

    public void setUdicCityUniCode(Long udicCityUniCode) {
        this.udicCityUniCode = udicCityUniCode;
    }

    public Long getUdicProvinceUniCode() {
        return udicProvinceUniCode;
    }

    public void setUdicProvinceUniCode(Long udicProvinceUniCode) {
        this.udicProvinceUniCode = udicProvinceUniCode;
    }

    public Long getIssueAgencyComUniCode() {
        return issueAgencyComUniCode;
    }

    public void setIssueAgencyComUniCode(Long issueAgencyComUniCode) {
        this.issueAgencyComUniCode = issueAgencyComUniCode;
    }

    public Integer getBondFilterType() {
        return bondFilterType;
    }

    public void setBondFilterType(Integer bondFilterType) {
        this.bondFilterType = bondFilterType;
    }

    public Integer getBasicBondFilterType() {
        return basicBondFilterType;
    }

    public void setBasicBondFilterType(Integer basicBondFilterType) {
        this.basicBondFilterType = basicBondFilterType;
    }

    public Integer getLocalBondType() {
        return localBondType;
    }

    public void setLocalBondType(Integer localBondType) {
        this.localBondType = localBondType;
    }

    public Integer getCorporateFinanceStatus() {
        return corporateFinanceStatus;
    }

    public void setCorporateFinanceStatus(Integer corporateFinanceStatus) {
        this.corporateFinanceStatus = corporateFinanceStatus;
    }

    public Integer getTier1Status() {
        return tier1Status;
    }

    public void setTier1Status(Integer tier1Status) {
        this.tier1Status = tier1Status;
    }

    public Integer getTier2Status() {
        return tier2Status;
    }

    public void setTier2Status(Integer tier2Status) {
        this.tier2Status = tier2Status;
    }

    public Integer getElectricityStatus() {
        return electricityStatus;
    }

    public void setElectricityStatus(Integer electricityStatus) {
        this.electricityStatus = electricityStatus;
    }

    public Integer getSteelStatus() {
        return steelStatus;
    }

    public void setSteelStatus(Integer steelStatus) {
        this.steelStatus = steelStatus;
    }

    public Integer getCoalStatus() {
        return coalStatus;
    }

    public void setCoalStatus(Integer coalStatus) {
        this.coalStatus = coalStatus;
    }

    public Integer getCementStatus() {
        return cementStatus;
    }

    public void setCementStatus(Integer cementStatus) {
        this.cementStatus = cementStatus;
    }

    public Integer getRealEstateStatus() {
        return realEstateStatus;
    }

    public void setRealEstateStatus(Integer realEstateStatus) {
        this.realEstateStatus = realEstateStatus;
    }

    public Integer getTransportStatus() {
        return transportStatus;
    }

    public void setTransportStatus(Integer transportStatus) {
        this.transportStatus = transportStatus;
    }

    public Integer getUdicStatus() {
        return udicStatus;
    }

    public void setUdicStatus(Integer udicStatus) {
        this.udicStatus = udicStatus;
    }

    public Integer getRailwayStatus() {
        return railwayStatus;
    }

    public void setRailwayStatus(Integer railwayStatus) {
        this.railwayStatus = railwayStatus;
    }

    public Integer getListedStatus() {
        return listedStatus;
    }

    public void setListedStatus(Integer listedStatus) {
        this.listedStatus = listedStatus;
    }

    public Integer getGreenBondStatus() {
        return greenBondStatus;
    }

    public void setGreenBondStatus(Integer greenBondStatus) {
        this.greenBondStatus = greenBondStatus;
    }

    public Integer getPledgeStatus() {
        return pledgeStatus;
    }

    public void setPledgeStatus(Integer pledgeStatus) {
        this.pledgeStatus = pledgeStatus;
    }

    public Integer getCrossMarketStatus() {
        return crossMarketStatus;
    }

    public void setCrossMarketStatus(Integer crossMarketStatus) {
        this.crossMarketStatus = crossMarketStatus;
    }

    public Integer getBankType() {
        return bankType;
    }

    public void setBankType(Integer bankType) {
        this.bankType = bankType;
    }

    public Integer getNcdType() {
        return ncdType;
    }

    public void setNcdType(Integer ncdType) {
        this.ncdType = ncdType;
    }

    public Integer getCouponRateFilterType() {
        return couponRateFilterType;
    }

    public void setCouponRateFilterType(Integer couponRateFilterType) {
        this.couponRateFilterType = couponRateFilterType;
    }

    public Integer getCouponRateV3FilterType() {
        return couponRateV3FilterType;
    }

    public void setCouponRateV3FilterType(Integer couponRateV3FilterType) {
        this.couponRateV3FilterType = couponRateV3FilterType;
    }

    public Integer getBondImpliedRatingMapping() {
        return bondImpliedRatingMapping;
    }

    public void setBondImpliedRatingMapping(Integer bondImpliedRatingMapping) {
        this.bondImpliedRatingMapping = bondImpliedRatingMapping;
    }

    public Integer getBondExtRatingFilterMapping() {
        return bondExtRatingFilterMapping;
    }

    public void setBondExtRatingFilterMapping(Integer bondExtRatingFilterMapping) {
        this.bondExtRatingFilterMapping = bondExtRatingFilterMapping;
    }

    public Integer getComExtRatingFilterMapping() {
        return comExtRatingFilterMapping;
    }

    public void setComExtRatingFilterMapping(Integer comExtRatingFilterMapping) {
        this.comExtRatingFilterMapping = comExtRatingFilterMapping;
    }

    public Integer getComYyRatingMapping() {
        return comYyRatingMapping;
    }

    public void setComYyRatingMapping(Integer comYyRatingMapping) {
        this.comYyRatingMapping = comYyRatingMapping;
    }

    public Integer getComYyRatingV2Mapping() {
        return comYyRatingV2Mapping;
    }

    public void setComYyRatingV2Mapping(Integer comYyRatingV2Mapping) {
        this.comYyRatingV2Mapping = comYyRatingV2Mapping;
    }

    public Integer getComYyRatingV2MappingSort() {
        return comYyRatingV2MappingSort;
    }

    public void setComYyRatingV2MappingSort(Integer comYyRatingV2MappingSort) {
        this.comYyRatingV2MappingSort = comYyRatingV2MappingSort;
    }

    public Integer getBusinessFilterNature() {
        return businessFilterNature;
    }

    public void setBusinessFilterNature(Integer businessFilterNature) {
        this.businessFilterNature = businessFilterNature;
    }

    public Integer getEmbeddedOptionStatus() {
        return embeddedOptionStatus;
    }

    public void setEmbeddedOptionStatus(Integer embeddedOptionStatus) {
        this.embeddedOptionStatus = embeddedOptionStatus;
    }

    public Integer getPerpetualStatus() {
        return perpetualStatus;
    }

    public void setPerpetualStatus(Integer perpetualStatus) {
        this.perpetualStatus = perpetualStatus;
    }

    public Integer getGuaranteedStatus() {
        return guaranteedStatus;
    }

    public void setGuaranteedStatus(Integer guaranteedStatus) {
        this.guaranteedStatus = guaranteedStatus;
    }

    public Integer getGuaranteedStatusV2() {
        return guaranteedStatusV2;
    }

    public void setGuaranteedStatusV2(Integer guaranteedStatusV2) {
        this.guaranteedStatusV2 = guaranteedStatusV2;
    }

    public Integer getUdicAdministrativeRegion() {
        return udicAdministrativeRegion;
    }

    public void setUdicAdministrativeRegion(Integer udicAdministrativeRegion) {
        this.udicAdministrativeRegion = udicAdministrativeRegion;
    }

    public Integer getBondOfferingType() {
        return bondOfferingType;
    }

    public void setBondOfferingType(Integer bondOfferingType) {
        this.bondOfferingType = bondOfferingType;
    }

    public Integer getSecondMarket() {
        return secondMarket;
    }

    public void setSecondMarket(Integer secondMarket) {
        this.secondMarket = secondMarket;
    }

    public Integer getSecondFilterMarket() {
        return secondFilterMarket;
    }

    public void setSecondFilterMarket(Integer secondFilterMarket) {
        this.secondFilterMarket = secondFilterMarket;
    }

    public Integer getCirculationStatus() {
        return circulationStatus;
    }

    public void setCirculationStatus(Integer circulationStatus) {
        this.circulationStatus = circulationStatus;
    }

    public Integer getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(Integer issueStatus) {
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

    public Integer getBusinessNature() {
        return businessNature;
    }

    public void setBusinessNature(Integer businessNature) {
        this.businessNature = businessNature;
    }

    public Integer getPublicOffering() {
        return publicOffering;
    }

    public void setPublicOffering(Integer publicOffering) {
        this.publicOffering = publicOffering;
    }

    public Integer getCouponRateType() {
        return couponRateType;
    }

    public void setCouponRateType(Integer couponRateType) {
        this.couponRateType = couponRateType;
    }

    public Integer getEmbeddedOption() {
        return embeddedOption;
    }

    public void setEmbeddedOption(Integer embeddedOption) {
        this.embeddedOption = embeddedOption;
    }

    public Integer getBondType() {
        return bondType;
    }

    public void setBondType(Integer bondType) {
        this.bondType = bondType;
    }

    public Integer getComExtRatingMapping() {
        return comExtRatingMapping;
    }

    public void setComExtRatingMapping(Integer comExtRatingMapping) {
        this.comExtRatingMapping = comExtRatingMapping;
    }

    public Integer getIntlExtRatingMapping() {
        return intlExtRatingMapping;
    }

    public void setIntlExtRatingMapping(Integer intlExtRatingMapping) {
        this.intlExtRatingMapping = intlExtRatingMapping;
    }

    public Integer getBondExtRatingMapping() {
        return bondExtRatingMapping;
    }

    public void setBondExtRatingMapping(Integer bondExtRatingMapping) {
        this.bondExtRatingMapping = bondExtRatingMapping;
    }

    public Integer getPutOptionStatus() {
        return putOptionStatus;
    }

    public void setPutOptionStatus(Integer putOptionStatus) {
        this.putOptionStatus = putOptionStatus;
    }

    public Integer getRedeemStatus() {
        return redeemStatus;
    }

    public void setRedeemStatus(Integer redeemStatus) {
        this.redeemStatus = redeemStatus;
    }

    public Integer getDefaultComStatus() {
        return defaultComStatus;
    }

    public void setDefaultComStatus(Integer defaultComStatus) {
        this.defaultComStatus = defaultComStatus;
    }

    public Integer getInterestPaymentFrequency() {
        return interestPaymentFrequency;
    }

    public void setInterestPaymentFrequency(Integer interestPaymentFrequency) {
        this.interestPaymentFrequency = interestPaymentFrequency;
    }

    public Integer getNonBankFinanceStatus() {
        return nonBankFinanceStatus;
    }

    public void setNonBankFinanceStatus(Integer nonBankFinanceStatus) {
        this.nonBankFinanceStatus = nonBankFinanceStatus;
    }

    public Integer getRemainingTenorDay() {
        return remainingTenorDay;
    }

    public void setRemainingTenorDay(Integer remainingTenorDay) {
        this.remainingTenorDay = remainingTenorDay;
    }

    public Integer getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(Integer areaLevel) {
        this.areaLevel = areaLevel;
    }

    public Integer getPlatformLevel() {
        return platformLevel;
    }

    public void setPlatformLevel(Integer platformLevel) {
        this.platformLevel = platformLevel;
    }

    public Integer getDmUdicStatus() {
        return dmUdicStatus;
    }

    public void setDmUdicStatus(Integer dmUdicStatus) {
        this.dmUdicStatus = dmUdicStatus;
    }

    public Integer getCrossMarketDedupStatus() {
        return crossMarketDedupStatus;
    }

    public void setCrossMarketDedupStatus(Integer crossMarketDedupStatus) {
        this.crossMarketDedupStatus = crossMarketDedupStatus;
    }

    public Integer getPrepaymentStatus() {
        return prepaymentStatus;
    }

    public void setPrepaymentStatus(Integer prepaymentStatus) {
        this.prepaymentStatus = prepaymentStatus;
    }

    public Integer getSecurityGeneralStatus() {
        return securityGeneralStatus;
    }

    public void setSecurityGeneralStatus(Integer securityGeneralStatus) {
        this.securityGeneralStatus = securityGeneralStatus;
    }

    public Integer getSecuritySubStatus() {
        return securitySubStatus;
    }

    public void setSecuritySubStatus(Integer securitySubStatus) {
        this.securitySubStatus = securitySubStatus;
    }

    public Integer getInsurancePerpetualStatus() {
        return insurancePerpetualStatus;
    }

    public void setInsurancePerpetualStatus(Integer insurancePerpetualStatus) {
        this.insurancePerpetualStatus = insurancePerpetualStatus;
    }

    public Integer getInsuranceSubStatus() {
        return insuranceSubStatus;
    }

    public void setInsuranceSubStatus(Integer insuranceSubStatus) {
        this.insuranceSubStatus = insuranceSubStatus;
    }

    public Integer getWithoutHolidayStatus() {
        return withoutHolidayStatus;
    }

    public void setWithoutHolidayStatus(Integer withoutHolidayStatus) {
        this.withoutHolidayStatus = withoutHolidayStatus;
    }

    public Integer getForeignBankStatus() {
        return foreignBankStatus;
    }

    public void setForeignBankStatus(Integer foreignBankStatus) {
        this.foreignBankStatus = foreignBankStatus;
    }

    public Integer getSubordinatedStatus() {
        return subordinatedStatus;
    }

    public void setSubordinatedStatus(Integer subordinatedStatus) {
        this.subordinatedStatus = subordinatedStatus;
    }

    public Integer getBondTenorDay() {
        return bondTenorDay;
    }

    public void setBondTenorDay(Integer bondTenorDay) {
        this.bondTenorDay = bondTenorDay;
    }

    public Integer getCbResourceType() {
        return cbResourceType;
    }

    public void setCbResourceType(Integer cbResourceType) {
        this.cbResourceType = cbResourceType;
    }

    public Integer getScienceTechNoteStatus() {
        return scienceTechNoteStatus;
    }

    public void setScienceTechNoteStatus(Integer scienceTechNoteStatus) {
        this.scienceTechNoteStatus = scienceTechNoteStatus;
    }

    public Integer getStiStatus() {
        return stiStatus;
    }

    public void setStiStatus(Integer stiStatus) {
        this.stiStatus = stiStatus;
    }

    public Integer getCarbonNeutralityStatus() {
        return carbonNeutralityStatus;
    }

    public void setCarbonNeutralityStatus(Integer carbonNeutralityStatus) {
        this.carbonNeutralityStatus = carbonNeutralityStatus;
    }

    public Integer getRuralRevivalStatus() {
        return ruralRevivalStatus;
    }

    public void setRuralRevivalStatus(Integer ruralRevivalStatus) {
        this.ruralRevivalStatus = ruralRevivalStatus;
    }

    public Integer getLgBondType() {
        return lgBondType;
    }

    public void setLgBondType(Integer lgBondType) {
        this.lgBondType = lgBondType;
    }

    public Integer getPandaStatus() {
        return pandaStatus;
    }

    public void setPandaStatus(Integer pandaStatus) {
        this.pandaStatus = pandaStatus;
    }

    public Integer getPandaBondStatus() {
        return pandaBondStatus;
    }

    public void setPandaBondStatus(Integer pandaBondStatus) {
        this.pandaBondStatus = pandaBondStatus;
    }

    public Integer getTradingNum() {
        return tradingNum;
    }

    public void setTradingNum(Integer tradingNum) {
        this.tradingNum = tradingNum;
    }

    public Integer getTradingDays() {
        return tradingDays;
    }

    public void setTradingDays(Integer tradingDays) {
        this.tradingDays = tradingDays;
    }

    public Integer getBidNum() {
        return bidNum;
    }

    public void setBidNum(Integer bidNum) {
        this.bidNum = bidNum;
    }

    public Integer getBidQuoteDays() {
        return bidQuoteDays;
    }

    public void setBidQuoteDays(Integer bidQuoteDays) {
        this.bidQuoteDays = bidQuoteDays;
    }

    public Integer getOfrNum() {
        return ofrNum;
    }

    public void setOfrNum(Integer ofrNum) {
        this.ofrNum = ofrNum;
    }

    public Integer getOfrQuoteDays() {
        return ofrQuoteDays;
    }

    public void setOfrQuoteDays(Integer ofrQuoteDays) {
        this.ofrQuoteDays = ofrQuoteDays;
    }

    public Integer getTwoSideQuoteDays() {
        return twoSideQuoteDays;
    }

    public void setTwoSideQuoteDays(Integer twoSideQuoteDays) {
        this.twoSideQuoteDays = twoSideQuoteDays;
    }

    public Integer getLiquidityScoreStatPeriod() {
        return liquidityScoreStatPeriod;
    }

    public void setLiquidityScoreStatPeriod(Integer liquidityScoreStatPeriod) {
        this.liquidityScoreStatPeriod = liquidityScoreStatPeriod;
    }

    public Integer getLiquidityScoreLevel() {
        return liquidityScoreLevel;
    }

    public void setLiquidityScoreLevel(Integer liquidityScoreLevel) {
        this.liquidityScoreLevel = liquidityScoreLevel;
    }

    public Integer getTlacBondStatus() {
        return tlacBondStatus;
    }

    public void setTlacBondStatus(Integer tlacBondStatus) {
        this.tlacBondStatus = tlacBondStatus;
    }

    public Integer getRateType() {
        return rateType;
    }

    public void setRateType(Integer rateType) {
        this.rateType = rateType;
    }

    public Integer getCounterBondStatus() {
        return counterBondStatus;
    }

    public void setCounterBondStatus(Integer counterBondStatus) {
        this.counterBondStatus = counterBondStatus;
    }

    public Integer getSecurityInstCpBondStatus() {
        return securityInstCpBondStatus;
    }

    public void setSecurityInstCpBondStatus(Integer securityInstCpBondStatus) {
        this.securityInstCpBondStatus = securityInstCpBondStatus;
    }

    public Integer getPolicyBankSubBondStatus() {
        return policyBankSubBondStatus;
    }

    public void setPolicyBankSubBondStatus(Integer policyBankSubBondStatus) {
        this.policyBankSubBondStatus = policyBankSubBondStatus;
    }

    public Integer getDiscountTreasuryBondStatus() {
        return discountTreasuryBondStatus;
    }

    public void setDiscountTreasuryBondStatus(Integer discountTreasuryBondStatus) {
        this.discountTreasuryBondStatus = discountTreasuryBondStatus;
    }

    public Integer getCustodyVenue() {
        return custodyVenue;
    }

    public void setCustodyVenue(Integer custodyVenue) {
        this.custodyVenue = custodyVenue;
    }

    public Integer getChinaBondCreditRatingMapping() {
        return chinaBondCreditRatingMapping;
    }

    public void setChinaBondCreditRatingMapping(Integer chinaBondCreditRatingMapping) {
        this.chinaBondCreditRatingMapping = chinaBondCreditRatingMapping;
    }

    public Integer getChinaComCreditRatingMapping() {
        return chinaComCreditRatingMapping;
    }

    public void setChinaComCreditRatingMapping(Integer chinaComCreditRatingMapping) {
        this.chinaComCreditRatingMapping = chinaComCreditRatingMapping;
    }

    public Integer getMarketMaker() {
        return marketMaker;
    }

    public void setMarketMaker(Integer marketMaker) {
        this.marketMaker = marketMaker;
    }

    public Integer getIssueAgencyTypeCode() {
        return issueAgencyTypeCode;
    }

    public void setIssueAgencyTypeCode(Integer issueAgencyTypeCode) {
        this.issueAgencyTypeCode = issueAgencyTypeCode;
    }

    public Integer getCreditBondEtfStatus() {
        return creditBondEtfStatus;
    }

    public void setCreditBondEtfStatus(Integer creditBondEtfStatus) {
        this.creditBondEtfStatus = creditBondEtfStatus;
    }

    public Integer getRateBondEtfStatus() {
        return rateBondEtfStatus;
    }

    public void setRateBondEtfStatus(Integer rateBondEtfStatus) {
        this.rateBondEtfStatus = rateBondEtfStatus;
    }

    public Integer getSciTechInnoBondEtfStatus() {
        return sciTechInnoBondEtfStatus;
    }

    public void setSciTechInnoBondEtfStatus(Integer sciTechInnoBondEtfStatus) {
        this.sciTechInnoBondEtfStatus = sciTechInnoBondEtfStatus;
    }

    public Integer getConvertibleBondEtfStatus() {
        return convertibleBondEtfStatus;
    }

    public void setConvertibleBondEtfStatus(Integer convertibleBondEtfStatus) {
        this.convertibleBondEtfStatus = convertibleBondEtfStatus;
    }

    public Integer getMaturityHoildayDay() {
        return maturityHoildayDay;
    }

    public void setMaturityHoildayDay(Integer maturityHoildayDay) {
        this.maturityHoildayDay = maturityHoildayDay;
    }

    public Integer getMaturityHolidayDayNotWeekend() {
        return maturityHolidayDayNotWeekend;
    }

    public void setMaturityHolidayDayNotWeekend(Integer maturityHolidayDayNotWeekend) {
        this.maturityHolidayDayNotWeekend = maturityHolidayDayNotWeekend;
    }

    public Integer getStiEtfStatus() {
        return stiEtfStatus;
    }

    public void setStiEtfStatus(Integer stiEtfStatus) {
        this.stiEtfStatus = stiEtfStatus;
    }

    public Integer getStiNotEtfStatus() {
        return stiNotEtfStatus;
    }

    public void setStiNotEtfStatus(Integer stiNotEtfStatus) {
        this.stiNotEtfStatus = stiNotEtfStatus;
    }

    public Integer getTaxFreeStatus() {
        return taxFreeStatus;
    }

    public void setTaxFreeStatus(Integer taxFreeStatus) {
        this.taxFreeStatus = taxFreeStatus;
    }

    public Integer getPaymentOrder() {
        return paymentOrder;
    }

    public void setPaymentOrder(Integer paymentOrder) {
        this.paymentOrder = paymentOrder;
    }

    public Integer getCallableStatus() {
        return callableStatus;
    }

    public void setCallableStatus(Integer callableStatus) {
        this.callableStatus = callableStatus;
    }

    public Integer getRiskType() {
        return riskType;
    }

    public void setRiskType(Integer riskType) {
        this.riskType = riskType;
    }

    public Integer getTaxRateMatrixType() {
        return taxRateMatrixType;
    }

    public void setTaxRateMatrixType(Integer taxRateMatrixType) {
        this.taxRateMatrixType = taxRateMatrixType;
    }

    public Integer getLargeGearScore() {
        return largeGearScore;
    }

    public void setLargeGearScore(Integer largeGearScore) {
        this.largeGearScore = largeGearScore;
    }

    public Integer getSmallGearScore() {
        return smallGearScore;
    }

    public void setSmallGearScore(Integer smallGearScore) {
        this.smallGearScore = smallGearScore;
    }

    public Integer getLsScoreShowStatus() {
        return lsScoreShowStatus;
    }

    public void setLsScoreShowStatus(Integer lsScoreShowStatus) {
        this.lsScoreShowStatus = lsScoreShowStatus;
    }

    public Integer getCouponRateF9FilterType() {
        return couponRateF9FilterType;
    }

    public void setCouponRateF9FilterType(Integer couponRateF9FilterType) {
        this.couponRateF9FilterType = couponRateF9FilterType;
    }

    public Integer getCreditBondStatus() {
        return creditBondStatus;
    }

    public void setCreditBondStatus(Integer creditBondStatus) {
        this.creditBondStatus = creditBondStatus;
    }

    public Integer getRateBondStatus() {
        return rateBondStatus;
    }

    public void setRateBondStatus(Integer rateBondStatus) {
        this.rateBondStatus = rateBondStatus;
    }

    public Integer getSciTechInnoBondStatus() {
        return sciTechInnoBondStatus;
    }

    public void setSciTechInnoBondStatus(Integer sciTechInnoBondStatus) {
        this.sciTechInnoBondStatus = sciTechInnoBondStatus;
    }

    public Integer getOutstandingStatus() {
        return outstandingStatus;
    }

    public void setOutstandingStatus(Integer outstandingStatus) {
        this.outstandingStatus = outstandingStatus;
    }

    public Integer getBondIssYear() {
        return bondIssYear;
    }

    public void setBondIssYear(Integer bondIssYear) {
        this.bondIssYear = bondIssYear;
    }

    public Integer getFundUseType() {
        return fundUseType;
    }

    public void setFundUseType(Integer fundUseType) {
        this.fundUseType = fundUseType;
    }

    public Integer getHighGrowthSectorBondStatus() {
        return highGrowthSectorBondStatus;
    }

    public void setHighGrowthSectorBondStatus(Integer highGrowthSectorBondStatus) {
        this.highGrowthSectorBondStatus = highGrowthSectorBondStatus;
    }

    public Integer getInterestCalculateMethod() {
        return interestCalculateMethod;
    }

    public void setInterestCalculateMethod(Integer interestCalculateMethod) {
        this.interestCalculateMethod = interestCalculateMethod;
    }

    public String getGuarantorFullNames() {
        return guarantorFullNames;
    }

    public void setGuarantorFullNames(String guarantorFullNames) {
        this.guarantorFullNames = guarantorFullNames;
    }

    public String getFundShortInfos() {
        return fundShortInfos;
    }

    public void setFundShortInfos(String fundShortInfos) {
        this.fundShortInfos = fundShortInfos;
    }

    public String getCrossBondCodeNameV3() {
        return crossBondCodeNameV3;
    }

    public void setCrossBondCodeNameV3(String crossBondCodeNameV3) {
        this.crossBondCodeNameV3 = crossBondCodeNameV3;
    }

    public String getExerciseDateList() {
        return exerciseDateList;
    }

    public void setExerciseDateList(String exerciseDateList) {
        this.exerciseDateList = exerciseDateList;
    }

    public String getCalcFutureExerciseDate() {
        return calcFutureExerciseDate;
    }

    public void setCalcFutureExerciseDate(String calcFutureExerciseDate) {
        this.calcFutureExerciseDate = calcFutureExerciseDate;
    }

    public String getCalcHistoryExerciseDate() {
        return calcHistoryExerciseDate;
    }

    public void setCalcHistoryExerciseDate(String calcHistoryExerciseDate) {
        this.calcHistoryExerciseDate = calcHistoryExerciseDate;
    }

    public String getContentHash() {
        return contentHash;
    }

    public void setContentHash(String contentHash) {
        this.contentHash = contentHash;
    }

    public String getUpdateByDis() {
        return updateByDis;
    }

    public void setUpdateByDis(String updateByDis) {
        this.updateByDis = updateByDis;
    }
}
