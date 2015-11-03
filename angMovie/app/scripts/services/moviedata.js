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
    var data = {};
    $http({
      method: 'POST',
      url: 'http://localhost:8080/actor?name=james franco'
    }).then(function successCallback(response) {
      data = response;
      console.log(data);
    }, function errorCallback(response) {
      console.log(response);
    });

    // Public API here
    return {
      getMovieByActor: function() {
        return data;
      }
    };
  });