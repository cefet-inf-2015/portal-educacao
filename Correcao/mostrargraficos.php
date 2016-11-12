<!DOCTYPE html>
<html>
  <head>
    <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    	var data = <?php echo json_encode("42", JSON_HEX_TAG); ?>;
		show.innerHTML = JSON.stringify(data);

		google.charts.load('current', {'packages':['bar']});
		// Set a callback to run when the Google Visualization API is loaded.
		google.charts.setOnLoadCallback(drawChart);
		// Callback that creates and populates a data table,
		// instantiates the pie chart, passes in the data and
		// draws it.
		function drawChart() {
		// Create the data table.
		var data = google.visualization.arrayToDataTable([
		  /*["Aluno", "Nota"],
		  ["Copper", 8.9],
		  ["Silver", 10.49],
		  ["Gold", 19.30],
		  ["Platinum", 21.45]*/
		]);
		// Set chart options
		var options = {
		  chart: {
		    title: 'Desempenho dos alunos',
		    subtitle: 'Notas na prova',
		  },
		  bars: 'horizontal' // Required for Material Bar Charts.
		};
		// Instantiate and draw our chart, passing in some options.
		var chart = new google.charts.Bar(document.getElementById('barchart_material'));
		chart.draw(data, options);
		}
    </script>
  </head>

  <body>
    <!--Div that will hold the pie chart-->
    <div id="barchart_material"></div>
    <div id="show"></div>
  </body>
</html>