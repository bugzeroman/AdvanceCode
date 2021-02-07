package edu.yuwen.dp.structure.proxy.scene;

public interface IUserController {
    UserVo login(String telephone, String password);

    UserVo register(String telephone, String password);
}
