# Jaxb

Java Architecture for XML Binding (JAXB) ist eine API zum Übertragen von Objektzuständen auf XML-Dokumente und umgekehrt.

Mit Java 11 ist u.a. das Modul ```javax.xml.bind``` (JAXB) endgültig entfallen und muss als zusätzliche Abhängigkeit
eingebunden werden.

## Annotationen

### Zugriff über Getter/Setter-Methoden

| Wert                                                | Datenaustausch über                                                |
|-----------------------------------------------------|--------------------------------------------------------------------|
| ```@XmlAccessorType(XmlAccessType.FIELD)```         | jedes nichtstatische Attribut                                      |
| ```@XmlAccessorType(XmlAccessType.PROPERTY)```      | jede JavaBean-Property                                             |
| ```@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)``` | jede öffentliche JavaBean-Property oder jedes öffentliche Attribut |

Die Standardbelegung ist ```AccessType.PUBLIC_MEMBER```.

### @Transient

Die Annotation ```@Transient``` nimmt ein Element von der XML-Abbildung aus:
```
class Person {
 @XmlTransient public int id;
 public String firstname;
 public String lastname;
}
```

### Werte als Attribute schreiben mit @XmlAttribute
Üblicherweise schreibt JAXB jeden Wert in ein eigenes XML-Element. Soll der Wert als Attribut geschrieben werden, 
kommt die Annotation ```@XmlAttribute``` zum Einsatz.
```
class Person {
public String name;
public @XmlAttribute int id;
}
```

### Reihenfolge der Elemente ändern
Ist die Reihenfolge der XML-Elemente wichtig, so lässt sich mit dem propOrder von ```@XmlType``` die Reihenfolge
der Eigenschaften bestimmen:
```
@XmlType(propOrder = { "firstname", "lastname" })
class Person {
 public String lastname, firstname;
}
```

### Einzelner Wert ohne eigenes XML-Element
Gibt es nur ein Element in der Klasse, so kann ```@XmlValue``` es direkt ohne Unterelement in den Rumpf setzen:
```
class Person {
public @XmlValue int id;
}
```

### Kompakte Listendarstellung

Die Datenstruktur Liste wird in JAXB üblicherweise so abgebildet, dass jedes Listenelement einzeln in ein XML-Element kommt. 
Die Annotation ```@XmlList``` weist JAXB an, Elemente einer Sammlung mit Leerzeichen zu trennen. Das funktioniert gut bei IDs, 
aber natürlich nicht mit allgemeinen Zeichenketten, die Leerzeichen enthalten.
```
class Person {
public @XmlList List<String> emails;
}
```

### Elemente zusätzlich einpacken

Die Annotation ```@XmlElementWrapper``` dient dazu, ein zusätzliches XML-Element zu erzeugen. 
In der Regel wird das für Sammlungen angewendet. 
```
class Person {
@XmlElementWrapper(name = "emails")
@XmlElement(name = "email")
public List<String> emails;
}
```

## Literatur

Weitere Informationen zu JAXB und XMl können beispielsweise in der Online-Ausgabe des Buches **Java SE 8 Standard-Bibliothek**
von *Christian Ullenboom* nachgelesen werden: [Kapitel 8: Die eXtensible Markup Language (XML)](https://openbook.rheinwerk-verlag.de/java8/08_001.html#u8)
