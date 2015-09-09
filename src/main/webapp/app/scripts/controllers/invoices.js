WebInvoicingApp.controller('InvoicesController',
  [
    '$scope',
    'crudService',
    '$location',
    function ($scope, crudService, $location) {
      var service = crudService('invoices');

      $scope.disabled = true;

      $scope.entities = service.query();

      $scope.showInvoice = function(id) {
        $location.path("/invoice/" + id);
      };

    }]);
