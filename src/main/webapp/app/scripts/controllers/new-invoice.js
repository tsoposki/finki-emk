WebInvoicingApp.controller('NewInvoiceController',
  [
    '$scope',
    'crudService',
    '$routeParams',
    'toaster',
    function ($scope, crudService, $routeParams, toaster) {
      var itemsService = crudService('items');
      var partnerService = crudService('partners');
      var paymentService = crudService('payment_types');
      var currencyService = crudService('currencies');
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

      $scope.addNewItem = function (item, quantity) {
        //var issueDate = new Date($scope.issueDate);
        //var maturityDate = new Date($scope.maturityDate);

        var itemIndex = hasItem(item);

        if (itemIndex >= 0) {
          updateQuantity(itemIndex, $scope.newInvoice.invoiceItems[itemIndex].quantity + quantity);
        } else {
          $scope.newInvoice.invoiceItems.push({
            item: item,
            quantity: quantity
          });
        }

        //$scope.newInvoice.issueDate = issueDate.getTime();
        //$scope.newInvoice.maturityDate = maturityDate.getTime();

        updateSummary();
      };

      function hasItem(item) {
        var itemIndex = -1;

        for (var i = 0; i < $scope.newInvoice.invoiceItems.length; i++) {
          if ($scope.newInvoice.invoiceItems[i].item.id === item.id) {
            itemIndex = i;
            break;
          }
        }

        return itemIndex;
      }

      function updateQuantity(index, newQuantity) {
        $scope.newInvoice.invoiceItems[index].quantity = newQuantity;
      }

      function updateSummary() {
        var totalPrice = 0;
        var totalTax = 0;

        for (var i = 0; i < $scope.newInvoice.invoiceItems.length; i++) {
          var invoiceItem = $scope.newInvoice.invoiceItems[i];

          totalPrice += invoiceItem.item.price * invoiceItem.quantity;
          totalTax += (invoiceItem.item.tax.value / 100) * invoiceItem.item.price * invoiceItem.quantity;
        }

        $scope.newInvoice.totalPrice = totalPrice;
        $scope.newInvoice.totalTax = totalTax;

      }

      $scope.createInvoice = function () {
        invoiceService.save($scope.newInvoice, function (data) {
          console.log(data);
        });
      };


      // util functions
      function guid() {
        function s4() {
          return Math.floor((1 + Math.random()) * 0x10000)
            .toString(16)
            .substring(1);
        }

        return s4() + s4() + '-' + s4() + '-' + s4() + '-' +
          s4() + '-' + s4() + s4() + s4();
      }

    }]);
