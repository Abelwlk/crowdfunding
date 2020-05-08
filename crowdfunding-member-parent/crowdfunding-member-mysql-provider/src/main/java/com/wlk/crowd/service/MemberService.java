package com.wlk.crowd.service;

import com.wlk.crowd.entity.po.MemberPO;

public interface MemberService {
    MemberPO getMemberPOByLoginAcct(String loginacct);
}
