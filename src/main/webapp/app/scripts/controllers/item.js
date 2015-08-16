WebInvoicingApp.controller('ItemController',
  [
    '$scope',
    'crudService',
    'ItemService',
    '$routeParams',
    'toaster',
    function ($scope, crudService, itemService, $routeParams, toaster) {
      var service = crudService('items');
      var taxCrudService = crudService('taxes');
      var currencyCrudService = crudService('currencies');
      var categoryCrudService = crudService('categories');

      $scope.getItems = function(categoryId) {
        if(categoryId == -1) {
          $scope.entities = service.query();
        }
        else {
          $scope.entities = itemService.findByCategoryId(categoryId);
        }
      };

      $scope.disabled = true;

      $scope.entities = service.query();
      if ($routeParams.id) {
        $scope.entity = service.get({
          id: $routeParams.id
        });
      } else {
        $scope.entity = {};
      }

      $scope.taxes = taxCrudService.query();
      $scope.currencies = currencyCrudService.query();
      $scope.categories = categoryCrudService.query();
      $scope.selectedItem = {};

      $scope.entity = {};

      $scope.edit = function (id) {
        $scope.entity = service.get({
          id: id
        });
      };

      $scope.save = function (item) {
        service.save(item, function (data) {
          $scope.entity = {};
          $scope.entities = service.query();
        });
      };

      $scope.remove = function (id) {
        service
          .remove(
          {
            id: id
          },
          function () {
            $scope.entities = service
              .query();
          },
          function (res) {
            if (res.status == 500) {
              // alert('ne moze da se
              // izbrise!');
              toaster
                .pop(
                'error',
                'Deleting error',
                'Ne moze da se izbrise objektot. Postoi drug objekt so nadvoresen kluc koj pokazuva kon nego!');
            }
          });

      };

      $scope.showItem = function(item) {
        $scope.selectedItem = _(item).clone();
        $scope.selectedItem.priceWithTax = item.price * (1 + item.tax.value/100);

        console.log($scope.selectedItem);
      };

      $scope.$watch('entity.tax', function(newValue, oldValue) {
        if($scope.entity.price) {
          $scope.newArticlePriceWithTax = $scope.entity.price * (1 + $scope.entity.tax.value/100);
        }
      });

      $scope.$watch('entity.price', function(newValue, oldValue) {
        if($scope.entity.tax) {
          $scope.newArticlePriceWithTax = $scope.entity.price * (1 + $scope.entity.tax.value/100);
        }
      });

      $scope.$watch('selectedItem.price', function(newValue, oldValue) {
        if($scope.selectedItem.tax) {
          $scope.selectedItem.priceWithTax = $scope.selectedItem.price * (1 + $scope.selectedItem.tax.value/100);
        }
      });

      $scope.$watch('selectedItem.tax', function(newValue, oldValue) {
        if($scope.selectedItem.price) {
          $scope.selectedItem.priceWithTax = $scope.selectedItem.price * (1 + $scope.selectedItem.tax.value/100);
        }
      });

    }]);
