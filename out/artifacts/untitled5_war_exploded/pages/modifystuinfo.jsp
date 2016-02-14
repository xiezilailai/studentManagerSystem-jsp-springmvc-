<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.xiezilailai.example.entities.StudentinfoEntity" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<%

//    StudentinfoEntity stuInfoService=new StudentinfoEntity();
   List stus= (List) session.getAttribute("stus");
//    out.print(stus.size());
    Iterator iter=stus.iterator();

%>
<table>
    <tr>
        <td>id</td>
        <td>nickName</td>
        <td>realName</td>
        <td>sex</td>
        <td>bornDate</td>
        <td>profession</td>
        <td>subjects</td>
        <td>hobbies</td>
        <td>remarks</td>
        <td></td>
    </tr>
    <%
        int i=0;
        while (iter.hasNext()){
            StudentinfoEntity student=(com.xiezilailai.example.entities.StudentinfoEntity)iter.next();
    %>
    <tr <%if (i%2==0){%>bgcolor="#F0F8FF"<%}%>>
        <td><%=student.getId()%></td>
        <td><%=student.getNickname()%></td>
        <td><%=student.getRealname()%></td>
        <td>
            <%
                if (student.getSex() == 1)
                    out.print("man");
                else
                    out.print("woman");
            %>
        </td>
        <td><%=student.getBorndate()%></td>
        <td><%=student.getProfession()%></td>
        <td><%=student.getSubject()%></td>
        <td><%=student.getHobby()%></td>
        <td><%=student.getRemark()%></td>
        <td><a href="/modifyOneStu?id=<%=student.getId()%>">modify</a></td>
    </tr>
    <%i++;
    }%>

</table>
</body>
</html>