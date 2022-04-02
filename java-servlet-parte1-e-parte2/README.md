### PARTE 1 - FUNDAMENTOS


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
    

### PARTE 2 - AUTENTICAÇÃO E MVC

## Aula 1 - Criando o controlador [tempo: 1h52min]

- **Minhas notas:**
    - Devemos separar o Modelo em uma camada e os Servlets em outra (pacotes diferentes)
    - Outra boa pratica é criar um único Servlet que gerencie a comunicação do cliente com os Servlets, ele vai fazer o direcionamento da requisição pra o objeto desejado
    - Servlet é uma forma de atrelar uma requisição HTTP a um objeto Java
    - Nessa arquitetura, não utilizamos mais Servlets para executar as ações, criamos um novo pacote para açoes e criamos classes convencionais, que executam o código que era executado pelo Servlet especifico em métodos
    - Na classe de ação, o método que irá executar a lógica de negócio, será necessário receber os parametros request e response, já que internamente ela vai usa-los
    - No Servlet controlador será feito o direcionamento pra a ação adequada e essa ação chamará o método passando request e response como parametros
    - A função do controlador é receber as requisições e delegar as chamadas para as ações correspondentes.
    - A camada Controller também é chamada de Action
    

## Aula 2 - O padrão MVC [tempo: 1h:32min]

- **Minhas notas:**
    - O controlador (Servlet) deve ser responsável por fazer o redirecionamento e não as ações
    - Para fazer isso, as ações passam a retornar uma String que informa o endereço que será chamado no Controller
    - Existem dois tipos de requisições possiveis, **`forward`** e **`redirect`;** O primeiro acessa a pagina pelo servidor, o segundo faz o cliente acessar a URL
    - A String retornada pela action irá informar isso da seguinte forma: **`"forward:nome_do_destino"`** ou `**"redirect:url_do_destino"**`
    - No controller devemos quebrar a String com um **`.split(":")`** para separar o despachador e o endereco
    - Como boa pratica iremos refatorar o controller com o padrão de projeto **Command** que é o aplicado para lidar com classes que só possuem um método, geralmente **execute** ou **run**
- **O que foi visto:**
    - MVC significa *Model-View-Controller*
    - MVC divide a aplicação em 3 camadas lógicas
    - Cada camada tem a sua responsabilidade
    - O controlador central e as ações fazem parte da camada *Controller*, que define o fluxo da aplicação
    - Os JSPs fazem parte da camada *View*, que define a interface
    - As classes do modelo fazem parte da camada *Model*, que encapsula as regras de negócio
    - MVC facilita a manutenção e evolução da aplicação
    - Os JSPs devem ficar "escondidos" na pasta **WEB-INF**, pois dependem da ação

## Aula 3 - Formulário de login [tempo: 45min]

- **Minhas notas:**
    - Na aula criamos um sistema de autenticação, para isso criamos uma nova classe **na camada modelo** chamada **`Usuario`**, uma nova pagina **na camada view** chamada **`formLogin.jsp`** e uma nova **action na camada controller** chamada **`Login`**
    - A action **`Login`** deve retornar um **redirecionamento** para a action **`ListaEmpresas`**
    - Para acessarmos a pagina de login precisamos criar uma nova action na camada controller que faça o forward para a view, criamos então uma classe chamada **`LoginForm`**
    - Sempre que queremos ir para uma nova pagina, devemos criar uma ação que chame o JSP da pagina através do nosso Controller (Servlet que faz o controle de fluxo)
    - O **foward** sempre chama o nome do arquivo JSP
    - Nesse ponto ainda é possivel acessar a pagina de ListaEmpresas sem autenticação, além disso mesmo entrando com dados errados, o redirecionamento é feito
    - Pra solucionar isso, criamos uma lógica de validação de usuários na classe Usuário e na pagina de login, criamos uma validação através de um if-else e fazemos o direcionamento a partir do retorno do login
    - Mesmo com isso é possivel acessar o link da Lista diretamente, mas a pagina de login já tem o comportamento desejado
    - Para criar as autorizações, precisamos configurar o web.xml e o tomcat-users.xml para definir as permissões e os recursos acessaveis pra cada tipo de permissão
    - Esse procedimento é um padrão chamado Java Authentication and Authorization Service (JAAS) é a API padrão do Java para segurança, mas não é usualmente utilizada.
    
- **O que foi visto:**
    - A representar o usuário através de uma classe `Usuario`
    - A criar um formulário de login
    - A criar a ação para chamar o formulário
    - A criar a ação verificar o login e a senha

## Aula 4 - HttpSession [tempo: 55min]

- **Minhas notas:**
    - Para persistir a informação do login não usamos mais o request e sim o HttpSession, essa classe possui um método chamado .getSession() que retorna um código de identificação do navegador
    - Isso é necessário pois cada requisição é tratada isoladamente, assim, se realizamos uma nova requisição, os atributos são zerados, o que não ocorre com a Session
    - Na action de Login, colocamos a sessionId como atributo da Session, assim poderemos validar se o usuario realizou o login
    - Agora devemos criar uma validação da sessionId no nosso Servlet Controller, na validação, caso o usuário não tenha uma SessionId salva como atributo, ele será redirecionado para a pagina de login
    - Para garantir que a pagina de login não fique protegida, precisamos ainda adicionar um segundo boolean na validação que indica que a pagina acessada não é a de login
    - Apesar de isso solucionar o problema, essa autenticação não deve ficar no controlador, já que sua função deve ser somente a de controle de fluxo
    - Para fazermos o logout devemos criar uma nova action que recupera a HttpSession com request.getSession() e depois session.invalidate() que irá apagar o cockie que é quem guarda as informações da sessão
    - Criamos uma nova pagina JSP para conter o link de logout e usamos a tag **`<c:import url=”nome_do_arquivo” />`** em cada pagina JSP que deverá ter o botão de logout
    - O cockie gerado pela aplicação tem um tempo de persistencia de 30 minutos no Tomcat 9, podemos alterar esse tempo no arquivo web.xml, lá podemos definir quanto tempo o cockie irá persistir com o usuário inativo
    
- **O que foi visto:**
    - Por padrão, o navegador não envia nenhuma identificação sobre o usuário
    - Quando o Tomcat recebe uma nova requisição (sem identificação), gerará um ID
    - O ID fica salvo no cookie de nome `JSessionID`
    - O ID é um *hash* (número aleatório)
    - O cookie é anexado à resposta HTTP
    - O navegador reenvia o cookie automaticamente nas próximas requisições
    - O Tomcat gera, além do ID, um objeto chamado `HttpSession`
    - A vida do objeto `HttpSession` fica atrelado ao ID
    - Para ter acesso à `HttpSession`, basta chamar `request.getSession()`
    - Usamos a `HttpSession` para guardar dados sobre o usuário (login, permissões, carrinho de compra)
    - A `HttpSession` tem um ciclo de vida e será automaticamente invalidada

## Aula 5 - Aplicando filtros [tempo: 1h14min]

- **Minhas notas:**
    - Um filtro é uma camada inicial que tem responsabilidades semelhantes a um Servlet, ele faz um controle de requisições antes mesmo de entrar no Controller
    - Para criar um **filtro**, devemos implementar a interface **`Filter`** da biblioteca **`javax.servlet`**
    - Podemos por exemplo utilizar o filtro para medir tempo de execução de ações
    - O Filter controla a sequencia da requisição a partir do objeto **`FilterChain`** que ele recebe como parametro junto com request e response
    - Mapeamos o acesso ao filter através da anotação **`@WebFilter(urlPatterns=”/endereco_do_controller”)`** ele deve ter o mapeamento igual ao do Controller, mas o Java vai executar o Filter antes do Servlet
    - O filter ajuda a centralizar operações que seriam espalhadas entre varios objetos, no caso da aula usamos ele pra medir o tempo de execução e ele fará isso pra cada nova request. Definimos a ação chamada e ele informa isso junto com o tempo de execução
    - A direfença de um Filter para um Servlet é que o Filter consegue parar a requisição atraves do parametro FilterChain
    - Devemos utilizar o Filter para realizar a autenticação, podemos copiar a lógica escrita no Controller para esse novo filter responsavel por essa operação
    - Precisamos no entanto fazer um **Cast** dos objetos request e response recebidos no Filter de **`ServletRequest`**/**`ServletResponse`** para **`HttpServletRequest`**/**`HttpServletResponse`** porque de outro modo não teriamos acesso ao método **`getSession()`**
    - Quando temos mais de um filtro a ordem de execução deles deve ser definida no **`web.xml`**
    - O Controller deve ser um Filtro também, ele não deve existir como Servlet
    - Utilizamos a lógica de Filter, mas não precisamos usar o objeto Chain que iria direcionar para o próximo Filter, já que o Controller chama as Actions diretamente
    - Filtros também são chamados de ***interceptadores***
    - No Spring a classe que cria um filtro é a **`Interceptor`**
    - A diferença entre esses dois conceitos é que o Filter fica antes do controlador e o Interceptor fica depois. Assim o **`Filter` filtra as requisições da web** e o **`Interceptor` filtra as chamadas de ações**
    
- **O que foi visto:**
    - Um Filter e Servlet são bem parecidos
    - Comparado com Servlet, o Filter tem o poder de parar o fluxo
    - Para escrever um filtro, devemos implementar a interface `javax.servlet.Filter`
    - Para mapear o filtro, usamos a anotação `@WebFilter` ou o **web.xml**
    - Vários filtros podem funcionar numa cadeia (um chama o próximo, mas todos são independentes)
    - Para definir a ordem de execução, devemos mapear os filtros no **web.xml**
    - Um filtro recebe como parâmetro, do método `doFilter`, um `ServletRequest` e um `ServletResponse`
    - Ambos, `ServletRequest` e `ServletResponse`, são interfaces mais genéricas do que `HttpServletRequest` e `HttpServletResponse`
    - Para chamar o próximo filtro na cadeia, usamos o objeto `FilterChain`

## Aula 6 - Introdução ao Web Services [tempo: 1h14min]

- **Minhas notas:**
    - Web Services usam o protocolo HTTP para enviar dados para o cliente através de JSON ou XML
    - Vamos criar um novo Servlet para lidar com as requisições HTTP retornando JSON ou XML
    - Usaremos a **biblioteca `GSON`** para lidar com JSON
    - Essa biblioteca converte objetos Java para o formato JSON
    - Para fazer isso, instanciamos um objeto **`Gson`** e criamos uma String a partir da instancia com o método **`gson.toJson(objetoJava)`;** Pelo que entendi, essa operação deve ser feita com objetos **`List`**
    - Para retornar um JSON pelo objeto response, precisamos definir o ContentType através do método **`response.setContentType(”application/json”)`**
    - Para inserir a informação na response usamos o método **`response.getWriter().print(objetoJson)`**
    - Quando criamos um Web Service podemos atender a varios tipos de clientes diferentes, não necessáriamente um navegador, por isso não damos o retorno em HTML e sim em JSON ou XML, para que o cliente utilize os dados da forma desejada
    - Para lidar com XML utilizaremos as bibliotecas **`xmlpull`** e **`xstream`**
    - Para criarmos um objeto XML com nossos dados precisamos instanciar um objeto **`XStream`** e criar uma String com o método **`xstream.toXml(objetoJava)`**
    - Além disso, antes de criar a String, devemos criar um **alias** para a instancia de XStream que definirá o nome da tag (XML funciona com tags), de outro modo as informações estarão envolvidas numa tag que é o Full Qualified Name do objeto Java. Fazemos isso com o método **`xtream.alias("nome_desejado", ObjetoJava.class)`**
    - O restante é igual ao JSON, exceto pelo ContentType que será **`"application/xml"`**
    - Geralmente quando falamos de **Web Services** nos referimos a eles como **APIs** (Application Programming Interface)
    - Apesar disso a **API é a definição da interface que o serviço oferece** e não o serviço em si, nos comunicamos com o serviço através de APIs
    - 
- **O que foi visto:**
    - Que um *web service* usa HTML, JSON ou XML como retorno
    - Que um *web service* oferece alguma funcionalidade para seu cliente
    - Que um *web service* é útil quando precisa oferecer uma funcionalidade para cliente diferentes
    - Que para o *web service* não importa se o cliente foi escrito em Java, C# ou outra linguagem, pois usamos um protocolo e formatos independentes da plataforma
    - Como gerar JSON no código Java através de GSON
    - Como gerar XML no código Java através de XStream
    - Como escrever um web service através de um `HttpServlet`
    - Como criar um cliente HTTP a partir do código Java, usando a biblioteca `Apache HttpClient`
    - Como gerar JSON ou XML a partir do cabeçalho `Accept` da requisição

## Aula 7 - Deploy no Jetty [tempo: 47min]

- **Minhas notas:**
    - Existem servidores que são **Servlet Containers** ou **Servlet Engines** que servem basicamente para gerenciar requisições e respostas HTTP
    - Existem servidores mais completos chamados de **Application Servers** que possuem mais funcionalidades e bibliotecas
    - Nessa aula de deploy precisaremos implementar as funções **`init`** e **`destroy`** da interface **`Filter`** pois o Jetty espera que elas existam, isso não é necessário no Tomcat 9 (apesar de ser necessário nas versões mais antigad)
    - Exportamos o WAR da nossa aplicação e colamos ela no webapps do Jetty (arquivo baixado)
    - Fazendo isso, podemos rodar o servidor e nossa aplicação irá funcionar
    - Dessa forma podemos portar nossa aplicação para qualquer servidor
    - Dentro da nossa aplicação recebemos como parametro para funções objetos definidos a partir de interfaces que não implementamos (como a HttpServletRequest), essa implementação é feita pelo servidor, internamente ele define objetos que assinam as intefaces
    - Nossa aplicação só depende da **Especificação Servlet**, a **implementação das interfaces é feita individualmente pra cada servidor**
    - É por causa disso que a aplicação é portavel
    - Uma **Especificação** é a definição de um padrão de interfaces que deve ser usada, mas sem a implementação dos objetos. A especificação vai garantir que sua aplicação possa ser entendida por qualquer servidor, que implementa os objetos da especificação
    - O papel do *Servlet Container* é implementar as interfaces que fazem parte da especificação de uma Servlet.
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ebf42161-e13f-4329-bbec-924f9fe3e948/Untitled.png)
    
- **O que foi visto:**
    - A disponibilizar a nossa aplicação no *servlet container* **Jetty**
    - Que Servlet é uma especificação
    - Que a especificação Servlet faz parte do Java EE/Jakarta EE
    - Que, ao usar Servlet, programamos independentemente do servidor/container
    - A diferença entre *servlet container* e *application server*
