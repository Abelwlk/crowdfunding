package com.wlk.crowd.service.impl;

import com.wlk.crowd.entity.po.MemberPO;
import com.wlk.crowd.entity.po.MemberPOExample;
import com.wlk.crowd.mapper.MemberPOMapper;
import com.wlk.crowd.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberPOMapper mapper;

    public MemberPO getMemberPOByLoginAcct(String loginacct) {

        MemberPOExample example = new MemberPOExample();
        MemberPOExample.Criteria criteria = example.createCriteria();
        criteria.andLoginacctEqualTo(loginacct);

        List<MemberPO> list = mapper.selectByExample(example);
        return list.get(0);
    }
}
