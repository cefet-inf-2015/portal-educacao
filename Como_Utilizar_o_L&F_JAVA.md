#Como utilizar o 'Look and Feel'

tutorial de como utilizar look and feel, para edição de interface gráfica em java.

## Introdução
#### Uma rápida definição da Wikipédia sobre o que é look and feel

   - "Na concepção do software o termo "Look and Feel" é utilizado em relação a interface gráfica do usuário e compreende os aspectos da sua concepção, incluindo elementos como cores, formas, disposição e tipos de caracteres (o "Look"), bem como o comportamento de elementos dinâmicos tais como botões, caixas, e menus (o "Feel")."
   
#### Partindo para a parte de JAVA
  
  - A arquitetura da biblioteca Swing foi planejada de modo a permitir que o úsuario modifique o L&F das aplicações.
  
  - É possivel que cada JComponent possua multiplos L&F, mas para isso é necessário que cada componente seja separado em classes distintas.

  - A L&F que os componentes usam é especificada pela classe UIManager, que está presente no pacote javax.swing. Toda vez que um componente é criado, o componente pergunta para UI manager qual UI será encarregado por implementar o L&F dele. // Nada que vocês precisem se preocupar
  
## Na prática 

  - Parece bem complicado, mas na realidade é bem simples. //É igual andar de bike enquanto o chão pega fogo.
  
  - Neste tutorial, daremos maior enfoque a utilização da ferramenta de WYSIWYG do netbeans. // Que por sinal é uma coisa linda.
  
  - É possivel trocar o L&F de JComponents mexendo diretamente no código, para isso deve-se usar o comando UIManager.setLookAndFeel(Uma explicação mais detalhada pode ser encontrada [No site da Oracle](https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html), ou neste [forum aqui](http://javafree.uol.com.br/topic-3229-Aparencias-de-interface-Look-and-Feel.html)). //Mas caso você tenha amor proprio, irá usar o editor WYSIWYG do netbeans.
  
  - Mas se ainda assim quiser dar uma olhada no código, aqui vai um exemplo:
```java
public static void main(String[] args) { 
    try { 
       // Set System L&F 
        UIManager.setLookAndFeel( 
            UIManager.[b]getSystemLookAndFeelClassName[/b]()); 
    } 
    catch (UnsupportedLookAndFeelException e) { 
       // handle exception 
    } 
    catch (ClassNotFoundException e) { 
       // handle exception 
    } 
    catch (InstantiationException e) { 
       // handle exception 
    } 
    catch (IllegalAccessException e) { 
       // handle exception 
    } 

    new SwingApplication(); //Create and show the GUI. 
} 
```
  
  - Para alterar o L&F dos JComponentes através do FORM EDITOR do netbeans, deve-se simplismente clicar com o botão direito em cima do frame, ao qual as mudanças devem ser aplicadas, depois basta ir até "preview design", e pronto, irá aparecer um menu com as opções de pré visualização do L&F.
  
  ![Alt Text](http://i.stack.imgur.com/hligH.png)


  - Para que estás mudanças sejam aplicadas basta adicionar o seguinte trecho de código a sua classe de aplicação central(MAIN), ou ao construtor de sua classe.
  
```java
    /**
     * Creates new form Home
     */
     try {
         UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
         Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
     }
```

## Iremos seguir alguns padrões

  - 1º Deve-se, obrigatorimente, manter fidelidade aos padrões apresentados pelo layout default //deve-se usar os menus padrões, sem invenção de moda.
  
  - 2º Para evitar problemas, JComponents de um mesmo tipo(exemplo dois jbuttons), ***deverão obrigatoriamente usar o mesmo L&F.***
  
  - 3º As informações em java deverão ser, preferencialmente, dispostas na tela de forma a ocuparem apenas o espaço disponibilizado, evitando o uso de scrollbar. // é preferível utilizar mais de um frame, do que conter um scrollbar.  
 
  - 4º De preferência pela utilização do editor do netbenas, para evitar problemas.
  
  - 5º O tema padrão que deverá ser utilizado é o do Windows Classic.
