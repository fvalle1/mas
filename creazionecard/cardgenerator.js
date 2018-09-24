doCards=function(){
	let ncards = 4;
	hours = [
		"mattina",
		"tardamattinata",
		"pranzo",
		"primopomeriggio",
		"pomeriggio",
		"sera",
		"notte",
		];
	let output = [];


	for (var i = 1; i <= ncards; i++) {
		let row = [];
		for ( let hour of hours) {
			val = $("#"+hour+"card"+i).val().toString();
			if(val.localeCompare("gohome")==0) row.push(0);
			if(val.localeCompare("goschool")==0) row.push(1);
			if(val.localeCompare("gowork")==0) row.push(2);
			if(val.localeCompare("gomarket")==0) row.push(3);
			if(val.localeCompare("gohospital")==0) row.push(4);
			if(val.localeCompare("gorandom")==0) row.push(5)
			if(val.localeCompare("stay")==0) row.push(6);
		}
		output.push(row);
	}
	exportToCsv("cards.csv", output);
}


function exportToCsv(filename, rows) {
	console.debug(rows);
	var processRow = function (row) {
		var finalVal = '';
		for (var j = 0; j < row.length; j++) {
			var innerValue = row[j] === null ? '' : row[j].toString();
			if (row[j] instanceof Date) {
				innerValue = row[j].toLocaleString();
			};
			var result = innerValue.replace(/"/g, '""');
			if (result.search(/("|,|\n)/g) >= 0)
				result = '"' + result + '"';
			if (j > 0)
				finalVal += ',';
			finalVal += result;
		}
		return finalVal + '\n';
	};

	var csvFile = '';
	for (var i = 0; i < rows.length; i++) {
		csvFile += processRow(rows[i]);
	}

	var blob = new Blob([csvFile], { type: 'text/csv;charset=utf-8;' });
	if (navigator.msSaveBlob) { // IE 10+
		navigator.msSaveBlob(blob, filename);
	} else {
		var link = document.createElement("a");
		if (link.download !== undefined) { // feature detection
			// Browsers that support HTML5 download attribute
			var url = URL.createObjectURL(blob);
			link.setAttribute("href", url);
			link.setAttribute("download", filename);
			link.style.visibility = 'hidden';
			document.body.appendChild(link);
			link.click();
			document.body.removeChild(link);
		}
	}
}