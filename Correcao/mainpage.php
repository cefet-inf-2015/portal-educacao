<html>
<head>
	
</head>
<body>
	
</body>
</html>
<html>
  <head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script type="text/javascript">
			var nomes = Array();
			var notas = Array();
			$(document).ready(function(){
			var obj = <?php session_start(); echo json_encode($_SESSION['respostasAssociadas']); ?>;
			for (i=0; i<obj.length; i++){
				nomes.push(Object.keys(obj[i]));
				notas.push(obj[i][nomes[i]]);
			}
				
			}) 
    	
		</script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
				alert(nomes[0].type)
        var data = google.visualization.arrayToDataTable([
          ['Aluno', 'Nota'],
          [String(nomes[0]), Number(notas[0])],
          [String(nomes[1]), Number(notas[1])],
          [String(nomes[2]), Number(notas[2])],
          [String(nomes[3]), Number(notas[3])],
					[String(nomes[4]), Number(notas[4])],
					[String(nomes[5]), Number(notas[5])],
        ]);

        var options = {
          chart: {
            title: 'Notas da turma',
            subtitle: 'Performance da turma na prova.',
          },
          bars: 'horizontal' // Required for Material Bar Charts.
        };

        var chart = new google.charts.Bar(document.getElementById('barchart_material'));

        chart.draw(data, options);
      }
    </script>
		<script type="text/javascript">
			function calcMedia(){
				var soma = Number();
		for (i=0; i<notas.length; i++){
			soma = soma+notas[i];
		}
		var media = soma/notas.length;
			alert(media);
				}
		</script>
  </head>
  <body>
    <div id="barchart_material" style="width: 900px; height: 500px;"></div>
		<button type=button onclick="calcMedia()">Calc media</button>
  </body>
</html>