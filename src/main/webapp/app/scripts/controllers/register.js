WebInvoicingApp.controller('RegisterController', [
  '$scope',
  'crudService',
  '$rootScope',
  '$location',
  '$filter',
  'UserService',
  'toaster',
  function ($scope, crudService, $rootScope, $location, $filter, UserService, toaster) {
    var userService = crudService('user');
    var companyService = crudService('companies');
    var addressService = crudService('addresses');
    var cityService = crudService('cities');


    $scope.cities = cityService.query();

    $scope.newUser = {};
    $scope.newCompany = {};

    $scope.save = function (newUser, newCompany) {
      console.log(newCompany.address);

      addressService.save(newCompany.address, function (data) {
        newCompany.address.id = data.id;

        companyService.save(newCompany, function (data) {
          newCompany.id = data.id;
          newUser.company = newCompany;

          userService.save(newUser, function (data) {
            console.log(data);
            $location.path("/login");
          });
        });
      });


    };

  }]);
