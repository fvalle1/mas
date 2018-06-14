angular.module("lesson")
.component("lesson",{
	templateUrl: "app/lesson.template.html",
	controller: function($scope){
		var ctrl=this;
		
		$scope.show=true;
		
		$scope.onClick=function(){
			$scope.show=!$scope.show;
		}
		
	},
	bindings: {
		title: "="
	}
})