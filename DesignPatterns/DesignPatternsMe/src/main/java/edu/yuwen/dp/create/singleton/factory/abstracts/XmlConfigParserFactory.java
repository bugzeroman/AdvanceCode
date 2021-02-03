package edu.yuwen.dp.create.singleton.factory.abstracts;

import edu.yuwen.dp.create.singleton.factory.abstracts.scene.ISystemConfigParser;
import edu.yuwen.dp.create.singleton.factory.abstracts.scene.XmlSystemConfigParser;
import edu.yuwen.dp.create.singleton.factory.scene.IRuleConfigParser;
import edu.yuwen.dp.create.singleton.factory.scene.XmlRuleConfigParser;

public class XmlConfigParserFactory implements IConfigParserFactory {
    @Override
    public IRuleConfigParser createRuleParser() {
        return new XmlRuleConfigParser();
    }

    @Override
    public ISystemConfigParser createSystemParser() {
        return new XmlSystemConfigParser();
    }
}