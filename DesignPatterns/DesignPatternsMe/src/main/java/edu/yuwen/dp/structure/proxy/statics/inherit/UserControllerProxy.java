package edu.yuwen.dp.structure.proxy.statics.inherit;

import edu.yuwen.dp.structure.proxy.scene.UserVo;

/**
 * 1.代理模式（结构型）
 * 
 * 2.静态代理的实现方式二，通过继承代理
 *
 * Demo:性能统计，给业务接口增加调用耗时统计的功能
 */
public class UserControllerProxy extends UserController {

    public UserControllerProxy() {
    }

    @Override
    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        // 委托给父类，实现具体的业务
        UserVo userVo = super.login(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        System.out.println("call time cost is " + responseTime);
        return userVo;
    }

    @Override
    public UserVo register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        // 委托给父类，实现具体的业务
        UserVo userVo = super.register(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        System.out.println("call time cost is " + responseTime);

        return userVo;
    }
}
