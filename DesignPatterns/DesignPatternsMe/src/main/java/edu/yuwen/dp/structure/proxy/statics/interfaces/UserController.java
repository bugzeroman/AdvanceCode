package edu.yuwen.dp.structure.proxy.statics.interfaces;

public class UserController implements IUserController {
    // ...省略其他属性和方法...

    @Override
    public UserVo login(String telephone, String password) {
        // ...省略login逻辑...
        // ...返回UserVo数据...
        // 模拟业务耗时100ms
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserVo register(String telephone, String password) {
        // ...省略register逻辑...
        // ...返回UserVo数据...
        return null;
    }
}