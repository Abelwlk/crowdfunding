package com.wlk.crowd.mvc.handler;

import com.wlk.crowd.entity.Admin;
import com.wlk.crowd.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.wlk.crowd.util.CrowdUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TestHandler {

    @Autowired
    private AdminService adminService;


    @RequestMapping("test/ssm.html")
    public String testSSM(Model model, HttpServletRequest request) {
        List<Admin> lists = adminService.getAll();
        boolean judge = CrowdUtil.judgeRequestType(request);
        System.out.println(judge);
        System.out.println(lists);
        model.addAttribute("lists", lists);
        int i=10/0;
        return "target";
    }

    @RequestMapping("send/array.html")
    public String testReceive(@RequestParam("array[]") List<Integer> array,HttpServletRequest request) {
        for (Integer integer : array) {
            System.out.println(integer);
        }
        boolean judge = CrowdUtil.judgeRequestType(request);
        System.out.println(judge);
        return "target";
    }
}
