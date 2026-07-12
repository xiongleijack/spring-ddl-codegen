package com.example.spider.model.dto.response;

import java.sql.Date;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import io.swagger.annotations.ApiModelProperty;

/**
 * 境内债券筛选V3宽表（旧onshore_bond_filter超集+F9/DeepInfo/list复刻字段），每个bondUniCode一行，软删，update_time为增量游标表Page对象 {@link OnshoreBondFilterV5DO}
 *
 * @author xionglei
 */
public class OnshoreBondFilterV5PageDTO {

    @ApiModelProperty("主键。[V5:SYSTEM_LATEST] anchor=contentHash; value=null; source=system:OnshoreBondFilterV5ServiceImpl#saveLatestWithContentGate; fields=system auto id/content gate copy id null")
    private Long id;

    @ApiModelProperty("债券统一编码。[V5:BUSINESS_KEY] anchor=getOnshoreBondFilterV5Info; value=filterBO.getBondUniCode(); source=table:t_bond_basic_info; fields=bond_uni_code; via=BondBasicInfoDAO#listBondFilterBO")
    private Long bondUniCode;

    @ApiModelProperty("债券ID。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getBondId(); source=table:t_bond_basic_info; fields=bond_id; via=BondBasicInfoDAO#listBondShortInfoByUniCodes")
    private Long bondId;

    @ApiModelProperty("债券代码。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getBondCode(); source=table:t_bond_basic_info; fields=bond_code; via=BondBasicInfoDAO#listBondShortInfoByUniCodes")
    private String bondCode;

    @ApiModelProperty("债券简称。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getBondShortName(); source=table:t_bond_basic_info; fields=bond_short_name; via=BondBasicInfoDAO#listBondShortInfoByUniCodes")
    private String bondShortName;

    @ApiModelProperty("YY主体评级V2（字符串，映射值见 com_yy_rating_v2_mapping）。[V5:RATING] anchor=getOnshoreBondFilterV5Info; value=yyRatingEnum.map(YyRatingEnum::getText).orElse(null); source=BondRatingHttpService#listComLatestRating; path:POST /internal/com/comLatestRating/get")
    private String comYyRatingV2;

    @ApiModelProperty("债券隐含评级 取值：AAA+;AAA;AAA-;AA+;AA;AA(2);AA-（数值映射见 bond_implied_rating_mapping）。[V5:RATING] anchor=getOnshoreBondFilterV5Info; value=RatingUtils.getRating(bondLatestRatingDTO != null ? bondLatestRatingDTO.getImpliedRatingMapping() : null); source=BondRatingHttpService#listComLatestRating; path:POST /internal/com/comLatestRating/get")
    private String bondImpliedRating;

    @ApiModelProperty("债券外部评级筛选 取值：AAA;AA+;AA;AA-;A+;--（数值映射见 bond_ext_rating_filter_mapping）。[V5:RATING] anchor=getOnshoreBondFilterV5Info; value=RatingUtils.getRating(bondLatestRatingDTO != null ? bondLatestRatingDTO.getExtCreditRatingMapping() : null); source=BondRatingHttpService#listComLatestRating; path:POST /internal/com/comLatestRating/get")
    private String bondExtRating;

    @ApiModelProperty("主体外部评级筛选 取值：AAA;AA+;AA;AA-;A+;--（数值映射见 com_ext_rating_filter_mapping）。[V5:RATING] anchor=getOnshoreBondFilterV5Info; value=RatingUtils.getRating(comLatestRatingDTO != null ? comLatestRatingDTO.getExtCreditRatingMapping() : null); source=BondRatingHttpService#listComLatestRating; path:POST /internal/com/comLatestRating/get")
    private String comExtRating;

    @ApiModelProperty("主体简称（发行人简称）。[V5:COM_INFO] anchor=applyLegacyOnlyV3BatchFields; value=comShortInfoDTO.getComShortName(); source=ComInfoHttpService#listComShortInfoDTO; path:POST /internal/com/info/short/getByUnicode")
    private String comShortName;

    @ApiModelProperty("主体全称（发行人全称）。[V5:COM_INFO] anchor=applyLegacyOnlyV3BatchFields; value=comShortInfoDTO.getComFullName(); source=ComInfoHttpService#listComShortInfoDTO; path:POST /internal/com/info/short/getByUnicode")
    private String comFullName;

    @ApiModelProperty("剩余期限（字符串，天数见 remaining_tenor_day）。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getRemainingTenor(); source=table:t_bond_basic_info; fields=remaining_tenor; via=BondBasicInfoDAO#listBondShortInfoByUniCodes")
    private String remainingTenor;

    @ApiModelProperty("城投二级行业名称。[V5:URBAN_AREA] anchor=getOnshoreBondFilterV5Info; value=udicComInfoForBasicDTO.getInduLevel2Name(); source=ComInfoHttpService#listUrbanAreaInfoDTO; path:POST /internal/urban/com/areaInfo/getByComUniCode")
    private String udicInduLevel2Name;

    @ApiModelProperty("债券期限（字符串，天数见 bond_tenor_day）。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getBondTenor(); source=table:t_bond_primary_info; fields=bond_matu_des; via=BondBasicInfoDAO#listBondShortInfoBO")
    private String bondTenor;

    @ApiModelProperty("中债资信债券评级 取值：AAA+,AAA,AAA-,AA+,AA,其他,无评级（数值映射见 china_bond_credit_rating_mapping）。[V5:RATING] anchor=getOnshoreBondFilterV5Info; value=chinaBondRatingMappingEnum.getText(); source=BondRatingHttpService#listComLatestRating; path:POST /internal/com/comLatestRating/get")
    private String chinaBondCreditRating;

    @ApiModelProperty("中债资信主体评级 取值：AAA+,AAA,AAA-,AA+,AA,其他,无评级（数值映射见 china_com_credit_rating_mapping）。[V5:RATING] anchor=getOnshoreBondFilterV5Info; value=chinaComRatingMappingEnum.getText(); source=BondRatingHttpService#listComLatestRating; path:POST /internal/com/comLatestRating/get")
    private String chinaComCreditRating;

    @ApiModelProperty("债券承销商（发行机构）主体全称。[V5:ISSUE_INFO] anchor=getOnshoreBondFilterV5Info; value=bondIssueAgencyInfoDTO.getComFullName(); source=BondPrimaryInfoV5DAO#listByBondUniCodes; path:POST /internal/bond-issue-agency/listOnshoreBondIssueAgency")
    private String issueAgencyComFullName;

    @ApiModelProperty("流动性大档评分描述（字符串，数值见 large_gear_score）。[V5:LIQUIDITY_BASE] anchor=applyLiquidityBaseFields; value=EnumUtils.getEnumByValue(liquidityBondBaseDTO.getLargeGearScore(), LiquidityLargeGearScoreEnum.class) .map(ITextValueEnum::getText).orElse(null); source=LiquidityScoreHttpService#listBondLiquidityScore; path:POST /internal/ls/data/bond/base/list")
    private String largeGearScoreDesc;

    @ApiModelProperty("流动性小档评分描述（字符串，数值见 small_gear_score）。[V5:LIQUIDITY_BASE] anchor=applyLiquidityBaseFields; value=EnumUtils.getEnumByValue(liquidityBondBaseDTO.getSmallGearScore(), LiquiditySmallGearScoreEnum.class) .map(ITextValueEnum::getText).orElse(null); source=LiquidityScoreHttpService#listBondLiquidityScore; path:POST /internal/ls/data/bond/base/list")
    private String smallGearScoreDesc;

    @ApiModelProperty("浮息基准（浮动利率基准）。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getBaseRatePar(); source=table:t_bond_basic_info; fields=base_rate_par; via=BondBasicInfoDAO#listBondShortInfoByUniCodes")
    private String baseRatePar;

    @ApiModelProperty("债券信用级别（取自 rating 服务）。[V5:RATING] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getBondCredLevel(); source=BondRatingHttpService#listComLatestRating; path:POST /internal/com/comLatestRating/get")
    private String bondCredLevel;

    @ApiModelProperty("发行人（主体）信用级别（取自 rating 服务）。[V5:RATING] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getComCredLevel(); source=BondRatingHttpService#listComLatestRating; path:POST /internal/com/comLatestRating/get")
    private String comCredLevel;

    @ApiModelProperty("最新行权日（字符串）。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=Objects.isNull(defaultOnshoreBondInfo.getLatestExerciseDate()) ? defaultOnshoreBondInfo.getOriginExerciseDate() : DateExtensionUtils.format(defaultOnshoreBondInfo.getLatestExerciseDate(), DateExtensionUtils.FORMAT_DATE_SIMPLE); source=calc:BondBasicInfoDAO#getLatestExerciseDate; fields=t_bond_basic_info.exer_pay_date")
    private String latestExerciseDate;

    @ApiModelProperty("债券类型展示名称。由 BondType.getText() 映射。[V5:DISPLAY_NAME_COMPUTED] anchor=fillReplicatedFields; value=BondType.getBondType(v5do.getBondType()).map(BondType::getText).orElse(null); source=calc:OnshoreBondFilterV5ServiceImpl#fillReplicatedFields; fields=v5do.bondType<-t_bond_basic_info.bond_type_par; enum=BondType")
    private String displayBondType;

    @ApiModelProperty("企业性质展示名称。由 BusinessNatureEnum.getText() 映射。[V5:COM_INFO] anchor=fillReplicatedFields; value=BusinessNatureEnum.getText(v5do.getBusinessNature()); source=ComInfoHttpService#listComShortInfoDTO; path:POST /internal/com/info/short/getByUnicode")
    private String displayBusinessNature;

    @ApiModelProperty("付息频率展示名称。由 InterestPaymentFrequencyEnum.getText() 映射。[V5:DISPLAY_NAME_COMPUTED] anchor=fillReplicatedFields; value=InterestPaymentFrequencyEnum.getText(v5do.getInterestPaymentFrequency()); source=calc:OnshoreBondFilterV5ServiceImpl#fillReplicatedFields; fields=v5do.interestPaymentFrequency<-OnshoreBondInfoDTO.intePayFreq; enum=InterestPaymentFrequencyEnum")
    private String displayInterestPaymentFrequency;

    @ApiModelProperty("利率类型展示名称。由 OnshoreRateTypeEnum.getText() 映射。[V5:DISPLAY_NAME_COMPUTED] anchor=fillReplicatedFields; value=EnumUtils.getEnumByValue(v5do.getCouponRateType(), OnshoreRateTypeEnum.class) .map(OnshoreRateTypeEnum::getText).orElse(null); source=calc:OnshoreBondFilterV5ServiceImpl#fillReplicatedFields; fields=v5do.couponRateType<-t_bond_basic_info.rate_type_par; enum=OnshoreRateTypeEnum")
    private String displayRateType;

    @ApiModelProperty("币种名称，兼容 BondInfoViewNameDTO。[V5:DISPLAY_NAME_COMPUTED] anchor=getOnshoreBondFilterV5Info; value=filterBO.getCurrencyName(); source=table:t_bond_basic_info; fields=cury_type_par; via=BondBasicInfoDAO#listBondFilterBO/CurrencyTypeMapper")
    private String currencyName;

    @ApiModelProperty("担保情况名称，兼容 BondInfoViewNameDTO。[V5:PARTY_ENRICH] anchor=getOnshoreBondFilterV5Info; value=filterBO.getGuaranteeName(); source=ComInfoHttpService#listComRelatedPartyByUniCodes; path:POST /internal/com/related/party/getByUnicode")
    private String guaranteeName;

    @ApiModelProperty("募集方式名称，兼容 BondInfoViewNameDTO。[V5:DISPLAY_NAME_COMPUTED] anchor=getOnshoreBondFilterV5Info; value=filterBO.getPublicOfferingName(); source=table:t_bond_basic_info; fields=is_public_iss; via=BondBasicInfoDAO#getPublicOffering")
    private String publicOfferingName;

    @ApiModelProperty("利率类型名称，兼容 BondInfoViewNameDTO。[V5:DISPLAY_NAME_COMPUTED] anchor=getOnshoreBondFilterV5Info; value=filterBO.getRateTypeName(); source=table:t_bond_basic_info; fields=rate_type_par; via=BondBasicInfoDAO#getOnshoreRateTypeEnum")
    private String rateTypeName;

    @ApiModelProperty("含权条款名称，兼容 BondInfoViewNameDTO。[V5:DISPLAY_NAME_COMPUTED] anchor=getOnshoreBondFilterV5Info; value=filterBO.getEmbeddedOptionName(); source=table:t_broker_filter; fields=provision; via=BondBasicInfoDAO#getEmbeddedEnum")
    private String embeddedOptionName;

    @ApiModelProperty("债券类型名称，兼容 BondInfoViewNameDTO。[V5:DISPLAY_NAME_COMPUTED] anchor=getOnshoreBondFilterV5Info; value=filterBO.getBondTypeName(); source=table:t_bond_basic_info; fields=bond_type_par; enum=BondType")
    private String bondTypeName;

    @ApiModelProperty("注册地城市名称，兼容 BondInfoViewNameDTO。[V5:COM_INFO] anchor=applyComShortInfoDerivedFields; value=comShortInfoDTO.getCityName(); source=ComInfoHttpService#listComShortInfoDTO; path:POST /internal/com/info/short/getByUnicode")
    private String cityName;

    @ApiModelProperty("城投区域级别名称，兼容 BondInfoViewNameDTO。[V5:URBAN_AREA] anchor=getOnshoreBondFilterV5Info; value=urbanAreaInfoDTO.getUrbanAreaLevelName(); source=ComInfoHttpService#listUrbanAreaInfoDTO; path:POST /internal/urban/com/areaInfo/getByComUniCode")
    private String urbanAreaLevelName;

    @ApiModelProperty("城投区域名称，兼容 BondInfoViewNameDTO。[V5:URBAN_AREA] anchor=getOnshoreBondFilterV5Info; value=urbanAreaInfoDTO.getUrbanAreaName(); source=ComInfoHttpService#listUrbanAreaInfoDTO; path:POST /internal/urban/com/areaInfo/getByComUniCode")
    private String urbanAreaName;

    @ApiModelProperty("城投城市名称，兼容 BondInfoViewNameDTO。[V5:URBAN_AREA] anchor=getOnshoreBondFilterV5Info; value=urbanAreaInfoDTO.getUrbanCityName(); source=ComInfoHttpService#listUrbanAreaInfoDTO; path:POST /internal/urban/com/areaInfo/getByComUniCode")
    private String urbanCityName;

    @ApiModelProperty("城投省份名称，兼容 BondInfoViewNameDTO。[V5:URBAN_AREA] anchor=getOnshoreBondFilterV5Info; value=urbanAreaInfoDTO.getUrbanProvinceName(); source=ComInfoHttpService#listUrbanAreaInfoDTO; path:POST /internal/urban/com/areaInfo/getByComUniCode")
    private String urbanProvinceName;

    @ApiModelProperty("企业性质名称，兼容 BondInfoViewNameDTO。[V5:COM_INFO] anchor=applyComShortInfoDerivedFields; value=BusinessNatureEnum.getText(comShortInfoDTO.getBusinessNature()); source=ComInfoHttpService#listComShortInfoDTO; path:POST /internal/com/info/short/getByUnicode")
    private String businessNatureName;

    @ApiModelProperty("主体外部评级机构名称，兼容 BondInfoViewNameDTO。[V5:RATING] anchor=getOnshoreBondFilterV5Info; value=comLatestRatingDTO != null ? comLatestRatingDTO.getExtCreditRatingComName() : null; source=BondRatingHttpService#listComLatestRating; path:POST /internal/com/comLatestRating/get")
    private String comExtRatingComName;

    @ApiModelProperty("海外主体评级，兼容 BondInfoViewNameDTO。[V5:RATING] anchor=getOnshoreBondFilterV5Info; value=comLatestRatingDTO != null ? comLatestRatingDTO.getIntlExtCreditRating() : null; source=BondRatingHttpService#listComLatestRating; path:POST /internal/com/comLatestRating/get")
    private String intlExtRating;

    @ApiModelProperty("海外主体评级机构名称，兼容 BondInfoViewNameDTO。[V5:RATING] anchor=getOnshoreBondFilterV5Info; value=comLatestRatingDTO != null ? comLatestRatingDTO.getIntlExtCreditRatingComName() : null; source=BondRatingHttpService#listComLatestRating; path:POST /internal/com/comLatestRating/get")
    private String intlExtRatingComName;

    @ApiModelProperty("债券外部评级机构名称，兼容 BondInfoViewNameDTO。[V5:RATING] anchor=getOnshoreBondFilterV5Info; value=bondLatestRatingDTO != null ? bondLatestRatingDTO.getExtCreditRatingComName() : null; source=BondRatingHttpService#listComLatestRating; path:POST /internal/com/comLatestRating/get")
    private String bondExtRatingComName;

    @ApiModelProperty("担保人全称，兼容 BondInfoViewNameDTO。[V5:PARTY_ENRICH] anchor=getOnshoreBondFilterV5Info; value=filterBO.getGuarantorFullName(); source=ComInfoHttpService#listComRelatedPartyByUniCodes; path:POST /internal/com/related/party/getByUnicode")
    private String guarantorFullName;

    @ApiModelProperty("上市日。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=filterBO.getListDate() != null ? new java.sql.Date(filterBO.getListDate().getTime()) : null; source=table:t_bond_basic_info; fields=list_date; via=BondBasicInfoDAO#listBondFilterBO")
    private Date listDate;

    @ApiModelProperty("到期日（日历）：优先取 latest_exercise_date，无行权日时取 maturity_date。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=Objects.nonNull(defaultOnshoreBondInfo.getLatestExerciseDate()) ? defaultOnshoreBondInfo.getLatestExerciseDate() : defaultOnshoreBondInfo.getMaturityDate(); source=calc:OnshoreBondFilterV5ServiceImpl#maturityDateCalendar; fields=t_bond_basic_info.exer_pay_date/actu_end_date")
    private Date maturityDateCalendar;

    @ApiModelProperty("发行起始日。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getIssueStartDate(); source=table:t_bond_basic_info; fields=iss_start_date; via=BondBasicInfoDAO#listBondShortInfoByUniCodes")
    private Date issueStartDate;

    @ApiModelProperty("发行结束日。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getIssueEndDate(); source=table:t_bond_basic_info; fields=iss_end_date; via=BondBasicInfoDAO#listBondShortInfoByUniCodes")
    private Date issueEndDate;

    @ApiModelProperty("起息日（源:t_bond_basic_info#inte_start_date）。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getInterestStartDate(); source=table:t_bond_basic_info; fields=inte_start_date; via=BondBasicInfoDAO#listBondShortInfoByUniCodes")
    private Date interestStartDate;

    @ApiModelProperty("到期日（源:t_bond_basic_info#actu_end_date）。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getMaturityDate(); source=table:t_bond_basic_info; fields=actu_end_date; via=BondBasicInfoDAO#listBondShortInfoByUniCodes")
    private Date maturityDate;

    @ApiModelProperty("计算用最新行权日。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getCalcLatestExerciseDate(); source=calc:BondBasicInfoDAO#parseCalcLatestExerciseDate; fields=t_bond_basic_info.exer_pay_date")
    private Date calcLatestExerciseDate;

    @ApiModelProperty("实际摘牌日。由 calculateActuDelistDate 计算。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=calculateActuDelistDate(defaultOnshoreBondInfo.getTheoDelistDate(), defaultOnshoreBondInfo.getActuDelistDate(), defaultOnshoreBondInfo.getMaturityDate(), basicBondFilterType, riskType); source=calc:OnshoreBondFilterV5ServiceImpl#calculateActuDelistDate; fields=t_bond_basic_info.theo_delist_date/actu_delist_date/actu_end_date")
    private Date actuDelistDate;

    @ApiModelProperty("债权登记日。来源 bond_basic_info.debt_reg_date。[V5:BASIC_PHYSICAL_TABLE] anchor=fillReplicatedFields; value=toSqlDate(bondBasicInfoDO.getDebtRegDate()); source=table:t_bond_basic_info; fields=coll_cap_purp/ref_yield/debt_reg_date/guaranteed_settlement_status/actu_iss_amut")
    private Date debtRegDate;

    @ApiModelProperty("理论摘牌日。来源 defaultOnshoreBondInfo.theoDelistDate。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=fillReplicatedFields; value=new java.sql.Date(defaultOnshoreBondInfo.getTheoDelistDate().getTime()); source=table:t_bond_basic_info; fields=theo_delist_date; via=BondBasicInfoDAO#listBondShortInfoByUniCodes")
    private Date theoDelistDate;

    @ApiModelProperty("最后交易日。来源 defaultOnshoreBondInfo.lastTradeDate。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=fillReplicatedFields; value=new java.sql.Date(defaultOnshoreBondInfo.getLastTradeDate().getTime()); source=table:t_bond_basic_info; fields=last_trade_date; via=BondBasicInfoDAO#listBondShortInfoByUniCodes")
    private Date lastTradeDate;

    @ApiModelProperty("换手率。[V5:LIQUIDITY_STAT] anchor=fillLiquidityScore; value=liquidityScoreIndexStatDTO.getTurnoverRate(); source=BondPriceApolloHttpService#listLiquidityScoreIndexStatDTOs; path:POST /internal/liquidity-score/list/stat")
    private BigDecimal turnoverRate;

    @ApiModelProperty("CFETS(银行间)成交量(亿)。[V5:LIQUIDITY_STAT] anchor=fillLiquidityScore; value=liquidityScoreIndexStatDTO.getInterbankTradeAmount(); source=BondPriceApolloHttpService#listLiquidityScoreIndexStatDTOs; path:POST /internal/liquidity-score/list/stat")
    private BigDecimal interbankTradeAmount;

    @ApiModelProperty("交易所成交量(万)。[V5:LIQUIDITY_STAT] anchor=fillLiquidityScore; value=liquidityScoreIndexStatDTO.getExchangeTradeAmount(); source=BondPriceApolloHttpService#listLiquidityScoreIndexStatDTOs; path:POST /internal/liquidity-score/list/stat")
    private BigDecimal exchangeTradeAmount;

    @ApiModelProperty("成交偏离中值(BP)：成交收益率减中债中位数。[V5:LIQUIDITY_STAT] anchor=fillLiquidityScore; value=liquidityScoreIndexStatDTO.getTradeYieldSubCbMedian(); source=BondPriceApolloHttpService#listLiquidityScoreIndexStatDTOs; path:POST /internal/liquidity-score/list/stat")
    private BigDecimal tradeYieldSubCbMedian;

    @ApiModelProperty("双边利差中值(BP)：bid收益率减ofr。[V5:LIQUIDITY_STAT] anchor=fillLiquidityScore; value=liquidityScoreIndexStatDTO.getBidYieldSubOfrMedian(); source=BondPriceApolloHttpService#listLiquidityScoreIndexStatDTOs; path:POST /internal/liquidity-score/list/stat")
    private BigDecimal bidYieldSubOfrMedian;

    @ApiModelProperty("bid中债偏离中值(BP)：bid收益率减中债。[V5:LIQUIDITY_STAT] anchor=fillLiquidityScore; value=liquidityScoreIndexStatDTO.getBidYieldSubCbMedian(); source=BondPriceApolloHttpService#listLiquidityScoreIndexStatDTOs; path:POST /internal/liquidity-score/list/stat")
    private BigDecimal bidYieldSubCbMedian;

    @ApiModelProperty("ofr偏离中值(BP)：中债收益率减ofr。[V5:LIQUIDITY_STAT] anchor=fillLiquidityScore; value=liquidityScoreIndexStatDTO.getCbYieldSubOfrMedian(); source=BondPriceApolloHttpService#listLiquidityScoreIndexStatDTOs; path:POST /internal/liquidity-score/list/stat")
    private BigDecimal cbYieldSubOfrMedian;

    @ApiModelProperty("债券余额(单位:亿，标准单位)。[V5:BALANCE_SCALE] anchor=applyFilterBondBalance; value=Objects.nonNull(balanceWan) ? balanceWan.multiply(WAN_AND_BILLION_CONVERT_RATIO) : null; source=table:t_bond_basic_info; fields=new_size")
    private BigDecimal bondBalance;

    @ApiModelProperty("债券余额(单位:万，兼容旧filter表)。[V5:BALANCE_SCALE] anchor=applyFilterBondBalance; value=balanceWan; source=table:t_bond_basic_info; fields=new_size")
    private BigDecimal bondBalanceTenK;

    @ApiModelProperty("实际发行金额(默认:亿)。[V5:BASIC_PHYSICAL_TABLE] anchor=OnshoreBondInfoDTO; value=BigDecimalUtils.safeMultiply(info.getActualIssueAmount(), WAN_AND_BILLION_CONVERT_RATIO).orElse(null); source=table:t_bond_basic_info; fields=coll_cap_purp/ref_yield/debt_reg_date/guaranteed_settlement_status/actu_iss_amut")
    private BigDecimal actualIssueAmount;

    @ApiModelProperty("发行价格(单位:元)。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getIssuePrice(); source=table:t_bond_basic_info; fields=iss_pri; via=BondBasicInfoDAO#listBondShortInfoByUniCodes")
    private BigDecimal issuePrice;

    @ApiModelProperty("招标区间下限(源:t_bond_primary_info#did_interval_low)。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getDidIntervalLow(); source=table:t_bond_primary_info; fields=did_interval_low; via=BondBasicInfoDAO#listBondShortInfoBO")
    private BigDecimal didIntervalLow;

    @ApiModelProperty("招标区间上限(源:t_bond_primary_info#did_interval_sup)。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getDidIntervalSup(); source=table:t_bond_primary_info; fields=did_interval_sup; via=BondBasicInfoDAO#listBondShortInfoBO")
    private BigDecimal didIntervalSup;

    @ApiModelProperty("最新票面利率。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=filterBO.getLatestCouponRate(); source=calc:BondBasicInfoDAO#getLatestCouponRate; fields=t_bond_basic_info.new_coup_rate/ref_yield")
    private BigDecimal latestCouponRate;

    @ApiModelProperty("最新票面值。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getLatestParValue(); source=calc:BondBasicInfoDAO#listBondShortInfoBO; fields=t_bond_basic_info.bond_par_val + bond_cash_flow_chart.inte_pay_end")
    private BigDecimal latestParValue;

    @ApiModelProperty("流动性评分值 S+:100 S:95 S-:90 A+:85 A:80 A-:70 B+:60 B:55 B-:50 C+:35 C:30 C-:25 D+:10 D:5 D-:3 E:0（是否展示见 ls_score_show_status）。[V5:LIQUIDITY_BASE] anchor=applyLiquidityBaseFields; value=liquidityBondBaseDTO.getScore(); source=LiquidityScoreHttpService#listBondLiquidityScore; path:POST /internal/ls/data/bond/base/list")
    private BigDecimal lsScore;

    @ApiModelProperty("质押率(转股比例)。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=filterBO.getConvRatio(); source=table:t_bond_conv_ratio; fields=conv_ratio/start_date/end_date; via=TBondConvRatioDAO#listEligibleConvRatios")
    private BigDecimal convRatio;

    @ApiModelProperty("一级行业编码。[V5:COM_INFO] anchor=applyComShortInfoDerivedFields; value=induLevel1Code; source=ComInfoHttpService#listComShortInfoDTO; path:POST /internal/com/info/short/getByUnicode")
    private Long induLevel1Code;

    @ApiModelProperty("二级行业编码。[V5:COM_INFO] anchor=applyComShortInfoDerivedFields; value=induLevel2Code; source=ComInfoHttpService#listComShortInfoDTO; path:POST /internal/com/info/short/getByUnicode")
    private Long induLevel2Code;

    @ApiModelProperty("省份编码。[V5:COM_INFO] anchor=applyComShortInfoDerivedFields; value=comShortInfoDTO.getProvinceUniCode(); source=ComInfoHttpService#listComShortInfoDTO; path:POST /internal/com/info/short/getByUnicode")
    private Long provinceUniCode;

    @ApiModelProperty("地级市编码。[V5:COM_INFO] anchor=applyComShortInfoDerivedFields; value=comShortInfoDTO.getCityUniCode(); source=ComInfoHttpService#listComShortInfoDTO; path:POST /internal/com/info/short/getByUnicode")
    private Long cityUniCode;

    @ApiModelProperty("城投(实际控制人)区域编码。[V5:URBAN_AREA] anchor=getOnshoreBondFilterV5Info; value=urbanArea; source=ComInfoHttpService#listUrbanAreaInfoDTO; path:POST /internal/urban/com/areaInfo/getByComUniCode")
    private Long udicAreaUniCode;

    @ApiModelProperty("区域编码：udicAreaUniCode!=0取之；为0但cityUniCode!=0取cityUniCode；均为0取provinceUniCode。[V5:URBAN_AREA] anchor=getOnshoreBondFilterV5Info; value=areaUniCode != null ? areaUniCode : 0L; source=ComInfoHttpService#listUrbanAreaInfoDTO; path:POST /internal/urban/com/areaInfo/getByComUniCode")
    private Long areaUniCode;

    @ApiModelProperty("由 area_uni_code 反查关联的省编码。[V5:URBAN_AREA] anchor=getOnshoreBondFilterV5Info; value=areaInfoResponseDTO.getProvinceUniCode() != null ? areaInfoResponseDTO.getProvinceUniCode() : comShortInfoDTO.getProvinceUniCode(); source=ComInfoHttpService#listUrbanAreaInfoDTO; path:POST /internal/urban/com/areaInfo/getByComUniCode")
    private Long areaProvinceUniCode;

    @ApiModelProperty("由 area_uni_code 反查关联的市编码。[V5:URBAN_AREA] anchor=getOnshoreBondFilterV5Info; value=areaInfoResponseDTO.getCityUniCode(); source=ComInfoHttpService#listUrbanAreaInfoDTO; path:POST /internal/urban/com/areaInfo/getByComUniCode")
    private Long areaCityUniCode;

    @ApiModelProperty("由 area_uni_code 反查关联的区县编码。[V5:URBAN_AREA] anchor=getOnshoreBondFilterV5Info; value=areaInfoResponseDTO.getDistrictUniCode(); source=ComInfoHttpService#listUrbanAreaInfoDTO; path:POST /internal/urban/com/areaInfo/getByComUniCode")
    private Long areaDistrictUniCode;

    @ApiModelProperty("主体唯一编码。[V5:BUSINESS_KEY] anchor=getOnshoreBondFilterV5Info; value=comUniCode; source=table:t_bond_basic_info; fields=com_uni_code; via=BondBasicInfoDAO#listBondFilterBO")
    private Long comUniCode;

    @ApiModelProperty("城投(实际控制人)区县编码。[V5:URBAN_AREA] anchor=getOnshoreBondFilterV5Info; value=urbanArea; source=ComInfoHttpService#listUrbanAreaInfoDTO; path:POST /internal/urban/com/areaInfo/getByComUniCode")
    private Long udicDistrictUniCode;

    @ApiModelProperty("城投(实际控制人)城市编码。[V5:URBAN_AREA] anchor=getOnshoreBondFilterV5Info; value=urbanCity; source=ComInfoHttpService#listUrbanAreaInfoDTO; path:POST /internal/urban/com/areaInfo/getByComUniCode")
    private Long udicCityUniCode;

    @ApiModelProperty("城投(实际控制人)省份编码。[V5:URBAN_AREA] anchor=getOnshoreBondFilterV5Info; value=urbanProvince; source=ComInfoHttpService#listUrbanAreaInfoDTO; path:POST /internal/urban/com/areaInfo/getByComUniCode")
    private Long udicProvinceUniCode;

    @ApiModelProperty("债券承销商（发行机构）唯一编码。[V5:ISSUE_INFO] anchor=getOnshoreBondFilterV5Info; value=bondIssueAgencyInfoDTO.getComUniCode(); source=BondPrimaryInfoV5DAO#listByBondUniCodes; path:POST /internal/bond-issue-agency/listOnshoreBondIssueAgency")
    private Long issueAgencyComUniCode;

    @ApiModelProperty("债券筛选类型 BondFilterTypeEnum：利率/信用/NCD/ABS/其他999。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=getPriceBondFilterType(bondType, comUniCode, bankType, businessFilterNature, basicBondFilterType); source=calc:OnshoreBondFilterV5ServiceImpl#getPriceBondFilterType; fields=t_bond_basic_info.bond_type_par/sec_mar_par/is_public_iss/cury_type_par + ComShortInfoDTO.bankType/businessFilterNature + basic_bond_filter_type")
    private Integer bondFilterType;

    @ApiModelProperty("债券筛选类型 同 bond_basic.onshore_bond_filter.bond_filter_type。[V5:LEGACY_ALIAS] anchor=getOnshoreBondFilterV5Info; value=basicBondFilterType; source=alias:bond_filter_type(old-filter large category); fields=basicBondFilterType<-BondFilterTypeEnum from t_bond_basic_info.bond_type_par/sec_mar_par/is_public_iss/cury_type_par")
    private Integer basicBondFilterType;

    @ApiModelProperty("地方债类型 1:一般地方债 2:地方专项债。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=this.getLocalBondType(defaultOnshoreBondInfo); source=calc:OnshoreBondFilterV5ServiceImpl#getLocalBondType; fields=OnshoreBondInfoDTO.bondType/bondFullName <- t_bond_basic_info.bond_type_par/bond_full_name")
    private Integer localBondType;

    @ApiModelProperty("是否商金债 0:否 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=this.getCorporateFinanceStatus(bondType, embeddedOption); source=calc:OnshoreBondFilterV5ServiceImpl#getCorporateFinanceStatus; fields=bondType<-t_bond_basic_info.bond_type_par; embeddedOption<-t_broker_filter.provision")
    private Integer corporateFinanceStatus;

    @ApiModelProperty("是否银行永续债 0:否 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=this.getTier1Status(bondType, embeddedOption); source=calc:OnshoreBondFilterV5ServiceImpl#getTier1Status; fields=bondType<-t_bond_basic_info.bond_type_par; embeddedOption<-t_broker_filter.provision")
    private Integer tier1Status;

    @ApiModelProperty("是否二级资本债 0:否 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=this.getTier2Status(bondType, embeddedOption); source=calc:OnshoreBondFilterV5ServiceImpl#getTier2Status; fields=bondType<-t_bond_basic_info.bond_type_par; embeddedOption<-t_broker_filter.provision")
    private Integer tier2Status;

    @ApiModelProperty("是否电力 0:否 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=applyLegacyOnlyV3BatchFields; value=this.getInduStatus(InduGeneralFilterEnum.ELECTRICITY, oldRow.getInduLevel2Code()); source=calc:OnshoreBondFilterV5ServiceImpl#getInduStatus; fields=ComShortInfoDTO.induLevel2Code")
    private Integer electricityStatus;

    @ApiModelProperty("是否钢铁 0:否 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=applyLegacyOnlyV3BatchFields; value=this.getInduStatus(InduGeneralFilterEnum.STEEL, oldRow.getInduLevel1Code()); source=calc:OnshoreBondFilterV5ServiceImpl#getInduStatus; fields=ComShortInfoDTO.induLevel1Code")
    private Integer steelStatus;

    @ApiModelProperty("是否煤炭 0:否 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=applyLegacyOnlyV3BatchFields; value=this.getInduStatus(InduGeneralFilterEnum.COAL, oldRow.getInduLevel2Code()); source=calc:OnshoreBondFilterV5ServiceImpl#getInduStatus; fields=ComShortInfoDTO.induLevel2Code")
    private Integer coalStatus;

    @ApiModelProperty("是否水泥 0:否 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=applyLegacyOnlyV3BatchFields; value=this.getInduStatus(InduGeneralFilterEnum.CEMENT, oldRow.getInduLevel2Code()); source=calc:OnshoreBondFilterV5ServiceImpl#getInduStatus; fields=ComShortInfoDTO.induLevel2Code")
    private Integer cementStatus;

    @ApiModelProperty("是否房地产 0:否 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=applyLegacyOnlyV3BatchFields; value=this.getInduStatus(InduGeneralFilterEnum.REAL_ESTATE, oldRow.getInduLevel1Code()); source=calc:OnshoreBondFilterV5ServiceImpl#getInduStatus; fields=ComShortInfoDTO.induLevel1Code")
    private Integer realEstateStatus;

    @ApiModelProperty("是否交运 0:否 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=applyLegacyOnlyV3BatchFields; value=this.getInduStatus(InduGeneralFilterEnum.TRANSPORT, oldRow.getInduLevel1Code()); source=calc:OnshoreBondFilterV5ServiceImpl#getInduStatus; fields=ComShortInfoDTO.induLevel1Code")
    private Integer transportStatus;

    @ApiModelProperty("是否城投主体 0:否 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=urbanInvest; source=ComInfoHttpService#listComShortInfoDTO; path:POST /internal/com/info/short/getByUnicode; fields=ComShortInfoDTO.urbanInvest")
    private Integer udicStatus;

    @ApiModelProperty("是否铁道 0:否 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=this.getRailwayStatus(defaultOnshoreBondInfo.getBondShortName()); source=calc:OnshoreBondFilterV5ServiceImpl#getRailwayStatus; fields=OnshoreBondInfoDTO.bondShortName<-t_bond_basic_info.bond_short_name")
    private Integer railwayStatus;

    @ApiModelProperty("是否上市 0:否 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=applyComShortInfoDerivedFields; value=comShortInfoDTO.getListed(); source=ComInfoHttpService#listComShortInfoDTO; path:POST /internal/com/info/short/getByUnicode; fields=ComShortInfoDTO.listed")
    private Integer listedStatus;

    @ApiModelProperty("是否绿色债券 0:否 1:是。[V5:BOND_TYPE] anchor=applyBondTypeDerivedFields; value=CommonUtils.flagToStatus(bondTypeDTO != null ? bondTypeDTO.getGreenBondFlag() : null); source=DwsBondInfoHttpService#getBondTypeByBondUniCodes; path:POST /internal/bond-info/bond-types")
    private Integer greenBondStatus;

    @ApiModelProperty("是否可质押 0:否 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=filterBO.getPledgeStatus(); source=table:t_bond_conv_ratio; fields=conv_ratio/start_date/end_date; via=TBondConvRatioDAO#listEligibleConvRatios")
    private Integer pledgeStatus;

    @ApiModelProperty("是否跨市场 0:否 1:是。[V5:CROSS_MARKET] anchor=getOnshoreBondFilterV5Info; value=filterBO.getCrossMarketStatus(); source=calc:OnshoreBondFilterV5ServiceImpl#packageCoreFields; fields=BondCodeNameV3DTO.bondUniCode/bondCode/bondShortName; OnshoreBondFilterBO.crossMarketStatus; table=t_bond_basic_info; fields=bond_code/sec_mar_par/is_cros_mar_par")
    private Integer crossMarketStatus;

    @ApiModelProperty("银行类型 1:政策性银行 2:国有商业银行 3:股份制商业银行 4:城市商业银行 5:农村商业银行 6:农村信用合作社 7:村镇银行。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=bankType != null ? bankType : OLD_FILTER_DEFAULT_UNKNOWN; source=ComInfoHttpService#listComShortInfoDTO; path:POST /internal/com/info/short/getByUnicode; fields=ComShortInfoDTO.bankType; default=999 when null")
    private Integer bankType;

    @ApiModelProperty("同业存单(NCD)类型 2:国有商业银行 3:股份制商业银行 4:城市商业银行 5:农村商业银行 999:其他(1,6,7也归属到其他)。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=this.getNcdType(basicBondFilterType, bondType, bankType, businessFilterNature); source=calc:OnshoreBondFilterV5ServiceImpl#getNcdType; fields=basic_bond_filter_type + t_bond_basic_info.bond_type_par + ComShortInfoDTO.bankType/businessFilterNature")
    private Integer ncdType;

    @ApiModelProperty("票面利率筛选类型 1:固息 2:浮息 999:其他。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=couponRateFilterType; source=calc:CouponRateTypeEnum#getCouponRateFilterTypeEnum; fields=t_bond_basic_info.rate_type_par")
    private Integer couponRateFilterType;

    @ApiModelProperty("票面利率V3筛选类型 1:固息 2:DEPO 3:LPR 4:SHIBOR 999:其他。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=this.getCouponRateV3FilterType(couponRateFilterType, derivBenchmarkDTO); source=calc:OnshoreBondFilterV5ServiceImpl#getCouponRateV3FilterType; fields=t_bond_basic_info.rate_type_par + DerivBenchmarkDTO.benchmarkEngName; path:POST /internal/bond-info/listDerivBenchmark")
    private Integer couponRateV3FilterType;

    @ApiModelProperty("债券隐含评级映射 10:AAA+ 20:AAA 30:AAA- 40:AA+ 50:AA 55:AA(2) 60:AA-。[V5:RATING] anchor=getOnshoreBondFilterV5Info; value=bondLatestRatingDTO != null ? bondLatestRatingDTO.getImpliedRatingMapping() : null; source=BondRatingHttpService#listComLatestRating; path:POST /internal/com/comLatestRating/get")
    private Integer bondImpliedRatingMapping;

    @ApiModelProperty("债券外部评级筛选映射 1:AAA 2:AA+ 3:AA 4:AA- 5:A+ 999:其他。[V5:RATING] anchor=getOnshoreBondFilterV5Info; value=ExtRatingFilterMappingEnum.getExtRatingFilterMappingEnumByOriginRatingMapping( bondLatestRatingDTO != null ? bondLatestRatingDTO.getExtCreditRatingMapping() : null).getValue(); source=BondRatingHttpService#listComLatestRating; path:POST /internal/com/comLatestRating/get")
    private Integer bondExtRatingFilterMapping;

    @ApiModelProperty("主体外部评级筛选映射 1:AAA 2:AA+ 3:AA 4:AA- 5:A+ 999:其他。[V5:RATING] anchor=getOnshoreBondFilterV5Info; value=ExtRatingFilterMappingEnum.getExtRatingFilterMappingEnumByOriginRatingMapping( comLatestRatingDTO != null ? comLatestRatingDTO.getExtCreditRatingMapping() : null).getValue(); source=BondRatingHttpService#listComLatestRating; path:POST /internal/com/comLatestRating/get")
    private Integer comExtRatingFilterMapping;

    @ApiModelProperty("YY主体评级映射 投资级:1,2,3,4,5 投机级:6,7,8 风险级:9,10。[V5:RATING] anchor=getOnshoreBondFilterV5Info; value=comLatestRatingDTO != null && comLatestRatingDTO.getYyRating() != null ? comLatestRatingDTO.getYyRating() : 0; source=BondRatingHttpService#listComLatestRating; path:POST /internal/com/comLatestRating/get")
    private Integer comYyRatingMapping;

    @ApiModelProperty("YY主体评级V2映射。[V5:RATING] anchor=getOnshoreBondFilterV5Info; value=mapping; source=BondRatingHttpService#listComLatestRating; path:POST /internal/com/comLatestRating/get")
    private Integer comYyRatingV2Mapping;

    @ApiModelProperty("YY主体评级V2映射排序字段。[V5:RATING] anchor=getOnshoreBondFilterV5Info; value=yyRatingEnum.map(YyRatingEnum::getSort).orElse(null); source=BondRatingHttpService#listComLatestRating; path:POST /internal/com/comLatestRating/get")
    private Integer comYyRatingV2MappingSort;

    @ApiModelProperty("企业性质(经营类型过滤用) 1:央企 2:国企 3:民企 999:其他。[V5:COM_INFO] anchor=applyComShortInfoDerivedFields; value=businessFilterNature; source=ComInfoHttpService#listComShortInfoDTO; path:POST /internal/com/info/short/getByUnicode")
    private Integer businessFilterNature;

    @ApiModelProperty("是否含权 0:否 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=filterBO.getEmbeddedOptionStatus(); source=table:t_bond_basic_info; fields=is_redem_par/is_resa_par; via=BondBasicInfoDAO#getEmbeddedOptionStatus")
    private Integer embeddedOptionStatus;

    @ApiModelProperty("是否永续 0:非永续 1:永续。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=perpetualStatus; source=table:t_bond_basic_info; fields=exer_pay_date; via=BondBasicInfoDAO#getPerpetualStatus")
    private Integer perpetualStatus;

    @ApiModelProperty("担保状态 0:无 1:有。[V5:PARTY_ENRICH] anchor=getOnshoreBondFilterV5Info; value=guarantee; source=ComInfoHttpService#listComRelatedPartyByUniCodes; path:POST /internal/com/related/party/getByUnicode")
    private Integer guaranteedStatus;

    @ApiModelProperty("担保细分 0:无担保 1:担保公司担保 2:其他担保。[V5:PARTY_ENRICH] anchor=getOnshoreBondFilterV5Info; value=guaranteedStatusV2; source=ComInfoHttpService#listComRelatedPartyByUniCodes; path:POST /internal/com/related/party/getByUnicode")
    private Integer guaranteedStatusV2;

    @ApiModelProperty("城投行政区划/区域级别 1:直辖市级 2:省级 3:计划单列市 4:副省级城市 5:副省级国家级新区 6:直辖市区 7:强地级市 8:地级市 9:正厅级国家级新区 10:副厅级国家级新区 11:国家级开发区 12:百强区 13:省级开发区 14:百强县 15:一般区县（汇总：1,2省级；3,4,6,7,8市级；15,14,12区/县级；9,10,11,13园区级）。[V5:URBAN_AREA] anchor=getOnshoreBondFilterV5Info; value=urbanAreaInfoDTO.getUrbanAreaLevel(); source=ComInfoHttpService#listUrbanAreaInfoDTO; path:POST /internal/urban/com/areaInfo/getByComUniCode")
    private Integer udicAdministrativeRegion;

    @ApiModelProperty("债券募集类型 1:公募 2:私募 3:小公募。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=this.getBondOfferingType(publicOfferingVal, basicBondFilterType); source=calc:OnshoreBondFilterV5ServiceImpl#getBondOfferingType; fields=public_offering<-t_bond_basic_info.is_public_iss + basic_bond_filter_type")
    private Integer bondOfferingType;

    @ApiModelProperty("债券市场(二级) 1:深圳证券交易所 2:上海证券交易所 3:银行间市场 4:柜台交易市场 999:其他。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=secondMarketVal; source=calc:SecondMarket#getSecondMarket; fields=t_bond_basic_info.bond_code/sec_mar_par")
    private Integer secondMarket;

    @ApiModelProperty("二级筛选市场 1:交易所 2:银行间 999:其他。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=secondFilterMarket; source=calc:SecondMarketEnum#getSecondMarketFilterByValue; fields=second_market<-t_bond_basic_info.bond_code/sec_mar_par")
    private Integer secondFilterMarket;

    @ApiModelProperty("是否流通中 0:否 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=filterBO.getCirculationStatus(); source=table:t_bond_basic_info; fields=info_state/del_status/save_status/curr_status/is_new; via=BondBasicInfoDAO#getCirculationStatusEnum")
    private Integer circulationStatus;

    @ApiModelProperty("发行状态 0:发行中 1:已上市 2:延迟发行 3:取消发行。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=filterBO.getIssueStatus(); source=table:t_bond_basic_info; fields=iss_status")
    private Integer issueStatus;

    @ApiModelProperty("是否到期 0:未到期 1:已到期。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=filterBO.getExpired(); source=table:t_bond_basic_info; fields=remaining_tenor; via=BondBasicInfoDAO#listBondFilterBO")
    private Integer expired;

    @ApiModelProperty("币种 1:CNY 2:HKD 3:USD。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=filterBO.getCurrency(); source=table:t_bond_basic_info; fields=cury_type_par")
    private Integer currency;

    @ApiModelProperty("业务性质 详见参数字典 http://git.innodealing.cn/global/document/wikis （常用字段规范）。[V5:COM_INFO] anchor=applyComShortInfoDerivedFields; value=comShortInfoDTO.getBusinessNature(); source=ComInfoHttpService#listComShortInfoDTO; path:POST /internal/com/info/short/getByUnicode")
    private Integer businessNature;

    @ApiModelProperty("募集方式 0:私募 1:公募。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=publicOfferingVal; source=table:t_bond_basic_info; fields=is_public_iss; via=BondBasicInfoDAO#getPublicOffering")
    private Integer publicOffering;

    @ApiModelProperty("票面利率类型 0:其他 1:固定利率 2:浮动利率 3:累进利率 4:贴现 5:无序利率 999:其他。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=rateType; source=table:t_bond_basic_info; fields=rate_type_par")
    private Integer couponRateType;

    @ApiModelProperty("含权类型 0:含权 1:不含权 2:永续。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=embeddedOption; source=table:t_broker_filter; fields=provision; via=BondBasicInfoDAO#getEmbeddedEnum")
    private Integer embeddedOption;

    @ApiModelProperty("债券类型 详见参数字典 bond_type http://git.innodealing.cn/global/document/wikis （常用字段规范）。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=bondType; source=table:t_bond_basic_info; fields=bond_type_par")
    private Integer bondType;

    @ApiModelProperty("主体外部评级映射 0:-- 20:AAA 40:AA+ 50:AA 60:AA- 70:A+ 80:A 90:A- 100:BBB+ 110:BBB 120:BBB- 130:BB+ 140:BB 150:BB- 160:B+ 170:B 180:B- 200:CCC 220:CC 230:C。[V5:RATING] anchor=getOnshoreBondFilterV5Info; value=comLatestRatingDTO != null ? comLatestRatingDTO.getExtCreditRatingMapping() : null; source=BondRatingHttpService#listComLatestRating; path:POST /internal/com/comLatestRating/get")
    private Integer comExtRatingMapping;

    @ApiModelProperty("海外主体外部评级映射 0:-- 20:AAA 22:Aaa 42:Aa1 50:AA 60:AA- 70:A+ 72:A1 80:A 82:A2 90:A- 92:A3 100:BBB+ 102:Baa1 110:BBB 112:Baa2 120:BBB- 122:Baa3 130:BB+ 132:Ba1 140:BB 142:Ba2 150:BB- 152:Ba3 160:B+ 162:B1 172:B2 180:B- 182:B3 190:CCC+ 192:Caa1 202:Caa2 210:CCC- 212:Caa3 222:Ca 239:SD 240:D 999:-- 1002:WD。[V5:RATING] anchor=getOnshoreBondFilterV5Info; value=comLatestRatingDTO != null ? comLatestRatingDTO.getIntlExtCreditRatingMapping() : null; source=BondRatingHttpService#listComLatestRating; path:POST /internal/com/comLatestRating/get")
    private Integer intlExtRatingMapping;

    @ApiModelProperty("债券外部评级映射 0:-- 20:AAA 21:A-1+ 22:Aaa 30:AAA- 40:AA+ 50:AA 60:AA- 70:A+ 71:A-1 80:A 90:A- 91:A-2 100:BBB+ 110:BBB 120:BBB- 121:A-3 130:BB+ 140:BB 160:B+ 170:B 180:B- 200:CCC 220:CC 230:C 240:D 999:--。[V5:RATING] anchor=getOnshoreBondFilterV5Info; value=bondLatestRatingDTO != null ? bondLatestRatingDTO.getExtCreditRatingMapping() : null; source=BondRatingHttpService#listComLatestRating; path:POST /internal/com/comLatestRating/get")
    private Integer bondExtRatingMapping;

    @ApiModelProperty("是否回售 0:否 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=filterBO.getPutOptionStatus(); source=table:t_bond_basic_info; fields=is_resa_par")
    private Integer putOptionStatus;

    @ApiModelProperty("是否赎回 0:否 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=filterBO.getCallableStatus(); source=table:t_bond_basic_info; fields=is_redem_par; canonical=callable_status")
    private Integer redeemStatus;

    @ApiModelProperty("主体是否违约 0:否 1:是。[V5:RISK_SENTIMENT] anchor=getOnshoreBondFilterV5Info; value=isDefaultCom ? WHETHER_YES_TAG : WHETHER_NO_TAG; source=BondSentimentHttpService#listRiskTypeByBoundUniCodes; path:POST /internal/default/bond/default/risk-type/by-bound-uni-codes")
    private Integer defaultComStatus;

    @ApiModelProperty("付息频率 12:按月 4:按季 2:半年 1:按年 999:其他。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=this.getInterestPaymentFrequency(defaultOnshoreBondInfo); source=calc:OnshoreBondFilterV5ServiceImpl#getInterestPaymentFrequency; fields=OnshoreBondInfoDTO.intePayFreq/interestPaymentMethod")
    private Integer interestPaymentFrequency;

    @ApiModelProperty("是否非银金融债 0:否 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=applyLegacyOnlyV3BatchFields; value=this.getNonBankFinanceStatus(oldRow.getBondFilterType(), oldRow.getInduLevel1Code()); source=calc:OnshoreBondFilterV5ServiceImpl#getNonBankFinanceStatus; fields=basic_bond_filter_type + ComShortInfoDTO.induLevel1Code")
    private Integer nonBankFinanceStatus;

    @ApiModelProperty("剩余期限天数。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getRemainingTenorDay(); source=calc:BondBasicInfoDAO#getBondRemainingTenorDTO; fields=t_bond_basic_info.actu_end_date/matu_pay_date/exer_pay_date/curr_status")
    private Integer remainingTenorDay;

    @ApiModelProperty("区域等级/档位 1:北京,上海,广东,浙江,江苏 2:深圳,宁波,福建,厦门,山东 3:青岛,山西,重庆,四川,安徽,湖南,陕西,江西,河北 4:大连,海南,天津,河南,宁夏,湖北 5:广西,新疆,青海,吉林,黑龙江,甘肃,西藏,兵团 6:内蒙古,辽宁,贵州,云南。[V5:URBAN_AREA] anchor=getOnshoreBondFilterV5Info; value=ComAreaLevelEnum.getLevel(comUniCode); source=ComInfoHttpService#listUrbanAreaInfoDTO; path:POST /internal/urban/com/areaInfo/getByComUniCode")
    private Integer areaLevel;

    @ApiModelProperty("平台重要性(平台等级) 1:核心平台 2:重要平台 3:次要平台。[V5:URBAN_AREA] anchor=getOnshoreBondFilterV5Info; value=udicComInfoForBasicDTO.getPlatformLevel(); source=ComInfoHttpService#listUrbanAreaInfoDTO; path:POST /internal/urban/com/areaInfo/getByComUniCode")
    private Integer platformLevel;

    @ApiModelProperty("DM城投状态 0:非城投 1:城投。[V5:URBAN_AREA] anchor=applyComShortInfoDerivedFields; value=comShortInfoDTO.getDmUdicStatus(); source=ComInfoHttpService#listUrbanAreaInfoDTO; path:POST /internal/urban/com/areaInfo/getByComUniCode")
    private Integer dmUdicStatus;

    @ApiModelProperty("跨市场去重状态 1:跨市场债去重后展示或非跨市场债 0:跨市场债去重后不展示（去重按 sec_mar_par 3,2,6,1,78,4,其他 优先级保留）。[V5:CROSS_MARKET] anchor=getOnshoreBondFilterV5Info; value=crossMarketDedupStatus; source=calc:OnshoreBondFilterV5ServiceImpl#packageCoreFields; fields=BondCodeNameV3DTO.bondUniCode/bondCode/bondShortName; OnshoreBondFilterBO.crossMarketStatus; table=t_bond_basic_info; fields=bond_code/sec_mar_par/is_cros_mar_par")
    private Integer crossMarketDedupStatus;

    @ApiModelProperty("提前还本状态 0:不提前还本 1:提前还本。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=isPrepayment ? BoolStatusEnum.TRUE.getValue() : BoolStatusEnum.FALSE.getValue(); source=calc:BondBasicInfoDAO#calcPrepaymentStatus; fields=bond_cash_flow_chart.prin_pay_amount/inte_start_date/isvalid")
    private Integer prepaymentStatus;

    @ApiModelProperty("券商普通债状态 0:不是 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=this.getSecurityGeneralStatus(induLevel2Code, bondType); source=calc:OnshoreBondFilterV5ServiceImpl#getSecurityGeneralStatus; fields=ComShortInfoDTO.induLevel2Code + t_bond_basic_info.bond_type_par")
    private Integer securityGeneralStatus;

    @ApiModelProperty("券商次级债状态 0:不是 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=this.getSecuritySubStatus(bondType); source=calc:OnshoreBondFilterV5ServiceImpl#getSecuritySubStatus; fields=t_bond_basic_info.bond_type_par")
    private Integer securitySubStatus;

    @ApiModelProperty("保险永续债状态 0:不是 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=this.getInsurancePerpetualStatus(induLevel2Code, perpetualStatus); source=calc:OnshoreBondFilterV5ServiceImpl#getInsurancePerpetualStatus; fields=ComShortInfoDTO.induLevel2Code + perpetual_status")
    private Integer insurancePerpetualStatus;

    @ApiModelProperty("保险次级债状态 0:不是 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=this.getInsuranceSubStatus(bondType, perpetualStatus); source=calc:OnshoreBondFilterV5ServiceImpl#getInsuranceSubStatus; fields=t_bond_basic_info.bond_type_par + perpetual_status")
    private Integer insuranceSubStatus;

    @ApiModelProperty("不含假期状态 0:不是 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=this.getWithoutHolidayStatus(defaultOnshoreBondInfo); source=calc:OnshoreBondFilterV5ServiceImpl#getWithoutHolidayStatus; fields=OnshoreBondInfoDTO.bondShortName/bondFullName")
    private Integer withoutHolidayStatus;

    @ApiModelProperty("外资银行状态 0:不是 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=applyLegacyOnlyV3BatchFields; value=this.getForeignBankStatus(oldRow.getInduLevel2Code(), oldRow.getBusinessFilterNature()); source=calc:OnshoreBondFilterV5ServiceImpl#getForeignBankStatus; fields=ComShortInfoDTO.induLevel2Code/businessFilterNature")
    private Integer foreignBankStatus;

    @ApiModelProperty("次级债状态 0:不是 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=this.getSubordinatedStatus(paymentOrder); source=calc:OnshoreBondFilterV5ServiceImpl#getSubordinatedStatus; fields=payment_order<-BondTypeDTO.paymentOrder")
    private Integer subordinatedStatus;

    @ApiModelProperty("债券期限天数。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getBondTenorDay(); source=calc:BondBasicInfoDAO#getBondTenor; fields=t_bond_basic_info.bond_matu/matu_unit_par")
    private Integer bondTenorDay;

    @ApiModelProperty("科创票据状态 0:不是 1:是。[V5:BOND_TYPE] anchor=applyBondTypeDerivedFields; value=CommonUtils.flagToStatus(bondTypeDTO != null ? bondTypeDTO.getSciTechInnoBondFlag() : null); source=DwsBondInfoHttpService#getBondTypeByBondUniCodes; path:POST /internal/bond-info/bond-types")
    private Integer scienceTechNoteStatus;

    @ApiModelProperty("科技创新公司债状态 0:不是 1:是。[V5:BOND_TYPE] anchor=applyBondTypeDerivedFields; value=CommonUtils.flagToStatus(bondTypeDTO != null ? bondTypeDTO.getSciTechInnoBondFlag() : null); source=DwsBondInfoHttpService#getBondTypeByBondUniCodes; path:POST /internal/bond-info/bond-types")
    private Integer stiStatus;

    @ApiModelProperty("碳中和债状态 0:不是 1:是。[V5:BOND_TYPE] anchor=applyBondTypeDerivedFields; value=CommonUtils.flagToStatus(bondTypeDTO != null ? bondTypeDTO.getCarbonNeutralBondFlag() : null); source=DwsBondInfoHttpService#getBondTypeByBondUniCodes; path:POST /internal/bond-info/bond-types")
    private Integer carbonNeutralityStatus;

    @ApiModelProperty("是否城投主体(兼容旧filter，同udic_status) 0:否 1:是。[V5:LEGACY_ALIAS] anchor=getOnshoreBondFilterV5Info; value=urbanInvest; source=alias:udic_status; fields=ComShortInfoDTO.urbanInvest")
    private Integer urbanInvest;

    @ApiModelProperty("担保状态(兼容旧filter，同guaranteed_status) 0:无 1:有。[V5:LEGACY_ALIAS] anchor=getOnshoreBondFilterV5Info; value=guarantee; source=alias:guaranteed_status; fields=t_bond_basic_info.is_guar_par; via=BondBasicInfoDAO#listBondFilterBO")
    private Integer guarantee;

    @ApiModelProperty("城投区域级别(兼容旧filter，同udic_administrative_region)。[V5:LEGACY_ALIAS] anchor=getOnshoreBondFilterV5Info; value=urbanAreaInfoDTO.getUrbanAreaLevel(); source=alias:udic_administrative_region; fields=UrbanAreaInfoDTO.urbanAreaLevel; path:POST /internal/urban/com/areaInfo/getByComUniCode")
    private Integer urbanAreaLevel;

    @ApiModelProperty("城投区域编码(兼容旧filter，同udic_district_uni_code)。[V5:LEGACY_ALIAS] anchor=getOnshoreBondFilterV5Info; value=urbanArea; source=alias:udic_district_uni_code; fields=UrbanAreaInfoDTO.urbanAreaUniCode; path:POST /internal/urban/com/areaInfo/getByComUniCode")
    private Long urbanAreaUniCode;

    @ApiModelProperty("城投城市编码(兼容旧filter，同udic_city_uni_code)。[V5:LEGACY_ALIAS] anchor=getOnshoreBondFilterV5Info; value=urbanCity; source=alias:udic_city_uni_code; fields=UrbanAreaInfoDTO.urbanCityUniCode; path:POST /internal/urban/com/areaInfo/getByComUniCode")
    private Long urbanCityUniCode;

    @ApiModelProperty("城投省份编码(兼容旧filter，同udic_province_uni_code)。[V5:LEGACY_ALIAS] anchor=getOnshoreBondFilterV5Info; value=urbanProvince; source=alias:udic_province_uni_code; fields=UrbanAreaInfoDTO.urbanProvinceUniCode; path:POST /internal/urban/com/areaInfo/getByComUniCode")
    private Long urbanProvinceUniCode;

    @ApiModelProperty("碳中和债(兼容旧filter，同carbon_neutrality_status) 0:否 1:是。[V5:LEGACY_ALIAS] anchor=applyBondTypeDerivedFields; value=v5do.getCarbonNeutralityStatus(); source=alias:carbon_neutrality_status; fields=BondTypeDTO.carbonNeutralBondFlag; path:POST /internal/bond-info/bond-types")
    private Integer carbonNeutralBondStatus;

    @ApiModelProperty("乡村振兴债状态 0:不是 1:是。[V5:BOND_TYPE] anchor=getOnshoreBondFilterV5Info; value=Objects.equals(RURALREVIVAL_BOND_THEME, bondTheme) ? WHETHER_YES_TAG : WHETHER_NO_TAG; source=DwsBondInfoHttpService#getBondTypeByBondUniCodes; path:POST /internal/bond-info/bond-types")
    private Integer ruralRevivalStatus;

    @ApiModelProperty("地方债类型 1:一般债 2:专项债 99:其他。[V5:BOND_TYPE] anchor=getOnshoreBondFilterV5Info; value=lgBondTypeDTO != null ? lgBondTypeDTO.getLgBondType() : null; source=DwsBondInfoHttpService#getBondTypeByBondUniCodes; path:POST /internal/bond-info/bond-types")
    private Integer lgBondType;

    @ApiModelProperty("熊猫债状态 0:不是 1:是。[V5:BOND_TYPE] anchor=getOnshoreBondFilterV5Info; value=BooleanUtils.toInteger(pandaBondStatus); source=DwsBondInfoHttpService#getBondTypeByBondUniCodes; path:POST /internal/bond-info/bond-types")
    private Integer pandaStatus;

    @ApiModelProperty("熊猫债状态 0:不是 1:是。[V5:BOND_TYPE] anchor=getOnshoreBondFilterV5Info; value=BooleanUtils.toInteger(pandaBondStatus); source=DwsBondInfoHttpService#getBondTypeByBondUniCodes; path:POST /internal/bond-info/bond-types")
    private Integer pandaBondStatus;

    @ApiModelProperty("经纪商成交(笔)。[V5:LIQUIDITY_STAT] anchor=fillLiquidityScore; value=liquidityScoreIndexStatDTO.getTradingNum(); source=BondPriceApolloHttpService#listLiquidityScoreIndexStatDTOs; path:POST /internal/liquidity-score/list/stat")
    private Integer tradingNum;

    @ApiModelProperty("成交天数。[V5:LIQUIDITY_STAT] anchor=fillLiquidityScore; value=liquidityScoreIndexStatDTO.getTradingDays(); source=BondPriceApolloHttpService#listLiquidityScoreIndexStatDTOs; path:POST /internal/liquidity-score/list/stat")
    private Integer tradingDays;

    @ApiModelProperty("Bid笔数。[V5:LIQUIDITY_STAT] anchor=fillLiquidityScore; value=liquidityScoreIndexStatDTO.getBidNum(); source=BondPriceApolloHttpService#listLiquidityScoreIndexStatDTOs; path:POST /internal/liquidity-score/list/stat")
    private Integer bidNum;

    @ApiModelProperty("Bid天数。[V5:LIQUIDITY_STAT] anchor=fillLiquidityScore; value=liquidityScoreIndexStatDTO.getBidQuoteDays(); source=BondPriceApolloHttpService#listLiquidityScoreIndexStatDTOs; path:POST /internal/liquidity-score/list/stat")
    private Integer bidQuoteDays;

    @ApiModelProperty("Ofr笔数。[V5:LIQUIDITY_STAT] anchor=fillLiquidityScore; value=liquidityScoreIndexStatDTO.getOfrNum(); source=BondPriceApolloHttpService#listLiquidityScoreIndexStatDTOs; path:POST /internal/liquidity-score/list/stat")
    private Integer ofrNum;

    @ApiModelProperty("Ofr天数。[V5:LIQUIDITY_STAT] anchor=fillLiquidityScore; value=liquidityScoreIndexStatDTO.getOfrQuoteDays(); source=BondPriceApolloHttpService#listLiquidityScoreIndexStatDTOs; path:POST /internal/liquidity-score/list/stat")
    private Integer ofrQuoteDays;

    @ApiModelProperty("双边报价天数。[V5:LIQUIDITY_STAT] anchor=fillLiquidityScore; value=liquidityScoreIndexStatDTO.getTwoSideQuoteDays(); source=BondPriceApolloHttpService#listLiquidityScoreIndexStatDTOs; path:POST /internal/liquidity-score/list/stat")
    private Integer twoSideQuoteDays;

    @ApiModelProperty("流动性评分统计周期 1:3天 10:14天。[V5:LIQUIDITY_STAT] anchor=fillLiquidityScore; value=liquidityScoreIndexStatDTO.getLiquidityScoreStatPeriod(); source=BondPriceApolloHttpService#listLiquidityScoreIndexStatDTOs; path:POST /internal/liquidity-score/list/stat")
    private Integer liquidityScoreStatPeriod;

    @ApiModelProperty("流动性评分档位，V5 按 large_gear_score 透传；生产 V3/旧 filter 无对应来源，不参与业务差异比对。[V5:LIQUIDITY_BASE] anchor=applyLiquidityBaseFields; value=liquidityBondBaseDTO.getLargeGearScore(); source=LiquidityScoreHttpService#listBondLiquidityScore; path:POST /internal/ls/data/bond/base/list")
    private Integer liquidityScoreLevel;

    @ApiModelProperty("是否TLAC债 0:否 1:是。[V5:BOND_TYPE] anchor=applyLegacyOnlyV3BatchFields; value=this.getTalcStatus(null); source=DwsBondInfoHttpService#getBondTypeByBondUniCodes; path:POST /internal/bond-info/bond-types")
    private Integer tlacBondStatus;

    @ApiModelProperty("利率类型 2:浮动利率。[V5:LEGACY_ALIAS] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getRateTypePar(); source=alias:coupon_rate_type; fields=OnshoreBondInfoDTO.rateTypePar<-t_bond_basic_info.rate_type_par")
    private Integer rateType;

    @ApiModelProperty("是否柜台债 0:否 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=getCounterBondStatus(defaultOnshoreBondInfo); source=calc:OnshoreBondFilterV5ServiceImpl#getCounterBondStatus; fields=OnshoreBondInfoDTO.secondMarket/secMarPar")
    private Integer counterBondStatus;

    @ApiModelProperty("是否证券公司短融债 0:否 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=applyLegacyOnlyV3BatchFields; value=this.getStatusByBondType(null, BondType.SECURITY_SHORT_TERM_FINANCING_BOND); source=calc:OnshoreBondFilterV5ServiceImpl#getStatusByBondType; fields=BondTypeDTO.bondType; path:POST /internal/bond-info/bond-types")
    private Integer securityInstCpBondStatus;

    @ApiModelProperty("是否政策性银行次级债 0:否 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=applyLegacyOnlyV3BatchFields; value=this.getStatusByBondType(null, BondType.POLICY_BANK_SUBORDINATED_BOND); source=calc:OnshoreBondFilterV5ServiceImpl#getStatusByBondType; fields=BondTypeDTO.bondType; path:POST /internal/bond-info/bond-types")
    private Integer policyBankSubBondStatus;

    @ApiModelProperty("是否贴现国债 0:否 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=getDiscountedTreasuryBondStatus(defaultOnshoreBondInfo); source=calc:OnshoreBondFilterV5ServiceImpl#getDiscountedTreasuryBondStatus; fields=OnshoreBondInfoDTO.bondType/couponRateType")
    private Integer discountTreasuryBondStatus;

    @ApiModelProperty("托管场所 1:中债登 2:中证登 3:上清所 99:其他。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=getCustodyVenue(defaultOnshoreBondInfo); source=calc:OnshoreBondFilterV5ServiceImpl#getCustodyVenue; fields=OnshoreBondInfoDTO.custodianFullName/custodianUniCode")
    private Integer custodyVenue;

    @ApiModelProperty("中债资信债券评级映射 1:AAA+ 2:AAA 3:AAA- 4:AA+ 5:AA 99:其他 999:无评级。[V5:RATING] anchor=getOnshoreBondFilterV5Info; value=chinaBondRatingMappingEnum.getValue(); source=BondRatingHttpService#listComLatestRating; path:POST /internal/com/comLatestRating/get")
    private Integer chinaBondCreditRatingMapping;

    @ApiModelProperty("中债资信主体评级映射 1:AAA+ 2:AAA 3:AAA- 4:AA+ 5:AA 99:其他 999:无评级。[V5:RATING] anchor=getOnshoreBondFilterV5Info; value=chinaComRatingMappingEnum.getValue(); source=BondRatingHttpService#listComLatestRating; path:POST /internal/com/comLatestRating/get")
    private Integer chinaComCreditRatingMapping;

    @ApiModelProperty("交易所做市 1:上证利率 2:上证信用 3:深证利率 4:深证信用。[V5:MARKET_MAKING] anchor=getOnshoreBondFilterV5Info; value=this.getMarketMaker(secondMarketVal, bondMarketMakingListDTO); source=DwsBondInfoHttpService#listDwdBondMarketMakingListDTO; path:POST /internal/dwd-bond-market-making-list/listBondMarketingStatusByBondUniCodes")
    private Integer marketMaker;

    @ApiModelProperty("债券承销商中介类型代码。[V5:ISSUE_INFO] anchor=getOnshoreBondFilterV5Info; value=bondIssueAgencyInfoDTO.getIssueAgencyTypeCode(); source=BondPrimaryInfoV5DAO#listByBondUniCodes; path:POST /internal/bond-issue-agency/listOnshoreBondIssueAgency")
    private Integer issueAgencyTypeCode;

    @ApiModelProperty("是否信用债ETF 0:否 1:是。[V5:FUND] anchor=applyFundFields; value=BondFilterUtils.getCreditBondEtfStatus(safeFundInfos); source=DwsBondInfoHttpService#listDwsFundInfoByBondUniCodes; path:POST /internal/dws-fund-info/listOnshoreFundConsRel")
    private Integer creditBondEtfStatus;

    @ApiModelProperty("是否利率债ETF 0:否 1:是。[V5:FUND] anchor=applyFundFields; value=BondFilterUtils.getRateBondEtfStatus(safeFundInfos); source=DwsBondInfoHttpService#listDwsFundInfoByBondUniCodes; path:POST /internal/dws-fund-info/listOnshoreFundConsRel")
    private Integer rateBondEtfStatus;

    @ApiModelProperty("是否科创债ETF 0:否 1:是。[V5:FUND] anchor=applyFundFields; value=BondFilterUtils.getSciTechInnoBondEtfStatus(safeFundInfos); source=DwsBondInfoHttpService#listDwsFundInfoByBondUniCodes; path:POST /internal/dws-fund-info/listOnshoreFundConsRel")
    private Integer sciTechInnoBondEtfStatus;

    @ApiModelProperty("是否可转债ETF 0:否 1:是。[V5:FUND] anchor=applyFundFields; value=BondFilterUtils.getConvertibleBondEtfStatus(safeFundInfos); source=DwsBondInfoHttpService#listDwsFundInfoByBondUniCodes; path:POST /internal/dws-fund-info/listOnshoreFundConsRel")
    private Integer convertibleBondEtfStatus;

    @ApiModelProperty("到期日距下个工作日相差天数（到期日即工作日则为0）。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getMaturityHoildayDay(); source=calc:BondBasicInfoDAO#calcMaturityHolidayDay; fields=t_bond_basic_info.actu_end_date/exer_pay_date/matu_pay_date")
    private Integer maturityHoildayDay;

    @ApiModelProperty("到期日距下个工作日相差天数（不含周末口径）。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getMaturityHolidayDayNotWeekend(); source=calc:BondBasicInfoDAO#calcMaturityHolidayDay; fields=t_bond_basic_info.actu_end_date/exer_pay_date/matu_pay_date")
    private Integer maturityHolidayDayNotWeekend;

    @ApiModelProperty("科创债-科创债ETF成分券状态 0:不是 1:是。[V5:FUND] anchor=applyLegacyOnlyV3BatchFields; value=BondFilterUtils.getStiEtfStatus(v5do.getSciTechInnoBondStatus(), v5do.getSciTechInnoBondEtfStatus()); source=DwsBondInfoHttpService#listDwsFundInfoByBondUniCodes; path:POST /internal/dws-fund-info/listOnshoreFundConsRel")
    private Integer stiEtfStatus;

    @ApiModelProperty("科创债-非科创债ETF成分券状态 0:不是 1:是。[V5:FUND] anchor=applyLegacyOnlyV3BatchFields; value=BondFilterUtils.getStiNotEtfStatus(v5do.getSciTechInnoBondStatus(), v5do.getSciTechInnoBondEtfStatus()); source=DwsBondInfoHttpService#listDwsFundInfoByBondUniCodes; path:POST /internal/dws-fund-info/listOnshoreFundConsRel")
    private Integer stiNotEtfStatus;

    @ApiModelProperty("是否免税 0:否 1:是。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=applyBondTypeDerivedFields; value=taxFree != null ? (taxFree ? WHETHER_YES_TAG : WHETHER_NO_TAG) : null; source=calc:OnshoreBondFilterV5ServiceImpl#applyBondTypeDerivedFields; fields=BondTypeDTO.taxFree; path:POST /internal/bond-info/bond-types")
    private Integer taxFreeStatus;

    @ApiModelProperty("清偿顺序 1:普通债权 2:次级债权 3:二级资本工具 4:混合资本工具 5:其他一级资本工具 99:其他。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=paymentOrder; source=calc:OnshoreBondFilterV5ServiceImpl#packageCoreFields; fields=BondTypeDTO.paymentOrder; path:POST /internal/bond-info/bond-types")
    private Integer paymentOrder;

    @ApiModelProperty("是否可赎回 0:不可赎回 1:可赎。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=filterBO.getCallableStatus(); source=table:t_bond_basic_info; fields=is_redem_par")
    private Integer callableStatus;

    @ApiModelProperty("风险类型 0:违约 1:展期。[V5:RISK_SENTIMENT] anchor=getOnshoreBondFilterV5Info; value=defaultBondRiskTypeInfoDTO.getRiskType(); source=BondSentimentHttpService#listRiskTypeByBoundUniCodes; path:POST /internal/default/bond/default/risk-type/by-bound-uni-codes")
    private Integer riskType;

    @ApiModelProperty("税率矩阵类型 1:国债 2:地方债 3:政金债 4:央票 5:金融债 6:同业存单 7:铁道债 99:信用债。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=getTaxRateMatrixType(bondFilterType, onshoreBondFilterV5DO.getRailwayStatus()); source=calc:OnshoreBondFilterV5ServiceImpl#getTaxRateMatrixType; fields=bond_filter_type + railway_status")
    private Integer taxRateMatrixType;

    @ApiModelProperty("流动性大档评分 1:S 2:A 3:B 4:C 5:D 6:E（参见 LiquidityLargeGearScoreEnum）。[V5:LIQUIDITY_BASE] anchor=applyLiquidityBaseFields; value=liquidityBondBaseDTO.getLargeGearScore(); source=LiquidityScoreHttpService#listBondLiquidityScore; path:POST /internal/ls/data/bond/base/list")
    private Integer largeGearScore;

    @ApiModelProperty("流动性小档评分 1:S+ 2:S 3:S- 4:A+ 5:A 6:A- 7:B+ 8:B 9:B- 10:C+ 11:C 12:C- 13:D+ 14:D 15:D- 16:E（参见 LiquiditySmallGearScoreEnum）。[V5:LIQUIDITY_BASE] anchor=applyLiquidityBaseFields; value=liquidityBondBaseDTO.getSmallGearScore(); source=LiquidityScoreHttpService#listBondLiquidityScore; path:POST /internal/ls/data/bond/base/list")
    private Integer smallGearScore;

    @ApiModelProperty("流动性评分值是否展示 0:不展示 1:展示。[V5:LIQUIDITY_BASE] anchor=getOnshoreBondFilterV5Info; value=!NO_CREDIT_BOND_FILTER_TYPE.contains(bondFilterType) || bondFilterType == LOCAL_BOND ? 1 : 0; source=LiquidityScoreHttpService#listBondLiquidityScore; path:POST /internal/ls/data/bond/base/list")
    private Integer lsScoreShowStatus;

    @ApiModelProperty("票面利率F9筛选类型 1:固息 2:浮息 999:其他（累进利率类型映射为其他）。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=getCouponRateF9FilterType(defaultOnshoreBondInfo.getCouponRateType(), couponRateFilterType); source=calc:OnshoreBondFilterV5ServiceImpl#getCouponRateF9FilterType; fields=OnshoreBondInfoDTO.couponRateType + coupon_rate_filter_type")
    private Integer couponRateF9FilterType;

    @ApiModelProperty("是否信用债 0:否 1:是。[V5:BOND_TYPE] anchor=applyBondTypeDerivedFields; value=CommonUtils.flagToStatus(bondTypeDTO != null ? bondTypeDTO.getCreditBondFlag() : null); source=DwsBondInfoHttpService#getBondTypeByBondUniCodes; path:POST /internal/bond-info/bond-types")
    private Integer creditBondStatus;

    @ApiModelProperty("是否利率债 0:否 1:是。[V5:BOND_TYPE] anchor=applyBondTypeDerivedFields; value=CommonUtils.flagToStatus(bondTypeDTO != null ? bondTypeDTO.getRateBondFlag() : null); source=DwsBondInfoHttpService#getBondTypeByBondUniCodes; path:POST /internal/bond-info/bond-types")
    private Integer rateBondStatus;

    @ApiModelProperty("是否科创债 0:否 1:是。[V5:BOND_TYPE] anchor=applyBondTypeDerivedFields; value=CommonUtils.flagToStatus(bondTypeDTO != null ? bondTypeDTO.getSciTechInnoBondFlag() : null); source=DwsBondInfoHttpService#getBondTypeByBondUniCodes; path:POST /internal/bond-info/bond-types")
    private Integer sciTechInnoBondStatus;

    @ApiModelProperty("存续状态 0:非存续 1:存续 99:其他。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=applyBondTypeDerivedFields; value=bondTypeDTO != null ? bondTypeDTO.getOutstandingStatus() : null; source=DwsBondInfoHttpService#getBondTypeByBondUniCodes; path:POST /internal/bond-info/bond-types; fields=BondTypeDTO.outstandingStatus")
    private Integer outstandingStatus;

    @ApiModelProperty("债券发行年份。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getBondIssYear(); source=OnshoreBondInfoDTO; fields=bondIssYear<-t_bond_basic_info.iss_start_date")
    private Integer bondIssYear;

    @ApiModelProperty("地方债资金用途性质 1:新增 2:再融资 3:置换 4:特殊再融资 99:其他。[V5:BOND_TYPE] anchor=getOnshoreBondFilterV5Info; value=lgBondTypeDTO != null ? lgBondTypeDTO.getFundUseType() : null; source=DwsBondInfoHttpService#getBondTypeByBondUniCodes; path:POST /internal/bond-info/bond-types")
    private Integer fundUseType;

    @ApiModelProperty("高成长产业债状态 0:否 1:是。[V5:BOND_TYPE] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getBondFullName() != null && defaultOnshoreBondInfo.getBondFullName().contains(HIGH_GROWTH_SECTOR_BOND_STATUS_KEYWORD) ? 1 : 0; source=DwsBondInfoHttpService#getBondTypeByBondUniCodes; path:POST /internal/bond-info/bond-types")
    private Integer highGrowthSectorBondStatus;

    @ApiModelProperty("利息计算方式 1:按频率比例 2:ACT/365 3:ACT/360 4:ACT/ACT 5:THIRTY_360 6:DIVIDE 999:其他。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=getOnshoreBondFilterV5Info; value=defaultOnshoreBondInfo.getInterestCalculateMethod(); source=OnshoreBondInfoDTO; fields=interestCalculateMethod")
    private Integer interestCalculateMethod;

    @ApiModelProperty("期限类型(1:短期 2:中期 3:长期)。来源 lgBondTypeDTO.getTermType()。[V5:BOND_TYPE] anchor=getOnshoreBondFilterV5Info; value=lgBondTypeDTO != null ? lgBondTypeDTO.getTermType() : null; source=DwsBondInfoHttpService#getBondTypeByBondUniCodes; path:POST /internal/bond-info/bond-types")
    private Integer bondTermType;

    @ApiModelProperty("违约标签(0:非违约 1:实质违约 2:技术违约)。由 riskType+defaultComStatus 计算。[V5:RISK_SENTIMENT] anchor=getOnshoreBondFilterV5Info; value=computeDefaultTag( defaultBondRiskTypeInfoDTO.getRiskType(), onshoreBondFilterV5DO.getDefaultComStatus()); source=BondSentimentHttpService#listRiskTypeByBoundUniCodes; path:POST /internal/default/bond/default/risk-type/by-bound-uni-codes")
    private Integer defaultTag;

    @ApiModelProperty("担保交收状态(0:否 1:是)。来源 bond_basic_info.guaranteed_settlement_status。[V5:BASIC_PHYSICAL_TABLE] anchor=fillReplicatedFields; value=bondBasicInfoDO.getGuaranteedSettlementStatus(); source=table:t_bond_basic_info; fields=coll_cap_purp/ref_yield/debt_reg_date/guaranteed_settlement_status/actu_iss_amut")
    private Integer guaranteedSettlementStatus;

    @ApiModelProperty("付息方式。来源 defaultOnshoreBondInfo.interestPaymentMethod。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=fillReplicatedFields; value=defaultOnshoreBondInfo.getInterestPaymentMethod(); source=OnshoreBondInfoDTO; fields=interestPaymentMethod")
    private Integer interestPaymentMethod;

    @ApiModelProperty("还本付息方式。来源 defaultOnshoreBondInfo.repayClsPayType。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=fillReplicatedFields; value=defaultOnshoreBondInfo.getRepayClsPayType(); source=OnshoreBondInfoDTO; fields=repayClsPayType")
    private Integer repayClsPayType;

    @ApiModelProperty("票面重置周期。来源 defaultOnshoreBondInfo.couponResetPeriod。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=fillReplicatedFields; value=defaultOnshoreBondInfo.getCouponResetPeriod(); source=OnshoreBondInfoDTO; fields=couponResetPeriod")
    private Integer couponResetPeriod;

    @ApiModelProperty("票面重置周期单位。来源 defaultOnshoreBondInfo.couponResetPeriodUnit。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=fillReplicatedFields; value=defaultOnshoreBondInfo.getCouponResetPeriodUnit(); source=OnshoreBondInfoDTO; fields=couponResetPeriodUnit")
    private Integer couponResetPeriodUnit;

    @ApiModelProperty("证券优先级排序。来源 defaultOnshoreBondInfo.securitySeniorityRanking。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=fillReplicatedFields; value=defaultOnshoreBondInfo.getSecuritySeniorityRanking(); source=OnshoreBondInfoDTO; fields=securitySeniorityRanking")
    private Integer securitySeniorityRanking;

    @ApiModelProperty("银行优先级排序。来源 defaultOnshoreBondInfo.bankSeniorityRanking。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=fillReplicatedFields; value=defaultOnshoreBondInfo.getBankSeniorityRanking(); source=OnshoreBondInfoDTO; fields=bankSeniorityRanking")
    private Integer bankSeniorityRanking;

    @ApiModelProperty("保险优先级排序。来源 defaultOnshoreBondInfo.insuranceSeniorityRanking。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=fillReplicatedFields; value=defaultOnshoreBondInfo.getInsuranceSeniorityRanking(); source=OnshoreBondInfoDTO; fields=insuranceSeniorityRanking")
    private Integer insuranceSeniorityRanking;

    @ApiModelProperty("非固定付息频率状态(0:否 1:是)。来源 defaultOnshoreBondInfo.nonFixInteFreqStatus。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=fillReplicatedFields; value=defaultOnshoreBondInfo.getNonFixInteFreqStatus(); source=OnshoreBondInfoDTO; fields=nonFixInteFreqStatus")
    private Integer nonFixInteFreqStatus;

    @ApiModelProperty("债券担保人全称列表 Set<String>。[V5:PARTY_ENRICH] anchor=getOnshoreBondFilterV5Info; value=guarantorFullNames.isEmpty() ? null : JSON.toJSONString(guarantorFullNames); source=ComInfoHttpService#listComRelatedPartyByUniCodes; path:POST /internal/com/related/party/getByUnicode")
    private String guarantorFullNames;

    @ApiModelProperty("基金精简信息 List<DwsFundShortInfoDTO>。[V5:FUND] anchor=applyFundFields; value=fundShortInfoList.isEmpty() ? null : JSON.toJSONString(fundShortInfoList); source=DwsBondInfoHttpService#listDwsFundInfoByBondUniCodes; path:POST /internal/dws-fund-info/listOnshoreFundConsRel")
    private String fundShortInfos;

    @ApiModelProperty("跨市场债券集合 List<BondCodeNameV3DTO>（跨市场债拼接，见 cross_market_dedup_status）。[V5:CROSS_MARKET] anchor=getOnshoreBondFilterV5Info; value=crossBonds.isEmpty() ? null : JSON.toJSONString(crossBonds); source=calc:OnshoreBondFilterV5ServiceImpl#packageCoreFields; fields=BondCodeNameV3DTO.bondUniCode/bondCode/bondShortName; OnshoreBondFilterBO.crossMarketStatus; table=t_bond_basic_info; fields=bond_code/sec_mar_par/is_cros_mar_par")
    private String crossBondCodeNameV3;

    @ApiModelProperty("行权日期集合 List<String>。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=exerciseDateList == null || exerciseDateList.isEmpty() ? null : JSON.toJSONString(exerciseDateList); source=calc:BondBasicInfoDAO#getExerciseDateList; fields=t_bond_basic_info.exer_pay_date")
    private String exerciseDateList;

    @ApiModelProperty("计算用未来行权日集合(>=计算日) List<java.sql.Date>(epoch-millis)。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=futureDates == null || futureDates.isEmpty() ? null : JSON.toJSONString(futureDates); source=calc:BondBasicInfoDAO#filterCalcFutureExerciseDates; fields=t_bond_basic_info.exer_pay_date")
    private String calcFutureExerciseDate;

    @ApiModelProperty("计算用历史行权日集合 List<java.sql.Date>(epoch-millis)。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=getOnshoreBondFilterV5Info; value=historyDates == null || historyDates.isEmpty() ? null : JSON.toJSONString(historyDates); source=calc:BondBasicInfoDAO#parseAllExerciseDates; fields=t_bond_basic_info.exer_pay_date")
    private String calcHistoryExerciseDate;

    @ApiModelProperty("城投评分（dmUdicScore）。v1 filter 超集对齐字段。[V5:URBAN_AREA] anchor=getOnshoreBondFilterV5Info; value=udicComInfoForBasicDTO.getDmUdicScore(); source=ComInfoHttpService#listUrbanAreaInfoDTO; path:POST /internal/urban/com/areaInfo/getByComUniCode")
    private BigDecimal udicScore;

    @ApiModelProperty("债券全称。复刻自 bond_basic_info.bond_full_name。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=fillReplicatedFields; value=defaultOnshoreBondInfo.getBondFullName(); source=table:t_bond_basic_info; fields=bond_full_name; via=BondBasicInfoDAO#listBondShortInfoByUniCodes")
    private String bondFullName;

    @ApiModelProperty("一级行业名称。复刻自 ComShortInfoDTO.induLevel1Name。[V5:COM_INFO] anchor=applyComShortInfoDerivedFields; value=comShortInfoDTO.getInduLevel1Name(); source=ComInfoHttpService#listComShortInfoDTO; path:POST /internal/com/info/short/getByUnicode")
    private String induLevel1Name;

    @ApiModelProperty("二级行业名称。复刻自 ComShortInfoDTO.induLevel2Name。[V5:COM_INFO] anchor=applyComShortInfoDerivedFields; value=comShortInfoDTO.getInduLevel2Name(); source=ComInfoHttpService#listComShortInfoDTO; path:POST /internal/com/info/short/getByUnicode")
    private String induLevel2Name;

    @ApiModelProperty("省份名称。复刻自 ComShortInfoDTO.provinceName。[V5:COM_INFO] anchor=applyComShortInfoDerivedFields; value=comShortInfoDTO.getProvinceName(); source=ComInfoHttpService#listComShortInfoDTO; path:POST /internal/com/info/short/getByUnicode")
    private String provinceName;

    @ApiModelProperty("募集资金用途。复刻自 bond_basic_info.coll_cap_purp。[V5:BASIC_PHYSICAL_TABLE] anchor=fillReplicatedFields; value=bondBasicInfoDO.getCollCapPurp(); source=table:t_bond_basic_info; fields=coll_cap_purp/ref_yield/debt_reg_date/guaranteed_settlement_status/actu_iss_amut")
    private String recruitmentFundUse;

    @ApiModelProperty("发行票面利率。复刻自 BondShortInfoBO.couponRate。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=fillReplicatedFields; value=defaultOnshoreBondInfo.getIssueCouponRate(); source=table:t_bond_basic_info; fields=iss_coup_rate; via=BondBasicInfoDAO#listBondShortInfoByUniCodes")
    private BigDecimal issueCouponRate;

    @ApiModelProperty("发行面值。复刻自 bond_basic_info.bond_par_val。[V5:BASE_DAO_DATES_TENOR_AMOUNT] anchor=fillReplicatedFields; value=defaultOnshoreBondInfo.getLatestParValue(); source=table:t_bond_basic_info; fields=bond_par_val; via=BondBasicInfoDAO#listBondShortInfoByUniCodes")
    private BigDecimal issueParValue;

    @ApiModelProperty("托管人编码。复刻自 bond_basic_info.custodian_code。[V5:PARTY_ENRICH] anchor=fillReplicatedFields; value=defaultOnshoreBondInfo.getCustodianUniCode(); source=ComInfoHttpService#listComRelatedPartyByUniCodes; path:POST /internal/com/related/party/getByUnicode")
    private Long custodianUniCode;

    @ApiModelProperty("托管人全称。复刻自 comInfoHttpService.listComCodeMappingInfoDTOByCode。[V5:PARTY_ENRICH] anchor=fillReplicatedFields; value=defaultOnshoreBondInfo.getCustodianFullName(); source=ComInfoHttpService#listComRelatedPartyByUniCodes; path:POST /internal/com/related/party/getByUnicode")
    private String custodianFullName;

    @ApiModelProperty("控股股东编码。复刻自 comInfoHttpService.listComRelatedPartyByUniCodes(CONTROLLING_SHAREHOLDER)。[V5:PARTY_ENRICH] anchor=fillReplicatedFields; value=top.getRelatedPartyCode(); source=ComInfoHttpService#listComRelatedPartyByUniCodes; path:POST /internal/com/related/party/getByUnicode")
    private Long shareholderUniCode;

    @ApiModelProperty("控股股东名称。[V5:PARTY_ENRICH] anchor=fillReplicatedFields; value=top.getRelatedPartyFullName(); source=ComInfoHttpService#listComRelatedPartyByUniCodes; path:POST /internal/com/related/party/getByUnicode")
    private String shareholderName;

    @ApiModelProperty("控股股东持股比例。[V5:PARTY_ENRICH] anchor=fillReplicatedFields; value=top.getShareholdingRatio(); source=ComInfoHttpService#listComRelatedPartyByUniCodes; path:POST /internal/com/related/party/getByUnicode")
    private BigDecimal shareholdingRatio;

    @ApiModelProperty("实控人编码。复刻自 comInfoHttpService.listComRelatedPartyByUniCodes(ACTUAL_CONTROLLER)。[V5:PARTY_ENRICH] anchor=fillReplicatedFields; value=r.getRelatedPartyCode(); source=ComInfoHttpService#listComRelatedPartyByUniCodes; path:POST /internal/com/related/party/getByUnicode")
    private Long realControlUniCode;

    @ApiModelProperty("实控人名称（多人逗号拼接）。[V5:PARTY_ENRICH] anchor=fillReplicatedFields; value=realControls.stream() .map(ComRelatedPartyDTO::getRelatedPartyFullName) .filter(Objects::nonNull) .collect(Collectors.joining(",")); source=ComInfoHttpService#listComRelatedPartyByUniCodes; path:POST /internal/com/related/party/getByUnicode")
    private String realControlName;

    @ApiModelProperty("缴款日。复刻自 t_bond_primary_info.pay_start_date。[V5:ISSUE_INFO] anchor=fillReplicatedFields; value=toSqlDate(bondPrimaryInfoDO.getPayStartDate()); source=BondPrimaryInfoV5DAO#listByBondUniCodes; path:POST /internal/bond-issue-agency/listOnshoreBondIssueAgency")
    private Date payDate;

    @ApiModelProperty("招标/簿记建档日。[V5:ISSUE_INFO] anchor=fillReplicatedFields; value=resolveTenderDocumentationDate(bondBasicInfoDO, bondPrimaryInfoDO); source=BondPrimaryInfoV5DAO#listByBondUniCodes; path:POST /internal/bond-issue-agency/listOnshoreBondIssueAgency")
    private Date tenderDocumentationDate;

    @ApiModelProperty("发行手续费率。[V5:ISSUE_INFO] anchor=fillReplicatedFields; value=issueCommissionRate; source=BondPrimaryInfoV5DAO#listByBondUniCodes; path:POST /internal/bond-issue-agency/listOnshoreBondIssueAgency")
    private BigDecimal issueCommissionRate;

    @ApiModelProperty("城投市场化经营状态 0:否 1:是。[V5:URBAN_AREA] anchor=fillReplicatedFields; value=marketizationStatus; source=ComInfoHttpService#listUrbanAreaInfoDTO; path:POST /internal/urban/com/areaInfo/getByComUniCode")
    private Integer marketizationStatus;

    @ApiModelProperty("中证隐含评级。[V5:F9_AUX_CACHE] anchor=fillReplicatedFields; value=auxInfoBO.getCsImpliedRating(); source=cache:BondAuxInfoV5CacheService#listByBondUniCodes; path:POST /internal/cs-dwd/valuation/list-latest/uni-code/cross-market/valuation-types")
    private String csImpliedRating;

    @ApiModelProperty("中证到期估值净价。[V5:F9_AUX_CACHE] anchor=fillReplicatedFields; value=auxInfoBO.getCsMaturityValuationNetPrice(); source=cache:BondAuxInfoV5CacheService#listByBondUniCodes; path:POST /internal/cs-dwd/valuation/list-latest/uni-code/cross-market/valuation-types")
    private BigDecimal csMaturityValuationNetPrice;

    @ApiModelProperty("中证到期估值收益率。[V5:F9_AUX_CACHE] anchor=fillReplicatedFields; value=auxInfoBO.getCsMaturityValuationYield(); source=cache:BondAuxInfoV5CacheService#listByBondUniCodes; path:POST /internal/cs-dwd/valuation/list-latest/uni-code/cross-market/valuation-types")
    private BigDecimal csMaturityValuationYield;

    @ApiModelProperty("中证到期估值日期。[V5:F9_AUX_CACHE] anchor=fillReplicatedFields; value=auxInfoBO.getCsMaturityValuationDate(); source=cache:BondAuxInfoV5CacheService#listByBondUniCodes; path:POST /internal/cs-dwd/valuation/list-latest/uni-code/cross-market/valuation-types")
    private Date csMaturityValuationDate;

    @ApiModelProperty("中证估值展示日期。[V5:F9_AUX_CACHE] anchor=fillReplicatedFields; value=auxInfoBO.getCsValuationDisplayDate(); source=cache:BondAuxInfoV5CacheService#listByBondUniCodes; path:POST /internal/cs-dwd/valuation/list-latest/uni-code/cross-market/valuation-types")
    private Date csValuationDisplayDate;

    @ApiModelProperty("中证行权估值净价。[V5:F9_AUX_CACHE] anchor=fillReplicatedFields; value=auxInfoBO.getCsExerciseValuationNetPrice(); source=cache:BondAuxInfoV5CacheService#listByBondUniCodes; path:POST /internal/cs-dwd/valuation/list-latest/uni-code/cross-market/valuation-types")
    private BigDecimal csExerciseValuationNetPrice;

    @ApiModelProperty("中证行权估值收益率。[V5:F9_AUX_CACHE] anchor=fillReplicatedFields; value=auxInfoBO.getCsExerciseValuationYield(); source=cache:BondAuxInfoV5CacheService#listByBondUniCodes; path:POST /internal/cs-dwd/valuation/list-latest/uni-code/cross-market/valuation-types")
    private BigDecimal csExerciseValuationYield;

    @ApiModelProperty("中证行权估值日期。[V5:F9_AUX_CACHE] anchor=fillReplicatedFields; value=auxInfoBO.getCsExerciseValuationDate(); source=cache:BondAuxInfoV5CacheService#listByBondUniCodes; path:POST /internal/cs-dwd/valuation/list-latest/uni-code/cross-market/valuation-types")
    private Date csExerciseValuationDate;

    @ApiModelProperty("中债到期估值净价。[V5:F9_AUX_CACHE] anchor=fillReplicatedFields; value=auxInfoBO.getChinaBondMaturityValuationNetPrice(); source=cache:BondAuxInfoV5CacheService#listByBondUniCodes; path:POST /internal/cs-dwd/valuation/list-latest/uni-code/cross-market/valuation-types")
    private BigDecimal chinaBondMaturityValuationNetPrice;

    @ApiModelProperty("中债到期估值收益率。[V5:F9_AUX_CACHE] anchor=fillReplicatedFields; value=auxInfoBO.getChinaBondMaturityValuationYield(); source=cache:BondAuxInfoV5CacheService#listByBondUniCodes; path:POST /internal/cs-dwd/valuation/list-latest/uni-code/cross-market/valuation-types")
    private BigDecimal chinaBondMaturityValuationYield;

    @ApiModelProperty("中债到期估值日期。[V5:F9_AUX_CACHE] anchor=fillReplicatedFields; value=auxInfoBO.getChinaBondMaturityValuationDate(); source=cache:BondAuxInfoV5CacheService#listByBondUniCodes; path:POST /internal/cs-dwd/valuation/list-latest/uni-code/cross-market/valuation-types")
    private Date chinaBondMaturityValuationDate;

    @ApiModelProperty("中债估值展示日期。[V5:F9_AUX_CACHE] anchor=fillReplicatedFields; value=auxInfoBO.getChinaBondValuationDisplayDate(); source=cache:BondAuxInfoV5CacheService#listByBondUniCodes; path:POST /internal/cs-dwd/valuation/list-latest/uni-code/cross-market/valuation-types")
    private Date chinaBondValuationDisplayDate;

    @ApiModelProperty("中债行权估值净价。[V5:F9_AUX_CACHE] anchor=fillReplicatedFields; value=auxInfoBO.getChinaBondExerciseValuationNetPrice(); source=cache:BondAuxInfoV5CacheService#listByBondUniCodes; path:POST /internal/cs-dwd/valuation/list-latest/uni-code/cross-market/valuation-types")
    private BigDecimal chinaBondExerciseValuationNetPrice;

    @ApiModelProperty("中债行权估值收益率。[V5:F9_AUX_CACHE] anchor=fillReplicatedFields; value=auxInfoBO.getChinaBondExerciseValuationYield(); source=cache:BondAuxInfoV5CacheService#listByBondUniCodes; path:POST /internal/cs-dwd/valuation/list-latest/uni-code/cross-market/valuation-types")
    private BigDecimal chinaBondExerciseValuationYield;

    @ApiModelProperty("中债行权估值日期。[V5:F9_AUX_CACHE] anchor=fillReplicatedFields; value=auxInfoBO.getChinaBondExerciseValuationDate(); source=cache:BondAuxInfoV5CacheService#listByBondUniCodes; path:POST /internal/cs-dwd/valuation/list-latest/uni-code/cross-market/valuation-types")
    private Date chinaBondExerciseValuationDate;

    @ApiModelProperty("参考收益率。复刻自 bond_basic_info.ref_yield。[V5:BASIC_PHYSICAL_TABLE] anchor=fillReplicatedFields; value=bondBasicInfoDO.getRefYield(); source=table:t_bond_basic_info; fields=coll_cap_purp/ref_yield/debt_reg_date/guaranteed_settlement_status/actu_iss_amut")
    private BigDecimal referenceYield;

    @ApiModelProperty("非贴现且非CD标记。[V5:BASE_FILTER_COMPUTED_STATUS] anchor=fillReplicatedFields; value=notDiscountAndCd ? 1 : 0; source=calc:OnshoreBondFilterV5ServiceImpl#fillReplicatedFields; fields=t_bond_basic_info.rate_type_par/bond_type_par")
    private Integer notDiscountAndCd;

    @ApiModelProperty("估值修正久期。[V5:F9_AUX_CACHE] anchor=fillReplicatedFields; value=auxInfoBO.getValuationModifiedDuration(); source=cache:BondAuxInfoV5CacheService#listByBondUniCodes; path:POST /internal/cs-dwd/valuation/list-latest/uni-code/cross-market/valuation-types")
    private BigDecimal valuationModifiedDuration;

    @ApiModelProperty("估值利率久期。[V5:F9_AUX_CACHE] anchor=fillReplicatedFields; value=auxInfoBO.getValuationRateDuration(); source=cache:BondAuxInfoV5CacheService#listByBondUniCodes; path:POST /internal/cs-dwd/valuation/list-latest/uni-code/cross-market/valuation-types")
    private BigDecimal valuationRateDuration;

    @ApiModelProperty("估值利差久期。[V5:F9_AUX_CACHE] anchor=fillReplicatedFields; value=auxInfoBO.getValuationSpreadDuration(); source=cache:BondAuxInfoV5CacheService#listByBondUniCodes; path:POST /internal/cs-dwd/valuation/list-latest/uni-code/cross-market/valuation-types")
    private BigDecimal valuationSpreadDuration;

    @ApiModelProperty("下次付息日（T-0实时,min(inteStartDate>today)）。[V5:CASHFLOW_COMPUTED] anchor=fillReplicatedFields; value=computeNextInterestDate(cashFlowList); source=calc:OnshoreBondFilterV5ServiceImpl#fillReplicatedFields; fields=BondCashFlowChartDO.bondUniCode/inteStartDate/prinPayAmount/isvalid; table=bond_cash_flow_chart")
    private Date nextInterestDate;

    @ApiModelProperty("最新面值（issueParValue-累计已偿还本金）。[V5:CASHFLOW_COMPUTED] anchor=fillReplicatedFields; value=currentPar; source=calc:OnshoreBondFilterV5ServiceImpl#fillReplicatedFields; fields=BondCashFlowChartDO.bondUniCode/inteStartDate/prinPayAmount/isvalid; table=bond_cash_flow_chart")
    private BigDecimal currentParValue;

    @ApiModelProperty("全字段内容哈希 MD5（内容门控：哈希不变则不写、update_time 不动）。[V5:SYSTEM_LATEST] anchor=Timestamp; value=OnshoreBondFilterV5Converter.contentHash(v5do); source=system:OnshoreBondFilterV5ServiceImpl#saveLatestWithContentGate; fields=all persisted V5DO business columns except id/create_time/update_time/content_hash/content_length")
    private String contentHash;

    @ApiModelProperty("内容长度（contentHash 计算时 JSON 串的 UTF-8 字节数，辅助 hash 碰撞排查与增量预判）。[V5:SYSTEM_LATEST] anchor=contentHash; value=null; source=system:OnshoreBondFilterV5ServiceImpl#saveLatestWithContentGate; fields=contentHash JSON UTF-8 byte length")
    private Integer contentLength;

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

    public String getDisplayBondType() {
        return displayBondType;
    }

    public void setDisplayBondType(String displayBondType) {
        this.displayBondType = displayBondType;
    }

    public String getDisplayBusinessNature() {
        return displayBusinessNature;
    }

    public void setDisplayBusinessNature(String displayBusinessNature) {
        this.displayBusinessNature = displayBusinessNature;
    }

    public String getDisplayInterestPaymentFrequency() {
        return displayInterestPaymentFrequency;
    }

    public void setDisplayInterestPaymentFrequency(String displayInterestPaymentFrequency) {
        this.displayInterestPaymentFrequency = displayInterestPaymentFrequency;
    }

    public String getDisplayRateType() {
        return displayRateType;
    }

    public void setDisplayRateType(String displayRateType) {
        this.displayRateType = displayRateType;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getGuaranteeName() {
        return guaranteeName;
    }

    public void setGuaranteeName(String guaranteeName) {
        this.guaranteeName = guaranteeName;
    }

    public String getPublicOfferingName() {
        return publicOfferingName;
    }

    public void setPublicOfferingName(String publicOfferingName) {
        this.publicOfferingName = publicOfferingName;
    }

    public String getRateTypeName() {
        return rateTypeName;
    }

    public void setRateTypeName(String rateTypeName) {
        this.rateTypeName = rateTypeName;
    }

    public String getEmbeddedOptionName() {
        return embeddedOptionName;
    }

    public void setEmbeddedOptionName(String embeddedOptionName) {
        this.embeddedOptionName = embeddedOptionName;
    }

    public String getBondTypeName() {
        return bondTypeName;
    }

    public void setBondTypeName(String bondTypeName) {
        this.bondTypeName = bondTypeName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getUrbanAreaLevelName() {
        return urbanAreaLevelName;
    }

    public void setUrbanAreaLevelName(String urbanAreaLevelName) {
        this.urbanAreaLevelName = urbanAreaLevelName;
    }

    public String getUrbanAreaName() {
        return urbanAreaName;
    }

    public void setUrbanAreaName(String urbanAreaName) {
        this.urbanAreaName = urbanAreaName;
    }

    public String getUrbanCityName() {
        return urbanCityName;
    }

    public void setUrbanCityName(String urbanCityName) {
        this.urbanCityName = urbanCityName;
    }

    public String getUrbanProvinceName() {
        return urbanProvinceName;
    }

    public void setUrbanProvinceName(String urbanProvinceName) {
        this.urbanProvinceName = urbanProvinceName;
    }

    public String getBusinessNatureName() {
        return businessNatureName;
    }

    public void setBusinessNatureName(String businessNatureName) {
        this.businessNatureName = businessNatureName;
    }

    public String getComExtRatingComName() {
        return comExtRatingComName;
    }

    public void setComExtRatingComName(String comExtRatingComName) {
        this.comExtRatingComName = comExtRatingComName;
    }

    public String getIntlExtRating() {
        return intlExtRating;
    }

    public void setIntlExtRating(String intlExtRating) {
        this.intlExtRating = intlExtRating;
    }

    public String getIntlExtRatingComName() {
        return intlExtRatingComName;
    }

    public void setIntlExtRatingComName(String intlExtRatingComName) {
        this.intlExtRatingComName = intlExtRatingComName;
    }

    public String getBondExtRatingComName() {
        return bondExtRatingComName;
    }

    public void setBondExtRatingComName(String bondExtRatingComName) {
        this.bondExtRatingComName = bondExtRatingComName;
    }

    public String getGuarantorFullName() {
        return guarantorFullName;
    }

    public void setGuarantorFullName(String guarantorFullName) {
        this.guarantorFullName = guarantorFullName;
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

    public Date getInterestStartDate() {
        return interestStartDate;
    }

    public void setInterestStartDate(Date interestStartDate) {
        this.interestStartDate = interestStartDate;
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

    public Date getActuDelistDate() {
        return actuDelistDate;
    }

    public void setActuDelistDate(Date actuDelistDate) {
        this.actuDelistDate = actuDelistDate;
    }

    public Date getDebtRegDate() {
        return debtRegDate;
    }

    public void setDebtRegDate(Date debtRegDate) {
        this.debtRegDate = debtRegDate;
    }

    public Date getTheoDelistDate() {
        return theoDelistDate;
    }

    public void setTheoDelistDate(Date theoDelistDate) {
        this.theoDelistDate = theoDelistDate;
    }

    public Date getLastTradeDate() {
        return lastTradeDate;
    }

    public void setLastTradeDate(Date lastTradeDate) {
        this.lastTradeDate = lastTradeDate;
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

    public BigDecimal getBondBalanceTenK() {
        return bondBalanceTenK;
    }

    public void setBondBalanceTenK(BigDecimal bondBalanceTenK) {
        this.bondBalanceTenK = bondBalanceTenK;
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

    public Integer getUrbanInvest() {
        return urbanInvest;
    }

    public void setUrbanInvest(Integer urbanInvest) {
        this.urbanInvest = urbanInvest;
    }

    public Integer getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(Integer guarantee) {
        this.guarantee = guarantee;
    }

    public Integer getUrbanAreaLevel() {
        return urbanAreaLevel;
    }

    public void setUrbanAreaLevel(Integer urbanAreaLevel) {
        this.urbanAreaLevel = urbanAreaLevel;
    }

    public Long getUrbanAreaUniCode() {
        return urbanAreaUniCode;
    }

    public void setUrbanAreaUniCode(Long urbanAreaUniCode) {
        this.urbanAreaUniCode = urbanAreaUniCode;
    }

    public Long getUrbanCityUniCode() {
        return urbanCityUniCode;
    }

    public void setUrbanCityUniCode(Long urbanCityUniCode) {
        this.urbanCityUniCode = urbanCityUniCode;
    }

    public Long getUrbanProvinceUniCode() {
        return urbanProvinceUniCode;
    }

    public void setUrbanProvinceUniCode(Long urbanProvinceUniCode) {
        this.urbanProvinceUniCode = urbanProvinceUniCode;
    }

    public Integer getCarbonNeutralBondStatus() {
        return carbonNeutralBondStatus;
    }

    public void setCarbonNeutralBondStatus(Integer carbonNeutralBondStatus) {
        this.carbonNeutralBondStatus = carbonNeutralBondStatus;
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

    public Integer getBondTermType() {
        return bondTermType;
    }

    public void setBondTermType(Integer bondTermType) {
        this.bondTermType = bondTermType;
    }

    public Integer getDefaultTag() {
        return defaultTag;
    }

    public void setDefaultTag(Integer defaultTag) {
        this.defaultTag = defaultTag;
    }

    public Integer getGuaranteedSettlementStatus() {
        return guaranteedSettlementStatus;
    }

    public void setGuaranteedSettlementStatus(Integer guaranteedSettlementStatus) {
        this.guaranteedSettlementStatus = guaranteedSettlementStatus;
    }

    public Integer getInterestPaymentMethod() {
        return interestPaymentMethod;
    }

    public void setInterestPaymentMethod(Integer interestPaymentMethod) {
        this.interestPaymentMethod = interestPaymentMethod;
    }

    public Integer getRepayClsPayType() {
        return repayClsPayType;
    }

    public void setRepayClsPayType(Integer repayClsPayType) {
        this.repayClsPayType = repayClsPayType;
    }

    public Integer getCouponResetPeriod() {
        return couponResetPeriod;
    }

    public void setCouponResetPeriod(Integer couponResetPeriod) {
        this.couponResetPeriod = couponResetPeriod;
    }

    public Integer getCouponResetPeriodUnit() {
        return couponResetPeriodUnit;
    }

    public void setCouponResetPeriodUnit(Integer couponResetPeriodUnit) {
        this.couponResetPeriodUnit = couponResetPeriodUnit;
    }

    public Integer getSecuritySeniorityRanking() {
        return securitySeniorityRanking;
    }

    public void setSecuritySeniorityRanking(Integer securitySeniorityRanking) {
        this.securitySeniorityRanking = securitySeniorityRanking;
    }

    public Integer getBankSeniorityRanking() {
        return bankSeniorityRanking;
    }

    public void setBankSeniorityRanking(Integer bankSeniorityRanking) {
        this.bankSeniorityRanking = bankSeniorityRanking;
    }

    public Integer getInsuranceSeniorityRanking() {
        return insuranceSeniorityRanking;
    }

    public void setInsuranceSeniorityRanking(Integer insuranceSeniorityRanking) {
        this.insuranceSeniorityRanking = insuranceSeniorityRanking;
    }

    public Integer getNonFixInteFreqStatus() {
        return nonFixInteFreqStatus;
    }

    public void setNonFixInteFreqStatus(Integer nonFixInteFreqStatus) {
        this.nonFixInteFreqStatus = nonFixInteFreqStatus;
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

    public BigDecimal getUdicScore() {
        return udicScore;
    }

    public void setUdicScore(BigDecimal udicScore) {
        this.udicScore = udicScore;
    }

    public String getBondFullName() {
        return bondFullName;
    }

    public void setBondFullName(String bondFullName) {
        this.bondFullName = bondFullName;
    }

    public String getInduLevel1Name() {
        return induLevel1Name;
    }

    public void setInduLevel1Name(String induLevel1Name) {
        this.induLevel1Name = induLevel1Name;
    }

    public String getInduLevel2Name() {
        return induLevel2Name;
    }

    public void setInduLevel2Name(String induLevel2Name) {
        this.induLevel2Name = induLevel2Name;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getRecruitmentFundUse() {
        return recruitmentFundUse;
    }

    public void setRecruitmentFundUse(String recruitmentFundUse) {
        this.recruitmentFundUse = recruitmentFundUse;
    }

    public BigDecimal getIssueCouponRate() {
        return issueCouponRate;
    }

    public void setIssueCouponRate(BigDecimal issueCouponRate) {
        this.issueCouponRate = issueCouponRate;
    }

    public BigDecimal getIssueParValue() {
        return issueParValue;
    }

    public void setIssueParValue(BigDecimal issueParValue) {
        this.issueParValue = issueParValue;
    }

    public Long getCustodianUniCode() {
        return custodianUniCode;
    }

    public void setCustodianUniCode(Long custodianUniCode) {
        this.custodianUniCode = custodianUniCode;
    }

    public String getCustodianFullName() {
        return custodianFullName;
    }

    public void setCustodianFullName(String custodianFullName) {
        this.custodianFullName = custodianFullName;
    }

    public Long getShareholderUniCode() {
        return shareholderUniCode;
    }

    public void setShareholderUniCode(Long shareholderUniCode) {
        this.shareholderUniCode = shareholderUniCode;
    }

    public String getShareholderName() {
        return shareholderName;
    }

    public void setShareholderName(String shareholderName) {
        this.shareholderName = shareholderName;
    }

    public BigDecimal getShareholdingRatio() {
        return shareholdingRatio;
    }

    public void setShareholdingRatio(BigDecimal shareholdingRatio) {
        this.shareholdingRatio = shareholdingRatio;
    }

    public Long getRealControlUniCode() {
        return realControlUniCode;
    }

    public void setRealControlUniCode(Long realControlUniCode) {
        this.realControlUniCode = realControlUniCode;
    }

    public String getRealControlName() {
        return realControlName;
    }

    public void setRealControlName(String realControlName) {
        this.realControlName = realControlName;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Date getTenderDocumentationDate() {
        return tenderDocumentationDate;
    }

    public void setTenderDocumentationDate(Date tenderDocumentationDate) {
        this.tenderDocumentationDate = tenderDocumentationDate;
    }

    public BigDecimal getIssueCommissionRate() {
        return issueCommissionRate;
    }

    public void setIssueCommissionRate(BigDecimal issueCommissionRate) {
        this.issueCommissionRate = issueCommissionRate;
    }

    public Integer getMarketizationStatus() {
        return marketizationStatus;
    }

    public void setMarketizationStatus(Integer marketizationStatus) {
        this.marketizationStatus = marketizationStatus;
    }

    public String getCsImpliedRating() {
        return csImpliedRating;
    }

    public void setCsImpliedRating(String csImpliedRating) {
        this.csImpliedRating = csImpliedRating;
    }

    public BigDecimal getCsMaturityValuationNetPrice() {
        return csMaturityValuationNetPrice;
    }

    public void setCsMaturityValuationNetPrice(BigDecimal csMaturityValuationNetPrice) {
        this.csMaturityValuationNetPrice = csMaturityValuationNetPrice;
    }

    public BigDecimal getCsMaturityValuationYield() {
        return csMaturityValuationYield;
    }

    public void setCsMaturityValuationYield(BigDecimal csMaturityValuationYield) {
        this.csMaturityValuationYield = csMaturityValuationYield;
    }

    public Date getCsMaturityValuationDate() {
        return csMaturityValuationDate;
    }

    public void setCsMaturityValuationDate(Date csMaturityValuationDate) {
        this.csMaturityValuationDate = csMaturityValuationDate;
    }

    public Date getCsValuationDisplayDate() {
        return csValuationDisplayDate;
    }

    public void setCsValuationDisplayDate(Date csValuationDisplayDate) {
        this.csValuationDisplayDate = csValuationDisplayDate;
    }

    public BigDecimal getCsExerciseValuationNetPrice() {
        return csExerciseValuationNetPrice;
    }

    public void setCsExerciseValuationNetPrice(BigDecimal csExerciseValuationNetPrice) {
        this.csExerciseValuationNetPrice = csExerciseValuationNetPrice;
    }

    public BigDecimal getCsExerciseValuationYield() {
        return csExerciseValuationYield;
    }

    public void setCsExerciseValuationYield(BigDecimal csExerciseValuationYield) {
        this.csExerciseValuationYield = csExerciseValuationYield;
    }

    public Date getCsExerciseValuationDate() {
        return csExerciseValuationDate;
    }

    public void setCsExerciseValuationDate(Date csExerciseValuationDate) {
        this.csExerciseValuationDate = csExerciseValuationDate;
    }

    public BigDecimal getChinaBondMaturityValuationNetPrice() {
        return chinaBondMaturityValuationNetPrice;
    }

    public void setChinaBondMaturityValuationNetPrice(BigDecimal chinaBondMaturityValuationNetPrice) {
        this.chinaBondMaturityValuationNetPrice = chinaBondMaturityValuationNetPrice;
    }

    public BigDecimal getChinaBondMaturityValuationYield() {
        return chinaBondMaturityValuationYield;
    }

    public void setChinaBondMaturityValuationYield(BigDecimal chinaBondMaturityValuationYield) {
        this.chinaBondMaturityValuationYield = chinaBondMaturityValuationYield;
    }

    public Date getChinaBondMaturityValuationDate() {
        return chinaBondMaturityValuationDate;
    }

    public void setChinaBondMaturityValuationDate(Date chinaBondMaturityValuationDate) {
        this.chinaBondMaturityValuationDate = chinaBondMaturityValuationDate;
    }

    public Date getChinaBondValuationDisplayDate() {
        return chinaBondValuationDisplayDate;
    }

    public void setChinaBondValuationDisplayDate(Date chinaBondValuationDisplayDate) {
        this.chinaBondValuationDisplayDate = chinaBondValuationDisplayDate;
    }

    public BigDecimal getChinaBondExerciseValuationNetPrice() {
        return chinaBondExerciseValuationNetPrice;
    }

    public void setChinaBondExerciseValuationNetPrice(BigDecimal chinaBondExerciseValuationNetPrice) {
        this.chinaBondExerciseValuationNetPrice = chinaBondExerciseValuationNetPrice;
    }

    public BigDecimal getChinaBondExerciseValuationYield() {
        return chinaBondExerciseValuationYield;
    }

    public void setChinaBondExerciseValuationYield(BigDecimal chinaBondExerciseValuationYield) {
        this.chinaBondExerciseValuationYield = chinaBondExerciseValuationYield;
    }

    public Date getChinaBondExerciseValuationDate() {
        return chinaBondExerciseValuationDate;
    }

    public void setChinaBondExerciseValuationDate(Date chinaBondExerciseValuationDate) {
        this.chinaBondExerciseValuationDate = chinaBondExerciseValuationDate;
    }

    public BigDecimal getReferenceYield() {
        return referenceYield;
    }

    public void setReferenceYield(BigDecimal referenceYield) {
        this.referenceYield = referenceYield;
    }

    public Integer getNotDiscountAndCd() {
        return notDiscountAndCd;
    }

    public void setNotDiscountAndCd(Integer notDiscountAndCd) {
        this.notDiscountAndCd = notDiscountAndCd;
    }

    public BigDecimal getValuationModifiedDuration() {
        return valuationModifiedDuration;
    }

    public void setValuationModifiedDuration(BigDecimal valuationModifiedDuration) {
        this.valuationModifiedDuration = valuationModifiedDuration;
    }

    public BigDecimal getValuationRateDuration() {
        return valuationRateDuration;
    }

    public void setValuationRateDuration(BigDecimal valuationRateDuration) {
        this.valuationRateDuration = valuationRateDuration;
    }

    public BigDecimal getValuationSpreadDuration() {
        return valuationSpreadDuration;
    }

    public void setValuationSpreadDuration(BigDecimal valuationSpreadDuration) {
        this.valuationSpreadDuration = valuationSpreadDuration;
    }

    public Date getNextInterestDate() {
        return nextInterestDate;
    }

    public void setNextInterestDate(Date nextInterestDate) {
        this.nextInterestDate = nextInterestDate;
    }

    public BigDecimal getCurrentParValue() {
        return currentParValue;
    }

    public void setCurrentParValue(BigDecimal currentParValue) {
        this.currentParValue = currentParValue;
    }

    public String getContentHash() {
        return contentHash;
    }

    public void setContentHash(String contentHash) {
        this.contentHash = contentHash;
    }

    public Integer getContentLength() {
        return contentLength;
    }

    public void setContentLength(Integer contentLength) {
        this.contentLength = contentLength;
    }

    public String getUpdateByDis() {
        return updateByDis;
    }

    public void setUpdateByDis(String updateByDis) {
        this.updateByDis = updateByDis;
    }
}
