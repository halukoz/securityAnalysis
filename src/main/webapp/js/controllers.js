//Haluk Ozduman 2016

'use strict';

var controllers = angular.module('controllers', []);

controllers.controller('MainCtrl', ['$scope', '$location', '$http',
	function MainCtrl($scope, $location, $http) {
	
	var http = $http;
	var scope = $scope;
}]);


controllers.controller('CaesarCtrl', ['$scope', '$location', '$http', 'ceasarService',
	function CaesarCrtl($scope, $location, $http, ceasarService) {
	
	var http = $http;
	var scope = $scope;	
	
	scope.title = 'Ceasar Cipher';	
	$scope.encryptWithCeasarCipher = function() {
	      ceasarService.getEncryptedTextFromCeasarCipher(scope.ceasarPlainText, scope.shiftAmountPlainText).then(function(response) {
			scope.encryptedText = response;
		  });
	}
	
	$scope.decryptWithCeasarCipher = function() {
		ceasarService.getDecryptedTextFromCeasarCipher(scope.ceasarCipheredText, scope.shiftAmountCipheredText).then(function(response) {
			scope.decryptedText = response;
		 });
	}

	$scope.clearEncryptionCeasarCipher = function() {
		scope.ceasarPlainText = "";
		scope.shiftAmountPlainText = "";
		scope.encryptedText = "";
		
	}
	
	$scope.clearDecryptionCeasarCipher = function() {
		scope.shiftAmountCipheredText = "";
		scope.ceasarCipheredText = "";
		scope.decryptedText = "";
	}
}]);

controllers.controller('VigenereCtrl', ['$scope', '$location', '$http', 'vigenereService',
	function CaesarCrtl($scope, $location, $http, vigenereService) {

	var http = $http;
	var scope = $scope;

	$scope.encryptWithVigenereCipher = function() {
		
		vigenereService.getEncryptedTextFromVigenereCipher(scope.vigenerePlainText, scope.keyPlainText).then(function(response) {
			scope.encryptedText = response;
	    });
	}

	$scope.decryptWithVigenereCipher = function() {
		
		vigenereService.getDecryptedTextFromVigenereCipher(scope.vigenereCipheredText, scope.keyCipheredText).then(function(response) {
			scope.decryptedText = response;
		});
	}

	$scope.clearEncryptionVigenereCipher = function() {
		scope.vigenerePlainText = "";
		scope.keyPlainText = "";
		scope.encryptedText = "";
	}
	
	$scope.clearDecryptionVigenereCipher = function() {
		scope.vigenereCipheredText = "";
		scope.keyCipheredText = "";
		scope.decryptedText = "";
	}
}]);

controllers.controller('OneTimePaddingCtrl', ['$scope', '$location', '$http','oneTimePaddingService', 
	function CaesarCrtl($scope, $location, $http, oneTimePaddingService) {

	var http = $http;
	var scope = $scope;

	$scope.encryptWithOneTimePadding = function() {
		
		oneTimePaddingService.getEncryptedTextFromOneTimePadding(scope.oneTimePaddingPlainText, scope.keyPlainText).then(function(response) {
			scope.encryptedText = response;
	    });
	}

	$scope.decryptWithOneTimePadding = function() {
		
		oneTimePaddingService.getDecryptedTextFromOneTimePadding(scope.oneTimePaddingCipheredText, scope.keyCipheredText).then(function(response) {
			scope.decryptedText = response;
	    });
	}
	
	$scope.clearEncryptionOneTimePadding = function() {
		scope.oneTimePaddingPlainText = "";
		scope.keyPlainText = "";
		scope.encryptedText = "";
	}
	
	$scope.clearDecryptionOneTimePadding = function() {
		scope.oneTimePaddingCipheredText = "";
		scope.keyCipheredText = "";
		scope.decryptedText = "";
	}
}]);

controllers.controller('DesCtrl', ['$scope', '$location', '$http', 'desService',
	function DesCtrl($scope, $location, $http, desService) {

	var http = $http;
	var scope = $scope;

	$scope.encryptWithDes = function() {
		
		desService.getEncryptedTextFromDes(scope.desPlainText).then(function(response) {
			scope.encryptedText = response;
	    });
	}

	$scope.clearEncryptionDes = function() {
		scope.desPlainText = "";
		scope.encryptedText = "";
	}
}]);

controllers.controller('AesCtrl', ['$scope', '$location', '$http', 'aesService',
	function AesCtrl($scope, $location, $http, aesService) {

	var http = $http;
	var scope = $scope;

	$scope.encryptWithAes = function() {
		
		aesService.getEncryptedTextFromAes(scope.aesPlainText,scope.keyPlainText).then(function(response) {
			scope.encryptedText = response;
	    });
	}

	$scope.decryptWithAes = function() {
		
		aesService.getDecryptedTextFromAes(scope.aesCipheredText,scope.keyCipheredText).then(function(response) {
			scope.decryptedText = response;
	    });
	}
	
	$scope.clearEncryptionAes = function() {
		scope.aesPlainText = "";
		scope.keyPlainText = "";
		scope.encryptedText = "";
	}
	
	$scope.clearDecryptionAes = function() {
		scope.aesCipheredText = "";
		scope.keyCipheredText = "";
		scope.decryptedText = "";
	}
}]);
