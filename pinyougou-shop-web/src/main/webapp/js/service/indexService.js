app.service("indexService", function ($http) {
    //显示登录名
    this.showLoginName=function () {
        return $http.get("../login/name.do");
    }
});