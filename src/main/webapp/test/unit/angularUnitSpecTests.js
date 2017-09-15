describe('Testing AngularJS Test Suite', function() {
	
	beforeEach(module('cryptoApp'));

	// Unit test for Main controller.
	describe('Testing AngularJS Main Controller', function() {
		
		beforeEach(inject(function($controller, $rootScope){
			scope = $rootScope.$new();
			ctrl = $controller('MainCtrl', {$scope:scope})
		}));
	
	});
	
	// Unit test for Ceasar cipher UI.
	describe('Testing AngularJS Ceasar Controller', function() {
		
		beforeEach(inject(function($controller, $rootScope){
			scope = $rootScope.$new();
			ctrl = $controller('CaesarCtrl', {$scope:scope})
		}));
		
		it('Should clear input and result texts of Ceasar encryption part', function() {
			scope.clearEncryptionCeasarCipher();
			expect(scope.ceasarPlainText.length).toBe(0);
			expect(scope.shiftAmountPlainText.length).toBe(0);
			expect(scope.encryptedText.length).toBe(0);
		});
		
		it('Should clear input and result texts of Ceasar decryption part', function() {
			scope.clearDecryptionCeasarCipher();
			expect(scope.shiftAmountCipheredText.length).toBe(0);
			expect(scope.ceasarCipheredText.length).toBe(0);
			expect(scope.decryptedText.length).toBe(0);
		});
	});
	
	// Unit test for Vigenere cipher UI.
	describe('Testing AngularJS Vigenere Controller', function() {
		
		beforeEach(inject(function($controller, $rootScope){
			scope = $rootScope.$new();
			ctrl = $controller('VigenereCtrl', {$scope:scope})
		}));
		
		it('Should clear input and result texts of Vigenere encryption part', function() {
			scope.clearEncryptionVigenereCipher();
			expect(scope.vigenerePlainText.length).toBe(0);
			expect(scope.keyPlainText.length).toBe(0);
			expect(scope.encryptedText.length).toBe(0);
		});
		
		it('Should clear input and result texts of Vigenere decryption part', function() {
			scope.clearDecryptionVigenereCipher();
			expect(scope.vigenereCipheredText.length).toBe(0);
			expect(scope.keyCipheredText.length).toBe(0);
			expect(scope.decryptedText.length).toBe(0);
		});
	});
	
	// Unit test for One Time Padding UI.
	describe('Testing AngularJS One Time Padding Controller', function() {
		
		beforeEach(inject(function($controller, $rootScope){
			scope = $rootScope.$new();
			ctrl = $controller('OneTimePaddingCtrl', {$scope:scope})
		}));
		
		it('Should clear input and result texts of One Time Padding encryption part', function() {
			scope.clearEncryptionOneTimePadding();
			expect(scope.oneTimePaddingPlainText.length).toBe(0);
			expect(scope.keyPlainText.length).toBe(0);
			expect(scope.encryptedText.length).toBe(0);
		});
		
		it('Should clear input and result texts of One Time Padding decryption part', function() {
			scope.clearDecryptionOneTimePadding();
			expect(scope.oneTimePaddingCipheredText.length).toBe(0);
			expect(scope.keyCipheredText.length).toBe(0);
			expect(scope.decryptedText.length).toBe(0);
		});
	});
	
	// Unit test for DES.
	describe('Testing AngularJS DES', function() {
		
		beforeEach(inject(function($controller, $rootScope){
			scope = $rootScope.$new();
			ctrl = $controller('DesCtrl', {$scope:scope})
		}));
		
		it('Should clear input and result texts of Des encryption part', function() {
			scope.clearEncryptionDes();
			expect(scope.desPlainText.length).toBe(0);
			expect(scope.encryptedText.length).toBe(0);
		});
	});
	
	// Unit test for AES.
	describe('Testing AngularJS AES', function() {
		
		beforeEach(inject(function($controller, $rootScope){
			scope = $rootScope.$new();
			ctrl = $controller('AesCtrl', {$scope:scope})
		}));
		
		it('Should clear input and result texts of Aes encryption part', function() {
			scope.clearEncryptionAes();
			expect(scope.aesPlainText.length).toBe(0);
			expect(scope.keyPlainText.length).toBe(0);
			expect(scope.encryptedText.length).toBe(0);
		});
		
		it('Should clear input and result texts of Aes decryption part', function() {
			scope.clearDecryptionAes();
			expect(scope.aesCipheredText.length).toBe(0);
			expect(scope.keyCipheredText.length).toBe(0);
			expect(scope.decryptedText.length).toBe(0);
		});
	});
	
});