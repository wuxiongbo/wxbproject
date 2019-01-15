/** 定义基础控制器层 */
app.controller('baseController',function($scope){

    /** 定义分页配置信息对象 */
    $scope.paginationConf = {
        currentPage : 1, // 当前页码
        totalItems : 0, // 总记录数
        itemsPerPage : 10, // 每页显示的记录数
        perPageOptions : [10,15,20], // 页码下拉列表
        onChange : function() { // 改变事件
            $scope.reload();
        }
    };

    /** 改变事件: 下拉列表页码发生改变时，重新加载数据 */
    $scope.reload = function(){
        $scope.search($scope.paginationConf.currentPage,
                      $scope.paginationConf.itemsPerPage);
    };

    /** 定义ids数组封装删除的id */
    $scope.ids = [];

    /** 定义checkbox点击事件函数 */
    $scope.updateSelection = function($event,id){
        //传入id
        // alert('获取到id:'+id);
        //判断
        if($event.target.checked){
            // alert('选中');
            $scope.ids.push(id);//选中,添加到数组
        }else{
            // alert('未选中')
            var index = $scope.ids.indexOf(id); //获取未选中的id在数组中的索引;
            $scope.ids.splice(index,1);// 数组中,索引处起,删除一位;
        }
    }

});