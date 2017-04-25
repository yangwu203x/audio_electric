package com.audio.electric.service;

import com.audio.electric.domain.Menu;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/25 0025 14:22
 */
public interface IMenuService {

    public List<Menu> obtainAllMenu();

    public List<Menu> obtainAccountMenu(String accountNo);
}
