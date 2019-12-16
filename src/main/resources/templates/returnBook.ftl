<!DOCTYPE html>
<html lang="RU">
<head>
    <meta charset="utf-8">
    <title>Список книг библиотеки</title>
    <style>
        .nameOfPage {
            color: #4682B4;
            text-align:  center;
        }
        .filter {
            text-align:  center;
            margin-bottom: 10px;
        }
        .outline {
            padding: 0 10px;
            width: 480px; /* Ширина таблицы */
            border: 3px solid #4682B4; /* Рамка */
            margin: auto; /* Выравниваем таблицу по центру окна  */
        }
        .additional_data {
            padding: 10px 10px 10px;
            width: 500px;
            border: 0px; /* Рамка */
            margin: auto;
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
        </ul>
    </div>
    <form action="/logout" method="post">
        <button type="submit" class="btn btn-secondary">Выйти</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </form>
</nav>
<form method="get" action="/issuedBooks" >
    <button type="submit" class="btn btn-secondary">Назад</button>
</form>
<h1 class="nameOfPage">Возврат книги</h1>
<div class="outline">
    <p><b>ISBN:</b>  ${issuedBook.book.ISBN}</p>
    <p><b>Название:</b>  ${issuedBook.book.name}</p>
    <p><b>Автор:</b>  ${issuedBook.book.author.name}</p>
    <p><b>Жанр:</b>   ${issuedBook.book.genre.name}</p>
    <p><b>Издательство:</b>   ${issuedBook.book.publishing.name}</p>
    <p><b>Дата:</b>   ${issuedBook.book.yearOfPublication}</p>
    <p><b>Читатель:</b>   ${issuedBook.reader.fullName}</p>
</div>
<form class="additional_data" method="get" action="/returnBook" >
    <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
    <button type="submit" class="btn btn-primary btn-lg btn-block" name="issueID" value="${issuedBook.issueID}">Подтвердить</button>
</form>
</body>
</html>