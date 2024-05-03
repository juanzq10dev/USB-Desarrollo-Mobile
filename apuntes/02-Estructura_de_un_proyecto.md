# Estructura de un proyecto Android

Las carpetas de un proyecto de Android son: 

```
MyApp 
| app
   | lib 
   | src
      | androidTest
      | main 
        | java
        | res
            | drawable
            | layout
            | mipmap
            | values 
        | AndroidManifest.xml
      | test
| build.gradle
| gradlew
       
```

Las carpetas dentro de `res` son para: 
- `drawable`: vectores e imágenes de la app. 
- `layout`: tiene una vista de las ventanas en formato .xml. La vista se puede realizar con el diseñador, pero lo más común es realizarlo por código. 
- `mipmap`: Íconos de la aplicación. 
- `values`: Valores de Strings. 
