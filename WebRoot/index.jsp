<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title> Hello MiniUI!</title>
    <!--jQuery js-->
    <script src="${pageContext.request.contextPath}/js/jquery-1.6.2.min.js" type="text/javascript"></script>
    <!--MiniUI-->
    <link href="${pageContext.request.contextPath}/js/miniui/themes/default/miniui.css" rel="stylesheet" type="text/css" />        
    <script src="${pageContext.request.contextPath}/js/miniui/miniui.js" type="text/javascript"></script>

</head>
<body>
<div id="datagrid1" class="mini-datagrid" style="width:800px;height:280px;" 
    url="${pageContext.request.contextPath}/adminCategorySecond_findAll2.action" idField="id"
    allowResize="true" pageSize="20" 
    allowCellEdit="true" allowCellSelect="true" multiSelect="true"
>
    <div property="columns">
        <div type="checkcolumn"></div>            
        <div field="csid" width="120" headerAlign="center" allowSort="true">编号
            <input property="editor" class="mini-spinner" style="width:100%;"/>
        </div>                
        <div field="csname" width="100" headerAlign="center"  allowSort="true" >二级分类名称
            <input property="editor" class="mini-textbox" minValue="0" maxValue="200" value="25" style="width:100%;"/>
        </div>


</div>  
</div> 
    <script type="text/javascript">
        mini.parse();
        var grid = mini.get("datagrid1");
        grid.load();
    </script>
</body>
</html>
