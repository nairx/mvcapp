<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <h1>Student Management</h1>
    <form action="/students/save" method="post">
      <p>
        <input type="text" placeholder="Name" name="name" />
      </p>

      <p>
        <input type="text" placeholder="Course" name="course" />
      </p>

      <p>
        <button>Submit</button>
      </p>
    </form>
    <hr>

    <table>
        <tr>
            <th>Name</th>
            <th>Course</th>
            <th>Actions</th>
        </tr>
    

    <c:forEach var="student" items="${students}">
  
<tr>
    <td>${student.name}</td>
    <td>${student.course}</td>
    <td>
        <a href="delete/${student.id}">Delete</a>
    </td>
</tr>


    </c:forEach>

</table>

  </body>
</html>
