/*
 * Generic CRUD resource REST service
 */
WebInvoicingApp.factory('InvoicesService', ['$resource', 'settings', function($resource, settings) {

  var Invoices = $resource('/api/data/rest/invoices/:invoiceId', {invoiceId:'@id'});
  return $resource('api/data/rest/invoices/:id', {}, {});

}]);
