/*
 * Generic CRUD resource REST service
 */
WebInvoicingApp.factory('Order', ['$resource', 'settings', function($resource, settings) {

  return $resource('api/data/rest/order_items/:id', {}, {
    getMyOrders: {
      method: 'GET',
      url: 'api/data/rest/order_items/my',
      isArray: true
    },
    checkPay: {
      method: 'POST',
      url: 'api/data/rest/order_items/check_pay'
    }
  });

}]);
