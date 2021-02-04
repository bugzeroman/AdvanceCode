package edu.yuwen.dp.create.factory.more.di;

import java.io.InputStream;
import java.util.List;

import edu.yuwen.dp.create.factory.more.di.entity.BeanDefinition;

public interface BeanConfigParser {
    List<BeanDefinition> parse(InputStream inputStream);

    List<BeanDefinition> parse(String configContent);
}
