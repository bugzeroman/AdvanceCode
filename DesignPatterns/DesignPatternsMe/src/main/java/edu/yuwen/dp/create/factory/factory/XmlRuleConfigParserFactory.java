package edu.yuwen.dp.create.factory.factory;

import edu.yuwen.dp.create.factory.scene.IRuleConfigParser;
import edu.yuwen.dp.create.factory.scene.XmlRuleConfigParser;

public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new XmlRuleConfigParser();
    }
}