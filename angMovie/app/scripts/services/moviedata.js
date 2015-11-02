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
    $http({
      method: 'POST',
      url: 'http://localhost:8080/actor?name=leonardo dicaprio'
    }).then(function successCallback(response) {
      console.log(response);
    }, function errorCallback(response) {
      console.log(response);
    });

    // Public API here
    return {
      someMethod: function() {
        return response;
      }
    };
  });