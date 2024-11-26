-- Insert data into Location table
INSERT INTO location (address, city, state, postal_code, country)
VALUES
('Rua Visconde do Rio Branco, 123', 'Municipio de São Joaquim da Barra', 'SP', '14600-000', 'Brazil'),
('Rua Avenida Anhanguera, 456', 'Municipio de Espirito Santo do Pinhal', 'SP', '13950-000', 'Brazil'),
('Rua Boa Vista, 789', 'Municipio de Divinolândia', 'SP', '13650-000', 'Brazil'),
('Rua São Luiz, 321', 'Municipio de Santo Antônio do Pinhal', 'SP', '13940-000', 'Brazil'),
('Rua Bento de Abreu, 901', 'Municipio de Ribeirão Preto', 'SP', '14015-130', 'Brazil');

-- Insert data into Merchant table
INSERT INTO merchant (name, phone_number, email, website, location_id)
VALUES
('Tocaya Café', '55 16 99111-1111', 'contato@tocaya.com.br', 'https://tocaya.com.br', 1),
('Sitio da Cachoeirinha', '55 19 99888-2222', 'cachoeirinha@sitiodacachoeirinha.com.br', 'https://sitiodacachoeirinha.com.br', 2),
('Fazenda dos Sonhos', '55 11 94444-3333', 'contato@fazendadossonhos.com.br', 'https://fazendadossonhos.com.br', 3),
('Café do Ponto', '55 12 93333-4444', 'contato@cafedoponto.com.br', 'https://cafedoponto.com.br', 4),
('Bom Cafe', '55 13 92222-5555', 'contato@bomcafe.com.br', 'https://bomcafe.com.br', 5);

-- Insert data into Product table
INSERT INTO product (name, description, price, merchant_id)
VALUES
('Café especial da Cachoeirinha', 'Grão de café torrado no lenheiro, 100% arábica', 49.90, 2),
('Café com notas de frutas', 'Grão de café com notas de frutas vermelhas e florais', 59.90, 2),
('Café do Sitio', 'Café produzido na fazenda, com sabor intenso e acidez suave', 69.90, 2),
('Café Gourmet', 'Café produzido com grãos de alta qualidade, torrado ao ponto', 79.90, 1),
('Café com chocolate', 'Café com notas de chocolate, produzido com leite de cabra e cacau', 89.90, 1),
('Café com leite de cabra', 'Café com leite de cabra, produzido com grãos de alta qualidade', 99.90, 1),
('Café com fubá', 'Café com fubá, produzido com grãos de alta qualidade e fubá de milho', 49.90, 3),
('Café com coco', 'Café com coco, produzido com grãos de alta qualidade e coco ralado', 59.90, 3),
('Café com amendoim', 'Café com amendoim, produzido com grãos de alta qualidade e amendoim torrado', 69.90, 3),
('Café com baunilha', 'Café com baunilha, produzido com grãos de alta qualidade e baunilha natural', 79.90, 3);
