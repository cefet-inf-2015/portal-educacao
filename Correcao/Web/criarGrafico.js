google.charts.load('current', {'packages':['bar']});
google.charts.setOnLoadCallback(drawChart);
function drawChart() {
	var data = new google.visualization.DataTable();
	data.addColumn('string', 'Nome do aluno');
	data.addColumn('number', 'Nota');
	data.addRows(nomes.length);
	for (i=0; i<nomes.length; i++){
		data.setCell(i, 0, String(nomes[i]));
		data.setCell(i, 1, Number(notas[i]));
	}
	var options = {
  	chart: {
    	title: 'Notas da turma',
    	subtitle: 'Performance da turma na prova.',
  	},
  	bars: 'horizontal' // Required for Material Bar Charts.
	};
	var chart = new google.charts.Bar(document.querySelector('#barchart_material'));
	chart.draw(data, options);
}