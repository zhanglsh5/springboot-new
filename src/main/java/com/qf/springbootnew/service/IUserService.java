package com.qf.springbootnew.service;

import com.qf.springbootnew.entity.TUser;

public interface IUserService {

    public TUser selectByPrimaryKey(Long id);

}
