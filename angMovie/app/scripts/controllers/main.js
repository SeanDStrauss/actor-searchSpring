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
   $scope.searchByActor = function() {

   }
    console.log(movieData);

  });
