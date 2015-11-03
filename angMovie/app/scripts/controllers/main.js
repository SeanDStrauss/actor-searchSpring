'use strict';

/**
 * @ngdoc function
 * @name angMovieApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the angMovieApp
 */
angular.module('angMovieApp')
  .controller('MainCtrl', function ($scope, movieData) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    console.log(movieData);

  });
