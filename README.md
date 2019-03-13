# API-EscolaEmCasaGames

### ENTIDADES
|ENTIDADE|DADOS|
|--------|-----|
|[ALUNO](EscolaEmcasaGames/src/main/java/com/example/demo/domain/Aluno.java)|(id, nome, email, idCurso)|
|[ADMIN](EscolaEmcasaGames/src/main/java/com/example/demo/domain/Admin.java)|(id, login, usuario, senha)|
|[CURSO](EscolaEmcasaGames/src/main/java/com/example/demo/domain/Curso.java)|(id, nome, alunos, lms, urlMls)|
|[DISCIPLINA](EscolaEmcasaGames/src/main/java/com/example/demo/domain/Disciplina.java)|(id, anoEnsino, disciplina)|
|[GAME](EscolaEmcasaGames/src/main/java/com/example/demo/domain/Game.java)|(id, nome, disciplina, link, icone, reputacao, gamePlay, comentarios, resumo)|
|[GAMESAVE](EscolaEmcasaGames/src/main/java/com/example/demo/domain/GameSave.java)|(id, game, aluno, gameID, alunoID, pontuacao, tempo, data)|
|[LMS](EscolaEmcasaGames/src/main/java/com/example/demo/domain/LMS.java)|(id, url, nome, cursos)|

### URL BASE LOCAL
```bash
http://localhost:8080/
```
#### ALUNOS

|METODO|DESCRICAO|URL|DADOS|
|------|---------|---|-----|
|GET   |Recuperar alunos|URL BASE + /alunos|
|GET   |Recuperar aluno por ID|URL BASE + /alunos/{id}|
|POST   |Salvar aluno|URL BASE + /alunos|[Enviar aluno](EscolaEmcasaGames/src/main/java/com/example/demo/domain/Aluno.java)|
|DELETE   |Remover aluno|URL BASE + /alunos/{id}|

#### ADMIN

|METODO|DESCRICAO|URL|DADOS|
|------|---------|---|-----|
|GET   |Recuperar admin|URL BASE + /admin|
|GET   |Recuperar admin por ID|URL BASE + /admin/{id}|
|POST   |Salvar admin|URL BASE + /admin|[Enviar admin](EscolaEmcasaGames/src/main/java/com/example/demo/domain/Admin.java)|
|DELETE   |Remover admin|URL BASE + /admin/{id}|

#### CURSO

|METODO|DESCRICAO|URL|DADOS|
|------|---------|---|-----|
|GET   |Recuperar cursos|URL BASE + /cursos|
|GET   |Recuperar curso por ID|URL BASE + /cursos/{id}|
|POST   |Salvar curso|URL BASE + /cursos|[Enviar curso](EscolaEmcasaGames/src/main/java/com/example/demo/domain/Curso.java)|
|DELETE   |Remover curso|URL BASE + /cursos/{id}|

#### DISCIPLINA

|METODO|DESCRICAO|URL|DADOS|
|------|---------|---|-----|
|GET   |Recuperar disciplinas|URL BASE + /disciplinas|
|GET   |Recuperar disciplina por ID|URL BASE + /disciplinas/{id}|
|POST   |Salvar disciplina|URL BASE + /disciplinas|[Enviar disciplina](EscolaEmcasaGames/src/main/java/com/example/demo/domain/Disciplina.java)|
|DELETE   |Remover disciplina|URL BASE + /disciplinas/{id}|

#### GAME

|METODO|DESCRICAO|URL|DADOS|
|------|---------|---|-----|
|GET   |Recuperar jogos|URL BASE + /games|
|GET   |Recuperar jogo por ID|URL BASE + /games/{id}|
|POST   |Salvar jogo|URL BASE + /games|[Enviar game](EscolaEmcasaGames/src/main/java/com/example/demo/domain/Game.java)|
|DELETE   |Remover jogo|URL BASE + /games/{id}|

#### GAMESAVED

|METODO|DESCRICAO|URL|DADOS|
|------|---------|---|-----|
|GET   |Recuperar saves dos jogos|URL BASE + /gamesSaved|
|GET   |Recuperar saves por ID|URL BASE + /gamesSaved/{id}|
|POST   |Salvar saves|URL BASE + /gamesSaved|[Enviar gameSave](EscolaEmcasaGames/src/main/java/com/example/demo/domain/GameSave.java)|
|DELETE   |Remover saves|URL BASE + /gamesSaved/{id}|

#### LMS

|METODO|DESCRICAO|URL|DADOS|
|------|---------|---|-----|
|GET   |Recuperar LMS|URL BASE + /lms|
|GET   |Recuperar LMS por URL|URL BASE + /lms/{url}|
|POST   |Salvar LMS|URL BASE + /lms|[Enviar lms](EscolaEmcasaGames/src/main/java/com/example/demo/domain/LMS.java)|
|DELETE   |Remover LMS|URL BASE + /lms/{id}|
