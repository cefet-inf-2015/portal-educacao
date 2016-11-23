//Date globlal
var gDate;

//Mostra o primeiro elemento passado enquanto oculta o segundo.
//O terceiro elemento define até onde será feito o scroll da página
function mostra(aparece,oculta,rola) {
	let aux = document.querySelector('#'+aparece);
	aux.style.display = "flex";
	aux = document.querySelector('#'+oculta);
	aux.style.display = "none";
	scroll(rola);
}

//Faz a página realizar o Scroll
function scroll(rola) {
	let target_offset = $("#" + rola).offset();
  let target_top = target_offset.top;
  $('html, body').animate({ scrollTop: target_top }, 0);
}

//Utiliza Ajax para receber dados do Servidor
//Preenche o Calendário com os eventos
function atividades(linha, mes, ano, dsemana) {
	$(function () {
		$.ajax({                                      
      url: 'php/load.php', //Arquivo a ser chamado no servidor    
      data: { //Dados a serem enviados ao servidor
    		mes: mes,
    		ano: ano,
    		linha: linha
			},
      dataType: 'json', //Forma a se receber os dados                 
      //Caso receba dados com sucesso realiza a funcao
      //data contêm os dados recebidos
      success: function(data) { 
	      if(data!=null) {	
	      	if(data.ano == ano && data.mes == mes)	{
	      		let aux = parseInt(data.dia) + parseInt(dsemana);
	      		let divDia = document.querySelector("[id='"+String(aux)+"']");
		      	//Não deixa mostrar mais que 6 linhas na div
		      	let str = divDia.innerHTML;
		      	str = str.split("<br>");
		      	if(str.length < 7) {	
		      		let atividade = data.atividade;
		      		//Não deixa mostra mais que 11 caracteres na div
		      		if(atividade.length>11) {
		      			atividade = atividade.substr(0,11);
		      			divDia.innerHTML += "<br>" + atividade + "...";	
		      		}
		      		else {
		      			divDia.innerHTML += "<br>" + atividade;
		      		}
		      	}	
	      	
	      		atividades(++linha, mes, ano, dsemana);			
	      	}
	      }
      } 
    });
  });
}

//Mostra o Calendário básico sem as atividades
function calendario(d) {	
	d.setDate(1); //Define a data para o primeiro dia do mês
	let dsemana = (d.getDay()+1); //Guarda o dia da semana em que o mês começa
	//Define o mês na div dentro do HTML
	let aux = document.querySelector('#mes');
	switch (d.getMonth()) {
		case 0:
			aux.innerHTML = "Janeiro";
			break;
		case 1:
			aux.innerHTML = "Fevereiro";
			break;
		case 2:
			aux.innerHTML = "Março";
			break;
		case 3:
			aux.innerHTML = "Abril";
			break;
		case 4:
			aux.innerHTML = "Maio";
			break;
		case 5:
			aux.innerHTML = "Junho";
			break;
		case 6:
			aux.innerHTML = "Julho";
			break;
		case 7:
			aux.innerHTML = "Agosto";
			break;
		case 8:
			aux.innerHTML = "Setembro";
			break;
		case 9:
			aux.innerHTML = "Outubro";
			break;
		case 10:
			aux.innerHTML = "Novembro";
			break;
		case 11:
			aux.innerHTML = "Dezembro";
			break;
	}
	
	//Esvazia o calendário
	for(x=1; x<=42; x++) {
		let divDia = document.querySelector("[id='"+String(x)+"']");
		divDia.innerHTML = " ";
	}	

	//Limpa as cores do calendário
	let divDia = document.querySelectorAll("div.dia");
	for(x=0; x<42; x++) {
		let auxDia = divDia.item(x);
		auxDia = auxDia.classList;
		auxDia.remove('grey');
		auxDia.remove('lighten-2');
	}

	//Colore os dias anteriores
	let colDia = 0;
	for(x=1; x<dsemana; x++) {
		let auxDia = divDia.item(colDia);
		auxDia = auxDia.classList;
		auxDia.add('grey');
		auxDia.add('lighten-2');
		colDia+=6;	
	}

	//Pega o último dia do mês
	d.setMonth(d.getMonth()+1);
	d.setDate(0); //Define a data como o último dia do mês anterior
	let dfinal = d.getDate(); //Guarda a data

	//Preenche o calendário com os dias
	let auxd = 1;
	while(auxd<=dfinal) {
		let divDia = document.querySelector("[id='"+String(dsemana)+"']");
		divDia.innerHTML = auxd + "<br>";
		auxd++;
		dsemana++;		
	}

	//Colore os dias posteriores
	colDia = 41;
	for(x=dsemana; x<=42; x++) {
		let auxDia = divDia.item(colDia);
		auxDia = auxDia.classList;
		auxDia.add('grey');
		auxDia.add('lighten-2');
		colDia-=6;
		if(colDia==-1)
			colDia=40;
	}
	//Retorna a data para o primeiro dia do mês
	d.setDate(1);
}

//Monta o Calendário completo
function carrega(d) {
	//Salva a última data imposta
	gDate = d;
	calendario(d);
	atividades(1,(d.getMonth()+1),d.getFullYear(), d.getDay());
}

//Trabalha com a Data inserida e transfere como um Date para a função Calendário
function dataShow() {
	let ok = document.querySelector('#ok').classList;
	let mensagem = document.querySelector('#mensagem');
	let data = document.querySelector('#data');
	let preData = data.value.split('/');
	let mes = (parseInt(preData[0])-1);
	
	if(mes<0 || mes>11 || data.value == "") {
		mensagem.style.display = "block";
		ok.remove('blue');
		ok.add('red');
		carrega(new Date());
	}
	else {
		mensagem.style.display = "none";
		ok.remove('red');
		ok.add('blue');
		let d = new Date(preData[1], mes,1);
		carrega(d);
	}
}

//Filtra as atividades mostradas
function filtro() {
	//Recupera o valor da última data salva
	let d = gDate;
	//Parâmetros para filtragem
	let atv = document.querySelector("[id=fAtividade]");
	let mat = document.querySelector("[id=fMateria]");
	//Verifica se foi passado parâmetros
	let mensagem = document.querySelector('#fMensagem');
	let botao = document.querySelector('#filtrar').classList;
	if(atv.value=="" && mat.value=="") {
		mensagem.style.display = "block";
		botao.remove('blue');
		botao.add('red');
		scroll('fMensagem');
		carrega(d);
	}
	else {
		mensagem.style.display = "none";
		botao.remove('red');
		botao.add('blue');
		//Limpa o calendário
		calendario(d);
		//Organiza a data
		mes = gDate.getMonth()+1;
		ano = gDate.getFullYear();
		dsemana = gDate.getDay();
		//Exibe as atividades já filtradas
		fAtividade(1,mes,ano,dsemana,atv.value,mat.value);
	}
}

//Consulta no servidor os dados com filtro
function fAtividade(linha, mes, ano, dsemana, atv, mat) {
	$(function () {
		$.ajax({                                      
      url: 'php/load.php', //Arquivo a ser chamado no servidor    
      data: { //Dados a serem enviados ao servidor
    		mes: mes,
    		ano: ano,
    		linha: linha
			},
      dataType: 'json', //Forma a se receber os dados                 
      //Caso receba dados com sucesso realiza a funcao
      //data contêm os dados recebidos
      success: function(data) { 
	    	//Filtragem usando apenas o parâmetro atividade
		    if(data!=null) {	
		    	if(atv!="") {	
				    if(data.ano == ano && data.mes == mes && data.atividade == atv)	{
			      	let aux = parseInt(data.dia) + parseInt(dsemana);
			      	let divDia = document.querySelector("[id='"+String(aux)+"']");
				      //Não deixa mostrar mais que 6 linhas na div
				      let str = divDia.innerHTML;
				      str = str.split("<br>");
				      if(str.length < 7) {	
				      	let atividade = data.atividade;
				      	//Não deixa mostra mais que 11 caracteres na div
				      	if(atividade.length>11) {
				      		atividade = atividade.substr(0,11);
				      		divDia.innerHTML += "<br>" + atividade + "...";	
				      	}
				      	else {
				      		divDia.innerHTML += "<br>" + atividade;
				      	}
				      }	
			      	fAtividade(++linha, mes, ano, dsemana, atv, mat);			
			      }
		      }
	      	else {
			      //Filtragem usando o parâmetro materia
			      if(data.ano == ano && data.mes == mes && data.materia == mat) {
			      	let aux = parseInt(data.dia) + parseInt(dsemana);
			      		let divDia = document.querySelector("[id='"+String(aux)+"']");
				      	//Não deixa mostrar mais que 6 linhas na div
				      	let str = divDia.innerHTML;
				      	str = str.split("<br>");
				      	if(str.length < 7) {	
				      		let atividade = data.atividade;
				      		//Não deixa mostra mais que 11 caracteres na div
				      		if(atividade.length>11) {
				      			atividade = atividade.substr(0,11);
				      			divDia.innerHTML += "<br>" + atividade + "...";	
				      		}
				      		else {
				      			divDia.innerHTML += "<br>" + atividade;
				      		}
				      	}	
			      	fAtividade(++linha, mes, ano, dsemana, atv, mat);			
			      }
		      }
		      fAtividade(++linha, mes, ano, dsemana, atv, mat);
		    }  
	    }	 
    });
  });
}

//Valida os campos de inserção
function validar(frm) {
	let mensagem = document.querySelector('#mensagem2');
	let botao = document.querySelector('#inserir').classList;
	let data = document.querySelector('#dataForm');
	let preData = data.value.split('/');
	let dia = parseInt(preData[2]);
	let mes = parseInt(preData[1]);

	if(frm.atividade.value == "" || frm.dataForm.value == "" || frm.materia.value == "" 
		|| mes<1 || mes>12 || dia<1 || dia>31) {
		mensagem.style.display = "block";
		botao.remove('blue');
		botao.add('red');
		scroll('mensagem2');
		return false;
	}
	else {
		mensagem.style.display = "none";
		botao.remove('red');
		botao.add('blue');	
	}	
	frm.submit();
}

//Preenche os Models com as atividades
function preenche(div) {
	div = document.querySelector("[id='"+String(div)+"']");
	let dia = div.innerHTML.split("<");
	dia = dia[0];
	let mes = (gDate.getMonth()+1);
	let ano = gDate.getFullYear();
	//Limpa o model
	let box = document.querySelector('#mAtividades');	
  	box.innerHTML = "";
	completoAtividades(1, dia, mes,ano);
}

//Retorna as atividades completas do servidor
function completoAtividades(linha, dia, mes, ano) {	
	$(function () {
		$.ajax({                                      
      url: 'php/load.php', //Arquivo a ser chamado no servidor    
      data: { //Dados a serem enviados ao servidor
    		mes: mes,
    		ano: ano,
    		linha: linha
			},
      dataType: 'json', //Forma a se receber os dados                 
      //Caso receba dados com sucesso realiza a funcao
      //data contêm os dados recebidos
      success: function(data) { 
	      if(data!=null) {	
	      	if(data.ano == ano && data.mes == mes && data.dia == dia)	{
	      		let box = document.querySelector('#mAtividades');	
	      		box.innerHTML += "<b>Atividade:</b> " + data.atividade + "<br>";
	      		box.innerHTML += "<b>Descrição: </b>" + data.descricao + "<br>";
	      		box.innerHTML += "<b>Matéria: </b>" + data.materia + "&nbsp&nbsp&nbsp&"
	      		+ "nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp";
	      		if(data.hora!="00:00:00")
	      			box.innerHTML += "<b>Hora: </b>" + data.hora + "\n\n"; 
	      		completoAtividades(++linha, dia, mes, ano);	
	      		box.innerHTML += "<br>________________________________________________"
	      		+ "_______________________________________________________________" +
	      		"____________________________________<br><br>";		
	      	}
	      	else {
	      		if(data!=null)
	      			completoAtividades(++linha, dia, mes, ano);
	      	}
	     	}	
      } 
    });
  });
}


