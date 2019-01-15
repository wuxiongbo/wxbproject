app.controller("brandController",function($scope,baseService,$controller){

/** 继承baseController控制器 */
    $controller('baseController',{$scope:$scope});

//删除数据
    //定义ids数组封装删除的id;
    //1.选中的id封装成数组

    //2.定义checkbox点击事件函数

    //3.执行批量删除
    $scope.delete = function(){

        if($scope.ids.length > 0){

            //发送异步请求
            baseService.deleteById("/brand/delete",$scope.ids).then(
                function(response){
                    if (response.data){
                        //重载当前页的品牌数据
                        $scope.reload();
                    }
                },function (response) {
                    alert('数据删除失败!!');
                })

        }else{
            alert('请选择要删除的品牌!');
        }
    }

//保存数据
    $scope.saveOrUpdate = function(){
        //判断是添加还是修改方法
        var url = "save"; //默认为添加
        if($scope.entity.id){
            url="update";  //进来这里,表示有id值,判断为修改
        }

        baseService.sendPost("/brand/"+url, $scope.entity).then(
            function (response) {
                alert(JSON.stringify(response));
                if(response.data){
                    $scope.reload();
                }else{
                    alert('添加失败!')
                }
            }
        )
    };

    //显示修改窗口的数据;  为什么这个不允许抽取到baseController中;
    $scope.show = function(brand){
        var newbrand = JSON.parse(JSON.stringify(brand));
        $scope.entity = newbrand;  //entity 是在这里定义的
    };


//分页查询数据
    //分页配置对象

    //定义查询条件对象
    $scope.searchEntity = {};

    //分页查询数据,  page当前页,rows每页显示页码
    $scope.search = function (page, rows) {
        baseService.findByPage('/brand/findByPage',page,rows,$scope.searchEntity)
            .then(function (response) {
            $scope.dataList = response.data.rows;
            $scope.paginationConf.totalItems = response.data.total;
            })
    }
})