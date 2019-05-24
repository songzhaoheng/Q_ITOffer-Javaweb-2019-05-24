package com.mybatis.interfacer.companyInfoRegister;

import com.qst.itofferbacker.javabean.CompanyInfo;
import com.qst.itofferbacker.javabean.CompanyInfoAdd;

public interface CompanyInfoRegisterInterface {

    //插入企业信息
    public boolean insertCompanyInfo(CompanyInfoAdd companyInfoAdd);
}
