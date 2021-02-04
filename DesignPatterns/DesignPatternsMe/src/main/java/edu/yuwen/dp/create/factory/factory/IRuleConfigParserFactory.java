package edu.yuwen.dp.create.factory.factory;

import edu.yuwen.dp.create.factory.scene.IRuleConfigParser;

public interface IRuleConfigParserFactory {
    IRuleConfigParser createParser();
}