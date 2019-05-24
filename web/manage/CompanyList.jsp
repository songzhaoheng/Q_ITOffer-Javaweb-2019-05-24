<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.List,com.qst.itofferbacker.javabean.CompanyInfo"%>
<%@ page import="com.qst.itofferbacker.javabean.CompanyInfo" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%   String path = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
     System.out.print(path);
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="shortcut icon" href="../images/logo/ico.png" type="image/x-icon" >
<link href="css/manageadmin.css" rel="stylesheet" type="text/css" />
<base  href="<%=path %>" />
            
<title>企业信息列表</title>
</head>
<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">企业列表</a></li>
  </ul>
</div>
<div class="rightinfo">
  <div class="tools">
    <ul class="toolbar">
      <li class="click"><span><img src="images/t01.png" /></span><a href="manage/companyAdd.html">添加</a></li>
      <li><span><img src="images/t03.png" /></span><a href="#">删除</a></li>
    </ul>
  </div>
  <table class="imgtable">
    <thead>
      <tr>
        <th ><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>企业名称</th>
        <th>企业所在地</th>
        <th>企业规模</th>
        <th>企业性质</th>
        <th>招聘状态</th>
        <th>显示排序</th>
        <th>浏览数</th>
        <th>操作</th>
      </tr>
    </thead>
    <tbody>
       
	    <% List <CompanyInfo> list= (List<CompanyInfo>) request.getAttribute("list");
	    	for(CompanyInfo c:list) { %>
	    	<tr height="50px">
	    	<td ><input name="" type="checkbox" value="" /></td>
	    	<td >	<%=c.getCOMPANY_NAME()%></td>
	    	<td >	<%=c.getCOMPANY_AREA()%></td>
	    	<td >	<%=c.getCOMPANY_SIZE()%></td>
	    	<td >	<%=c.getCOMPANY_TYPE()%></td>
	    	<td >	<%=c.getCOMPANY_STATE() %></td>
	    	<td >	<%=c.getCOMPANY_SORT()%></td>
	    	<td >	<%=c.getCOMPANY_VIEWNUM()%></td>
	    	<td ><a href="companyAdd.html" class="tablelink">修改</a> &nbsp;&nbsp;<a href="#" class="tablelink"> 删除</a></td>
	    	 </tr>
	    	 <%}%>
    
    
     
    </tbody>
  </table>
  <div class="pagin">
    <div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
    <ul class="paginList">
      <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
      <li class="paginItem"><a href="javascript:;">1</a></li>
      <li class="paginItem current"><a href="javascript:;">2</a></li>
      <li class="paginItem"><a href="javascript:;">3</a></li>
      <li class="paginItem"><a href="javascript:;">4</a></li>
      <li class="paginItem"><a href="javascript:;">5</a></li>
      <li class="paginItem more"><a href="javascript:;">...</a></li>
      <li class="paginItem"><a href="javascript:;">10</a></li>
      <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
    </ul>
  </div>
</div>
</body>
</html>