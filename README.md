# Cryptographic Analysis, Backend and Frontend Project

This application contains different cipher techniques, users can decrypt and encrypt their texts with this web-based application.

## Technologies
* Backend: Java, RestAPI, Jersey
* Frontend: Angular JS, HTML-5, CSS-3
* Package Management: Npm, Bower
* Test: Junit Test, Karma, Jasmine
* Build Automation Tool: Maven

## How to install
* This is a maven project, therefore you should install maven if you do not have. (Eclipse-Neon EE contains maven plugin.)
* Clone the project from this github page
* Import the project into your Eclipse as maven project.
* Then, right click on the project and run the project as "maven build".
* Then, run the project as "maven test", if you want to see test results.
* Then, run the project on Server (Tomcat 8)
* At the end, you could see the web interface with this url. (http://localhost:8080/cryptoanalysis/#!/)

## How to install and test with Karma
* Firstly you should install Npm
* Then, you should install karma and phantomjs, you can install with the command: npm install karma-cli phantomjs -g
* Then, you should install jasmine, you can install with the command: npm install karma jasmine --save-dev
* Then, you can go to src/main/webapp/test and run the command: karma start karma.conf.js
* Finally, You will see the result of the tests.

![The Design](/crypto_analysis.png)
