/*
 * Generic CRUD resource REST service
 */
WebInvoicingApp.factory('Category', [ '$resource', function($resource) {
	return $resource('/data/rest/categories/:id', {}, {});
} ]);
