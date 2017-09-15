// Haluk Ozduman 2016

'use strict';

var cryptoApp = angular.module('cryptoApp', [
	'ngRoute',
	'ngResource',
	'resourceServices',
	'controllers'
]);

cryptoApp.config(['$routeProvider', '$locationProvider',
	function($routeProvider, $locationProvider) {
	   $routeProvider.
	     when('/', {
         templateUrl: 'views/main.html',
         controller: 'MainCtrl'
	   });
}]);
