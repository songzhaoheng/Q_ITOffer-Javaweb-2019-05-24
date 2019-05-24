package mybatis.interfacer.companyInfo;

import itofferbacker.javabean.CompanyInfo;

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
