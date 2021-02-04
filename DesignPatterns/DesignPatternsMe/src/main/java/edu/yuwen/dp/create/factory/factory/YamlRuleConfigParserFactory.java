package edu.yuwen.dp.create.factory.factory;

import edu.yuwen.dp.create.factory.scene.IRuleConfigParser;
import edu.yuwen.dp.create.factory.scene.YamlRuleConfigParser;

public class YamlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new YamlRuleConfigParser();
    }
}
