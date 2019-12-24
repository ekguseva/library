<!DOCTYPE html>
<html lang="RU" >
<head>
    <meta charset="utf-8">
    <title>Вход в систему</title>
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
            border: 0px ; /* Рамка */
            margin: auto;
        }
    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body bgcolor="#e6f3f8">
<h1 class="nameOfPage">Авторизация</h1>
<form action="/login" method="post">
    <div class="outline">
        <p></p>
    <div><label><b> Имя пользователя: </b><input type="text" name="username" placeholder="Введите свой логин" size="38"/> </label></div>
    <div><label><b> Пароль: </b><input type="password" name="password" placeholder="Введите свой пароль" size="51"/> </label></div>
        <p></p>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </div>
    <div class="additional_data">
        <a href="/registration" class="btn btn-link">Зарегистрироваться</a>
        <input type="submit" class="btn btn-primary" value="Войти"/>
    </div>
</form>

</body>
</html>