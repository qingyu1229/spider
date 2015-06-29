package org.beyong.parse.rule;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * Created by 梁擎宇 on 15-6-24.
 */
public class RuleLocator {
    /**
     * 规则说明：
     *
     * Site规则：
     * 属性1：includeBinaryContentInCrawling,是否下载目标区域中的多媒体文件，例如图片视频等
     * 属性2：maxDepath,最大抓取深度
     * 属性3：interval,重新调度的时间间隔
     * 属性4：enable,是否开启本站的抓取
     * 属性5：seedUrl,种子链接
     * 属性6：thread,本站的并发量
     * 属性7：charset，本站的网页内容字符编码
     * 属性8：sitePriority,站点优先级
     * 属性9：siteName,站点名称
     * 属性10：politenessDelay,两次请求的最小时间间隔
     * 属性11：socketTimeout，socket超时时间
     * 属性12：connectionTimeout，connection超时时间
     * 属性13：maxDownloadSize，允许的最大页面或文件大小
     * 属性14：followRedirects，是否处理重定向
     * 属性15：proxyHost，代理Host
     * 属性16：proxyPort，代理Port
     * 属性17：proxyUsername，代理账号
     * 属性18：proxyPassword，代理账号的密码
     *
     *
     *
     * 非目标页面URL发掘规则：
     * 属性1：depth,说明：URL所处的深度,是否可以为空：是
     * 属性2：ruleType,说明：枚举类型，可以取的值有REGEX/STARTWITH/ENDWITH/EQUAL/CONTAINS,是否可以为空：否
     * 属性3：rule,说明：规则字符串,是否可以为空：否
     * 属性4：isTarget,说明：是否为目标URL,是否可以为空：否
     *
     * 目标数据采集规则说明：
     * 属性1：name,说明：属性名称，是否可以为空：否
     * 属性2：cssPath,说明：数据抽取路径，是否可以为空：否
     * 属性3：regex,说明：当使用cssPath抽取不够精确时，使用正则再次抽取，是否可以为空：是
     *
     */

    private static Table<String,Integer,SupportUrlRule> supportUrlRuleTable= HashBasedTable.create();


    public static SupportUrlRule getSupportUrlRule(String domain,short depth){
        SupportUrlRule rule=null;



        return rule;
    }

    public static DataRule getDataRule(String domain){
        DataRule rule=null;


        return rule;
    }


    public static boolean addSupportUrlRule(SupportUrlRule supportUrlRule,String domain){
        supportUrlRuleTable.put(domain,Integer.valueOf(supportUrlRule.getDepth()),supportUrlRule);
        return true;
    }

}
