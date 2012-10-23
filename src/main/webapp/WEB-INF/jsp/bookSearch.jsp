<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta charset="UTF-8" />
    <style type="text/css" rel="" href="${pageContext.request.contextPath}/css/style.css"></style>
    <title>書籍検索 - Jabazon</title>
  </head>
  <body>
    <h1>Jabazonへようこそ！</h1>
    <form>
      <input type="text" id="q" /> <button id="searcher">検索</button>
    </form>
    <div id="content"></div>
    <footer>Powered by <a href="http://books.google.co.jp">Google books</a></footer>
    
    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
    <script>
      function initialize() {
        $('#searcher').click(function() {
          var query = encodeURI($('#q').val());
          if (!query) {
        	  return false;
          }
          $('#scripts').append('<script src="https://www.googleapis.com/books/v1/volumes?q=' + query + '&callback=handleResponse"><' + 'script>');
          return false;
        });
      }
      $(initialize);

      function handleResponse(response) {
        for (var i = 0; i < response.items.length; i++) {
          var item = response.items[i];
          // in production code, item.text should have the HTML entities escaped.
          document.getElementById("content").innerHTML += "<br>" + item.volumeInfo.title;
        }
      }
    </script>
    <div id="scripts"></div>
    <!--
    <script src="https://www.googleapis.com/books/v1/volumes?q=harry+potter&callback=handleResponse"></script>
    -->
  </body>
</html>