'use strict';

WebInvoicingApp.factory('UserService', function($resource) {

	return $resource('api/data/rest/user/:action', {}, {
		authenticate : {
			method : 'POST',
			params : {
				'action' : 'authenticate'
			},
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}
	});
});
