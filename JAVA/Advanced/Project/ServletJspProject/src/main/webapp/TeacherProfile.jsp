<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import = "java.sql.*,java.util.*,ConnectionMaker.ConnectionMaker" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<style>
ul{
background-color:#9DE7CD;

}
li{
margin:auto;
color:#19194F;
}
body{
background-color:#C3ED82;
}

td, th{
padding: 2px 10px 5px 10px;
}
</style>

<%
                 String username = (String) session.getAttribute("username" );
                 String password = (String) session.getAttribute("password" );
                 int id =   (int) session.getAttribute("id");
                 String name = (String) session.getAttribute("name");
                 String aboutMe = (String) session.getAttribute("aboutMe");
                 String testimonial = (String) session.getAttribute("testimonial");
                 int age = (int) session.getAttribute("age");
                 String address = (String) session.getAttribute("address");
                 String doj = (String) session.getAttribute("doj");
                 String mobile = (String) session.getAttribute("mobile");
                 String photo = (String) session.getAttribute("photo");
%>
</head>
<body>
<ul class="nav nav-pills mb-3 ms-auto" id="pills-tab" role="tablist" style="padding:20px 5px 0px 5px">
    <li class="nav-item">
        <a class="nav-link" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab" aria-controls="pills-home" aria-selected="false">
            <img src="images/<%= photo %>" style="border-radius:50%" width="100px" height="100px" alt = "zulfa"></a>
    </li>
    <li class="nav-item">
        <a class="nav-link active" id="pills-profile-tab" data-toggle="pill" href="#pills-profile" role="tab" aria-controls="pills-profile" aria-selected="true">Profile</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="pills-aboutme-tab" data-toggle="pill" href="#pills-aboutme" role="tab" aria-controls="pills-aboutme" aria-selected="false">About me</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="pills-testimonial-tab" data-toggle="pill" href="#pills-testimonial" role="tab" aria-controls="pills-testimonial" aria-selected="false">Testimonial</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="pills-hierarchy-tab" data-toggle="pill" href="#pills-hierarchy" role="tab" aria-controls="pills-hierarchy" aria-selected="false">Hierarchy</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="pills-course-tab" data-toggle="pill" href="#pills-course" role="tab" aria-controls="pills-course" aria-selected="false">Courses</a>
    </li>
    <li class="nav-item ml-auto">
        <form method="post" action="Logout" align="right">
                    <input class="btn btn-success"  type="submit" value="Logout">
                </form>
    </li>
</ul>
<div class="tab-content" id="pills-tabContent" style="padding:5px 50px 20px 50px">

    <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
        <table>
            <tr>
                <th>ID</th>
                <td><%= id %></td>
            </tr>
            <tr>
                <th>Username</th>
                <td><%= username %></td>
            </tr>
            <tr>
                <th>Name</th>
                <td><%= name %></td>
            </tr>
            <tr>
                <th>Age</th>
                <td><%= age %></td>
            </tr>
            <tr>
                <th>Address</th>
                <td><%= address %></td>
            </tr>
            <tr>
                <th>Date of Joining</th>
                <td><%= doj %></td>
            </tr>
            <tr>
                <th>Mobile no.</th>
                <td><%= mobile %></td>
            </tr>
        </table>
    </div>
    <div class="tab-pane fade show active" id="pills-aboutme" role="tabpanel" aria-labelledby="pills-aboutme-tab">
    <h2>About Me</h2>
        <p><%= aboutMe %></p>
    </div>
    <div class="tab-pane fade show active" id="pills-testimonial" role="tabpanel" aria-labelledby="pills-testimonial-tab">
    <h2>Testimonial</h2>
        <p>
           <%= testimonial %>
        </p>
    </div>
    <div class="tab-pane fade show active" id="pills-hierarchy" role="tabpanel" aria-labelledby="pills-hierarchy-tab">
<h2>Teacher Hierarchy</h2>
<table>
<tr>
<th>Teacher Name</th>
<th>Students</th>
</tr>
<tr>
<td><%= name %>
<br>
<img src="images/<%= photo %>" style="border-radius:80%" width="100px" height="100px">
</td>
<td></td>
</tr>
<%
Connection connection = ConnectionMaker.getConnection();
try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select s.name,s.profile_photo from teacher t inner join studentTeacher st on t.id = st.teacher_id inner join student s on st.student_id = s.id where t.id=" + id);

            while(resultSet.next()) {
                %>
           <tr>
           <td>============></td>
           <td><%= resultSet.getString(1) %>
           <br>
           <img src="images/<%= resultSet.getString(2) %>" style="border-radius:80%" width="90px" height="90px" >
           </td>
           </tr>

<%
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
%>

</table>

</div>
    <div class="tab-pane fade" id="pills-course" role="tabpanel" aria-labelledby="pills-course-tab">
        <h2>My courses</h2><a href="AddCourse.html">
                                           <button type = "submit" >Add Course</button>
                                           </a>
         <table border = 1>
                <tr>
                <th>Course Name</th>
                <th>Added by</th>
                <th>Video</th>
                </tr>
                <%
                Connection connection1 = ConnectionMaker.getConnection();
                try {
                            Statement statement1 = connection1.createStatement();
                            ResultSet resultSet1 = statement1.executeQuery("select * from courses where teacher_name like '" + name + "'");

                            while(resultSet1.next()) {
                                %>
                           <tr>
                           <td><%= resultSet1.getString(2) %></td>
                           <td><%= resultSet1.getString(4) %></td>
                           <td>
                           <video width="320" height="240" controls>
                             <source src="videos/<%= resultSet1.getString(3) %>" type="video/mp4">
                             Your browser does not support the video tag.
                           </video>
                           </td>
                           </tr>

                <%
                            }



                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                %>

                </table>


    </div>
</div>
</body>
</html>