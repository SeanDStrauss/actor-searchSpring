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
  	}

  	$scope.$watch(function(){return movieData.getMovieByActor();}, function(newVal, oldVal) {
		if (typeof newVal !== 'undefined') {
        $scope.movieInfo = newVal.data;
        var movieArray = $scope.movieInfo;
        //console.log(movieArray);
        

        for(var key in movieArray) {
        	$scope.movieList += movieArray[key]
        }
       
       }})




  });
