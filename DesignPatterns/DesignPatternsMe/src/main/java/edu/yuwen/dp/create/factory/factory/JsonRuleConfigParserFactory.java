package edu.yuwen.dp.create.factory.factory;

import edu.yuwen.dp.create.factory.scene.IRuleConfigParser;
import edu.yuwen.dp.create.factory.scene.JsonRuleConfigParser;

public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}