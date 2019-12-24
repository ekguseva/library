<!DOCTYPE html>
<html lang="RU">
<head>
    <meta charset="utf-8">
    <title>Список книг библиотеки</title>
    <style>
        .nameOfPage {
            text-align:  center;
            color: #4682B4;
        }
        .filter {
            text-align:  center;
            margin-bottom: 10px;
        }
        table {
            width: 1500px; /* Ширина таблицы */
            border: 3px solid #4682B4; /* Рамка вокруг таблицы */
            margin: auto; /* Выравниваем таблицу по центру окна  */
            text-align: center; /* Выравниваем текст по центру ячейки */
        }
        td {
            text-align: center; /* Выравниваем текст по центру ячейки */
        }
    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body bgcolor="#e6f3f8">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">ИС "Библиотека"</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/books">Список книг</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/issuedBooks">Список выданных книг</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/statistics">Статистика</a>
            </li>
        </ul>
    </div>

    <form action="/logout" method="post">
        <button type="submit" class="btn btn-secondary">Выйти</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </form>
</nav>
<form  method="get" action="/books">
    <button type="submit" class="btn btn-outline-primary">Сбросить</button>
</form>
<h1 class="nameOfPage">Список книг</h1>
<form  method="get" action="/books" class="filter">
    <input type="text" name="nameFilter" placeholder="Название"/>
    <input type="text" name="authorFilter" placeholder="Автор"/>
    <input type="text" name="genreFilter" placeholder="Жанр"/>
    <button type="submit" class="btn btn-primary">Найти</button>
</form>
    <table border="1">
        <tr>
            <th>ISBN</th>
            <th>Название</th>
            <th>Автор</th>
            <th>Жанр</th>
            <th>Издательство</th>
            <th>Дата издания</th>
            <th>Количество</th>
            <th>Выдача книги</th>
        </tr>
        <#list books as book>
            <div>
                <tr>
                    <td>${book.ISBN}</td>
                    <td>${book.name}</td>
                    <td>${book.author.name}</td>
                    <td>${book.genre.name}</td>
                    <td>${book.publishing.name}</td>
                    <td>#{book.yearOfPublication}</td>
                    <td>${book.numberOfAvailable}</td>
                    <td>
                        <#if book.numberOfAvailable gt 0>
                            <form method="get" action="/giveCurrentBook">
                                <input type="hidden" name="bookID" value="#{book.bookID}"/>
                                <button type="submit" class="btn btn-light">Выдать</button>
                            </form>
                        <#else>
                            <button type="submit" class="btn btn-light" disabled>Выдать</button>
                        </#if>
                    </td>
                </tr>
            </div>
        <#else>
            Книг по запросу не найдено
        </#list>
    </table>
</body>
</html>