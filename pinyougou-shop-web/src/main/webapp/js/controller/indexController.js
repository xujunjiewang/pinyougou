app.controller("indexController", function ($scope, indexService) {

    //显示用户名
    $scope.showLoginName = function() {
        indexService.showLoginName().success(
            function (response) {
                $scope.showName = response.showName;
            });
    }
})