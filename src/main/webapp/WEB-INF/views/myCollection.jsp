<%--
  Created by IntelliJ IDEA.
  User: LXPENG
  Date: 2016/4/28
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <button type="btnAdd" class="btn btn-default">
      <i class="glyphicon glyphicon-plus"></i>
    </button>
    <button type="btnCol" class="btn btn-default">
      <i class="glyphicon glyphicon-heart"></i>
    </button>
    <button id="btnDel" type="button" class="btn btn-default">
      <i class="glyphicon glyphicon-trash"></i>
    </button>
    <button id="btnSearch" type="button" class="btn btn-default">
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
      <th class="col-md" data-field="rentFloor" data-sortable="true" data-editable="true">楼层</th>
      <th class="col-md" data-field="floors" data-sortable="true" data-editable="true">总楼层</th>
      <th class="col-md" data-field="toward" data-sortable="true" data-editable="true">朝向</th>
      <th class="col-md" data-field="decoration" data-sortable="true" data-editable="true">装修程度</th>
      <th class="col-md" data-field="houseType" data-sortable="true" data-editable="true">房屋类型</th>
      <th class="col-md" data-field="county" data-sortable="true" data-editable="true">县</th>
      <th class="col-md" data-field="town" data-sortable="true" data-editable="true">镇</th>
      <th class="col-md" data-field="furniture" data-sortable="true" data-editable="true">家具</th>
      <th class="col-md" data-field="description" data-sortable="true" data-editable="true">描述</th>
      <th class="col-md" data-field="contact" data-sortable="true" data-editable="true">联系人</th>
      <th data-formatter="op_formatter">操作</th>
    </tr>
    </thead>
  </table>
  <!--end Bootstrap-Table-->
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close"
                data-dismiss="modal" aria-hidden="true">
          &times;
        </button>
        <h4 class="modal-title" id="myModalLabel">
          模态框（Modal）标题
        </h4>
      </div>
      <div class="modal-body">
        <textarea class="form-control" rows="5">111</textarea>
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
  </div><!-- /.model-dialog -->
</div><!-- /.modal -->


<script src="http://g.tbcdn.cn/kissy/k/1.4.0/seed-min.js"></script>
<script src="/assets/js/rentalHouse/data.js"></script>
<script src="/assets/js/jquery-1.10.2.min.js"></script>
<script src="/assets/js/bootstrap.js"></script>
<script src="/assets/js/bootstrap-table.js"></script>
<script src="/assets/js/localization/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript">
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
  //end 筛选

  S.use('rentalHouse/index', function (S, HotelFilter) {
    new HotelFilter('#demo', BJDATA);
  });

//  $('#table').bootstrapTable({
//    data: [{
//      id: 1,
//      name: '个人-骆驼 三江超市对面骆兴家园二期车棚出租(三江超市旁。骆兴西路)',
//      price: '250',
//      roomNumber: '1',
//      toward: '南'
//    }, {
//      id: 2,
//      name: '镇海镇海村 1室1厅 46平米 中等装修 押一付一(个人)',
//      price: '500',
//      roomNumber: '1',
//      toward: '南'
//    }, {
//      id: 3,
//      name: '镇海庄市芳晨丽阳 中等装修 面议(个人)',
//      price: '500',
//      roomNumber: '1',
//      toward: '南'
//    }, {
//      id: 4,
//      name: '镇海庄市芳晨丽阳 中等装修 面议(个人)',
//      price: '500',
//      roomNumber: '1',
//      toward: '南'
//    }, {
//      id: 5,
//      name: '镇海庄市光明新村 1室1厅 48平米 精装修 押一付一',
//      price: '500',
//      roomNumber: '1',
//      toward: '南'
//    }, {
//      id: 6,
//      name: '镇海庄市柳岸柳韵 1室1厅 15平米 简单装修 押一付三',
//      price: '500',
//      roomNumber: '1',
//      toward: '南'
//    }, {
//      id: 7,
//      name: '镇海庄市逸夫小学后面 2室 40平米 简单装修 年付(个人)',
//      price: '500',
//      roomNumber: '1',
//      toward: '南'
//    }, {
//      id: 6,
//      name: '镇海庄市柳岸柳韵 1室1厅 15平米 简单装修 押一付三',
//      price: '500',
//      roomNumber: '1',
//      toward: '南'
//    }, {
//      id: 7,
//      name: '镇海庄市逸夫小学后面 2室 40平米 简单装修 年付(个人)',
//      price: '500',
//      roomNumber: '1',
//      toward: '南'
//    }, {
//      id: 6,
//      name: '镇海庄市柳岸柳韵 1室1厅 15平米 简单装修 押一付三',
//      price: '500',
//      roomNumber: '1',
//      toward: '南'
//    }, {
//      id: 7,
//      name: '镇海庄市逸夫小学后面 2室 40平米 简单装修 年付(个人)',
//      price: '500',
//      roomNumber: '1',
//      toward: '南'
//    }, {
//      id: 6,
//      name: '镇海庄市柳岸柳韵 1室1厅 15平米 简单装修 押一付三',
//      price: '500',
//      roomNumber: '1',
//      toward: '南'
//    }, {
//      id: 7,
//      name: '镇海庄市逸夫小学后面 2室 40平米 简单装修 年付(个人)',
//      price: '500',
//      roomNumber: '1',
//      toward: '南'
//    }]
//  });

  var $table = $('#table'),
          $button = $('#btnDel'),
          $search = $('#btnSearch');


  $(function () {
    //删除按钮
    $button.click(function () {
      alert('getSelections: ' + getSelectedRow());
    });

    function getSelectedRow() {
      var selectedRows = $table.bootstrapTable('getSelections');
      console.log(JSON.stringify(selectedRows))
      $.each(selectedRows, function (i, n) {
        alert('id = ' + n.id);
      });
    }

    //搜索
    $search.click(function () {
      var param = {};
      param["userId"] = 1;

      var url = "http://localhost:8080/collection/houseList";
      $.ajax({
        type : "POST",
        url : url,
        data : param,
        success : function(result) {
          var data = result.data;
          $('#table').bootstrapTable('load',{
            data: data,
            pagination: true
          });

        },
        error : function() {
          alert("网络异常");
        }
      });

    });

  });

  function op_formatter(value, row) {
    var btnCom = '<button ' +
            'data-toggle="modal" ' +
            'data-target="#myModal">' +
            '评论' +
            '</button>';
    var btnRem = '<button ' +
            'data-toggle="modal" ' +
            'data-target="#">' +
            '收藏' +
            '</button>';

    var btnArray = new Array();
    btnArray.push(btnCom);
    return btnArray.join('');
  }

  $.extend($.fn.bootstrapTable.defaults, $.fn.bootstrapTable.locales['zh-CN']);

</script>
</body>
</html>