[![Typing SVG](https://readme-typing-svg.herokuapp.com?size=35&color=C54DF7FF&lines=Сервер+прогноза+погоды)](https://git.io/typing-svg)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)

Весь пакет состоит из двух частей:
- Клиентская десктопная часть.
- Серверная API часть *(текущий пакет)*;

***

<h3>Клиентская чать</h3>
Для работы с текущим API используется десктопный [***клиент***][client].
<br>

***

<h3>Серверная часть</h3>
Сервер принимает GET запросы от *клиентской части* двух типов:
* Civil 
* Civil light

В качестве **headers** передаются координаты долготы и широты города, по которому необходимо сделать получить прогноз погоды 

После чего, отправляет соответствующий запрос на API сервер [***7Times***][7times_server], который отвечает json пакетом данных.
Сервер его сериализует в DTO и отправляет клиенту.

В качестве порта по умолчаю указан 9090 в **application.properties**:
<br><code>
server.port=9090
</code>

В планах доделать работу еще по друм вариантам запроса:
* Astro (7Times)
* Yandex Weather

Так же, необходимо сделать unit тесты на все классы.

[client]: https://github.com/SergeyMazurtsev/Simple_Weather_Forecast "Клиентская часть"
[7times_server]: http://www.7timer.info