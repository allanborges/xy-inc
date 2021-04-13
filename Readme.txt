
Foi usado um web service com a implementação  RESTful(JAX-RS essa é a especificação) juntamente com o TOMCAT7 , com a implementação JERSEY.Para a persistência, usei JPA+Hibernate.

---
Instruções de ambiente:
---

importar o projeto no eclipse, usando o plugin do maven.
File -> import- > maven -> Existing Maven Project

o SGBD usado foi o MYSQL
criar a base XYInc
Configurar o arquivo Persistence.xml com seus dados do banco,

deixe a linha a seguir como create para criar a tabela de inicio, depois troque para "update"
<property name="hibernate.hbm2ddl.auto" value="create" />


---
Usando a aplicação:
---

para cadastrar deverá fazer uma requisição POST para a url http://localhost:8080/xyimp2/poi/salva, recomendo usar o CURL ou algum plugin do chrome ou firefox que simule a requisição

exemplo de inserções usando o CURL:

curl -X POST -H 'Content-type:text/xml' -d '<poIDto>
<coorX>31</coorX>
<coorY>18</coorY>
<nome>Posto</nome>
</poIDto>'  http://localhost:8080/xyimp2/poi/salva


curl -X POST -H 'Content-type:text/xml' -d '<poIDto>
<coorX>15</coorX>
<coorY>12</coorY>
<nome>Joalheria</nome>
</poIDto>'  http://localhost:8080/xyimp2/poi/salva


para listar os POIS : http://localhost:8080/xyimp2/poi/listar


listar por proximidade deverá passar os parametros das coordenadas e a distancia maxima, conforme a URL de exemplo abaixo:

http://localhost:8080/xyimp2/poi/listarPorProximidade?x=20&y=10&distancia=10










