<!DOCTYPE html>
<html lang="RU" >
<head>
    <title>Регистрация</title>
    <style>
        .nameOfPage {
            color: #4682B4;
            text-align:  center;
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
            border: 0px ; /* Рамка */
            margin: auto;
        }
    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<h1 class="nameOfPage">Регистрация</h1>
<form action="/registration" method="post">
    <div class="outline">
        <p></p>
    <div><label> Логин: <input type="text" name="username" size="38"/> </label></div>
    <div><label> Пароль: <input type="password" name="password" size="37"/> </label></div>
        <p></p>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </div>
    <div class="additional_data"><input class="btn btn-primary" type="submit" value="Зарегистрироваться"/></div>
</form>
</body>
</html>