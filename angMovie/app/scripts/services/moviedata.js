'use strict';

/**
 * @ngdoc service
 * @name angMovieApp.movieData
 * @description
 * # movieData
 * Factory in the angMovieApp.
 */
angular.module('angMovieApp')
  .factory('movieData', function($http) {
    var movieData = {};
    function searchByActor(name) {
    $http({
      method: 'GET',
      url: 'http://localhost:8080/actor?name=' + name
    }).then(function successCallback(response) {
      movieData = response;
      console.log(movieData);
      //console.log(data);
    }, function errorCallback(response) {
      
    });
  }

    // Public API here
    return {
      getMovieByActor: function() {
        return movieData;
      },
      searchByActor: searchByActor
    };
  });