/**
 * Created by riste_000 on 3/18/2015.
 */

FirstApp.controller('BrowseCategoryController', [
  '$scope',
  'crudService',
  '$routeParams',
  'toaster',
  function ($scope, crudService, $routeParams, toaster) {
    var categoryService = crudService('categories');
    $scope.cat = categoryService.get({
      id: $routeParams.id
    }, function (data) {
      console.log(data);
      $scope.entities = bookService.query({
        categoryId: $scope.cat.id
      })
    });

    var bookService = crudService('books');



  }]);
