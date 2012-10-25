  $(function() { initialize(); });

  function initialize() {
    $("#q").select();
  }

  var volumes;

  function doSearch(pQuery) {
    if (!pQuery) {
      return;
    }
    var query = encodeURI(pQuery);
    $('#searcher').attr('disabled', 'disabled');
    $('#scripts').append('<script src="https://www.googleapis.com/books/v1/volumes?q=' + pQuery + '&callback=handleResponse"><' + 'script>');
  }

  function handleResponse(response) {
    $('#searcher').removeAttr('disabled');

    volumes = response;

    var tokens = [];
    for (var i = 0; i < response.items.length; i++) {
      var item = response.items[i];
      var volume = item.volumeInfo;

      tokens.push('<div class="book" id="book_' + i + '">');
      tokens.push('<fieldset class="book">');
      tokens.push('<legend><img src="' + nvl(nvl(volume, 'imageLinks'), 'smallThumbnail') + '" />' + volume.title + '<span>タップで発注！</span></legend>');
      addTag(tokens, 'div', '価格：\¥' + nvl(nvl(nvl(item, 'saleInfo'), 'listPrice'), 'amount'));
      addTag(tokens, 'div', 'ISBN：' + getIsbn13(volume));
      addTag(tokens, 'div', '出版：' + (volume.publisher?volume.publisher:''));
      addTag(tokens, 'div', '著者：' + getAuthor(volume));
//      addTag(tokens, 'div', '国：' + nvl(nvl(volume, 'saleInfo'), 'country'));
      addTag(tokens, 'div', volume.description);
      tokens.push('</fieldset>');
      tokens.push('</div>');
    }
    $('#content').html(tokens.join(''));
    $('#scripts').html('');
    
    var books = $('div.book');
    books.click(function() {
      var selectedIndex = $(this).attr('id').split('_')[1] - 0
      var item = volumes.items[selectedIndex];
      doOrder(item);
    });
  }

  function doOrder(pItem) {
    var dialog = $('#dialog');
    dialog.html(pItem.kind);
    dialog.dialog({
      modal: true,
      title: 'じゃばらへ発注！'
    });
    // TODO
  }

  function nvl(pObject, pPropertyName) {
    if (!pObject) return '';
    return pPropertyName in pObject ? pObject[pPropertyName] : '';
  }

  function getAuthor(pVolume) {
    var authors = pVolume.authors;
    if (!authors) {
      return '';
    }
    return authors.join(', ');
  }

  function getIsbn13(pVolume) {
    if (!pVolume) {
      return '';
    }
    var industryIdentifiers = pVolume.industryIdentifiers;
    for (var i = 0, len = industryIdentifiers.length; i < len; ++i) {
      var industry = industryIdentifiers[i];
      if ('ISBN_13' === industry.type) {
        return industry.identifier ? industry.identifier : '';
      }
    }
    return '';
  }

  function addTag(pTokens, pTagName, pInnerHtml) {
      pTokens.push('<');
      pTokens.push(pTagName);
      pTokens.push('>');
      pTokens.push(pInnerHtml);
      pTokens.push('</');
      pTokens.push(pTagName);
      pTokens.push('>');
  }
