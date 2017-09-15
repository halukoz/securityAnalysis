'use strict';

var services = angular.module('resourceServices', ['ngResource']);


services.service('ceasarService', function($http, $q){
	
	this.getEncryptedTextFromCeasarCipher = function(ceasarPlainText, shiftAmountPlainText) {
		
		var defer = $q.defer();
		$http.get("http://localhost:8080/cryptoanalysis/api/messages/caesar/encryption/"+ ceasarPlainText +"/"+shiftAmountPlainText).then(function(response) {
	    	defer.resolve(response.data);
		});
	    return defer.promise;
	}
	
    this.getDecryptedTextFromCeasarCipher = function(ceasarCipheredText, shiftAmountCipheredText) {
		
		var defer = $q.defer();
		$http.get("http://localhost:8080/cryptoanalysis/api/messages/caesar/decryption/"+ ceasarCipheredText +"/"+shiftAmountCipheredText).then(function(response) {
	    	defer.resolve(response.data);
		});
	    return defer.promise;
	}
});

services.service('vigenereService', function($http, $q) {
	
	this.getEncryptedTextFromVigenereCipher = function(vigenerePlainText, keyPlainText) {
		
		var defer = $q.defer();
		$http.get("http://localhost:8080/cryptoanalysis/api/messages/vigenere/encryption/"+ vigenerePlainText +"/"+keyPlainText).then(function(response) {
	    	defer.resolve(response.data);
		});
	    return defer.promise;
	}
	
	this.getDecryptedTextFromVigenereCipher = function(vigenereCipheredText, keyCipheredText) {
		
		var defer = $q.defer();
		$http.get("http://localhost:8080/cryptoanalysis/api/messages/vigenere/decryption/"+ vigenereCipheredText +"/"+keyCipheredText).then(function(response) {
	    	defer.resolve(response.data);
		});
	    return defer.promise;
	}
	
});

services.service('oneTimePaddingService', function($http, $q) {
	
	this.getEncryptedTextFromOneTimePadding = function(oneTimePaddingPlainText, keyPlainText) {
		
		var defer = $q.defer();
		$http.get("http://localhost:8080/cryptoanalysis/api/messages/onetimepadding/encryption/"+ oneTimePaddingPlainText +"/"+keyPlainText).then(function(response) {
	    	defer.resolve(response.data);
		});
	    return defer.promise;
	}
	
	this.getDecryptedTextFromOneTimePadding = function(oneTimePaddingCipheredText, keyCipheredText) {
		
		var defer = $q.defer();
		$http.get("http://localhost:8080/cryptoanalysis/api/messages/onetimepadding/decryption/"+ oneTimePaddingCipheredText +"/"+keyCipheredText).then(function(response) {
	    	defer.resolve(response.data);
		});
	    return defer.promise;
	}
});


services.service('desService', function($http, $q) {
	
	this.getEncryptedTextFromDes = function(desPlainText) {
		
		var defer = $q.defer();
		$http.get("http://localhost:8080/cryptoanalysis/api/messages/des/encryption/"+desPlainText).then(function(response) {
	    	defer.resolve(response.data);
		});
	    return defer.promise;
	} 
	
});

services.service('aesService', function($http, $q) {
	
   this.getEncryptedTextFromAes = function(aesPlainText, keyPlainText) {
	
	   var defer = $q.defer();
		$http.get("http://localhost:8080/cryptoanalysis/api/messages/aes/encryption/"+aesPlainText + "/" + keyPlainText).then(function(response) {
	    	defer.resolve(response.data);
		});
	    return defer.promise;
	} 
   
   this.getDecryptedTextFromAes = function(aesCipheredText, keyCipheredText) {
		
		var defer = $q.defer();
		$http.get("http://localhost:8080/cryptoanalysis/api/messages/aes/decryption/"+aesCipheredText + "/" + keyCipheredText).then(function(response) {
	    	defer.resolve(response.data);
		});
	    return defer.promise;
	} 
	
});

