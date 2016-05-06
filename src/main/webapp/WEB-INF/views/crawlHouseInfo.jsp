<%--
  Created by IntelliJ IDEA.
  User: LXPENG
  Date: 2016/4/28
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Dashboard Template for Bootstrap</title>

  <link rel="stylesheet" href="/assets/js/rentalHouse/index.css"/>
  <link rel="stylesheet" href="/assets/css/bootstrap.css">
  <link rel="stylesheet" href="/assets/css/bootstrap-table.css"/>
</head>
<body style="padding-top: 0px">
<div align="center">
  <div id="demo"></div>

  <!--start Bootstrap-Table-->
  <div id="toolbar" class="btn-group">
    <button id="btnAdd" type="button" class="btn btn-default">
      <i class="glyphicon glyphicon-plus"></i>
    </button>
    <button id="btnCol" type="button" class="btn btn-default">
      <i class="glyphicon glyphicon-heart"></i>
    </button>
    <button id="btnDel" type="button" class="btn btn-default">
      <i class="glyphicon glyphicon-trash"></i>
    </button>
    <button id="btnImport" type="button" class="btn btn-default">
      收集
    </button>
  </div>
  <table id="table"
         class="table table-bordered"
         data-toggle="table"
         data-toolbar="#toolbar"
         data-search="true"
         <%--data-show-refresh="true"--%>
         data-show-toggle="true"
         data-show-columns="true"
         data-pagination="true">
    <thead>
    <tr>
      <th data-field="state" data-checkbox="true"></th>
      <%--<th class="col-md-1" data-field="id" hidden="hidden">ID</th>--%>
      <th class="col-md" data-field="mainTitle" data-sortable="true" data-editable="true">标题</th>
      <th class="col-md-1" data-field="housePrice" data-sortable="true" data-editable="true">租金</th>
      <th class="col-md-1" data-field="bedRoom" data-sortable="true" data-editable="true">卧室</th>
      <th class="col-md-1" data-field="livingRoom" data-sortable="true" data-editable="true">客厅</th>
      <th class="col-md-1"data-via="false" data-field="restRoom" data-sortable="true" data-editable="true">卫生间</th>
      <th class="col-md-1" data-field="area" data-sortable="true" data-editable="true">面积</th>
      <%--<th class="col-md" data-field="rentFloor" data-sortable="true" data-editable="true">楼层</th>--%>
      <%--<th class="col-md" data-field="floors" data-sortable="true" data-editable="true">总楼层</th>--%>
      <th class="col-md" data-field="toward" data-sortable="true" data-editable="true">朝向</th>
      <th class="col-md" data-field="decoration" data-sortable="true" data-editable="true">装修程度</th>
      <th class="col-md" data-field="houseType" data-sortable="true" data-editable="true">房屋类型</th>
      <th class="col-md" data-field="county" data-sortable="true" data-editable="true">县</th>
      <th class="col-md" data-field="town" data-sortable="true" data-editable="true">镇</th>
      <th class="col-md" data-field="furniture" data-sortable="true" data-editable="true">家具</th>
      <th class="col-md" data-field="description" data-sortable="true" data-editable="true">描述</th>
      <th class="col-md" data-field="contact" data-sortable="true" data-editable="true">联系人</th>
      <th class="operation" data-formatter="op_formatter">操作</th>
    </tr>
    </thead>
  </table>
  <!--end Bootstrap-Table-->
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content-parent">
      <div class="modal-header">
        <button type="button" class="close"
                data-dismiss="modal" aria-hidden="true">
          &times;
        </button>
        <h4 class="modal-title" id="myModalLabel">
          模态框（Modal）标题
        </h4>
      </div>
      <div class="modal-body modal-content">
        在这里添加一些文本
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default"
                data-dismiss="modal">关闭
        </button>
        <button type="button" class="btn btn-primary">
          提交更改
        </button>
      </div>
    </div><!-- /.modal-content -->
  </div>
  <!-- /.modal -->
</div>


<script src="http://g.tbcdn.cn/kissy/k/1.4.0/seed-min.js"></script>
<script src="/assets/js/rentalHouse/data.js"></script>
<script src="/assets/js/jquery-1.10.2.min.js"></script>
<script src="/assets/js/bootstrap.js"></script>
<script src="/assets/js/bootstrap-table.js"></script>
<script src="/assets/js/localization/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript">

  //获取地域数据
  var queryLocal = JSON.parse(JSON.stringify(${queryLocal}));
  BJDATA.queryLocal=queryLocal;
  //    start 筛选
  var S = KISSY;
  if (S.Config.debug) {
    S.config({
      packages: [
        {
          name: 'gallery/filter',
          path: '../../',
          charset: 'utf-8',
          ignorePackageNameInUri: true
        }
      ]
    });
  }

  S.config({
    packages: [
      {
        name: 'rentalHouse',
        path: '/assets/js/rentalHouse/',
        charset: 'utf-8',
        debug: true,
        ignorePackageNameInUri: true
      }
    ]
  });

  S.use('rentalHouse/index', function (S, HotelFilter) {
    new HotelFilter('#demo', BJDATA);
  });
  //end 筛选

  //选择节点
  var $table = $('#table'),
          $add = $('#btnAdd'),
          $col = $('#btnCol'),
          $del = $('#btnDel'),
          $import = $('#btnImport'),
          $collect = $('.collect');

  //table本地化
  $.extend($.fn.bootstrapTable.defaults, $.fn.bootstrapTable.locales['zh-CN']);


  $(function () {
    //添加按钮
    $add.click(function () {
      var allSelectRows = getAllSelectedRow();
      alert(JSON.stringify(allSelectRows));
    });
    //多个收藏按钮
    $col.click(function () {
      var collectIdArray = [];
      //获取选中的房屋信息id
      var allSelectRows = getAllSelectedRow();
      $.each(allSelectRows, function (i, n) {
        collectIdArray.push(n.id);
      });
      var param = {"houseIdListString" : JSON.stringify(collectIdArray)};
      param.userId = 23;
      alert('收藏一条信息参数：' + JSON.stringify(param));
      var url = "<%=basePath%>collection/collectHouse";
      collectHouse(url, param);
    });
    //多个删除按钮
    $del.click(function () {
      var collectIdArray = [];
      //获取选中的房屋信息id
      var allSelectRows = getAllSelectedRow();
      $.each(allSelectRows, function (i, n) {
        collectIdArray.push(n.id);
      });
      var param = {"houseIdListString": JSON.stringify(collectIdArray)};
      alert('删除多条信息参数：' + JSON.stringify(param));
      var url = "<%=basePath%>crawl/houseInfo/delete";
      if (param.houseIdListString == '[]') {
        alert("请选中信息");
      } else {
        collectHouse(url, param);
      }
    });
    //导入信息按钮
    $import.click(function () {
      var queryList = $('#J_FilterQueryList i');
      var param = {};
      $.each(queryList, function () {
        var key = this.attributes.getNamedItem("data-type").value,
                value = this.attributes.getNamedItem("data-value").value;
        param[key] = value;
      });
      var url = "http://localhost:8080/crawl/house/info";
      $.ajax({
        type : "GET",
        url : url,
        data : param,
        success : function(result) {
          var data = result.data;
          $('#table').bootstrapTable('load',{
            data: data,
            pagination: true
          });

          //start 收藏按钮
          $(document).on('click', '.collect', function () {
            $('tr').removeClass('selected');
            $('.bs-checkbox input').attr("checked",false);

            var nowSelected = $(this).parent('td').parent('tr');
            nowSelected.addClass('selected');
            nowSelected.children('.bs-checkbox').children('input').attr("checked",true);
            var collectIdArray = [];
            collectIdArray.push(getSelectedRow().id);
            var param = {"houseIdListString" : JSON.stringify(collectIdArray)};
            param.userId = 23;
            alert('收藏一条信息参数：' + JSON.stringify(param));
            var url = "<%=basePath%>collection/collectHouse";
            collectHouse(url, param);
          });
          //end 收藏按钮

          //start 评论按钮
          $(document).on('click', '.comment', function () {
            $('tr').removeClass('selected');
            $('.bs-checkbox input').attr("checked", false);

            var nowSelected = $(this).parent('td').parent('tr');
            nowSelected.addClass('selected');
            nowSelected.children('.bs-checkbox').children('input').attr("checked", true);

            var collectionId = getSelectedRow().id;
            var param = {"collectionId": collectionId};
            alert('收藏一条信息参数：' + JSON.stringify(param));
            $('#myModal #myModalLabel').text(collectionId);
            $('#myModal .modal-body.modal-content').text(JSON.stringify(getSelectedRow().name));
            $('#myModal').modal('toggle')
          });
          //end 评论按钮
        },
        error : function() {
          alert("网络异常");
        }
      });

    });

  });
  //获取一行数据
  function getSelectedRow() {
    var index = $table.find('tr.selected').data('index');
    return $table.bootstrapTable('getData')[index];
  }
  //获取所有选中行数据
  function getAllSelectedRow() {
    return $table.bootstrapTable('getAllSelections')
  }
  function collectHouse(url, param) {
    $.ajax({
      type : "POST",
      url : url,
      data : param,
      success : function(result) {
        var successful = result.successful;
        if(successful) {
          alert("成功");
        } else {
          alert(result.msg);
        }
      },
      error : function() {
        alert("网络异常");
      }
    });
  }

  //table 操作列
  function op_formatter(value, row) {
    var btnCom = '<button ' +
            'class="comment" ' +
            '>' +
            '评论' +
            '</button>';

    var btnRem = '<button ' +
            'class="collect"' +
            'data-toggle="modal" ' +
            'data-target="#">' +
            '收藏' +
            '</button>';

    var btnArray = new Array();
    btnArray.push(btnRem);
    return btnArray.join('');
  }
  //模态框完全隐藏时触发事件
  $("#myModal").on("hidden.bs.modal", function () {
    //todo 事件
    $(this).removeData("bs.modal");
  });

</script>
</body>
</html>