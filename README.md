# Projeto de gestão de empresas

Para rodar: dar um mvn clean package e debugar o CompanyApplication

Rotas: 
    - localhost:8080/addresses             (POST)   - salvar address
    - localhost:8080/addresses/{id}        (PUT)    - atualizar address
    - localhost:8080/addresses/{id}        (DELETE) - deletar address
    - localhost:8080/addresses/{id}        (GET)    - trazer address
    - localhost:8080/addresses/client/{id} (GET)    - trazer addresses por id do cliente
    - localhost:8080/addresses             (GET)    - trazer todos os addresses
    -
    - localhost:8080/contacts              (POST)   - salvar contact
    - localhost:8080/contacts/{id}         (PUT)    - atualizar contact
    - localhost:8080/contacts/{id}         (DELETE) - deletar contact
    - localhost:8080/contacts/{id}         (GET)    - trazer contact
    - localhost:8080/contacts/client/{id}  (GET)    - trazer contacts por id do cliente
    - localhost:8080/contacts              (GET)    - trazer todos os contacts
    -
    - localhost:8080/clients               (POST)   - salvar client
    - localhost:8080/clients/{id}          (PUT)    - atualizar client
    - localhost:8080/clients/{id}          (DELETE) - deletar client
    - localhost:8080/clients/{id}          (GET)    - trazer client
    - localhost:8080/clients               (GET)    - trazer todos os clients