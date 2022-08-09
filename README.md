Есть таблица products в SQL базе. В ней миллионы строк. С полями: id (целое число), name(строка до 100 символов), description(строка до 1000 символов). Все поля не могут быть пустыми.
Написать REST сервис shop с ресурсом
/shop/product?nameFilter=val

Запрос к product должен возвращать контакты из таблицы БД products. Параметр nameFilter обязателен. В него передается регулярное выражение. В возвращаемых данных не должно быть записей, в которых products.name совпадает с регулярным выражением.

Массив контактов возвращается в json формате
Фильтр обязательно применять в java коде, не использовать возможности SQL.

Пример запросов
/shop/product?nameFilter=^E.*$ - возвращает контакты, которые НЕ начинаются с E
/shop/product?nameFilter=^.*[eva].*$ - возвращает контакты, которые НЕ содержат букв e, v, a


●	В реализации обязательно учитывать огромное предполагаемое количество контактов и то, что легко написать фильтр, который возвращает их все.
●	Учитывать, что сервис должен быть готов одновременно обрабатывать множество запросов.
●	SQL БД можно использовать любую, предпочтительно PostgreSQL.
●	Сервис хотелось бы увидеть на Spring Boot.
●	Коды ошибок HTTP использовать типичные для REST сервисов.
●	Сборка maven
●	Наличие тестов
●	README или любой другой файл в репозитории не должен содержать текст задания.