## Aula 1 - Fundamentos da Web e a API de Servlets [tempo: 1h46min]

- **Minhas notas**
    - Para criar aplicações Web precisamos instalar o Eclipse EE, uma versão que da suporte para as necessidades do desenvolvimento web
    - Precisamos de um servidor também, utilizaremos no curso o Apache Tomcat 9.0
    - Dentro do Eclipse, vamos na view **Servers,** selecionamos o Apache Tomcat na versão desejada, na sequencia informamos qual é o endereço do arquivo da instalação do tomcat
    - Para criar um projeto Web criamos um **Dinamic Web Project**
    - Criado o projeto, precisamos adiciona-lo a nosso servidor, podemos arrastar a pasta até a view Servers e soltando sobre a linha que informa sobre o servidor inicializado ou então clicar com o botão direito sobre essa linha, selecionar “Add or Remove” e adicionar o projeto.
    - Podemos criar uma pagina estática criando um arquivo .html e adicionando ele a **`src/main/webapp`**
    - Servlet é o objeto que fica dentro do nosso projeto e que pode ser chamado através do protocolo HTTP
    - Para criar um Servlet devemos extender a classe **`HttpServlet`** e sobrescrever o método **`service`** que toma como parametros um objeto **`HttpServletRequest`(req)** e um **`HttpServletResponse`(resp)**
    - Dentro desse método service, criamos uma referencia do tipo **`PrintWriter`** recebendo **`resp.getWriter()`**
    - Agora utilizamos a referencia do tipo PrintWriter para escrever o código html que será executado ao charmarmos esse Servlet
    - Além disso, precisamos escrever a anotação **`@WebServlet(urlPatterns=”/nossa_url”)`** para informar através de que URL aquele Servlet será executado
    

## Aula 2 -  Trabalhando com POST e GET [tempo: 42min]

- **Minhas notas**
    - Podemos simplificar a criação de um Servlet utilizando a interface do Eclipse, clicamos com o botão direito no package onde queremos adicionar o Servlet > new > Servlet
    - Podemos enviar parametros utilizando o endereço que acessa o Servlet, para isso precisamos adicional ao final da URL **`?nome_do_parametro=valor_do_parametro`**
    - Dentro da classe Servlet no método **`service`**, recuperamos o valor da variavel com **`request.getParameter(”nome_do_parametro”)`** , onde **`request`** é o objeto que recebemos no primeiro parametro do método **`service`**
    - Podemos adicionar mais parametros separando-os com o caractere **`&`**
    - O método **`getParameter()`** sempre retorna uma String
    - Através do envio de parametros, estamos realizando uma requisição do método GET
    - Esse tipo de requisição é ideal para realizar uma busca, por exemplo, mas não é o adequado para fazer um envio de dados
    - Para enviar dados devemos fazer uma requisição do tipo POST
    - Para realizar uma requisição POST, precisamos criar uma pagina HTML com um **`form`** que indique no parametro **`action`** o endereço do Servlet e no parametro **`method`** informe que a requisição será do tipo **POST**
    - Dessa forma, os parametro e seus valores não irão ser informados na URL, já que serão enviados no body da requisição
    - Em uma URL Servlet a primeira parte da URL
    - Para criar um método que lide exclusivamente POST no nosso Servlet devemos sobrescrever o método **`doPost`** ao invés do **`service`** ja que ele lida tanto com requisições POST quanto GET
    

## Aula 3 - Definindo o nosso modelo [tempo: 41min]

- **Minhas notas**
    - Na aula criamos uma classe Banco para modelar um banco de dados e uma classe Empresa pra modelar uma entidade empresa
    - A classe **Banco** possui um **atributo de classe** (**`static`**) que guarda um **`ArrayList`** com as empresas adicionadas, além disso possui um método para adicionar uma empresa ao banco e um pra retornar a empresa
    - Na função **`doPost`** instanciamos o **Banco**, instanciamos uma **Empresa** com o nome passado na requisição e adicionamos essa empresa ao Banco
    - Criamos um novo Servlet para retornar a lista de empresas salvas em Banco
    - A ideia é lidarmos com os dados recebidos pelas requisições criando modelos para aumentar a legibilidade do código
    - O Banco na nossa aplicação é a *camada de persistencia*
    - Numa aplicação real o **modelo** ou **domínio** são as classes que representam o mundo real, as classes e funcionalidades do modelo são levantadas por um analista de requisitos conversando com o cliente.

## Aula 4 - Páginas dinâmicas com JSP [tempo: 1h2min]

- **Minhas notas**
    - JSP é uma **Java Server Page**, uma pagina HTML que aceita código Java, como um JSX no JavaScript
    - Para executar código dentro de um arquivo JSP, utilizamos a sintaxe **`<% código; %>`**
    - O fora dessa tag de código, utilizamos html normalmente
    - O código do JSP roda no servidor, por isso o nome Java **Server** Page
    - Podemos encurtar a sintaxe no scriptlet escrevendo **`<%= saida %>`** ao inves de println
    - Para linkar uma pagina a outra, criamos um objeto **`RequestDispatcher`** recebendo o método **`request.getRequestDispatcher(”nome_do_arquivo.jsp”)`**
    - Em seguida invocamos o método **`fd.forward(request, response)`**
    - Assim, ao acessar o **`Servlet`** ele vai realizar as operações definidas e renderizar o HTML do arquivo **`JSP`**
    - Para passarmos dados para o arquivo JSP, devemos utilizar o método **`request.setAttribute(”nome_do_atributo”, Objeto)`**
    - Dentro do JSP, resgatamos os dados com **`request.getAttribute(”nome_do_atributo”)`**
    - É preciso também fazer o cast já que ele será enviado como **`Object`**
    

## Aula 5 - JSTL e Expression Language [tempo: 1h25min]

- **Minhas notas**
    - Scriptlets não são uma boa prática
    - Não é bom colocar HTML junto com o código Java
    - Para substituir os Scriptlets utilizamos expressões, a sintaxe é **`${ código }`**
    - Através das expressões os objetos registrados em atributos no **`request`**
    - Na **`expression language`** não é possivel fazer laços, apenas acessar variaveis
    - Para solucionar isso, precisamos copiar o .jar da biblioteca JSLT para o projeto, através das tags que essa biblioteca fornece podemos utilizar uma sintaxe HTML que permite operações dinamicas como loops
    - A tag para um loop for é a **`<c:forEach items="${array}" var="item"></c:forEach>`**
    - Precisamos importar a biblioteca dentro do nosso arquivo HTML, nas linhas iniciais do arquivo digitar **`<%@ taglib uri=”http://java.sun.com/jsp/jstl/core” prefix="c" %>`**
    - Essa uri não direciona para um link, mas indica o nome do pacote da biblioteca, que foi instalada em **webapp > WEB-INF > lib**
    - JSTL é a sigla para **Java Standard Tag Library**
    - O parametro **`prefix`** indica a referencia para a biblioteca
    - Ao invés de escrevermos código Java em Scriptlets agora iremos criar tags a partir da biblioteca de tags, referenciando a biblioteca e a tag desejada
    - Na tag ainda indicamos no parametro **`items`** qual é o objeto a ser iterado e no parametro **`var`** o nome pelo qual trataremos o valor de cada iteração
    - O JSTL tem 4 sub-bibliotecas, core (para controle de fluxo, a utilizada no exemplo), fmt (para formatação), sql (para executar sql) e xml (para gerar XML). Usualmente só as duas primeiras são utilizadas
    - Outra tag útil é a **`<c:url value=”/pagina” />`** que retorna a url incluindo o contexto da aplicação, é uma boa pratica passar essa tag como action para tag de formulário, já que caso ocorra alguma alteração no nome do projeto (contexto) ela impede que os redirecionamentos quebrem
    - É interessante passar o parametro **`var`** para o a tag, assim podemos passar somente o nome da variavel para a action ao invés de escrever a tag entre aspas como valor de action
    - Existe a tag **`<c:if test=”${expreção_booleana}”>Conteudo HTML</c:if>`**
    - 
    

## Aula 6 - Redirecionando o fluxo [tempo: 40min]

- **Minhas notas**
    - O **`RequestDispatcher`** pode receber qualquer recurso que possa ser acessado por uma URL
    - Podemos encadear **`Servlets`** chamando um ao outro através do **`RequestDispatcher`**, essa é uma forma de reutilizar código
    - Fazer essa requisição pelo lado do servidor é pode ser uma má pratica, pois a ultima requisição feita ao servidor pode ser feita apertando F5.
    - Quando isso for um problema, o ideal é realizar essa requisição através do cliente, assim um Servlet não chama o outro diretamente, mas indica ao navegador que faça essa chamada
    - Assim, caso a página seja atualizada, as duas requisições não serão chamadas novamente, apenas a ultima.
    - Um exemplo onde a requisição ao Servlet ser feita no servidor é um problema: o primeiro Servlet envia um formulário, a segunda chama um JSP para apresentar uma confirmação. Caso a página fosse atualizada, o envio do formulário ocorreria novamente, mas a intenção seria somente atualizar a pagina do JSP
    - Podemos evitar isso isso através do método **`response.sendRedirect("nome_do_recurso")`** na primeira requisição. Assim o navegador iria realizar a requisição e se atualizado, somente o segundo Servlet seria executado.
    - Fazer isso, no entanto, apaga as informações salvas no request pelo primeiro Servlet. Assim, se o segundo Servlet precisasse receber algum dado como atributo do **`request`**, não daria certo
    - 
    

## Aula 7 - Completando o CRUD [tempo: 1h52min]

- **Minhas notas**
    - Criamos os métodos Remove e Update do nosso CRUD
    - Utilizamos a classe Banco para realizar as operações dentro da lista estática
    - A classe ArrayList não permite remoção de itens durante um loop for, para fazer a remoção, precisamos utilizar o objeto Iterator()
    - É uma boa pratica usar o id de um objeto como parametro na URL para realizar operações de remoção
    - Foi criada um input do tipo hidden para passar a informação do id a ser removido numa operação de update para evitar interação do usuário com esse dado (o que poderia levar a um NullPointerException)

## Aula 8 - Deploy da aplicação [tempo: 47min]

- **Minhas notas**
    - Podemos utilizar o arquivo **`web.xml`** para definir as rotas, definindo um arquivo pra ser renderizado de forma padrão ou definindo URLs para acessar Servlets
    - Esse método não é mais utilizado hoje em dia, mas existem projetos antigos que ainda gerenciam rotas dessa forma
    - Servlet é um objeto que pode ser chamado através do protocolo HTTP
    - Quem proporciona isso é o Tomcat
    - Tomcat é um Middleware e utiliza Inversão de controle (IOC)
    - O Tomcat abstrai a instanciação das classes Servlet
    - O Tomcat cria uma instancia única ao longo do uso da aplicação e ele só faz isso quando o Servlet é utilizado, ele não instancia todos eles ao iniciar o programa
    - Outros frameworks mais modernos, como o Spring tem implementações diferentes, além de fornecer utilidades mais variadas. O Tomcat só permite a comunicação de objetos via HTTP
    - Inversão de controle (IOC) significa que não é o meu método main que instancia os objetos e sim o Tomcat
    - Tomcat só instancia o Servlet quando ocorre uma requisição e ele só faz isso uma vez, mas podemos alterar esse comportamento se, além de **`urlPatterns`** passarmos o parâmetro **`loadOnStartup=1`** para a anotação **`@WebServlet`** do Servlet
    - Para fazer o **deploy** de uma aplicação java precisamos clicar com o botão direito no diretório, selecionar a opção **`export`** > **`WAR file`**
    - WAR é a sigla para Web ARchive
    - Caso utilizassemos um servidor externo como a AWS disponibilizariamos esse arquivo para ser disponibilizado
    - Na aula, criamos um novo servidor Tomcat e importamos o arquivo para a pasta webapps desse novo servidor
    - Agora podemos subir o servidor executando o arquivo **`bin/startup.sh`** na pasta  do servidor
    - Podemos alterar a porta de acesso a aplicação alterando o **`conf/server.xml`** dentro do novo servidor
