(function(c){function b(d){var e=d||(App.Domain.space+"/cmt/share/");this.viewUrl=e+"get_thread?asyn=1&";this.addUrl=e+"add_cmt";this.delUrl=e+"delete_cmt";this.getListContUrl=e+"batch_count?asyn=1&"}var a;b.prototype={view:function(f){var e=baidu.url.jsonToQuery(f);var d=this.viewUrl+e+"&t="+Math.random();baidu.sio.callByBrowser(d)},addComment:function(d){a=a?a:new Space.Libs.IframeLoader();a.request(this.addUrl,d)},delComment:function(d){a=a?a:new Space.Libs.IframeLoader();a.request(this.delUrl,d)},getListCont:function(f){var e=baidu.url.jsonToQuery(f);var d=this.getListContUrl+e+"&t="+Math.random();baidu.sio.callByBrowser(d)}};c.Comment=b})(Space.Pubs);