<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

    <h1>Student Form</h1>
    
 <form action="/admin/students/save" method="post">
    <input type="hidden" value="${student.id}" name="id"/>
      <p>
        <input type="text" placeholder="Name" name="name" value="${student.name}" />
      </p>

      <p>
        <input type="text" placeholder="Course" name="course" value="${student.course}" />
      </p>

      <p>
        <button>Submit</button>
      </p>
    </form>

</body>
</html>