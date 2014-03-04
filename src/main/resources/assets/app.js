angular.module('app', ['ngRoute'])
.config(function($routeProvider) {
  $routeProvider
    .when('/', {
      controller:'AppCtrl',
      templateUrl:'app.html'
    })
    .otherwise({
      redirectTo:'/'
    });
})
.controller('AppCtrl', function($scope, $http) {
  $scope.exchanges = []
  $http.get('/services/exchanges/available')
    .success(function(data) {
      $scope.exchanges = data;
    });
  $scope.addAlert = function() {
    var data = {
      'phone': $scope.phoneNum,
      'price': $scope.price,
      'direction':$scope.direction
    };
    $http.post('/services/alert/add', data)
  }
});