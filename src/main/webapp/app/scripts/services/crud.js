/*
 * Generic CRUD resource REST service
 */
WebInvoicingApp.factory('crudService', ['$resource', 'settings', function($resource, settings) {
  return function(type) {
    return $resource('api/data/rest/' + type + '/:id', {}, {
      import: {
        method: 'POST',
        url: 'api/data/rest/' + type + '/import'
      },
      paged: {
        method: 'GET',
        url: 'api/data/rest/' + type + '/paged'
      }
    });
  };
}]);
