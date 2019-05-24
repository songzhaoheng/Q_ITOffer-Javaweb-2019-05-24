<%--
  Created by IntelliJ IDEA.
  User: 23369
  Date: 2019/5/14
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Hern商城管理界面</title>
    <link rel="shortcut icon" href="images/logo/ico.png" type="image/x-icon" >
    <link rel="stylesheet" href="css/registered/registered.css" type="text/css">
    <link rel="stylesheet" href="css/registered/registered_context.css" type="text/css">
    <link rel="stylesheet" href="css/registered/registered_head.css" type="text/css">
    <script src="javascript/login/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="javascript/login/decide.js" type="text/javascript" charset="UTF-8"></script>
    <script src="javascript/login/login.js" type="text/javascript" charset="utf-8"></script>
  </head>
  <body>
  <!--头部标题-->
  <header>
    <a href="html/index.html" class="logo" title="返回Hern商城首页">
      <img src="images/logo/logo1.jpg" width="150">
    </a>
    <div class="desc">欢迎登录Hern商城管理界面</div>
  </header>

  <!--登录信息表单界面-->
  <section>
    <form id="form_registered" action="loginServlet" method="post">
      <div class="register-box">
        <label for="username" class="username_label">用 户 名
          <input id="input_username" name="username" maxlength="20" type="text" placeholder="您的用户名和登录名" style="color: #000000;" value="">
        </label>
        <div class="tips">

        </div>
      </div>
      <div class="register-box">
        <label for="username" class="other_label">账 号 密 码
          <input id="input_userpass"  name="userpass" maxlength="20" type="password" placeholder="至少使用两种字符组合" style="color: #000000;">
          <a href="jsp/passwordBack.jsp" style="text-decoration: none; color: #FF3428;">忘记密码</a>
        </label>
        <div class="tips">

        </div>
      </div>
      <div class="register-box">
        <label for="username" class="other_label">验 证 码
          <input name="input_usercode" maxlength="20" type="text" placeholder="请输入验证码">
        </label>
        <span id="code"></span>
        <div class="tips">

        </div>
      </div>
      <div class="submit_btn">
        <button type="submit" id="submit_btn">立 即 登 录</button>
      </div>
    </form>
  </section>

  <section style="margin-top: 30px;">
    <!--版权等-->
    <div style="padding: 20px 0;overflow: hidden;height: 160px;">
      <!--购物指南-->
      <div style="float: left;width: 198px;line-height: 22px; margin-left: 200px" class="bottoma">
        <h3>购物指南</h3>
        <ul>
          <li>购物流程</li>
          <li>会员介绍</li>
          <li>生活旅行</li>
          <li>常见问题</li>
          <li>大家电</li>
          <li>联系客服</li>
        </ul>
      </div>

      <!--配送方式-->
      <div style="float: left;width: 198px;line-height: 22px; margin-left: 50px">
        <h3>配送方式</h3>
        <ul>
          <li>上门自提</li>
          <li>211限时达</li>
          <li>配送服务查询</li>
          <li>配送费收取标准</li>
          <li>海外配送</li>
        </ul>
      </div>
      <!--支付方式-->
      <div style="float: left;width: 198px;line-height: 22px; margin-left:50px">
        <h3>支付方式</h3>
        <ul>
          <li>货到付款</li>
          <li>在线支付</li>
          <li>分期付款</li>
          <li>邮局汇款</li>
          <li>公司转账</li>
        </ul>
      </div>

      <!--售后服务-->
      <div style="float: left;width: 198px;line-height: 22px; margin-left: 50px" class="bottoma">
        <h3>售后服务</h3>
        <ul>
          <li>售后政策</li>
          <li>价格保护</li>
          <li>退款说明</li>
          <li>返修/退换货</li>
          <li><a href="jsp/retrieveAccount.jsp" style="text-decoration: none; color: #6e6568;">找回账户</a></li>
        </ul>
      </div>

      <!--特色服务-->
      <div style="float: left;width: 198px;line-height: 22px; margin-left: 50px">
        <h3>特色服务</h3>
        <ul>
          <li>夺宝岛</li>
          <li>DIY装机</li>
          <li>延保服务</li>
          <li>京东E卡</li>
          <li>京东通信</li>
          <li><a href="#" style="text-decoration: none;">京东JD+</a></li>
        </ul>
      </div>
    </div>
    <hr style="background-color: #cccccc; border: none; height: 1px">
    <!--版权声明-->
    <div style="width: 100%; margin-top: 30px; text-align: center;">
      <p style="margin: 0 6px;">关于我们&nbsp;|&nbsp;联系客服&nbsp;|&nbsp;合作招商&nbsp;|&nbsp;商家帮助&nbsp;|&nbsp;营销中心&nbsp;|&nbsp;手机京东&nbsp;|&nbsp;友情链接&nbsp;|&nbsp;销售联盟&nbsp;|&nbsp;京东社区&nbsp;|&nbsp;风险监测&nbsp;|&nbsp;隐私政策&nbsp;|&nbsp;京东公益&nbsp;|&nbsp;English&nbsp; Site&nbsp;|&nbsp;Media &nbsp;& &nbsp;IR&nbsp;</p>
      <p style="margin-top: 10px; margin-bottom: 10px">Copyright © 2004 - 2019  京东JD.com 版权所有&nbsp;|&nbsp;消费者维权热线：4006067733经营证照&nbsp;|&nbsp;(京)网械平台备字(2018)第00003号&nbsp;|&nbsp;营业执照</p>
    </div>
  </section>

  </body>
</html>
