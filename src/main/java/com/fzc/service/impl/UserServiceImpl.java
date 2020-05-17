package com.fzc.service.impl;

import com.fzc.dao.UserDao;
import com.fzc.entity.User;
import com.fzc.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author fzc
 * @since 2020-05-09 19:42:50
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;


    /**
     * 查询出全部记录
     *
     * @return 实例对象列表
     */
    @Override
    public List<User> queryList() {
        return userDao.queryList();
    }

    /**
     * 通过username查询单条数据
     *
     * @param username 用户名
     * @return 实例对象
     */
    @Override
    public User queryByName(String username) {
        return userDao.queryByName(username);
    }

    @Override
    public List<User> searchNameList(String username) {
        return userDao.searchNameList(username);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(Integer id) {
        return this.userDao.deleteById(id) > 0;
    }
}