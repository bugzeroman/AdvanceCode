package edu.yuwen.dp.structure.proxy.statics.interfaces;

import edu.yuwen.dp.structure.proxy.scene.IUserController;
import edu.yuwen.dp.structure.proxy.scene.UserController;
import edu.yuwen.dp.structure.proxy.scene.UserVo;

/**
 * 1.代理模式（结构性）
 * 
 * 1.静态代理的实现方式一，通过接口代理
 *
 * Demo:性能统计，给业务接口增加调用耗时统计的功能
 */
public class UserControllerProxy implements IUserController {
    private UserController userController;

    public UserControllerProxy(UserController userController) {
        this.userController = userController;
    }

    @Override
    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        // 委托
        UserVo userVo = userController.login(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        System.out.println("call time cost is " + responseTime);
        return userVo;
    }

    @Override
    public UserVo register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        // 委托
        UserVo userVo = userController.register(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        System.out.println("call time cost is " + responseTime);
        return userVo;
    }
}
