package edu.yuwen.dp.create.singleton.factory.factory;

import edu.yuwen.dp.create.singleton.factory.scene.IRuleConfigParser;

public interface IRuleConfigParserFactory {
    IRuleConfigParser createParser();
}