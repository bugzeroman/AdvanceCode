package edu.yuwen.dp.create.factory.abstracts;

import edu.yuwen.dp.create.factory.abstracts.scene.ISystemConfigParser;
import edu.yuwen.dp.create.factory.scene.IRuleConfigParser;

/**
 * 2.工厂模式 
 * 
 * 3.抽象工厂 不常用，此Demo未完成
 * 
 * Explain:既可以按照配置文件格式来分类，
 * 也可以按照解析的对象（Rule 规则配置还是 System 系统配置）来分类，
 * 那就会对应下面这 8 个 parser 类。
 * 针对规则配置的解析器：
 * 基于接口IRuleConfigParser
 * JsonRuleConfigParser
 * XmlRuleConfigParser
 * YamlRuleConfigParser
 * PropertiesRuleConfigParser
 * 针对系统配置的解析器：
 * 基于接口ISystemConfigParser
 * JsonSystemConfigParser
 * XmlSystemConfigParser
 * YamlSystemConfigParser
 * PropertiesSystemConfigParser
 */
public interface IConfigParserFactory {
    IRuleConfigParser createRuleParser();

    ISystemConfigParser createSystemParser();
    // 此处可以扩展新的parser类型，比如IBizConfigParser
}

// 省略YamlConfigParserFactory和PropertiesConfigParserFactory代码