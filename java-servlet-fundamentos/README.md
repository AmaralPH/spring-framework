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
