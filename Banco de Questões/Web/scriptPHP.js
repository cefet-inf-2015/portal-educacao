questoes = document.querySelectorAll('.form_alterar');
qC = 0;

for(let questao of questoes){
	let questaoCounter = qC; //corrigindo problema de referencia
	
	function Alternativa(){
		let checkboxes = document.querySelectorAll('.checkboxesEdit-'+questaoCounter);
		let radios = document.querySelectorAll('.rdiosEdit-'+questaoCounter);
				
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
	
			textArea.setAttribute('id','altEdit-' + questaoCounter + "-" + contadorAlternativas);
			textArea.setAttribute('name','alternativaEdit-' + questaoCounter + "-" + contadorAlternativas);
			
			label.innerHTML = "Alternativa: " + (contadorAlternativas + 1);
			label.setAttribute('for', 'altEdit' + questaoCounter + "-" + contadorAlternativas)
	
			div.appendChild(label);				
			div.appendChild(textArea);
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
			
			cBox.setAttribute('id','cBoxEdit-' + questaoCounter + "-" + contadorAlternativas);
			cBox.setAttribute('name','cBoxEdit-' + questaoCounter + "-" + contadorAlternativas);
			cBox.setAttribute('type', 'checkbox');
			cBox.setAttribute('class', 'filled-in');
			cBox.classList.add('checkboxesEdit-'+questaoCounter);
			
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
				radioDiv.classList.add('rdiosEdit-'+questaoCounter);
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
			
			radioLabel.innerHTML = "Correto";
			radioLabel.setAttribute('for', 'rdioEdit-' + questaoCounter + "-" + contadorAlternativas);
			
			div.appendChild(document.createElement('br'));
			div.appendChild(document.createElement('br'));
		}
		
		contadorAlternativas++;
	}
	
	function LimparAlternativas(){
		let div = document.querySelector('#alternativas-alterar-'+questaoCounter);
		while(div.firstChild){
			div.removeChild(div.firstChild);
		}
		contadorAlternativas=0;
	}
	
	function ExcluirAlternativas(){
		let div = document.querySelector('#alternativas-alterar-'+questaoCounter);
		if(div.firstChild){
			div.removeChild(div.lastChild);
		}
		contadorAlternativas--;
	}
	
	questao.querySelector('#inserirAlternativa-alterar-'+questaoCounter).addEventListener('click', Inserir);
	questao.querySelector('#limparAlternativa-alterar-'+questaoCounter).addEventListener('click', LimparAlternativas);
	questao.querySelector('#excluirAlternativa-alterar-'+questaoCounter).addEventListener('click', ExcluirAlternativas);
	questao.querySelector('#estilo-alterar-'+questaoCounter).addEventListener('mouseout', Alternativa);
	Alternativa();
	
	qC++;
}	
