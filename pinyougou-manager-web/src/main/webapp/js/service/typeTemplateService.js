app.service("typeTemplateService", function ($http) {

    this.add = function (entity) {
        return $http.post("../typeTemplate/addTypeTemplate.do", entity);
    }

    this.revise = function (entity) {
        return $http.post("../typeTemplate/reviseTypeTemplate.do", entity);
    }

    this.searchOne = function (id) {
        return $http.get("../typeTemplate/searchOne.do?id=" + id);
    }

    this.expurgate = function (selectIds) {
        return  $http.get("../typeTemplate/expurgateTypeTemplate.do?ids=" + selectIds);
    }

    this.search = function (page, size, searchEntity) {
        return $http.post("../typeTemplate/searchPage.do?page=" + page + "&size=" + size, searchEntity);
    }

});