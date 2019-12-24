<!DOCTYPE html>
<html lang="RU">
<head>
    <meta charset="utf-8">
    <title>Список взятых книг библиотеки</title>
    <style>
        .nameOfPage {
            text-align:  center;
            color: #4682B4;
        }
        .filter {
            text-align: center;
            margin-bottom: 10px;
        }
        table {
            width: 1500px; /* Ширина таблицы */
            border: 3px solid #4682B4; /* Рамка вокруг таблицы */

            margin: auto; /* Выравниваем таблицу по центру окна  */
            text-align: center;
        }
        td, th{
            padding: 3px; /* Поля вокруг содержимого таблицы */
            border: 1px solid #4682B4; /* Параметры рамки */
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
            <li class="nav-item">
                <a class="nav-link" href="/books">Список книг</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/issuedBooks">Список выданных книг</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/statistics">Статистика</a>
            </li>
        </ul>
    </div>

    <form action="/logout" method="post">
        <button type="submit" class="btn btn-secondary">Выйти</button>
        <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
    </form>
</nav>
<h1 class="nameOfPage">Статистика по информационной системе</h1>
<table>
    <tr>
        <th>Метрика</th><th>Количество</th>
    </tr>
    <tr>
        <td>Количество книг в библиотеке</td>
        <td>
            <#list book as bcount>
                ${bcount}
            </#list>
        </td>
    </tr>
    <tr>
        <td>Количество экземпляров книг</td>
        <td>
            <#list bookCopies as bcount>
                ${bcount}
            </#list>
        </td>
    </tr>
    <tr>
        <td>Количество выданных книг</td>
        <td>
            <#list issuedBook as bcount>
                ${bcount}
            </#list>
        </td>
    </tr>
    <tr>
        <td>Количество выданных книг, которые не вернули</td>
        <td>
            <#list issuedBookIsNotReturned as bcount>
                ${bcount}
            </#list>
        </td>
    </tr>
    <tr>
        <td>Количество читателей</td>
        <td>
            <#list reader as bcount>
                ${bcount}
            </#list>
        </td>
    </tr>
    <tr>
        <td>Количество сотрудников</td>
        <td>
            <#list employee as bcount>
                ${bcount}
            </#list>
        </td>
    </tr>
</table>
</body>
</html>