UI-autotests-task

Стек: Java 19, maven, junit5, selenium, allure, Jenkins

ОБъект тестирования лежит [здесь](https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager)

Реализованы:
- [тесты-кейсы](https://github.com/Idzanaagi/UI-autotests-task/blob/main/TestCases.txt) по чек-листу;
- [описание страниц](https://github.com/Idzanaagi/UI-autotests-task/tree/main/src/test/java/pages) по Page Object Model;
- сами [автотесты](https://github.com/Idzanaagi/UI-autotests-task/tree/main/src/test/java/tests);
- [параллельный запуск](https://github.com/Idzanaagi/UI-autotests-task/blob/20729aa997d94e0d0b649418d230c24759c7d359/pom.xml#L89-L92) тестов;
- [сборка и прогон тестов](https://github.com/Idzanaagi/UI-autotests-task/blob/main/.github/workflows/maven.yml) через GIthub Actions;
- и сборка, прогон тестов и формирование отчёта Allure в Jenkins, но он локальный, так что ссылоок не будет.

Установка и запуск (windows 11, IntelliJ IDEA):
- склонировать этот репозиторий;
- открыть проект в IDE;
- запустить все тесты (Shift+f10 или mvn clean test);
- или перейти в test/java/tests/, выбрать понравившийся тест и запустить его.

Сформировать отчёт allure (powershell):
```
mvn clean test
allure generate --clean
allure open
```
