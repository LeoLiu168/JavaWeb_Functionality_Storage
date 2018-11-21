﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		//页面加载函数即执行,异步查询字典数据
		$.post("${pageContext.request.contextPath }/baseDict_findByTypeCode.action",
				{"dict_type_code":"002"},function(data){
			//遍历JSON数据
			$(data).each(function(i, n){
				$("#acct_location").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
			});
		},"json");
		
		$.post("${pageContext.request.contextPath }/baseDict_findByTypeCode.action",
				{"dict_type_code":"006"},function(data){
			// 遍历json的数据:
			$(data).each(function(i,n){
				$("#acct_level").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
			});
		},"json");

		
		$.post("${pageContext.request.contextPath }/baseDict_findByTypeCode.action",
				{"dict_type_code":"001"},function(data){
			//遍历JSON数据
			$(data).each(function(i, n){
				$("#acct_type").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
			});
		},"json");
	});
</script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/customer_save.action"
		method=post>
		

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：账户管理 &gt; 添加账户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
						  
						    
							<TR>
								<td>账户名称：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="acct_name">
								</td>
								<td>账户级别 ：</td>
								<td>
								<select id="acct_level">
									<option value="">-请选择-</option>
								</select>
								
								</td>
							</TR>
							
							<TR>
								
								<td>注册来源 ：</td>
								<td>
								<select id="acct_location">
									<option value="">-请选择-</option>
								</select>
								</td>
								<td>账户类型 ：</td>
								<td>
								<select id="acct_type">
									<option value="">-请选择-</option>
								</select>
								</td>
							</TR>
							
							<TR>
								
								
								<td>联系电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="acct_phone">
								</td>
								<td>系统编号 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="acct_serial">
								</td>
							</TR>
							
							
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value=" 保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
