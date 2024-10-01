<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>相应不同类型文件</title>
  <style>
    ul li {
      list-style: none;
      float: left;
      margin-top: 40px;
    }

    ul li a{
      padding: 20px 50px;
      height: 40px;
      background-color: #00897b;
      color: #fff;
      box-sizing: border-box;
      margin-right: 10px;
      font-size: 16px;
      text-decoration: none;
    }

    ui li a:hover{
      background-color: #ea8363;
    }
  </style>
</head>
<body>
<h1><%= "设置 Content-Type 不同类型的资源" %>
</h1>
<h2><%= "根据不同的参数类型返回不同的资源" %>
</h2>
<br/>
<ul>
  <li>
      <a href="/res?type=img">返回图片</a>
  </li>

  <li>
    <a href="/res?type=img">返回图片</a>
  </li>

  <li>
    <a href="/res?type=img">返回图片</a>
  </li>
</ul>
</body>
</html>