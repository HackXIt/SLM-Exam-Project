# Exam documentation

1. Projekt in IntelliJ erstellen

![image-20221221175432792](C:\Users\rini\OneDrive\FH Technikum - BIC\WS2022\SLM - Software-Lifecycle-Management\Exam\attachments\image-20221221175432792.png)

![image-20221221175646376](C:\Users\rini\AppData\Roaming\Typora\typora-user-images\image-20221221175646376.png)



·    [Java Spring Boot initializr](https://start.spring.io/)
 Maven
 package at.fhtechnikum.[rectangle](https://www.dict.cc/?s=square);
 Dependency **Spring Web**

![A screenshot of a computer  Description automatically generated with medium confidence](file:///C:/Users/rini/AppData/Local/Temp/msohtmlclip1/01/clip_image002.png)

·    .zip entpacken und mit IntelliJ öffnen

·    IntelliJ: VCS -> create git repository

·    IntelliJ: Git -> Github -> Share
 Privat

 

·    Controller erstellen
 Unter src -> main -> java -> package: Package „Controller“ erstellen und Klasse „RectangleController“
 @RestController
 

·    Kanban Board erstellen
 Github: Projects -> New Project -> Board

·    Todo in Kanban Board erstellen

·    Screenshot

·    Todo „In Process“ schieben

·    Screenshot

·    Issue generieren

·    Screenshot
 

·    Branch erstellen

·    Methode in Controller schreiben
 @GetMapping("/rec/{width}/{height}")
 public String calcRectangle(@PathVariable int width, @PathVariable String height){}

https://spring.io/guides/tutorials/rest/ 

·    Mit Aufruf in Browser testen: http://localhost:8080/rec/2/5 

·    Auf github pushen mit Verweis auf issue

·    Branch mergen (Zielbranch auswählen -> Checkout; IntelliJ: Git -> Merge und Quelle auswählen)

·    Issue schließen

·    Screenshot

 

·    Automatisierte Tests auf github
 Github: Actions -> „Java with Maven“ -> configure

 

![img](file:///C:/Users/rini/AppData/Local/Temp/msohtmlclip1/01/clip_image004.png)

·    Branch für Tests erstellen

 

·    Issue für Test erstellen

·    Test erstellen

 

import static org.junit.jupiter.api.Assertions.assertEquals;

 

// Given

RectangleController controller = new RectangleController();

 

// When

int result = controller.calcRectangle(5, 12);

 

// Then

assertEquals(result, 60);

 

·    User Stories erstellen

·    Readme in Github erstellen