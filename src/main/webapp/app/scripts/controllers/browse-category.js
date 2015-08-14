/**
 * Created by riste_000 on 3/18/2015.
 */

WebInvoicingApp.controller('BrowseCategoryController', [
  '$scope',
  'crudService',
  '$routeParams',
  'BookService',
  function ($scope, crudService, $routeParams, BookService) {
    var categoryService = crudService('categories');
    $scope.cat = categoryService.get({
      id: $routeParams.id
    });

    $scope.entities = BookService.findByCategory({
      id: $routeParams.id
    });


  }]);
