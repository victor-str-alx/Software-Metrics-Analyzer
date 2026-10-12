# Software Metrics Analyzer (PAOO - P1)

## Descriere succinta
Aplicatia implementeaza o arhitectura extensibila pentru analiza automata a metricilor software colectate din surse multiple (Git, Jira, SonarQube). Solutia este modulara si permite adaugarea facila de surse noi, strategii noi de analiza si noi mecanisme de notificare.

## Functionalitati
- Colectare de metrici din surse multiple printr-o interfata comuna (`MetricsSource`).
- Instantiere dinamica a surselor printr-un factory extensibil (`MetricsSourceFactory`).
- Alegerea algoritmului de analiza prin strategie (`AnalysisStrategy`).
- Generare raport agregat (`MetricReport`) pe baza datelor colectate.
- Notificare observatori la generarea raportului (`ReportPublisher` + `ReportObserver`).

## Rulare aplicatie
Cerinte:
- Java 17+
- Maven 3.9+

Comenzi:
```bash
cd "JAVA APP"
mvn clean compile
mvn exec:java -Dexec.mainClass="ro.paoo.exam.Main"
```

Alternativ (fara plugin exec):
```bash
cd "JAVA APP"
mvn clean package
java -cp target/classes ro.paoo.exam.Main
```

## Design patterns folosite si motivatia
- **Factory Method / Simple Factory** (`MetricsSourceFactory`)
  - Izoleaza logica de creare a surselor de metrici.
  - Face simpla adaugarea unei noi surse fara modificari in client.
- **Strategy** (`AnalysisStrategy`, `SumAnalysisStrategy`, `RiskAnalysisStrategy`)
  - Permite schimbarea algoritmului de analiza fara a afecta serviciul principal.
  - Respecta extensibilitatea ceruta pentru rapoarte diferite.
- **Observer** (`ReportPublisher`, `ReportObserver`, `ConsoleReportObserver`)
  - Decupleaza generarea raportului de reactiile la raport (logging, notificari, export etc.).
  - Permite adaugarea unor observatori noi fara schimbari in fluxul principal.

## Principiile SOLID - unde sunt aplicate
- **S - Single Responsibility Principle**
  - `MetricsAnalysisService`: orchestration analiza.
  - `MetricsSourceFactory`: creare obiecte sursa.
  - `ReportPublisher`: gestionare observatori/notificari.
- **O - Open/Closed Principle**
  - Sursa noua: se adauga o clasa care implementeaza `MetricsSource`.
  - Strategie noua: se adauga o clasa care implementeaza `AnalysisStrategy`.
  - Observator nou: se adauga o clasa care implementeaza `ReportObserver`.
- **L - Liskov Substitution Principle**
  - `GitMetricsSource`, `JiraMetricsSource`, `SonarMetricsSource` pot fi folosite interschimbabil ca `MetricsSource`.
  - `RiskAnalysisStrategy` si `SumAnalysisStrategy` pot substitui `AnalysisStrategy`.
- **I - Interface Segregation Principle**
  - Interfete mici, specializate: `MetricsSource`, `AnalysisStrategy`, `ReportObserver`.
  - Clientii depind doar de metodele necesare.
- **D - Dependency Inversion Principle**
  - `MetricsAnalysisService` depinde de abstractii (`AnalysisStrategy`, `MetricsSource`) si nu de implementari concrete.
  - Dependintele sunt injectate prin constructor.


# Software-Metrics-Analyzer
