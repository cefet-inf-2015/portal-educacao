//Este script tem como objetivo manipular as questoes de modo que elas possam ser editadas pelo usuario.
questoes = document.querySelectorAll('.form_alterar'); //Seleciona todas as questoes presentes no formulario destinado a alterar questoes.
qC = 0; //Variavel auxiliar na correcao de um problema na referenciacao de uma questao.

for(let questao of questoes){
	let questaoCounter = qC; //Correcao do problema de referencia.
	
	//Alternativa() mostra na tela os campos que serao preenchidos pelo usuario com o objetivo de formar alternativas para as questoes.
	function Alternativa(){
		let checkboxes = document.querySelectorAll('.checkboxesEdit-'+questaoCounter);
		let radios = document.querySelectorAll('.radioEdit-'+questaoCounter);
				
		if(document.querySelector('#estilo-alterar-'+questaoCounter).value=="" || document.querySelector('#estilo-alterar-'+questaoCounter).value==2){
			document.querySelector('#adicionar_excluir-alterar-'+questaoCounter).className = 'esconder';
			document.querySelector('#alternativas-alterar-'+questaoCounter).className = 'esconder';
		}
		else if(document.querySelector('#estilo-alterar-'+questaoCounter).value==0){
			document.querySelector('#adicionar_excluir-alterar-'+questaoCounter).className = 'mostrar';
			document.querySelector('#alternativas-alterar-'+questaoCounter).className = 'mostrar';
			for(let cbox of checkboxes){
				cbox.classList.remove('mostrar');
				cbox.classList.add('esconder')
			}
			for(let rdio of radios){
				rdio.classList.remove('esconder');
				rdio.classList.add('mostrar')
			}
		}
		else if(document.querySelector('#estilo-alterar-'+questaoCounter).value==1){
			document.querySelector('#adicionar_excluir-alterar-'+questaoCounter).className = 'mostrar';
			document.querySelector('#alternativas-alterar-'+questaoCounter).className = 'mostrar';
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
	
	let contadorAlternativas = document.querySelector('#alternativas-alterar-'+questaoCounter).childNodes.length;
	console.log(contadorAlternativas);
	
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
			div2.classList.add('alternativaEditar')
	
			div.appendChild(div2);
	
			div = document.createElement('div');
			textArea = document.createElement('textarea');
	
			div.classList.add('row');
			textArea.classList.add('materialize-textarea');
	
			textArea.setAttribute('id','altEdit-' + questaoCounter + "-" + contadorAlternativas);
			textArea.setAttribute('name','alternativaEdit-' + questaoCounter + "-" + contadorAlternativas);
			
			label.innerHTML = "Alternativa: " + (contadorAlternativas + 1);
			label.setAttribute('for', 'altEdit-' + questaoCounter + "-" + contadorAlternativas)
			label.classList.add('labelAltEdit');
			
			cBoxExcluirDiv.appendChild(cBoxExcluir);
			cBoxExcluirDiv.appendChild(cBoxExcluirLabel);
			cBoxExcluirDiv.setAttribute('align', 'right');
	
			cBoxExcluir.setAttribute('id','cBoxExcluirEditar-' + questaoCounter + '-' + contadorAlternativas);
			cBoxExcluir.setAttribute('name','cBoxExcluirEditar-' + questaoCounter + '-' + contadorAlternativas);
			cBoxExcluir.setAttribute('type', 'checkbox');
			cBoxExcluir.setAttribute('class', 'filled-in');
			cBoxExcluir.setAttribute('align', 'right');
			cBoxExcluir.classList.add('checkboxesExcluirEditar');
			
			cBoxExcluirLabel.innerHTML = " Excluir";
			cBoxExcluirLabel.setAttribute('for', 'cBoxExcluirEditar-' + questaoCounter + '-' + contadorAlternativas);
			cBoxExcluirLabel.classList.add('cBoxExcluirLabelEditar');
	
			div.appendChild(label);				
			div.appendChild(textArea);
			div.appendChild(cBoxExcluirDiv);
			div2.appendChild(div);
			document.querySelector('#alternativas-alterar-'+questaoCounter).appendChild(div2);
	
			let cBoxDiv = document.createElement('div')
			let cBox = document.createElement('input');
			let cBoxLabel = document.createElement('label');
			
			let radioDiv = document.createElement('div')
			let radio = document.createElement('input');
			let radioLabel = document.createElement('label');
			
			cBoxDiv.appendChild(cBox);
			cBoxDiv.appendChild(cBoxLabel);
			div.appendChild(cBoxDiv);
			
			radioDiv.appendChild(radio);
			radioDiv.appendChild(radioLabel);
			div.appendChild(radioDiv);
			
			div.appendChild(cBoxExcluirDiv);
			
			cBox.setAttribute('id','cBoxEdit-' + questaoCounter + "-" + contadorAlternativas);
			cBox.setAttribute('name','cBoxEdit-' + questaoCounter + "-" + contadorAlternativas);
			cBox.setAttribute('type', 'checkbox');
			cBox.setAttribute('class', 'filled-in');
			cBox.classList.add('checkboxesEditar-'+questaoCounter);
			
			radio.setAttribute('id','rdioEdit-' + questaoCounter + "-" + contadorAlternativas);
			radio.setAttribute('name','rdioEdit-'+questaoCounter);
			radio.setAttribute('type', 'radio');
			radio.setAttribute('value', 'rdioEdit-' + questaoCounter + "-" + contadorAlternativas);
			radio.classList.add('rdiosEdit-'+questaoCounter);
			
			if(document.querySelector('#estilo-alterar-'+questaoCounter).value==0){
				document.querySelector('#adicionar_excluir-alterar-'+questaoCounter).className = 'mostrar';
				document.querySelector('#alternativas-alterar-'+questaoCounter).className = 'mostrar';
				cBoxDiv.classList.add('checkboxesEdit-'+questaoCounter);
				cBoxDiv.classList.add('esconder');
				radioDiv.classList.add('radioEdit-'+questaoCounter);
				radioDiv.classList.add('mostrar');
			}
			else if(document.querySelector('#estilo-alterar-'+questaoCounter).value==1){
				document.querySelector('#adicionar_excluir-alterar-'+questaoCounter).className = 'mostrar';
				document.querySelector('#alternativas-alterar-'+questaoCounter).className = 'mostrar';
				cBoxDiv.classList.add('checkboxesEdit-'+questaoCounter);
				cBoxDiv.classList.add('mostrar');
				radioDiv.classList.add('rdiosEdit-'+questaoCounter);
				radioDiv.classList.add('esconder');
			}
	
			
			cBoxLabel.innerHTML = "Verdadeiro";
			cBoxLabel.setAttribute('for', 'cBoxEdit-' + questaoCounter + "-" + contadorAlternativas);
			cBoxLabel.classList.add('cBoxEditLabel');
			
			radioLabel.innerHTML = "Correto";
			radioLabel.setAttribute('for', 'rdioEdit-' + questaoCounter + "-" + contadorAlternativas);
			radioLabel.classList.add('radioEditLabel');
			radioLabel.classList.add('radioEditLabel');
			
			div.appendChild(document.createElement('br'));
			div.appendChild(document.createElement('br'));
		}
		
		contadorAlternativas++;
	}

	//LimparAlternativas() apaga todas as alternativas inseridas pelo usuario. 
	function LimparAlternativas(){
		let div = document.querySelector('#alternativas-alterar-'+questaoCounter);
		while(div.firstChild){
			div.removeChild(div.firstChild);
		}
		contadorAlternativas=0;
	}
	
	//ExcluirAlternativas() exclui a ultima alternativa inserida pelo usuario.
	function ExcluirAlternativas(){
		//Excluindo alternativas
		let cBoxExcluir = document.querySelectorAll('.checkboxesExcluirEditar');
		let div = document.querySelector('#alternativas-alterar-'+questaoCounter);
			
		for(let cbox of cBoxExcluir){
			if(cbox.checked==true){ 
				div.removeChild(cbox.closest('.alternativaEditar'))
				contadorAlternativas--;
			}
		}
		
		//renomeando alternativas para evitar conflitos
		let alternativa = div.querySelectorAll('.alternativaEditar');
		let nAlt = 0;
		for(let alt of alternativa){
			alt.querySelector('.labelAltEdit').setAttribute('for', 'altEdit-'+questaoCounter+'-'+nAlt);
			alt.querySelector('.labelAltEdit').innerHTML = "Alternativa: "+(nAlt+1);
			alt.querySelector('.materialize-textarea').setAttribute('id', 'altEdit-'+questaoCounter+'-'+nAlt);
			alt.querySelector('.materialize-textarea').setAttribute('name', 'alternativaEdit-'+questaoCounter+'-'+nAlt);
			alt.querySelector('.checkboxesEditar-'+questaoCounter).setAttribute('id', 'cBoxEdit-'+questaoCounter+'-'+nAlt);
			alt.querySelector('.checkboxesEditar-'+questaoCounter).setAttribute('name', 'cBoxEdit-'+questaoCounter+'-'+nAlt);
			alt.querySelector('.cBoxEditLabel').setAttribute('for', 'cBoxEdit-'+questaoCounter+'-'+nAlt);
			alt.querySelector('.rdiosEdit-'+questaoCounter).setAttribute('id', 'rdioEdit-'+questaoCounter+'-'+nAlt);
			alt.querySelector('.rdiosEdit-'+questaoCounter).setAttribute('value', 'rdioEdit-'+questaoCounter+'-'+nAlt);
			alt.querySelector('.radioEditLabel').setAttribute('for', 'rdioEdit-'+questaoCounter+'-'+nAlt);
			alt.querySelector('.checkboxesExcluirEditar').setAttribute('id', 'cBoxExcluirEditar-'+questaoCounter+'-'+nAlt);
			alt.querySelector('.checkboxesExcluirEditar').setAttribute('name', 'cBoxExcluirEditar-'+questaoCounter+'-'+nAlt);
			alt.querySelector('.cBoxExcluirLabelEditar').setAttribute('for', 'cBoxExcluirEditar-'+questaoCounter+'-'+nAlt);
			
			nAlt++;
		}
	}

	function excluirFoto(){
		let foto = questao.querySelector('#excluirFotoEditar-'+questaoCounter).parentNode.parentNode;
		foto.removeChild(questao.querySelector('#excluirFotoEditar-'+questaoCounter).parentNode);
		document.querySelector('#imagemTField-'+questaoCounter).value = '';
		document.querySelector('#excluido-'+questaoCounter).value = true;
		
	}
	
	//Chama as funcoes.
	questao.querySelector('#inserirAlternativa-alterar-'+questaoCounter).addEventListener('click', Inserir);
	questao.querySelector('#limparAlternativa-alterar-'+questaoCounter).addEventListener('click', LimparAlternativas);
	questao.querySelector('#excluirAlternativa-alterar-'+questaoCounter).addEventListener('click', ExcluirAlternativas);
	questao.querySelector('#estilo-alterar-'+questaoCounter).addEventListener('mouseout', Alternativa);
	questao.querySelector('#excluirFotoEditar-'+questaoCounter).addEventListener('click', excluirFoto);
	Alternativa();
	
	qC++;
}	
