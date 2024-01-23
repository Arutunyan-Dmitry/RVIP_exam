CREATE TABLE t_task (
                     id INTEGER PRIMARY KEY UNIQUE NOT NULL,
                     body VARCHAR(255) NOT NULL,
                     is_Sent BOOLEAN,
                     error VARCHAR,
                     created VARCHAR(255) NOT NULL
);
CREATE TABLE t_log (
                     id INTEGER PRIMARY KEY UNIQUE NOT NULL,
                     body VARCHAR(255) NOT NULL,
                     is_Done BOOLEAN,
                     error VARCHAR,
                     received VARCHAR(255) NOT NULL
);