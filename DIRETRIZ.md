#Diretrizes e Padronização para o projeto.

É importante mantermos nosso trabalho organizado, facilitando a leitura de todos ao código já escrito.

##Desenvolvimento

  - Cada tarefa está listada na página [*Projects*][projects]. As equipes deverão seguir um método de produção que utiliza
cartões para indicar o andamento de fluxos e processos no projeto (chamado *Kanban*). Caberá aos líderes das equipes editá-los
e atualizá-los *conforme necessário*.

##Padronização
 __*Cabe aos líderes das equipes exigir o cumprimento da padronização!!*__

- Códigos HTML e CSS:
  - Seguir o [**codeGuide**][codeGuide].
- ####Códigos JavaScript:
  - Utilizaremos nosso próprio padrão, incluindo aspectos do Ecmascript 6 (JS6):
    - **_Tab_**ulação de 2 espaços
    - Uso de *aspas simples*
    - [`for..of`][for-of] ao invés do do `for(;;)` tradicional
    - [`const`/`let`][const-let] em vez de `var` sempre que possível
    - Nome das variáveis e funções em [camelCase][cml-case]
    - Declarar multiplas variáveis da seguinte forma:
    
      ```js
      let primeira = 1,
          segunda = 2,
          //...
          milesima = 1000;
      ```
    - Trabalhar com [*template literals*][tmp-str] para manipular strings
    
      ```js
      let i = 1;
      
      // Isso:
      let str = 'Essa é a linha ' + i;
      // É o mesmo que:
      let str = `Essa é a linha ${i}`;
      ```
    - Utilizar nomes de variáveis **concisos** e **descritivos**:
    
        ```js
        let str = 'Zé e William' // Ruim. TA ERRADO!!

        let nomeDosDiretores = 'Zé e William' // Qualquer um entenderá em qualquer trecho
        ```
        
    - Evitar linhas muito longas. Prefira quebrá-la em variáveis:

        ```js
        // Mais horroroso do que quebrar linha pra abrir corpo:
        document.querySelector('#troco').value = document.querySelector('#quantia-paga').value - document.querySelector('#preço').value;

        //Faça bonitinho:
        let elementoTroco = document.querySelector('#troco'),
            quantiaPaga = document.querySelector('#quantia-paga').value,
            preco = document.querySelector('#preço').value;
        elementoTroco.value = quantiaPaga - preco;
        ```
        
    - Não trabalhar com _`getElementById()`_ nem _`getElementsByClassName()`_. Utilize [_`querySelector()`_]
[query-selector] e [_`querySelectorAll()`_][query-all], que aceita [_seletores CSS_][seletores] (!!!) como argumento:
        ```js
        // Mais decepcionante que No Man's Sky:
        let lista = document.getElementById('principal'),
            ultimoDaLista = lista.parentNode.lastChild;

        // Show 10/10:
        let ultimoDaLista = document.querySelector('#principal:last-child');
        ```


- ####Códigos Java:
  - **_Tab_**ulação de 4 espaços (padrão do netBeans)
  - Nome das variáveis e funções em [camelCase][cml-case]
  - Criar um arquivo para cada classe criada
  - Utilizar o [_`for melhorado`_][enhanced-for] sempre que possível

##Framework para WEB
  _**Frameworks**_ são um conjunto de classes que permitem o reaproveitamento de código e facilitam *muito* o 
desenvolvimento de aplicações.
  Para a parte de WEB do nosso projeto, utilizaremos o [**Materialize**][materialize], framework inspirada
no conceitos do [Material Design][material-design] da Google.

  ![Logotipo materialize](http://blockino.ufsc.br/img/tech/materialize.png "logotipo Materialize")
![logotipo es6](https://aspblogs.blob.core.windows.net/media/dwahlin/Windows-Live-Writer/57c59b2be72b_127DE/image_8.png "logo es6")
![logotipo github]( https://cdn4.iconfinder.com/data/icons/iconsimple-logotypes/512/github-256.png "logo github")


  [codeGuide]: http://codeguide.co/
  [for-of]: https://developer.mozilla.org/pt-BR/docs/Web/JavaScript/Reference/Statements/for...of
  [const-let]: https://developer.mozilla.org/pt-BR/docs/Web/JavaScript/Reference/Statements/let
  [tmp-str]: https://developer.mozilla.org/pt-PT/docs/Web/JavaScript/Reference/Template_literals
  [cml-case]: https://pt.wikipedia.org/wiki/CamelCase
  [query-selector]: https://developer.mozilla.org/pt-BR/docs/Web/API/Document/querySelector
  [query-all]: https://developer.mozilla.org/pt-BR/docs/Web/API/Document/querySelectorAll
  [seletores]: http://www.maujor.com/tutorial/guia-completo-seletores-css3.php
  [enhanced-for]: https://jawakopi.wordpress.com/2010/11/06/o-for-melhorado/
  [materialize]: http://materializecss.com/
  [material-design]: https://material.google.com
  [projects]: https://github.com/cefet-inf-2015/portal-educacao/projects
