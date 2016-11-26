//Setando funções aos listeners
window.onload = function(){
	document.querySelector('#inserir').addEventListener('click', function(e){ ExibirCamposEspecificos(e.target.id) });
	document.querySelector('#editar').addEventListener('click', function(e){ ExibirCamposEspecificos(e.target.id) });
	document.querySelector('#produzir').addEventListener('click', function(e){ ExibirCamposEspecificos(e.target.id) });
	document.querySelector('#inserirAlternativa-inserir').addEventListener('click', Inserir);
	document.querySelector('#excluirAlternativa-inserir').addEventListener('click', ExcluirAlternativas);
	document.querySelector('#limparAlternativa-inserir').addEventListener('click', LimparAlternativas);
	document.querySelector('#estilo-inserir').addEventListener('mouseout', Alternativa);
	document.querySelector('#estilo-inserir').addEventListener('blur', Alternativa);
	
	Alternativa();
}

//variavel para controlar o numero de alternativas que serao exibidas nas questoes de V ou F e multipla escolha.
let contadorAlternativas = 0;

//ExibirCamposEspecificos(idBotao) mostra apenas os campos associados ao botao selecionado (INSERIR QUESTOES, EDITAR QUESTOES ou PRODUZIR PROVA).
function ExibirCamposEspecificos(idBotao){
	let inserirQuestoes = document.querySelector('#inserir_questoes'),
		editarQuestoes = document.querySelector('#editar_questoes'),
		produzirProva = document.querySelector('#produzir_prova');


	switch(idBotao){
		case 'inserir':
			inserirQuestoes.className = 'mostrar'; //A classe 'mostrar' foi criada no CSS e tem como objetivo exibir o elemento da tela (display:'block').
			editarQuestoes.className = 'esconder'; //A classe 'esconder' tambem foi criada no CSS e tem funcionamento contrario a 'mostrar' (display:'none').
			produzirProva.className = 'esconder';
			break;

		case 'editar':
			inserirQuestoes.className = 'esconder';
			editarQuestoes.className = 'mostrar';
			produzirProva.className = 'esconder';
			break;

		case 'produzir':
			inserirQuestoes.className = 'esconder';
			editarQuestoes.className = 'esconder';
			produzirProva.className = 'mostrar';
			break;
	}

}

//Inserir() cria uma textArea para que o usuario possa digitar o enunciado de uma alternativa em questoes VF ou ME.
function Inserir(){
	if(contadorAlternativas<=4){
		let div = document.createElement('div'), 
			div2 = document.createElement('div'),
			textArea = document.createElement('textArea'),
			label = document.createElement('label');
			
		let cBoxExcluirDiv = document.createElement('div'),
		   cBoxExcluir = document.createElement('input'),
		   cBoxExcluirLabel = document.createElement('label');	
			
		div.classList.add('row');
		div2.classList.add('col');
		div2.classList.add('s12');
		div2.classList.add('alternativa');

		div.appendChild(div2);

		div = document.createElement('div');
		textArea = document.createElement('textarea');

		div.classList.add('row');
		textArea.classList.add('materialize-textarea');

		textArea.setAttribute('id','alt' + contadorAlternativas);
		textArea.setAttribute('name','alternativa' + contadorAlternativas);
		
		label.innerHTML = "Alternativa: " + (contadorAlternativas + 1);
		label.setAttribute('for', 'alt' + contadorAlternativas);
		label.classList.add('labelAlt');
		
		cBoxExcluirDiv.appendChild(cBoxExcluir);
		cBoxExcluirDiv.appendChild(cBoxExcluirLabel);
		cBoxExcluirDiv.setAttribute('align', 'right');

		cBoxExcluir.setAttribute('id','cBoxExcluir' + contadorAlternativas);
		cBoxExcluir.setAttribute('name','cBoxExcluir' + contadorAlternativas);
		cBoxExcluir.setAttribute('type', 'checkbox');
		cBoxExcluir.setAttribute('class', 'filled-in');
		cBoxExcluir.setAttribute('align', 'right');
		cBoxExcluir.classList.add('checkboxesExcluir');
		
		cBoxExcluirLabel.innerHTML = " Excluir";
		cBoxExcluirLabel.setAttribute('for', 'cBoxExcluir' + contadorAlternativas);
		cBoxExcluirLabel.classList.add('cBoxExcluirLabel');
		
		div.appendChild(label);			
		div.appendChild(textArea);
		div.appendChild(cBoxExcluirDiv);
		div2.appendChild(div);
		document.querySelector('#alternativas-inserir').appendChild(div2);
		
		//Botoes radio e excluir exclusivos de VF ou ME
		let cBoxDiv = document.createElement('div'),
		    cBox = document.createElement('input'),
		    cBoxLabel = document.createElement('label');
		
		let radioDiv = document.createElement('div'),
		    radio = document.createElement('input'),
		    radioLabel = document.createElement('label');

		cBoxDiv.appendChild(cBox);
		cBoxDiv.appendChild(cBoxLabel);
		div.appendChild(cBoxDiv);
		
		radioDiv.appendChild(radio);
		radioDiv.appendChild(radioLabel);
		div.appendChild(radioDiv);
		
		div.appendChild(cBoxExcluirDiv);
		
		cBox.setAttribute('id','cBox' + contadorAlternativas);
		cBox.setAttribute('name','cBox' + contadorAlternativas);
		cBox.setAttribute('type', 'checkbox');
		cBox.setAttribute('class', 'filled-in');
		cBox.classList.add('checkboxes');
		
		radio.setAttribute('id','rdio' + contadorAlternativas);
		radio.setAttribute('name','rdio');
		radio.setAttribute('type', 'radio');
		radio.setAttribute('value', 'rdio' + contadorAlternativas);
		radio.classList.add('rdios');
		
		if(document.querySelector('#estilo-inserir').value==0){ //Se o usuario selecionar a opcao VF, a textArea sera acompanhada de um checkbox. 
			document.querySelector('#adicionar_excluir-inserir').className = 'mostrar';
			document.querySelector('#alternativas-inserir').className = 'mostrar';
			cBoxDiv.classList.add('checkboxesIns');
			cBoxDiv.classList.add('esconder');
			radioDiv.classList.add('rdiosIns');
			radioDiv.classList.add('mostrar');
		}
		else if(document.querySelector('#estilo-inserir').value==1){ //Se o usuario selecionar a opcao ME, a texta Area sera acompanhada de um radio.
			document.querySelector('#adicionar_excluir-inserir').className = 'mostrar';
			document.querySelector('#alternativas-inserir').className = 'mostrar';
			cBoxDiv.classList.add('checkboxesIns');
			cBoxDiv.classList.add('mostrar');
			radioDiv.classList.add('rdiosIns');
			radioDiv.classList.add('esconder');
		} //O uso de checkbox ou radio serve para que o usuario escolha a opcao correta entre as alternativas inseridas, fazendo assim o gabarito da questao.

		
		cBoxLabel.innerHTML = "Verdadeiro";
		cBoxLabel.setAttribute('for', 'cBox' + contadorAlternativas);
		cBoxLabel.classList.add('cBoxLabel');
		
		radioLabel.innerHTML = "Correto";
		radioLabel.setAttribute('for', 'rdio' + contadorAlternativas);
		radioLabel.classList.add('radioLabel');
		
		div.appendChild(document.createElement('br'));
		div.appendChild(document.createElement('br'));
	}
	
	contadorAlternativas++;
}

//Alternativa() mostra na tela os campos que serao preenchidos pelo usuario com o objetivo de formar alternativas para as questoes.
function Alternativa(){
	let checkboxes = document.querySelectorAll('.checkboxesIns'),
	    radios = document.querySelectorAll('.rdiosIns');
			
	if(document.querySelector('#estilo-inserir').value=="" || document.querySelector('#estilo-inserir').value==2){
		document.querySelector('#adicionar_excluir-inserir').className = 'esconder';
		document.querySelector('#alternativas-inserir').className = 'esconder';
	}
	else if(document.querySelector('#estilo-inserir').value==0){
		document.querySelector('#adicionar_excluir-inserir').className = 'mostrar';
		document.querySelector('#alternativas-inserir').className = 'mostrar';
		for(let cbox of checkboxes){
			cbox.classList.remove('mostrar');
			cbox.classList.add('esconder')
		}
		for(let rdio of radios){
			rdio.classList.remove('esconder');
			rdio.classList.add('mostrar')
		}
	}
	else if(document.querySelector('#estilo-inserir').value==1){
		document.querySelector('#adicionar_excluir-inserir').className = 'mostrar';
		document.querySelector('#alternativas-inserir').className = 'mostrar';
		for(let cbox of checkboxes){
			cbox.classList.remove('esconder');
			cbox.classList.add('mostrar')
		}
		for(let rdio of radios){
			rdio.classList.remove('mostrar');
			rdio.classList.add('esconder')
		}
	}
}

//LimparAlternativas() apaga todas as alternativas inseridas pelo usuario. 
function LimparAlternativas(){
	let div = document.querySelector('#alternativas-inserir');
	while(div.firstChild){
		div.removeChild(div.firstChild);
	}
	contadorAlternativas=0;
}

//ExcluirAlternativas() exclui a alternativa escolhida pelo usuario.
function ExcluirAlternativas(){
	//Excluindo alternativas
	let cBoxExcluir = document.querySelectorAll('.checkboxesExcluir');
	let div = document.querySelector('#alternativas-inserir');
		
	for(let cbox of cBoxExcluir){
		if(cbox.checked==true){ 
			div.removeChild(cbox.closest('.alternativa'))
			contadorAlternativas--;
		}
	}
	
	//renomeando alternativas para evitar conflitos
	let alternativa = div.querySelectorAll('.alternativa');
	let nAlt = 0;
	for(let alt of alternativa){
		alt.querySelector('.labelAlt').setAttribute('for', 'alt'+nAlt);
		alt.querySelector('.labelAlt').innerHTML = "Alternativa: "+(nAlt+1);
		alt.querySelector('.materialize-textarea').setAttribute('id', 'alt'+nAlt);
		alt.querySelector('.materialize-textarea').setAttribute('name', 'alternativa'+nAlt);
		alt.querySelector('.checkboxes').setAttribute('id', 'cBox'+nAlt);
		alt.querySelector('.checkboxes').setAttribute('name', 'cBox'+nAlt);
		alt.querySelector('.cBoxLabel').setAttribute('for', 'cBox'+nAlt);
		alt.querySelector('.rdios').setAttribute('id', 'rdio'+nAlt);
		alt.querySelector('.radioLabel').setAttribute('for', 'rdio'+nAlt);
		alt.querySelector('.checkboxesExcluir').setAttribute('id', 'cBoxExcluir'+nAlt);
		alt.querySelector('.checkboxesExcluir').setAttribute('name', 'cBoxExcluir'+nAlt);
		alt.querySelector('.cBoxExcluirLabel').setAttribute('for', 'cBoxExcluir'+nAlt);
		
		
		nAlt++;
	}

}
