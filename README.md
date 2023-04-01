UI-autotests-task

Стек: Java 19, maven, junit5, selenium, allure

Структура проекта:
- ./TestCases.txt - тест-кейсы
- src/test/java/pages/ - описание тестируемых страниц
- src/test/java/tests/ - тесты
- src/test/java/utils/ - хелперы

Реализовано:
- подробные тест-кейсы по чек-листу
- автотесты
- отчёты Allure 
- параллельный запуск тестов
- запуск в CI/CD

Сформировать отчёт allure (powershell):
```
mvn clean test
allure generate --clean
allure open
```
