/*window.onload = function(){
	document.querySelector('#inserir').addEventListener('click', ExibirCamposEspecificos, false);
}*/

function ExibirCamposEspecificos(idBotao){
	let estilo = document.querySelector('#estilo_questao'),
		nivel = document.querySelector('#nivel_questao'),
		disciplina = document.querySelector('#disciplina_questao'),
		tema = document.querySelector('#tema_questao'),
		cabecalho = document.querySelector('#cabecalho_questao'),
		gabarito = document.querySelector('#gabarito_questao'),
		botoesEnviarRefazer = document.querySelector('#botoes_env_ref'),
		salvaAlteracoes = document.querySelector('#botao_salva'),
		confirmaExclusao = document.querySelector('#botao_confirma'),
		nivelProva = document.querySelector('#nivel_prova');
		estiloProva = document.querySelector('#estilo_prova');
		numeroQuestoes = document.querySelector('#numero'),
		botoesVisualizarGerarImprimir = document.querySelector('#botoes_vi_ge_im');


	switch(idBotao){
		case 'inserir':
			estilo.className = 'mostrar';
			nivel.className = 'mostrar';
			disciplina.className = 'mostrar';
			tema.className = 'mostrar';
			cabecalho.className = 'mostrar';
			gabarito.className = 'mostrar';
			botoesEnviarRefazer.className = 'mostrar';
			confirmaExclusao.className = 'esconder';
			salvaAlteracoes.className = 'esconder';
			nivelProva.className = 'esconder';
			estiloProva.className = 'esconder';
			numeroQuestoes.className = 'esconder';
			botoesVisualizarGerarImprimir.className = 'esconder';
			break;

		case 'alterar':
			estilo.className = 'esconder';
			nivel.className = 'esconder';
			disciplina.className = 'mostrar';
			tema.className = 'mostrar';
			cabecalho.className = 'esconder';
			gabarito.className = 'esconder';
			botoesEnviarRefazer.className = 'esconder';
			confirmaExclusao.className = 'esconder';
			salvaAlteracoes.className = 'mostrar';
			nivelProva.className = 'esconder';
			estiloProva.className = 'esconder';
			numeroQuestoes.className = 'esconder';
			botoesVisualizarGerarImprimir.className = 'esconder';
			break;
		
		case 'excluir':
			estilo.className = 'esconder';
			nivel.className = 'esconder';
			disciplina.className = 'mostrar';
			tema.className = 'mostrar';
			cabecalho.className = 'esconder';
			gabarito.className = 'esconder';
			botoesEnviarRefazer.className = 'esconder';
			confirmaExclusao.className = 'mostrar';
			salvaAlteracoes.className = 'esconder';
			nivelProva.className = 'esconder';
			estiloProva.className = 'esconder';
			numeroQuestoes.className = 'esconder';
			botoesVisualizarGerarImprimir.className = 'esconder';
			break;

		case 'produzir':
			estilo.className = 'esconder';
			nivel.className = 'esconder';
			disciplina.className = 'mostrar';
			tema.className = 'mostrar';
			cabecalho.className = 'esconder';
			gabarito.className = 'esconder';
			botoesEnviarRefazer.className = 'esconder';
			confirmaExclusao.className = 'esconder';
			salvaAlteracoes.className = 'esconder';
			nivelProva.className = 'mostrar';
			estiloProva.className = 'mostrar';
			numeroQuestoes.className = 'mostrar';
			botoesVisualizarGerarImprimir.className = 'mostrar';
			break;
	}

}

function CriaCamposEspecificos(){
	let indexSelecionaodo = document.querySelector('#tipo').selectedIndex;
	
	switch(indexSelecionaodo){
		case 1:
			let div = document.querySelector('#multipla_V_F'),
				botaoRadio = document.createElement('radio'),
				opcao = document.createElement('options');
				
				botaoRadio.appendChild(opcao);
				div.appendChild(botaoRadio);
				break;
				
				
				
			
	}
	
}