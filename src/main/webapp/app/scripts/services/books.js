/*
 * Generic CRUD resource REST service
 */
FirstApp.factory('BookService', ['$resource', 'settings', function ($resource, settings) {

  return $resource(settings.contextPath + '/data/rest/books/:id', {}, {
    findPromoted: {
      method: 'GET',
      url: settings.contextPath + "/data/rest/books/promoted",
      isArray: true
    },
    paged: {
      method: 'GET',
      url: settings.contextPath + "/data/rest/books/paged"
    }
  });

}]);
