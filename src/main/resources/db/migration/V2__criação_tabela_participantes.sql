CREATE TABLE participantes (
    id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    esta_cofirmado BOOLEAN NOT NULL,
    viagem_id UUID,
    FOREIGN KEY (viagem_id) REFERENCES viagem (id)
    );
