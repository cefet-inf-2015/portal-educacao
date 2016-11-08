function exibeCampoEspecifico(id){
		    var divEspeciProva = document.getElementById("divProva");
		    var divEspeciTrabalho = document.getElementById("divTrabalho");
		    var selecionado = document.getElementById(id);
		    var divBotao1 = document.getElementById("divBotao1");
     	    var divBotao2 = document.getElementById("divBotao2");
     		
     		if(selecionado.value == "individual"){
			    if (divindividual.className === "disable") {
			        divindividual.className = "disable2";
			    } else {
			        divindividual.className = "disable";
			    }
			} else	{
		    if(selecionado.value == "prova"){
		    	divEspeciTrabalho.className = "disable";
		    if (divEspeciProva.className === "disable") {
		        divEspeciProva.className = "disable2";
		    } else {
		        divEspeciProva.className = "disable";
		    }
		   } else {
		   	if(selecionado.value == "trabalho"){
		   		divEspeciProva.className = "disable";
		   	 if (divEspeciTrabalho.className === "disable") {
		        divEspeciTrabalho.className = "disable2";
		    } else {
		        divEspeciTrabalho.className = "disable";
		    }
		   }
        }
        }
    }

     	function exibe(id){
     		
     	    var selecionado = document.getElementById(id);
		    var divBotao1 = document.getElementById("divBotao1");
     	    var divBotao2 = document.getElementById("divBotao2");

            if(selecionado.value == "privada"){
		    	divBotao2.className = "disable";
		    		if (divBotao1.className === "disable") {
		       			 divBotao1.className = "disable2";		   
		    		 } 
		    		 	 } else {
						    if(selecionado.value == "publica"){
						   		divBotao2.className = "disable2";
						   	    if (divBotao1.className === "disable") {
						        divBotao1.className = "disable2";
		    		 	}
					 } 
                }
      }



      function ExibeFormedicao(id){

    var opcao = document.getElementsByName("opcaoEdicao");
    var campo = document.getElementById(id);
    var botao = document.getElementById("botao");

    for (var i=0; i<opcao.length; i++){ 
        if (opcao[i].checked == true){ 
            botao.className = "disable2";
           // if (campo.className === "disable")
            campo.className = "disable2";
    	} 
	}
}
