UI-autotests-task

Стек: Java 19, maven, junit5, selenium, allure, Jenkins

Объект тестирования лежит [здесь](https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager)

Реализованы:
- [тесты-кейсы](https://github.com/Idzanaagi/UI-autotests-task/blob/main/TestCases.txt) по чек-листу;
- [описание страниц](https://github.com/Idzanaagi/UI-autotests-task/tree/main/src/test/java/pages) по Page Object Model;
- сами [автотесты](https://github.com/Idzanaagi/UI-autotests-task/tree/main/src/test/java/tests);
- [параллельный запуск](https://github.com/Idzanaagi/UI-autotests-task/blob/20729aa997d94e0d0b649418d230c24759c7d359/pom.xml#L89-L92) тестов;
- [сборка и прогон тестов](https://github.com/Idzanaagi/UI-autotests-task/blob/main/.github/workflows/maven.yml) через GIthub Actions;
- и сборка, прогон тестов и формирование отчёта Allure в Jenkins:

![ui-allure](https://user-images.githubusercontent.com/87720620/231713497-8a2fad43-64ef-48a8-bd06-78586a3f7818.png)

Сформировать отчёт allure (powershell):
```
mvn clean test
allure generate --clean
allure open
```
