$(document).ready(function calcMedia(){
	var soma = Number();
	for (i=0; i<notas.length; i++){
		soma = soma+notas[i];
	}
	var media = soma/notas.length;
	media = Number((media).toFixed(2));
	document.querySelector('#media').innerHTML = "Média da nota da turma: " + media;
})