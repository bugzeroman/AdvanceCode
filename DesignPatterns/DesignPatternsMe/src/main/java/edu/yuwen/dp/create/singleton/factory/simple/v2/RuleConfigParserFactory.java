package edu.yuwen.dp.create.singleton.factory.simple.v2;

import java.util.HashMap;
import java.util.Map;

import edu.yuwen.dp.create.singleton.factory.scene.IRuleConfigParser;
import edu.yuwen.dp.create.singleton.factory.scene.JsonRuleConfigParser;
import edu.yuwen.dp.create.singleton.factory.scene.PropertiesRuleConfigParser;
import edu.yuwen.dp.create.singleton.factory.scene.XmlRuleConfigParser;
import edu.yuwen.dp.create.singleton.factory.scene.YamlRuleConfigParser;

/**
 * 2.工厂模式  
 * 
 * 1.简单工厂模式 第二种写法，针对线程安全可复用的实例，可以预先缓存，类似单例模式和简单工厂模式的结合
 * 
 * 推荐第二种写法
 * 
 * Explain:将createParser()函数剥离到一个独立的类中，让这个类只负责对象的创建
 */
public class RuleConfigParserFactory {
    private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
        cachedParsers.put("yaml", new YamlRuleConfigParser());
        cachedParsers.put("properties", new PropertiesRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            // 返回null还是IllegalArgumentException全凭你自己说了算
            return null;
        }
        IRuleConfigParser parser = cachedParsers.get(configFormat.toLowerCase());
        return parser;
    }
}