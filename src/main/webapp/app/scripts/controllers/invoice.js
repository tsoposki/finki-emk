WebInvoicingApp.controller('InvoiceController',
  [
    '$scope',
    'crudService',
    '$routeParams',
    'toaster',
    function ($scope, crudService, $routeParams, toaster) {
      var invoiceService = crudService('invoices');

      $scope.items = itemsService.query();
      $scope.partners = partnerService.query();
      $scope.currencies = currencyService.query();
      $scope.paymentTypes = paymentService.query();

      $scope.newInvoice = {
        invoiceItems: [],
        issueDate: 0,
        maturityDate: 0
      };
      $scope.issueDate = {};
      $scope.maturityDate = {};
      $scope.totalPrice = 0;
      $scope.totalTax = 0;

      $scope.newItem = {};

      $scope.addNewItem = function() {
        var issueDate = new Date($scope.issueDate);
        var maturityDate = new Date($scope.maturityDate);

        $scope.newInvoice.invoiceItems.push($scope.newItem);

        $scope.newInvoice.issueDate = issueDate.getTime();
        $scope.newInvoice.maturityDate = maturityDate.getTime();

        updateSummary();
      };

      function updateSummary() {
        var totalPrice = 0;
        var totalTax = 0;

        for(var i=0; i<$scope.newInvoice.invoiceItems.length; i++) {
          var invoiceItem = $scope.newInvoice.invoiceItems[i];

          totalPrice += invoiceItem.item.price * invoiceItem.quantity;
          totalTax += (invoiceItem.item.tax/100) * invoiceItem.item.price * invoiceItem.quantity;
        }

        $scope.totalPrice = totalPrice;
        $scope.totalTax = totalTax;
      }

      $scope.createInvoice = function() {
        invoiceService.save($scope.newInvoice, function(data) {
          console.log(data);
        });
      };

    }]);
