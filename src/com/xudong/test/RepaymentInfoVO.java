package com.xudong.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Title: RepaymentInfoVO.java 
 * @Package com.microcredit.plan.vo 
 * @Description: 还款计划表参数VO 
 * @author wangwen   
 * @date 2014-11-5 下午06:08:40 
 * @version V1.0
 */
public class RepaymentInfoVO {
	public static final String TERMUNIT_YEAR = "Y"; // 还款计划周期单位：年

	public static final String TERMUNIT_HALFYEAR = "H"; // 还款计划周期单位：半年

	public static final String TERMUNIT_QUARTER = "S"; // 还款计划周期单位：季

	public static final String TERMUNIT_MONTH = "M"; // 还款计划周期单位：月（默认）
	
	public static final String TERMUNIT_S_MONTH = "B"; // 还款计划周期单位：双月
	
	public static final String TERMUNIT_DAY = "D";// 还款计划周期单位：天
	
	public static final String TERMUNIT_WEEK = "W";// 还款计划周期单位：周
	
	public static final String TERMUNIT_FORTNIGHT = "F";// 还款计划周期单位：两周
	
	public static final String ISAVOIDHF_YES = "1";//是否规避节假日  是
	
	public static final String ISAVOIDHF_NO = "0";//是否规避节假日  否
	
	public static final String PLANWAY_PRINCIPAL = "1"; //还款计划方式：等额本息
	
	public static final String PLANWAY_PRINCIPAL_PEI = "0"; //还款计划方式：等额本息(一次还本，按期还息)

	public static final String PLANWAY_EQUAL = "2"; //还款计划方式：等额本金
	
	public static final String PLANWAY_ALL_PEI = "3"; //还款计划方式：一次还本，按期还息
	
	public static final String PLANWAY_ALL_PEI_A = "A"; //还款计划方式：一次还本，按期还息(金鼎信)
	
	public static final String PLANWAY_ALL_PI = "4"; //还款计划方式：一次还本付息
	
	public static final String PLANWAY_ALL_PEI_Q = "5";//按月付息，按季等额还本
	
	public static final String PLANWAY_ALL_PEI_HY = "6";//按月还息，半年还本
	
	public static final String PLANWAY_ALL_PEI_Y = "7";//按月还息，按年还本
	
	public static final String PLANWAY_IRREGULAR_PAYMENTS = "8";//不规则还款
	
	public static final String PLANWAY_EQUAL_BROIBS = "9";//还款计划方式：等额本息，减本不减息
	
	public static final String PLANINT_COM0 = "0";//还款计划表计息规则，0：算头不算尾
	
	public static final String PLANINT_COM1 = "1";//还款计划表计息规则，1：算头又算尾
	
	public static final String RZFEE_MODE1 = "1";//融资服务费收取形式：期初
	public static final String RZFEE_MODE2 = "2";//融资服务费收取形式：期末
	public static final String RZFEE_MODE3 = "3";//融资服务费收取形式：期初+期末
	
	public static final String RZFEE_BEARMANNER1 = "1";//融资服务费计息方式（1=日计息，2= 月计息）
	public static final String RZFEE_BEARMANNER2 = "2";//融资服务费计息方式（1=日计息，2= 月计息）

	public static final String BUSFEE_FLAG0 = "0";//业务推介费收取方式：自主收取
	public static final String BUSFEE_FLAG1 = "1";//业务推介费收取方式：委托收取
	public static final String BUSFEE_FLAG2 = "2";//业务推介费收取方式：自主+委托
	
	public static final String BUSFEE_MODE1 = "1";//业务推介费收取形式：期初
	public static final String BUSFEE_MODE2 = "2";//业务推介费收取形式：期末
	public static final String BUSFEE_MODE3 = "3";//业务推介费收取形式：期初+期末
	
	public static final String BUSFEE_BEARMANNER1 = "1";//业务推介费计息方式（1=日计息，2= 月计息）
	public static final String BUSFEE_BEARMANNER2 = "2";//业务推介费计息方式（1=日计息，2= 月计息）
	
	public static final String FEE_BEARMANNER1 = "1";//管理费计息方式（1=日计息，2= 月计息）
	public static final String FEE_BEARMANNER2 = "2";//管理费计息方式（1=日计息，2= 月计息）
	
	public static final String OTHERFEE_MODE0 = "0";//除利率外的费率，计算方式，0：各自按利率计算，
	public static final String OTHERFEE_MODE1 = "1";//除利率外的费率，计算方式，1：总利率计算后按利率比例拆分
	
	private String loandate;//放款日
	
	private String loanamount;//放款金额
	
	private String old_loanamount;//原始放款金额
	
	private String loanrates;//放款利率
	
	private String total_loanrates;//总利率
	
	private String loanterm;//贷款期限
	
	private String insnumber;//分期期数
	
	private String timeunit;//期数单位（T=天，Z=周，W=两周，M=月，S=双月，J=季，B=半年，N=年）
	
	private String firstrepdate;//计划首次还款日
	
	private String receivedmode;//收息方式(1=期初，2=期末)
	
	private String bearmanner;//计息方式（1=日计息，2= 月计息）
	
	private String methodrepayment;//还款方式
	
	private BigDecimal creaseAmt;//等额递增和等额递减的每期本金变化值
	
	private String planFlag;
	
	private BigDecimal balance;//贷款余额
	
	private Integer termid;// 当期期数
	
	private String currentLendDay;//当期还款日
	
	private String endLendDay;//最后一期还款日
	
	private String periodLendDay;//上一期还款日
	
	private Integer format_posi;//金额格式化位数
	
	private Integer format_rate;//利率格式化位数
	
	private Integer lockFlag;//锁定笔数[1=锁定本本金/2= 锁定本息/0=未锁定]
	
	private String modPlan;//是否是修改还款计划（T=修改还款计划/E=提前还款）
	
	private Integer cyclenumber = 1;//循环期数
	
	private String isdatacoll;//是否是补录数据
	
	private String isBeyond;//是否超出人行利率4倍[0=未超 /1=已超]
	
	private BigDecimal manExpenseFee;//管理费（月利率）
	
	private String feetype;//管理费收取方式[1=期末收、2=期初收 ]
	
	private String dFirstrepdate="";//初始的还款计划表的计划首次还款日
	
	private String firstInterestType;//首期利息生成方式[1=日计息，2= 月计息]
	
	private BigDecimal feeAmount = BigDecimal.ZERO;//期初收利的管理费金额
	
	private String planintscom;//还款计划表计息规则（0：算头不算尾、1：算头又算尾）
	
	private String firPayDay;//每期固定还款日
	
	private String otherFeeMode = "";//除利率外的费率，计算方式，0：各自按利率计算，1：总利率计算后按利率比例拆分
	
	private String rzFeeMode;//融资服务费收取模式【1：期初/2：期末；3：期初+期末】
	private String rzFeeRate;//融资服务费率
	private String rzFeeRateAf;//融资服务费率
	private String rzFeeAmt;//融资服务费
	private String rzFeeAmtAf;//融资服务费
	private String rzFeeBearmanner;//融资服务费计息方式【1=日计息，2=月计息】

	private String busFeeForm;//业务推介费收取形式【0：自主/1：委托；2：自主+委托】
	private String busFeeMode;//业务推介费收取模式【1：期初/2：期末；3：期初+期末】
	private String busFeeRate;//业务推介费率
	private String busFeeRateAf;//业务推介费率
	private String busFeeAmt;//业务推介费
	private String busFeeAmtAf;//业务推介费
	private String busFeeBearmanner;//业务推介费计息方式【1=日计息，2=月计息】
	private String feeBearmanner;//管理费计息方式【1=日计息，2=月计息】
	
	private String bnspFlag;//特殊续贷标记[1:特殊续贷，其他：非特殊续贷]
	private String preEndReturnDate;//上次结清还款日  amash表的 VALUEDATE顺排，第一个endflag=1的VALUEDATE
	
	public String getTotal_loanrates() {
		return total_loanrates;
	}

	public void setTotal_loanrates(String total_loanrates) {
		this.total_loanrates = total_loanrates;
	}

	public String getBusFeeForm() {
		return busFeeForm;
	}

	public void setBusFeeForm(String busFeeForm) {
		this.busFeeForm = busFeeForm;
	}

	public String getFeeBearmanner() {
		return feeBearmanner;
	}

	public void setFeeBearmanner(String feeBearmanner) {
		this.feeBearmanner = feeBearmanner;
	}

	public String getRzFeeBearmanner() {
		return rzFeeBearmanner;
	}

	public void setRzFeeBearmanner(String rzFeeBearmanner) {
		this.rzFeeBearmanner = rzFeeBearmanner;
	}

	public String getBusFeeBearmanner() {
		return busFeeBearmanner;
	}

	public void setBusFeeBearmanner(String busFeeBearmanner) {
		this.busFeeBearmanner = busFeeBearmanner;
	}

	public String getRzFeeRateAf() {
		return rzFeeRateAf;
	}

	public void setRzFeeRateAf(String rzFeeRateAf) {
		this.rzFeeRateAf = rzFeeRateAf;
	}

	public String getRzFeeAmtAf() {
		return rzFeeAmtAf;
	}

	public void setRzFeeAmtAf(String rzFeeAmtAf) {
		this.rzFeeAmtAf = rzFeeAmtAf;
	}

	public String getBusFeeRateAf() {
		return busFeeRateAf;
	}

	public void setBusFeeRateAf(String busFeeRateAf) {
		this.busFeeRateAf = busFeeRateAf;
	}

	public String getBusFeeAmtAf() {
		return busFeeAmtAf;
	}

	public void setBusFeeAmtAf(String busFeeAmtAf) {
		this.busFeeAmtAf = busFeeAmtAf;
	}

	public String getRzFeeMode() {
		return rzFeeMode;
	}

	public void setRzFeeMode(String rzFeeMode) {
		this.rzFeeMode = rzFeeMode;
	}

	public String getRzFeeRate() {
		return rzFeeRate;
	}

	public void setRzFeeRate(String rzFeeRate) {
		this.rzFeeRate = rzFeeRate;
	}

	public String getRzFeeAmt() {
		return rzFeeAmt;
	}

	public void setRzFeeAmt(String rzFeeAmt) {
		this.rzFeeAmt = rzFeeAmt;
	}

	public String getBusFeeMode() {
		return busFeeMode;
	}

	public void setBusFeeMode(String busFeeMode) {
		this.busFeeMode = busFeeMode;
	}

	public String getBusFeeRate() {
		return busFeeRate;
	}

	public void setBusFeeRate(String busFeeRate) {
		this.busFeeRate = busFeeRate;
	}

	public String getBusFeeAmt() {
		return busFeeAmt;
	}

	public void setBusFeeAmt(String busFeeAmt) {
		this.busFeeAmt = busFeeAmt;
	}

	public String getFirPayDay() {
		return firPayDay;
	}

	public void setFirPayDay(String firPayDay) {
		this.firPayDay = firPayDay;
	}

	public String getPlanintscom() {
		return planintscom;
	}

	public void setPlanintscom(String planintscom) {
		this.planintscom = planintscom;
	}

	public String getLoandate() {
		return loandate;
	}

	public void setLoandate(String loandate) {
		this.loandate = loandate;
	}

	public String getLoanamount() {
		return loanamount;
	}

	public void setLoanamount(String loanamount) {
		this.loanamount = loanamount;
	}

	public String getLoanrates() {
		return loanrates;
	}

	public void setLoanrates(String loanrates) {
		this.loanrates = loanrates;
	}

	public String getLoanterm() {
		return loanterm;
	}

	public void setLoanterm(String loanterm) {
		this.loanterm = loanterm;
	}

	public String getInsnumber() {
		return insnumber;
	}

	public void setInsnumber(String insnumber) {
		this.insnumber = insnumber;
	}

	public String getTimeunit() {
		return timeunit;
	}

	public void setTimeunit(String timeunit) {
		this.timeunit = timeunit;
	}

	public String getFirstrepdate() {
		return firstrepdate;
	}

	public void setFirstrepdate(String firstrepdate) {
		this.firstrepdate = firstrepdate;
	}

	public String getReceivedmode() {
		return receivedmode;
	}

	public void setReceivedmode(String receivedmode) {
		this.receivedmode = receivedmode;
	}

	public String getBearmanner() {
		return bearmanner;
	}

	public void setBearmanner(String bearmanner) {
		this.bearmanner = bearmanner;
	}

	public String getMethodrepayment() {
		return methodrepayment;
	}

	public void setMethodrepayment(String methodrepayment) {
		this.methodrepayment = methodrepayment;
	}

	public BigDecimal getCreaseAmt() {
		return creaseAmt;
	}

	public void setCreaseAmt(BigDecimal creaseAmt) {
		this.creaseAmt = creaseAmt;
	}

	public String getPlanFlag() {
		return planFlag;
	}

	public void setPlanFlag(String planFlag) {
		this.planFlag = planFlag;
	}

	public String getCurrentLendDay() {
		return currentLendDay;
	}

	public void setCurrentLendDay(String currentLendDay) {
		this.currentLendDay = currentLendDay;
	}

	public String getPeriodLendDay() {
		return periodLendDay;
	}

	public void setPeriodLendDay(String periodLendDay) {
		this.periodLendDay = periodLendDay;
	}

	public Integer getTermid() {
		return termid;
	}

	public void setTermid(Integer termid) {
		this.termid = termid;
	}

	public Integer getFormat_posi() {
		return format_posi;
	}

	public void setFormat_posi(Integer format_posi) {
		this.format_posi = format_posi;
	}

	public Integer getLockFlag() {
		return lockFlag;
	}

	public void setLockFlag(Integer lockFlag) {
		this.lockFlag = lockFlag;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getModPlan() {
		return modPlan;
	}

	public void setModPlan(String modPlan) {
		this.modPlan = modPlan;
	}

	public Integer getCyclenumber() {
		return cyclenumber;
	}

	public void setCyclenumber(Integer cyclenumber) {
		this.cyclenumber = cyclenumber;
	}

	public String getIsdatacoll() {
		return isdatacoll;
	}

	public void setIsdatacoll(String isdatacoll) {
		this.isdatacoll = isdatacoll;
	}

	public String getdFirstrepdate() {
		return dFirstrepdate;
	}

	public void setdFirstrepdate(String dFirstrepdate) {
		this.dFirstrepdate = dFirstrepdate;
	}
	public String getIsBeyond() {
		return isBeyond;
	}

	public void setIsBeyond(String isBeyond) {
		this.isBeyond = isBeyond;
	}

	public BigDecimal getManExpenseFee() {
		return manExpenseFee;
	}

	public void setManExpenseFee(BigDecimal manExpenseFee) {
		this.manExpenseFee = manExpenseFee;
	}

	public String getFeetype() {
		return feetype;
	}

	public void setFeetype(String feetype) {
		this.feetype = feetype;
	}

	public String getFirstInterestType() {
		return firstInterestType;
	}

	public void setFirstInterestType(String firstInterestType) {
		this.firstInterestType = firstInterestType;
	}
	public BigDecimal getFeeAmount() {
		return feeAmount;
	}

	public void setFeeAmount(BigDecimal feeAmount) {
		this.feeAmount = feeAmount;
	}
	
	public Integer getFormat_rate() {
		return format_rate;
	}

	public void setFormat_rate(Integer format_rate) {
		this.format_rate = format_rate;
	}
	
	public String getEndLendDay() {
		return endLendDay;
	}

	public void setEndLendDay(String endLendDay) {
		this.endLendDay = endLendDay;
	}
	
	public String getOld_loanamount() {
		return old_loanamount;
	}

	public void setOld_loanamount(String old_loanamount) {
		this.old_loanamount = old_loanamount;
	}

	public String getOtherFeeMode() {
		return otherFeeMode;
	}

	public void setOtherFeeMode(String otherFeeMode) {
		this.otherFeeMode = otherFeeMode;
	}
	
	public String getBnspFlag() {
		return bnspFlag;
	}

	public void setBnspFlag(String bnspFlag) {
		this.bnspFlag = bnspFlag;
	}

	public String getPreEndReturnDate() {
		return preEndReturnDate;
	}

	public void setPreEndReturnDate(String preEndReturnDate) {
		this.preEndReturnDate = preEndReturnDate;
	}

	/**
	 * @Title: assignment 
	 * @Description: 取页面数据
	 * @param @param map
	 * @return void 
	 * @throws
	 */
	public void assignment(Map map){
	}
}
