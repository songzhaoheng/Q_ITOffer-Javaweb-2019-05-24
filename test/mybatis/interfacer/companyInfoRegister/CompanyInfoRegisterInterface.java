package mybatis.interfacer.companyInfoRegister;

import itofferbacker.javabean.CompanyInfoAdd;

public interface CompanyInfoRegisterInterface {

    //插入企业信息
    public boolean insertCompanyInfo(CompanyInfoAdd companyInfoAdd);
}
