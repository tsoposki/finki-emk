/*
 * Generic CRUD resource REST service
 */
WebInvoicingApp.factory('BookService', ['$resource', 'settings', function($resource, settings) {

  return $resource('api/data/rest/books/:id', {}, {
    findPromoted: {
      method: 'GET',
      url: 'api/data/rest/books/promoted',
      isArray: true
    },
    findByCategory: {
      method: 'GET',
      url: 'api/data/rest/books/by_category/:id',
      isArray: true
    },
    search: {
      method: 'GET',
      url: 'api/data/rest/books/search',
      isArray: true
    },
    paged: {
      method: 'GET',
      url: 'api/data/rest/books/paged'
    }
  });

}]);
