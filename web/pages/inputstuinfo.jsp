<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
input
<form action="/input_success" method="post">
    <table bgcolor="aqua" align="center">
        <tr>
            <td colspan="2" align="center" bgcolor=green>录入学生信息</td>
        </tr>
        <tr>
            <td>昵称:</td>
            <td><input type="text" size=20 name="nickname"></td>
        </tr>
        <tr>
            <td>真实姓名:</td>
            <td><input type="text" size=20 name="realname"></td>
        </tr>
        <tr>
            <td>性别:</td>
            <td><input type="radio" name="sex" checked value="1">男&nbsp;&nbsp;
                <input type="radio" name="sex" checked value="0">女
            </td>
        </tr>
        <tr>
            <td>出生日期:</td>
            <td><input type="text" name="borndate" size="20"></td>
        </tr>
        <tr>
            <td>所学专业:</td>
            <td>
                <select name="profession">
                    <option>计算机科学与技术</option>
                    <option>信息安全</option>
                    <option>数字媒体</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>所学课程:</td>
            <td>
                <select name="subject" size=8 multiple="multiple">
                    <option>计算机导论</option>
                    <option>数据结构</option>
                    <option>数据库原理</option>

                    <option>操作系统</option>
                    <option>计算机网络</option>
                    <option>软件工程</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>兴趣:</td>
            <td>
                <input type="checkbox" value="music" name="hobby">听音乐&nbsp;
                <input type="checkbox" value="book" name="hobby">看小说&nbsp;
                <input type="checkbox" value="web" name="hobby">上网&nbsp;
            </td>
        </tr>
        <tr valign="top">
            <td>备注:</td>
            <td><textarea rows="3" cols="20" name="remark"></textarea> </td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input type="submit" value="提交">&nbsp;&nbsp;
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>