package edu.yuwen.dp.structure.proxy.statics.inherit;

/**
 * 该业务类没有实现接口
 *
 */
public class UserController {
    // ...省略其他属性和方法...

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

    public UserVo register(String telephone, String password) {
        // ...省略register逻辑...
        // ...返回UserVo数据...
        return null;
    }
}
