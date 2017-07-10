package com.audio.electric.service;

import com.audio.electric.domain.ExportPrivilege;
import com.audio.electric.domain.Role;

import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/26 0026 16:12
 */
public interface IRoleService {
    List<Role> listRole(Role role);

    Role getRole(Role role);

    int addRole(Role role);

    int modifyRole(Role role);

    int deleteRole(String ids);

    int modifyExportPwd(ExportPrivilege exportPrivilege);
}
