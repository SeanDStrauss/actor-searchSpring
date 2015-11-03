'use strict';

/**
 * @ngdoc overview
 * @name angMovieApp
 * @description
 * # angMovieApp
 *
 * Main module of the application.
 */
angular
  .module('angMovieApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
