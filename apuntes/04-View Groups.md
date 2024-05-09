# View Groups

## LinearLayout
- Se utilizan para agrupar elementos en filas o en vertical
- Los componentes en Linear Layout tienen una propiedad `weight` para redimensionarlos.
    ```xml
    <LinearLayout
        ...
        android:direction="vertical"
        ...
    >
        <View  
            android:layout_width="wrap_content"
            android:layout_height="0dp"
            android:weight=1
            android:color="@android/black"
        />
        <View  
            android:layout_width="wrap_content"
            android:layout_height="0dp"
            android:weight=2
            android:color="@android/white"
        />
        <View  
            android:layout_width="wrap_content"
            android:layout_height="0dp"
            android:weight=1
            android:color="@android/black"
        />
    </LinearLayout>
    ```

## RelativeLayout
- Ya no es tan utilizado debido al uso de ContraintLayout. 
- Define su tmaaño y posición en base a otros elementos () 

## ConstraintLayout
- Permite definir el layout en base a `constraints` (límites/anclas) definidos.

## Referenciar a un View en Kotlin. 
- Hasta ahora tenemos archivos `.xml` estáticas. 
- Se referencian dentro de Kotlin de está manera:
    1. Asignar un id a nuestro view en el archivo `.xml`
    2. En el archivo Kotlin lo siguiente
```Kotlin
class MainActivity : AppCompatActivity() {
    lateinit var myTextView : TextView
    override fun onCreate() {
        ...
        myTextView = findViewById(R.id.textView) 
    }
}
```