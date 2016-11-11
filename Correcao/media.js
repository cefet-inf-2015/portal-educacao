$(document).ready(function calcMedia(){
	var soma = Number();
	for (i=0; i<notas.length; i++){
		soma = soma+notas[i];
	}
	var media = soma/notas.length;
	document.querySelector('#media').innerHTML = "Média da nota da turma: " + media;
})