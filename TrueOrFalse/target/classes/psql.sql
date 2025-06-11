
CREATE TABLE questions (
                           id SERIAL PRIMARY KEY,
                           text TEXT NOT NULL,
                           answer BOOLEAN NOT NULL

);

INSERT INTO questions (text, answer) VALUES
                                         ('The sun rises in the west.', false),
                                         ('Water boils at 100°C.', true),
                                         ('Java is a type of coffee.', true),
                                         ('The Eiffel Tower is located in Germany.', false),
                                         ('Python is older than Java.', false),
                                         ('Is the sky blue?', true),
                                         ('Is the sky green?', false),
                                         ('50 + 2 = 25', false),
                                         ('Are spiders insects?', false);