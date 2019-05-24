package com.qst.itofferbacker.javabean;

/*
* 企业信息添加JavaBean
* */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CompanyInfoAdd {

    private String COMPANY_NAME ;//企业名称
    private String COMPANY_AREA ;//企业所在地
    private String COMPANY_SIZE ;//企业规模
    private String COMPANY_TYPE;//企业性质
    private String COMPANY_BRIEF ;//企业简介
    private int COMPANY_STATE ;//企业招聘状态
    private int COMPANY_SORT ;//企业顺序
    private String COMPANY_VIEWNUM;//图片文件名
    private String COMPANY_PIC;//浏览数

    public CompanyInfoAdd() {
        super();
    }

    public CompanyInfoAdd(String COMPANY_NAME, String COMPANY_AREA, String COMPANY_SIZE, String COMPANY_TYPE, String COMPANY_BRIEF, int COMPANY_STATE, int COMPANY_SORT, String COMPANY_VIEWNUM, String COMPANY_PIC) {
        this.COMPANY_NAME = COMPANY_NAME;
        this.COMPANY_AREA = COMPANY_AREA;
        this.COMPANY_SIZE = COMPANY_SIZE;
        this.COMPANY_TYPE = COMPANY_TYPE;
        this.COMPANY_BRIEF = COMPANY_BRIEF;
        this.COMPANY_STATE = COMPANY_STATE;
        this.COMPANY_SORT = COMPANY_SORT;
        this.COMPANY_VIEWNUM = COMPANY_VIEWNUM;
        this.COMPANY_PIC = COMPANY_PIC;
    }
}
