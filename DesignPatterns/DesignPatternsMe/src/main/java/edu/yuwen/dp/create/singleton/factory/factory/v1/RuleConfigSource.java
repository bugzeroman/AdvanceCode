package edu.yuwen.dp.create.singleton.factory.factory.v1;

import edu.yuwen.dp.create.singleton.factory.factory.IRuleConfigParserFactory;
import edu.yuwen.dp.create.singleton.factory.factory.JsonRuleConfigParserFactory;
import edu.yuwen.dp.create.singleton.factory.factory.PropertiesRuleConfigParserFactory;
import edu.yuwen.dp.create.singleton.factory.factory.XmlRuleConfigParserFactory;
import edu.yuwen.dp.create.singleton.factory.factory.YamlRuleConfigParserFactory;
import edu.yuwen.dp.create.singleton.factory.scene.IRuleConfigParser;
import edu.yuwen.dp.create.singleton.factory.scene.InvalidRuleConfigException;
import edu.yuwen.dp.create.singleton.factory.scene.RuleConfig;

/**
 * 2.工厂模式 
 * 
 * 2.工厂方法模式 第一种，典型代码实现
 * 
 * Demo:根据配置文件的后缀（json、xml、yaml、properties），
 * 选择不同的解析器（JsonRuleConfigParser、XmlRuleConfigParser……），
 * 将存储在文件中的配置解析成内存对象 RuleConfig。
 */
public class RuleConfigSource {
    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);

        IRuleConfigParserFactory parserFactory = null;
        if ("json".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new JsonRuleConfigParserFactory();
        } else if ("xml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new XmlRuleConfigParserFactory();
        } else if ("yaml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new YamlRuleConfigParserFactory();
        } else if ("properties".equalsIgnoreCase(ruleConfigFileExtension)) {
            parserFactory = new PropertiesRuleConfigParserFactory();
        } else {
            throw new InvalidRuleConfigException("Rule config file format is not supported: " + ruleConfigFilePath);
        }
        IRuleConfigParser parser = parserFactory.createParser();

        String configText = "";
        // 从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        // 解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}
