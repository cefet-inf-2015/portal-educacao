#Como utilizar o Layout
O código index.html na pasta principal do projeto serve como um fundo base para todas as páginas a serem criadas.

![Imagem do layout][layout]

##Como mudar o título e o subtítulo
- O código referente a essa parte do site é o seguinte:  
```html
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br><br>
      <h1 class="header center blue-text text-darken-4">Portal Educação</h1>
      <div class="row center">
        <h5 class="header col s12 light">Um portal com soluções para sistemas educacionais</h5>
      </div>
      <br><br>
    </div>
  </div>
```
- Logo, para adicionar o título referente a sua parte do trabalho, basta substituir o "Portal Educação"
- Também é possível (e recomendado) que se altere o subtítulo

##Onde inserir o conteúdo
- O conteúdo deve ser inserido abaixo do comentário "conteúdo aqui".
```html
  <div class="container">
    <div class="section">
      <!-- CONTEÚDO AQUI -->

      

    </div>
  </div>
 ```

##Mudanças
Eventualmente ocorrerão mudanças no layout, que esperamos não serem frequentes, por exemplo para a inserção da Logo, do banner, do menu
e dos botões de Sign In. Por isso, será necessário que todas as páginas sejam atualizadas de tempos em tempos.

#File Path
- Um problema comum encontrado ao tentar utilizar o layout é que o CSS não estava funcionando. Isso se deve ao file path da pasta styles
que contém todos os arquivos de estilização do Materialize.  
- O código de importação utilizado no index.html é:
```html
  <link href="styles/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="styles/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
```
- Ele apenas funciona porque "styles" encontra-se na mesma pasta. Para outros arquivos html que não se encontram na mesma pasta,
é preciso tomar cuidado com o file path.

##Como lidar
- Uma forma de fazer funcionar é copiar a pasta styles para dentro da pasta com o arquivo html. Porém essa opção **NÃO** deve ser
utilizada, já que teríamos **DEZ** pastas styles quando poderia haver apenas uma, tornando o site muito mais pesado.  
- Outra forma seria utilizar o endereço definitivo para a pasta. Apesar de ser a forma mais adequada, poderia causar problemas por
cada um possuir um user diferente em casa, o que tornaria muito chato mudar o file path toda vez que abrisse o arquivo em um computador
diferente.
```html
   <link href="c:/Users/Aluno/Desktop/portal-educacao/styles/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
```
- A solução que utilizaremos será ``../``. Cada ``../`` dado volta uma pasta para trás.
![Imagem exemplificando file path][file path]  
  - Portanto, no exemplo acima ao dar ``../`` uma vez, você estará acessando o conteúdo da pasta "projeto". Com mais um ``../`` você
acessará o conteúdo de "Mural". Mais um ``../`` te permitirá acessar todo conteúdo de "portal-educacao", e consequentemente a pasta styles.  
  - O código final então será:
```html
   <link href="../../../styles/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
```

#Utilizando o Materialize
Os arquivos de estilização do Materialize já foram baixados dentro da pasta "styles". Nos arquivos há centenas de estilizações,
incluindo cores de background, cores para a fonte e muito mais.

##Para utilizar botões
- Os mais diversos botões podem ser encontrados na [página do Materialize][pag materialize] e para utilizá-los, basta copiar o código
dado para o seu html!
```html
    <a class="waves-effect waves-light btn">button</a>
```
- É possível ainda customizar o botão para atender melhor às suas necessidades:
```html
    <a class="waves-effect waves-light btn light-blue darken-4" id="btn">button</a>
```
Esse botão deixará de ter a cor predefinida pelo materialize e passará a ser azul de acordo com a estilização ``light-blue darken-4``

###Para tornar os botões responsivos
Ainda utlizando o botão
```html
    <a class="waves-effect waves-light btn light-blue darken-4" id="btn">button</a>
```
Para fazê-lo executar algo, basta criar em um arquivo .js um action listener
```js
    let btt = document.querySelector("#btn");
    btt.addEventListener("click", funcaoBtn);
    function funcaoBtn() {
      //função a ser realizada ao clicar no botão
    }
```

**_OBS:_** O # antes de btn indica que o querySelector deve procurar um elemento cuja id seja #btn#. De outra forma ele procuraria
um elemento cuja classe fosse #btn#.


[layout]: https://github.com/paula-mr/Aplica-es-para-Web/blob/master/apresent/1.PNG
[file path]: https://github.com/paula-mr/Aplica-es-para-Web/blob/master/apresent/2.PNG
[pag materialize]: http://materializecss.com/buttons.html
