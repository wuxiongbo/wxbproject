/** 定义控制器层 */
app.controller('specificationController', function($scope, $controller, baseService){

    /** 指定继承baseController */
    $controller('baseController',{$scope:$scope});

    /** 定义一个空的搜索对象 */
    $scope.searchEntity = {};
    /** 分页查询 */
    $scope.search = function(page, rows){
        //进来方法后,
        baseService.findByPage("/specification/findByPage", page, rows, $scope.searchEntity)
            .then(function(response){
                $scope.dataList = response.data.rows;
                /** 更新总记录数 */
                $scope.paginationConf.totalItems = response.data.total;
            });
    };

    /** 添加或修改 */
    $scope.saveOrUpdate = function(){
        var url = "save";
        if ($scope.entity.id){
            url = "update";
        }
        alert(JSON.stringify($scope.entity));

        /** 发送post请求 */
        baseService.sendPost("/specification/" + url, $scope.entity)
            .then(function(response){
                if (response.data){
                    /** 重新加载数据 */
                    $scope.reload();
                    $scope.entity = {};
                }else{
                    alert("操作失败！");
                }
            });
    };

    /** 显示修改 */
    $scope.show = function(entity){
       $scope.entity = JSON.parse(JSON.stringify(entity));
       /** 调用服务层, 发送异步请求,根据当前规格id查询其所有规格选项 */
       baseService.findOne("/specification/findOne",entity.id)
            .then(function(response){
                $scope.entity.specificationOptions = response.data;
            });

    };

    /** 批量删除 */
    $scope.delete = function(){
        if ($scope.ids.length > 0){
            baseService.deleteById("/specification/delete", $scope.ids)
                .then(function(response){
                    if (response.data){
                        $scope.reload();
                    }else{
                        alert("删除失败！");
                    }
                });
        }
    };

    /** 新增规格选项行 */
    $scope.addTableRow = function(){
        $scope.entity.specificationOptions.push({});
    };
    /** 删除规格选项行 */
    $scope.deleteTableRow = function(index){
        $scope.entity.specificationOptions.splice(index, 1);
    };
});