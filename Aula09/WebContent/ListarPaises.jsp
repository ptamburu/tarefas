<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Buscar Paises</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">

        </head>

        <body>
            <!-- Barra superior com os menus de navegação -->
			<c:import url="Menu.jsp"/>
            <!-- Container Principal -->
            <div id="main" class="container">
                <form action="listarPaises.do" method="post">
                    <div id="top" class="row">
                        <div class="col-md-3">
                            <h2>Paises</h2>
                        </div>

                        <div class="col-md-6">
                            <div class="input-group h2">
                                <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Paises (deixe vazio para trazer todos)">
                                <span class="input-group-btn">
                <button class="btn btn-primary" type="submit" name="acao" value="buscar">
                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                                </span>
                            </div>
                        </div>

                        <div class="col-md-3">
                            <a href="CriarPais.jsp" class="btn btn-primary pull-right h2">Novo Pais</a>
                        </div>
                    </div>
                    <!-- /#top -->
                </form>
                <hr />
                <c:if test="${not empty lista}">
                <div id="list" class="row">

                    <div class="table-responsive col-md-12">
                        <table class="table table-striped" cellspacing="0" cellpadding="0">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>Populacao</th>
                                    <th>Area</th>
                                    <th class="actions">Ações</th>
                                </tr>
                            </thead>
                            <tbody>
          					<c:forEach var="pais" items="${lista}">
                                       <tr>
                                            <td>
                                               ${pais.id}
                                            </td>
                                            <td>
                                                ${pais.nome}
                                            </td>
                                            <td>
                                                ${pais.populacao}
                                            </td>
                                            <td>
                                                ${pais.area}
                                            </td>
                                            <td class="actions">
                                                <a class="btn btn-success btn-xs" href="ManterPais.do?acao=Visualizar&id=${pais.id }&nome=${pais.nome}&populacao=${pais.populacao }&area=${pais.area}">Visualizar</a>
                                                <a class="btn btn-warning btn-xs" href="ManterPais.do?acao=Editar&id=${pais.id}&nome=${pais.nome}&populacao=${pais.populacao }&area=${pais.area}">Editar</a>
                                                <a class="btn btn-danger btn-xs" href="ManterPais.do?acao=Excluir&id=${pais.id}&nome=${pais.nome}&populacao=${pais.populacao }&area=${pais.area}">Excluir</a>
                                            </td>
                                        </tr>
                            </c:forEach>

                            </tbody>
                        </table>

                    </div>
                </div>
                <!-- /#list -->

                <div id="bottom" class="row">
                    <div class="col-md-12">
                        <!-- paginação ainda não foi implementada -->
                        <ul class="pagination">
                            <li class="disabled"><a>&lt; Anterior</a>
                            </li>
                            <li class="disabled"><a>1</a>
                            </li>
                            <li><a href="#">2</a>
                            </li>
                            <li><a href="#">3</a>
                            </li>
                            <li class="next"><a href="#" rel="next">Próximo &gt;</a>
                            </li>
                        </ul>
                        <!-- /.pagination -->
                    </div>
                </div>
                </c:if>
                <!-- /#bottom -->
            </div>
            <!-- /#main -->
            <script src="js/jquery.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
        </body>

        </html>