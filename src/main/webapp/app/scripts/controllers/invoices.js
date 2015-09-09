WebInvoicingApp.controller('InvoicesController',
  [
    '$scope',
    'crudService',
    '$location',
    function ($scope, crudService, $location) {
      var service = crudService('invoices');
      $scope.entities = service.query(function(data) {
        console.log('finished loading');
        var totalPrice = 0;
        var totalTax = 0;

        if($scope.entities.invoiceItems) {
          for(var i=0; i<$scope.entities.invoiceItems.length; i++) {
            var invoiceItem = $scope.entities.invoiceItems[i];
            totalPrice += invoiceItem.item.price * invoiceItem.quantity;
            totalTax += (invoiceItem.item.tax/100) * invoiceItem.item.price * invoiceItem.quantity;

            $scope.entities[i].totalPrice = totalPrice;
            $scope.entities[i].totalTax = totalTax;
          }
        }

      });

      $scope.$watch('entities', function(newValue, oldValue) {

      });

      $scope.showInvoice = function(id) {
        $location.path("/invoice/" + id);
      };

    }]);
