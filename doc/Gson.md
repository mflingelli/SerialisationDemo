# Gson

Standardmäßig müssen keine Annoationen gesetzt werden. Folgende Annotationen stehen zur Verfügung.

## @Expose

Dies ist in Situationen nützlich, in denen Sie steuern möchten, ob bestimmte Felder für die Serialisierung/Deserialisierung
berücksichtigt werden sollen. Diese Annotation wird auf Feldebene angewendet und ist nur wirksam, wenn Gson
mit GsonBuilder erstellt wird und ```excludeFieldsWithoutExposeAnnotation``` wie unten aufgerufen wird:
```
Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
```

```
public class Car {

    @Expose
    private String mark;
     
    @Expose(serialize = false) 
    private int model;
     
    @Expose(serialize = false, deserialize = false) 
    private String type;
}
```

## @SerializedName
Diese Annotation ist in Situationen nützlich, in denen Sie ein Feld mit einem anderen Namen als dem tatsächlichen 
Feldnamen serialisieren möchten. Geben Sie einfach den erwarteten serialisierten Namen als Annotationsattribut an, 
und Gson stellt sicher, dass das Feld mit dem angegebenen Namen gelesen/geschrieben wird.

```
public class Car2 {
    @SerializedName("Crafted-By") 
    private String maker;
}
```

## @Since, @ Until
Diese beiden Annotationen sind praktisch, wenn Sie die Versionierung Ihrer JSON-Klassen verwalten möchten. 
Sie können steuern, ob ein bestimmtes Feld basierend auf einer bestimmten Version für die Serialisierung/Deserialisierung 
berücksichtigt wird.
* Die Annotation ```@Since``` gibt die Versionsnummer an, seit ein Mitglied oder ein Typ vorhanden ist. Dies bedeutet, dass dieses Feld nur für die Serialisierung/Deserialisierung ab einer bestimmten Version berücksichtigt wird. Vor dieser Version wird es ignoriert.
* Die Annotation ```@Until``` gibt die Versionsnummer an, bis ein Mitglied oder ein Typ vorhanden sein sollte. Dies bedeutet, dass dieses Feld nur für die Serialisierung/Deserialisierung bis zu einer bestimmten Version berücksichtigt wird. Nach dieser Version wird es ignoriert.

Diese Annotationen werden auf Feldebene angewendet und sind nur wirksam, wenn Gson mit GsonBuilder erstellt und 
die Methode ```GsonBuilder.setVersion(double)``` wie unten aufgerufen wird:
```
Gson gson = new GsonBuilder().setVersion(double).create();
```

```
public class Car3 {
 
    @Since(2.0)
    private String mark;
     
    @Since(2.1) 
    private int model;
 
    @Until(1.9) 
    private String type;
     
    @Until(2.1)
    private String maker;
 }
```

## @JsonAdapter
Diese Annotation kann auf Feld- oder Klassenebene verwendet werden, um den Gson ```TypeAdapter``` anzugeben, der 
beim Serialisieren/Deserialisieren verwendet werden soll. Standardmäßig konvertiert Gson Anwendungsklassen mithilfe 
seiner integrierten Typadapter in JSON. Sie können dieses Verhalten jedoch überschreiben, indem Sie benutzerdefinierte 
Typadapter bereitstellen.

## Literatur
Weitere Informationen zu Gson können hier nachgelesen werden: [http://websystique.com/java/json/gson-json-annotations-example/](http://websystique.com/java/json/gson-json-annotations-example/)
