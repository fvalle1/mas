angular.module("references",[])
.component("myreferences",{
	templateUrl: "app/references.template.html",
	controller: function(){
		var ctrl=this;
		
		this.campusnetUrl="http://fisica.campusnet.unito.it/do/documenti.pl/Show?_id=npr6";
	}
})
