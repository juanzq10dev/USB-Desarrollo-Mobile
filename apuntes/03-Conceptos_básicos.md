# Conceptos básicos
## Views
- Básicamente todo lo que vemos en la pantalla de una aplicación Android es un View. 
- Están ligados a un área rectangular. 
- Son responsables de saber dibujar y manejar eventos. 
- Ejemplos de Views: TextViews, ImageView, Button...

## View Groups  
- Son view que son contenedores de otros views.
- **Frame Layout**: Diseñados para tener un solo hijo. 
- **Linear Layout**: Poner views en línea recta u horizontal. 
- **Contraint Layout**: Agrupar vistas en una posición relativa a otra. 

## Resource ID's
- Cada resource tiene un "resource ID" para acceder a él. 
- La convención es escribir los ID's en snake_case. 
- Android Studio auto genera una clase llamada R.jaav con referencias a todos los recursos de la aplicación. 
- Las referencias se pueden referenciar como: `R.<tipo_de_recurso>`