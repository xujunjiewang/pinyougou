app.service("specificationService", function ($http) {

    this.add = function (entity) {
        return $http.post("../specification/addSpecification.do", entity);
    }

    this.revise = function (entity) {
        return $http.post("../specification/reviseSpecification.do", entity);
    }

    this.searchOne = function (id) {
        return $http.get("../specification/searchOne.do?id=" + id);
    }

    this.expurgate = function (selectIds) {
        return  $http.get("../specification/expurgateSpecification.do?ids=" + selectIds);
    }

    this.search = function (page, size, searchEntity) {
        return $http.post("../specification/searchPage.do?page=" + page + "&size=" + size, searchEntity);
    }

    this.searchSpecList = function () {
        return $http.get("../specification/searchSpecList.do");
    }
});