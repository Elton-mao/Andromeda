USE Andromeda;

CREATE TABLE Setor(
    id VARCHAR(36) PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE Usuarios (
    id VARCHAR(36) PRIMARY KEY,
    login VARCHAR(50) NOT NULL UNIQUE,
    nome_completo VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    senha VARCHAR(50) NOT NULL,
    perfil_de_acesso VARCHAR(50) NOT NULL,
    status_do_usuario VARCHAR(50) NOT NULL,
    setor_id VARCHAR(36) NOT NULL,
    CONSTRAINT FK_usuario_setor FOREIGN KEY (setor_id) REFERENCES Setor(id)
);

CREATE TABLE Requisicao (
    id VARCHAR(36) PRIMARY KEY,
    data_criacao DATETIME NOT NULL,
    solicitante_id VARCHAR(36) NOT NULL,
    status_da_requisicao VARCHAR(20) NOT NULL,
    tipo_de_solicitacao VARCHAR(50) NOT NULL,
    prioridade VARCHAR(20) NOT NULL,
    numero_requisicao INT NOT NULL AUTO_INCREMENT UNIQUE,
    CONSTRAINT FK_usuario_solicitacao FOREIGN KEY (solicitante_id) REFERENCES Usuarios(id)
);

CREATE TABLE Centro_de_custo (
    id VARCHAR(36) PRIMARY KEY,
    codigo VARCHAR(10) NOT NULL UNIQUE,
    nome VARCHAR(100) NOT NULL UNIQUE,
    descricao VARCHAR(200)
);

CREATE TABLE Requisicao_de_pessoal (
    id VARCHAR(36) PRIMARY KEY,
    data_limite_contratacao DATE NOT NULL,
    quantidade_vagas INT NOT NULL,
    data_aprovacao DATETIME,
    motivo_da_requisicao VARCHAR(50) NOT NULL,
    requisicao_ti_id VARCHAR(36),
    centro_de_custo_id VARCHAR(36) NOT NULL,
    CONSTRAINT FK_requisicao_pessoal_requisicao FOREIGN KEY (id) REFERENCES Requisicao(id),
    CONSTRAINT FK_Requisicao_de_pessoal_Centro_custo FOREIGN KEY (centro_de_custo_id) REFERENCES Centro_de_custo(id)
);

CREATE TABLE Cargos(
    id VARCHAR(36) PRIMARY KEY,
    titulo_do_cargo VARCHAR(50) NOT NULL,
    salario DECIMAL(10,2) NOT NULL
);

CREATE TABLE Vagas (
    id VARCHAR(36) PRIMARY KEY,
    requisicao_id VARCHAR(36) NOT NULL,
    cargo_id VARCHAR(36) NOT NULL,
    tipo_contrato VARCHAR(20) NOT NULL,
    turno_trabalho VARCHAR(20) NOT NULL,
    escolaridade VARCHAR(20) NOT NULL,
    isalubridade VARCHAR(50) NOT NULL,
    cnh_requerida VARCHAR(3) NOT NULL,
    pos_requerida VARCHAR(3) NOT NULL,
    competencias_tecnicas VARCHAR(255),
    status VARCHAR(20) NOT NULL,
    CONSTRAINT FK_vaga_solicitacao FOREIGN KEY (requisicao_id) REFERENCES Requisicao_de_pessoal(id),
    CONSTRAINT FK_CARGO_VAGA FOREIGN KEY (cargo_id) REFERENCES Cargos(id)
);

CREATE TABLE Recurso_de_ti (
    id VARCHAR(36) PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descricao VARCHAR(200),
    ativo TINYINT(1) NOT NULL DEFAULT 1,
    categoria VARCHAR(50) NOT NULL
);

CREATE TABLE Requisicao_de_recurso_ti (
    id VARCHAR(36) PRIMARY KEY,
    data_aprovacao DATETIME,
    CONSTRAINT FK_requisicao_recurso FOREIGN KEY (id) REFERENCES Requisicao(id)
);

CREATE TABLE Requisicao_ti_recursos (
    requisicao_id VARCHAR(36) NOT NULL,
    recurso_id VARCHAR(36) NOT NULL,
    PRIMARY KEY (requisicao_id, recurso_id),
    CONSTRAINT FK_requisicao_ti FOREIGN KEY (requisicao_id) REFERENCES Requisicao_de_recurso_ti(id),
    CONSTRAINT FK_recurso_ti FOREIGN KEY (recurso_id) REFERENCES Recurso_de_ti(id)
);

ALTER TABLE Requisicao_de_pessoal
ADD CONSTRAINT fk_requisicao_ti_requisicao_pessoal
FOREIGN KEY (requisicao_ti_id) REFERENCES Requisicao_de_recurso_ti(id);
