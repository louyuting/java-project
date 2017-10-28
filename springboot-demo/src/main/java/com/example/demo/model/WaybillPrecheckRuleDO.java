package com.example.demo.model;

/**
 * 数据库对应映射对象
 * @author ximu
 * @description
 * @email chris.lyt@alibaba-inc.com
 * @date 2017/8/12
 */
public class WaybillPrecheckRuleDO {
    private Long id;
    private String cpCode;
    private String prefix;
    private Long seqStart;
    private Long seqEnd;
    private String validateCode;
    private Integer validateLength;
    private Integer validateCodeOffset;
    private String suffix;
    private Integer length;
    private String finalRule;
    private String bakJson;

    public WaybillPrecheckRuleDO() {
    }

    public WaybillPrecheckRuleDO(Long id, String cpCode, String prefix, Long seqStart, Long seqEnd,
                                 String validateCode, Integer validateLength, Integer validateCodeOffset,
                                 String suffix, Integer length, String finalRule, String bakJson) {
        this.id = id;
        this.cpCode = cpCode;
        this.prefix = prefix;
        this.seqStart = seqStart;
        this.seqEnd = seqEnd;
        this.validateCode = validateCode;
        this.validateLength = validateLength;
        this.validateCodeOffset = validateCodeOffset;
        this.suffix = suffix;
        this.length = length;
        this.finalRule = finalRule;
        this.bakJson = bakJson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpCode() {
        return cpCode;
    }

    public void setCpCode(String cpCode) {
        this.cpCode = cpCode;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Long getSeqStart() {
        return seqStart;
    }

    public void setSeqStart(Long seqStart) {
        this.seqStart = seqStart;
    }

    public Long getSeqEnd() {
        return seqEnd;
    }

    public void setSeqEnd(Long seqEnd) {
        this.seqEnd = seqEnd;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public Integer getValidateLength() {
        return validateLength;
    }

    public void setValidateLength(Integer validateLength) {
        this.validateLength = validateLength;
    }

    public Integer getValidateCodeOffset() {
        return validateCodeOffset;
    }

    public void setValidateCodeOffset(Integer validateCodeOffset) {
        this.validateCodeOffset = validateCodeOffset;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getFinalRule() {
        return finalRule;
    }

    public void setFinalRule(String finalRule) {
        this.finalRule = finalRule;
    }

    public String getBakJson() {
        return bakJson;
    }

    public void setBakJson(String bakJson) {
        this.bakJson = bakJson;
    }

    @Override
    public String toString() {
        return "WaybillPrecheckRuleDO{" +
            "id=" + id +
            ", cpCode='" + cpCode + '\'' +
            ", prefix='" + prefix + '\'' +
            ", seqStart=" + seqStart +
            ", seqEnd=" + seqEnd +
            ", validateCode='" + validateCode + '\'' +
            ", validateLength=" + validateLength +
            ", validateCodeOffset=" + validateCodeOffset +
            ", suffix='" + suffix + '\'' +
            ", length=" + length +
            ", finalRule='" + finalRule + '\'' +
            ", bakJson='" + bakJson + '\'' +
            '}';
    }
}
