package com.mybatis.interfacer.companyInfo;

import com.qst.itofferbacker.javabean.CompanyInfo;
import com.qst.itofferbacker.javabean.CompanyInfoAdd;

import java.util.List;

/*
* 查询企业信息是否存在接口
* */
public interface CompanyInfoInterface {

    //获取企业名称
    public CompanyInfo getCompanyName(String CompanyName);

    //获取所有企业信息
    public List<CompanyInfo> selectCompanyInfo();
}
