<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta charset="UTF-8" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/jabazon.css" media="screen"></link>
    <title>書籍検索 - Jabazon</title>
  </head>
  <body>
    <h1>Jabazonへようこそ！</h1>
    <form action="" method="get">
      <input type="text" id="q" name="q" value="<%=request.getAttribute("q") %>" />
      <input type="submit" id="searcher" value="検索" />
    </form>
    <div id="content"></div>
    <footer>Powered by <a href="http://books.google.co.jp">Google books</a></footer>

    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jabazon.js"></script>
    <script>
      $(function() {
        doSearch('<%=request.getAttribute("q")%>');
      });
    </script>
    <div id="scripts"></div>
  </body>
</html>
