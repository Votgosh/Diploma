# Дипломный проект профессии «Тестировщик»

Дипломный проект представляет собой автоматизацию тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка.

## Описание приложения

### Бизнес часть

Приложение представляет из себя веб-сервис.

![](pic/service.png)

Приложение предлагает купить тур по определённой цене с помощью двух способов:
1. Обычная оплата по дебетовой карте
1. Уникальная технология: выдача кредита по данным банковской карты

Само приложение не обрабатывает данные по картам, а пересылает их банковским сервисам:
* сервису платежей (далее - Payment Gate)
* кредитному сервису (далее - Credit Gate)


### Техническая часть

Само приложение расположено в файле [`aqa-shop.jar`](aqa-shop.jar) и запускается стандартным способом `java -jar aqa-shop.jar` на порту 8080.

В файле [`application.properties`](application.properties) приведён ряд типовых настроек:
* учётные данные и url для подключения к СУБД
* url-адреса банковских сервисов

### СУБД

Заявлена поддержка двух СУБД (вы это должны проверить):
* MySQL
* PostgreSQL

Учётные данные и url для подключения задаются в файле [`application.properties`](application.properties).

## Задача

Автоматизация позитивных и негативных сценариев покупки тура.

## Документация

[Дипломное задание](https://github.com/netology-code/qa-diploma.git)

[План автоматизации тестирования веб-формы сервиса покупки туров интернет-банка](docs/Plan.md)

[Отчёт о проведенном тестировании](docs/Report.md)

[Отчёт о проведённой автоматизации](docs/Summary.md)

## Запуск приложения

## Предварительно установленные компоненты:
* IntelliJ IDEA Community Edition 2021.3.2
* Docker Desktop 

## Загруженные docker container images:
* mysql:latest
* postgres:latest
* gate-simulator:1.0
#### Команды для скачивания образов:
##### Скачать MySql image:
    docker pull mysql:latest
    
##### Скачать PostgreSql image:
    docker pull postgres:latest

### Подключение SUT к MySQL

1. Запустить Docker Desktop
1. Открыть проект в IntelliJ IDEA
1. В терминале в корне проекта запустить контейнеры:

   `docker-compose up -d`
1. Запустить приложение:

   `java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar`
1. Открыть второй терминал
1. Запустить тесты:

   `.\gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app"`
1. Создать отчёт Allure и открыть в браузере

   `.\gradlew allureServe`
1. Закрыть отчёт:

   **CTRL + C -> y -> Enter**
1. Перейти в первый терминал
1. Остановить приложение:

   **CTRL + C**
1. Остановить контейнеры:

   `docker-compose down`
   </a>
### Подключение SUT к PostgreSQL

1. Запустить Docker Desktop
1. Открыть проект в IntelliJ IDEA
1. В терминале в корне проекта запустить контейнеры:

   `docker-compose up -d`
1. Запустить приложение:

   `java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar`
1. Открыть второй терминал
1. Запустить тесты:

   `.\gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app"`
1. Создать отчёт Allure и открыть в браузере

   `.\gradlew allureServe`
1. Закрыть отчёт:

   **CTRL + C -> y -> Enter**
1. Перейти в первый терминал
1. Остановить приложение:

   **CTRL + C**
1. Остановить контейнеры:

   `docker-compose down`
   </a>