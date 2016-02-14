<%@ page import="com.xiezilailai.example.entities.StudentinfoEntity" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<%
    StudentinfoEntity stu=(StudentinfoEntity) session.getAttribute("stu");
%>
<form action="/modify_success" method="post">
    <table bgcolor="aqua" align="center">
        <tr>
            <td colspan="2" align="center" bgcolor=green>录入学生信息</td>
        </tr>
        <tr>
            <td>昵称:</td>
            <td><input type="text" size=20 name="nickname" value="<%=stu.getNickname()%>"></td>
        </tr>
        <tr>
            <td>真实姓名:</td>
            <td><input type="text" size=20 name="realname" value="<%=stu.getRealname()%>"></td>
        </tr>
        <tr>
            <td>性别:</td>
            <td><input type="radio" name="sex" <%if (stu.getSex()==1){%>checked<%}%> value="1">男&nbsp;&nbsp;
                <input type="radio" name="sex" <%if (stu.getSex()==0){%>checked<%}%> value="0">女
            </td>
        </tr>
        <tr>
            <td>出生日期:</td>
            <td><input type="text" name="borndate" size="20" value="<%=stu.getBorndate()%>"></td>
        </tr>
        <tr>
            <td>所学专业:</td>
            <td>
                <select name="profession">
                    <option <%if (stu.getProfession().equals("计算机科学与技术")){%>selected<%}%>>计算机科学与技术</option>
                    <option <%if (stu.getProfession().equals("信息安全")){%>selected<%}%>>信息安全</option>
                    <option <%if (stu.getProfession().equals("数字媒体")){%>selected<%}%>>数字媒体</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>所学课程:</td>
            <td>
                <select name="subject" size=8 multiple="multiple">
                    <option
                            <%
                                String[] subjects=stu.getSubject().split("&");
                                for (int i = 0; i < subjects.length; i++) {
                                    if (subjects[i].equals("计算机导论")) {
                            %>
                            selected
                            <%
                                        break;
                                    }
                                }%>
                    >计算机导论
                    </option>
                    <option
                            <%
                                for (int i = 0; i < subjects.length; i++) {
                                    if (subjects[i].equals("数据结构")) {
                            %>
                            selected
                            <%
                                        break;
                                    }
                                }%>

                    >数据结构
                    </option>
                    <option
                            <%
                                for (int i = 0; i < subjects.length; i++) {
                                    if (subjects[i].equals("数据库原理")) {
                            %>
                            selected
                            <%
                                        break;
                                    }
                                }%>>数据库原理
                    </option>

                    <option
                            <%
                                for (int i = 0; i < subjects.length; i++) {
                                    if (subjects[i].equals("操作系统")) {
                            %>
                            selected
                            <%
                                        break;
                                    }
                                }%>>操作系统
                    </option>
                    <option
                            <%
                                for (int i = 0; i < subjects.length; i++) {
                                    if (subjects[i].equals("计算机网络")) {
                            %>
                            selected
                            <%
                                        break;
                                    }
                                }%>>计算机网络
                    </option>
                    <option
                            <%
                                for (int i = 0; i < subjects.length; i++) {
                                    if (subjects[i].equals("软件工程")) {
                            %>
                            selected
                            <%
                                        break;
                                    }
                                }%>>软件工程
                    </option>
                </select>
            </td>
        </tr>
        <tr>
            <td>兴趣:</td>
            <td>
                <input type="checkbox" value="music" name="hobby"
                    <%String[] hobbies=stu.getHobby().split("&");
			for (int i = 0; i < hobbies.length; i++) {
				if (hobbies[i].equals("music")) {%>
                       checked <%break;
				}
			}%>
                >听音乐&nbsp;
                <input type="checkbox" value="book" name="hobby"
                    <%
			for (int i = 0; i < hobbies.length; i++) {
				if (hobbies[i].equals("book")) {%>
                       checked <%break;
				}
			}%>>看小说&nbsp;
                <input type="checkbox" value="web" name="hobby"
                    <%
			for (int i = 0; i < hobbies.length; i++) {
				if (hobbies[i].equals("web")) {%>
                       checked <%break;
				}
			}%>>上网&nbsp;
            </td>
        </tr>
        <tr valign="top">
            <td>备注:</td>
            <td><textarea rows="3" cols="20" name="remark"><%=stu.getRemark()%></textarea></td>
        </tr>
        <tr>
            <td align="center" colspan="2"><input type="hidden" name="id" value="<%=stu.getId()%>"/>
                <input type="submit" value="提交">&nbsp;&nbsp;
                <input type="reset" value="重置">

            </td>
        </tr>
    </table>
</form>
</body>
</html>