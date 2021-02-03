package edu.yuwen.dp.create.singleton.factory.abstracts.scene;

/**
 * 场景扩展需要的支持类：
 * 既可以按照配置文件格式来分类，
 * 也可以按照解析的对象来分类，
 * 即Rule规则配置还是 System系统配置。
 *
 */
public interface ISystemConfigParser {
    ISystemConfigParser createSystemParser();
}
