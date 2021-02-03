package edu.yuwen.dp.create.singleton.factory.abstracts;

import edu.yuwen.dp.create.singleton.factory.abstracts.scene.ISystemConfigParser;
import edu.yuwen.dp.create.singleton.factory.abstracts.scene.JsonSystemConfigParser;
import edu.yuwen.dp.create.singleton.factory.scene.IRuleConfigParser;
import edu.yuwen.dp.create.singleton.factory.scene.JsonRuleConfigParser;

public class JsonConfigParserFactory implements IConfigParserFactory {
    @Override
    public IRuleConfigParser createRuleParser() {
        return new JsonRuleConfigParser();
    }

    @Override
    public ISystemConfigParser createSystemParser() {
        return new JsonSystemConfigParser();
    }
}