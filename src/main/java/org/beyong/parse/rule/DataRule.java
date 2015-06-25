package org.beyong.parse.rule;

/**
 * Created by 梁擎宇 on 15-6-25.
 */
public class DataRule {

    /**
     * 目标数据采集规则说明：
     * 属性1：name,说明：属性名称，是否可以为空：否
     * 属性2：cssPath,说明：数据抽取路径，是否可以为空：否
     * 属性3：regex,说明：当使用cssPath抽取不够精确时，使用正则再次抽取，是否可以为空：是
     *
     */

    /**
     * 数据名称
     */
    private String name;

    /**
     * 类css选择路径
     */
    private String cssPath;

    /**
     * 当使用cssPath抽取不够精确时，使用正则再次抽取
     */
    private String regex;

    public DataRule(String name, String cssPath, String regex) {
        this.name = name;
        this.cssPath = cssPath;
        this.regex = regex;
    }

    public DataRule() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCssPath() {
        return cssPath;
    }

    public void setCssPath(String cssPath) {
        this.cssPath = cssPath;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
}
