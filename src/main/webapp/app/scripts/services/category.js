/*
 * Generic CRUD resource REST service
 */
WebInvoicingApp.factory('Category', [ '$resource', function($resource) {
	return $resource('api/data/rest/categories/:id', {}, {});
} ]);
