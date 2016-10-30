window.onload = function(){
	document.querySelector('#inserir').addEventListener('click', function(e){ ExibirCamposEspecificos(e.target.id) });
	document.querySelector('#editar').addEventListener('click', function(e){ ExibirCamposEspecificos(e.target.id) });
	document.querySelector('#produzir').addEventListener('click', function(e){ ExibirCamposEspecificos(e.target.id) });
	document.querySelector('#inserirAlternativa-inserir').addEventListener('click', Inserir);
	document.querySelector('#excluirAlternativa-inserir').addEventListener('click', ExcluirAlternativas);
	document.querySelector('#limparAlternativa-inserir').addEventListener('click', LimparAlternativas);
	document.querySelector('#estilo-inserir').addEventListener('mouseout', Alternativa);
}

let contadorAlternativas = 0;

function ExibirCamposEspecificos(idBotao){
	let inserirQuestoes = document.querySelector('#inserir_questoes'),
		editarQuestoes = document.querySelector('#editar_questoes'),
		produzirProva = document.querySelector('#produzir_prova');


	switch(idBotao){
		case 'inserir':
			inserirQuestoes.className = 'mostrar';
			editarQuestoes.className = 'esconder';
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

function Inserir(){
	if(contadorAlternativas<=4){
		let div = document.createElement('div'), 
			div2 = document.createElement('div'),
			textArea = document.createElement('textArea'),
			label = document.createElement('label');
			
		div.classList.add('row');
		div2.classList.add('col');
		div2.classList.add('s12');

		div.appendChild(div2);

		div = document.createElement('div');
		textArea = document.createElement('textarea');

		div.classList.add('row');
		textArea.classList.add('materialize-textarea');

		textArea.setAttribute('id','alt' + contadorAlternativas);
		textArea.setAttribute('name','alternativa' + contadorAlternativas);
		
		label.innerHTML = "Alternativa: " + (contadorAlternativas + 1);
		label.setAttribute('for', 'alt' + contadorAlternativas)

		div.appendChild(label);				
		div.appendChild(textArea);
		div2.appendChild(div);
		document.querySelector('#alternativas-inserir').appendChild(div2);

		let cBoxDiv = document.createElement('div')
		let cBox = document.createElement('input');
		let cBoxLabel = document.createElement('label');
		
		cBoxDiv.appendChild(cBox);
		cBoxDiv.appendChild(cBoxLabel);
		div.appendChild(cBoxDiv);
		
		cBox.setAttribute('id','cBox' + contadorAlternativas);
		cBox.setAttribute('name','cBox' + contadorAlternativas);
		cBox.setAttribute('type', 'checkbox');
		cBox.setAttribute('class', 'filled-in');
		cBox.classList.add('checkboxes');
		if(document.querySelector('#estilo-inserir').value==0){
			document.querySelector('#adicionar_excluir-inserir').className = 'mostrar';
			document.querySelector('#alternativas-inserir').className = 'mostrar';
			cBoxDiv.classList.add('checkboxesIns');
			cBoxDiv.classList.add('esconder');
		}
		else if(document.querySelector('#estilo-inserir').value==1){
			document.querySelector('#adicionar_excluir-inserir').className = 'mostrar';
			document.querySelector('#alternativas-inserir').className = 'mostrar';
			cBoxDiv.classList.add('checkboxesIns');
			cBoxDiv.classList.add('mostrar');
		}

		
		cBoxLabel.innerHTML = "Verdadeiro";
		cBoxLabel.setAttribute('for', 'cBox' + contadorAlternativas);
		
		div.appendChild(document.createElement('br'));
		div.appendChild(document.createElement('br'));
	}
	
	contadorAlternativas++;
}

function Alternativa(){
	let checkboxes = document.querySelectorAll('.checkboxesIns');
			
	if(document.querySelector('#estilo-inserir').value=="" || document.querySelector('#estilo-inserir').value==2){
		document.querySelector('#adicionar_excluir-inserir').className = 'esconder';
		document.querySelector('#alternativas-inserir').className = 'esconder';
		document.querySelector('#gabarito-inserir').closest('.input-field').classList.remove('mostrar');
		document.querySelector('#gabarito-inserir').closest('.input-field').classList.add('esconder');
	}
	else if(document.querySelector('#estilo-inserir').value==0){
		document.querySelector('#adicionar_excluir-inserir').className = 'mostrar';
		document.querySelector('#alternativas-inserir').className = 'mostrar';
		for(let cbox of checkboxes){
			cbox.classList.remove('mostrar');
			cbox.classList.add('esconder')
		}
		document.querySelector('#gabarito-inserir').closest('.input-field').classList.remove('esconder');
		document.querySelector('#gabarito-inserir').closest('.input-field').classList.add('mostrar');
	}
	else if(document.querySelector('#estilo-inserir').value==1){
		document.querySelector('#adicionar_excluir-inserir').className = 'mostrar';
		document.querySelector('#alternativas-inserir').className = 'mostrar';
		for(let cbox of checkboxes){
			cbox.classList.remove('esconder');
			cbox.classList.add('mostrar')
		}
		document.querySelector('#gabarito-inserir').closest('.input-field').classList.remove('esconder');
		document.querySelector('#gabarito-inserir').closest('.input-field').classList.add('mostrar');
	}
}

function LimparAlternativas(){
	let div = document.querySelector('#alternativas-inserir');
	while(div.firstChild){
		div.removeChild(div.firstChild);
	}
	contadorAlternativas=0;
}

function ExcluirAlternativas(){
	let div = document.querySelector('#alternativas-inserir');
	if(div.firstChild){
		div.removeChild(div.lastChild);
	}
	contadorAlternativas--;
}
