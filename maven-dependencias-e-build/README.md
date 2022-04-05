## Aula 1 - Conhecendo o Maven [tempo: 53min]

- **Minhas notas:**
    - Maven é uma abstração que auxilia no gerenciamento de dependencias e no build de uma aplicação
    - A forma mais obvia de gerar um build de uma aplicação, é exportando um WAR da aplicação
    - Apesar disso, algumas outras coisas devem ser feitas antes de gerar o build, como executar os testes e definir as propriedades do banco de dados, removendo o local e infomando os dados do servidor.
    - Uma solução criada foi o Apache Ant que automatiza esses processos. Apesar disso, o gerenciamento de dependencias ainda tinha que ser feito manualmente, para solucionar isso foi desenvolvido o Apache Ivy, que cuidava exclusivamente das dependencias
    - A solução era usar as duas ferramentas em conjunto
    - Para simplificar ainda mais esses processos, foi criado o Apache Maven que junta essas duas funções (gerenciamento de bibliotecas e build)
    - 
- **O que foi visto:**
    - As dificuldades de se realizar manualmente o build de uma aplicação Java;
    - As dificuldades de se gerenciar manualmente as dependências de uma aplicação Java;
    - O que é o Maven;
    - Como instalar e executar o Maven.

## Aula 2 - Projetos com Maven [tempo: 36min]

- **Minhas notas:**
    - O Eclipse disponibiliza uma inicialização de projeto Maven
    - A estrutura do projeto é composta por 4 pastas: **`src/main/java`** , **`src/main/resources`** , **`src/test/java`** e **`src/test/resources`**
    - Os arquivos Java ficam em **`src/main/java`**
    - Tudo que não é classe java, mas precisa ser acessivel para o seu código fica em **`src/main/resources`**
    - Ao criar um teste para uma classe, o Eclipse automáticamente adiciona ao diretório de testes java
    - O arquivo pom.xml define as configurações do seu projeto
    - É uma boa pratica seguir a estrutura de pastas do Maven, apesar disso é possivel definir uma estrutura diferente pelo pom.xml
    - Podemos converter um projeto para o formato Maven, devemos clicar com o botão direito no projeto, selecionar configure > convert to Maven Project
    - Na aula realizamos a migração de uma aplicação que não tinha Maven para o padrão Maven, fizemos isso convertendo para Maven Project, depois alterando a estrutura de pastas em build path > configure build path > source > deletando pastas atuais > criando pastas da arquitetura do Maven > movendo os arquivos para as pastas corretas
- **O que foi visto:**
    - A criar uma aplicação com Maven;
    - A entender a estrutura de diretórios de uma aplicação com Maven;
    - A migrar uma aplicação para o Maven.

## Aula 3 - Dependências no Maven [tempo: 22min]

- **Minhas notas:**
    - Na aula removemos a dependencia JUnit pelo build path para podermos atribuir a função de gerenciamento dessa biblioteca para o Maven
    - Para fazer isso devemos abrir uma tag **`dependencies`** no pom.xml, dentro dela uma tag **`dependency`** e dentro dela quatro tags, **`groupId`** , **`artifactId` ,** **`version`** , **`scope`**
    - Para essas tags foram passados os valores **junit**, **junit**, **4.12** e **test** respectivamente
    - Ao salvar o arquivo, o Maven vai baixar e adicionar a dependencia automáticamente ao projeto
    - Podemos buscar as informações da dependencia no site da Maven
    - O Maven busca em um diretório local a biblioteca e caso ela não esteja lá, baixa do repositório do Maven e instala nesse diretório local
    - Podemos adicionar uma biblioteca de fora do repositório padrão do Maven com as tags **`repositories`** > **`repository`** > [**`id`**,**`url`**]
    - Assim ele vai buscar na url informada na tag a biblioteca, pode ser passado um repositório local para essa tag também
    - A pasta local que o Maven usa para instalar as bibliotecas fica em **`home/.m2/repository`**
    - Quando por algum motivo a biblioteca instalada não rodar e o update Maven não funcionar, podemos remover todas as pastas em **`home/.m2/repository`** rodar o update de novo e o Maven irá baixar todas as bibliotecas novamente, o que corregirá um erro de instalação
- **O que foi visto:**
    - A como declarar as dependências de uma aplicação;
    - A como pesquisar por dependências no repositório central do Maven;
    - A como configurar outros repositórios remotos.

## Aula 4 - Build no Maven [tempo: 29min]

- **Minhas notas:**
    - Para compilar o projeto usando o Maven pela linha de comando usamos **`mvn compile`**
    - Ao fazer isso recebemos um erro informando que a source e target estavam em versões antigas
    - Para corrigir isso, criamos uma tag **`build`** > **`plugins`** > **`plugin`** > [**`artifactId`** (valor **maven-compiler-plugin**), **`configuration`** > [**`source`**(**11**), **`target`**(**11**)]]
    - Assim informamos ao Maven que ao compilar o código queremos usar a versão 11 do java
    - Podemos utilizar outros comandos Maven como o **`mvn test`** para rodar os testes da aplicação
    - Ele funciona basicamente como o npm no Node.js
    - As tarefas passadas como parametro no terminal para o **`mvn`** são chamadas **goal**
    - O Maven salva os arquivos do build na pasta target
    - Para gerarmos um JAR da nossa aplicação, usamos o goal **`mvn package`**
    - Para limpar o build **`mvn clean`**
    - Para instalar uma dependencia em **`home/.m2/repository`** o goal é **`mvn install`**
    - Também existe o **`mvn deploy`** que faz o a instalação em um repositório remoto, para definir o repositório remoto criamos as configurações no arquivo pom.xml
    - No **pom.xml** podemos definir o nome do arquivo JAR gerado pelo Maven ao fazer o build, para isso, na tag **`build`** adicionamos uma tag **`finalName`** e passamos como valor o nome desejado
    - Podemos executar os mesmos comandos através do eclipse clicando com o botão direito no projeto > Run As > Maven build... > Goals (digitar os goals desejados)
    - Podemos goals seguidos como **`mvn clean test compile`**
    
- **O que foi visto:**
    - A realizar o build da aplicação com Maven;
    - A utilizar o comando `mvn nome-do-goal` para realizar o build;
    - Alguns *goals* do Maven, como `compile`, `test` e `package`;
    - A personalizar o artefato de build gerado pelo Maven.

## Aula 5 - Outros recursos [tempo: 51min]

- **Minhas notas:**
    - Pluguins servem para adicionar recursos para o build da aplicação
    - Na aula foi implementado o plugin Jacoco que serve para gerar um relatório de cobertura de testes
    - É possivel criar plugins pra extender o Maven com funções criadas por nós
    - Podemos configurar um proxy para ser utilizado pelo Maven, para isso precisamos criar um arquivo settings.xml na pasta **`.m2`** no nosso sistema, essa configuração não fica na pom.xml pois não é uma configuração do projeto e sim uma configuração local para lidar com a rede
    - Para configurar o proxy, no arquivo setting.xml abrimos uma tag settings com os dados necessarios (pegar na internet), uma tag **`proxies`** > **`proxy`** > [**`id`**, **`active`**, **`protocol`**, **`host`**, **`port`**, **`username`**, **`password`**] informando nas tags filhas de proxy as informações
    - Podemos dividir um projeto em modulos usando o Maven, para na aplicação pai, definimos a tag **`<packaging>pom</pachaging>`** depois da tag **`version`,** no fim do arquivo, também precisamos definir uma tag **`modules`** e dentro dela uma tag **`module`** para cada modulo, tendo como valor o nome do modulo
    - No pom.xml de cada um dos módulos, criamos uma tag **`parent`** e movemos as tags **`goupId`**, **`artifactId`** e **`version`** para dentro dela
    - A partir do Java 9, essa modularização não precisa ser feita pelo Maven
- **O que foi visto:**
    - A utilizar plugins do Maven;
    - A como configurar um *proxy* no Maven;
    - A como configurar uma aplicação modularizada no Maven.
