app.service("brandService", function ($http) {

    this.add = function (entity) {
        return $http.post("../brand/addBrand.do", entity);
    }

    this.revise = function (entity) {
        return $http.post("../brand/reviseBrand.do", entity);
    }

    this.searchOne = function (id) {
        return $http.get("../brand/searchOne.do?id=" + id);
    }

    this.expurgate = function (selectIds) {
        return  $http.get("../brand/expurgateBrand.do?ids=" + selectIds);
    }

    this.searchEntity = function (page, size, searchEntity) {
        return $http.post("../brand/searchPage.do?page=" + page + "&size=" + size, searchEntity);
    }

    this.searchBrandList = function () {
        return $http.get("../brand/searchBrandList.do");
    }
});