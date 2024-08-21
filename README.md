# Projeto de Testes Automatizados Java com Selenium e Cucumber

Este projeto implementa testes automatizados utilizando Selenium WebDriver e Cucumber, com integração ao JUnit para execução de testes. Ele simula interações de usuário no site MantisBT, verificando o comportamento correto em cenários específicos.

## Descrição do Projeto

O objetivo deste projeto é automatizar testes de interface para uma aplicação web, verificando funcionalidades como login, criação de tarefas, exportação de CSV, entre outros. O projeto utiliza práticas recomendadas para manter as credenciais seguras e para garantir a manutenção e escalabilidade dos testes.

## Pré-requisitos

Antes de começar, certifique-se de ter os seguintes softwares instalados em seu sistema:

- [Java JDK 8+](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
- [Maven](https://maven.apache.org/)
- [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/downloads) (compatível com sua versão do Google Chrome)
- [Git](https://git-scm.com/)

Além disso, você precisará configurar variáveis de ambiente para suas credenciais:

```shell
export APP_USERNAME=seu_usuario
export APP_PASSWORD=sua_senha
```

## Configuração do Projeto
1. Clone o repositório;
2. Navegue até o diretório do projeto;
3. Instale as dependências do Maven:
```bash
mvn clean install
```
4. Coloque o `chromedriver` no caminho especificado ou atualize o caminho no projeto conforme necessário:
```bash
System.setProperty("webdriver.chrome.driver", "caminho/para/seu/chromedriver");
```
5. (Opcional) Adicione suas credenciais ao arquivo config.properties (não versionado no repositório) caso não queira usar variáveis de ambiente:
```bash
app.username=seu_usuario
app.password=sua_senha
```

## Como Executar os Testes
```bash
mvn test
```

## Estrutura do Projeto:
- hooks: Contém a configuração e o encerramento dos testes.
- pages: Contém os objetos de página que encapsulam a lógica de interação com as páginas da web.
- runners: Contém as classes que executam os testes com Cucumber e JUnit.
- stepDefinitions: Contém as implementações dos passos definidos nos arquivos .feature.
- features: Contém os arquivos .feature que definem os cenários de teste em Gherkin.
