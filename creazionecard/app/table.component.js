angular.module("table")
.component("mytable",{
	templateUrl:"app/table.template.html",
	controller : function tableController($scope){
		$scope.types= [
			"",
			"card1", 
			"card2", 
			"card3",
			"card4",
			"card5",
			"card6",
			"card7",
			"card8",
			"card9",
			"card10",
			];

		$scope.hours = [
			"mattina",
			"tardamattinata",
			"pranzo",
			"primopomeriggio",
			"pomeriggio",
			"sera",
			"notte",
			];

		$scope.behaviour=[ //scope fa vedere in html
			"gohome",
			"goschool",
			"gowork",
			"gomarket",
			"gohospital",
			"gorandom",
			"stay",
			];



	}
});