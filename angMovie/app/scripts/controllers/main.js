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
 

  	$scope.searchActor =function (){
  		movieData.searchByActor($scope.name);
  		console.log(movieData);
  	}



    

  });
