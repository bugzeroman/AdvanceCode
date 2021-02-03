package edu.yuwen.dp.create.singleton.factory.simple.v1;

import edu.yuwen.dp.create.singleton.factory.scene.IRuleConfigParser;
import edu.yuwen.dp.create.singleton.factory.scene.JsonRuleConfigParser;
import edu.yuwen.dp.create.singleton.factory.scene.PropertiesRuleConfigParser;
import edu.yuwen.dp.create.singleton.factory.scene.XmlRuleConfigParser;
import edu.yuwen.dp.create.singleton.factory.scene.YamlRuleConfigParser;

/**
 * 1.简单工厂模式
 * 
 * Explain:将createParser()函数剥离到一个独立的类中，让这个类只负责对象的创建
 */
public class RuleConfigParserFactory {
    public static IRuleConfigParser createParser(String configFormat) {
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(configFormat)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(configFormat)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(configFormat)) {
            parser = new YamlRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(configFormat)) {
            parser = new PropertiesRuleConfigParser();
        }
        return parser;
    }
}