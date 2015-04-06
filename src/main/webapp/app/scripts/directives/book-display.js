/*
 * Directive for generic combo (select)
 *
 */

FirstApp.directive('bookDisplay', [
  'crudService',
  '$location',
  function (crudService, $location) {
    return {
      restrict: 'AE',
      scope: {
        entity: '='
      },
      compile: function (tElem, attrs) {


        return function (scope, elem, attrs) {

        };
      },
      controller: function ($scope, $element, crudService, $injector) {
        $scope.display = function () {
          $location.path('/book/details/' + $scope.entity.id);
        }
      },
      templateUrl: 'directives/book-display.html'
    };
  }]);

