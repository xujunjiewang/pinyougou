app.controller("specificationController", function ($scope, $controller, specificationService) {

   $controller("baseController", {$scope:$scope}); //继承


    $scope.searchEntity = {};
    //分页显示查询
    $scope.search = function (page, size) {
        specificationService.search(page, size, [$scope.searchEntity]).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;
            }
        );
    }

    //添加规格
    $scope.save = function() {
        var serviceObject;//服务层对象
        if($scope.entity.specification.id != null) {
            serviceObject = specificationService.revise($scope.entity);
        }else {
            serviceObject = specificationService.add($scope.entity);
            //修改当前页
            $scope.paginationConf.currentPage = Math.ceil( $scope.paginationConf.totalItems /  $scope.paginationConf.itemsPerPage);
        }


        serviceObject.success(
            function (response) {
                if(response.success) {
                    $scope.reloadList();
                }else {
                    alert(response.message);
                }
        });
    }

    //根据id查找实体类
    $scope.searchOne = function(id) {
        specificationService.searchOne(id).success(
            function (response) {
                $scope.entity = response;
        });
    }

    //删除规格
    $scope.expurgate = function() {
        specificationService.expurgate($scope.selectIds).success(
            function (response) {
                if(response.success) {
                    $scope.reloadList();
                }else {
                    alert($scope.message);
                }
            }
        );
    }

    //添加行
    $scope.addTableRow = function () {
        $scope.entity.specificationOptionList.push({});
    }

    //删除行
    $scope.delTableRow = function (index) {
        $scope.entity.specificationOptionList.splice(index, 1);
    }

});