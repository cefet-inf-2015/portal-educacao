botoes = document.querySelectorAll('.botoes');

for(let botao of botoes){
	let botao_altera = botao.querySelector('.botao_altera');
	let botao_apaga = botao.querySelector('.botao_apaga');
		
	botao_altera.addEventListener('click', function(e){			
			let botoes = e.target.closest('.botoes');
			let questao = botoes.previousElementSibling;
			
			while(questao==null || questao.className!='questao_usuario'){
				questao = questao.previousElementSibling;	
			}
						
			console.log(questao.id);
			questao.readOnly = false;
		});
}
