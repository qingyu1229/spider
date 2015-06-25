package org.beyong.parse.rule;

/**
 * Created by 梁擎宇 on 15-6-25.
 */
public class SupportUrlRule {

    /**
     * 非目标页面URL发掘规则：
     * 属性1：depth,说明：URL所处的深度,是否可以为空：是
     * 属性2：ruleType,说明：枚举类型，可以取的值有REGEX/STARTWITH/ENDWITH/EQUAL/CONTAINS,是否可以为空：否
     * 属性3：rule,说明：规则字符串,是否可以为空：否
     * 属性4：isTarget,说明：是否为目标URL,是否可以为空：否
     */

    /**
     * 当前URL所处的深度（从0开始）
     */
    private Integer depth;

    /**
     * 当前URL的发掘规则类型
     */
    private RuleType ruleType;

    /**
     * 当前URL的发掘规则
     */
    private String rule;

    /**
     * 当前URL是否为目标URL(即包含所需数据的页面的URL)
     */
    private boolean isTarget;


    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public RuleType getRuleType() {
        return ruleType;
    }

    public void setRuleType(RuleType ruleType) {
        this.ruleType = ruleType;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public boolean isTarget() {
        return isTarget;
    }

    public void setTarget(boolean isTarget) {
        this.isTarget = isTarget;
    }

    @Override
    public String toString() {
        return "SupportUrlRule{" +
                "depth=" + depth +
                ", ruleType=" + ruleType +
                ", rule='" + rule + '\'' +
                ", isTarget=" + isTarget +
                '}';
    }
}
