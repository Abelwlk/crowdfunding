package com.wlk.crowd.mvc.handler;

import com.github.pagehelper.PageInfo;
import com.wlk.crowd.entity.Role;
import com.wlk.crowd.service.RoleService;
import com.wlk.crowd.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleHandler {

    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping("remove/by/role/id/array.json")
    public ResultEntity<PageInfo<Role>> deleteByRoleIdArray(@RequestBody List<Integer> roleIdList) {
        roleService.removeRole(roleIdList);
        return ResultEntity.successWithoutData();
    }

    @ResponseBody
    @RequestMapping("/update.json")
    public ResultEntity<PageInfo<Role>> updateRole(Role role) {
        roleService.updateRole(role);
        return ResultEntity.successWithoutData();
    }

    @ResponseBody
    @RequestMapping("/save.json")
    public ResultEntity<PageInfo<Role>> saveRole(Role role) {
        roleService.saveRole(role);
        return ResultEntity.successWithoutData();
    }

    @PreAuthorize("hasRole('部长')")
    @ResponseBody
    @RequestMapping("/get/page/info.json")
    public ResultEntity<PageInfo<Role>> getPageInfo(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "keyword", defaultValue = "") String keyword) {

        PageInfo<Role> pageInfo;
        try {
            pageInfo = roleService.getPageInfo(pageNum, pageSize, keyword);

            return ResultEntity.successWithData(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }
}
