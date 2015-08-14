'use strict';

/**
 * @ngdoc Simple controller definition that have the $scope and firstService
 *        injected by angular. The $scope is the glue between the controller
 *        and the view that displays the information. The controller is not
 *        aware about the view that displays the information.
 *
 * @name avAngularStartupApp.controller:MainCtrl
 * @description # MainCtrl Controller of the avAngularStartupApp
 */

WebInvoicingApp.controller('MainCtrl', ['$scope', 'BookService',
  function ($scope, BookService) {
    $scope.promotedBooks = BookService.findPromoted();
  }]);
