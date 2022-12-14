# Projeto de gestão de empresas

Para rodar: dar um mvn clean package e debugar o CompanyApplication

Tecnologias utilizadas:

    - Java com Spring
    - Database : MySQL

Rotas: 

    - Addresses
    - localhost:8080/addresses             (POST)   - salvar address
    - localhost:8080/addresses/{id}        (PUT)    - atualizar address
    - localhost:8080/addresses/{id}        (DELETE) - deletar address
    - localhost:8080/addresses/{id}        (GET)    - trazer address
    - localhost:8080/addresses/client/{id} (GET)    - trazer addresses por id do cliente
    - localhost:8080/addresses             (GET)    - trazer todos os addresses
    -
    - Contacts
    - localhost:8080/contacts              (POST)   - salvar contact
    - localhost:8080/contacts/{id}         (PUT)    - atualizar contact
    - localhost:8080/contacts/{id}         (DELETE) - deletar contact
    - localhost:8080/contacts/{id}         (GET)    - trazer contact
    - localhost:8080/contacts/client/{id}  (GET)    - trazer contacts por id do cliente
    - localhost:8080/contacts              (GET)    - trazer todos os contacts
    -
    - Clients
    - localhost:8080/clients               (POST)   - salvar client
    - localhost:8080/clients/{id}          (PUT)    - atualizar client
    - localhost:8080/clients/{id}          (DELETE) - deletar client
    - localhost:8080/clients/{id}          (GET)    - trazer client
    - localhost:8080/clients               (GET)    - trazer todos os clients
    -
    - Faq
    - Obs: do jeito que está rodando o projeto agora, toda vez que é iniciado uma nova sessão, são apagados
    - todos os dados do banco e recriado tudo novamente. Então, para fazer testes da faq, podemos fazer
    - a carga de perguntas pelo postman através da api.
    - localhost:8080/faq                   (POST)   - salvar faq
    - localhost:8080/faq/all               (POST)   - salvar faqs
    - localhost:8080/faq/{id}              (PUT)    - atualizar faq
    - localhost:8080/faq/{id}              (DELETE) - deletar faq
    - localhost:8080/faq/{id}              (GET)    - trazer faq
    - localhost:8080/faq                   (GET)    - trazer todas faqs
    -
    - Users
    - localhost:8080/users/login           (POST)   - validar se login do user está correto
    - localhost:8080/users                 (POST)   - salvar user
    - localhost:8080/users/{id}            (PUT)    - atualizar user
    - localhost:8080/users/{id}            (DELETE) - deletar user
    - localhost:8080/users/{id}            (GET)    - trazer user
    - localhost:8080/users/client/{id}     (GET)    - trazer users por id do cliente
    - localhost:8080/users/exists/{id}     (GET)    - trazer se usuario existe ou não
    - localhost:8080/users                 (GET)    - trazer todos os users
