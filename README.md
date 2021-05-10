### API REST Google Keep

Implementação de uma API REST com recursos similares ao aplicativo de anotações _Google Keep_. A API foi desenvolvida com o objetivo de praticar conhecimentos adquiridos. Foram utilizadas as seguintes tecnologias:

- Java
- Apache Maven
- Spring Boot 
- Spring Web
- Spring Data JPA
- Spring Security
- MySQL

![image](https://user-images.githubusercontent.com/62680318/112052285-b4541600-8b31-11eb-88e7-7c5efab0e20e.png)

Os usuários possuem email e senha. Já as notas possuem os seguintes atributos:
- Título (String)
- Texto (String)
- Cor da nota (Enumerated)
- Marcador (String)
- Fixar (Boolean): se a nota deve ser fixada no topo da página ou não.
- Data de criação (LocalDateTime)
- Usuário

Para a segurança da API foi utilizado o Spring Security. De acordo com o padrão REST, foi implementada a autenticação stateless por meio da especificação JSON web token (JWT).
