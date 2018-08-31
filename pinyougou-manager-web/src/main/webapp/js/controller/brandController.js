app.controller('brandController', function ($scope, $controller, brandService) {

    $controller("baseController", {$scope:$scope}); //继承


    //新增，修改
    $scope.save = function() {
        var serviceObject;
        if($scope.entity.id != null) {
            serviceObject = brandService.revise($scope.entity); //修改
        }else {
            serviceObject = brandService.add($scope.entity);  //添加
            //修改当前页为最后一页
            $scope.paginationConf.currentPage = Math.ceil($scope.paginationConf.totalItems / $scope.paginationConf.itemsPerPage);
        }

        serviceObject.success(
            function (response) {
                if(response.success) {
                    $scope.reloadList();
                }else {
                    alert(response.message);
                }
            }
        );
    }

    //根据id查找实体
    $scope.searchOne = function(id) {
        brandService.searchOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        );
    }



    //删除
    $scope.expurgate = function() {
        if(confirm("确定要删除吗?")) {
            brandService.expurgate($scope.selectIds).success(
                function (response) {
                    if(response.success) {
                        $scope.reloadList();
                        $scope.selectIds = [];
                    }else {
                        alert(response.message);
                    }
                }
            );
        }
    }

    $scope.searchEntity = {};
    //分页查询显示
    $scope.search = function (page, size) {
        brandService.searchEntity(page, size, $scope.searchEntity).success(
            function (response) {
                $scope.list = response.rows;//显示当前页数据
                $scope.paginationConf.totalItems = response.total; //更新总记录数
            });
    }
});