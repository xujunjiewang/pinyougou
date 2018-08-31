app.controller("typeTemplateController", function ($scope, $controller, typeTemplateService, brandService, specificationService) {

   $controller("baseController", {$scope:$scope}); //继承


    $scope.searchEntity = {};
    //分页显示查询
    $scope.search = function (page, size) {
        typeTemplateService.search(page, size, $scope.searchEntity).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;
            }
        );
    }

    //添加，修改模板
    $scope.save = function() {
        var serviceObject;//服务层对象
        if($scope.entity.id != null) {
            serviceObject = typeTemplateService.revise($scope.entity);
        }else {
            serviceObject = typeTemplateService.add($scope.entity);
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
        typeTemplateService.searchOne(id).success(
            function (response) {
                $scope.entity = response;
                $scope.entity.brandIds = JSON.parse($scope.entity.brandIds);
                $scope.entity.specIds = JSON.parse($scope.entity.specIds);
                $scope.entity.customAttributeItems = JSON.parse($scope.entity.customAttributeItems);
            });
    }

    //删除模板
    $scope.expurgate = function() {
        typeTemplateService.expurgate($scope.selectIds).success(
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
        $scope.entity.customAttributeItems.push({});
    }

    //删除行
    $scope.delTableRow = function (index) {
        $scope.entity.customAttributeItems.splice(index, 1);
    }

    //select2多选数据
    $scope.brandList = {data:[]};
    $scope.searchBrandList = function () {
        brandService.searchBrandList().success(
            function (response) {
                $scope.brandList = {data:response};
            }
        );
    }

    $scope.specList = {data:[]}
    $scope.searchSpecList = function () {
        specificationService.searchSpecList().success(
            function (response) {
                $scope.specList = {data:response};
            }
        );
    }
});