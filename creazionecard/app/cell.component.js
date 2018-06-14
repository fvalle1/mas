angular.module("cell")
.component("mycell",{
	templateUrl:"app/cell.template.html",
	controller: function mycellController($scope){
		var ctrl=this;
	},
	bindings: {
		myCellContent: '<',
	}
}
);
