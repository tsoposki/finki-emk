/*
 * Generic CRUD resource REST service
 */
WebInvoicingApp.factory('ItemService', ['$resource', 'settings', function($resource, settings) {

  var ItemsByCategory = $resource('/api/data/rest/items/by_category/:categoryId', {categoryId:'@id'});

  return {
    findByCategoryId: findByCategoryId
  };

  function findByCategoryId(categoryId) {
    return ItemsByCategory.query({categoryId: categoryId});
  }

}]);
