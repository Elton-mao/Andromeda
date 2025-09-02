
# Sistema de Controle de Contratação de Funcionários

Este projeto é um sistema robusto para gerenciamento de requisições de pessoal e controle de funcionários, desenvolvido em Java com o framework Spring Boot. A aplicação foi criada para otimizar e automatizar o processo de contratação, desde a solicitação de uma nova vaga até a gestão dos usuários no sistema.

## Principais Tecnologias

O projeto foi construído utilizando um conjunto de tecnologias modernas e consolidadas no mercado de desenvolvimento de software:

- **Backend:**
  - **Java 21:** Versão mais recente do Java, garantindo performance e acesso a funcionalidades modernas da linguagem.
  - **Spring Boot 3.5.5:** Framework principal para a construção da aplicação, facilitando a configuração, o desenvolvimento e a implantação.
  - **Spring Data JPA:** Para persistência de dados e comunicação com o banco de dados de forma simplificada e eficiente.
  - **Spring Web:** Para a criação de endpoints REST e controllers que servem as páginas da aplicação.
  - **Lombok:** Para reduzir a verbosidade do código Java, automatizando a criação de getters, setters, construtores, etc.
  - **ModelMapper:** Para facilitar o mapeamento de objetos e a conversão entre DTOs e entidades.

- **Frontend:**
  - **Thymeleaf:** Motor de templates para renderização de páginas HTML no lado do servidor, integrado ao Spring Boot.
  - **HTML5, CSS3, JavaScript:** Tecnologias padrão para a construção da interface do usuário.
  - **Bootstrap:** Framework CSS para a criação de interfaces responsivas e modernas.

- **Banco de Dados:**
  - **MySQL & SQL Server:** O sistema está configurado para suportar ambos os bancos de dados relacionais.
  - **Maven:** Ferramenta de automação de build e gerenciamento de dependências do projeto.

## Estrutura do Projeto

O código é organizado seguindo as convenções do Spring Boot, separando as responsabilidades em pacotes bem definidos:

```
/src/main/java/com/sistemadecontroledefuncionario/
├── core/                     # Camada de negócio e acesso a dados
│   ├── cargo/
│   ├── centroDeCusto/
│   ├── config/
│   ├── recursosDeTi/
│   ├── requisicao/
│   ├── setor/
│   ├── usuario/
│   ├── utils/
│   └── vaga/
└── web/                      # Camada de apresentação (Controllers e DTOs)
    ├── admin/
    ├── cargo/
    ├── centroDeCusto/
    ├── recursoDeTi/
    ├── requisicao/
    ├── setor/
    ├── usuario/
    └── vagas/
```

- **`core`**: Contém toda a lógica de negócio, entidades JPA, repositórios para acesso ao banco de dados e serviços.
- **`web`**: Responsável pela exposição dos endpoints da aplicação. Contém os `Controllers` que recebem as requisições HTTP e os `DTOs` (Data Transfer Objects) para a troca de informações com o frontend.

## Desafios do Projeto

Durante o desenvolvimento, alguns desafios interessantes foram superados:

1.  **Modelagem de Dados Flexível:** Criar um esquema de banco de dados que suportasse diferentes tipos de requisições (pessoal, recursos de TI) e seus respectivos ciclos de vida, mantendo a integridade e a performance.
2.  **Controle de Acesso Baseado em Perfis (Role-Based Access Control):** Implementar um sistema de autenticação e autorização que permitisse diferentes níveis de acesso (Admin, Gestor, RH, Diretor), garantindo que cada usuário tivesse acesso apenas às funcionalidades e dados pertinentes ao seu perfil.
3.  **Arquitetura Multicamadas:** Desenhar e implementar uma arquitetura bem definida (Controller-Service-Repository) para garantir a separação de responsabilidades, facilitando a manutenção, a testabilidade e a escalabilidade do sistema.
4.  **Integração Frontend-Backend:** Garantir uma comunicação fluida entre o backend Spring e o frontend renderizado com Thymeleaf, utilizando DTOs para transferir dados de forma segura e eficiente.

## Endpoints da Aplicação

Abaixo estão listados os principais endpoints da aplicação, agrupados por funcionalidade:

### Administração
- `GET /admin`: Painel principal da administração.
- `GET /admin/config`: Página de configurações do sistema.

### Usuários
- `GET /usuarios/all`: Lista todos os usuários.
- `GET /usuarios`: Exibe o formulário para criar um novo usuário.
- `POST /usuarios`: Cria um novo usuário.
- `GET /usuarios/atualizar/{id}`: Exibe o formulário para atualizar um usuário.
- `POST /usuarios/atualizar/{id}`: Atualiza os dados de um usuário.
- `GET /usuarios/excluir/{id}`: Remove um usuário.
- `GET /usuarios/bloquear/{id}/{novoStatus}`: Altera o status de um usuário (ativo/bloqueado).
- `GET /usuarios/{id}/requisicoes`: Lista todas as requisições feitas por um usuário específico.

### Dashboards
- `GET /dashboard/gestor/{id}`: Exibe o dashboard específico para o perfil "Gestor".
- `GET /dashboard/rh/{id}`: Exibe o dashboard específico para o perfil "RH".
- `GET /dashboard/diretor/{id}`: Exibe o dashboard específico para o perfil "Diretor".

### Cargos
- `GET /cargos/criar`: Exibe o formulário para criar um novo cargo.
- `POST /cargos/criar`: Cria um novo cargo.

### Recursos de TI
- `GET /recurso-de-ti`: Lista todos os recursos de TI.
- `GET /recurso-de-ti/criar`: Exibe o formulário para criar um novo recurso.
- `POST /recurso-de-ti/criar`: Cria um novo recurso de TI.
- `GET /recurso-de-ti/atualizar/{id}`: Exibe o formulário para atualizar um recurso.
- `POST /recurso-de-ti/atualizar/{id}`: Atualiza um recurso de TI.
- `GET /recurso-de-ti/excluir/{id}`: Remove um recurso de TI.

### Requisições de Pessoal
- `GET /requisicao/criar`: Exibe o formulário para criar uma nova requisição de pessoal.
- `POST /requisicao/criar`: Cria uma nova requisição de pessoal.
![WhatsApp Image 2025-09-02 at 09 35 53](https://github.com/user-attachments/assets/12456e27-efe6-4111-a8ee-859e12b3aee9)
![WhatsApp Image 2025-09-02 at 09 35 53 (1)](https://github.com/user-attachments/assets/8289bdc2-5ba4-43e2-96b6-c0daeb345ef2)
![WhatsApp Image 2025-09-02 at 09 35 52](https://github.com/user-attachments/assets/c579d4eb-4f50-4616-8dd3-f0cf009b27a8)
![WhatsApp Image 2025-09-02 at 09 35 52 (4)](https://github.com/user-attachments/assets/7030a09c-7a06-4d03-ae20-e2b21fe25348)
![WhatsApp Image 2025-09-02 at 09 35 52 (3)](https://github.com/user-attachments/assets/19a8df69-88e1-444f-95a7-15485e02fd76)
![WhatsApp Image 2025-09-02 at 09 35 52 (2)](https://github.com/user-attachments/assets/1c6e4b0b-bd65-4e12-b907-a181f845fbe4)
![WhatsApp Image 2025-09-02 at 09 35 52 (1)](https://github.com/user-attachments/assets/bb57c7e0-84b5-4784-ab07-476a7aab2896)
<img width="1890" height="1063" alt="Captura de tela 2025-09-02 094145" src="https://github.com/user-attachments/assets/14b56485-6453-4303-a235-0ad3a7b6883f" />
<img width="1880" height="1070" alt="Captura de tela 2025-09-02 094128" src="https://github.com/user-attachments/assets/27da42ea-6e03-4b53-84ac-8a7282686b41" />
<img width="1903" height="848" alt="Captura de tela 2025-09-02 093247" src="https://github.com/user-attachments/assets/d78d0fc4-16ed-465d-acdb-0e62e7fba2db" />
<img width="1903" height="826" alt="Captura de tela 2025-09-02 093201" src="https://github.com/user-attachments/assets/995552f1-8269-4ad7-b100-f1cb8acc6eeb" />
<img width="1902" height="1078" alt="Captura de tela 2025-09-02 091823" src="https://github.com/user-attachments/assets/a9784076-4294-4d61-b6fa-05480a087a42" />
<img width="1910" height="1079" alt="Captura de tela 2025-09-02 091748" src="https://github.com/user-attachments/assets/c571824c-b7da-4134-85f9-db7a61945949" />
<img width="1901" height="1079" alt="Captura de tela 2025-09-02 091643" src="https://github.com/user-attachments/assets/e5bbb856-b26d-43c1-b29c-4e52cccd7aa0" />


